package org.chalmers.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.scene.chart.*;

import java.util.*;

public class BudgetPostMonthLineDiagram implements IBudgetPostsObserver{
    XYChart.Series<Integer, Integer> data = new XYChart.Series<Integer, Integer>();

    public BudgetPostMonthLineDiagram(){
        this.data = fillObservableList();
    }

    public XYChart.Series fillObservableList(){
        for(int i = 1; i<=31;i++){
            data.getData().add(new XYChart.Data<>(i, 0));
        }
        return data;
    }
    public XYChart.Series getDataSerie(){
        return this.data;
    }

    @Override
    public void update(ArrayList<Transaction> list) {
        for(Transaction transaction: list){
            if( transaction.getAmount() != 0){
                Integer date = transaction.getDateOfTransaction().get(Calendar.DAY_OF_MONTH);
                Integer amount = (int) transaction.getAmount();
                var temp = this.data.getData().get(date-1);
                int temp2 = temp.getYValue();
                this.data.getData().set(date-1,new XYChart.Data<>(date,amount + temp2));
                }
            }
        }
}

