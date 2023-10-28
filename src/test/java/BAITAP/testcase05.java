package BAITAP;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testcase05 {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            // 2. Click on 'My Account' link
            WebElement myAccountLink = driver.findElement(By.xpath("//a[normalize-space()='My Account']"));
            myAccountLink.click();

            // 3. Click on 'Create an Account' link
            WebElement createAccountLink = driver.findElement(By.xpath("//a[normalize-space()='Create an Account']"));
            createAccountLink.click();

            // 4. Fill in new user information excluding the registered Email ID
            WebElement firstNameInput = driver.findElement(By.id("firstname"));
            firstNameInput.sendKeys("John");
            WebElement lastNameInput = driver.findElement(By.id("lastname"));
            lastNameInput.sendKeys("Doe");
            WebElement emailInput = driver.findElement(By.id("email_address"));
            emailInput.sendKeys("test@example.com");
            WebElement passwordInput = driver.findElement(By.id("password"));
            passwordInput.sendKeys("password123");
            WebElement confirmPasswordInput = driver.findElement(By.id("confirmation"));
            confirmPasswordInput.sendKeys("password123");

            // 5. Click 'Register'
            WebElement registerButton = driver.findElement(By.xpath("//button[@title='Register']"));
            registerButton.click();

            // 6. Verify account registration is done
            WebElement registrationMessage = driver.findElement(By.xpath("//h1[normalize-space()='Account Registration Done']"));
            String registrationMessageText = registrationMessage.getText();
            if (registrationMessageText.equals("Account Registration Done")) {
                System.out.println("Registration is done.");
            } else {
                System.out.println("Registration is not done.");
            }

            // 7. Go to 'TV' menu
            WebElement tvMenu = driver.findElement(By.xpath("//a[normalize-space()='TV']"));
            tvMenu.click();

            // 8. Add product 'LG LCD' to wishlist
            WebElement lgLcdProductLink = driver.findElement(By.xpath("//a[contains(text(),'LG LCD')]"));
            lgLcdProductLink.click();
            WebElement addToWishlistButton = driver.findElement(By.xpath("//button[@title='Add to Wishlist']"));
            addToWishlistButton.click();

            // 9. Click 'SHARE WISHLIST'
            WebElement shareWishlistButton = driver.findElement(By.xpath("//button[@title='Share Wishlist']"));
            shareWishlistButton.click();

            // 10. Enter email and message, then click 'SHARE WISHLIST'
            WebElement emailInput2 = driver.findElement(By.id("email_address"));
            emailInput2.sendKeys("friend@example.com");
            WebElement messageInput = driver.findElement(By.id("message"));
            messageInput.sendKeys("Check out my wishlist!");
            WebElement shareWishlistButton2 = driver.findElement(By.xpath("//button[@title='Share Wishlist']"));
            shareWishlistButton2.click();

            // Switch to the new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // Check if the wishlist is shared
            WebElement wishlistSharedMessage = driver.findElement(By.xpath("//span[@class='success-msg']"));
            String wishlistSharedMessageText = wishlistSharedMessage.getText();
            if (wishlistSharedMessageText.contains("Your Wishlist has been shared.")) {
                System.out.println("Wishlist is shared successfully.");
            } else {
                System.out.println("Wishlist is not shared.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the browser session
            driver.quit();
        }
    }
}