package JBWindows.APP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class APP_MasterListView {

	@FindBy(id = "APP_MasterListView")	WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "btnCancel") WebElement btnCancel;
	@FindBy(id = "btnPrint") WebElement btnPrint;
	@FindBy(id = "btnExportPopup") WebElement btnExportPopup;
	@FindBy(id = "barPDF") WebElement MenubarPDF;
	@FindBy(id = "barXLS") WebElement MenubarXLS;

	public APP_MasterListView() {
		pageName.click();
	}

	public void activatePage() {
		pageName.click();
	}

	public void clickCloseButton() {
		BtnClose.click();
	}

	public void clickCancelButton() {
		btnCancel.click();
	}
	public void clickPrintButton() {
		btnPrint.click();
	}
}
