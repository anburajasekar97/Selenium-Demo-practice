package Com.DemowebShop_GenericUtility;

public interface FrameWorksConstants {
	Java_utility  jutil= new Java_utility();
	
	String propertyFilePath = "./src/test/resources/testdata/commondata";
	
	String excelFilePath = "./src/test/resources/testdata/addressdata.xlsx";
	
	String screenshots = "./screenshots/" +jutil.dateandTime() +".png";
	
	String extentreports ="./reports/" +jutil.dateandTime() +".html";

}
