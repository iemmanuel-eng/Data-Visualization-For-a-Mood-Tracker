import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class DataManager {
     private Path filePath;
     private Scanner scan = new Scanner(System.in);

     public void createCSV(){
          Path path = Path.of("MoodData.csv");
          if(Files.exists(path)){
               System.out.println("File exists. Setting active file to \"MoodData.csv\"");
               setFilePath(path);
          }
          if(!Files.exists(path)){
               try {
                   Files.createFile(path);
                   setFilePath(path);
               } catch (IOException e) {
                    System.out.println("Error occured, cannot create file due to exception: " + e);
                    return;
               }
               try(BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, StandardOpenOption.APPEND);) {
                    String header = "Date,HoursOfSleep,Exercise,Assessments,HoursOfFreeTime,Mood";
                    writer.write(header);
                    writer.newLine();
               } catch (IOException e) {
                    System.out.println("Couldn't write to the file because of this error: " + e);
               }
          }
     }
     public Path getFilePath(){
          return filePath;
     }
     public void setFilePath(String newPath){
          filePath = Path.of(newPath);
     }
     public void setFilePath(Path newPath){
          filePath = newPath;
     }
     public void updateData(DataEntry data){
          System.out.println("This is the string to be appended: " + data.returnDataEntryString());
          System.out.println("Is this the string you want? y/n");
          String yesOrNo = scan.nextLine();
          if(yesOrNo.contains("N") || yesOrNo.contains("n")){
               return;
          }
          if(yesOrNo.contains("Y") || yesOrNo.contains("y")){
               try(BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, StandardOpenOption.APPEND);) {
                    writer.write(data.returnDataEntryString());
                    writer.newLine();
                    System.out.println("File updated");
          } catch (IOException e) {
               System.out.println("Couldn't write to the file because of this error: " + e);
          }
          }
     }

}