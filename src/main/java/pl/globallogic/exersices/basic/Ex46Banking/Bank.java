package pl.globallogic.exersices.basic.Ex46Banking;

import java.util.ArrayList;

public class Bank {
    private String name;
    ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName) {
        return branches.add(new Branch(branchName));
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch foundBranch = findBranch(branchName);
        foundBranch.newCustomer(customerName, initialTransaction)
        return true;
    }

    public boolean addCustomerTranscaction(String branchName, String customerName,double transaction) {
        return true;
    }

    public Branch findBranch(String branchName) {
        for (Branch branch : branches) {
            if (branch.getName().equals(branchName)) {
                return branch;
            }
        }
        return null;
    }
}
