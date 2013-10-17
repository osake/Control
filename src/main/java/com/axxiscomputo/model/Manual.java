package com.axxiscomputo.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: paco
 * Date: 16/10/13
 * Time: 11:33 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table (name = "manuales")
public class Manual implements Serializable{

    private Long id;
    private String idioma;
    private String tags;
    private String titulo;
    private String ubicacion;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(length = 30)
    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Column(length = 150)
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Column(length = 100, unique = true, nullable = false)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Column(length = 80,nullable = false)
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
