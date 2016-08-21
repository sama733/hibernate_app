<%@ page import="dataaccess.bean.LoanType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href=jspfile/cssfile/styleSheet.css rel=stylesheet>
    <script type="text/javascript" src="/jspfile/table-script.js"></script>
    <title>شرایط اعطا</title>
</head>
<body>
<div class="title">
    <h1>شرایط اعطا</h1>
</div>
<div id="wrapper">
    <div class="content">
        <div class="box">
            <div class="box-in">
                <br>
                <table>
                    <%
                        LoanType loanType = (LoanType) request.getAttribute("loanType");
                    %>
                    <tr>
                        <td>نام تسهیلات</td>
                        <td><%=loanType.getLoanTypeName()%>
                        </td>
                    </tr>
                    <tr>
                        <td>نرخ سود تسهیلات</td>
                        <td><%=loanType.getInterestRate()%>
                        </td>
                    </tr>
                </table>
                <a href="/jspfile/create-loantype.jsp" class=form>تصحیح</a>
                <br>
                <hr>
                <br>
                <h3>لطفا شروط اعطای تسهیلات مورد نظر را وارد کنید</h3>
                <br>
                <table>
                    <tr>
                        <td>نام</td>
                        <td><input type="text" id="grantName"></td>
                    </tr>
                    <tr>
                        <td>حداقل مدت قرارداد</td>
                        <td><input type="text" id="minPeriod"></td>
                    </tr>
                    <tr>
                        <td>حداکثر مدت قرارداد</td>
                        <td><input type="text" id="maxPeriod"></td>
                    </tr>
                    <tr>
                        <td>حداقل مبلغ قرارداد</td>
                        <td><input type="text" id="minCost"></td>
                    </tr>
                    <tr>
                        <td>حداکثر مبلغ قرارداد</td>
                        <td><input type="text" id="maxCost"></td>
                    </tr>
                </table>
                <input class="button" type="submit" value="اضافه کردن" onclick="addRow()">
                <br>
                <hr>
                <br>
                <form action="/GrantConditionServlet" method="get">
                    <input type="hidden" name="loanTypeName" value="<%=request.getParameter("loanTypeName")%>">
                    <input type="hidden" name="interestRate" value="<%=request.getParameter("interestRate")%>">
                    <table class="result-table" id="grantConditionsTable"></table>
                    <br>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
