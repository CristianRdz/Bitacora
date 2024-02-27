package servicios.uno.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import servicios.uno.model.Genero;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QueryDto {
    //director, fechaInicio, fechaFin, genero
    private String director;
    private String fechaInicio;
    private String fechaFin;
    private Genero genero;
}
