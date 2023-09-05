package pl.globallogic.exersices.basic.Ex46Banking;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Bank {
    private String name;
    ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch foundBranch = findBranch(branchName);
        if (foundBranch != null) {
            return foundBranch.newCustomer(customerName, initialTransaction);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName,double transaction) {
        Branch foundBranch = findBranch(branchName);
        if (foundBranch != null) {
            return foundBranch.addCustomerTransaction(customerName, transaction);
        }
        return false;
    }

    public Branch findBranch(String branchName) {
        for (Branch branch : branches) {
            if (branch.getName().equals(branchName)) {
                return branch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean printTransaction) {
        Branch foundBranch = findBranch(branchName);
        if (foundBranch != null) {
            System.out.printf("Customer details for branch '%s' \n", branchName);
            ArrayList<Customer> customers = foundBranch.getCustomers();
            for (Customer customer : customers) {
                System.out.printf("Customer: %s [%s] \n", customer.getName(), customers.indexOf(customer) + 1);
                if (printTransaction) {
                    System.out.println("Transactions:");
                    ArrayList<Double> transactions = customer.getTransactions();
                    for (Double transaction : transactions) {
                        System.out.printf("[%s] Amount %s \n", transactions.indexOf(transaction) + 1, transaction);
                    }
                }
            }
            return true;
        }
        return false;
    }
}
