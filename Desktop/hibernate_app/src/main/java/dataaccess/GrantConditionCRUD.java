package dataaccess;

import dataaccess.bean.GrantCondition;
import dataaccess.bean.LoanType;
import logic.exception.ConditionRangeException;
import logic.exception.DataNotFoundException;
import logic.exception.FieldRequiredException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;
import util.LoggerUtil;

import java.util.ArrayList;
import java.util.List;

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
            LoggerUtil.getLogger().info("grantConditions was created successfully.");
        } catch (RuntimeException e) {
            LoggerUtil.getLogger().info("could not create grantConditions");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<GrantCondition> retrieveConditionsByLoanTypeId(Integer loanTypeId) throws DataNotFoundException {
        List<GrantCondition> grantConditions;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {

            Query query = session.createQuery("from GrantCondition GC where GC.loanTypeId =:LT");
            query.setParameter("LT", loanTypeId);
            grantConditions = query.list();
            LoggerUtil.getLogger().info("grantCondition was successfully retrieved from database");
        } catch (RuntimeException e) {
            LoggerUtil.getLogger().info("grantCondition was not successfully retrieved from database");
            e.printStackTrace();
            throw new DataNotFoundException("خطا در بازیابی شروط اعطا!");
        } finally {
            session.close();
        }
        return grantConditions;
    }
}
