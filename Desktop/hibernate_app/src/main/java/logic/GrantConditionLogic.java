package logic;

import dataaccess.bean.GrantCondition;
import logic.exception.ConditionRangeException;
import logic.exception.FieldRequiredException;

import java.util.ArrayList;

public class GrantConditionLogic {
    public static void validateGrantCondition(ArrayList<GrantCondition> grantConditions)

            throws ConditionRangeException, FieldRequiredException {

        for (GrantCondition grantCondition : grantConditions) {
            if (grantCondition.getMinCost().equals("") || grantCondition.getMinCost() == null) {
                throw new FieldRequiredException("لطفا حداقل مبلغ قرار داد را وارد نمایید");
            }
            if (grantCondition.getMaxCost().equals("") || grantCondition.getMaxCost() == null) {
                throw new FieldRequiredException("لطفا حداکثر مبلغ قرار داد را وارد نمایید");
            }
            if (grantCondition.getMinPeriod().equals("") || grantCondition.getMinPeriod() == null) {
                throw new FieldRequiredException("لطفا حداقل مدت قرار داد را وارد نمایید");
            }
            if (grantCondition.getMaxPeriod().equals("") || grantCondition.getMaxPeriod() == null) {
                throw new FieldRequiredException("لطفا حداکثر مدت قرار داد را وارد نمایید");
            }
            if (grantCondition.getMinPeriod() > grantCondition.getMaxPeriod()) {
                throw new ConditionRangeException("حداکثر مدت قرارداد باید بزرگتر از حداقل مدت قرارداد باشد.");
            }
            if (grantCondition.getMinCost().compareTo(grantCondition.getMaxCost()) == 1) {
                throw new ConditionRangeException("حداکثر مبلغ قرارداد باید بزرگتر از حداقل مدت قرارداد باشد.");
            }
        }
    }
}

