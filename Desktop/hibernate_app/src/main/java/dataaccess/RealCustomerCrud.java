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
