package dataaccess.bean;

import java.util.Set;

public class LoanType {
    private int loanTypeId;
    private String loanTypeName;
    private float interestRate;
    private Set<GrantCondition> grantConditions;

    public LoanType(int loanTypeId, String loanTypeName, float interestRate) {
        this.loanTypeId = loanTypeId;
        this.loanTypeName = loanTypeName;
        this.interestRate = interestRate;
    }

    public LoanType(int loanTypeId, String loanTypeName, float interestRate, Set<GrantCondition> grantConditions) {
        this.loanTypeId = loanTypeId;
        this.loanTypeName = loanTypeName;
        this.interestRate = interestRate;
        this.grantConditions = grantConditions;
    }

    public LoanType(String loanTypeName, Float interestRate) {
        this.loanTypeName = loanTypeName;
        this.interestRate = interestRate;
    }

    public LoanType() {
    }

    public int getLoanTypeId() {
        return loanTypeId;
    }

    public void setLoanTypeId(int loanTypeId) {
        this.loanTypeId = loanTypeId;
    }

    public String getLoanTypeName() {
        return loanTypeName;
    }

    public void setLoanTypeName(String loanTypeName) {
        this.loanTypeName = loanTypeName;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public Set<GrantCondition> getGrantConditions() {
        return grantConditions;
    }

    public void setGrantConditions(Set<GrantCondition> grantConditions) {
        this.grantConditions = grantConditions;
    }
}
