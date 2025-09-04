package JBWindows.SAL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class SAL_OrderQueue extends BaseClass{
	
	@FindBy(id = "SAL_OrderQueue") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	@FindBy(id = "grdCardView") WebElement grdCardView;
	@FindBy(id = "btnRefresh") WebElement BtnRefresh;
	@FindBy(id = "btnClose") WebElement BtnCloseBottom;


	public SAL_OrderQueue() {
		pageName.click();
	}

	public void activatePage() {
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}
	
	public void clickRefreshButton()
	{
		BtnRefresh.click();
	}
	
	public void clickCloseBottomButton()
	{
		BtnCloseBottom.click();
	}

}
