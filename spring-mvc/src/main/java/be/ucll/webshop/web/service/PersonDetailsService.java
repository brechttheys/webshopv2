package be.ucll.webshop.web.service;

import be.ucll.webshop.domain.model.Person;
import be.ucll.webshop.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonDetailsService implements UserDetailsService {

    @Autowired
    private UserService userservice;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person user  = userservice.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new PersonPrincipal(user);
    }


}
