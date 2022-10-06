package org.chalmers;

import javafx.animation.ScaleTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.chalmers.Controllers.OverviewPieChartController;
import org.chalmers.model.BudgetPost;

import java.io.IOException;
import java.util.List;

public class OverviewPieChart extends AnchorPane {
    @FXML private PieChart piechart;

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
        piechart.setLabelsVisible(false);

        // Lägger till animation i piecharten
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

    /**
     * Used for applying correct colors to the pie chart.
     */
    private void applyColors() {
        List<BudgetPost> bps = controller.getBudgetPosts();

        int i = 0;
        for (PieChart.Data data : piechart.getData()) {
            data.getNode().setStyle("-fx-pie-color: rgb(" + bps.get(i).getId().getColor() + ");");
            i++;
        }
    }
}

