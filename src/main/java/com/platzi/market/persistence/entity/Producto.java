package com.platzi.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="productos")
public class Producto {

    //ATRIBUTES

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    private String nombre;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    //MAPEANDO UNA RELACION ENTRE PRODUCTOS Y CATEGORIAS (MUCHOS PRODUCTOS ESTAN PRESENTES EN 1 CATEGORIA)
    /*
    Para mapear una relacion se hace uso de la anotacion @ManyToOne para especificar que muchos productos estan
    en 1 categoria, en la entidad categoria la anotacion sera la opuesta @OneToMany. Adicionalmente se anota con
    @JoinColumn y en esta se especifica 3 parametros:
    1. "name" se indica el campo en la BD con el que la entidad producto se encuentra relacionado, en este caso
    se relaciona con el campo "id_categoria" de la tabla categoria.
    2. insertable y updatable = false indica que no se podra elimnar, crear o modificar una categoria, solo desde su entidad
    correspondiente llamada categoria.
     */

    //Esta relacion solo sirve para recuperar a que categoria pertenece un producto
    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Categoria categoria;

    //MAPEANDO LA RELACION ENTRE PRODUCTOS Y COMPRAPRODUCTOS
    @OneToMany(mappedBy = "producto")
    private List<ComprasProducto> compras;

    // GETTERS AND SETTERS


    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<ComprasProducto> getCompras() {
        return compras;
    }

    public void setCompras(List<ComprasProducto> compras) {
        this.compras = compras;
    }
}
