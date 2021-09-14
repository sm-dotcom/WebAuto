/**
 * @author sarah.mahmood
 *
 * Sep 14, 2021 6:08:19 PM
 */
package Settings;

public class TestResult {
		 
		 public String SheetName;
		 public String TestCaseID;
		 public String Status;
		 
		 public TestResult(String sheetName, String testCaseID, String status)
		 {
				super();
				SheetName = sheetName;
				TestCaseID = testCaseID;
				Status = status;
			}
	}

