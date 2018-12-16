package pl.coderslab.validations.user;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.dto.UserDto;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidLoginAttemptValidator implements ConstraintValidator<ValidLoginAttempt, UserDto> {

  @Autowired UserRepository userRepository;

  public void initialize(ValidLoginAttempt constraint) {}

  public boolean isValid(UserDto loginAttempt, ConstraintValidatorContext context) {
    User user = userRepository.findByEmail(loginAttempt.getEmail());
    return user != null && user.passwordMatches(loginAttempt.getPassword());
  }
}
