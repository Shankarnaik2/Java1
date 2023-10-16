package SampleProgram;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.Document;

import java.io.FileOutputStream;

public class MongoDBToExcelDownloader {
    public static void main(String[] args) {
        // MongoDB connection parameters
        String mongoHost = "localhost";
        int mongoPort = 27017;
        String dbName = "Employee";
        String collectionName = "Employee";

        // Excel file name
        String excelFileName = "mongodb_data.xlsx";

        try {
            // Connect to MongoDB
            MongoClient mongoClient = new MongoClient(mongoHost, mongoPort);
            MongoDatabase database = mongoClient.getDatabase(dbName);
            MongoCollection<Document> collection = database.getCollection(collectionName);

            // Create a new workbook and sheet
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("MongoDB Data");

            // Create a header row
            Row headerRow = sheet.createRow(0);

            // Add headers for your data
            headerRow.createCell(0).setCellValue("id");
            headerRow.createCell(1).setCellValue("name");
            headerRow.createCell(1).setCellValue("Dept");
            // Add more headers as needed

            // Query MongoDB collection
            MongoCursor<Document> cursor = collection.find().iterator();

            int rowNumber = 1; // Start with the second row (index 1)
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Row row = sheet.createRow(rowNumber++);

                // Add data to each cell in the row
                row.createCell(0).setCellValue(document.getInteger("id"));
                row.createCell(1).setCellValue(document.getString("name"));
                row.createCell(1).setCellValue(document.getString("Dept"));
             // Add more cells as needed
            }

            // Save the Excel file
            try (FileOutputStream fileOut = new FileOutputStream(excelFileName)) {
                workbook.write(fileOut);
                System.out.println("Excel file saved: " + excelFileName);
            }

            // Close MongoDB connection
            mongoClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
