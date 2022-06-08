FROM amazoncorretto:11-alpine
COPY /build/libs/AlfaBankTestTask-0.0.1-SNAPSHOT.jar /RandomGifService-0.0.1.jar
ENTRYPOINT ["java", "-jar", "RandomGifService-0.0.1.jar"]