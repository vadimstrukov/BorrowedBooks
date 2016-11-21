package ee.strukov.books.api.service.impl;

import ee.strukov.books.api.model.User;
import ee.strukov.books.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by strukov on 20.11.16.
 */
@Service
public class UserServiceImpl implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User %s does not exist!", email));
        }
        return new UserRepositoryUserDetails(user);
    }

    public List<User> getUsers(){
        return this.userRepository.findAll();
    }

    private final static class UserRepositoryUserDetails extends User implements UserDetails {

        private static final long serialVersionUID = 1L;

        private UserRepositoryUserDetails(User user) {
            super(user);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return getRoles();
        }

        @Override
        public String getPassword() {
            return getPass();
        }

        @Override
        public String getUsername() {
            return getEmail();
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

    }
}
