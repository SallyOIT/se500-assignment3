package edu.olivetuniversity.se500;

import java.text.SimpleDateFormat;

import com.google.inject.Guice;
import com.google.inject.Inject;

/**
 * Hello world!
 *
 */
public class Worker 
{
	@Inject
	private Now now;
	
	@NotOnWeekends
	public void workLikeADog() {
        String dayOfWeek = new SimpleDateFormat("EEEE").format(now.get());
        System.out.println("I am working now(" + dayOfWeek + ")...and I want to work even on weekends to make more money...");
    }
	
    public static void main( String[] args )
    {
    	Worker worker = Guice.createInjector(new CurrentTimeModule(), new NotOnWeekendsModule()).getInstance(Worker.class);
        worker.workLikeADog();
    }
}
