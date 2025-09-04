package JBWindows.CRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class CRM_DocumentPopup extends BaseClass{

	@FindBy(id = "CRM_DocumentPopup") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "cmbDocumentProofType") WebElement cmbDocumentProofType;
	@FindBy(id = "txtTitle") WebElement txtTitle;
	@FindBy(id = "lookUpDocumentType") WebElement lookUpDocumentType;
	@FindBy(id = "txtDocumentNo") WebElement txtDocumentNo;
	@FindBy(id = "memoRemarks") WebElement memoRemarks;
	@FindBy(id = "btnSelectDocument") WebElement btnSelectDocument;
	@FindBy(id = "chkVerified") WebElement chkVerified;
	@FindBy(id = "pdfViewerFiles") WebElement pdfViewerFiles;
	@FindBy(id = "imageViewerFiles") WebElement imageViewerFiles;
	@FindBy(id = "documentViewerFiles") WebElement documentViewerFiles;
	@FindBy(id = "btnAdd") WebElement BtnAdd;
	@FindBy(id = "btnCancel") WebElement BtnCancel;

	public CRM_DocumentPopup() {
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

	public void clickAddButton()
	{
		BtnAdd.click();
	}
	
}
