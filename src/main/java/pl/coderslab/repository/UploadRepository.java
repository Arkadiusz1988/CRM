package pl.coderslab.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.UploadFile;

import java.util.List;

public interface UploadRepository extends JpaRepository<UploadFile, Long> {

    UploadFile findByFileName(String name);
    List<UploadFile> findAllUploadByProject1Id(Long id);
}
