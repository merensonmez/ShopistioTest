import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.time.Duration;

public class shopistio {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        Faker faker = new Faker();
        String fakeFirstName = faker.name().firstName();
        String fakeLastName = faker.name().lastName();
        String fakeEmail = faker.internet().emailAddress();

        driver.get("https://shopist.io/");

        WebElement chairs = driver.findElement(By.xpath("//div[@class='menu-item-large'][normalize-space()='Chairs']"));
        chairs.click();
        Thread.sleep(1000);
        WebElement blackShellChair = driver.findElement(By.xpath("//div[@class='products']//div[2]//div[1]//a[1]//div[1]//img[1]"));
        blackShellChair.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='purchase-button']")).click();
        Thread.sleep(1000);
        WebElement sofas = driver.findElement(By.xpath("//div[@class='menu-item-large'][normalize-space()='Sofas']"));
        sofas.click();
        Thread.sleep(1000);
        WebElement blackVelvetSectional = driver.findElement(By.xpath("//div[9]//div[1]//a[1]//div[1]//img[1]"));
        blackVelvetSectional.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='purchase-button']")).click();
        Thread.sleep(1000);
        WebElement bedding = driver.findElement(By.xpath("//div[@class='menu-item-large'][normalize-space()='Bedding']"));
        bedding.click();
        Thread.sleep(1000);
        WebElement duvetCover = driver.findElement(By.xpath("//div[@class='products']//div[2]//div[1]//a[1]//div[1]//img[1]"));
        duvetCover.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='purchase-button']")).click();
        Thread.sleep(1000);
        WebElement lighting = driver.findElement(By.xpath("//div[@class='menu-item-large'][normalize-space()='Lighting']"));
        lighting.click();
        Thread.sleep(1000);
        WebElement arcLamp = driver.findElement(By.xpath("//div[@class='products']//div[2]//div[1]//a[1]//div[1]//img[1]"));
        arcLamp.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='purchase-button']")).click();
        Thread.sleep(1000);
        WebElement cart = driver.findElement(By.xpath("//div[@class='menu-item-large'][normalize-space()='Cart (4)']"));
        cart.click();
        Thread.sleep(1000);
        WebElement totalPrice = driver.findElement(By.xpath("//div[@class='line line-total']"));
        String total = totalPrice.getText();
        System.out.println("" +total);
        Thread.sleep(1000);
        WebElement checkout = driver.findElement(By.cssSelector(".checkout"));
        checkout.click();
        Thread.sleep(1000);

        WebElement checkoutMessage = driver.findElement(By.cssSelector(".checkout-title"));
        if (checkoutMessage.isEnabled()){
            System.out.println("Thank you!.Your order has been placed.\n");
        }else {
            System.out.println("Have a problem in your products!!!");
        }
        Thread.sleep(1000);
        WebElement continueShopping = driver.findElement(By.cssSelector(".continue-shopping"));
         continueShopping.click();
        Thread.sleep(1000);
         WebElement signupButton = driver.findElement(By.cssSelector(".signup-button"));
         signupButton.click();
        Thread.sleep(1000);

        driver.findElement(By.id("fn-input")).sendKeys(fakeFirstName);
        driver.findElement(By.id("ln-input")).sendKeys(fakeLastName);
        driver.findElement(By.id("email-addr-input")).sendKeys(fakeEmail);

        WebElement lastSignupButton = driver.findElement(By.xpath("//div[normalize-space()='Sign Up']"));
        lastSignupButton.click();
        driver.close();

    }
}
