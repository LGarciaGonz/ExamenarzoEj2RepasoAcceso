package entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "gama_producto", schema = "jardineria", catalog = "")
public class GamaProductoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "gama", nullable = false, length = 50)
    private String gama;
    @Basic
    @Column(name = "descripcion_texto", nullable = true, length = -1)
    private String descripcionTexto;
    @OneToMany(mappedBy = "gamaProductoByIdGama")
    private Collection<ProductoEntity> productosById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public String getDescripcionTexto() {
        return descripcionTexto;
    }

    public void setDescripcionTexto(String descripcionTexto) {
        this.descripcionTexto = descripcionTexto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GamaProductoEntity that = (GamaProductoEntity) o;
        return id == that.id && Objects.equals(gama, that.gama) && Objects.equals(descripcionTexto, that.descripcionTexto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gama, descripcionTexto);
    }

    public Collection<ProductoEntity> getProductosById() {
        return productosById;
    }

    public void setProductosById(Collection<ProductoEntity> productosById) {
        this.productosById = productosById;
    }
}
