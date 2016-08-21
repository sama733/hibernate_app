package dataaccess;

import dataaccess.bean.LoanType;
import logic.LoanTypeLogic;
import logic.exception.FieldRequiredException;

/**
 * Created by DOTIN SCHOOL 4 on 8/20/2016.
 */
public class LoanTypeCRUD {

    public static LoanType createLoanType(String loanName, Float interestRate) throws FieldRequiredException {

        return LoanTypeLogic.validateLoanType(loanName, interestRate);

    }

}
