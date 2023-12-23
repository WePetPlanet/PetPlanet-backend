# 构建阶段：使用 Maven 镜像进行构建
FROM maven:3.8.3-openjdk-11 AS build

# 创建工作目录
RUN mkdir -p /app/parent
WORKDIR /app/parent
COPY pom.xml .
RUN mvn dependency:go-offline -B
RUN mvn package -DskipTests -DfinalName=petplanet-common:jar:0.0.1-SNAPSHOT

# 新建一个空镜像
FROM scratch

# 将构建好的 common.jar 复制到空镜像中
COPY --from=build /app/common/target/petplanet-common:jar:0.0.1-SNAPSHOT.jar ./petplanet-common:jar:0.0.1-SNAPSHOT.jar

# 定义容器启动时执行的默认命令
CMD ["echo", "common.jar is built"]
