<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang=fa>
<head>
    <meta charset=UTF-8>
    <link href="jspfile/cssfile/styleSheet.css" rel="stylesheet">
    <title><%=request.getAttribute("header")%></title>
</head>
<body>
<div class=title>
    <h1> <%=request.getAttribute("header")%></h1>
</div>
<div id=wrapper>
    <div class=content>
        <div class=box>
            <div class=box-in>
                <br>
                <h2><%=request.getAttribute("header")%></h2>
                <br>
                <p><%=request.getAttribute("text")%></p>
                <br>
                <a href="<%=request.getAttribute("url")%>" class="form">بازگشت </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>

