<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<jsp:useBean class="edu.tongji.javaee.exam.model.Customer" id="customer" scope="request"></jsp:useBean>
<%
	//edu.tongji.javaee.exam.model.Customer customer=(edu.tongji.javaee.exam.model.Customer)request.getAttribute("customer");
%>
<HTML><HEAD><TITLE>Technical Certification Exam Tool</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="Microsoft FrontPage 4.0">
<STYLE type="text/css">
<!--
. nav_passive{
	font-size: 0.4cm;
	font-family: Verdana;
	background-color: #8cfbfb;
	padding-top: 3px;
	padding-left: 3px;
	padding-right: 3px;
	padding-bottom: 3px;
}

. nav_active{
	font-size: 0.45cm;
	font-family: Arial;
	background-color: #c0c0c0;
	padding-top: 3px;
	padding-left: 3px;
	padding-right: 3px;
	padding-bottom: 3px;
	border-top-width: 1px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	border-style: inset inset inset inset;
	vertical-align: middle;
}
-->
</STYLE>
</HEAD>
<BODY bgcolor="#FFFFFF">
<TABLE width="800" cellpadding="0" cellspacing="0">
    <TBODY><TR><TD colspan="2" height="50" valign="top" align="left" width="800">
<IMG border="0" height="82" src="../images/header.gif" width="802"></TD>
      </TR></TBODY></TABLE>
<TABLE width="800" height="270" cellpadding="0" cellspacing="0">
    <TBODY><TR class="tstnav">
            <TH class="tstnav" rowspan="8" valign="top" height="132" width="155" align="right" bgcolor="#ffffa6">
            <TABLE cellspacing="0" cellpadding="0" width="155">
                <TBODY><TR><TD height="40" colspan="2">.</TD></TR>
                    <TR><TD class="nav_passive" colspan="2" width="155"><A href="/JavaEE/index.html">Home Page</A></TD>
                    </TR><TR><TD class="nav_passive" colspan="2">Update Profile</TD></TR>
                    <TR><TD class="nav_passive" colspan="2">Transcript</TD></TR>
                    <TR><TD class="nav_active" width="85">Options</TD>
                        <TD style="background-color: #cccccc" width="49" align="right"><IMG src="../images/arrow_next_rotating.gif" width="38" height="34" border="0"></TD></TR>
                    <TR><TD class="nav_passive" colspan="2">Logout</TD></TR>
                </TBODY></TABLE></TH>
            <TD width="645" style="padding-top: 5px; padding-left: 5px; padding-right: 5px; padding-bottom: 5px">
            <FONT color="#00ff00" size="5" face="Comic Sans MS">Welcome back: <jsp:getProperty name="customer" property="firstName" /></FONT><BR>
            <BR><BR><A href="/JavaEE/ExamCommand?command=displayTestAreas">List of Available Tests</A><BR>
            <BR><A href="http://www.ibm.com">Your Test Records</A><BR>
            <BR><A href="/ILSCS01/ExamCommand?command=updateProfile">Update your profile</A></TD>
        </TR></TBODY></TABLE><TABLE><TBODY>
<TR><TD colspan="2" valign="top" align="left" height="35" width="800">
    <TABLE width="797"><TBODY><TR>
                <TD align="LEFT" valign="top" width="789" colspan="2" bgcolor="#0033ff" height="22"><IMG border="0" height="19" src="../images/privacy.gif" width="53"><IMG border="0" height="19" src="../images/legal.gif" width="41"><IMG border="0" height="19" src="../images/contact.gif" width="56"></TD>
            </TR></TBODY></TABLE></TD></TR></TBODY></TABLE></BODY></HTML>
