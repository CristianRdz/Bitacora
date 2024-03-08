# Bitácora de cambios

Este proyecto implementa una bitácora para registrar todas las peticiones HTTP que son recibidas por el servidor.

## Componentes principales

### MultiReadHttpServletRequest.java

Esta clase extiende `HttpServletRequestWrapper` y se utiliza para copiar y almacenar el contenido de cada petición HTTP que es recibida por el servidor. Esto permite que el cuerpo de la petición pueda ser leído múltiples veces.

### MultiReadHttpServletResponse.java

Esta clase extiende `HttpServletResponseWrapper` y se utiliza para copiar y almacenar el contenido de cada respuesta HTTP que es enviada por el servidor. Esto permite que el cuerpo de la respuesta pueda ser leído múltiples veces.

### BitacoraFilter.java

Este filtro intercepta cada petición HTTP, copia el contenido del cuerpo de la petición y de la respuesta, y almacena esta información en la base de datos. Además, registra datos adicionales como la dirección IP del cliente.

## Dependencias

Para poder almacenar objetos JSON en los modelos de la base de datos, este proyecto utiliza la dependencia `hypersistence-utils-hibernate-60`. Para agregar esta dependencia a tu proyecto, incluye el siguiente código en tu archivo `pom.xml`:

```xml
<dependency>
    <groupId>io.hypersistence</groupId>
    <artifactId>hypersistence-utils-hibernate-60</artifactId>
    <version>3.7.3</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
</dependency>
```

La dependencia `jackson-databind` se utiliza para convertir objetos Java a JSON y viceversa. Esta biblioteca proporciona funcionalidad para leer y escribir JSON, ya sea a y desde modelos de datos básicos (como Mapas, Listas, Strings, Integers, etc.), o a y desde objetos Java de tipo POJO (Plain Old Java Object).

## Uso de columnas JSON en la base de datos

Para declarar una columna JSON en la base de datos, se utiliza la anotación `@Column` con la definición de columna "json", y se especifica el tipo de la columna como `JsonType`. Aquí tienes un ejemplo:

```java
@Column(columnDefinition = "json")
@Type(JsonType.class)
private JsonNode data;
```

## Configuración y ejecución

### Cliente

Entrar a la carpeta, abrir la consola de comandos y correr los siguientes comandos:

```bash
npm i
npm run dev
```

### Servidor

Abrir el proyecto, preferentemente en IntelliJ de Jetbrains y ejecutarlo, tener en cuenta que utiliza Java 17 en adelante
