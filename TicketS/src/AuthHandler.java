import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class AuthHandler {
    public static void saveMemberData(List<Member> members, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Member member : members) {
                writer.println(member.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Member> loadMemberData(String filePath) {
        List<Member> members = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] memberData = line.split(",");
                members.add(new Supporter(memberData[0], memberData[1],memberData[2],memberData[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return members;
    }
}
