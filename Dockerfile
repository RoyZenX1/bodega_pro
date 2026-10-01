# ----- ETAPA 1: Compilación (Build) -----
FROM maven:3.9-eclipse-temurin-25-alpine AS build
WORKDIR /app

# Copiar el pom.xml y descargar dependencias para aprovechar la caché de Docker
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el código fuente y compilar omitiendo pruebas
COPY src ./src
RUN mvn clean package -DskipTests

# ----- ETAPA 2: Ejecución (Runtime) -----
FROM eclipse-temurin:25-jre-alpine
WORKDIR /app

# Copiar el ejecutable .jar generado en la etapa de compilación
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto de Spring Boot
EXPOSE 8080

# Variable de entorno para asignar el puerto que Render requiere
ENV PORT=8080

# Comando para ejecutar la app pasando dinámicamente el puerto
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT}"]
