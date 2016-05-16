<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>编辑图书</title>
<s:head />
</head>

<body>
	<h2>
		<s:if test="null==book">增加图书
</s:if>
		<s:else>
编辑图书
</s:else>
	</h2>
	<s:form name="editForm" action="save" validate="true">
		<s:textfield label="书名" name="book.bookId" />
		<s:textfield label="作者" name="book.author" />
		<s:textfield label="内容" name="book.content" />
		<s:textfield label="来源" name="book.source"></s:textfield>
		<s:if test="null==book">
			<s:hidden name="book.id" value="%{id}" />
		</s:if>
		<s:else>
			<s:hidden name="book.id" />
		</s:else>
		<s:hidden name="queryName" />
		<s:hidden name="queryValue" />
		<s:submit value="%{getText('保存')}" />
	</s:form>
	<p>
		<a href="<s:url action="list" />">返回</a>
	</p>
</body>
</html>