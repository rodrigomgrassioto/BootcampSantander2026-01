package com.devrodrigo.annotation;

import java.lang.annotation.Retention;

import static com.devrodrigo.annotation.FieldFormatEnum.CAMEL_CASE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.TYPE;

@Retention(RUNTIME)
@Target(TYPE)
public @interface SerializerType  {

    FieldFormatEnum fieldFormat() default CAMEL_CASE;

    boolean prettify() default true;
}
