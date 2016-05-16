<%@page pageEncoding="utf-8" contentType="text/html; charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>图书展示系统</title>
</head>
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
}

table thead tr th {
	border: 1px solid black;
	padding: 3px;
	background-color: #cccccc;
}

table tbody tr td {
	border: 1px solid black;
	padding: 3px;
}

#pc{
   width:80%;
}
</style>


<script type="text/javascript">
	function doSearch() {
		if (document.all.searchValue.value == "") {
			alert("请输入查询关键字!");
		} else {
			var value = document.all.searchValue.value;
			window.location.href = "book/list.action?queryName="
					+ document.all.searchName.value + "&&queryValue=" + value;
		}
	}
</script>
<body>

	<table align="center">
		<tr align="center">
			<td><select name="searchName">
			        <option value="id">id</option>
					<option value="bookId">书名</option>
					<option value="author">作者</option>
					<option value="content">内容</option>
					<!-- <option value="bookDate">出版日期</option> -->
					<option value="source">来源</option>
			</select> <input type="text" name="searchValue" value="" size="10" /> <input
				type="button" value="查询" onClick="doSearch();">
			</td>
		</tr>
		<tr align="center">
			<td><a href="<s:url action="list" includeParams="none"/>">全部</a>
				<a href='<s:url action="edit" ></s:url>'>增加</a>
			</td>
		</tr>
		<tr>
			<td>
				<table cellspacing="0" align="center">
					<thead>
						<tr>
						    <th>id</th>
							<th>书名</th>
							<th>作者</th>
							<th id="pc">内容</th>
							<th>来源</th>
							<th>删除</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="availableItems">
							<tr class="trs">
								<td><a
									href='<s:url action="edit" ><s:param name="id" value="id" /></s:url>'>
										<s:property value="id" /> </a>
								</td>
								<td><s:property value="bookId" /></td>
								<td><s:property value="author" /></td>
								<td><s:property value="content" /></td>
								<td><s:property value="source" /></td>

								<td><a
									href='<s:url action="delete"><s:param name="id" value="id" /></s:url>'>删除</a>
								</td>
							</tr>
						</s:iterator>
						<tr align="right">
							<td colspan="9">共<s:property value="totalRows" />行&nbsp; 第<s:property
									value="currentPage" />页&nbsp; 共<s:property
									value="pager.getTotalPages()" />页&nbsp; <a
								href="<s:url value="list.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'first'"/>
    			
    		</s:url>">首页</a>
								<a
								href="<s:url value="list.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'previous'"/>
    		</s:url>">上一页</a>
								<a
								href="<s:url value="list.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'next'"/>
    		</s:url>">下一页</a>
								<a
								href="<s:url value="list.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'last'"/>
    		</s:url>">尾页</a>
							</td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
