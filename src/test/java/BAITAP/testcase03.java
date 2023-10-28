package BAITAP;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testcase03 {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            // 2. Click on 'MOBILE' menu
            WebElement mobileMenu = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
            mobileMenu.click();

            // 3. Click on 'ADD TO CART' for Sony Xperia mobile
            WebElement addToCartButton = driver.findElement(By.xpath("//a[contains(text(),'Sony Xperia')]/../../following-sibling::div[@class='actions']/button"));
            addToCartButton.click();

            // 4. Change 'QTY' value to 1000 and click 'UPDATE' button
            WebElement qtyInput = driver.findElement(By.xpath("//input[@title='Qty']"));
            qtyInput.clear();
            qtyInput.sendKeys("1000");
            WebElement updateButton = driver.findElement(By.xpath("//button[@title='Update']"));
            updateButton.click();

            // 5. Verify the error message
            WebElement errorMessage = driver.findElement(By.xpath("//p[@class='item-msg error']"));
            String errorMessageText = errorMessage.getText();
            if (errorMessageText.contains("The requested quantity for \"Sony Xperia\" is not available.")) {
                System.out.println("Error message is displayed: " + errorMessageText);
            } else {
                System.out.println("Error message is not displayed.");
            }

            // 6. Click on 'EMPTY CART' link in the footer of the list of all mobiles
            WebElement emptyCartLink = driver.findElement(By.xpath("//a[text()='Empty Cart']"));
            emptyCartLink.click();

            // 7. Verify cart is empty
            WebElement emptyCartMessage = driver.findElement(By.xpath("//h1[normalize-space()='SHOPPING CART IS EMPTY']"));
            String emptyCartMessageText = emptyCartMessage.getText();
            if (emptyCartMessageText.equals("SHOPPING CART IS EMPTY")) {
                System.out.println("Cart is empty.");
            } else {
                System.out.println("Cart is not empty.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the browser session
            driver.quit();
        }
    }
}