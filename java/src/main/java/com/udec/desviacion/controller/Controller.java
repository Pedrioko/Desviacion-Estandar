/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.desviacion.controller;

import com.udec.desviacion.domain.Dato;
import com.udec.desviacion.math.Stats;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PedroD
 */
public class Controller {

    List<Dato> datos;

    public void addDato(double valor) {
        Dato dato = new Dato();
        dato.setId(this.datos.size() + 1);
        dato.setValor(valor);
        this.datos.add(dato);
    }

    public List<Dato> getDatos() {
        return datos;
    }

    public double getStdDev() {
        return Stats.getStdDev(this.datos);
    }

    public Controller() {
        this.datos = new ArrayList<>();
    }

}
