package JBWindows.APP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.BaseClass;

public class APP_Diagnostics extends BaseClass{
	
	@FindBy(id = "APP_Diagnostics") WebElement pageName;

	@FindBy(id = "btnLastSync") WebElement btnLastSync;
	@FindBy(id = "btnDeviceInfo") WebElement btnDeviceInfo;
	@FindBy(id = "btnLogDetails") WebElement btnLogDetails;
	@FindBy(id = "btnAppMaintenance") WebElement btnAppMaintenance;
	@FindBy(id = "btnAuditTrail") WebElement btnAuditTrail;
	@FindBy(id = "btnReleaseNote") WebElement btnReleaseNote;
	
	@FindBy(id = "btnShareDeviceInfo") WebElement btnShareDeviceInfo;
	@FindBy(id = "btnShareLog") WebElement btnShareLog;
	@FindBy(id = "btnClearLog") WebElement btnClearLog;
	@FindBy(id = "btnClearDatabase") WebElement btnClearDatabase;
	@FindBy(id = "btnClearAllTransaction") WebElement btnClearAllTransaction;
	@FindBy(id = "btnForceUpload") WebElement btnForceUpload;
	@FindBy(id = "btnForceDownload") WebElement btnForceDownload;

	public APP_Diagnostics()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void activatePage()
	{
		pageName.click();
	}


}
