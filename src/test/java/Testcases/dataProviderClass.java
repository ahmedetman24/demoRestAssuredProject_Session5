package Testcases;

import TestData.excelReader;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class dataProviderClass
{
    @DataProvider(name = "getAPIs")
    public static Object[][] readGetAPIsData() throws IOException {
        excelReader er = new excelReader();
        return er.getExcelData("allAPIsData.xlsx", 0);
    }

    @DataProvider(name = "postAPIs")
    public static Object[][] readPostAPIsData() throws IOException {
        excelReader er = new excelReader();
        return er.getExcelData("allAPIsData.xlsx", 1);
    }

    @DataProvider(name = "putAPIs")
    public static Object[][] readPutAPIsData() throws IOException {
        excelReader er = new excelReader();
        return er.getExcelData("allAPIsData.xlsx", 2);
    }

    @DataProvider(name = "deleteAPIs")
    public static Object[][] readDeleteAPIsData() throws IOException {
        excelReader er = new excelReader();
        return er.getExcelData("allAPIsData.xlsx", 3);
    }
}
