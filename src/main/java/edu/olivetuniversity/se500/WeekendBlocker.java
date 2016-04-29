package edu.olivetuniversity.se500;

import java.util.Calendar;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.LONG;
import static java.util.Locale.ENGLISH;
import java.util.GregorianCalendar;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.google.inject.Inject;

public class WeekendBlocker implements MethodInterceptor {
	
	@Inject
	private Now now;
	
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Calendar today = new GregorianCalendar();
		today.setTime(now.get());
		if (today.getDisplayName(DAY_OF_WEEK, LONG, ENGLISH).startsWith("S")) {
			throw new IllegalStateException(
		    		  invocation.getMethod().getName() + " not allowed on weekends!");
		}

		return invocation.proceed();
	}

}
