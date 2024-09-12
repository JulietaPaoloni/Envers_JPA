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
@Table(name="factura")
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "total")
    private int total;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();

    @OneToMany(mappedBy = "factura" ,  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();

    public Factura(String fecha, int total) {
        this.fecha = fecha;
        this.total = total;
    }

}
