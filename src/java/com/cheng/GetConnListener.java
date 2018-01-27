/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cheng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author james
 */
@WebListener
public class GetConnListener implements ServletContextListener {

    // 应该启动时，该方法被调用。
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ServletContext application = sce.getServletContext();
            
            // get initial parameters from web.xml.
            String driver = application.getInitParameter("driver");
            String url = application.getInitParameter("url");
            String user = application.getInitParameter("user");
            String pass = application.getInitParameter("pass");

            // Retrieve the Class object of mysql's jdbc driver, that 
            // is 'com.mysql.jdbc.Driver';
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, pass);
            // Set the achieved `Connection` instance into the `ServletContext`,
            //  so that we can retrieve it at the jsp when it was used.
            application.setAttribute("conn", conn);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GetConnListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // 应该关闭时，该方法被调用。
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        Connection conn = (Connection) application.getAttribute("conn");
        if (conn != null) {

            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
