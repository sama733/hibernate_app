package logic;

import dataaccess.GrantConditionCRUD;
import dataaccess.bean.GrantCondition;
import dataaccess.bean.LoanFile;
import logic.exception.DataNotFoundException;
import logic.exception.InputNotInRangeException;

import java.util.List;


public class LoanFileLogic {


    public static void validateLoanFile(LoanFile loanFile, Integer loanTypeId) throws InputNotInRangeException, DataNotFoundException {

        List<GrantCondition> grantConditions = GrantConditionCRUD.retrieveConditionsByLoanTypeId(loanTypeId);
        for (GrantCondition grantCondition : grantConditions) {
            if (loanFile.getDuration() > grantCondition.getMaxPeriod() || loanFile.getDuration() < grantCondition.getMinPeriod()) {
                throw new InputNotInRangeException("مدت زمان وارد شده در محدوده مدت زمان های شرایط تسهیلات صدق نمی کند! لطفا دوباره تلاش کنید.");
            }
            if (loanFile.getCost().compareTo(grantCondition.getMaxCost()) == 1 || loanFile.getCost().compareTo(grantCondition.getMinCost()) == -1) {
                throw new InputNotInRangeException("مبلغ وارد شده در محدوده مبلغ های شرایط تسهیلات صدق نمی کند! لطفا دوباره تلاش کنید.");
            }
        }
    }


}
