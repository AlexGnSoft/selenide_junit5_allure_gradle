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
                .findProductOnProductMaintenance(product);

        boolean verifyProductByName = steps.adminSteps.verifyObjectExistenceInProductMaintenanceTable(product.getProductName(), "Product Name");

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
                .findProductOnProductMaintenance(product);

        steps.adminSteps
                .updateProduct(updatedProduct)
                .findProductOnProductMaintenance(updatedProduct);

        boolean verifyProductByName = steps.adminSteps.verifyObjectExistenceInProductMaintenanceTable(updatedProduct.getProductName(), "Product Name");

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
                .addNewProductListing(product,  DRUG_STRENGTH, NDC)
                .findProductOnListingMaintenance(product);

        boolean verifyProductListingByName = steps.adminSteps.verifyObjectExistenceInProductListingMaintenanceTable(product.getProductName(), "Product Name");
        boolean isNdcCorrect = steps.adminSteps.isNdcCorrect(NDC);
        boolean strengthCorrect = steps.adminSteps.isStrengthCorrect(DRUG_STRENGTH);

        Assertions.assertTrue(verifyProductListingByName, "Product listing was not added");
        Assertions.assertTrue(isNdcCorrect, "Product NDC was not added");
        Assertions.assertTrue(strengthCorrect, "Product Strength was not added");

    }
}
