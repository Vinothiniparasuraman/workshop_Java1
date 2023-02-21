import com.provility.workshop.CSVRecords;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;

public class Jsonmain {
    public static <json> void main(String... args) {

            List<json> csvFilesRecords = (List<json>) readBooksFromCSV1();
            for (json TransactionRecords : csvFilesRecords) {
                System.out.println(TransactionRecords);
            }


        }
        private static <json> List<json> readBooksFromCSV1() {
            List<json> csvFiles1 = new ArrayList<>();
            Path pathToFile = Paths.get("WarmingStations_Incomm_Ex (1).json");

            try (BufferedReader br = Files.newBufferedReader(pathToFile,
                    StandardCharsets.US_ASCII)) {
                String line = br.readLine();
                while (line != null) {

                    String[] attributes = line.split(",");
                    json book = (json) createBook(attributes);
                    csvFiles1.add(book);
                    line = br.readLine();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            return csvFiles1;
        }

        private static Json createBook(String[] metadata) {

            String ID =metadata[0] ;
            String Name =metadata[1] ;
            String PhoneNumber =metadata[2] ;
            String Address =metadata[3] ;
            String Description =metadata[4] ;
            String Coordinates =metadata[5] ;
            String TravelRoute =metadata[6] ;
            return new Json(ID, Name, PhoneNumber,Address,Description,Coordinates,TravelRoute);
        }
    }

