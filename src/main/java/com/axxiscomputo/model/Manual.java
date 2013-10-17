package com.axxiscomputo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: paco
 * Date: 16/10/13
 * Time: 11:33 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table (name = "manuales")
public class Manual {

    private Long id;
    private String hola;
}
