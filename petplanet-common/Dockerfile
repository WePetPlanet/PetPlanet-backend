# 构建阶段：使用 Maven 镜像进行构建
FROM maven:3.8.3-openjdk-11 AS build

# 创建工作目录
RUN mkdir -p /app/common
WORKDIR /app/common
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src/ ./src/
RUN mvn package -DskipTests -DfinalName=petplanet-common:jar:0.0.1-SNAPSHOT

COPY --from=build /app/common/target/petplanet-common:jar:0.0.1-SNAPSHOT.jar ./petplanet-common:jar:0.0.1-SNAPSHOT.jar