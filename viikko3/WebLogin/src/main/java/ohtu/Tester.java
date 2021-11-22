package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class Tester {

    private static String newUserName;

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);

        driver.get("http://localhost:4567");
      //  newUser(element, driver);


        driver.get("http://localhost:4567");
      //  failedLogin(element, driver);

        driver.get("http://localhost:4567");

        logout(element,driver);
        
        driver.quit();
    }

    public static void failedLogin(WebElement element, WebDriver driver){


        driver.get("http://localhost:4567");

        sleep(2);

        element = driver.findElement(By.linkText("login"));
        element.click();

        element = driver.findElement(By.name("username"));
        element.sendKeys(newUserName);

        sleep(2);

        element = driver.findElement(By.name("password"));
        element.sendKeys("akkedoiwapwp");
        element = driver.findElement(By.name("login"));

        sleep(2);
        element.submit();

        sleep(3);

    }

    public static void newUser(WebElement element, WebDriver driver){

        driver.get("http://localhost:4567");

        sleep(2);

        element = driver.findElement(By.linkText("register new user"));
        element.click();

        Random r = new Random();
        newUserName = "arto"+r.nextInt(100000);

        element = driver.findElement(By.name("username"));
        element.sendKeys(newUserName);

        sleep(2);

        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");

        sleep(2);

        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkep");

        element = driver.findElement(By.name("signup"));
        sleep(2);
        element.submit();

        sleep(3);

    }

    public static void logout(WebElement element, WebDriver driver){

        newUser(element, driver);

        element = driver.findElement(By.linkText("continue to application mainpage"));
        sleep(2);
        element.click();

        element = driver.findElement(By.linkText("logout"));
        sleep(2);
        element.click();



    }

    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
