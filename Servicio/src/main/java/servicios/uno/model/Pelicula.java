package servicios.uno.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "peliculas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pelicula{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pelicula;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String director;

    @Column(nullable = false)
    long duracion;

    @Column(nullable = true , name = "creada_en" ,columnDefinition = "DATE")
    String creadaEn;

    @ManyToOne
    @JoinColumn(name = "fk_genero")
    private Genero genero;

}
