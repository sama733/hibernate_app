package dataaccess.bean;

import java.util.ArrayList;
import java.util.List;

public class LoanType {
    private Long loanTypeId;
    private String loanName;
    private float interestRate;
    private List<GrantCondition> grantConditions = new ArrayList<GrantCondition>();
    private List<LoanFile> loanFiles = new ArrayList<LoanFile>();

    public LoanType(Long loanTypeId, String loanName, float interestRate, List<GrantCondition> grantConditions, List<LoanFile> loanFiles) {
        this.loanTypeId = loanTypeId;
        this.loanName = loanName;
        this.interestRate = interestRate;
        this.grantConditions = grantConditions;
        this.loanFiles = loanFiles;
    }

    public LoanType() {
    }

    public List<LoanFile> getLoanFiles() {
        return loanFiles;
    }

    public void setLoanFiles(List<LoanFile> loanFiles) {
        this.loanFiles = loanFiles;
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

    public List<GrantCondition> getGrantConditions() {
        return grantConditions;
    }

    public void setGrantConditions(List<GrantCondition> grantConditions) {
        this.grantConditions = grantConditions;
    }
}
