package dataaccess;


import dataaccess.bean.RealCustomer;
import logic.RealCustomerLogic;
import logic.exception.DataNotFoundException;
import logic.exception.FieldRequiredException;
import logic.exception.NationalCodeFormatException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import java.util.List;

public class RealCustomerCrud {

    public static void create(RealCustomer realCustomer) throws FieldRequiredException, NationalCodeFormatException {
        RealCustomerLogic.validateCustomerInformation(realCustomer);
        RealCustomerCrud.saveRealCustomer(realCustomer);
    }

    public static void saveRealCustomer(RealCustomer realCustomer) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            session.save(realCustomer);
            tx.commit();
        } finally {
            session.close();
        }
    }

    public static List<RealCustomer> retrieveRealCustomer(RealCustomer realCustomer) throws DataNotFoundException {
        List<RealCustomer> realCustomers;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            realCustomers = generateCriteria(session, realCustomer).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new DataNotFoundException("خطا در پیدا کردن مشتری!");
        }
        return realCustomers;
    }

    private static Criteria generateCriteria(Session session, RealCustomer realCustomer) {

        Criteria criteria = session.createCriteria(RealCustomer.class);

        if ((realCustomer.getCustomerId() != null)) {
            criteria.add(Restrictions.eq("customerId", realCustomer.getCustomerId()));
        }
        if (!realCustomer.getNationalCode().equalsIgnoreCase(null) && !realCustomer.getNationalCode().equals("")) {
            criteria.add(Restrictions.eq("nationalCode", realCustomer.getNationalCode()));
        }
        if (!realCustomer.getFirstName().equalsIgnoreCase(null) && !realCustomer.getFirstName().equals("")) {
            criteria.add(Restrictions.eq("firstName", realCustomer.getFirstName()));
        }
        if (!realCustomer.getLastName().equalsIgnoreCase(null) && !realCustomer.getLastName().equals("")) {
            criteria.add(Restrictions.eq("lastName", realCustomer.getLastName()));
        }

        return criteria;

    }

}

