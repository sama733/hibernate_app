package DAL;

import java.util.ArrayList;
import java.util.List;

public class LoanType {
    private Integer loanTypeId;
    private String loanName;
    private float interestRate;
    private List<GrantCondition> grantConditions = new ArrayList<GrantCondition>();
    private List<LoanFile> loanFiles = new ArrayList<LoanFile>();

    public LoanType(Integer loanId, String loanName, float interestRate, List<GrantCondition> grantConditions) {
        this.loanTypeId = loanId;
        this.loanName = loanName;
        this.interestRate = interestRate;
        this.grantConditions = grantConditions;
    }

    public LoanType() {
    }

    public List<LoanFile> getLoanFiles() {
        return loanFiles;
    }

    public void setLoanFiles(List<LoanFile> loanFiles) {
        this.loanFiles = loanFiles;
    }

    public Integer getLoanTypeId() {

        return loanTypeId;
    }

    public void setLoanTypeId(Integer loanTypeId) {
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
