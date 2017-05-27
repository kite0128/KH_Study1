<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('[name=searchBtn]').bind('click', function() {
			$('form').attr('action', 'list.do');
			$('form').submit();
		});

	/* 	var searchKey = "${param.searchKey}";
		var searchWord = "${param.searchWord}";

		switch (searchKey) {
		case "all":
			$("option[value=all]").prop("selected", "selected");
			break;
		case "subject":
			$("option[value=subject]").prop("selected", "selected");
			break;
		case "writer":
			$("option[value=writer]").prop("selected", "selected");
			break;
		}
		$("input[name=searchWord]").val(searchWord); */

		$('[name=searchWord]').val('${pdto.searchWord}');
		switch ('${pdto.searchKey}') {
		case 'all':
			$('[value=all]').prop('selected', 'selected');
			$('[name=searchWord]').val('');
			break;
		case 'subject':
			$('[value=subject]').prop('selected', 'selected');
			break;
		case 'writer':
			$('[value=writer]').prop('selected', 'selected');
			break;
		}
		
	});
</script>
</head>
<body>
	<div class="wrap">
		<p>
			<a href="writeForm.do">글쓰기</a>
		</p>

		<form name="frm">
			<select name="searchKey">
				<option value="all">전체</option>
				<option value="subject">제목</option>
				<option value="writer">글쓴이</option>
			</select> <input type="text" name="searchWord" /> <input type="button"
				name="searchBtn" value="검색" />
		</form>

		<%-- <form name="frm">
			<select name="searchKey">
				<c:choose>
					<c:when test="${empty pdto.searchKey || pdto.searchKey=='all'} ">
						<option value="all" selected="selected">전체</option>
					</c:when>
					<c:otherwise>
						<option value="all">전체</option>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${pdto.searchKey=='subject'}">
						<option value="subject" selected="selected">제목</option>
					</c:when>
					<c:otherwise>
						<option value="subject">제목</option>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${pdto.searchKey=='writer'}">
						<option value="writer" selected="selected">글쓴이</option>
					</c:when>
					<c:otherwise>
						<option value="writer">글쓴이</option>
					</c:otherwise>
				</c:choose>
			</select>

			<c:choose>
				<c:when test="${empty pdto.searchKey || pdto.searchKey=='all'}">
					<input type="text" name="searchWord" value="" />
				</c:when>
				<c:otherwise>
					<input type="text" name="searchWord" value="${pdto.searchWord}" />
				</c:otherwise>
			</c:choose>
			<input type="button" name="searchBtn" value="검색" />
		</form>
 --%>
		<table>
			<tr>
				<th>num</th>
				<th>subject</th>
				<th>writer</th>
				<th>readcount</th>
				<th>file</th>
			</tr>

			<c:forEach var="dto" items="${requestScope.aList}">
				<tr>
					<td>${dto.num}</td>
					<td><c:if test="${dto.re_level>0}">
							<img src="../guestview/images/level.gif" height=0
								width="${15*dto.re_level}" />
							<img src="../guestview/images/re.gif" />
							<!-- ..은 상위폴더로 .은 현재 자신의 폴더 -->
						</c:if> <%-- <a href="view.do?num=${dto.num}">${dto.subject}</a> --%> <c:url
							var="link" value="view.do">
							<c:param name="num" value="${dto.num}" />
							<c:param name="pageNum" value="${pdto.currentPage}" />
							<c:param name="searchKey" value="${pdto.searchKey}" />
							<c:param name="searchWord" value="${pdto.searchWord}" />
						</c:url> <a href="${link}">${dto.subject}</a></td>
					<td>${dto.writer}</td>
					<td>${dto.readcount}</td>
					<td><c:if test="${!empty dto.upload}">
							<img src="../guestview/images/save.gif" />
						</c:if></td>
				</tr>
			</c:forEach>
		</table>

		<!-- 페이지 -->
		<c:forEach var="i" begin="${pdto.startPage}" end="${pdto.endPage}">
			<span><a
				href="list.do?pageNum=${i}&searchKey=${pdto.searchKey}&searchWord=${pdto.searchWord}">${i}</a></span>
		</c:forEach>

		<!-- 다음 -->
		<c:if test="${pdto.totalPage>pdto.endPage}">
			<span><a
				href="list.do?pageNum=${pdto.startPage+pdto.blockPage}&searchKey=${pdto.searchKey}&searchWord=${pdto.searchWord}">다음</a></span>
		</c:if>

		<!-- 이전 -->
		<c:if test="${pdto.startPage>1}">
			<span><a
				href="list.do?pageNum=${pdto.startPage-pdto.blockPage}&searchKey=${pdto.searchKey}&searchWord=${pdto.searchWord}">이전</a></span>
		</c:if>
	</div>
</body>
</html>