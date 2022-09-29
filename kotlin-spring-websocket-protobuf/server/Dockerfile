FROM adoptopenjdk:11 As builder
COPY gradlew /
COPY gradle gradle
COPY build.gradle.kts /
COPY settings.gradle.kts /
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew bootJar --no-daemon

FROM gcr.io/distroless/java11-debian11
COPY --from=builder build/libs/*.jar app.jar
EXPOSE 3001
CMD ["app.jar"]