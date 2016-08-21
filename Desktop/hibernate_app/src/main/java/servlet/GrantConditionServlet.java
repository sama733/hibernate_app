package servlet;

import dataaccess.GrantConditionCRUD;
import dataaccess.bean.GrantCondition;
import dataaccess.bean.LoanType;
import logic.GrantConditionLogic;
import logic.exception.ConditionRangeException;
import logic.exception.FieldRequiredException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;


public class GrantConditionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String loanTypeName = request.getParameter("loanTypeName");
            Float interestRate = Float.parseFloat(request.getParameter("interestRate"));

            int rowCount = Integer.parseInt(request.getParameter("rowCount"));
            ArrayList<GrantCondition> grantConditions = new ArrayList<GrantCondition>();

            for (int i = 1; i < rowCount - 1; i++) {
                GrantCondition grantCondition = new GrantCondition();
                grantCondition.setGrantName(request.getParameter("grantName" + i));
                grantCondition.setMinPeriod(Integer.parseInt((request.getParameter("minPeriod" + i))));
                grantCondition.setMaxPeriod(Integer.parseInt((request.getParameter("maxPeriod" + i))));
                grantCondition.setMinCost(new BigDecimal((request.getParameter("minCost" + i))));
                grantCondition.setMaxCost(new BigDecimal((request.getParameter("maxCost" + i))));
                grantConditions.add(grantCondition);
            }
            GrantConditionLogic.validateGrantCondition(grantConditions);
            GrantConditionCRUD.createGrantCondition(new LoanType(loanTypeName, interestRate), grantConditions);

            request.setAttribute("header", "عملیات موفق");
            request.setAttribute("text", "نوع تسهیلات جدید با موفقیت ثبت شد!");
            request.setAttribute("url", "/jspfile/create-loantype.jsp");
        } catch (FieldRequiredException e) {
            e.printStackTrace();
            request.setAttribute("header", "عملیات ناموفق");
            request.setAttribute("text", "لطفا تمامی فیلد ها را پر نمایید! " + "\n");
            request.setAttribute("url", "/jspfile/create-loantype.jsp");
        } catch (ConditionRangeException e) {
            request.setAttribute("header", "عملیات ناموفق");
            request.setAttribute("text", "در تعیین مدت قرارداد و مبلغ قرارداد دقت نمایید! " + "\n");
            request.setAttribute("url", "/jspfile/create-loantype.jsp");
            e.printStackTrace();
        } finally {
            getServletConfig().getServletContext().getRequestDispatcher("/jspfile/info.jsp").forward(request, response);
        }

    }
}