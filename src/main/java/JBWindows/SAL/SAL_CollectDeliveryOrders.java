package JBWindows.SAL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.BaseClass;

public class SAL_CollectDeliveryOrders extends BaseClass{
	
	@FindBy(id = "SAL_CollectDeliveryOrders") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	@FindBy(id = "grdDelivery") WebElement grdDelivery;
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	
	//-----19-Feb-2018--Added by Moumita
	@FindBy(name = "Collection row 0") WebElement collectionRowFirst;

	public SAL_CollectDeliveryOrders() {
		PageFactory.initElements(driver, this);
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
	//-----19-Feb-2018--Added by Moumita
	public void selectFirstPaymentIcon() {
		collectionRowFirst.click();
	}
}
