package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\sampledata.xlsx";//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return logindata;//returning two dimension array
				
	}
	@DataProvider(name="SignupData")
	public String [][] getData1() throws IOException
	{
		String path=".\\testData\\sampledata.xlsx";//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet4");	
		int totalcols=xlutil.getCellCount("Sheet4",1);
				
		String signup[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				signup[i-1][j]= xlutil.getCellData("Sheet4",i, j);  //1,0
			}
		}
	return signup;//returning two dimension array
				
	}
	@DataProvider(name="ContactData")
    public String[][] getTestData2() throws IOException {
        String path = ".\\testData\\sampledata.xlsx"; // File path for testdata2.xlsx
        ExcelUtility xlutil = new ExcelUtility(path); // Creating an object for ExcelUtility
        
        int totalRows = xlutil.getRowCount("Sheet2");  
        int totalCols = xlutil.getCellCount("Sheet2", 1);
        
        String[][] testData2 = new String[totalRows][totalCols]; // 2D array for storing data
        
        for (int i = 1; i <= totalRows; i++) {  // Reading data from testdata2.xlsx
            for (int j = 0; j < totalCols; j++) {
                testData2[i - 1][j] = xlutil.getCellData("Sheet2", i, j); // 1st parameter: Sheet name, 2nd: Row, 3rd: Column
            }
        }
        
        return testData2; // Returning the 2D array
    }
	
	@DataProvider(name="TestData2")
    public String[][] getcontactus() throws IOException {
        String path = ".\\testData\\sampledata.xlsx"; // File path for testdata2.xlsx
        ExcelUtility xlutil = new ExcelUtility(path); // Creating an object for ExcelUtility
        
        int totalRows = xlutil.getRowCount("Sheet3");  
        int totalCols = xlutil.getCellCount("Sheet3", 1);
        
        String[][] testData2 = new String[totalRows][totalCols]; // 2D array for storing data
        
        for (int i = 1; i <= totalRows; i++) {  // Reading data from testdata2.xlsx
            for (int j = 0; j < totalCols; j++) {
                testData2[i - 1][j] = xlutil.getCellData("Sheet3", i, j); // 1st parameter: Sheet name, 2nd: Row, 3rd: Column
            }
        }
        
        return testData2; // Returning the 2D array
    }
	
	// DataProvider for Signup Data
    @DataProvider(name = "SignupData")
    public String[][] getSignupData() throws IOException {
        String path = ".\\testData\\unique_names_emails.xlsx"; // Update this path
        ExcelUtility xlutil = new ExcelUtility(path); // Creating an object for ExcelUtility

        int totalRows = xlutil.getRowCount("Sheet1");
        int totalCols = xlutil.getCellCount("Sheet1", 1);

        String[][] signupData = new String[totalRows][totalCols]; // 2D array for storing data

        for (int i = 1; i <= totalRows; i++) { // Reading data from Excel
            for (int j = 0; j < totalCols; j++) {
                signupData[i - 1][j] = xlutil.getCellData("Sheet1", i, j); // Sheet name, Row, Column
            }
        }

        return signupData; // Returning the 2D array
    }
	
	//DataProvider 4
}
