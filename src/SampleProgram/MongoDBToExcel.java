package SampleProgram;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class MongoDBToExcel {
    public static void main(String[] args) {
		/*
		 * Logger logger = LoggerFactory.getLogger(MongoDBToExcel.class);
		 * logger.info("This is how you configure Java Logging with SLF4J");
		 */
        // MongoDB connection parameters
        String host = "mongodb://localhost:27017";
        int port = 27017;
        String dbName = "admin";
        String collectionName = "Employee";

        // Excel file path
        String excelFilePath = "mongodb_data.xlsx";

        try {
            // Connect to MongoDB
            MongoClient mongoClient = new MongoClient(host, port);
            MongoDatabase database = mongoClient.getDatabase(dbName);
            MongoCollection<Document> collection = database.getCollection(collectionName);

            // Retrieve data from MongoDB
            FindIterable<Document> documents = collection.find();

            // Create an Excel workbook
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet(" MongoDB Data");

            // Create a header row
            Row headerRow = sheet.createRow(0);
            int headerCellNum = 0;
            for (String key : documents.first().keySet()) {
                Cell headerCell = headerRow.createCell(headerCellNum++);
                headerCell.setCellValue(key);
            }

            // Populate the Excel sheet with data
            int rowNum = 1;
            for (Document document : documents) {
                Row row = sheet.createRow(rowNum++);
                int cellNum = 0;
                for (String key : document.keySet()) {
                    Cell cell = row.createCell(cellNum++);
                    cell.setCellValue(document.get(key).toString());
                }
            }

            // Save the Excel file
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            outputStream.close();

            // Close the MongoDB connection
            mongoClient.close();

            System.out.println("Data exported to Excel successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
