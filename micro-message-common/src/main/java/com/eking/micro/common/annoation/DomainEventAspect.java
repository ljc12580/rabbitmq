package com.eking.micro.common.annoation;

import java.lang.annotation.*;

/**
 * Created by Jaye on 2017/7/11.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DomainEventAspect {
    String description() default "";
}
