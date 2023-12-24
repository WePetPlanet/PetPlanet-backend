FROM openjdk:11-jre-slim

RUN mkdir -p /app/pet/pet
WORKDIR /app/pet/pet
COPY --from=petplanet-parent /app/pet/petplanet-pet/target/*.jar ./pet.jar

EXPOSE 8881

CMD ["java", "-jar", "./pet.jar"]