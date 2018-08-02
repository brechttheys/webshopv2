package be.ucll.webshop.web.controller;

import be.ucll.webshop.domain.model.Product;
import be.ucll.webshop.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

@Controller
@RequestMapping(value="/product")
public class ProductController {

    private final ProductService service;

    public ProductController(@Autowired ProductService service) {
        this.service = service;
    }


    @RequestMapping(method= RequestMethod.GET)
    public ModelAndView getProducts() {
        return new ModelAndView("products","products",service.getProducts());
    }

    @RequestMapping(value= "/new", method = RequestMethod.GET)
    public ModelAndView getNewForm() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("productAction", "/product/new.htm");
        mav.addObject("product",new Product());
        mav.setViewName("productForm");
        return mav;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String save(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "productForm";
        }
        service.addProduct(product);
        return "redirect:/product.htm";
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView getEditForm(@PathVariable int id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("productAction", "/product/edit/" + id + ".htm");
        mav.addObject("product",service.getProduct(id));
        mav.setViewName("productForm");
        return mav;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public String update(@Valid Product product, BindingResult result, @PathVariable int id) {
        if (result.hasErrors()) {
            return "productForm";
        }
        service.updateProduct(id, product);
        return "redirect:/product.htm";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable int id) {
        service.removeProduct(id);
        return "redirect:/product.htm";
    }

}
