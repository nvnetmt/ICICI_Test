package com.oracle.ICICI.common.steps;

import io.cucumber.java.en.Then;
import com.oracle.acs.util.ExcelOperations;

public class DatabankInitialization {
	
	public static ExcelOperations exl;
	public static String strDataSheetName;
	public static int DataRow;
	
	@Then("^Input Data bank \"([^\"]*)\",\"([^\"]*)\"$")
	public void input_Data_bank(String dataSheetname,int row) throws Throwable {
		exl = new ExcelOperations("src\\test\\java\\com\\oracle\\ICICI\\HCM\\databank\\ICICIDataBank.xlsx");
		strDataSheetName=dataSheetname ;
		DataRow=row;
	}
	
	

}
