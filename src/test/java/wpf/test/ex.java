package wpf.test;

import commonClass.ApplicationVariables;
import commonClass.ExcelUtils;

public class ex {
	public static void main(String[] args) {		    	
		    	String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
		                ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		        String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
		                ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		        System.out.println(Username);
		        System.out.println(Password);
	}

}
