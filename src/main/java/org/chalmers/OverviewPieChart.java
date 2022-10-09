package org.chalmers;

import javafx.animation.ScaleTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.chalmers.Controllers.OverviewPieChartController;
import org.chalmers.model.BudgetPost;

import java.io.IOException;
import java.util.List;


/**
 * A view class for the pie chart on the main page
 *
 * @author williamfrisk
 * @author I-Hansson
 */
public class OverviewPieChart extends AnchorPane {
    @FXML private PieChart piechart;

    @FXML private Label caption;
    @FXML private Label caption1;
    @FXML private Label caption2;
    @FXML private Label caption3;
    @FXML private Label caption4; //TODO implementera så att denna representerar övrigt

    private final double pieChartTotal;


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
        this.pieChartTotal = calculateTotal();

        applyColors();

        piechart.setLegendVisible(false);
        piechart.setLabelsVisible(false);

        piechart.setStartAngle(-90);

        applyMouseOverAnimation();

        setupSliceCaptions();
    }


    private double calculateTotal() {
        double total = 0;
        for (PieChart.Data data : piechart.getData()) {
            total += data.getPieValue();
        }
        return total;
    }

    private void setupSliceCaptions() {
        Label[] captions = {caption, caption1, caption2, caption3};
        double percent = 0;
        int i = 0;

        for (Label caption : captions) {
            percent += (piechart.getData().get(i).getPieValue() / pieChartTotal) / 2;

            caption.setTranslateX(Math.cos(Math.toRadians(percent * 360)) * 90);
            caption.setTranslateY(Math.sin(Math.toRadians(percent * 360)) * 90);
            nameSliceCaption(piechart.getData().get(i).getPieValue() / pieChartTotal, caption);

            percent += (piechart.getData().get(i).getPieValue() / pieChartTotal) / 2;
            i++;
        }

    }

    private void nameSliceCaption(double percent, Label caption) {
        caption.setText(String.valueOf(Math.round(percent * 100)) + "%");
        caption.setStyle("-fx-text-fill: white; -fx-font-family: 'Roboto'");
    }


    /**
     * Applies mouse over animation to the pieChart
     */
    private void applyMouseOverAnimation() {
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


