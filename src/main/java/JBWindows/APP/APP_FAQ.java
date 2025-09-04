package JBWindows.APP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.BaseClass;

public class APP_FAQ extends BaseClass {

	@FindBy(id = "APP_FAQ")
	WebElement pageName;

	@FindBy(id = "btnHelp")
	WebElement btnHelp;
	@FindBy(id = "btnContactUs")
	WebElement btnContactUs;
	@FindBy(id = "btnServiceRequest")
	WebElement btnServiceRequest;
	@FindBy(id = "picClose")
	WebElement BtnClose;

	public APP_FAQ() {
		PageFactory.initElements(driver, this);
	}
	
	public void activatePage()
	{
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}
	
	public void clickContactUsButton()
	{
		btnContactUs.click();
	}
	
	public void clickHelpButton()
	{
		btnHelp.click();
	}
	
	public void clickServiceRequestutton()
	{
		btnServiceRequest.click();
	}

}
