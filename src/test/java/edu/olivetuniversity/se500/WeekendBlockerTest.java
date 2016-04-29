package edu.olivetuniversity.se500;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.inject.Guice;
import com.google.inject.Inject;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

public class WeekendBlockerTest {

	@Inject
	private Now now;
	@Inject
	private Worker worker;
	
	@Test(expected = IllegalStateException.class)
    public void testBlockOnWeekends() throws ParseException {
		//Guice.createInjector(new FakeNowModule()).injectMembers(this);
		Guice.createInjector(new FakeNowModule(), new NotOnWeekendsModule()).injectMembers(this);
		now.set(new SimpleDateFormat("yyyy-M-d").parse("2016-4-30"));
		worker.workLikeADog();
    }
	
	@Test
    public void notBlockedOnMonday() throws ParseException {
		Guice.createInjector(new FakeNowModule(), new NotOnWeekendsModule()).injectMembers(this);
        Date monday = new SimpleDateFormat("yyyy-M-d").parse("2016-4-25");
        for (int i = 0; i < 5; i++) {
            now.set(DateUtils.addDays(monday, i));
            worker.workLikeADog();
        }
    }
}
