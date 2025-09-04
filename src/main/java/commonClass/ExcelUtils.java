package commonClass;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static String FnReadCellData(String StrExcelPath, String StrSheetName) throws IOException {
        String CellValue = null;
        try (FileInputStream fis = new FileInputStream(StrExcelPath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet(StrSheetName);

            for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Row row = sheet.getRow(rowNum);
                if (row == null) continue;

                for (int cellNum = 0; cellNum < row.getLastCellNum(); cellNum++) {
                    Cell cell = row.getCell(cellNum);
                    if (cell == null) continue;

                    if (cell.getCellType() == CellType.STRING) {
                        CellValue = cell.getStringCellValue();
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        CellValue = NumberToTextConverter.toText(cell.getNumericCellValue());
                    }
                    System.out.println(CellValue);
                }
            }
        }
        return CellValue;
    }

    public static String fnGetExcelCellValue(String StrExcelPath, String StrSheetName, int intRowindex, int intCellindex) {
        String CellValue = null;
        try (FileInputStream fis = new FileInputStream(StrExcelPath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet(StrSheetName);
            Row row = sheet.getRow(intRowindex);
            if (row != null) {
                Cell cell = row.getCell(intCellindex);
                if (cell != null) {
                    if (cell.getCellType() == CellType.STRING) {
                        CellValue = cell.getStringCellValue();
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        CellValue = NumberToTextConverter.toText(cell.getNumericCellValue());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return CellValue;
    }

    public static int fnGetCellRowIndex(String StrExcelPath, String StrSheenName, String ActualCellvalue) throws IOException {
        try (FileInputStream fis = new FileInputStream(StrExcelPath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet(StrSheenName);

            for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Row row = sheet.getRow(rowNum);
                if (row == null) continue;

                for (int cellNum = 0; cellNum < row.getLastCellNum(); cellNum++) {
                    Cell cell = row.getCell(cellNum);
                    if (cell != null && cell.getCellType() == CellType.STRING) {
                        if (cell.getStringCellValue().trim().equals(ActualCellvalue)) {
                            return cell.getRowIndex();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public static int fnGetCellColumnIndex(String StrExcelPath, String StrSheenName, String ActualCellvalue) throws IOException {
        try (FileInputStream fis = new FileInputStream(StrExcelPath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet(StrSheenName);

            for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Row row = sheet.getRow(rowNum);
                if (row == null) continue;

                for (int cellNum = 0; cellNum < row.getLastCellNum(); cellNum++) {
                    Cell cell = row.getCell(cellNum);
                    if (cell != null && cell.getCellType() == CellType.STRING) {
                        if (cell.getStringCellValue().trim().equals(ActualCellvalue)) {
                            return cell.getColumnIndex();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public static int fngetUsedRowCount(String StrExcelPath, String StrSheenName) throws IOException {
        try (FileInputStream fis = new FileInputStream(StrExcelPath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            XSSFSheet sheet = workbook.getSheet(StrSheenName);
            return sheet.getLastRowNum();
        }
    }

    public static int fngetUsedColumnCount(String StrExcelPath, String StrSheenName, int intRowindex) throws IOException {
        try (FileInputStream fis = new FileInputStream(StrExcelPath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            XSSFSheet sheet = workbook.getSheet(StrSheenName);
            XSSFRow row = sheet.getRow(intRowindex);
            return row != null ? row.getLastCellNum() : 0;
        }
    }

    public static void fn_Set_Value(String strExcelPathString, String strsheetname, int rowindex, int cellindex, String strcellvalue) {
        try (FileInputStream fis = new FileInputStream(strExcelPathString);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet(strsheetname);
            Row row = sheet.getRow(rowindex);
            if (row == null) row = sheet.createRow(rowindex);

            Cell cell = row.createCell(cellindex);
            cell.setCellValue(strcellvalue);

            try (FileOutputStream fos = new FileOutputStream(strExcelPathString)) {
                workbook.write(fos);
            }

            System.out.println("Value successfully inserted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object[][] getDataFromExcelComplete(String ExcelPath, String SheetName) {
        Object[][] cellValue = null;
        try (FileInputStream fis = new FileInputStream(ExcelPath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet(SheetName);
            int totalRows = sheet.getLastRowNum();
            int totalCols = sheet.getRow(0).getLastCellNum();

            cellValue = new Object[totalRows][totalCols];

            for (int i = 0; i < totalRows; i++) {
                Row row = sheet.getRow(i + 1);
                for (int j = 0; j < totalCols; j++) {
                    Cell cell = row.getCell(j);
                    if (cell == null) {
                        cellValue[i][j] = "";
                        continue;
                    }
                    switch (cell.getCellType()) {
                        case STRING:
                            cellValue[i][j] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            cellValue[i][j] = NumberToTextConverter.toText(cell.getNumericCellValue());
                            break;
                        case BLANK:
                            cellValue[i][j] = "";
                            break;
                        default:
                            cellValue[i][j] = cell.toString();
                            break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cellValue;
    }

    public static Object[][] getCellValues(String ExcelPath, String SheetName, int rowindex) {
        Object[][] cellValue = null;
        try (FileInputStream fis = new FileInputStream(ExcelPath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet(SheetName);
            int totalCols = sheet.getRow(rowindex).getLastCellNum();
            cellValue = new Object[1][totalCols];

            Row row = sheet.getRow(rowindex);
            for (int j = 0; j < totalCols; j++) {
                Cell cell = row.getCell(j);
                if (cell != null) {
                    switch (cell.getCellType()) {
                        case STRING:
                            cellValue[0][j] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            cellValue[0][j] = NumberToTextConverter.toText(cell.getNumericCellValue());
                            break;
                        default:
                            cellValue[0][j] = cell.toString();
                            break;
                    }
                } else {
                    cellValue[0][j] = "";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cellValue;
    }
    
	/*
	 * @Author : Ramesh Date : 31-01-2018 Method is to get the expected cell value
	 * based on execution status. Method will find the row number & column number
	 * automatically & get the expected cell value based on value passed as
	 * parameter.
	 * 
	 * @Param : 1. ExcelPath, 2. ExcelSheetName, 3.
	 * ColumnHeaderBasedOnExecutionWillDecice, 4. ExecutionStatus(Yes/No), 5.
	 * ColumnHeaderforWhichValueIsRequired(URL/Password/UserName).
	 */

	@SuppressWarnings("resource")
	public static String fn_Get_Expected_Cell_Value_based_on_Execution_Status(String strExcelPathString,
			String strSheetName, String StrExecutionColumnHeader, String strExecutionStatus,
			String strColHeaderOfExpectedColumnValue) {

		String getValue = null;

		FileInputStream refExcel;
		try {
			refExcel = new FileInputStream(strExcelPathString);
			XSSFWorkbook refWB = new XSSFWorkbook(refExcel);
			XSSFSheet refSheet = refWB.getSheet(strSheetName);
			XSSFRow refRow = refSheet.getRow(0);

			for (int ColHeaderNum = 0; ColHeaderNum < refRow.getLastCellNum(); ColHeaderNum++) {
				String Colvalue;
				Colvalue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName, 0, ColHeaderNum);
				if (Colvalue.toLowerCase().trim().equals(StrExecutionColumnHeader.toLowerCase().trim())) {

					for (int RowNum = 0; RowNum < 100; RowNum++) {

						String RowCellvalue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName, RowNum,
								ColHeaderNum);

						if (RowCellvalue.toLowerCase().trim().equals(strExecutionStatus.toLowerCase().trim())) {

							for (int ColNumURL = 0; ColNumURL < refRow.getLastCellNum(); ColNumURL++) {
								String ColHeaderURL = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
										0, ColNumURL);

								if (ColHeaderURL.toLowerCase().trim()
										.equals(strColHeaderOfExpectedColumnValue.toLowerCase().trim())) {
									switch (strColHeaderOfExpectedColumnValue.toLowerCase().trim()) {
									case "url":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "username":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "password":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "organisationcode":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "accountid":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "subscriptioncode":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "installername":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "editfieldoldvalue":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									// ---1-May-2018---Added by Moumita
									case "editfieldname":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "editedvalue":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "paymentmode":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "vouchertype":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "wallettype":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									// ---4-May-2018---Added by Moumita
									case "startingrownumber":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;

									case "lastrownumber":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;

									case "rownumbernewcustomer":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "rownumberexistingcustomer":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "rownumber_bankaccountdetails":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "rownumber_advancereceived":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "rownumber_creditnote":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "rownumber_voucherdetails":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "rownumberadvancereceiveddetails":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;

									case "rownumber_sotype":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;

									case "pricelist":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "rownumber_modifiedprice":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "rownumber_taxgroup":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "rownumber_discountrule":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									// ---8-May-2018---Added by Moumita
									case "startingrownumber_paymentmode":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "lastrownumber_paymentmode":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "rownumber_discount_invoice":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "rownumber_discount_item":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "rownumber_tax_item":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									// ---10-May-2018---Added by Moumita
									case "rownumber_tax_invoice":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									// ---11-May-2018---Added by Moumita
									case "lastrownumber_exchange":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									// ---16-May-2018---Added by Moumita
									case "startingrownumber_newproduct":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									case "lastrownumber_newproduct":
										getValue = ExcelUtils.fnGetExcelCellValue(strExcelPathString, strSheetName,
												RowNum, ColNumURL);
										break;
									}
									break;
								}
							}
							break;
						}
					}
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getValue;
	}

}
