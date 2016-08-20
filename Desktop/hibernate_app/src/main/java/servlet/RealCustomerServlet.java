package servlet;


import dataaccess.RealCustomerCRUD;
import dataaccess.bean.RealCustomer;
import logic.exception.DataNotFoundException;
import logic.exception.DuplicateInformationException;
import logic.exception.FieldRequiredException;
import logic.exception.NationalCodeFormatException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RealCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        request.setCharacterEncoding("UTF-8");
        if ("create".equalsIgnoreCase(action)) {
            createRealCustomer(request, response);
        }
        if ("retrieve".equalsIgnoreCase(action)) {
            retrieveRealCustomer(request, response);
        }
        if ("confirm-delete".equalsIgnoreCase(action)) {
            confirmDeleteRealCustomer(request, response);
        }
        if ("confirm-update".equalsIgnoreCase(action)) {
            updateRealCustomer(request, response);
        }
        if ("update".equalsIgnoreCase(action)) {
            update(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {

        RealCustomer realCustomer;

        int customerId = Integer.parseInt(request.getParameter("id"));
        try {

            realCustomer = RealCustomerCRUD.updateRealCustomerById(customerId);

            request.setAttribute("realcustomer", realCustomer);
            getServletContext().getRequestDispatcher("/jspfile/update-realcustomer.jsp").forward(request, response);


        } catch (DataNotFoundException e) {
            request.setAttribute("header", "عملیات ناموفق");
            request.setAttribute("text", "خطا در به روز زسانی مشتری ایجاد شده است." + "\n" + e.getMessage());
            request.setAttribute("url", "/jspfile/search-realcustomer.jsp");
            e.printStackTrace();
        } catch (ServletException e) {
            request.setAttribute("header", "عملیات ناموفق");
            request.setAttribute("text", "خطا در به روز زسانی مشتری ایجاد شده است." + "\n" + e.getMessage());
            request.setAttribute("url", "/jspfile/search-realcustomer.jsp");
            e.printStackTrace();
        } catch (IOException e) {
            request.setAttribute("header", "عملیات ناموفق");
            request.setAttribute("text", "خطا در به روز زسانی مشتری ایجاد شده است." + "\n" + e.getMessage());
            request.setAttribute("url", "/jspfile/search-realcustomer.jsp");
            e.printStackTrace();
        } finally {
            try {
                getServletConfig().getServletContext().getRequestDispatcher("/jspfile/info.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateRealCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            RealCustomer realCustomer = new RealCustomer();

            realCustomer.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
            realCustomer.setFirstName(request.getParameter("firstName"));
            realCustomer.setLastName(request.getParameter("lastName"));
            realCustomer.setFatherName(request.getParameter("fatherName"));
            realCustomer.setDateOfBirth(request.getParameter("dateOfBirth"));
            realCustomer.setNationalCode(request.getParameter("nationalCode"));

            RealCustomerCRUD.update(realCustomer);

            request.setAttribute("header", "عملیات موفق");
            request.setAttribute("text", "اطلاعات مشتری با شماره " + realCustomer.getCustomerId() + " با موفقیت به روز شد.");
            request.setAttribute("url", "/jspfile/search-realcustomer.jsp");

        } catch (NationalCodeFormatException e) {
            request.setAttribute("header", "عملیات ناموفق");
            request.setAttribute("text", "خطا در به روز زسانی مشتری ایجاد شده است." + "\n" + e.getMessage());
            request.setAttribute("url", "/jspfile/search-realcustomer.jsp");
        } catch (FieldRequiredException e) {
            request.setAttribute("header", "عملیات ناموفق");
            request.setAttribute("text", "خطا در به روز زسانی مشتری ایجاد شده است." + "\n" + e.getMessage());
            request.setAttribute("url", "jspfile/search-realcustomer.jsp");
        } catch (DataNotFoundException e) {
            request.setAttribute("header", "عملیات ناموفق");
            request.setAttribute("text", "خطا در به روز زسانی مشتری ایجاد شده است." + "\n" + e.getMessage());
            request.setAttribute("url", "jspfile/search-realcustomer.jsp");
            e.printStackTrace();
        } catch (DuplicateInformationException e) {
            request.setAttribute("header", "عملیات ناموفق");
            request.setAttribute("text", "کد ملی تکراری می باشد." + "\n" + e.getMessage());
            request.setAttribute("url", "jspfile/search-realcustomer.jsp");
            e.printStackTrace();
        } finally {
            try {
                getServletConfig().getServletContext().getRequestDispatcher("/jspfile/info.jsp").forward(request, response);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }


    private void createRealCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            RealCustomer realCustomer = new RealCustomer();

            realCustomer.setFirstName(request.getParameter("firstName"));
            realCustomer.setLastName(request.getParameter("lastName"));
            realCustomer.setFatherName(request.getParameter("fatherName"));
            realCustomer.setDateOfBirth(request.getParameter("dateOfBirth"));
            realCustomer.setNationalCode(request.getParameter("nationalCode"));

            RealCustomerCRUD.create(realCustomer);

            request.setAttribute("header", "عملیات موفق");
            request.setAttribute("text", "مشتری با موفقیت ثبت شد.");
            request.setAttribute("url", "/index.jsp");
        } catch (FieldRequiredException e) {
            request.setAttribute("header", "عملیات ناموفق");
            request.setAttribute("text", "لطفا مقادیر را با دقت وارد کنید." + "\n");
            request.setAttribute("url", "/jspfile/create-realcustomer.jsp");
        } catch (NationalCodeFormatException e) {
            request.setAttribute("header", "عملیات ناموفق");
            request.setAttribute("text", "کد ملی نامعتبر است." + "\n");
            request.setAttribute("url", "/jspfile/create-realcustomer.jsp");
        } catch (DuplicateInformationException e) {
            request.setAttribute("header", "عملیات ناموفق");
            request.setAttribute("text", "کد ملی تکراری می باشد." + "\n");
            request.setAttribute("url", "/jspfile/create-realcustomer.jsp");
            e.printStackTrace();
        } finally {
            try {
                getServletContext().getRequestDispatcher("/jspfile/info.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void retrieveRealCustomer(HttpServletRequest request, HttpServletResponse response) {

        try {
            RealCustomer realCustomer = new RealCustomer();

            realCustomer.setFirstName(request.getParameter("firstName"));
            realCustomer.setLastName(request.getParameter("lastName"));
            realCustomer.setNationalCode(request.getParameter("nationalCode"));

            List<RealCustomer> realCustomers = RealCustomerCRUD.retrieveRealCustomer(realCustomer);


            request.setAttribute("realCustomers", realCustomers);

        } catch (DataNotFoundException e) {
            request.setAttribute("header", "عملیات ناموفق");
            request.setAttribute("text", "مشتری مورد نظر موجود نیست." + "\n");
            request.setAttribute("url", "/jspfile/info.jsp");
            e.printStackTrace();
        } finally {
            try {
                getServletConfig().getServletContext().getRequestDispatcher("/jspfile/show-realcustomer.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void confirmDeleteRealCustomer(HttpServletRequest request, HttpServletResponse response) {
        int customerId = Integer.parseInt(request.getParameter("id"));
        try {
            RealCustomerCRUD.retrieveRealCustomerById(customerId);

            request.setAttribute("header", "عملیات موفق");
            request.setAttribute("text", "مشتری با موفقیت حذف شد.");
            request.setAttribute("url", "/index.jsp");
        } catch (DataNotFoundException e) {
            request.setAttribute("header", "عملیات ناموفق");
            request.setAttribute("text", "مشتری مورد نظر موجود نیست." + "\n");
            request.setAttribute("url", "/jspfile/info.jsp");
            e.printStackTrace();
        } finally {
            try {
                getServletContext().getRequestDispatcher("/jspfile/info.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


