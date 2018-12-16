package pl.coderslab.validations.user;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {UniqueEmailValidator.class})
public @interface UniqueEmail {

  String message() default "{errors.registration.nonUniqueEmail}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
