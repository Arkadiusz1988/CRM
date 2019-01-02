package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dto.UserDto;
import pl.coderslab.entity.Project;
import pl.coderslab.entity.User;
import pl.coderslab.repository.ProjectRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.AuthService;

import javax.validation.Valid;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final AuthService authService;

    public ProjectController(UserRepository userRepository, ProjectRepository projectRepository, AuthService authService) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.authService = authService;
    }

    @GetMapping("/addPro")
    public String addPro(Model model) {
        model.addAttribute("project", new Project());
       // model.addAttribute("users",userRepository.findAll());
        model.addAttribute("userLogged",authService.getUser().getUsername());
        return "forms/addPro";
    }

    @PostMapping("/addPro")
    public String addProPost(@ModelAttribute("project") Project pro) {
        User tmp = userRepository.findUserByEmail(authService.getUser().getEmail());
        pro.getUsers().add(tmp);
        projectRepository.save(pro);
        return "redirect:/task/addTask";
    }

    @GetMapping("/showAllProjectOfUser")
    public String showAllprojectOfUsers(Model model){
        model.addAttribute("projects",projectRepository.findAll());
        return "forms/showAllProjectOfUser";
    }

    @GetMapping("/edit/{id}")
    public String showEditProjectForm(@PathVariable Long id, Model model) {
        Project project = projectRepository.findOne(id);
        model.addAttribute("project", project);
        return "forms/editPro";

    }

    @PostMapping("/edit/{id}")
    public String editProject (@PathVariable Long id, @Valid @ModelAttribute Project project){
        Project project1 = projectRepository.findOne(id);
        project1.setName(project.getName());
        project1.setDescription(project.getDescription());
        project1.setProjectStatusEnum(project.getProjectStatusEnum());
        project1.setProjectPrioEnum(project.getProjectPrioEnum());
        projectRepository.save(project1);
        return "redirect:/forms/showAllProjectOfUser";
    }

    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable Long id) {
        Project project = projectRepository.findOne(id);
        projectRepository.delete(project);
        return "redirect:/forms/showAllProjectOfUser";
    }

//    @GetMapping("/showLast3Pro")
//    public String showLast3Pro(Model model) {
//        model.addAttribute("projects",projectRepository.findTop3ByOrderByIdDesc());
//       // model.addAttribute("userLogged",authService.getUser().getUsername());
//        return "forms/showLast5Pro";
//    }


}
