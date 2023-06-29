package dev.ivrogo.todoapirest.Security;

import dev.ivrogo.todoapirest.Model.User;
import dev.ivrogo.todoapirest.Repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("The user with email " + email + " doesn't exist."));

       return new UserDetailsImpl(user);
    }
}
