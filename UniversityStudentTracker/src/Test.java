import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        FileHandler fileHandler = new FileHandler();
        ArrayList<Student> students = fileHandler.Read("StData.txt");
        Classificator sorter = new Classificator();
        sorter.sort(students);
        System.out.println("Data's where Sorted SUCCESSFULLY! Check files!");
    }
}
