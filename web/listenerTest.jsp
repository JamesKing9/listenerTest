<%-- 
    Document   : listenerTest
    Created on : Jan 27, 2018, 5:36:39 PM
    Author     : james
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>测试ServletContextListener</title>
    </head>

    <h1>下面时直接从 application 中取出数据库连接，并执行查询后的结果：</h1>

    <%
        // The 'conn' attribute was put in at `GetConnListener.java`;
        // This usage also demonstrate the `ServletContext` is a global variable.
        Connection conn = (Connection) application.getAttribute("conn");
        Statement stmt = conn.createStatement();
        String sql = "select * from news_inf";
        ResultSet rs = stmt.executeQuery(sql);
    %>

    <table>
        <%
            while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getString(1)%></td>
            <td><%=  rs.getString(2)%></td>
        </tr>
        <%
            }
        %>


    </table>
    <style type="text/css">
        table {
            background-color: #F00;
        }
        td {
            background-color: bisque;
            font-family: monospace;
            font-size: 20pt;
        }
    </style>
</html>
