<%@page import="com.qfedu.entity.Goods" %>
<%@page import="com.qfedu.service.impl.GoodsTypeServiceImpl" %>
<%@page import="com.qfedu.service.GoodsTypeService" %>
<%@page import="com.qfedu.service.impl.GoodsServiceImpl" %>
<%@page import="com.qfedu.service.GoodsService" %>
<%@page import="com.qfedu.entity.GoodsType" %>
<%@page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
	<title>订单管理</title>

	<!-- Bootstrap -->
	<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
			rel="stylesheet">
	<link
			href="https://cdn.bootcss.com/jquery-confirm/3.2.3/jquery-confirm.min.css"
			rel="stylesheet">
	<link rel="stylesheet"
		  href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
		  integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		  crossorigin="anonymous">
	<link
			href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css"
			rel="stylesheet">
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js "></script>
	<script
			src="https://cdn.bootcss.com/jquery-confirm/3.2.3/jquery-confirm.min.js "></script>
	<script src="https://cdn.bootcss.com/jquery.form/4.2.1/jquery.form.js"></script>
	<!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
	<!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
	<!--[if lt IE 9]>
	<script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
	<![endif]-->
	<style type="text/css">
		#dropdownMenu2 {
			padding-right: 28px;
			background-image: url("../images/my/2.png");
			background-repeat: no-repeat;
			background-position-x: right;
		}
	</style>
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
<%--<%--%>
<%--    // GoodsTypeService gt = new GoodsTypeServiceImpl();--%>
<%--    // List<GoodsType> typeList = gt.selectType();--%>
<%--    // request.setAttribute("typeList", typeList);--%>
<%--%>--%>


