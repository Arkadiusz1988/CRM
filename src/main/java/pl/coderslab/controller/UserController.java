package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.dto.UserDto;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.AuthService;
import pl.coderslab.validations.user.LoginAttemptValidationGroup;
import pl.coderslab.validations.user.RegistrationAttemptValidationGroup;

@Controller
public class UserController {

  private final AuthService authService;
  private final UserRepository userRepository;

  public UserController(AuthService authService, UserRepository userRepository) {
    this.authService = authService;
    this.userRepository = userRepository;
  }

  @GetMapping
  public String home(Model model) {
    if (!authService.isUserLoggedIn()) {
      return "redirect:/login";
    }

    model.addAttribute("user", authService.getUser());
    return "index";
  }

  @GetMapping("/login")
  public String showLoginForm(Model model) {
    if (authService.isUserLoggedIn()) {
      return "redirect:/";
    }

    model.addAttribute("user", new UserDto());
    return "forms/login";
  }

  @PostMapping("/login")
  public String login(
      @Validated(LoginAttemptValidationGroup.class) @ModelAttribute("user") UserDto loginAttempt,
      BindingResult bindingResult) {

    if (authService.isUserLoggedIn()) {
      return "redirect:/";
    }

    if (bindingResult.hasErrors()) {
      return "forms/login";
    }

    authService.setUser(userRepository.findByEmail(loginAttempt.getEmail()));
    return "redirect:/";
  }

  @GetMapping("/register")
  public String showRegisterForm(Model model) {
    if (authService.isUserLoggedIn()) {
      return "redirect:/";
    }

    model.addAttribute("user", new UserDto());
    return "forms/register";
  }

  @PostMapping("/register")
  public String register(
      @Validated(RegistrationAttemptValidationGroup.class) @ModelAttribute("user")
          UserDto registrationAttempt,
      BindingResult bindingResult) {

    if (authService.isUserLoggedIn()) {
      return "redirect:/";
    }

    if (bindingResult.hasErrors()) {
      return "forms/register";
    }

    User newUser = userRepository.save(registrationAttempt.toUser());
    authService.setUser(newUser);
    return "redirect:/";
  }

  @GetMapping("/logout")
  public String logout() {

    authService.logout();
    return "redirect:/login";
  }
}
