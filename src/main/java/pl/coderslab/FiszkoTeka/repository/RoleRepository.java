package pl.coderslab.FiszkoTeka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.FiszkoTeka.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
