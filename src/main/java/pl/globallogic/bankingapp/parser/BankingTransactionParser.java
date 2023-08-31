package pl.globallogic.bankingapp.parser;

import jdk.jshell.spi.ExecutionControl;
import pl.globallogic.bankingapp.model.BankingTransaction;

import java.nio.file.Path;
import java.util.List;

public interface BankingTransactionParser {

    static List<BankingTransaction> parseFile(Path file){
        return null;
    }
}
