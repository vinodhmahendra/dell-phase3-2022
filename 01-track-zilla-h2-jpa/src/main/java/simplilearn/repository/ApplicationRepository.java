package simplilearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import simplilearn.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer>{

}
