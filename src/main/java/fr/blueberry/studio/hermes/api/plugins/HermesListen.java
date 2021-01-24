package fr.blueberry.studio.hermes.api.plugins;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HermesListen {
    EventPriority priority() default EventPriority.NORMAL;
    boolean ignoreCancel() default false;
}