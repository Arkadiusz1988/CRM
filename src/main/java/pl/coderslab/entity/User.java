package pl.coderslab.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.validations.user.LoginAttemptValidationGroup;
import pl.coderslab.validations.user.ValidLoginAttempt;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity
@ValidLoginAttempt(groups = LoginAttemptValidationGroup.class)
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty private String username;

  @NotEmpty private String password;

  @Transient private String plainTextPassword;

  private Boolean enabled;

  // NOTE domyslny regex w tej adnotacji to .*,
  // co oznacza że validacja przepuszczałaby pusty string.
  @Email(regexp = ".+")
  private String email;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    // NOTE w przypadku gdy hasło jest pustym stringiem/nullem, funkcja hashpw zadziała i wygeneruje
    // nie-nullowego hasha
    // chcemy tego uniknąć:)
    this.password =
        password == null || password.isEmpty()
            ? password
            : BCrypt.hashpw(password, BCrypt.gensalt());
  }

  public boolean passwordMatches(String plainTextPassword) {
    return BCrypt.checkpw(plainTextPassword, this.password);
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("username='" + username + "'")
        .add("password='" + password + "'")
        .add("enabled=" + enabled)
        .add("email='" + email + "'")
        .toString();
  }
}
