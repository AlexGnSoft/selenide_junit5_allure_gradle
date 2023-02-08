package smoke.product_level;

import com.coretestautomation.domain.entities.product.Product;
import com.coretestautomation.domain.steps.holders.StepsContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Product maintenance tests")
public class ProductMaintenanceLevel extends AbstractProductLevelTest{

    private static Product product;
    private static StepsContainer steps;
    private static  String NDC;
    private static  String DRUG_STRENGTH;

    @BeforeAll
    public static void prepareClientData() {
        steps = new StepsContainer();
        product = new Product();
        product.setManufacturer("Nate test 12/14/22");

        NDC = "00573-0161-65";
        DRUG_STRENGTH = "200 mg/1";
    }


    @Test
    @DisplayName("Add a new product test")
    public void addNewProduct_OR_T24() {
        //Test data
        product.setProductName("AutoTestProduct " + getRandomString());

        steps.adminSteps
                .addNewProduct(product)
                .findProduct(product);

        boolean verifyProductByName = steps.adminSteps.verifyObjectExistenceInTable(product.getProductName(), "Product Name");

        Assertions.assertTrue(verifyProductByName, "Product was not added");
    }


    @Test()
    @DisplayName("Edit product test")
    public void editProduct_OR_T46() {
        //Test data
        product.setProductName("AutoTestProduct " + getRandomString());
        Product updatedProduct = new Product();
        updatedProduct.setProductName("AutoTestProduct " + getRandomString());

        steps.adminSteps
                .addNewProduct(product)
                .findProduct(product);

        steps.adminSteps
                .updateProduct(updatedProduct)
                .findProduct(updatedProduct);

        boolean verifyProductByName = steps.adminSteps.verifyObjectExistenceInTable(updatedProduct.getProductName(), "Product Name");

        Assertions.assertTrue(verifyProductByName, "Product was not updated");
    }

    @Test
    @DisplayName("Add new Product Listing for a product")
    public void addNewProductListingForProduct_OR_T25() {
        //Test data
        Product product = new Product();
        product.setProductName("AutoTestProduct " + getRandomString());
        product.setManufacturer("Nate test 12/14/22");

        steps.adminSteps
                .addNewProduct(product)
                .addNewProductListing(product, NDC);
               //.findProductListing(product, NDC);

       // boolean verifyProductListingByName = steps.adminSteps.verifyObjectExistenceInTable(product.getProductName(), "Product Name");

       //Assertions.assertTrue(verifyProductListingByName, "Product listing was not added");
    }
}
