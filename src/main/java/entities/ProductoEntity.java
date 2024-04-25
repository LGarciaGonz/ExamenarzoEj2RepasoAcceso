package entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "producto", schema = "jardineria", catalog = "")
public class ProductoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "codigo_producto", nullable = false, length = 15)
    private String codigoProducto;
    @Basic
    @Column(name = "nombre", nullable = false, length = 70)
    private String nombre;
    @Basic
    @Column(name = "id_gama", nullable = false)
    private int idGama;
    @Basic
    @Column(name = "precio_venta", nullable = false, precision = 2)
    private float precioVenta;
    @ManyToOne
    @JoinColumn(name = "id_gama", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private GamaProductoEntity gamaProductoByIdGama;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdGama() {
        return idGama;
    }

    public void setIdGama(int idGama) {
        this.idGama = idGama;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoEntity that = (ProductoEntity) o;
        return id == that.id && idGama == that.idGama && Float.compare(precioVenta, that.precioVenta) == 0 && Objects.equals(codigoProducto, that.codigoProducto) && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoProducto, nombre, idGama, precioVenta);
    }

    public GamaProductoEntity getGamaProductoByIdGama() {
        return gamaProductoByIdGama;
    }

    public void setGamaProductoByIdGama(GamaProductoEntity gamaProductoByIdGama) {
        this.gamaProductoByIdGama = gamaProductoByIdGama;
    }
}
