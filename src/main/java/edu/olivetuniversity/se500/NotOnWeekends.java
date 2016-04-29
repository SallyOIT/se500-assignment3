package edu.olivetuniversity.se500;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.METHOD;

@Retention(RUNTIME) @Target(METHOD)
public @interface NotOnWeekends {

}
