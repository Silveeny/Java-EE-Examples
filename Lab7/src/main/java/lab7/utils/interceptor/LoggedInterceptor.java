package lab7.utils.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
// Also in beans.xml - from course slides
@Logged
@Interceptor
public class LoggedInterceptor implements Serializable {

  @AroundInvoke
  public Object logMethodEntry(InvocationContext invocationContext)
    throws Exception {
    System.out.println("Entering method: "
    + invocationContext.getMethod().getName() + " in class "
    + invocationContext.getMethod().getDeclaringClass().getName());
    return invocationContext.proceed();
  }
}