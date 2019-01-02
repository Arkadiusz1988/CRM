package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Project;
import pl.coderslab.entity.Tasks;

import java.util.List;

public interface TasksRepository extends JpaRepository<Tasks, Long> {

    List<Tasks> findAllTaskByProjectId(Long id);
    //List<Tasks> findAllByProject(Project project);

}
