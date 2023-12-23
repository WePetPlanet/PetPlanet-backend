# 设置镜像的元数据信息
LABEL maintainer="ZYNORl/niuzy <3445669973@qq.com>"
LABEL description="This is a user module image."

# 构建阶段：使用 Maven 镜像进行构建
FROM maven:3.8.3-openjdk-11 AS build

# 创建工作目录
RUN mkdir -p /app/user
WORKDIR /app/user
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src/ ./src/
RUN mvn package -DskipTests -DfinalName=petplanet-user

# 运行阶段：使用 OpenJDK 镜像作为最终镜像
FROM openjdk:11-jre-slim

WORKDIR /app/user
COPY --from=build /app/user/target/petplanet-user.jar ./user.jar

EXPOSE 8883

CMD ["java", "-jar", "./user.jar"]


## 基础镜像
#FROM openjdk:11-jdk-slim
#
## 设置镜像的元数据信息
#LABEL maintainer = "ZYNORl/niuzy <3445669973@qq.com>"
#LABEL description = "This is a user module image."
#
## 设置工作目录
#ENV PETPLANET_USER_HOME /app/pet/user
#ENV PATH $PETPLANET_USER_HOME/bin:$PATH
#RUN mkdir -p "$PETPLANET_USER_HOME"
#WORKDIR $PETPLANET_USER_HOME
#
## 将构建好的jar包复制到容器中
#COPY target/petplanet-user-0.0.1-SNAPSHOT.jar .
#
##
#EXPOSE 8883
#
## 设置启动命令
#CMD ["java", "-jar", "petplanet-user-0.0.1-SNAPSHOT.jar"]
