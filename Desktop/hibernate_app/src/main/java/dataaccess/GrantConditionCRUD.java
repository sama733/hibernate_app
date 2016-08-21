package dataaccess;

import dataaccess.bean.GrantCondition;
import dataaccess.bean.LoanType;
import logic.exception.ConditionRangeException;
import logic.exception.FieldRequiredException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;

public class GrantConditionCRUD {

    public static void createGrantCondition(LoanType loanType, ArrayList<GrantCondition> grantConditions)
            throws ConditionRangeException, FieldRequiredException {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(loanType);
            for (GrantCondition grantCondition : grantConditions) {
                grantCondition.setLoanTypeId(loanType.getLoanTypeId());
                session.save(grantCondition);
            }
            transaction.commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
