package org.chalmers.modelAdapters.chartAdapters;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.collections.transformation.SortedList;
import javafx.scene.chart.PieChart;

import java.util.Map;

public class PieChartFX {

    public static ObservableList<PieChart.Data> getDataAsObservableList(Map<String, Integer> dataMap) {
        ObservableList<PieChart.Data> dataObservableList = FXCollections.observableArrayList();

        int i = 0;
        for (String name : dataMap.keySet()) {
            dataObservableList.add(i, new PieChart.Data(name, dataMap.get(name)));
            i++;
        }

        return dataObservableList;
    }
}
