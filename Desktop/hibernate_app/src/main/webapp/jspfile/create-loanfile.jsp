<%@ page import="dataaccess.bean.LoanType" %>
<%@ page import="dataaccess.bean.RealCustomer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <link href=jspfile/cssfile/styleSheet.css rel=stylesheet>
    <title>پرونده تسهیلاتی</title>
</head>
<body>
<div class="title">
    <h1>پرونده تسهیلاتی</h1>
</div>

<div id="wrapper">
    <div class="content">
        <div class="box">
            <div class="box-in">
                <br>
                <form action="/LoanFileServlet">
                    <input type="text" name="action" value="retrieve-realcustomer-and-loantype" hidden>
                    <table>
                        <tr>
                            <td>شماره مشتری</td>
                            <td><input type="text" name="customerId" value="<%=request.getAttribute("customerId")%>">
                            </td>
                            <td><input class="button" type="submit" value="بازیابی"></td>
                            <td><a href="../index.jsp" class="form">بازگشت به صفحه قبل</a></td>
                        </tr>
                    </table>
                </form>
                <br>
                <hr>
                <br>
                <% int customerExists = (int) request.getAttribute("customerExists");%>
                <c:choose>
                    <c:when test="<%=(customerExists==1)%>">
                        <form action="/LoanFileServlet">
                            <input type="text" hidden name="action" value="create">
                            <% RealCustomer realCustomer = (RealCustomer) request.getAttribute("realCustomerObject"); %>
                            <input type="text" hidden name="confirmedCustomerId"
                                   value="<%=realCustomer.getCustomerId()%>">

                            <table>
                                <tr>
                                    <td> نام و نام خانوادگی مشتری :</td>
                                    <td><%=realCustomer.getFirstName()%>
                                    </td>
                                </tr>
                                <tr>
                                    <td> نوع تسهیلات</td>
                                    <td>
                                        <%boolean anyLoanTypeExists = (boolean) request.getAttribute("anyLoanTypeExists"); %>
                                        <c:choose>
                                            <c:when test="<%=anyLoanTypeExists%>">
                                                <% ArrayList<LoanType> loanTypes = (ArrayList<LoanType>) request.getAttribute("loanTypes"); %>
                                                <select class="my-dropdown" name="loanType">
                                                    <% for (LoanType loanType : loanTypes) { %>
                                                    <option value="<%= loanType.getLoanTypeId()%>"><%= loanType.getLoanTypeName()%>
                                                    </option>
                                                    <%}%>
                                                </select>
                                            </c:when>
                                            <c:otherwise>
                                                <p>داده ای وجود ندارد</p>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                                <tr>
                                    <td> مدت قرارداد</td>
                                    <td><input type="text" name="duration"></td>
                                </tr>
                                <tr>
                                    <td>مبلغ قرارداد</td>
                                    <td><input type="text" name="amount"></td>
                                </tr>
                            </table>
                            <input class="button" type="submit" value="ثبت">
                        </form>
                    </c:when>
                    <c:when test="<%=(customerExists==0)%>">
                        <h2>خطا</h2>
                        <p>شماره مشتری یافت نشد</p>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>
                <br>
            </div>
        </div>
    </div>
</div>
</body>
</html>
