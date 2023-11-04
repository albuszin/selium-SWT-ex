package BAITAP;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
@Test
public class testcase08 {
    @Test
    public void testChangeReorderProduct() {
        // 1. Initialize the WebDriver
        WebDriver driver = driverFactory.getChromeDriver();

        try {
            // 2. Navigate to the website
            driver.get("http://live.techpanda.org/");

            // 3. Click on the "My Account" link
            WebElement accountLink = driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']"));
            accountLink.click();

            // 4. Log in using previously created credentials (replace with your credentials)
            WebElement emailInput = driver.findElement(By.xpath("//input[@id='email']"));
            emailInput.sendKeys("phucthien041@gmail.com");
            WebElement passwordInput = driver.findElement(By.xpath("//input[@id='pass']"));
            passwordInput.sendKeys("maylaconcho123");
            WebElement loginButton = driver.findElement(By.xpath("//button[@id='send2']"));
            loginButton.click();

            // Wait for the login to complete (replace with appropriate wait)
            Thread.sleep(5000);

            // 5. Click on 'REORDER' link
            WebElement reorderLink = driver.findElement(By.xpath("//a[contains(text(),'REORDER')]"));
            reorderLink.click();

            // 6. Change the quantity (QTY = 10)
            WebElement qtyInput = driver.findElement(By.xpath("//input[@class='input-text qty']"));
            qtyInput.clear();
            qtyInput.sendKeys("10");

            // Click the "Update" button
            WebElement updateButton = driver.findElement(By.xpath("//button[@title='Update']"));
            updateButton.click();

            // Wait for the update to complete (replace with appropriate wait)
            Thread.sleep(5000);

            // 7. Verify Grand Total is changed
            WebElement grandTotal = driver.findElement(By.xpath("//tr[@class='grand totals']//span[@class='price']"));
            String actualGrandTotal = grandTotal.getText();
            String expectedGrandTotal = "$XXX.XX"; // Replace with the expected grand total
            Assert.assertEquals(expectedGrandTotal, actualGrandTotal);

            // 8. Complete Billing & Shipping Information (add your code here)

            // 9. Verify order is generated and note the order number (add your code here)

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 10. Quit the browser session
            driver.quit();
        }
    }
}

