<%--
  Created by IntelliJ IDEA.
  作者: 小白
  日期: 2020/6/27
  时间: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.qfedu.entity.Goods"%>
<%@page import="com.qfedu.service.impl.GoodsServiceImpl"%>
<%@page import="com.qfedu.service.GoodsService"%>
<%@page import="com.qfedu.entity.GoodsType"%>
<%@page import="java.util.List"%>
<%@page import="com.qfedu.service.impl.GoodsTypeServiceImpl"%>
<%@page import="com.qfedu.service.GoodsTypeService"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%String path=request.getContextPath(); %>


<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加/修改商品</title>

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

<style type="text/css">
    th {
        text-align: center;
    }
</style>
<%
    GoodsTypeService gt=new GoodsTypeServiceImpl();
    List<GoodsType> typeList=gt.TypeSelect();
    request.setAttribute("typeList", typeList);

%>
<%
    String id=request.getParameter("id");
    if(id!=null){
        int id1=Integer.parseInt(id);
        GoodsService gs=new GoodsServiceImpl();
        Goods  goods = gs.getGoodsById(id1);
        request.setAttribute("goods",goods );
    }

%>

<script type="text/javascript">
    //解决选择下拉框内容到输入框内容的问题
    function showName(obj, id) {
        var name = $(obj).text();
        $("#typeName").val(name);
        $("#typeId").val(id);
    }

    function check() {
        var id = document.getElementById("price");
        if (/^\d+$/.test(id.value)||id.value=="") {
            return true;
        }else{
            alert("价格输入错误，请输入数字!");
            id.value="";
            return false;
        }
    }
    function submit(){
        if(check()==false){
            return false;
        }

    }
    function showPreview(source) {
        var file = source.files[0];
        if(window.FileReader) {
            var fr = new FileReader();
            console.log(fr);
            var portrait = document.getElementById('portrait');
            fr.onloadend = function(e) {
                portrait.src = e.target.result;
            };
            fr.readAsDataURL(file);
            portrait.style.display = 'block';
        }
    }


</script>
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

<div class="jumbotron" style="padding-top: 15px; padding-bottom: 15px;">
    <div class="container">
        <c:if test="${empty goods.id}">
            <h2>添加商品信息</h2>
        </c:if>
        <c:if test="${not empty goods.id}">
            <h2>修改商品信息</h2>
        </c:if>
    </div>
</div>
<div class="container" style="margin-top: 20px;" align="center">

    <form class="form-horizontal"
          action="${pageContext.request.contextPath}/AddGoodsServlet"
          method="post">

        <input type="hidden" name="id" value="${goods.id}" />
        <div class="form-group">
            <label class="col-sm-2 control-label">商品名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="goodsName"
                       value="${goods.goodsName}" placeholder="请输入名称,默认名为5G手机">
            </div>

        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">商品价格</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="price" id="price"
                       value="${goods.price}" placeholder="价格,默认为9999" onblur="return check()">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">商品类别</label>
            <div class="col-sm-10">
                <div class="input-group">
                    <div class="input-group-btn">
                        <button type="button" class="btn btn-default dropdown-toggle"
                                data-toggle="dropdown" aria-haspopup="true"
                                aria-expanded="false">
                            下拉菜单<span class="caret"></span>
                        </button>
                        <ul id="selectSpeaker" class="dropdown-menu">

                            <c:forEach items="${typeList}" var="type">
                                <li><a onclick="showName(this,${type.id})">${type.typename}</a></li>
                            </c:forEach>

                        </ul>
                    </div>
                    <!-- /btn-group -->
                    <input type="hidden" class="form-control" id="typeId"
                           name="typeId" value="${goods.typeId}"> <input type="text"
                                                                         class="form-control" disabled id="typeName"
                                                                         value="${goods.goodStype.typename}" placeholder="默认为测试类" aria-label="...">
                </div>
                <!-- /input-group -->
            </div>
        </div>


        <div class="form-group">
            <label class="col-sm-2 control-label">商品图片</label>
            <div class="col-sm-10">
                <input type="file" name="imgPath" value="${goods.imgPath} "onchange="showPreview(this)" ><br />
                <c:if test="${not empty goods.imgPath}">
                    <img src="http://localhost:8081/uploadfile/images/${goods.imgPath}"
                         id="portrait"	alt="..." class="img-thumbnail" height="130px" width="130px" >
                </c:if>
                <c:if test="${empty goods.imgPath}">
                    <img src="${pageContext.request.contextPath}/images/default.jpg"
                         id="portrait"	alt="..." class="img-thumbnail" height="130px" width="130px" >
                </c:if>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">商品描述</label>
            <div class="col-sm-10">
					<textarea class="form-control" name="comment" rows="3"
                              value="请输入描述">${goods.comment}</textarea>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" onclick="return submit()"  class="btn btn-default">保存</button>
            </div>
        </div>
    </form>

</div>


</body>
</html>
