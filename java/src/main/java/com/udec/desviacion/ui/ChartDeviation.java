package com.udec.desviacion.ui;

import com.udec.desviacion.domain.Dato;
import com.udec.desviacion.math.Stats;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.CategorySeries;
import org.knowm.xchart.style.Styler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ChartDeviation {

    public CategoryChart getChart(List<Dato> datos) {

        // Create Chart
        CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Datos-Desviación").build();

        // Customize Chart

        // Customize Chart
        chart.getStyler().setChartTitleVisible(true);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setDefaultSeriesRenderStyle(CategorySeries.CategorySeriesRenderStyle.Stick);
        List<Double> errorBars = new ArrayList<Double>();
        Double stvdev = Stats.getStdDev(datos);
        datos.forEach(e->errorBars.add(stvdev));
        List<Double> data = datos.stream().map(e -> e.getValor()).collect(Collectors.toList());
        chart.addSeries("10^(-x)", data, data, errorBars);


        return chart;
    }
}

