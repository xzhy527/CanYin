<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
<title>开台操作</title>
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
			      </li>
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
	<form method="post" action="gettables.do">
      <fieldset data-role="controlgroup" id="tablepos">
      </fieldset>
	</form>
		
		<!--
			<ul data-role="listview" id="tablesort">
			 <li><a data-role="che"></a></li>
			</ul>

 		 -->
		</div>
		
		<div class="content_right" id="showtables">
			  <ul data-role="listview" data-inset="false">
			  	 <li>fdsafdsa</li>
	
			      <li>
			        <a href="#">
			        	<img src="images/6rt.png" width=75 height=75>
			        	<h1>你好</h1>
			        	<p>sdf</p>	
			        </a>
			      </li> 
	         </ul>
      </div>
</div>
</body>

<script type="text/javascript">
$(function(){
    $.getJSON("gettablepos.do",function(json){    	
    	for(var i=0;i<json.length;i++){
    		var _elem=$("<label for='"+json[i].charvalue+"'>"+json[i].charvalue+"</label>"+"<input type='checkbox' name='pos' id='"+json[i].charvalue+"' value='"+json[i].charvalue+"' onclick='readtable()'>");    		
    		$("#tablepos").append(_elem);
    	}
    	$("#tablepos").trigger("create");
	});
    $.getJSON("gettabletype.do",function(json){    	
    	for(var i=0;i<json.length;i++){
    		var _elem=$("<label for='"+json[i].charvalue+"'>"+json[i].charvalue+"</label>"+"<input type='checkbox' name='type' id='"+json[i].charvalue+"' value='"+json[i].charvalue+"' onclick='readtable()'>");    		
    		$("#tablepos").append(_elem);
    	}
    	$("#tablepos").trigger("create");
	});
});
function readtable(){
	var formparam=$("form").serialize();
	
	$.post("gettables.do",formparam,function(json){
	/*	
	      <li>
	        <a href="#">
	        	<img src="images/6rt.png" width=75 height=75>
	        	<h1>你好</h1>
	        	<p>sdf</p>	
	        </a>
	      </li> 
		
		*/
			$("#showtables").html("");
			var $ul=$("<ul data-role='listview' data-inset='false'></ul>");
			
			for(var i=0;i<json.length;i++){
				/* 对桌台的业务判读以及分类处理说明*/
				var $li=$('<li><a href="#">'
				+'<img src="images/6rt.png" width=75 height=75>'
				+'<h1>'+json[i].tablename+'</h1>'
				+'<p>'+json[i].starttime+'</p>'
				+'</a></li>');				
				$ul.append($li);	
			}
			$("#showtables").html($ul);
		   $("ul").listview();   
			//$ul.listview("refresh");
			
	},"json");	
}






</script>



</html>