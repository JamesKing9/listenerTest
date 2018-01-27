# listenerTest

## ServletContextListener
```java
package javax.servlet

public interface ServletContextListener extends EventListener
```
- Interface for receiving notification events about ServletContext lifecycle changes.
- In order to receive these notification events, the implementation class must be either declared in the deployment descriptor of the web application, annotated with WebListener, or registered via one of the addListener methods defined on ServletContext.
- Implementations of this interface are invoked at their contextInitialized(javax.servlet.ServletContextEvent) method in the order in which they have been declared, and at their contextDestroyed(javax.servlet.ServletContextEvent) method in reverse order.
- Since:
    - Servlet 2.3
- See Also:
    - ServletContextEvent
