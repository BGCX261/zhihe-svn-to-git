//$Id: NotNull.java,v 1.1 2010/08/06 06:23:00 kfzx-xiezc Exp $
package org.lps.hibernate.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.hibernate.validator.ValidatorClass;


@Documented
@ValidatorClass(NotNullValidator.class)
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface NotNull {
	String message() default "{validator.notNull}";
}
