# FitPeo Automation Project

## Description

This project automates testing for the FitPeo website using **Selenium WebDriver**, **TestNG**, and the **Page Object Model (POM)** design pattern. The automation scripts focus on testing the core functionalities of the website, including navigating through different pages and performing calculations.

### Key Features:
- **Selenium WebDriver**: For browser automation.
- **TestNG**: For running and organizing tests.
- **Page Object Model**: For maintaining test scripts.
- **WebDriverManager**: For managing browser drivers dynamically.

## Prerequisites

Before setting up the project, ensure that you have the following tools and software installed:

1. **Java Development Kit (JDK)**:
   - Install JDK 8 or higher.
   - Verify installation:
     ```bash
     java -version
     javac -version
     ```

2. **Eclipse IDE** or **IntelliJ IDEA**:
   - Download and install an IDE of your choice.

3. **Maven** (Optional, if using Maven for dependency management):
   - Install Maven from [Maven Downloads](https://maven.apache.org/download.cgi).
   - Verify installation:
     ```bash
     mvn -version
     ```

4. **WebDriverManager**:
   - WebDriverManager handles the management of the browser drivers (e.g., ChromeDriver) automatically, so no manual setup is required.

5. **TestNG Plugin** for Eclipse/IntelliJ:
   - Install the TestNG plugin for Eclipse or IntelliJ to run the tests.

6. **Google Chrome** (or other supported browsers):
   - Ensure the latest version of Google Chrome is installed.

## Project Setup

1. **Download the Source File**
   - Clone or download the project repository to your local machine.

2. **Open the Project in Your IDE**:
   - Open Eclipse or IntelliJ IDEA and import the project as a **Maven project** if Maven is used.

3. **Install Dependencies**:
   - If you’re using Maven, the required dependencies will be automatically handled via the `pom.xml` file.

# Test Execution

### Configure the Test URL:

Open the `BaseTest.java` file and ensure the URL in the script is correct:

```java
driver.get("https://fitpeo.com");

**Run the Test**

- Open the `RevenueCalculatorTest.java` file.
- Right-click on the file and select **Run As > TestNG Test** (or use the TestNG configuration in your IDE).

**View Test Results**

- The test execution results will be displayed in the **Console** tab of your IDE.
- For detailed reports, check the **test-output** folder in the project directory, where **TestNG** generates the HTML reports.

   
