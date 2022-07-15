package simplilearn.repository;

import org.springframework.data.repository.CrudRepository;

import simplilearn.entity.Release;

public interface ReleaseRepository extends CrudRepository<Release, Long>{

}
