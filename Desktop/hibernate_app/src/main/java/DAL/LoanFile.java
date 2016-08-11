package DAL;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LoanFile {
    private int loanFileId;
    private int duration;
    private BigDecimal cost;
    private LoanType loanType;
    private RealCustomer realCustomer;
    private List<LoanFile> loanFiles = new ArrayList<LoanFile>();

    public LoanFile() {
    }

    public LoanFile(int loanFileId, int duration, BigDecimal amount, LoanType loanType, RealCustomer realCustomer) {

        this.loanFileId = loanFileId;
        this.duration = duration;
        this.cost = amount;
        this.loanType = loanType;
        this.realCustomer = realCustomer;
    }

    public List<LoanFile> getLoanFiles() {
        return loanFiles;
    }

    public void setLoanFiles(List<LoanFile> loanFiles) {
        this.loanFiles = loanFiles;
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
