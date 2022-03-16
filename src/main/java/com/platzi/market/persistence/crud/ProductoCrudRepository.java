package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {


    /*
                                            QUERY METHODS
        Proveen la posibilidad de generar consultas mediante la definicion de metodos, respetando una sintaxis
        en particular en este sentido son consultas adicionales que se necesitan para un caso en particular
        que crudRepository no nos provee.
     */


   /* --------------------------------------------------------------------------------------------------------
                                        EJEMPLO DE UNA QUERY NATIVA
       Este es un ejemplo de como hacer una consulta o Query nativa, notese que el nombre del metodo ya puede
       ser llamado de cualquier manera sin respetar la sintaxis en particular de los Query Methods

       @Query(value= "SELECT *  FROM productos WHERE idcategoria = ?", nativeQuery = true)
       List<Producto> buscarTodos(int idCategoria);

       ---------------------------------------------------------------------------------------------------------
    */

    /*------------------------------------------------------------------------------------------------------------
                                        DECLARACION DE UN QUERY METHOD
       Este metodo regresa una list de productos que pertenecen a una categoria en especifico
       Su parametro de busqueda es el id de la categoria.

       En estas definiciones se debe tener especial cuidado en que la sintaxis del Query Method debe respetar
       el camel case, sin embargo en la definicion del parametro del metodo se debe escribir el identificador
       del parametro como aparece en el campo de la entidad que lo contiene, en este caso la entidad PRODUCTO
       contiente este atributo identificandolo como "idCategoria"

       Este Query Method va a ser llamado en la clase ProductoRepository dentro de un metodo llamado getByCategoria
        que retorna el resultado de la invocacion a este Query method.


     */

    List<Producto> findByIdCategoriaOrderByNombreASC(int idCategoria);

    //Este Query Method hace una consulta a la BD y regresa un producto que coincida con el id y el nombre
    Producto findByIdProductoAndNombre(int idProducto, String nombre);

    //Este Query Method trae un listado de los productos en los que  su cantidad de stock es menor al nivel ingresado
    // y que pertenecen a una categoria en dada.
    List<Producto> findByIdCategoriaAndCantidadStockLessThan(int idCategoria, int cantidadStock);

    //Este Query Method regresa una lista de productos que pertenecen a una categoria dada y su valor de venta es igual
    //o mayor al parametro dado.

    List<Producto> findByIdCategoriaAndPrecioVentaGreaterThanEqual(int idCategoria, double precioVenta);



    //---------------------------------------------------------------------------------------------------------------

    Optional< List<Producto> > findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

}
