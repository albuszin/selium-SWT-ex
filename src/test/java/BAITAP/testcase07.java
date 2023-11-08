package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

@Test
public class testcase07 {
    @Test
    public void testSaveOrderAsPDF() {
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

            // Wait for the login to complete (replace with appropriate wait)
            Thread.sleep(5000);


            // 5. Click on 'My Orders'
              WebElement myOrdersLink = driver.findElement(By.xpath("//strong[contains(text(),'My Orders')]"));
            myOrdersLink.click();

            // 6. Click on 'View Order'
            WebElement viewOrderLink = driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr/td[6]/span/a[1]"));
            viewOrderLink.click();

            // 7. Click on 'Print Order' link
            WebElement printOrderLink = driver.findElement(By.xpath("//a[@class='link-print']"));
            printOrderLink.click();

            // Additional steps to save the PDF or verify its presence can be added here

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 8. Quit the browser session
            driver.quit();
        }
    }
}



