# 构建阶段：使用 Maven 镜像进行构建
FROM maven:3.8.3-openjdk-11

# 创建工作目录
RUN mkdir -p /app/pet
WORKDIR /app/pet
COPY ./* ./
RUN mvn dependency:go-offline -B
RUN mvn package -DskipTests
