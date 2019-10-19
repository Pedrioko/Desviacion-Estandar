/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.desviacion.math;

import com.udec.desviacion.domain.Dato;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * @author PedroD
 */
public class Stats {

    public static double getStdDev(List<Dato> list) {
        List<Double> listdiff = getDiffs(list);
        return Math.sqrt(getAvgDouble(listdiff));
    }

    public static List<Double> getDiffs(List<Dato> list) {
        double avg = getAvg(list);
        return list.stream().map((e -> {
                double diff = e.getValor() - avg;
                return diff * diff;
            })).collect(Collectors.toList());
    }

    public static double getAvg(List<Dato> list) {
        Double result;
        result = list.stream().map(Dato::getValor).reduce(0D, (t, i) -> t + i);
        return result / list.size();
    }

    public static double getAvgDouble(List<Double> list) {
        Double result;
        result = list.stream().reduce(0D, (t, i) -> t + i);
        return result / list.size();
    }
}
