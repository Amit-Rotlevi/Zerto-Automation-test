import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test 
{
	static WebDriver driver;
	
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Amit\\workspace\\Zerto\\Users\\Amit\\workspace\\Zerto\\Users\\Amit\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://zengo.com/");
	}
	
	public static void verifySite(String site) throws InterruptedException
	{
		Thread.sleep(2000);
		if(driver.getTitle() != null && driver.getTitle().contains(site))
			System.out.println("site is diplayed");
		else System.out.println("Error: site is not displayed");
		Thread.sleep(2000);
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		Test obj = new Test();
		obj.launchBrowser();
		
		try {
			verifySite("zengo.com");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.id("menu-item-6043")).click();
		
		try {
			verifySite("zengo.com/free-bitcoin");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.linkText("Download ZenGo")).click();
		
		driver.findElement(By.id("popup-model"));
		driver.navigate().back();
		Thread.sleep(3000);
		driver.quit();
	}
}
