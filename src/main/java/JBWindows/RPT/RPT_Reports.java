package JBWindows.RPT;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.BaseClass;

public class RPT_Reports extends BaseClass{

	@FindBy(id = "RPT_Reports") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "dtFromDate") WebElement dtFromDate;
	@FindBy(id = "dtToDate") WebElement dtToDate;
	@FindBy(id = "cboInterval") WebElement cboInterval;	
	@FindBy(id = "btnGenerate") WebElement btnGenerate;
	@FindBy(id = "btnExportPopup") WebElement btnExportPopup;
	@FindBy(id = "btnPrint") WebElement BtnPrint;
	@FindBy(id = "barPDF") WebElement barPDF;
	@FindBy(id = "barXLS") WebElement barXLS;
	@FindBy(id = "chartReports") WebElement chartReports;
	@FindBy(id = "grdReports") WebElement grdReports;

	public RPT_Reports() {
		PageFactory.initElements(driver, this);
	}

	public void activatePage() {
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}

	public void clickPrintButton()
	{
		BtnPrint.click();
	}
	
}
