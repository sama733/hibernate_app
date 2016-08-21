package dataaccess.bean;


import java.math.BigDecimal;

public class GrantCondition {
    private int grantId;
    private String grantName;
    private Integer minPeriod;
    private Integer maxPeriod;
    private BigDecimal minCost;
    private BigDecimal maxCost;
    private int loanTypeId;

    public GrantCondition(int grantId, String grantName, int minPeriod, int maxPeriod, BigDecimal minCost, BigDecimal maxCost) {
        this.grantId = grantId;
        this.grantName = grantName;
        this.minPeriod = minPeriod;
        this.maxPeriod = maxPeriod;
        this.minCost = minCost;
        this.maxCost = maxCost;
    }

    public GrantCondition(int grantId, String grantName, Integer minPeriod, Integer maxPeriod, BigDecimal minCost, BigDecimal maxCost, int loanTypeId) {
        this.grantId = grantId;
        this.grantName = grantName;
        this.minPeriod = minPeriod;
        this.maxPeriod = maxPeriod;
        this.minCost = minCost;
        this.maxCost = maxCost;
        this.loanTypeId = loanTypeId;
    }

    public GrantCondition() {
    }

    public int getLoanTypeId() {
        return loanTypeId;
    }

    public void setLoanTypeId(int loanTypeId) {
        this.loanTypeId = loanTypeId;
    }

    public int getGrantId() {
        return grantId;
    }

    public void setGrantId(int grantId) {
        this.grantId = grantId;
    }

    public String getGrantName() {
        return grantName;
    }

    public void setGrantName(String grantName) {
        this.grantName = grantName;
    }

    public Integer getMinPeriod() {
        return minPeriod;
    }

    public void setMinPeriod(Integer minPeriod) {
        this.minPeriod = minPeriod;
    }

    public Integer getMaxPeriod() {
        return maxPeriod;
    }

    public void setMaxPeriod(Integer maxPeriod) {
        this.maxPeriod = maxPeriod;
    }

    public BigDecimal getMinCost() {
        return minCost;
    }

    public void setMinCost(BigDecimal minCost) {
        this.minCost = minCost;
    }

    public BigDecimal getMaxCost() {
        return maxCost;
    }

    public void setMaxCost(BigDecimal maxCost) {
        this.maxCost = maxCost;
    }

}
