package dataaccess.bean;

import java.util.HashSet;
import java.util.Set;

public class LoanType {
    private Long loanTypeId;
    private String loanName;
    private float interestRate;
    private Set<GrantCondition> grantConditions = new HashSet<GrantCondition>();

    public LoanType(Long loanTypeId, String loanName, float interestRate) {
        this.loanTypeId = loanTypeId;
        this.loanName = loanName;
        this.interestRate = interestRate;
    }

    public LoanType() {
    }


    public Long getLoanTypeId() {

        return loanTypeId;
    }

    public void setLoanTypeId(Long loanTypeId) {
        this.loanTypeId = loanTypeId;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
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
