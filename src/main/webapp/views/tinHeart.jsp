<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>小鱼吃虾米</title>
    <style type="text/css">
        body{
            padding-top: 10px;
        }
        .all_bg{
            width: 800px;
            height: 600px;
            margin: 0px auto;
        }
        #allcanvas{
            position: relative;
            width: 800px;
            height: 600px;
            margin: 0px;
        }
        #canvas1{
            position: absolute;
            bottom: 0;
            left: 0;
            z-index: 1;
        }
        #canvas2{
            position: absolute;
            bottom: 0;
            left: 0;
            z-index: 0;
        }
    </style>
</head>
<body>
    <div class="all_bg">
        <div id="allcanvas">
            <canvas id="canvas1" width="800" height="600"></canvas>
            <canvas id="canvas2" width="800" height="600"></canvas>
        </div>
    </div>
    <script type="text/javascript" src="<%=basePath%>static/js/main.js"></script>
    <script type="text/javascript" src="<%=basePath%>static/js/commonFunctions.js"></script>
    <script type="text/javascript" src="<%=basePath%>static/js/background.js"></script>
    <script type="text/javascript" src="<%=basePath%>static/js/ane.js"></script>
    <script type="text/javascript" src="<%=basePath%>static/js/fruit.js"></script>
    <script type="text/javascript" src="<%=basePath%>static/js/mom.js"></script>
    <script type="text/javascript" src="<%=basePath%>static/js/collision.js"></script>
    <script type="text/javascript" src="<%=basePath%>static/js/baby.js"></script>
</body>

</html>