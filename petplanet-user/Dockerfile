# 构建阶段：使用 Maven 镜像进行构建
FROM common-maven-image AS build

# 创建工作目录
RUN mkdir -p /app/user
WORKDIR /app/user
COPY pom.xml .
COPY src/ ./src/
RUN mvn dependency:go-offline -B
RUN mvn package -DskipTests -DfinalName=petplanet-user

# 运行阶段：使用 OpenJDK 镜像作为最终镜像
FROM openjdk:11-jre-slim

WORKDIR /app/user
COPY --from=build /app/user/target/petplanet-user.jar ./user.jar

EXPOSE 8883

CMD ["java", "-jar", "./user.jar"]
