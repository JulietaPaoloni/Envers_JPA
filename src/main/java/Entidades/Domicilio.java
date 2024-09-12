package Entidades;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Audited
@Table(name="domicilio")
public class Domicilio implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_calle")
    private String nombreCalle;

    @Column(name = "numero")
    private int numero;

    @OneToOne(mappedBy ="domicilio")
    private Cliente cliente;

    public Domicilio(Long id, String nombreCalle, int numero) {
        this.id = id;
        this.nombreCalle = nombreCalle;
        this.numero = numero;
    }

}
