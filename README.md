**1. **Pre-Condition****
Ensure the following dependencies are installed:

***Selenium WebDriver** (for UI Testing)
***RestAssured** (for API Testing)
***mongodb-driver-sync** (for MongoDB connectivity)
***jsch** (for server connectivity)

Before initializing the test, start the server and VM:

**Start the QA Server**: https://4mddoupqew7iut5tezqetql27q0vrosd.lambda-url.us-east-1.on.aws/start

**Start the VM**: https://jmkihuxdio4fuacce56ljehlue0jtszg.lambda-url.us-east-1.on.aws/start

Allow at least **3 minutes** for the server to start before running the test suites.

**2. Updating Dynamic Values**
*Navigate to the ZeitBlast-QA-Automation repository on GitHub.
*Go to the path: src/test/resources/config/Zeitblast.properties.
*Update the required fields with the desired values.

**3. File Upload Scenario**
Step 1: Navigate to: src/test/resources/testdata.
         Add the Test Lead Data files.
         
Step 2:Navigate to: src/test/resources/features.
         Modify the appropriate files, ensuring the correct file name is used.
         
Example: "And The user uploads the excel file "AutomationData100.xlsx" in the import file field"
Replace "AutomationData100.xlsx" with the exact file name from the test data.

**4. Email Configuration**
To send reports via email:

Navigate to: src/main/java/com/anhtester/mail/EmailConfig.java.

Set your FROM address, PASSWORD, and TO address/addresses. 
Example: public static final String SERVER = "smtp.gmail.com";
public static final String PORT = "465";
public static final String FROM = "your-email@example.com";
public static final String PASSWORD = "your-password";
public static final String[] TO = {"recipient1@example.com", "recipient2@example.com"};

Then go to: src/test/resources/config/config.properties.

Change SEND_EMAIL_TO_USERS = "no" to "yes".

**5. Running a Specific Test in GitHub Actions (Manually)**
*Go to the Actions page in the repository.
*Navigate to the Actions column on the left.
*Click on the desired test to run.
*Click Run Workflow on the right.
*Confirm by clicking Run Workflow in the popup banner.

**6. Running the Entire Test Suite (Manually)**
*Go to the Actions page in the repository.
*Navigate to the Actions column on the left.
*Click on "entiretest" to run the tests sequentially.
*Click Run Workflow on the right.
*Confirm by clicking Run Workflow in the popup banner.

**7. View the test reports once completed**
*Go to the Actions page in the repository.
*Click on the latest test that has been run.
*Click on the number displayed under "Artifacts."
*Scroll down to find the "SparkReport."
*Click on "Download SparkReport" to download the ZIP file.
*Extract the ZIP file to view the results.

**8. Post-Condition**
After each use, switch off the QA server and VM:

**Stop the QA Server:** https://4mddoupqew7iut5tezqetql27q0vrosd.lambda-url.us-east-1.on.aws/stop

**Stop the VM:** https://jmkihuxdio4fuacce56ljehlue0jtszg.lambda-url.us-east-1.on.aws/stop



