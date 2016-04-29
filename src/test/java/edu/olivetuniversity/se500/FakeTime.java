package edu.olivetuniversity.se500;

import java.util.Date;

public class FakeTime implements Now {
	private Date now;

	public synchronized Date get() {
		return now;
	}
	
	public synchronized void set(Date now) {
		this.now = now;
	}

}
