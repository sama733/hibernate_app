<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <link href=./cssfile/styleSheet.css rel=stylesheet>
    <title>تعریف نوع تسهیلات</title>
</head>
<body>
<div class="title">
    <h1>تعریف نوع تسهیلات</h1>
</div>
<div id="wrapper">
    <div class="content">
        <div class="box">
            <div class="box-in">
                <br>
                <form action="/LoanTypeServlet" method="get">
                    <table>
                        <tr>
                            <td>نام نوع تسهیلات</td>
                            <td><input type="text" name="loanTypeName" required="required"
                                       oninvalid="this.setCustomValidity('وارد کردن نوع تسهیلات الزامی است')"/></td>
                        </tr>
                        <tr>
                            <td>نرخ سود</td>
                            <td><input type="text" name="interestRate" required="required"
                                       oninvalid="this.setCustomValidity('وارد کردن نرخ سود الزامی است')"/></td>
                        </tr>
                    </table>
                    <input class="button" type="submit" value="اضافه کردن شرط اعطا">
                    <a href="../index.jsp" class="button">بازگشت به صفحه قبل</a>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
