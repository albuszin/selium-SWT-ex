package BAITAP;

import driver.driverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class testcase06 {
    @Test
    public void runPurchaseProductTest() {
        // 1. Initialize the WebDriver
        WebDriver driver = driverFactory.getChromeDriver();

        try {
            // 2. Navigate to the website
            driver.get("http://live.techpanda.org/");

            // 3. Click on the "Account" link
            WebElement accountLink = driver
                    .findElement(By.xpath("//span[@class='label'][normalize-space()='Account']"));
            accountLink.click();

            // 4. Click on the "Log In" link
            WebElement loginLink = driver.findElement(By.xpath("//a[@title='Log In']"));
            loginLink.click();

            // 5. Fill in the email address field
            WebElement emailInput = driver.findElement(By.xpath("//input[@id='email']"));
            emailInput.sendKeys("phucthien0410@gmail.com");

            // 6. Fill in the password field
            WebElement passwordInput = driver.findElement(By.xpath("//input[@id='pass']"));
            passwordInput.sendKeys("maylaconcho123");

            // 7. Submit the login form
            WebElement loginButton = driver.findElement(By.xpath("//button[@id='send2']"));
            loginButton.click();

            // Add a sleep time (e.g., 5 seconds) after logging in
            try {
                Thread.sleep(5000); // Sleep for 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 8. Click on the "MY WISHLIST" link
            WebElement myWishlistLink = driver
                    .findElement(By.xpath("//div[@class='block-content']//a[normalize-space()='My Wishlist']"));
            myWishlistLink.click();

            // 9. Click on the "Add to Cart" button
            WebElement addToCartButton = driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]"));
            addToCartButton.click();

            // 10. Select the country
            WebElement countrySelect = driver.findElement(By.xpath("//select[@id='country']"));
            Select countryDropdown = new Select(countrySelect);
            countryDropdown.selectByVisibleText("United States");

            // 11. Select the state
            WebElement stateSelect = driver.findElement(By.xpath("//select[@id='region_id']"));
            Select stateDropdown = new Select(stateSelect);
            stateDropdown.selectByVisibleText("Utah");

            // 12. Enter the zip code
            WebElement zipCodeInput = driver.findElement(By.xpath("//input[@id='postcode']"));
            zipCodeInput.sendKeys("70000");

            // 13. Click on the "Estimate" button
            WebElement estimateButton = driver.findElement(By.xpath("//span[contains(text(),'Estimate')]"));
            estimateButton.click();
            try {
                Thread.sleep(5000); // Sleep for 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 14. Verify the shipping cost generated
            // WebElement shippingCost = driver.findElement(By.xpath("//tr[@class='shipping'][1]//span[@class='price']"));
            // String actualShippingCost = shippingCost.getText();
            // String expectedShippingCost = "$5.00"; // Replace with the expected shipping cost
            // Assert.assertEquals(expectedShippingCost, actualShippingCost);

            // 15. Check the "Fixed" button
            // WebElement fixedButton = driver.findElement(By.xpath("//input[@id='s_method_flatrate_flatrate']"));
            // fixedButton.click();

            // 16. Click on the "Update Total" button
            // WebElement updateTotalButton = driver.findElement(By.xpath("//button[@title='Update Total']"));
            // updateTotalButton.click();
            // try {
            //     Thread.sleep(5000); // Sleep for 5 seconds
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
            // 17. Verify that the shipping cost is added to the total
            // WebElement totalAmount = driver.findElement(By.xpath("//tr[@class='grand totals']//span[@class='price']"));
            // String actualTotalAmount = totalAmount.getText();
            // String expectedTotalAmount = "$620.00"; // Replace with the expected total amount with shipping cost
            // Assert.assertEquals(expectedTotalAmount, actualTotalAmount);

            // 18. Click "Proceed to Checkout"
            WebElement proceedToCheckoutButton = driver.findElement(By.xpath(
                    "//ul[@class='checkout-types top']//li//button[@title='Proceed to Checkout']//span//span[contains(text(),'Proceed to Checkout')]"));
            proceedToCheckoutButton.click();

            try {
                Thread.sleep(5000); // Sleep for 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Continue with the next steps
            // 12a. Enter Billing Information, and click Continue
            WebElement firstNameInput = driver.findElement(By.id("billing:firstname"));
            firstNameInput.sendKeys("John");
            WebElement middlenNameInput = driver.findElement(By.id("billing:middlename"));
            middlenNameInput.sendKeys("FFF");
            WebElement lastNameInput = driver.findElement(By.id("billing:lastname"));
            lastNameInput.sendKeys("Doe");
            WebElement companyInput = driver.findElement(By.id("billing:company"));
            companyInput.sendKeys("aa");
            WebElement addressInput = driver.findElement(By.id("billing:street1"));
            addressInput.sendKeys("aa");
            WebElement Address2Input = driver.findElement(By.id("billing:street2"));
            Address2Input.sendKeys("aa");
            WebElement cityInput = driver.findElement(By.id("billing:city"));
            cityInput.sendKeys("aa");
            WebElement regionInput = driver.findElement(By.id("billing:region"));
            regionInput.sendKeys("aa");
            WebElement zipInput = driver.findElement(By.id("billing:postcode"));
            zipInput.sendKeys("aa");
            WebElement countryInput = driver.findElement(By.id("billing:country_id"));
            Select countrySelect2Select = new Select(countryInput);
            countrySelect2Select.selectByVisibleText("Vietnam");
            WebElement phoneInput = driver.findElement(By.id("billing:telephone"));
            zipInput.sendKeys("212313331231232");
            WebElement faxInput = driver.findElement(By.id("billing:fax"));
            zipInput.sendKeys("2123");
            WebElement use_for_shipping_yesInput = driver.findElement(By.id("billing:use_for_shipping_yes"));
            use_for_shipping_yesInput.click();
            WebElement continueButton = driver.findElement(
                    By.xpath("//button[@onclick='billing.save()']//span//span[contains(text(),'Continue')]"));
            continueButton.click();
            // ...
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 19. Quit the browser session
            driver.quit();
        }
    }
}