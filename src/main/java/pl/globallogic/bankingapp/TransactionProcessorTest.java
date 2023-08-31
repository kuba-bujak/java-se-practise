package pl.globallogic.bankingapp;

import pl.globallogic.bankingapp.model.BankingTransaction;
import pl.globallogic.bankingapp.parser.BankingTransactionCSVParser;
import pl.globallogic.bankingapp.processor.BankingTransactionProcessor;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TransactionProcessorTest {
    //input: file with transactions data
    //output: various transactions statistics (total transaction value for particular transaction type, top 5 transfers, etc)

    public static void main(String[] args) {
        Path testData = Paths.get("src/main/resources/transactions.csv");
        double expectedTotalAmountForMoneyTransferSend = 1063.0;
        String targetTransactionType = "MONEY_TRANSFER_SEND";
        try {
            List<BankingTransaction> transactions = BankingTransactionCSVParser.parseFile(testData);
            System.out.println(transactions.size() == 15);
            System.out.println(BankingTransactionProcessor.getTotalAmountForMoneyTransferSend(transactions, targetTransactionType )
                == expectedTotalAmountForMoneyTransferSend);

        } catch (IOException e) {
            System.out.println("We have a problem with test data source. Please check it.");
        }
    }
}
