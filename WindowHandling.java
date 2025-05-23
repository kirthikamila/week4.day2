package week4.day2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class WindowHandling  {

    public static void main(String[] args) {
        // Initialize ChromeDriver
    	ChromeOptions options=new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("http://leaftaps.com/opentaps/control/login");      
        driver.manage().window().maximize();	       	   
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

       //username and password
        driver.findElement(By.id("username")).sendKeys("demosalesmanager");
        driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");

        // Login button
        driver.findElement(By.className("decorativeSubmit")).click();

        // CRM/SFA link
        driver.findElement(By.linkText("CRM/SFA")).click();

        // Contacts button
        driver.findElement(By.linkText("Contacts")).click();

        //Merge Contacts
        driver.findElement(By.linkText("Merge Contacts")).click();

        // widget of the "From Contact"
        driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
        
        // Switch to new window
        String mainWindowHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        // contact
        driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
        driver.switchTo().window(mainWindowHandle);
        
        //To Contact
        driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
        
        // Switch to new window
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        // contact
        driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
     	driver.switchTo().window(mainWindowHandle);

        // Merge 
        driver.findElement(By.linkText("Merge")).click();

        //alert
       Alert alert = driver.switchTo().alert();
       alert.accept();

        //title of the page
        String title = driver.getTitle();
        if (title.contains("View Contact")) {
            System.out.println("Test Passed: Title verified - " + title);
        } else {
             System.out.println("Test Failed: Title not matched");
        }
    }
}
