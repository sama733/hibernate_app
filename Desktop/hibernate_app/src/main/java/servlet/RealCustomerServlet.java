package servlet;


import dataaccess.bean.RealCustomer;
import logic.RealCustomerLogic;
import logic.exception.FieldRequiredException;
import logic.exception.NationalCodeFormatException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RealCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        request.setCharacterEncoding("UTF-8");
        if ("create".equalsIgnoreCase(action)) {
            createRealCustomer(request, response);
        }
    }


    private void createRealCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            RealCustomer realCustomer = new RealCustomer();
//            realCustomer.setCustomerId(Long.valueOf(request.getParameter("customerId")));
            realCustomer.setFirstName(request.getParameter("firstName"));
            realCustomer.setLastName(request.getParameter("lastName"));
            realCustomer.setFatherName(request.getParameter("fatherName"));
            realCustomer.setDateOfBirth(request.getParameter("dateOfBirth"));
            realCustomer.setNationalCode(request.getParameter("nationalCode"));

            RealCustomerLogic.create(realCustomer);

            request.setAttribute("header", "عملیات موفق");
            request.setAttribute("text", "مشتری با موفقیت ثبت شد.");
            request.setAttribute("url", "create-realcustomer.jsp");
        } catch (FieldRequiredException e) {
            request.setAttribute("header", "عملیات ناموفق");
            request.setAttribute("text", "خطا در ثبت مشتری جدیدایجاد شده است." + "\n" + e.getMessage());
            request.setAttribute("url", "create-realcustomer.jsp");
        }  catch (NationalCodeFormatException e) {
            request.setAttribute("header", "عملیات ناموفق");
            request.setAttribute("text", "خطا در ثبت مشتری جدیدایجاد شده است." + "\n" + e.getMessage());
            request.setAttribute("url", "create-realcustomer.jsp");
        } finally {
            try {
                getServletConfig().getServletContext().getRequestDispatcher("/info-page.jsp").forward(request, response);
            } catch ( IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }
}

