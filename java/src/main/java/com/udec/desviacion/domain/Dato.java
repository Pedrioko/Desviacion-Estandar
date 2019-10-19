/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.desviacion.domain;

/**
 *
 * @author PedroD
 */
public class Dato {

    private long id;

    private double valor;

    public Dato() {
    }

    public Dato(long id, double valor) {
        this.id = id;
        this.valor = valor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Dato{" + "id=" + id + ", valor=" + valor + '}';
    }

}
