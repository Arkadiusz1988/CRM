package pl.coderslab.validations.user;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
@Constraint(validatedBy = ValidLoginAttemptValidator.class)
public @interface ValidLoginAttempt {

  String message() default "{errors.login.invalidAttempt}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
