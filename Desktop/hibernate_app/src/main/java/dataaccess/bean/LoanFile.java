package dataaccess.bean;


import java.math.BigDecimal;

public class LoanFile {
    private Long loanFileId;
    private int duration;
    private BigDecimal cost;
    private LoanType loanType;
    private RealCustomer realCustomer;
    private Long loanTypeId;
    private Long customerId;

    public Long getLoanTypeId() {
        return loanTypeId;
    }

    public void setLoanTypeId(Long loanTypeId) {
        this.loanTypeId = loanTypeId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LoanFile() {
    }

    public LoanFile(Long loanFileId, int duration, BigDecimal cost, LoanType loanType, RealCustomer realCustomer, Long loanTypeId, Long customerId) {
        this.loanFileId = loanFileId;
        this.duration = duration;
        this.cost = cost;
        this.loanType = loanType;
        this.realCustomer = realCustomer;
        this.loanTypeId = loanTypeId;
        this.customerId = customerId;
    }

    public Long getLoanFileId() {

        return loanFileId;
    }

    public void setLoanFileId(Long loanFileId) {
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
