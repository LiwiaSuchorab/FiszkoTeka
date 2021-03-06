package pl.coderslab.FiszkoTeka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.FiszkoTeka.entity.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
