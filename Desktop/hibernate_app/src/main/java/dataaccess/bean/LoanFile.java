package dataaccess.bean;


import java.math.BigDecimal;

public class LoanFile {
    private int loanFileId;
    private int duration;
    private BigDecimal cost;
    private LoanType loanType;
    private RealCustomer realCustomer;


    public LoanFile() {
    }

    public LoanFile(int loanFileId, int duration, BigDecimal cost) {
        this.loanFileId = loanFileId;
        this.duration = duration;
        this.cost = cost;
    }

    public int getLoanFileId() {

        return loanFileId;
    }

    public void setLoanFileId(int loanFileId) {
        this.loanFileId = loanFileId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public RealCustomer getRealCustomer() {
        return realCustomer;
    }

    public void setRealCustomer(RealCustomer realCustomer) {
        this.realCustomer = realCustomer;
    }
}
