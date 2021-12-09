package pl.coderslab.FiszkoTeka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.FiszkoTeka.entity.Users;
import pl.coderslab.FiszkoTeka.entity.Word;
import pl.coderslab.FiszkoTeka.entity.WordUser;

import java.util.List;

@Repository
public interface WordUserRepository extends JpaRepository<WordUser, Long> {
    @Query("SELECT u FROM Users u WHERE u.id = ?1")
    public Users findByUser(Long id);
    List<WordUser> findAllByUsers_Id(long userId);

}
