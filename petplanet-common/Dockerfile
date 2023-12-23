# 构建阶段：使用 Maven 镜像进行构建
FROM maven:3.8.3-openjdk-11

# 创建工作目录
RUN mkdir -p /app/common
WORKDIR /app/common
COPY pom.xml .
COPY src/ ./src/

# jar打包
RUN mvn dependency:go-offline -B
RUN mvn package -DskipTests -DfinalName=petplanet-common.jar

# 安装 JAR 文件到 Maven 仓库
RUN mvn install:install-file \
    -Dfile=petplanet-common.jar \
    -DgroupId=top.zynorl.petplanet \
    -DartifactId=petplanet \
    -Dversion=0.0.1-SNAPSHOT \
    -Dpackaging=jar

# 定义容器启动时执行的默认命令
CMD ["echo", "petplanet-common-0.0.1-SNAPSHOT.jar is install for maven"]
