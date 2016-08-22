package dataaccess;

import dataaccess.bean.LoanFile;
import dataaccess.bean.LoanType;
import dataaccess.bean.RealCustomer;
import logic.LoanFileLogic;
import logic.exception.DataNotFoundException;
import logic.exception.InputNotInRangeException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by DOTIN SCHOOL 4 on 8/22/2016.
 */
public class LoanFileCRUD {

    public static List<LoanType> retrieveLoanTypes() throws DataNotFoundException {

        List<LoanType> loanTypes;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            loanTypes = session.createCriteria(LoanType.class).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new DataNotFoundException("هیچ نوع تسهیلاتی ثبت نشده است!");
        } finally {
            session.close();
        }
        return loanTypes;
    }

    public static void create(Integer customerId, Integer loanTypeId, LoanFile loanFile) throws DataNotFoundException, InputNotInRangeException {

        LoanType loanType = null;

            loanType = LoanTypeCRUD.retrieveLoanType(loanTypeId);
            LoanFileLogic.validateLoanFile(loanFile, loanTypeId);
            loanFile.setLoanType(loanType);
            RealCustomer realCustomer = RealCustomerCRUD.searchByCustomerId(customerId);
            loanFile.setRealCustomer(realCustomer);
            saveLoanFile(loanFile, loanType, realCustomer);

    }

    private static void saveLoanFile(LoanFile loanFile, LoanType loanType, RealCustomer realCustomer) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            loanFile.setLoanType(loanType);
            loanFile.setRealCustomer(realCustomer);
            session.save(loanFile);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
