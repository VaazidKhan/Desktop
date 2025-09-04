package JBWindows.AppSetup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class SYS_OrganizationType extends BaseClass {
	
	@FindBy(id = "SYS_OrganizationType") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "rbtnNewOrganisation") WebElement rbtnNewOrganisation;
	@FindBy(id = "rbtnExistingOrganisation") WebElement rbtnExistingOrganisation;
	@FindBy(id = "txtOrganizationCode") WebElement txtOrganizationCode;
	@FindBy(id = "txtAccountID") WebElement txtAccountID;
	@FindBy(id = "btnNext") WebElement BtnNext;

	public SYS_OrganizationType() {
		pageName.click();
	}

	public void activatePage() {
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}
	
	public void clickNextButton()
	{
		BtnNext.click();
	}


}
