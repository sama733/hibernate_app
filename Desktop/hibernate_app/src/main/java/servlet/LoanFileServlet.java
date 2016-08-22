package servlet;

import dataaccess.LoanFileCRUD;
import dataaccess.RealCustomerCRUD;
import dataaccess.bean.LoanFile;
import dataaccess.bean.LoanType;
import dataaccess.bean.RealCustomer;
import logic.exception.DataNotFoundException;
import logic.exception.InputNotInRangeException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class LoanFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if ("creation-file".equalsIgnoreCase(action)) {
            creationFile(request, response);
        }
        if ("search-realcustomer-and-loantype".equalsIgnoreCase(action)) {
            searchCustomerAndLoanType(request, response);
        }
        if ("create-loanfile".equalsIgnoreCase(action)) {
            createLoanFile(request, response);
        }
    }

    private void creationFile(HttpServletRequest request, HttpServletResponse response) {
        try {

            request.setAttribute("customerExists", -1);
            request.setAttribute("customerId", "");
            getServletContext().getRequestDispatcher("/jspfile/create-loanfile.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchCustomerAndLoanType(HttpServletRequest request, HttpServletResponse response) {

        Integer customerId = Integer.parseInt(request.getParameter("customerId"));
        int customerExists = 0;
        boolean loanTypeExists = false;
        try {
            RealCustomer realCustomer = RealCustomerCRUD.searchByCustomerId(customerId);
            customerExists = 1;
            request.setAttribute("customerExists", customerExists);
            request.setAttribute("realCustomer", realCustomer);
            request.setAttribute("customerId", realCustomer.getCustomerId());

            List<LoanType> loanTypes = LoanFileCRUD.retrieveLoanTypes();
            loanTypeExists = true;
            request.setAttribute("LoanTypeExists", loanTypeExists);
            request.setAttribute("loanTypes", loanTypes);


        } catch (DataNotFoundException e) {
            e.printStackTrace();
        }
        try {
            getServletConfig().getServletContext().getRequestDispatcher("/jspfile/create-loanfile.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void createLoanFile(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer customerId = Integer.parseInt(request.getParameter("CustomerId"));
            Integer loanTypeId = Integer.parseInt(request.getParameter("loanType"));

            LoanFile loanFile = new LoanFile();

            loanFile.setCost(new BigDecimal(request.getParameter("cost")));
            loanFile.setDuration(Integer.parseInt(request.getParameter("duration")));

            LoanFileCRUD.create(customerId, loanTypeId, loanFile);

            request.setAttribute("header", "عملیات موفق");
            request.setAttribute("text", "پرونده تسهیلاتی با موفقیت ثبت شد.");
            request.setAttribute("url", "LoanFileServlet?action=creation-file");
        } catch (Exception e) {
            request.setAttribute("header", "عملیات ناموفق");
            request.setAttribute("text", "خطا در ثبت پرونده تسهیلاتی جدیدایجاد شده است." + "\n");
            request.setAttribute("url", "LoanFileServlet?action=creation-file");
        } catch (DataNotFoundException e) {
            request.setAttribute("header", "عملیات ناموفق");
            request.setAttribute("text", "تسهیلات مورد نظر یافت نشد" + "\n");
            request.setAttribute("url", "LoanFileServlet?action=creation-file");
            e.printStackTrace();
        } catch (InputNotInRangeException e) {
            request.setAttribute("header", "عملیات ناموفق");
            request.setAttribute("text", "عدم تطابق با شروط اعطا" + "\n");
            request.setAttribute("url", "LoanFileServlet?action=creation-file");
            e.printStackTrace();
        } finally {
            try {
                getServletConfig().getServletContext().getRequestDispatcher("/jspfile/info.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
            }

        }
    }
}

