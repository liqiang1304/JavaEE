<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<%@ page import="java.util.Date"%>
<%@ page errorPage="errorPage.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!META http-equiv="Content-Type" content="text/html; charset=GBK">
<META name="GENERATOR" content="IBM WebSphere Studio">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="theme/Master.css" rel="stylesheet"
	type="text/css">
<TITLE>CGI.html</TITLE>
<%!
   private String showDate(Date date){
		java.text.SimpleDateFormat smdate=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return smdate.format(date);
    }%>
</HEAD>
<BODY>
<%@ include file="exam_header.html"%>
<h2><center>CGI Data Input(中文)</h2>
<FORM method="post" action="servlet/CGIServlet">
<TABLE border="1" width="100%">
	<TBODY>
		<TR><TD>Input</TD>
			<TD><INPUT type="text" name="request"></TD>
		</TR>
		<TR>
			<TD><INPUT type="submit" name="submit" value="Submit"></TD>
			<TD><INPUT type="reset" value="Reset"></TD>
		</TR>
	</TBODY>
</TABLE>
<%=showDate(new Date())%>
<br><h2>
<%  Date now=new Date();
    if (now.getHours()>13){
%>
Good afternoon,
<%  } else{%>
Good morning,
<%}%>
</BODY>
</HTML>
