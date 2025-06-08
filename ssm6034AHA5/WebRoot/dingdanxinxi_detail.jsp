<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>订单信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  订单信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>订单号：</td><td width='39%'>${dingdanxinxi.dingdanhao}</td>     <td width='11%'>订单金额：</td><td width='39%'>${dingdanxinxi.dingdanjine}</td></tr><tr>     <td width='11%'>订单内容：</td><td width='39%'>${dingdanxinxi.dingdanneirong}</td>     <td width='11%'>支付方式：</td><td width='39%'>${dingdanxinxi.zhifufangshi}</td></tr><tr>     <td width='11%'>购买人：</td><td width='39%'>${dingdanxinxi.goumairen}</td>     <td width='11%'>联系电话：</td><td width='39%'>${dingdanxinxi.lianxidianhua}</td></tr><tr>     <td width='11%'>地址：</td><td width='39%'>${dingdanxinxi.dizhi}</td>     <td width='11%'>备注：</td><td width='39%'>${dingdanxinxi.beizhu}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

