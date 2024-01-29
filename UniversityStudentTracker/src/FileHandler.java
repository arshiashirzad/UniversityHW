import java.io.*;
import java.util.ArrayList;
public class FileHandler implements IFileHandler{
    @Override
    public  ArrayList<Student> Read(String filePath){
        ArrayList<Student> studentsList = new ArrayList<Student>();
        try (BufferedReader reader = new BufferedReader(new FileReader("StData.txt"))) {
            //for ignoring first line of our text
            reader.readLine();
            String line;
            String FLine;
            while ((line = reader.readLine()) != null) {
                FLine = line.replaceAll("\\s+", ",");
                String[] studentData = FLine.split(",");
                studentsList.add(new Student(studentData[0] + studentData[1] ,studentData[2] , studentData[3] , Double.parseDouble(studentData[4])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentsList;
    }
    @Override
    public void Print(String studentInfo, String filePath){
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath,true))) {
            writer.println(studentInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
