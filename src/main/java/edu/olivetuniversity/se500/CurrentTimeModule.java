package edu.olivetuniversity.se500;

import com.google.inject.AbstractModule;

public class CurrentTimeModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Now.class).to(CurrentTime.class);
	}

}
