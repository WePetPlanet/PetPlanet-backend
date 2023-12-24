# 运行阶段：使用 OpenJDK 镜像作为最终镜像
FROM openjdk:11-jre-slim

RUN mkdir -p /app/pet/post
WORKDIR /app/pet/post
COPY --from=petplanet-parent /app/pet/petplanet-post/target/*.jar ./post.jar

EXPOSE 8882

CMD ["java", "-jar", "./post.jar"]
