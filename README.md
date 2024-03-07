# Script inicial
INSERT INTO `peliculas`.`generos` (`nombre`) VALUES ('Terror');
INSERT INTO `peliculas`.`generos` (`nombre`) VALUES ('Suspenso');
INSERT INTO `peliculas`.`generos` (`nombre`) VALUES ('Ficción');
INSERT INTO `peliculas`.`generos` (`nombre`) VALUES ('Documental');
INSERT INTO `peliculas`.`generos` (`nombre`) VALUES ('Drama');
INSERT INTO `peliculas`.`generos` (`nombre`) VALUES ('Comedia');
INSERT INTO `peliculas`.`generos` (`nombre`) VALUES ('Romance');


## Cuestiones importantes para la implementacion

## MultiReadHttpServletRequest.java
Funciona como una instancia de request, es decir copia cada una de las request que son recibidas por el servidor

## MultiReadHttpServletResponse.java
Funciona como una instancia de response, es decir copia cada una de las response que son recibidas por el servidor

## BitacoraFilter
Implementa las dos clases anteriores con un filtro por peticion el cual copia el contenido del body y de la response en json y algunos datos importantes mas como la ip
para guardarlo en la base de datos, es decir cada peticion esta siendo interceptada para y almacenada.

## Dependencia para poder guardar JSON en models

<dependency>
            <groupId>io.hypersistence</groupId>
            <artifactId>hypersistence-utils-hibernate-60</artifactId>
            <version>3.7.3</version>
        </dependency>

## Asi se declara una columna json en la base de datos 

@Column(columnDefinition = "json")
    @Type(JsonType.class)
    private JsonNode data;

