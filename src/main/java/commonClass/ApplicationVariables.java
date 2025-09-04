package commonClass;

public class ApplicationVariables {

	public static final String ApplicationType = Enumerators.ApplicationType.Windows.getValue();
	public static final String BuildTypeEnvironment = Enumerators.BuildTypeEnvironment.UAT.getValue();
	public static final String JBVartical = Enumerators.JBVerticals.WindowsQSR.getValue();

	// JBWindows driver & Application path
	public static final String JustBillingInstallerPath = System.getProperty("user.dir")
			+ "\\Store\\Installer\\";
	public static final String JustBillingInstallerName = "JustBilling.msi";

	// JBWindows driver & Application path
    public static final String host = "127.0.0.1";
    public static final int port = 4723;
	public static final String winAppDriverPath = "C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe";
	public static final String applicationPath = "C:\\Program Files (x86)\\JustBilling\\JustBilling\\POS.exe"; // Update if the path is different
;
//Screenshot Path
	public static final String ScreenshotsFilePath = System.getProperty("user.dir")
			+ "\\Reports\\TestScreenshots\\Windows\\Screenshot_";
	public static final String ScreenshotsNumberingAndExtension = "_"
			+ GenericMethods.fnGenRandNumber(99999, 1).toString() + ".png";

	public static final String ScreenshotsFilePath_Web = "_"
			+ GenericMethods.fnGenRandNumber(99999, 1).toString() + ".png";
	public static final String ScreenshotsNumberingAndExtension_Web = "_"
			+ GenericMethods.fnGenRandNumber(99999, 1).toString() + ".png";

	// Extent Report path
	// String date=GenericMethods.fnGetCurrentDate()
	public static final String ExtentReportFilePath = System.getProperty("user.dir") + "\\Reports\\JustBillingReport"
			+ GenericMethods.currentDate().toString() + ".html";

	// Log File Path
	public static final String LogFilePath = System.getProperty("user.dir") + "\\Log\\Log.txt";

	// Excel Path
	public static final String testdataInputExcelPath = "D:\\JB_Windows_src_Test_Data.xlsx";
	public static final String MasterExcelPath = System.getProperty("user.dir")
			+ "\\ExcelUtils\\JB_Windows_TestMasterData.xlsx";
	public static final String LoginMasterExcel = System.getProperty("user.dir") + "\\ExcelUtils\\Data_Source.xlsx";
	public static final String BOTestMasterExcelPath = System.getProperty("user.dir")
			+ "\\ExcelUtils\\JB_BackOffice_TestMasterData.xlsx";
	public static final String BOTestMasterExcelPathInFlight = System.getProperty("user.dir")
			+ "\\ExcelUtils\\Hello_Tomorrow_Data.xlsx";
	public static final String MasterInputExcelPath = System.getProperty("user.dir")
			+ "\\ExcelUtils\\JB_Windows_TestMasterData_Input.xlsx";
	public static final String BOTRANSACTIONEXCELPATH = System.getProperty("user.dir")
			+ "\\ExcelUtils\\JB_BackOffice_Transactions.xlsx";
	public static final String BOFINANCEEXCELPATH = System.getProperty("user.dir")
			+ "\\ExcelUtils\\JB_BackOffice_Finance_TestData.xlsx";
	public static final String BOFinanceTransactionsExcelPath = System.getProperty("user.dir")
			+ "\\ExcelUtils\\JB_BackOffice_Finance_Transactions.xlsx";
	public static final String BOSTOCKTRANSFEROUTTEMPLATEExcelPath = System.getProperty("user.dir")
			+ "\\ExcelUtils\\JB_Stock_Transfer_Out_Template.xlsx";
	public static final String BOIMPORTDATAEXCELPATH = System.getProperty("user.dir") + "\\ExcelUtils\\Import.xlsx";
	public static final String BOIMPORTDATAEXCELPATH2 = System.getProperty("user.dir") + "\\ExcelUtils\\Import_ExistData.xlsx";
	public static final String JBCONFIGURATIONEXCELPATH = System.getProperty("user.dir") + "\\ExcelUtils\\";
	public static final String JBTRANSACTIONEXCELPATH = System.getProperty("user.dir") + "\\ExcelUtils\\";
	public static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + "\\Properties\\config.properties";

}
