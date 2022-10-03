package org.chalmers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import org.chalmers.Controllers.OverviewpiechartController;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Overviewpiechart extends AnchorPane {
    @FXML private PieChart piechart;
    OverviewpiechartController controller = new OverviewpiechartController();

    public Overviewpiechart(){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Overviewpiechart.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.piechart.getData().addAll(controller.getData());




        }

    }


