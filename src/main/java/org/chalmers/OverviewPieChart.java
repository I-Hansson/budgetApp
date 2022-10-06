package org.chalmers;

import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import org.chalmers.Controllers.OverviewPieChartController;
import org.chalmers.model.BudgetPost;

import java.io.IOException;
import java.util.Timer;

public class OverviewPieChart extends AnchorPane {
    @FXML private PieChart piechart;
    private boolean animationFinished = true;

    OverviewPieChartController controller = new OverviewPieChartController();

    public OverviewPieChart(){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Overviewpiechart.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        piechart.getData().addAll(controller.getData());
        applyColors();

        piechart.setLegendVisible(false);
        piechart.setLabelLineLength(3);
        piechart.setLabelsVisible(false);
        
        for (final PieChart.Data data : piechart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET,
                    new EventHandler<MouseEvent>() {
                        @Override public void handle(MouseEvent e) {

                            ScaleTransition scaleTransition = new ScaleTransition();
                            scaleTransition.setDuration(Duration.millis(100));
                            scaleTransition.setCycleCount(1);
                            scaleTransition.setFromY(1);
                            scaleTransition.setFromX(1);
                            scaleTransition.setToY(1.1);
                            scaleTransition.setToX(1.1);
                            scaleTransition.setNode(data.getNode());
                            scaleTransition.play();
                        }
                    });
        }

        for (final PieChart.Data data : piechart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_EXITED_TARGET,
                    new EventHandler<MouseEvent>() {
                        @Override public void handle(MouseEvent e) {
                            ScaleTransition scaleTransition = new ScaleTransition();
                            scaleTransition.setDuration(Duration.millis(100));
                            scaleTransition.setCycleCount(1);
                            scaleTransition.setFromY(1.1);
                            scaleTransition.setFromX(1.1);
                            scaleTransition.setToY(1);
                            scaleTransition.setToX(1);
                            scaleTransition.setNode(data.getNode());
                            scaleTransition.play();
                        }
                    });
        }

    }

    private void applyColors() {
        BudgetPost[] bps = controller.getBudgetPosts();

        int i = 0;
        for (PieChart.Data data : piechart.getData()) {
            data.getNode().setStyle("-fx-pie-color: rgb(" + bps[i].getId().getColor() + ");");
            i++;
        }
    }
}


