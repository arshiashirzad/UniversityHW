import java.util.ArrayList;
public interface IFileHandler {
    ArrayList<Student> Read(String filePath);
    void Print(String studentInfo, String filePath);
}
