package be.ucll.webshop.web.controller;

import be.ucll.webshop.domain.model.Product;
import be.ucll.webshop.domain.service.ProductService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value="/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Product createProduct(@RequestBody Product newProduct) {
        Product prod = newProduct;
        service.addProduct(prod);
        return prod;
    }

    @RequestMapping(value="/delete/{id}",method= RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.GONE)
    @ResponseBody
    public String deleteProduct(@PathVariable int id) {
        service.removeProduct(id);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode childNode = mapper.createObjectNode();
        childNode.put("delete",id);
        String json = null;
        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(childNode);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return json;
    }

}
