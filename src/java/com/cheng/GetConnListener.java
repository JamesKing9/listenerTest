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
 * 
 javax.​servlet
public interface ServletContextListener extends EventListener

Interface for receiving notification events about ServletContext lifecycle changes.
In order to receive these notification events, the implementation class must be either declared in the deployment descriptor of the web application, annotated with WebListener, or registered via one of the addListener methods defined on ServletContext.
Implementations of this interface are invoked at their contextInitialized(javax.servlet.ServletContextEvent) method in the order in which they have been declared, and at their contextDestroyed(javax.servlet.ServletContextEvent) method in reverse order.
Since:
Servlet 2.3
See Also:
ServletContextEvent
 * @author james
 */
@WebListener
public class GetConnListener implements ServletContextListener {

    // 应该启动时，该方法被调用。
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ServletContext application = sce.getServletContext();
            String driver = application.getInitParameter("driver");
            String url = application.getInitParameter("url");
            String user = application.getInitParameter("user");
            String pass = application.getInitParameter("pass");

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
