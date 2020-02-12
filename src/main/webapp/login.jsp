<%--
  Created by IntelliJ IDEA.
  User: Bmo
  Date: 2020/1/5
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.css">
    <title>Title</title>
    <style>
        html{
            height: 100%;
        }
        body{
            height: 100%;
            background-image: linear-gradient(#8ca5db, #b792d5);
        }
        #login{
            width:400px;
            height:328px;
            position:absolute;
            left:0;
            right:0;
            top:0;
            bottom:0;
            margin:auto;
        }
        #registerBtn{
            margin-right: 15px;
        }
        #forgetPass {
            position: absolute;
            bottom: 23px;
            left: 19px;
        }
    </style>
</head>
<body>

    <div id="login" class="panel panel-primary">
        <div class="panel-heading">
            人事管理系统
        </div>
        <div class="panel-body">
            <div class="form-group">
                <form action="${pageContext.request.contextPath}/admin/login" method="post">
                    <label>用户名：</label><input type="text" class="form-control" name="username">
                    <div class="alert" id="warn-username"></div>
                    <label>密码：</label><input type="password" class="form-control" name="password">
                    <div class="alert" id="warn-password"></div>
                    <a href="#" class="text-info" id="forgetPass">忘记密码?</a>
                    <input type="submit" value="登录" class="btn btn-primary pull-right">
                </form>
            </div>
        </div>
    </div>

</body>
<script src="js/jquery-1.11.1.js"></script>
<script src="js/bootstrap.js"></script>
<script>

</script>
</html>
