<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("input[type='submit']").on("click",function(){
			if($("#filepath").val()==""){
				return false;
			}
		});
		
		$("#filepath").on("change",function(){
			var str = $("#filepath").val();
			var patt = /(.jpg$|.gif$)/g;
			var result = str.match(patt);
			if(!result){
				alert("jpg,gif만 가능합니다.");
				return false;
			}
			
			if(this.files && this.files[0]){
				
				if(this.files[0].size>100000000){
					alert("1GB이하만 첨부할 수 있습니다.");
					$("#filepath").val("");
					
					return false;
				}
				//파일을 읽기 위한 FileReader객체 생성
				var reader=new FileReader();
				
				//File내용을 읽어 dataURL 형식의 문자열로 저장
				reader.readAsDataURL(this.files[0]);
				
				//파일 읽어들이기를 성공했을 때 호출되는 이벤트 헨들러
				reader.onload=function(e){
					//이미지 Tag의 src속성에 읽어들인 File 내용을 지정
					$('img').attr('src',e.target.result);
				};
			}
		});
	});
</script>
</head>
<body>
	<form name="frm" action="uploadMain" method="post"
		enctype="multipart/form-data">
		<p>
			<img width="100" height="100" />
		</p>
		<p>
			<span>파일</span> <input type="file" name="filepath" id="filepath" />
		</p>
		<input type="submit" value="commit" />

	</form>
</body>
</html>