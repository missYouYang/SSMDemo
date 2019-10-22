<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title></title>
</head>

<%-----------------------------------------css区------------------------------------------------------------------------------%>
<link href="<%=basePath%>static/css/normalize.css" rel="stylesheet" />
<link href="<%=basePath%>static/js/pages/bootstrap/css/bootstrap.css" rel="stylesheet" />
<link href="<%=basePath%>static/js/pages/bootstrap/css/bootstrap-table.css" rel="stylesheet" />
<link href="<%=basePath%>static/js/pages/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css" rel="stylesheet" />
<link href="<%=basePath%>static/js/pages/daterangepicker/daterangepicker.min.css" rel="stylesheet" />
<link href="<%=basePath%>static/css/pages/datepicker.css" rel="stylesheet" />

<%--首页样式--%>
<link href="<%=basePath%>static/css/home.css" rel="stylesheet" />
<%--公共样式--%>
<link href="<%=basePath%>static/css/pages/common.css" rel="stylesheet" />
<%-----------------------------------------js区------------------------------------------------------------------------------%>
<script src="<%=basePath%>static/js/pages/jquery/jquery-3.4.1.js" type="text/javascript"></script>
<script src="<%=basePath%>static/js/pages/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=basePath%>static/js/pages/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js" type="text/javascript"></script>
<script src="<%=basePath%>static/js/pages/daterangepicker/daterangepicker.min.js" type="text/javascript"></script>
<script src="<%=basePath%>static/js/pages/bootstrap/js/datepicker.js" type="text/javascript"></script>
<script src="<%=basePath%>static/js/pages/bootstrap/js/bootstrap-table.js" type="text/javascript"></script>
<script src="<%=basePath%>static/js/pages/bootstrap/js/bstime.js" type="text/javascript"></script>

<!--[if lt IE 9]>
<script src="<%=basePath%>static/js/pages/html5shiv/3.7.0/html5shiv.js" type="text/javascript"></script>
<script src="<%=basePath%>static/js/pages/respond.js/1.4.2/respond.min.js" type="text/javascript"></script>
<![endif]-->
<%--<script src="<%=basePath%>index.js" type="text/javascript"></script>--%>

</html>
