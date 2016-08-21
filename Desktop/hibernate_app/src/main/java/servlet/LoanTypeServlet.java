package servlet;

import dataaccess.LoanTypeCRUD;
import dataaccess.bean.LoanType;
import logic.exception.FieldRequiredException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoanTypeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageToForward = "";
        try {
            String loanTypeName = request.getParameter("loanTypeName");
            Float interestRate = Float.parseFloat(request.getParameter("interestRate"));

            LoanType loanType = LoanTypeCRUD.createLoanType(loanTypeName, interestRate);

            request.setAttribute("loanType", loanType);
            pageToForward = "/jspfile/create-grantcondition.jsp";
        } catch (FieldRequiredException e) {
            request.setAttribute("header", "عملیات ناموفق");
            request.setAttribute("text", "خطا در ثبت نوع تسهیلات جدید! " + "\n" + e.getMessage());
            request.setAttribute("url", "/jspfile/create-loantype.jsp");
            pageToForward = "/jspfile/info.jsp";
        } finally {
            try {
                getServletConfig().getServletContext().getRequestDispatcher(pageToForward).forward(request, response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
