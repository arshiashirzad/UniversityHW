import java.rmi.StubNotFoundException;
import java.util.ArrayList;

public class Classificator {
    public void sort(ArrayList<Student> unsortedList){
        FileHandler fileHandler = new FileHandler();
        for(Student s : unsortedList){
            //PHD STUDENTS:
            if(s.studentNo.startsWith("89")){
                fileHandler.Print(s.toString(),"PhDStd.txt");
            }else if(s.studentNo.startsWith("41")){
                fileHandler.Print(s.toString(),"MScStd.txt");
            }else if(s.studentNo.startsWith("60")){
                fileHandler.Print(s.toString(),"BScStd.txt");
            }else{
                fileHandler.Print(s.toString(),"WrongStData.txt");
            }
        }
    }
}
