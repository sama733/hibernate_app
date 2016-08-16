package dataaccess;


import dataaccess.bean.RealCustomer;
import logic.RealCustomerLogic;
import logic.exception.FieldRequiredException;
import logic.exception.NationalCodeFormatException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

public class RealCustomerCrud {

    public static void create(RealCustomer realCustomer) throws FieldRequiredException, NationalCodeFormatException {
        RealCustomerLogic.validateCustomerInformation(realCustomer);
        RealCustomerCrud.saveRealCustomer(realCustomer);
    }

    public static void saveRealCustomer(RealCustomer realCustomer) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(realCustomer);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
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

