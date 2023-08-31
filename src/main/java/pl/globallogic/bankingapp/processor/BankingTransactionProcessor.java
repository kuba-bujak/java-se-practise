package pl.globallogic.bankingapp.processor;

import pl.globallogic.bankingapp.model.BankingTransaction;

import java.util.List;

public class BankingTransactionProcessor {

    //total transaction value for particular transaction type

    public static double getTotalAmountForMoneyTransferSend(List<BankingTransaction> transactions, String transactionType){
        double total = 0;
        for (BankingTransaction transaction :
                transactions) {
            if (transaction.getTransactionType().equals(transactionType)) {
                total += transaction.getAmount();
            }
        }
        return total;
    }
    // get top 5(n) by amount transactions - test required
    // get total for all transactions - test required
    // get total amount for particular month (use new LocalDate().getMonth()) - test required

}
