package code;

import entities.GamaProductoEntity;
import entities.ProductoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import libs.Leer;

import java.util.List;

public class InsProducto {
    static EntityManager em = EmfSingleton.getInstance().getEmf().createEntityManager();
    public static void crearProducto() {

        // VARIABLES -------------
        String nombre;
        String gama;
        float precioVenta;

        System.out.println("\n*****[ CREAR NUEVO PRODUCTO ]*****");

        nombre = Leer.pedirCadena("> Introduzca nombre del producto: ");
        gama = Leer.pedirCadena("> Introduzca gama: ");
        precioVenta = Leer.pedirFloat("> Introduzca precio de venta: ");

        try {
            EntityTransaction em2Transaction = em.getTransaction();
            em2Transaction.begin();

            Query obtenerID = em.createQuery("from ProductoEntity where nombre = ?1");
            obtenerID.setParameter(1, nombre);
            List<ProductoEntity> productos = obtenerID.setMaxResults(1).getResultList();

            if (productos.isEmpty()) { // Si no se encuentra ningún producto con ese nombre.
                ProductoEntity nuevoProd = new ProductoEntity();

                nuevoProd.setNombre(nombre);

                Query obtenerGama = em.createQuery("from GamaProductoEntity where gama = ?1");
                obtenerGama.setParameter(1, gama);
                List<GamaProductoEntity> gamas = obtenerGama.setMaxResults(1).getResultList();

                if (gamas.isEmpty()) { // Si no se encuentra ninguna gama con ese nombre.
                    String descripcion = Leer.pedirCadena("\n>>> La gama no existe. Introduzca una descripción para crearla:");

                    GamaProductoEntity nuevaGama = new GamaProductoEntity();

                    nuevaGama.setGama(gama);
                    nuevaGama.setDescripcionTexto(descripcion);

                    em.persist(nuevaGama);
                    nuevoProd.setIdGama(nuevaGama.getId());

                    System.out.println("\n>>> *****{ GAMA CREADA CORRECTAMENTE }*****\n");
                } else {
                    nuevoProd.setIdGama(gamas.get(0).getId());
                }

                // Dar valor a los campos restantes.
                nuevoProd.setCodigoProducto(nuevoProd.getNombre());
                nuevoProd.setPrecioVenta(precioVenta);

                em.persist(nuevoProd);
                System.out.println("\n>>> *****{ PRODUCTO CREADO CORRECTAMENTE }*****\n");
            } else {
                System.err.println("\n>>> ERROR: Ya existe un producto con ese nombre.");
            }

            em2Transaction.commit();

        } catch (Exception e) {
            System.err.println("\n>>>ERROR: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
