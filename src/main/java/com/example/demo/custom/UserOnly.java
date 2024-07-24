package com.example.demo.custom;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.security.access.prepost.PreAuthorize;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasRole('USER')")
public @interface UserOnly {
}
