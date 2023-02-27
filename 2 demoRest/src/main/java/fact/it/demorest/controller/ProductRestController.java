package fact.it.demorest.controller;

import fact.it.demorest.model.ProductService;
import fact.it.demorest.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductRestController {
    private ProductService productService;

    @PostConstruct
    public void fillProductServiceWithProducts() {
        productService = new ProductService();
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getProductList();
    }   

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int productId) {
        Optional<Product> product = productService.getOptionalProductById(productId);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("product/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product newProduct){
        return productService.addProduct(newProduct);
    }

    @PutMapping("product/update/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product updateProduct, @PathVariable("id") int productid){
        Product product = productService.updateProductById(updateProduct, productid);
        if (product==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @DeleteMapping("product/delete/{id}")
    public ResponseEntity<Integer> deleteProduct(@PathVariable("id") int productid){
        Optional<Product> product = productService.getOptionalProductById(productid);
        if (product.isPresent()){
            productService.getProductList().remove(product.get());
            return new ResponseEntity<>(productService.getProductList().size(), HttpStatus.OK);
        }
        return new ResponseEntity<>(productService.getProductList().size(), HttpStatus.NOT_FOUND);
    }
}
