﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>购买记录详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  购买记录详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>菜品编号：</td><td width='39%'>${goumaijilu.caipinbianhao}</td>     <td width='11%'>菜品名称：</td><td width='39%'>${goumaijilu.caipinmingcheng}</td></tr><tr>     <td width='11%'>菜品类别：</td><td width='39%'>${goumaijilu.caipinleibie}</td>     <td width='11%'>销量：</td><td width='39%'>${goumaijilu.xiaoliang}</td></tr><tr>     <td width='11%'>库存：</td><td width='39%'>${goumaijilu.kucun}</td>     <td width='11%'>价格：</td><td width='39%'>${goumaijilu.jiage}</td></tr><tr>     <td width='11%'>购买数量：</td><td width='39%'>${goumaijilu.goumaishuliang}</td>     <td width='11%'>购买金额：</td><td width='39%'>${goumaijilu.goumaijine}</td></tr><tr>     <td width='11%'>购买人：</td><td width='39%'>${goumaijilu.goumairen}</td>     <td width='11%'>备注：</td><td width='39%'>${goumaijilu.beizhu}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

