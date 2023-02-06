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

    @BeforeAll
    public static void prepareClientData() {
        steps = new StepsContainer();
        product = new Product();
        product.setManufacturer("Nate test 12/14/22");
    }


    @Test
    @DisplayName("Add a new product test")
    public void addNewProduct_OR_T24() {
        Assertions.assertTrue(true);
        //Test data
        product.setProductName("AutoTestProduct " + getRandomString());

        steps.adminSteps
                .addNewProduct(product)
                .findProduct(product);

        boolean verifyProductByName = steps.adminSteps.verifyObjectExistenceInTable(product.getProductName(), "Product Name");

        Assertions.assertTrue(verifyProductByName, "Product was not added");
    }
}
