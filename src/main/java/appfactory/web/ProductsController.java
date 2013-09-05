package appfactory.web;


import appfactory.dto.ProductData;
import appfactory.model.Product;
import appfactory.model.ProductCategory;
import appfactory.repositories.ProductCategoryRepository;
import appfactory.repositories.ProductRepository;
import appfactory.services.ProductService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductsController {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/products/promotions")
    public String getPromotions(Model model) {
        return "/products/promotions/list";
    }

    @RequestMapping("/products/categories")
    public String getProductCategories(Model model) {

        List<ProductCategory> productCategories = productCategoryRepository.findAll();
        model.addAttribute("productCategories", productCategories);

        return "/products/categories/list";
    }

    @RequestMapping("/products/categories/new")
    public String showCreateCategoryForm(Model model) {
        model.addAttribute(new ProductCategory());
        return "/products/categories/new";
    }

    @RequestMapping(value = "/products/categories", method = RequestMethod.POST)
    public String createCategory(@Valid ProductCategory category, BindingResult result, MultipartFile icon) throws IOException {

        if (result.hasErrors()) {
            return "/products/categories/new";
        }

        productService.createCategory(category, icon, servletContext.getRealPath("/"));

        return "redirect:/products/categories";
    }

    @RequestMapping("/products/categories/{id}/edit")
    public String editCategory(@PathVariable("id")Long id, Model model) {
        ProductCategory category = productCategoryRepository.findOne(id);
        model.addAttribute("productCategory", category);

        return "/products/categories/edit";
    }

    @RequestMapping(value = "/products/categories", method = RequestMethod.PATCH)
    public String updateCategory(@Valid ProductCategory category, BindingResult result) {
        if (result.hasErrors()) {
            return "/products/categories/edit";
        }

        ProductCategory old = productCategoryRepository.findOne(category.getId());

        old.setName(category.getName());
        old.setDesc(category.getDesc());

        productCategoryRepository.save(old);

        return "redirect:/products/categories";

    }

    @RequestMapping(value = "/products/categories/{id}", method = RequestMethod.DELETE)
    public String deleteCategory(@PathVariable("id") Long id) {

        ProductCategory category = productCategoryRepository.findOne(id);

        FileUtils.deleteQuietly(new File(servletContext.getRealPath("/" + category.getIconURL())));

        productCategoryRepository.delete(id);


        return "redirect:/products/categories";
    }

    @RequestMapping("/products/categories/{id}")
    public String showCategoryDetail(@PathVariable("id") Long id, Model model) {


        return "/products/categories/show";
    }

    @RequestMapping("/products/{id}")
    public String getProductDetail(@PathVariable("id")Long id, Model model) {
        return "/products/show";
    }

    @RequestMapping("/products")
    public String listAllProducts(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);

        return "/products/list";
    }

    @RequestMapping("/products/new")
    public String newProduct(Model model) {
        model.addAttribute("productData", new ProductData());
        return "/products/new";
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String createProduct(ProductData productData, BindingResult result) {



        return "redirect:/products";
    }

}
