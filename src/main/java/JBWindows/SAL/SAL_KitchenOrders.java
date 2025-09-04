package JBWindows.SAL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class SAL_KitchenOrders extends BaseClass{
	
	@FindBy(id = "SAL_KitchenOrders") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	@FindBy(id = "DepartmentTabs") WebElement DepartmentTabs;
	@FindBy(id = "grdBreakUp") WebElement grdBreakUp;
	@FindBy(id = "plKOTDisplay") WebElement plKOTDisplay;
	
	@FindBy(id = "btnClearAll") WebElement BtnClearAll;
	@FindBy(id = "btnRefresh") WebElement BtnRefresh;
	@FindBy(id = "btnClose") WebElement BtnCloseBottom;


	public SAL_KitchenOrders() {
		pageName.click();
	}

	public void activatePage() {
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}
	
	public void clickClearAllButton()
	{
		BtnClearAll.click();
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
