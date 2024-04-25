package entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "pedido", schema = "jardineria", catalog = "")
public class PedidoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "codigo_pedido", nullable = false)
    private int codigoPedido;
    @Basic
    @Column(name = "fecha_pedido", nullable = false)
    private Date fechaPedido;
    @Basic
    @Column(name = "codigo_cliente", nullable = false)
    private int codigoCliente;
    @ManyToOne
    @JoinColumn(name = "codigo_cliente", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private ClienteEntity clienteByCodigoCliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoEntity that = (PedidoEntity) o;
        return id == that.id && codigoPedido == that.codigoPedido && codigoCliente == that.codigoCliente && Objects.equals(fechaPedido, that.fechaPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoPedido, fechaPedido, codigoCliente);
    }

    public ClienteEntity getClienteByCodigoCliente() {
        return clienteByCodigoCliente;
    }

    public void setClienteByCodigoCliente(ClienteEntity clienteByCodigoCliente) {
        this.clienteByCodigoCliente = clienteByCodigoCliente;
    }
}
