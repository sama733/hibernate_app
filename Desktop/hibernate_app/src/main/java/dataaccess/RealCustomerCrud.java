package dataaccess;


import dataaccess.bean.RealCustomer;
import logic.exception.DataNotFoundException;
import logic.exception.DuplicateInformationException;
import logic.exception.FieldRequiredException;
import logic.exception.NationalCodeFormatException;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import static logic.RealCustomerLogic.validateCustomerInformation;

public class RealCustomerCRUD {

    public static void create(RealCustomer realCustomer) throws FieldRequiredException, NationalCodeFormatException, DuplicateInformationException {
        validateCustomerInformation(realCustomer);
        RealCustomerCRUD.saveRealCustomer(realCustomer);
    }

    public static void saveRealCustomer(RealCustomer realCustomer) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(realCustomer);
            transaction.commit();
        } finally {
            session.close();
        }
    }

    public static List<RealCustomer> retrieveRealCustomer(RealCustomer realCustomer) throws DataNotFoundException {
        List<RealCustomer> realCustomers;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            realCustomers = generateCriteria(session, realCustomer).list();
            transaction.commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new DataNotFoundException("خطا در پیدا کردن مشتری!");
        } finally {
            session.close();
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

    public static void retrieveRealCustomerById(int customerId) throws DataNotFoundException {
        RealCustomer realCustomer;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            realCustomer = session.get(RealCustomer.class, customerId);
            if (realCustomer != null) {
                session.delete(realCustomer);
                transaction.commit();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new DataNotFoundException("خطا در حذف مشتری!");
        } finally {
            session.close();
        }

    }

    public static RealCustomer updateRealCustomerById(int customerId) throws DataNotFoundException {
        RealCustomer realCustomer;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            realCustomer = session.get(RealCustomer.class, customerId);
            transaction.commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new DataNotFoundException("خطا در ویرایش مشتری!");
        } finally {
            session.close();
        }
        return realCustomer;
    }

    public static void update(RealCustomer realCustomer) throws NationalCodeFormatException, FieldRequiredException, DataNotFoundException, DuplicateInformationException {
        validateCustomerInformation(realCustomer);
//         updateRealCustomerById(realCustomer.getCustomerId());
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(realCustomer);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

//    private static RealCustomer updateRealCustomerById(Integer customerId) {
//        RealCustomer realCustomer;
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        try {
//            Transaction transaction = session.beginTransaction();
//            realCustomer = session.get(RealCustomer.class, customerId);
//            transaction.commit();
//        } finally {
//            session.close();
//        }
//        return realCustomer;
//    }

    public static List<RealCustomer> findByNationalCode(String nationalCode) {

        List<RealCustomer> realCustomers = new ArrayList<RealCustomer>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from RealCustomer  R where R.nationalCode = :nationalCode");
            query.setParameter("nationalCode", nationalCode);
            realCustomers = query.list();
        } finally {
            session.close();
        }

        return realCustomers;

    }

}

