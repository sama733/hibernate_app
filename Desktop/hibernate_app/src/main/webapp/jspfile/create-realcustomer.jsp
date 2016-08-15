<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html lang="fa">
<head>
    <link href=./cssfile/styleSheet.css rel=stylesheet>
    <title>ثبت اطلاعات مشتری</title>
</head>
<body>
<div class="title">
    <h1>ثبت اطلاعات مشتری</h1>
</div>

<div id="wrapper">
    <hr class="hrshow">
    <div class="content">
        <div class="box">
            <div class="box-in">
                <br>
                <p>لطفا اطلاعات مشتری را وارد نمایید.</p>
                <br>
                <form action="/RealCustomerServlet" method="get">
                    <input type="hidden" name="action" value="create">
                    <table>
                        <tr>
                            <td> نام</td>
                            <td><input type="text" name="firstName"></td>
                        </tr>
                        <tr>
                            <td> نام خانوادگی</td>
                            <td><input type="text" name="lastName"></td>
                        </tr>
                        <tr>
                            <td>نام پدر</td>
                            <td><input type="text" name="fatherName"></td>
                        </tr>
                        <tr>
                            <td>تاریخ تولد</td>
                            <td><input type="text" name="dateOfBirth"></td>
                        </tr>
                        <tr>
                            <td>کد ملی</td>
                            <td><input type="text" name="nationalCode"></td>
                        </tr>
                    </table>
                    <input type="submit" class="button" value="ثبت اطلاعات">
                    <a href="../index.jsp" class="form">بازگشت به صفحه قبل</a>
                </form>
            </div>
        </div>
    </div>
</div>


</body>
</html>