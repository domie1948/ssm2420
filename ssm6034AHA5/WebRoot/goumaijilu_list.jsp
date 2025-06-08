<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>购买记录查询</TITLE>
	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">购买记录列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="goumaijiluList.do" name="myform" method="post">
									查询   菜品编号：<input name="caipinbianhao" type="text" id="caipinbianhao" style='border:solid 1px #000000; color:#666666' size="12" />  菜品名称：<input name="caipinmingcheng" type="text" id="caipinmingcheng" style='border:solid 1px #000000; color:#666666' size="12" />  菜品类别：<input name="caipinleibie" type="text" id="caipinleibie" style='border:solid 1px #000000; color:#666666' size="12" />  购买人：<input name="goumairen" type="text" id="goumairen" style='border:solid 1px #000000; color:#666666' size="12" />
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td align='center'>菜品编号</td>    <td align='center'>菜品名称</td>    <td align='center'>菜品类别</td>    <td align='center'>销量</td>    <td align='center'>库存</td>    <td align='center'>价格</td>    <td align='center'>购买数量</td>    <td align='center'>购买金额</td>    <td align='center'>购买人</td>        <td  width='80' align='center'>是否审核</td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.caipinbianhao}</td>    <td>${u.caipinmingcheng}</td>    <td>${u.caipinleibie}</td>    <td>${u.xiaoliang}</td>    <td>${u.kucun}</td>    <td>${u.jiage}</td>    <td>${u.goumaishuliang}</td>    <td>${u.goumaijine}</td>    <td>${u.goumairen}</td>        <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=goumaijilu'"/></td>
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"><a href="doUpdateGoumaijilu.do?id=${u.id }">编辑</a>  <a href="deleteGoumaijilu.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a href="goumaijiluDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		 <%
			String sql="select * from goumaijilu where 1=1 ";
				if(request.getParameter("caipinbianhao")=="" ||request.getParameter("caipinbianhao")==null ){}else{String ncaipinbianhao=new String(request.getParameter("caipinbianhao").getBytes("8859_1"));if(ncaipinbianhao.contains("?")){ncaipinbianhao=request.getParameter("caipinbianhao");}sql=sql+" and caipinbianhao like '%"+ncaipinbianhao+"%'";}if(request.getParameter("caipinmingcheng")=="" ||request.getParameter("caipinmingcheng")==null ){}else{String ncaipinmingcheng=new String(request.getParameter("caipinmingcheng").getBytes("8859_1"));if(ncaipinmingcheng.contains("?")){ncaipinmingcheng=request.getParameter("caipinmingcheng");}sql=sql+" and caipinmingcheng like '%"+ncaipinmingcheng+"%'";}if(request.getParameter("caipinleibie")=="" ||request.getParameter("caipinleibie")==null ){}else{String ncaipinleibie=new String(request.getParameter("caipinleibie").getBytes("8859_1"));if(ncaipinleibie.contains("?")){ncaipinleibie=request.getParameter("caipinleibie");}sql=sql+" and caipinleibie like '%"+ncaipinleibie+"%'";}if(request.getParameter("goumairen")=="" ||request.getParameter("goumairen")==null ){}else{String ngoumairen=new String(request.getParameter("goumairen").getBytes("8859_1"));if(ngoumairen.contains("?")){ngoumairen=request.getParameter("goumairen");}sql=sql+" and goumairen like '%"+ngoumairen+"%'";}
			sql+=" order by id desc";
double goumaijinez=0;
							
							
			ResultSet RS_result=connDbBean.executeQuery(sql);
while(RS_result.next()){
				
						
						goumaijinez=goumaijinez+Float.valueOf(RS_result.getString("goumaijine")).floatValue();
						
						
			 }
			%>
		共计购买金额:<%=goumaijinez%>； 
		
			<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="goumaijiluList.do?page=1" >首页</a>
             <a href="goumaijiluList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="goumaijiluList.do?page=${page.page+1 }">下一页</a>
			<a href="goumaijiluList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
