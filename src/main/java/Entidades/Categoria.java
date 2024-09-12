package Entidades;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Audited
@Table(name="categoria")
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "denominacion")
    private String denominacion;

    @ManyToMany(mappedBy = "categorias")
    private List<Articulo> articulos = new ArrayList<>();

    // Constructor que acepta solo el nombre (denominacion)
    public Categoria(String denominacion) {
        this.denominacion = denominacion;
        this.articulos = new ArrayList<>();
    }
}
