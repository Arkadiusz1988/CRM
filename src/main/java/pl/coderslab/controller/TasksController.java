package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Project;
import pl.coderslab.entity.Tasks;
import pl.coderslab.repository.ProjectRepository;
import pl.coderslab.repository.TasksRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.AuthService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TasksController {

    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final AuthService authService;
    private final TasksRepository tasksRepository;

    public TasksController(UserRepository userRepository, ProjectRepository projectRepository, AuthService authService, TasksRepository tasksRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.authService = authService;
        this.tasksRepository = tasksRepository;
    }

    @GetMapping("/addTask")
    public String addTask(Model model) {
        model.addAttribute("task", new Tasks());
        //model.addAttribute("users",userRepository.findAll());
        model.addAttribute("userLogged",authService.getUser().getUsername());
        return "forms/addTask";
    }

    @PostMapping("/addTask")
    public String addTaskPost(@ModelAttribute("task") Tasks task) {
        List<Project> project = projectRepository.findByUsers(authService.getUser());
        task.setProject(project.get(project.size()-1));
        tasksRepository.save(task);
        return "forms/addTaskView";
    }

    @GetMapping("/addTaskById/{id}")
    public String addTaskById(@PathVariable Long id, Model model) {
        model.addAttribute("task", new Tasks());
        return "forms/addTaskById";
    }

    @PostMapping("/addTaskById/{id}")
    public String addTaskByIdPost(@PathVariable Long id, @Valid @ModelAttribute Tasks task){
        Tasks tasks = new Tasks();
        tasks.setName(task.getName());
        tasks.setDescription(task.getDescription());
        tasks.setProject(projectRepository.getOne(id));
        tasksRepository.save(tasks);
        return "redirect:/forms/showAllTaskOfProject";
    }


    @GetMapping("/showAllTaskOfProjectById/{id}")
    public String showAllTaskById(@PathVariable Long id,Model model){
        model.addAttribute("tasks", tasksRepository.findAllTaskByProjectId(id));
        return "forms/showAllTaskOfProject";
    }

    @GetMapping("/edit/{id}")
    public String showEditTaskForm(@PathVariable Long id, Model model) {
        Tasks tasks = tasksRepository.findOne(id);
        model.addAttribute("tasks", tasks);
        return "forms/editTask";

    }

    @PostMapping("/edit/{id}")
    public String editTask (@PathVariable Long id, @Valid @ModelAttribute Tasks task){
        Tasks tasks = tasksRepository.findOne(id);
        tasks.setName(task.getName());
        tasks.setDescription(task.getDescription());
        tasksRepository.save(tasks);
        return "redirect:/forms/showAllTaskOfProject";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        Tasks tasks = tasksRepository.getOne(id);
        tasksRepository.delete(tasks);
        return "redirect:/forms/showAllTaskOfProject";
    }


}
