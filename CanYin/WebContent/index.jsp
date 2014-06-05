<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>智能餐饮管理系统</title>
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
<style type="text/css">
.ui-block-a, 
.ui-block-b, 
.ui-block-c 
{
background-color: lightgray;
border: 1px solid black;
height: 100px;
font-weight: bold;
text-align: center;
padding: 1px;
}
.content_left{
	float: left;
	width: 24%;
}
.content_right{
	float: right;
	width: 75%;
	height:100%;
	background: white;
}
.ui-icon-buy {
	background:url('/images/gwc.png') no-repeat 0 0;
	width: 29px;
	height:27px;
}
</style>

</head>
<body>
<div data-role="page" data-position="fixed" id="page1">
<div data-theme="b" data-role="header">
    <a data-icon="home" data-iconpos="left" >店名:长春小巷食府</a>
    <h1></h1>
    <a data-icon="buy" data-iconpos="notext" data-corners="false" data=shadow="false"> 2 </a>
</div>
		<div class="content_left">
			<ul data-role="listview">
				<li>列表项</li>
				<li>列表项</li>
				<li>列表项</li>
			</ul>


		</div>
		
		<div class="content_right">
			    <ul data-role="listview" data-inset="false">
      <li>
        <a href="#">
        <img src="http://www.w3school.com.cn/i/chrome.png">
        <h2>Google Chrome</h2>
        <p>Google Chrome is a free, open-source web browser. Released in 2008.</p>
        </a>
      </li>
      <li>
        <a href="#">
        <img src="http://cmyy.qqwcb.com/app/public/14-01/1390353175_a.jpg" width=75 height=75>
        <h2>Mozilla Firefox</h2>
        <p>Firefox is a web browser from Mozilla. Released in 2004.</p>
        </a>
        <a href="#">sf</a>
      </li>
    </ul>
		</div>
</div>
</body>
</html>