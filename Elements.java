package Projectng;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Elements {
	@FindBy(xpath = "//*[@id=\'email\']")
	public static  WebElement email ;
	
	@FindBy(xpath = "//*[@id=\'passwd\']")
	public static WebElement password;
	
	@FindBy(xpath = "//*[@id=\'SubmitLogin\']/span")
	public static WebElement login;

	@FindBy(xpath ="//*[@id=\'block_top_menu\']/ul/li[3]/a")
	public static WebElement menu;
	
	@FindBy(xpath ="//span[@class='available-now']")
	public static WebElement mouseover;

	@FindBy(xpath ="//span[contains(text(),'Add to cart')]")
	public static WebElement addtocartbutton;
	
	
	@FindBy(xpath="//span[contains(text( ),'Proceed to checkout')]")
	public static WebElement addcart;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
	public static WebElement column;

	@FindBy(xpath="//*[@id=\'center_column\']/form/p/button/span")
	public static WebElement button;

    @FindBy(xpath="//*[@id=\"uniform-cgv\"]")
    public static WebElement agree;
    
    @FindBy(xpath="//*[@id=\'form\']/p/button/span")
    public static WebElement checkout;
    
    @FindBy(xpath="//*[@id=\'HOOK_PAYMENT\']/div[2]/div/p/a")
    public static WebElement payment;

    @FindBy(xpath = "//*[@id=\'cart_navigation\']/button/span")
    public static WebElement confirm;
           
    @FindBy(xpath="//*[@id=\"newsletter_block_left\"]/h4")
    public static WebElement news;
    
    
    @FindBy(xpath = "(//a[contains(text(),' orders')])[1]")
    public static WebElement backtoorder;

@FindBy(xpath="//*[@id=\"order-list\"]/tbody/tr[2]/td[2]")
public static WebElement price;
}
