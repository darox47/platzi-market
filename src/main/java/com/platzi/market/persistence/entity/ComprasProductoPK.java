package com.platzi.market.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/*
esta clase no se anota con  @Entity porque no va a mapear ninguna tabla de nuestra BBBDD, se anota
con la anotacion @Embeddable para enbeberla en la clase ComprasProducto y se debe implementar la iterfaz de java
Serializable.
 */


@Embeddable
public class ComprasProductoPK implements Serializable {

    //ATRIBUTES
    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_producto")
    private Integer idProducto;

    //SETTERS AND GETTERS


    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
