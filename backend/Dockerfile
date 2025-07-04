# Usá una imagen oficial de Java
FROM eclipse-temurin:17-jdk-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiás el jar generado al contenedor
COPY target/tu-app.jar app.jar

# Exponé el puerto (opcional, Render lo gestiona igual)
EXPOSE 8080

# Comando de inicio
ENTRYPOINT ["java", "-jar", "app.jar"]
