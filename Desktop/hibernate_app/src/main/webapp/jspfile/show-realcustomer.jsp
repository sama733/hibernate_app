<%@ page import="dataaccess.bean.RealCustomer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset=UTF-8>
    <link href=jspfile/cssfile/styleSheet.css rel=stylesheet>
    <title>نمایش مشتری</title>
</head>
<body>
<div class=title>
    <h1>نمایش مشتری</h1>
</div>
<div id=wrapper>
    <div class=content>
        <div class=box>
            <div class=box-in>
                <br>
                <br>
                <%
                    int count = 0;
                    ArrayList<RealCustomer> realCustomers = (ArrayList<RealCustomer>) request.getAttribute("realCustomers");
                    if (realCustomers.size() > 0) {
                %>
                <p>نتایج جستجو به شرح زیر است:</p>
                <table>
                    <thead>
                    <tr>
                        <th>
                                                            ردیف
                        </th>
                        <th>
                            نام
                        </th>
                        <th>
                            نام خانوادگی
                        </th>
                        <th>
                            نام پدر
                        </th>
                        <th>
                            کد ملی
                        </th>
                        <th>
                            شماره مشتری
                        </th>
                        <th>
                            انجام عملیات
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (RealCustomer realCustomer : realCustomers) {
                            count++;
                    %>
                    <tr>
                        <td>
                            <%=count%>
                        </td>
                        <td>
                            <%=realCustomer.getFirstName()%>
                        </td>
                        <td>
                            <%=realCustomer.getLastName()%>
                        </td>
                        <td>
                            <%=realCustomer.getFatherName()%>
                        </td>
                        <td>
                            <%=realCustomer.getNationalCode()%>
                        </td>
                        <td>
                            <%=realCustomer.getCustomerId()%>
                        </td>
                        <td><a href="RealCustomerServlet?action=confirm-delete&id=<%=realCustomer.getCustomerId() %>"
                               class=form>حذف</a>
                            <a href="RealCustomerServlet?action=update&id=<%=realCustomer.getCustomerId() %>"
                               class=form>اصلاح</a>
                        </td>
                    </tr>
                    <%}%>
                    </tbody>
                </table>
                <%} else {%>
                <h3>مشتری با مشخصات وارد شده وجود ندارد!</h3>
                <%}%>
                <a href="../index.jsp" class=form>بازگشت به صفحه قبل</a>
            </div>

        </div>

    </div>
</div>

</body>
</html>

