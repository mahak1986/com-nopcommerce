package nopcommercedemo;
/**
 * Project-1 - ProjectName : com-nopcommerce
 * BaseUrl = https://demo.nopcommerce.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Navigate to Url.
 * “https://demo.nopcommerce.com/login?returnUrl=
 * %2F”
 * 7. Print the current url.
 * 8. Navigate back to the home page.
 * 9. Navigate to the login page.
 * 10. Print the current url.
 * 11. Refresh the page.
 * 12. Enter the email to email field.
 * 13. Enter the password to password field.
 * 14. Click on Login Button.
 * 15. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class NopCommerceDemo {
    static String browser = "Chrome";
    static String baseUrl = "https://demo.nopcommerce.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        // Which browser to launch using if else
        // EqualsIgnoreCase ignores upper case or lower case
        if (browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        }else if (browser.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else{
            System.out.println("Invalid browser name");
        }

        //Getting base Url
        driver.get(baseUrl);
        //Maximizing the window
        driver.manage().window().maximize();
        //Implicit wait of 10s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Printing title of the page
        System.out.println("The title is: " + driver.getTitle());

        //Printing Current Url
        System.out.println("The current URL is: " + driver.getCurrentUrl());

        //Printing the Current Page Source - HTML Code
        System.out.println("The page source is :" +driver.getPageSource());

        //Navigate to Url
        String LoginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        driver.navigate().to(LoginUrl);

        //Printing the current Url
        System.out.println("The Current Url is: " + driver.getCurrentUrl());

        //Using thread to pause for few seconds
        Thread.sleep(2000);

        //Navigate back to homepage
        driver.navigate().back();
        Thread.sleep(2000);

        //Navigate forward to the login page
        driver.navigate().forward();

        //Printing Current Url
        System.out.println("Current Url : " + driver.getCurrentUrl());

        Thread.sleep(2000);
        // Refreshing the page
        driver.navigate().refresh();
        Thread.sleep(2000);

        //Click on login button
        driver.findElement(By.className("ico-login")).click();

        //Enter Email to email field using ID locator
        driver.findElement(By.id("Email")).sendKeys("mahak@gmail.com");
        Thread.sleep(1000);

        //Enter Password to the password field
        driver.findElement(By.id("Password")).sendKeys("Mahak");
        Thread.sleep(2000);

        //Click on login button
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(2000);

        //Closing the browser
        driver.quit();

    }

}
