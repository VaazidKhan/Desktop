package JBWindows.RPT;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class RPT_GSTDashboard extends BaseClass{

	@FindBy(id = "RPT_GSTDashboard") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "cboMonths") WebElement cboMonths;
	@FindBy(id = "cboYears") WebElement cboYears;
	@FindBy(id = "wbGSTDashboard") WebElement wbGSTDashboard;	
	@FindBy(id = "wbGSTR3B") WebElement wbGSTR3B;
	@FindBy(id = "wbGSTComputation") WebElement wbGSTComputation;
	@FindBy(id = "btnCancel") WebElement BtnCancel;

	public RPT_GSTDashboard() {
		pageName.click();
	}

	public void activatePage() {
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}
	
	public void clickCancelButton()
	{
		BtnCancel.click();
	}

}
