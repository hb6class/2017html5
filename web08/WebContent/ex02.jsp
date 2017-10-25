<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css" rel='stylesheet'>
	div{
		width: 500px;
		height: 200px;
		background-color: gray;
	}
	p{
		width: 300px;
		height: 100px;
		background-color: green;
		position: absolute;
		top: 0px;
	}
</style>
	<script type="text/javascript">
	/* 이벤트 버블링(<->캡쳐링) */
	window.onload=function(){

		var div=document.querySelector("div");
		var p =document.querySelector("p");
		
		var listener=function(e){
			e.stopPropagation();//전파~~x
			console.log(this+'클릭이벤트');
		};
		div.addEventListener('click', listener,true);
		p.addEventListener('click', listener,true);
		/* 
		div.onclick=function(){
			console.log('div태그 클릭이벤트');
		};
		
		p.onclick=function(e){
			//익스플로어(~ver9) e.cancelBubble=true;
			e.stopPropagation();
			console.log('p태그 클릭이벤트');
		};
		 */
		 
		 
	};
	
	</script>
</head>
<body>
	<div>
		<p>클릭</p>
	</div>
</body>
</html>