<script>


	var selectNum = 0;
	var allnum = 0;
	$(function () {
		$("#selectAll").click(function () {
			$("[type='checkbox']").prop("checked", this.checked);
			if (this.checked) {
				selectNum = $("[type='checkbox']").length - 1;

			} else {
				selectNum = 0;
			}
			$("#badge").text(selectNum);
		});
		var btn = document.getElementById('btn');
		var goodsids = document.getElementsByName("goodsid");
		$("[name='goodsid']").click(function () {

			if (this.checked) {
				selectNum += 1;
				var botton = false;
				for (var i = 0; i < goodsids.length - 1; i++) {
					if (goodsids[i].checked) {
						botton = true;
					} else {
						botton = false;
						break;
					}
				}
				if (botton) {
					allnum = 1;
					btn.checked = true;
				}
			} else {
				selectNum -= 1;
				allnum = 0;
				btn.checked = false;
			}
			$("#badge").text(selectNum);
		});
	});


	// 弹框初始化操作
	$(function () {
		$('[data-toggle="popover"]').popover();

	});

	function showAdd() {
		location.href = "/FengMi/after/add_goods.jsp";
	}

	// function checkAll() {
	//     var goodsids = document.getElementsByName("goodsid");
	//     if (allnum == 0) {
	//         for (var i = 0; i < goodsids.length - 1; i++) {
	//             goodsids[i].checked = true;
	//         }
	//         allnum = 1;
	//         selectNum = $("[type='checkbox']").length - 1;
	//         $("#badge").text(selectNum);
	//     } else {
	//         for (var i = 0; i < goodsids.length - 1; i++) {
	//             goodsids[i].checked = false;
	//         }
	//         allnum = 0;
	//         selectNum = $("[type='checked']").length;
	//         $("#badge").text(selectNum);
	//     }
	//
	// }

	function checkNo() {
		var stuids = document.getElementsByName("goodsid");
		for (var i = 0; i < stuids.length; i++) {
			stuids[i].checked = false;
		}
	}

	function delectAll() {
		if (confirm("确定删除吗？")) {
			var goodsid = document.getElementsByName("goodsid");

			var ids = [];
			for (var i = 0; i < goodsid.length; i++) {
				if (goodsid[i].checked) {
					ids[i] = goodsid[i].value;
				}
			}
			window.location.href = "/FengMi/DeletGoodsServlet?goodsid=" + ids;
		}

	}

	function batchDelete() {
		confirm.show('溫馨提示', '您确定要刪除' + selectNum + '个商品吗？', {
			'确定': {
				'primary': true,
				'callback': function () {
					$("#deleteForm").submit();
				}
			}
		});
	}

	//解决选择下拉框内容到输入框内容的问题


	function expEXCEL(url) {
		//jquery  confirm组件弹窗按钮样式
		$.confirm({
			title: '是否确认',
			content: '确认删除吗?',
			type: 'blue',
			icon: 'glyphicon glyphicon-question-sign',
			buttons: {
				ok: {
					text: '确认',
					btnClass: 'btn-primary',
					action: function () {
						location.href = url; //指向下载资源（此处为目标文件的输出数据流）
					}
				},
				cancel: {
					text: '取消',
					btnClass: 'btn-primary'
				}
			}
		});
	}
	function selectStatus(obj, id) {

		var name = $(obj).text();

		$("#dropdownMenu2").val(name);

		$("#orderStatus").val(id);
		<%--//var stuids=document.getElementById("show").value.innerHTML=${goods.goodstype.typename};--%>
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
				<li><a href="<%=path%>/UserFuzzyServlet">用户管理</a></li>
				<li class="active"><a href="<%=path%>/OrderFuzzySelectServlet">订单管理</a></li>
				<li><a href="<%=path%>/before/index.html">直通锋迷网</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">${username}</a></li>
				<li><a href="<%=path%>/LogOutServlet"><span class="glyphicon glyphicon-log-in"
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
		<h2>订单管理</h2>

	</div>
</div>
<div class="container">

	<div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-7">
			<form action="<%=path %>/OrderFuzzySelectServlet" class="form-inline" id="formForOrder">
				<div class="form-group">
					<div class="input-group" style="width: 220px;">
						<div class="input-group-addon">订单名称</div>
						<input type="text" name="username" class="form-control" style="width: 220px;"
							   id="exampleInputName"
							   placeholder="请输入订单名称"/>
					</div>
				</div>

				<div class="form-group" style="margin-left: 390px;">
					<div class="input-group" style="width: 0px;">
						<div class="input-group-addon">订单状态</div>
						<div class="dropdown">
							<input class="btn btn-primary dropdown-toggle" type="button"
								   id="dropdownMenu2" data-toggle="dropdown"
								   aria-haspopup="true" aria-expanded="false" value="订单状态" style="min-width: 105px;text-align: left;
														background-color: #337ab7;color: white;" >


							<span class="mycaret" style="position: absolute;top: 16px;right: 10px;"></span>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
								<li>
									<a onclick="selectStatus(this,1)">未付款</a>
									<a onclick="selectStatus(this,2)">已付款</a>
									<a onclick="selectStatus(this,3)">已发货</a>
									<a onclick="selectStatus(this,4)">已签收</a>
									<a onclick="selectStatus(this,5)">退货中</a>
									<input type="hidden" id="orderStatus" name="status" value=""/>
								</li>


							</ul>
						</div>

					</div>
				</div>

				<button type="submit" style="float: right;" onclick="checkValue02()" class="btn btn-primary"><span
						class="glyphicon glyphicon-search"
						style="color: white;" aria-hidden="true"></span>查询</button>
			</form>
		</div>
	</div>

</div>
<!--以下显示表格-->
<div class="container" style="margin-top: 20px;">
	<form id="deleteForm"
		  action="${pageContext.request.contextPath}/DeletGoodsServlet"
		  method="post">
		<table style="text-align: center; margin-right: 10px; width: 99%"
			   class="table table-striped table-hover table-bordered">
			<thead style="text-align: center;">
			<tr>
				<th>序号</th>
				<th>订单编号</th>
				<th>总金额</th>
				<th>订单状态</th>
				<th>下单时间</th>
				<th>用户名</th>
				<th>删除</th>

			</tr>
			</thead>
			<tbody>
			<c:forEach items="${list}" var="order" varStatus="obj">

				<tr>
					<td>${order.id}</td>
					<td>${order.orderCode}</td>
					<td>${order.totalPrice}</td>
					<td>${order.orderStatus}</td>
					<td>${order.createDate}</td>
					<td>${order.username}</td>
					<td><a class="glyphicon glyphicon-trash" color="#5BC0DE"
						   style="text-decoration: none" name="orderid"
						   href="<%=path%>/DeletOrderServlet?orderid=${order.id}"
						   onclick="if(confirm('是否确定删除该订单？')==false)return false"></a></td>
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
				   href="<%=path %>/OrderFuzzySelectServlet?pageNo=1" aria-label="Previous">
				<span aria-hidden="true">首页 </span>
			</a></li>
			<%
				if (pageNo > 1) {
			%>
			<li><a class=" btn-info"
				   href="<%=path %>/OrderFuzzySelectServlet?pageNo=${pageNo-1}"
				   aria-label="Previous"> <span aria-hidden="true"> « </span></a></li>
			<% } else {
			%>

			<li class="disabled"><a href="#" aria-label="Previous">« <span
					class="sr-only">(current) </span></a></li>
			<%
				}
				if (pageCount > pageNo) {
			%>

			<li><a class="btn"
				   href="<%=path %>/OrderFuzzySelectServlet?pageNo=${pageNo+1}">${pageNo}</a></li>
			<li><a class="btn-info"
				   href="<%=path %>/OrderFuzzySelectServlet?pageNo=${pageNo+1}&username=${user.username}"
				   aria-label="Next"><span aria-hidden="true">»</span></a></li>

			<% } else {
			%>

			<li><a class=" btn-info"
				   href="<%=path %>/OrderFuzzySelectServlet?pageNo=${pageNo}">${pageNo}</a></li>
			<li class="disabled"><a href="#" aria-label="Previous">»<span
					class="sr-only">(current) </span></a></li>
			<%
				}
			%>
			<li><a class=" btn-info"
				   href="<%=path %>/OrderFuzzySelectServlet?pageNo=${pageCount}"
				   aria-label="Previous"> <span aria-hidden="true">尾页 </span></a></li>
		</ul>
	</nav>
</div>

</table>
<br/>


</body>
</html>
