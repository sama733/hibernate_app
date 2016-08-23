package dataaccess;

import dataaccess.bean.LoanType;
import logic.LoanTypeLogic;
import logic.exception.DataNotFoundException;
import logic.exception.FieldRequiredException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;
import util.LoggerUtil;

public class LoanTypeCRUD {

    public static LoanType createLoanType(String loanName, Float interestRate) throws FieldRequiredException {

        return LoanTypeLogic.validateLoanType(loanName, interestRate);

    }

    public static LoanType retrieveLoanType(Integer loanTypeId) throws DataNotFoundException {

        LoanType loanType;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            loanType = session.get(LoanType.class, loanTypeId);
            LoggerUtil.getLogger().info("LoanType was successfully retrieved from database");
        } catch (RuntimeException e) {
            LoggerUtil.getLogger().info("LoanType was not successfully retrieved from database");
            e.printStackTrace();
            throw new DataNotFoundException("نوع تسهیلات با شماره " + loanTypeId + "وجود ندارد.");
        } finally {
            session.close();
        }
        return loanType;
    }
}
