package servlet;


import dataaccess.RealCustomerCrud;
import dataaccess.bean.RealCustomer;
import logic.exception.DataNotFoundException;
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
    }


    private void createRealCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            RealCustomer realCustomer = new RealCustomer();

            realCustomer.setFirstName(request.getParameter("firstName"));
            realCustomer.setLastName(request.getParameter("lastName"));
            realCustomer.setFatherName(request.getParameter("fatherName"));
            realCustomer.setDateOfBirth(request.getParameter("dateOfBirth"));
            realCustomer.setNationalCode(request.getParameter("nationalCode"));

            RealCustomerCrud.create(realCustomer);

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

            List<RealCustomer> realCustomers = RealCustomerCrud.retrieveRealCustomer(realCustomer);


            request.setAttribute("realCustomers", realCustomers);

        } catch (DataNotFoundException e) {
            request.setAttribute("header", "عملیات ناموفق");
            request.setAttribute("text", "مشتری مورد نظر موجود نیست." + "\n");
            request.setAttribute("url", "/jspfile/info.jsp");
            e.printStackTrace();
        }finally {
            try {
                getServletConfig().getServletContext().getRequestDispatcher("/jspfile/show-realcustomer.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}


