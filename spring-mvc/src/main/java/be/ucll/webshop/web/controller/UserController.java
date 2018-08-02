package be.ucll.webshop.web.controller;
import be.ucll.webshop.domain.model.Product;
import be.ucll.webshop.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/user")
public class UserController {

    private final UserService service;

    public UserController(@Autowired UserService userservice) {
        this.service = userservice;
    }

    @RequestMapping(method= RequestMethod.GET)
    public ModelAndView getProducts() {
        return new ModelAndView("users","users",service.getUsers());
    }




}
