package pgFactory;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Keys;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPgFac {
	WebDriver driver;
	String parentWindow;
	Actions action;
	public LoginPgFac(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
		parentWindow = driver.getWindowHandle();
	}
	Set<String> handles;
	public void mainPage() throws InterruptedException {
		driver.get("https://www.flipkart.com/");	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	/****Login Elements****/
	@FindBy(xpath ="//input[@class='_2IX_2- VJZDxU']")
	WebElement mobno;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement pass;
	
	@FindBy(xpath="//button/span[contains(text(),'Login')]")
	WebElement LoginBtn;
	
	@FindBy(xpath="//span[@class='_2YULOR']")
	WebElement msg;
	
	@FindBy(xpath="//a[contains(text(),\"Login\")]")
	WebElement Loginres;

	public void enter_mob_no(String mobNo) {
		mobno.sendKeys(mobNo);
	}
	public void enter_pass(String pswd) {
		pass.sendKeys(pswd);
	}
	public void clickLogin() {
		LoginBtn.click();
	}
	public void result() throws InterruptedException {
		Thread.sleep(3000);
		try {
			if(Loginres.isDisplayed())
				System.out.println("Login Unsuccessful"+" "+msg.getText());
		}
		catch (Exception e){
			System.out.println("Login Successful");
		}
		driver.close();
	}
	
	/****Search Elements****/
	@FindBy(xpath= "//input[@class='_3704LK']")
	WebElement srchBar;
		
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement SrchBtn;
		
	@FindBy(xpath="//div[contains(text(),'Fashion')]")
	WebElement fshnDrp;
		
	@FindBy(xpath="//a[contains(text(),'Women Ethnic')]")
	WebElement optnList;
		
	@FindBy(xpath="//a[contains(text(),'Women Kurtas & Kurtis')]")
	WebElement subOptn;
		
	public void srchBar_Pro(String prodName) {
		srchBar.sendKeys(prodName);
	}
	public void Srchclick() throws InterruptedException {
		SrchBtn.click();
	}
	public void DrpHover() {
		//action = new Actions(driver);
		action.moveToElement(fshnDrp).perform();
		action.moveToElement(optnList).perform();
	}
	public void selProdType() {
		subOptn.click();
	}
	/****Filtering Product*****/
	@FindBy(xpath="//div[@class='_1YAKP4']//select[@class='_2YxCDZ']")
	WebElement min;
	
	@FindBy(xpath="//div[@class='_3uDYxP']//select[@class='_2YxCDZ']")
	WebElement max;
	
	@FindBy(xpath="//div[@class='_3sckoD' and contains(text(),'300-700')]")
	WebElement PriceFilt;
	
	@FindBy(xpath="//div[@class='_3sckoD' and contains(text(),'Black')]")
	WebElement ColFilt;
	
	@FindBy(xpath="//body")
	WebElement pg;
	
	@FindBy(xpath="//div[contains(text(),'Color')]")
	WebElement ColorOptn;
	
	@FindBy(xpath="//label[@class='_2iDkf8 t0pPfW']//div[contains(text(),'Black')]")
	WebElement black;
	
	public void setMin() {
		Select minDrp= new Select(min);
		minDrp.selectByVisibleText("300");
	}
	public void setMax() {
		Select maxDrp= new Select(max);
		maxDrp.selectByVisibleText("700");
	}
	public void scroll() {
		pg.click();
		//action = new Actions(driver);
		action.scrollToElement(ColorOptn).perform();
	}
	public void selColor() {
		ColorOptn.click();
		black.click();
	}
	public void TagVisibility() {
		try {
			if(PriceFilt.isDisplayed())
				System.out.println("Price Filter applied succesfully");
			if(ColFilt.isDisplayed())
				System.out.println("Color Filter applied succesfully");
			
		}
		catch(Exception e) {
			System.out.println("Filter application failed");
		}
	}
	/****Add Product to cart****/
	
	@FindBy(xpath="//div[@data-id='KTAGE2G7AZSK9BYR']")
	WebElement prodOptn;
	
	@FindBy(xpath="//div[contains(text(),'Stylum')]")
	WebElement prodTitle;
	
	@FindBy(id="swatch-2-size")
	WebElement sizeL;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	WebElement cartBtn;
	
	public void selProd() {
		prodOptn.click();
	}
	public String retTitle() {
		return (prodTitle.getText());
	}
	
	public void PgRedirect() { 
		handles = driver.getWindowHandles(); 
		for(String windowHandle : handles) { 
			if(!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle); 
			}
		} 
	}
	public void selSize() {
		sizeL.click();
	}
	public void scrollToCart() {
		for(int i=0;i<3;i++) {
			action.sendKeys(Keys.PAGE_DOWN).perform();
		}
	}
	public void addToCart() {
		//action.moveToElement(cartBtn).click().perform();
		cartBtn.click();
	}
}
