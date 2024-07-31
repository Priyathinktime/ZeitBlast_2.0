 package com.anhtester.projects.website.Zeitblast.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.anhtester.constants.FrameworkConstants;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ZeitblastAPI {

	public void APIDelevirey(int scenario) throws IOException, InterruptedException {

		String file = null;
	int noofdelivery=0;
		if (scenario == 1) {
			file = "Leadsdata1.xlsx";
			noofdelivery=FrameworkConstants.No_of_Delivery_1;
			
		} else if (scenario == 2) {
			file = "Leadsdata2.xlsx";
			noofdelivery=FrameworkConstants.No_of_Delivery_2;
		
		} else if (scenario == 3) {
			file = "Leadsdata3.xlsx";
			noofdelivery=FrameworkConstants.No_of_Delivery_3;
		
		}

		FileInputStream inputStream = new FileInputStream(FrameworkConstants.TESTDATA_FILE_PATH + File.separator + file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(0);




		for (int i = 1; i <= noofdelivery; i++) {
			Row row = sheet.getRow(i);

			if (row != null) {
				Cell phone1 = row.getCell(0); // Phone column
				Cell id = row.getCell(1); // Id column


				if (phone1 != null && id != null) {
					String to = "+1" + phone1.getStringCellValue();
					String Id = id.getStringCellValue();
					String From = "+1" +FrameworkConstants.OUTBOUND_NUMBER;
					 JSONObject messageJson = new JSONObject();
				        messageJson.put("id", Id);
				        messageJson.put("owner", From);
				        messageJson.put("applicationId", "40a864b3-b3f3-46ed-86eb-bb0fc2b85539");
				        messageJson.put("time", "2024-01-15T10:40:33.595Z");
				        messageJson.put("segmentCount", 1);
				        messageJson.put("direction", "out");
				        messageJson.put("to", new JSONArray().put(to));
				        messageJson.put("from", From);
				        messageJson.put("text", "");
				        messageJson.put("tag", "65a50b141efdcd4310db80cb");

				        JSONObject requestBodyJson = new JSONObject();
				        requestBodyJson.put("time", "2024-01-15T10:40:34.777158112Z");
				        requestBodyJson.put("type", "message-delivered");
				        requestBodyJson.put("to", to);
				        requestBodyJson.put("description", "invalid-destination-address");
				        requestBodyJson.put("message", messageJson);
				        requestBodyJson.put("errorCode", 4720);

				        // Creating the JSON array to match the manual string approach
				        JSONArray requestBodyArray = new JSONArray();
				        requestBodyArray.put(requestBodyJson);

				        // Sending the request
				        RestAssured.baseURI = FrameworkConstants.API_URL;// Replace with your base URI
				        RestAssured.given()
				            .contentType(ContentType.JSON)
				            .body(requestBodyArray.toString()) // Convert JSONArray to String
				            .when()
				            .post("/batch/smsStatus/change")
				            .then()
				            .assertThat()
				            .statusCode(200);
				}
			}
		}

		workbook.close();
		inputStream.close();
	}

	public void sendmsgAPI(int scenario) throws InterruptedException, IOException {

		String file = null;
		int noogmsg=0;
		if (scenario == 1) {
			file = "Leadsdata1.xlsx";
			noogmsg=FrameworkConstants.No_of_SendMSg_1;
		} else if (scenario == 2) {
			file = "Leadsdata2.xlsx";
			noogmsg=FrameworkConstants.No_of_SendMSg_2;
		} else if (scenario == 3) {
			file = "Leadsdata3.xlsx";
			noogmsg=FrameworkConstants.No_of_SendMSg_3;
		}
		FileInputStream inputStream = new FileInputStream(FrameworkConstants.TESTDATA_FILE_PATH + File.separator + file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(0);


		for (int i = 1; i <=noogmsg; i++) {
			Row row = sheet.getRow(i);

			if (row != null) { 
				Cell phone1 = row.getCell(0); // Phone column
				Cell id = row.getCell(1); // Id column
				

				if (phone1 != null && id != null) {
					String From = "+1" + phone1.getStringCellValue();

					String To = "+1" +FrameworkConstants.OUTBOUND_NUMBER;
					String currentTime = LocalDateTime.now()
							.format(DateTimeFormatter.ofPattern("HH:mm:ss:SSS:dd/MM/yyyy"));


				            String text;
				            switch (i % 4) {
				                case 0:
				                    text = "Hi " + From + ", the current time is " + currentTime + ". Case 0 message.";
				                    break;
				                case 1:
				                    text = "Hello " + From + ", it's " + currentTime + ". Case 1 message.";
				                    break;
				                case 2:
				                    text = "Hey " + From + ", right now it's " + currentTime + ". Case 2 message.";
				                    break;
				                case 3:
				                    text = "Greetings " + From + ", the time is " + currentTime + ". Case 3 message.";
				                    break;
				                default:
				                    text = "Hi " + From + ", the current time is " + currentTime + ". Default message.";
				                    break;
				            }	
					
//					String text = "Hi"+ From +",the current time is  " + currentTime;
					String uuid = UUID.randomUUID().toString();

					 JSONObject message = new JSONObject();
				        message.put("id", uuid);
				        message.put("owner", "+13053064278");
				        message.put("applicationId", "40a864b3-b3f3-46ed-86eb-bb0fc2b85539");
				        message.put("time", "2023-12-04T06:53:24.721257Z");
				        message.put("segmentCount", 1);
				        message.put("direction", "in");
				        message.put("to", new JSONArray().put(To));
				        message.put("from", From);
				        message.put("text", text);

				        // Create the outer JSONObject
				        JSONObject requestBodyJson = new JSONObject();
				        requestBodyJson.put("time", "2023-12-04T06:53:24.839233Z");
				        requestBodyJson.put("type", "message-received");
				        requestBodyJson.put("to", To);
				        requestBodyJson.put("description", "Incoming message received");
				        requestBodyJson.put("message", message);

				        // Put the outer JSONObject into a JSONArray
				        JSONArray requestBodyArray = new JSONArray();
				        requestBodyArray.put(requestBodyJson);

				        RestAssured.baseURI = FrameworkConstants.API_URL;
				        RestAssured.given().header("Cookie", FrameworkConstants.API_HEADER)
				                .contentType(ContentType.JSON).body(requestBodyArray.toString()).when()
				                .post("/batch/inbound/callback").then().assertThat().statusCode(200);
				}
			}

			workbook.close();
			inputStream.close();
		}
	}
	
	public void sendmsgforparticularno(String phonenum) {
		String From = "+1" + phonenum;

		String To = "+1" +FrameworkConstants.OUTBOUND_NUMBER;
		String currentTime = LocalDateTime.now()
				.format(DateTimeFormatter.ofPattern("HH:mm:ss:SSS:dd/MM/yyyy"));

		String text = "Reply msg " + currentTime;
		String uuid = UUID.randomUUID().toString();

		String requestBody = "[{" + "\"time\": \"2023-12-04T06:53:24.839233Z\","
				+ "\"type\": \"message-received\"," + "\"to\": \"" + To + "\","
				+ "\"description\": \"Incoming message received\"," + "\"message\": {" + "\"id\": \"" + uuid
				+ "\"," + "\"owner\": \"+13053064278\","
				+ "\"applicationId\": \"40a864b3-b3f3-46ed-86eb-bb0fc2b85539\","
				+ "\"time\": \"2023-12-04T06:53:24.721257Z\"," + "\"segmentCount\": 1,"
				+ "\"direction\": \"in\"," + "\"to\": [ \"" + To + "\" ]," + "\"from\": \"" + From + "\","
				+ "\"text\": \"" + text + "\"" + "}" + "}]";
		RestAssured.baseURI = FrameworkConstants.API_URL;

		RestAssured.given().header("Cookie",
				FrameworkConstants.API_HEADER)
				.contentType(ContentType.JSON).body(requestBody).when().post("/batch/inbound/callback")
				.then().assertThat().statusCode(200);
	}
}
