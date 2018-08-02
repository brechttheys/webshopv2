package be.ucll.webshop.web.controller;

import be.ucll.webshop.domain.model.Person;
import be.ucll.webshop.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/rest/user")
public class UserRESTController {

    private final UserService service;

    public UserRESTController(@Autowired UserService userservice) {
        this.service = userservice;
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Person createUser(@RequestBody Person newUser) {
        Person user = newUser;
        service.saveUser(user);
        return user;
    }
}
