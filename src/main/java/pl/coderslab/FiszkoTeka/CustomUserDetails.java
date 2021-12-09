package pl.coderslab.FiszkoTeka;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.coderslab.FiszkoTeka.entity.Role;
import pl.coderslab.FiszkoTeka.entity.Users;
import pl.coderslab.FiszkoTeka.entity.Word;

public class CustomUserDetails implements UserDetails {

    private Users users;
    private Word word;

    public CustomUserDetails(Users users) {
        this.users = users;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = users.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return authorities;
    }


    public long getId() {
        return users.getId();
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullName() {
        return users.getFirstName() + " " + users.getLastName();
    }

}