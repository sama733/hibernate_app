<%@ page import="dataaccess.bean.RealCustomer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang=fa>
<head>
    <meta charset=UTF-8>
    <link href=jspfile/cssfile/styleSheet.css rel=stylesheet>
    <title>ویرایش اطلاعات مشتری</title>
</head>
<body>
<div class=title>
    <h1>ویرایش اطلاعات مشتری</h1>
</div>
<div id=wrapper>
    <div class=content>
        <div class=box>
            <div class=box-in>
                <br>
                <form action="/RealCustomerServlet" method="get">
                    <input type="hidden" name="action" value="confirm-update">
                    <p>اطلاعات مشتری حقیقی :</p>
                    <br>
                    <%RealCustomer realCustomer = (RealCustomer) request.getAttribute("realcustomer"); %>
                    <table>
                        <tr>
                            <td>شماره مشتری</td>
                            <td><input type='text' name='customerId' value="<%=realCustomer.getCustomerId()%>"
                                       readonly></td>
                        </tr>
                        <tr>
                            <td> نام</td>
                            <td><input type='text' name='firstName' value="<%=realCustomer.getFirstName()%>"></td>
                        </tr>
                        <td> نام خانوادگی</td>
                        <td><input type='text' name='lastName' value="<%=realCustomer.getLastName()%>"></td>
                        </tr>
                        <td> نام پدر</td>
                        <td><input type='text' name='fatherName' value="<%=realCustomer.getFatherName()%>"></td>
                        </tr>
                        <tr>
                            <td> تاریخ تولد</td>
                            <td><input type='text' name='dateOfBirth' value="<%=realCustomer.getDateOfBirth()%>">
                            </td>
                        </tr>
                        <tr>
                            <td>کد ملی</td>
                            <td><input type='text' name='nationalCode'
                                       value="<%=realCustomer.getNationalCode()%>"></td>
                        </tr>
                    </table>
                    <input type='submit' class='button' value='ذخیره تغییرات'>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
