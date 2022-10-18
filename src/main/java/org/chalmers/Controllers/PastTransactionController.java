package org.chalmers.Controllers;
import org.chalmers.PastTransactionItem;
import org.chalmers.model.ModelFacade;
import org.chalmers.model.Transaction;
import java.util.ArrayList;
import java.util.List;

public class PastTransactionController {

    ModelFacade facede = ModelFacade.getInstance();
    private List<PastTransactionItem>  pastTransactionItemList = new ArrayList<PastTransactionItem>();
    public PastTransactionController(){
        updateItem();

        }
        public void updateItem(){
        pastTransactionItemList.clear();
            for(Transaction t : facede.getCurrentBudgetTransactions()) {
                pastTransactionItemList.add(new PastTransactionItem(t));
            }
    }
    public List<PastTransactionItem> getPastTransactionItemList() {
        return this.pastTransactionItemList;
    }
}
