package Questao10.Teste;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver ();
		driver.get("https://www.google.com");
		driver.findElement(By.id("APjFqb")).sendKeys("NTTDATA");
		driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[@id='taw']//div[@class='v5yQqb']//span")).click();
		driver.findElement(By.cssSelector("button#all.green")).click();
		driver.findElement(By.xpath("//div[@class='lower']//span[text()='Carreira']")).click();
		String originalWindow = driver.getWindowHandle();
		driver.findElement(By.cssSelector("a.button.highlight")).click();
		System.out.println(originalWindow);
		for (String windowHandle : driver.getWindowHandles()) {
			System.out.println(windowHandle);
		    if(!originalWindow.contentEquals(windowHandle)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}
		
		new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.findElement(By.id("pesquisar-vaga-localidade-etc")).sendKeys("Arquiteto");
		
	}
	
}
