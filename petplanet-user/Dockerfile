# 运行阶段：使用 OpenJDK 镜像作为最终镜像
FROM openjdk:11-jre-slim

RUN mkdir -p /app/pet/user
WORKDIR /app/pet/user
COPY --from=petplanet-parent /app/pet/petplanet-user/target/*.jar ./user.jar

EXPOSE 8883

CMD ["java", "-jar", "./user.jar"]
