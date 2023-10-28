package BAITAP;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testcase04 {
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

            // 3. Click on 'Add To Compare' for Sony Xperia
            WebElement sonyXperiaCompareButton = driver.findElement(By.xpath("//a[contains(text(),'Sony Xperia')]/../../following-sibling::div[@class='actions']/ul/li/a"));
            sonyXperiaCompareButton.click();

            // 3. Click on 'Add To Compare' for iPhone
            WebElement iPhoneCompareButton = driver.findElement(By.xpath("//a[contains(text(),'iPhone')]/../../following-sibling::div[@class='actions']/ul/li/a"));
            iPhoneCompareButton.click();

            // 4. Click on 'COMPARE' button
            WebElement compareButton = driver.findElement(By.xpath("//button[@title='Compare']"));
            compareButton.click();

            // 5. Verify the pop-up window and check the selected products
            String mainWindowHandle = driver.getWindowHandle();
            for (String windowHandle : driver.getWindowHandles()) {
                if (!windowHandle.equals(mainWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                    WebElement compareHeading = driver.findElement(By.xpath("//h1[normalize-space()='COMPARE PRODUCTS']"));
                    String compareHeadingText = compareHeading.getText();
                    WebElement selectedProducts = driver.findElement(By.xpath("//div[@class='block-content']/ol/li"));
                    String selectedProductsText = selectedProducts.getText();

                    if (compareHeadingText.equals("COMPARE PRODUCTS") && selectedProductsText.contains("Sony Xperia") && selectedProductsText.contains("iPhone")) {
                        System.out.println("Pop-up window is displayed with selected products: " + selectedProductsText);
                    } else {
                        System.out.println("Pop-up window is not displayed with selected products.");
                    }

                    driver.close();
                    break;
                }
            }

            // Switch back to the main window
            driver.switchTo().window(mainWindowHandle);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the browser session
            driver.quit();
        }
    }
}