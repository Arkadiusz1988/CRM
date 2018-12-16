package pl.coderslab.validations.user;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

  @Autowired UserRepository userRepository;

  public void initialize(UniqueEmail constraint) {}

  public boolean isValid(String email, ConstraintValidatorContext context) {
    return email == null || userRepository.findUserByEmail(email) == null;
  }
}
