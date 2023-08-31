package pl.globallogic.bankingapp.model;

public class SavingAccount extends Account {

    private double savingRate;

    private String beneficiaryName;

    public SavingAccount(int id, String accountNumber, double balance, double savingRate, String beneficiaryName) {
        super(id, accountNumber, balance);
        this.savingRate = savingRate;
        this.beneficiaryName = beneficiaryName;
    }

    public double getSavingRate() {
        return savingRate;
    }

    public void setSavingRate(double savingRate) {
        this.savingRate = savingRate;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }
}
