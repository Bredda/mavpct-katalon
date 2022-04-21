import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.sql.ResultSet

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String query = """
SELECT TOP (100) [TimeStamp]
      ,[EventType]
      ,[Workstation]
      ,[EventCategory]
      ,[EventContentType]
      ,[EventContent]
  FROM [MavPctDB].[dbo].[TOperationalEvent]
"""

CustomKeywords.'mavpct.Database.connectDB'()

ResultSet result = CustomKeywords.'mavpct.Database.executeQuery'(query)
int i = 0
while(result.next()) {

	
	KeywordUtil.logInfo("Result ${i}: ${ result.getTimestamp('TimeStamp')}, ${result.getInt('EventType')}, ${result.getString('EventContentType')}")

}


CustomKeywords.'mavpct.Database.closeDatabaseConnection'()

