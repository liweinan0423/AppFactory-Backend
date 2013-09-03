package appfactory.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductsController {

    @RequestMapping("/products/promotions")
    public String getPromotions(Model model) {
        return "/products/promotions/list";
    }

    @RequestMapping("/products/categories/{id}")
    public String getProductCategories(@PathVariable("id") Long id, Model model) {



        return "/products/categories/show";
    }

    @RequestMapping("/products/{id}")
    public String getProductDetail(@PathVariable("id")Long id, Model model) {
        return "/products/show";
    }

}
