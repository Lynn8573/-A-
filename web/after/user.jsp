<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户登录</title>

    <!-- Bootstrap -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
            rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
</head>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script
        src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>

<style>
    th {
        text-align: center;
    }
</style>
<script type="text/javascript">
    function deleteConfirm(id, name) {

        confirm
            .show(
                '溫馨提示',
                '您确定要刪除[' + name + ']用户吗？',
                {
                    '确定' : {
                        'primary' : true,
                        'callback' : function() {
                            location.href = "${pageContext.request.contextPath}/UserDeleteServlet?id="
                                + id;
                        }
                    }
                });
    }
    function test() {
        confirm("dfgvb");
    }
</script>
</head>
<body>
<nav class="navbar navbar-inverse" style="margin-bottom: 0px;">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed"
                    data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                    aria-expanded="false">
                <span class="sr-only">Toggle navigation</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">锋迷网管理系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse"
             id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="<%=path%>/FuzzySelectGoods">商品管理 <span
                        class="sr-only">(current)</span></a></li>
                <li><a href="<%=path%>/GoodsTypeSelectServlet">商品类型管理</a></li>
                <li class="active"><a href="<%=path%>/UserFuzzyServlet">用户管理</a></li>
                <li><a href="<%=path%>/OrderFuzzySelectServlet">订单管理</a></li>
                <li><a href="${pageContext.request.contextPath}/before/index.html">直通锋迷网</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="<%=path%>/after/login.jsp">${username}</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-in"
                                      style="padding-left: 0px"></span></a></li>
                <li><a href="<%=path%>/LogOutServlet"
                       style="padding-left: 0px">退出</a></li>

            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
<div class="jumbotron" style="padding-top: 20px; padding-bottom: 25px">
    <div class="container">
        <h2>用户列表</h2>
    </div>
</div>
<div class="container">
    <form class="form-inline"
          action="${pageContext.request.contextPath}/UserFuzzyServlet"
          method="post">
        <div class="col-md-4">
            <div class="form-group">
                <label for="exampleInputName2">用户姓名</label> <input type="text"
                                                                   class="form-control" id="exampleInputName2" placeholder="输入姓名"
                                                                   name="username">
            </div>
        </div>
        <div class="col-md-3" style="text-align: right; padding-right: 25px;">
            <div class="form-group">
                <label>性别</label> <input type="radio" name="sex" value="男">男
                <input type="radio" name="sex" value="女">女
            </div>
            <button type="submit" class="btn btn-info"
                    style="margin-left: 20px;">查询</button>
        </div>
    </form>
    <div>
        <a href="${pageContext.request.contextPath}/after/admin_adduser.jsp"><button type="submit" class="btn btn-info"
                                                                                     style="margin-left: 20px;">添加</button></a>
    </div>
</div>

<!--以下显示表格-->
<div class="container" style="margin-top: 20px;">
    <form id="deleteFrom"
          action="${pageContext.request.contextPath}/UserSelectServlet"
          method="post">
        <table style="text-align: center; margin-right: 10px; width: 99%"
               class="table table-striped table-hover table-bordered">
            <thead style="text-align: center;">
            <tr>
                <th>序号</th>
                <th>用户姓名</th>
                <th>性别</th>
                <th>手机号</th>
                <th>删除</th>
                <th>重置密码</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.sex}</td>
                    <td>${user.phone}</td>


                    <td><a class="glyphicon glyphicon-trash" color="#5BC0DE"
                           style="text-decoration: none" name="id"
                           href="<%=path%>/UserDeleteServlet?id=${user.id}"
                           onclick="if(confirm('是否确定删除'+'${user.username}'+'？')==false)return false"></a></td>

                    <td><a class="glyphicon glyphicon-edit" color="#5BC0DE"
                           style="text-decoration: none" name="id"
                           href="<%=path%>/UserResetServlet?id=${user.id}"
                           onclick="if(confirm('是否确定重置'+'${user.username}'+'的密码？')==false)return false"></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>
<%
    Object objNo = request.getAttribute("pageNo");
    Object objCount = request.getAttribute("pageCount");
    int pageNo = 0;
    int pageCount = 0;
    if (objNo != null) {
        pageNo = Integer.parseInt(objNo.toString());
    }
    if (objCount != null) {
        pageCount = Integer.parseInt(objCount.toString());
    }
%>

<div class="container">
    <nav aria-label="..." class="navbar-right" style="margin-right: 15px">
        <ul class="pagination">
            <li><a class=" btn-info"
                   href="<%=path%>/UserFuzzyServlet?pageNo=1" aria-label="Previous">
                <span aria-hidden="true">首页 </span>
            </a></li>
            <%
                if (pageNo > 1) {
            %>
            <li><a class=" btn-info"
                   href="<%=path %>/UserFuzzyServlet?pageNo=${pageNo-1}&username=${user.username}&sex=${user.sex}"
                   aria-label="Previous"> <span aria-hidden="true"> « </span></a></li>

            <%
            } else {
            %>

            <li class="disabled"><a href="#" aria-label="Previous">« <span
                    class="sr-only">(current) </span></a></li>
            <%
                }
                if (pageCount > pageNo) {
            %>

            <li><a class="btn"
                   href="<%=path %>/UserFuzzyServlet?pageNo=${pageNo+1}&username=${user.username}&sex=${user.sex}">${pageNo}</a></li>
            <li><a class="btn-info"
                   href="<%=path %>/UserFuzzyServlet?pageNo=${pageNo+1}&username=${user.username}&sex=${user.sex}"
                   aria-label="Next"><span aria-hidden="true">»</span></a></li>

            <%
            } else {
            %>

            <li><a class=" btn-info"
                   href="<%=path %>/UserFuzzyServlet?pageNo=${pageNo}&username=${user.username}&sex=${user.sex}">${pageNo}</a></li>
            <li class="disabled"><a href="#" aria-label="Previous">»<span
                    class="sr-only">(current) </span></a></li>
            <%
                }
            %>
            <li><a class=" btn-info"
                   href="<%=path %>/UserFuzzyServlet?pageNo=${pageCount}&username=${user.username}&sex=${user.sex}"
                   aria-label="Previous"> <span aria-hidden="true">尾页 </span></a></li>
        </ul>
    </nav>
</div>
</body>
</html>
