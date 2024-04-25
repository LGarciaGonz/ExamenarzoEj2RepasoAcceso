package entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "cliente", schema = "jardineria", catalog = "")
public class ClienteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "codigo", nullable = false)
    private int codigo;
    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic
    @Column(name = "apellido", nullable = true, length = 30)
    private String apellido;
    @Basic
    @Column(name = "telefono", nullable = false, length = 15)
    private String telefono;
    @OneToMany(mappedBy = "clienteByCodigoCliente")
    private Collection<PedidoEntity> pedidosById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteEntity that = (ClienteEntity) o;
        return id == that.id && codigo == that.codigo && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(telefono, that.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, nombre, apellido, telefono);
    }

    public Collection<PedidoEntity> getPedidosById() {
        return pedidosById;
    }

    public void setPedidosById(Collection<PedidoEntity> pedidosById) {
        this.pedidosById = pedidosById;
    }
}
