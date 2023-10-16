package SampleProgram;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.Document;

import java.io.FileOutputStream;
import java.io.IOException;

public class JavaToMango {
	public static void main(String[] args) {
        // MongoDB Connection Parameters
        String mongoURI = "mongodb://localhost:27017"; // MongoDB URI
        String databaseName = "Employee";
        String collectionName = "Employee";

        try (MongoClient mongoClient = MongoClients.create(mongoURI)) {
            // Connect to the MongoDB database
            MongoDatabase database = mongoClient.getDatabase(databaseName);
            MongoCollection<Document> collection = database.getCollection(collectionName);

            // Create a new Excel workbook
            try (Workbook workbook = new XSSFWorkbook()) {
                // Create a new Excel sheet
                Sheet sheet = workbook.createSheet("MongoDB Data");

                // Retrieve data from MongoDB collection
                MongoCursor<Document> cursor = collection.find().iterator();

                int rowNumber = 0;
                while (cursor.hasNext()) {
                    Document document = cursor.next();

                    Row row = sheet.createRow(rowNumber++);
                    int cellNumber = 0;

                    // Iterate over document fields and add them to the Excel sheet
                    for (String key : document.keySet()) {
                        Cell cell = row.createCell(cellNumber++);

                        // Convert the value to a string and set it in the cell
                        cell.setCellValue(document.get(key).toString());
                    }
                }

                // Save the Excel workbook to a file
                try (FileOutputStream outputStream = new FileOutputStream("MongoDB Data.xlsx")) {
                    workbook.write(outputStream);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Data exported to MongoDBData.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
