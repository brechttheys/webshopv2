package be.ucll.webshop.web.controller;

import be.ucll.webshop.domain.model.BasketItem;
import be.ucll.webshop.domain.model.Product;
import be.ucll.webshop.domain.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value="/basket")
public class BasketController {

    private final BasketService service;

    public BasketController(@Autowired BasketService basketservice) {
        this.service = basketservice;
    }

    @RequestMapping(value="/add/{id}")
    public ModelAndView addToBasket(@PathVariable int id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        service.addItemToBasket(new BasketItem(username,id));
        return new ModelAndView("basket","basket", service.getBasketForUser(username));
    }

    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView getBasketItemsForUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return new ModelAndView("basket","basket", service.getBasketForUser(username));
    }

}
