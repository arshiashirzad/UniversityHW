import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataFileHandler {
    public static void saveUserData(List<User> users, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath,true))) {
            for (User user : users) {
                writer.println(user.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<User> loadUserData(String filePath) {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                users.add(new User(userData[0], userData[1],userData[2],userData[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
