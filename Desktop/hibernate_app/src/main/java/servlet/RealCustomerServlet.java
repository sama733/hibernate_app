package servlet;


import dataaccess.RealCustomerCrud;
import dataaccess.bean.RealCustomer;
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

            realCustomer.setFirstName(request.getParameter("firstName"));
            realCustomer.setLastName(request.getParameter("lastName"));
            realCustomer.setFatherName(request.getParameter("fatherName"));
            realCustomer.setDateOfBirth(request.getParameter("dateOfBirth"));
            realCustomer.setNationalCode(request.getParameter("nationalCode"));

            RealCustomerCrud.create(realCustomer);

        } catch (FieldRequiredException e) {
            e.printStackTrace();
        } catch (NationalCodeFormatException e) {
            e.printStackTrace();
        }
    }

}


