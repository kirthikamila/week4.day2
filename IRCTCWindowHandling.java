package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

public class IRCTCWindowHandling {
    public static void main(String[] args) {
        // Initialize ChromeDriver
       
        WebDriver driver = new ChromeDriver();

         {
            // Load the IRCTC webpage
            driver.get("https://www.irctc.co.in/");
            
            // Maximize the browser window
            driver.manage().window().maximize();
            
            // Add an implicit wait (optional, adjust as needed)
            driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
            
            // Click on the "FLIGHTS" link
            driver.findElement(By.xpath("//a[contains(text(), 'FLIGHTS')]")).click();
            
            // Store parent window handle
            String parentWindow = driver.getWindowHandle();
            
            // Get all window handles
            Set<String> allWindows = driver.getWindowHandles();
            
            // Switch to the flights window
            for (String window : allWindows) {
                if (!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                    System.out.println("Flights Window Title: " + driver.getTitle());
                    break;
                }
            }
            
            // Close the parent tab only
            driver.switchTo().window(parentWindow);
            driver.close();
            
            // Switching back to the flights window to continue execution if needed
            for (String window : driver.getWindowHandles()) {
                driver.switchTo().window(window);
                
            }
            
        }  {
            
        }
    }
}
