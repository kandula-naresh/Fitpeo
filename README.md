How to Set Up and Run the Automation Script

1. Prerequisites
Follow these steps to set up and execute the automated test for the FitPeo website using Selenium WebDriver, TestNG, and Page Object Model (POM) design pattern. Ensure the following tools and software are installed on your system:
   1. Java Development Kit (JDK):
	1. Install JDK 8 or higher.
	2. Verify installation by running:
		java -version
		javac -version
   2. Eclipse IDE:
	1. Download and install Eclipse IDE.
3.	WebDriverManager:
•	The scripts use WebDriverManager to manage browser drivers dynamically. No manual setup is required.
4.	TestNG Plugin for Eclipse:
•	Install TestNG in Eclipse from Help > Eclipse Marketplace by searching for "TestNG".
•	Add TestNG dependency to the pom.xml file if Maven is used.
5.	Browser:
•	Install the latest version of Google Chrome browser.

2. Project Setup:
1.	Clone or Download the Repository:
•	If you are using a Git repository, clone it using the command:
git clone <repository-url>
•	Alternatively, you can manually download the files.

2.	Open the Project in Your IDE:
1.	Open Eclipse IDE.
2.	Go to File > Import.
3.	Select Maven > Existing Maven Projects and click Next.
4.	Browse to the folder containing the unzipped project and click Finish.
3.	Install Dependencies:
•	If using Maven, ensure that all dependencies in pom.xml are installed. Like selenium, TestNG, WebDriverManager.

3.	Test Execution:
1.	Configure the Test URL:
•	In the BaseTest.java file, ensure that the URL driver.get("https://fitpeo.com"); is correct.
2.	Run the Test:
•	Open the RevenueCalculatorTest.java file in your IDE.
•	Right-click on the file and choose Run As > TestNG Test (or use the TestNG configuration in your IDE).
3.	View Test Results:
1.	Test execution results will appear in the Console tab of Eclipse.
2.	For detailed reports:
•	Check the test-output folder in the project directory for TestNG reports.

4. Troubleshooting
1.	Issue: ChromeDriver version mismatch.
•	Solution: Ensure ChromeDriver and Chrome browser versions match. WebDriverManager should handle this automatically.
2.	Issue: Missing dependencies.
•	Solution: Verify all JAR files are added to the project.
