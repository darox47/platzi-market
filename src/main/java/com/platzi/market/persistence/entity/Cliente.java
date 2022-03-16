package com.platzi.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    //ATRIBUTES

    @Id
    private  String id;

    private String nombre;

    private String apellidos;

    private Double celular;

    private String direccion;

    @Column(name = "correo_electronico")
    private String correroElectronico;

    //MAPEANDO LA RELACION DE CLIENTE CON COMPRA (1 cliente hace muchas compras)
    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;

    //GETTERS AND SETTERS

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Double getCelular() {
        return celular;
    }

    public void setCelular(Double celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreroElectronico() {
        return correroElectronico;
    }

    public void setCorreroElectronico(String correroElectronico) {
        this.correroElectronico = correroElectronico;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
}
