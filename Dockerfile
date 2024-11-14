# Usar una imagen base de OpenJDK 17
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo en la imagen
WORKDIR /app

# Copiar el archivo pom.xml y el código fuente del proyecto
COPY pom.xml /app
COPY src /app/src

# Compilar el proyecto
RUN ./mvnw package -DskipTests

# Exponer el puerto en el que se ejecuta la aplicación
EXPOSE 8080

# Ejecutar la aplicación Spring Boot
CMD ["java", "-jar", "target/catapi-0.0.1-SNAPSHOT.jar"]