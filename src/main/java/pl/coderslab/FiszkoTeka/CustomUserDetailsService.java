package pl.coderslab.FiszkoTeka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.coderslab.FiszkoTeka.entity.Users;
import pl.coderslab.FiszkoTeka.repository.UsersRepository;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.getUserByUsername(username);
        if (users == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(users);
    }
}
