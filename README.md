FitPeo Automation Testing Project
This repository contains automated test scripts for the FitPeo website using Selenium WebDriver, TestNG, and the Page Object Model (POM) design pattern.

1. Project Overview
This project automates key functionalities of the FitPeo website to ensure its reliability and performance. The tests are written in Java and follow best practices for maintainable and reusable test automation.

2. Prerequisites
Before setting up the project, ensure the following tools and software are installed:

Java Development Kit (JDK 8 or higher):
Verify installation by running:
bash
Copy code
java -version
javac -version
Eclipse IDE (or any Java-supported IDE like IntelliJ IDEA).
TestNG Plugin for Eclipse.
Google Chrome Browser (latest version).
Maven (if Maven is used for dependency management):
Verify installation:
bash
Copy code
mvn -version
3. Setup Instructions
Clone the repository:
bash
Copy code
git clone https://github.com/your-username/your-repository.git
Import the project into your IDE:
Open Eclipse or IntelliJ IDEA.
Select File > Import > Maven > Existing Maven Project.
Navigate to the project directory and click Finish.
Ensure Maven dependencies are installed by refreshing the project in your IDE.
4. Running the Tests
Configure the base URL in BaseTest.java:
java
Copy code
driver.get("https://fitpeo.com");
Open the testng.xml file in the project.
Right-click on the file and select Run As > TestNG Suite.
5. Results
View test execution results in the Console tab of your IDE.
For detailed reports:
Navigate to the test-output folder in the project directory.
6. Troubleshooting
Browser or WebDriver Issues:
Ensure ChromeDriver and Chrome browser versions match.
WebDriverManager should handle this automatically.
Missing Dependencies:
If errors occur, ensure Maven dependencies in pom.xml are downloaded correctly.
If not using Maven, add required JARs manually.
7. Project Structure
bash
Copy code
FitPeo-Automation-Project/
├── src/main/java/        # Contains POM classes
├── src/test/java/        # Contains test scripts
├── pom.xml               # Maven configuration file
├── testng.xml            # TestNG suite configuration
├── README.txt            # Project documentation
└── test-output/          # TestNG reports (generated after execution)
