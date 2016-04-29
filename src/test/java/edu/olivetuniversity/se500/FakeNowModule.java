package edu.olivetuniversity.se500;

import com.google.inject.AbstractModule;

public class FakeNowModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Now.class).to(FakeTime.class).asEagerSingleton();
	}

}
