package dataaccess;


import com.sun.org.apache.regexp.internal.RE;
import dataaccess.bean.LoanFile;
import dataaccess.bean.RealCustomer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.List;

public class ManipulatingTables {

    public static void saveRealCustomer(RealCustomer realCustomer) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(realCustomer);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        RealCustomer realCustomer= new RealCustomer();
        LoanFile loanFile= new LoanFile();
        realCustomer.setCustomerId((long) 10);
        realCustomer.setDateOfBirth("1000");
        realCustomer.setFatherName("vali");
        realCustomer.setFirstName("sama");
        realCustomer.setLastName("farsi");
//        realCustomer.setLoanFiles((List<LoanFile>) loanFile);
        realCustomer.setNationalCode("0013472135");

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(realCustomer);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }
}
