package DAL;


import java.math.BigDecimal;

public class GrantCondition {
    private int grantId;
    private String grantName;
    private int minPeriod;
    private int maxPeriod;
    private BigDecimal minCost;
    private BigDecimal maxCost;

    public GrantCondition(int grantId, String grantName, int minPeriod, int maxPeriod, BigDecimal minCost, BigDecimal maxCost) {
        this.grantId = grantId;
        this.grantName = grantName;
        this.minPeriod = minPeriod;
        this.maxPeriod = maxPeriod;
        this.minCost = minCost;
        this.maxCost = maxCost;
    }

    public GrantCondition() {
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

    public int getMinPeriod() {
        return minPeriod;
    }

    public void setMinPeriod(int minPeriod) {
        this.minPeriod = minPeriod;
    }

    public int getMaxPeriod() {
        return maxPeriod;
    }

    public void setMaxPeriod(int maxPeriod) {
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
