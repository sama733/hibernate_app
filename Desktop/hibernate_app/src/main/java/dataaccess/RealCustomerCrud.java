package dataaccess;


import dataaccess.bean.RealCustomer;
import logic.RealCustomerLogic;
import logic.exception.FieldRequiredException;
import logic.exception.NationalCodeFormatException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class RealCustomerCrud {

    public static void create(RealCustomer realCustomer) throws FieldRequiredException, NationalCodeFormatException {
        RealCustomerLogic.validateCustomerInformation(realCustomer);
        RealCustomerCrud.saveRealCustomer(realCustomer);
    }

    public static void saveRealCustomer(RealCustomer realCustomer) {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        try {
//            transaction.begin();
//            session.save(realCustomer);
//            transaction.commit();
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//
//        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            session.save(realCustomer);
            tx.commit();
        } finally {
            session.close();
        }
    }

//    public static void main(String[] args) {
//        RealCustomer realCustomer = new RealCustomer("dasd" , "dasda" , "dada" , "dasdas" , "dasd" ,0l);
//        LoanFile loanFile = new LoanFile();
//        loanFile.setCost(new BigDecimal("100"));
//        loanFile.setDuration(10);
//        try {
//            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//            Session session = sessionFactory.openSession();
//            session.beginTransaction();
//            session.save(realCustomer);
//            loanFile.setRealCustomer(realCustomer);
//            session.save(loanFile);
//            session.getTransaction().commit();
//            session.close();
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//        }
}

