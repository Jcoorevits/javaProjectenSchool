package fact.it.demorest.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductService {
    private List<Product> productList= new ArrayList<>();


    public ProductService() {
        productList.add(new Product(1, "IPHONE", "This is an Awesome Iphone", 400.4, "Apple Inc"));
        productList.add(new Product(2, "Samsung", "This is an Awesome Samsung", 300.4, "Samsung Inc"));
        productList.add(new Product(3, "LG Z", "This is an Awesome LG", 200.4, "LG Inc"));
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Optional<Product> getOptionalProductById(int productId){
        return getProductList().stream().filter(p-> p.getId()==productId).findFirst();
    }
    public Product getProductById(Optional<Product> optionalProduct){
        return optionalProduct.orElse(null);
    }

    public Product addProduct(Product newProduct) {
        newProduct.setId(productList.size()+1);
        productList.add(newProduct);
        return productList.get(productList.size()-1);
    }

    public Product updateProductById(Product updateProduct, int productid) {
        Optional<Product> productOptional = getOptionalProductById(productid);
        if (productOptional.isPresent()){
            Product product = productOptional.get();
            product.setName(updateProduct.getName());
            product.setDescription(updateProduct.getDescription());
            product.setPrice(updateProduct.getPrice());
            product.setSeller(updateProduct.getSeller());
            return product;
        }
        return null;
    }
}

