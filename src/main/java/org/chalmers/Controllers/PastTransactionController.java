package org.chalmers.Controllers;
import org.chalmers.PastTransactionItem;
import org.chalmers.model.ITransaction;
import org.chalmers.model.ModelFacade;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class for the view class PastTransactionView
 *
 * @author Jonathan
 */

public class PastTransactionController {

    ModelFacade facade = ModelFacade.getInstance();
    private List<PastTransactionItem>  pastTransactionItemList = new ArrayList<>();
    public PastTransactionController(){
        updateItem();

    }
    public void updateItem(){
        pastTransactionItemList.clear();
        for(ITransaction t : facade.getCurrentBudgetTransactions()) {
            pastTransactionItemList.add(new PastTransactionItem(t));
        }
    }
    public List<PastTransactionItem> getPastTransactionItemList() {
        return this.pastTransactionItemList;
    }
}
