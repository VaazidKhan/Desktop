package JBWindows.SAL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class SR_MoreInstructionPopup extends BaseClass{

	@FindBy(id = "SR_MoreInstructionPopup") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "grdInstruction") WebElement grdInstruction;


	public SR_MoreInstructionPopup() {
		pageName.click();
	}

	public void activatePage() {
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}
}
