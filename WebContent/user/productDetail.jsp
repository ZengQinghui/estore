<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath %>" />
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<meta name="description" content="杰普电子商务门户">
		<title>杰普电子商务门户</title>
		<LINK href="css/main.css" rel=stylesheet>
		<script language = "JavaScript" src = "js/main.js"></script>
	</head>
	<body onLoad="MM_preloadImages('images/index_on.gif','images/reg_on.gif','images/order_on.gif','../images/top/topxmas/jp_on.gif','../images/top/topxmas/download_on.gif','../images/top/topxmas/bbs_on.gif','../images/top/topxmas/designwz_on.gif')" topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
		<c:import url="/header.jsp"></c:import>

<!--文件体开始-->
		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="middle">
                  <a href=index.jsp>杰普电子商务门户</a> → 产品明细
                </td>
                </tr>
		</table>
              <br>

		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif" colspan="2"><p><font color="#ffffff"><b>${book.name }</b></font></td>
		</tr>
		<tr>
			<td class=tablebody1 valign=middle align=center width="20%">【
			作&nbsp; 者 】</td>
			<td class=tablebody1 valign=middle width="80%">&nbsp;&nbsp;孙卫琴</td>
		</tr>
		<tr>
			<td class=tablebody1 valign=middle align=center width="20%">【
			价&nbsp; 格 】</td>
			<td class=tablebody1 valign=middle width="80%">&nbsp;&nbsp;${book.price }</td>
		</tr>
		<tr>
			<td class=tablebody1 valign=middle align=center width="">【出 版 社】</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;电子工业出版社</td>
		</tr>
		<tr>
			<td class=tablebody1 valign=middle align=center width="">【 书&nbsp; 号
			】</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;${book.id }</td>
		</tr>
		<tr>
			<td class=tablebody1 valign=middle align=center width="">【 页&nbsp; 码
			】</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;600</td>
		</tr>
		<tr>
			<td class=tablebody1 valign=middle align=center width="">【所属类别】</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;软件与程序设计</td>
		</tr>
		<tr>
			<td class=tablebody1 align=center width="" valign="top">【 简&nbsp; 介
			】</td>
			<td class=tablebody1 valign=middle width="">　　孙卫琴的计算机书籍 创作心得:<br>

　　如果说书的结构好比房屋的框架，书的内容则好比房屋的具体组成元素。计算机书的内容的形式分为：文字、 表格、图和范例。为了把某种知识讲清楚，常常需要综合使用这四种形式的元素......
:<br>
　　继《Tomcat 与 Java Web开发技术详解(含光盘)》和《精通Struts：基于MVC的Java Web设计与开发(含光盘)》之后，应广大读者的强烈要求，孙卫琴的又一力作《精通Hibernate：Java对象持久化技术详解》，正处在迎接面市的准备当中。
Hibernate是一个基于Java的开放源代码的持久化中间件，它对JDBC作了轻量级封装，不仅提供ORM映射服务，还提供数据查询和数据缓存功能，Java开发人员可以方便的通过Hibernate API来操纵数据库。
现在，越来越多的Java开发人员把Hibernate作为企业应用和关系数据库之间的中间件，以节省和对象持久化有关的30%的JDBC编程工作量。 2005年，Hibernate作为优秀的类库和组件，荣获了第15届Jolt大奖。Hibernate之所以能够流行，归功于它特有的优势。<br>
　　本书结合大量典型的实例，详细介绍了运用目前最成熟的Hibernate2.1版本进行Java对象持久化的技术。Hibernate是连接Java 对象模型和关系数据模型的桥梁，通过本书，读者不仅能掌握用Hibernate工具对这两种模型进行映射的技术，还能获得设计与开发Java对象模型和关系数据模型的先进经验。</td>
		</tr>
		<tr>
			<td class=tablebody1 valign=middle align=center width="">　</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<img border="0" src="images/product/zcover2.gif" width="127" height="180"></td>
		</tr>
		<tr>
			<td class=tablebody2 valign=middle align=center colspan="2"><a href="user/ShoppingCarAddServlet?id=${book.id }">
			<img border="0" src="images/buycar.gif" width="92" height="21"></a> </td>
		</tr>
		</table>

<!--文件尾开始-->
		<c:import url="/footer.jsp"></c:import>
	</body>
</html>
    