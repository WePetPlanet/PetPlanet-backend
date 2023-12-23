# 构建阶段：使用 Maven 镜像进行构建
FROM common-maven-image AS build

# 创建工作目录
RUN mkdir -p /app/api
WORKDIR /app/api
COPY pom.xml .
COPY src/ ./src/
RUN mvn dependency:go-offline -B
RUN mvn package -DskipTests -DfinalName=petplanet-api

# 运行阶段：使用 OpenJDK 镜像作为最终镜像
FROM openjdk:11-jre-slim

WORKDIR /app/api
COPY --from=build /app/api/target/petplanet-api.jar ./api.jar

EXPOSE 8885

CMD ["java", "-jar", "./api.jar"]