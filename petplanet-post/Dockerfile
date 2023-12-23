# 设置镜像的元数据信息
LABEL maintainer = "ZYNORl/niuzy <3445669973@qq.com>"
LABEL description = "This is a post module image."

# 构建阶段：使用 Maven 镜像进行构建
FROM maven:3.8.3-openjdk-11 AS build

# 创建工作目录
RUN mkdir -p /app/post
WORKDIR /app/post
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src/ ./src/
RUN mvn package -DskipTests -DfinalName=petplanet-post

# 运行阶段：使用 OpenJDK 镜像作为最终镜像
FROM openjdk:11-jre-slim

WORKDIR /app/post
COPY --from=build /app/post/target/petplanet-post.jar ./post.jar

EXPOSE 8882

CMD ["java", "-jar", "./post.jar"]
