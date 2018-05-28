package be.ucll.webshop.web.controller;

import be.ucll.webshop.domain.model.Product;
import be.ucll.webshop.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value="/rest/products")
public class ProductRESTController {

    private final ProductService service;

    public ProductRESTController(@Autowired ProductService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Product> getProducts() {
        return service.getProductsAsList();
    }
}
