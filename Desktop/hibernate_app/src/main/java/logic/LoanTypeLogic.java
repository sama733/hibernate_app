package logic;

import dataaccess.bean.LoanType;
import logic.exception.FieldRequiredException;

public class LoanTypeLogic {

    public static LoanType validateLoanType(String loanTypeName, Float interestRate)
            throws FieldRequiredException {
        if (loanTypeName.equals(null) || loanTypeName.equals("")) {
            throw new FieldRequiredException("وارد کردن نام تسهیلات الزامی است.");
        }
        if (interestRate == null || interestRate.equals("")) {
            throw new FieldRequiredException("وارد کردن نرخ سود الزامی است.");
        }
        return new LoanType(loanTypeName, interestRate);
    }
}
