## 设置镜像的元数据信息
#LABEL maintainer = "ZYNORl/niuzy <3445669973@qq.com>"
#LABEL description = "This is a user module image."

# 构建阶段：使用 Maven 镜像进行构建
FROM maven:3.8.3-openjdk-11 AS build

# 创建工作目录
RUN mkdir -p /app/pet
WORKDIR /app/pet
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src/ ./src/
RUN mvn package -DskipTests -DfinalName=petplanet-pet

# 运行阶段：使用 OpenJDK 镜像作为最终镜像
FROM openjdk:11-jre-slim

WORKDIR /app/pet
COPY --from=build /app/pet/target/petplanet-pet.jar ./pet.jar

EXPOSE 8881

CMD ["java", "-jar", "./pet.jar"]