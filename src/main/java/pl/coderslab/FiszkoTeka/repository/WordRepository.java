package pl.coderslab.FiszkoTeka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.FiszkoTeka.entity.Users;
import pl.coderslab.FiszkoTeka.entity.Word;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    @Query("SELECT u FROM Users u WHERE u.id = ?1")
    public Users findByUser(Long id);
    List<Word> findAllByCategoriesId(long categoryId);

}
