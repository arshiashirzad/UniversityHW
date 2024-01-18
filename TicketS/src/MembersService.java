import java.util.List;
public class MembersService implements AccountManager {
    private List<Member> members;
    private String DataFile ;
    public MembersService(String DataFile) {
        if(DataFile.equals("Users.txt")){
        this.DataFile = DataFile;
        this.members = DataFileHandler.loadMemberData(DataFile);
        }
        if(DataFile.equals("Supporters.txt")){
            this.DataFile = DataFile;
            this.members = DataFileHandler.loadMemberData(DataFile);
        }
    }
    @Override
    public Member Ulogin(String password,String email) {
        for (Member member : members) {
            if (member.email.equals(email) && member.password.equals(password)) {
                return member;
            }
        }
        return null;
    }
    @Override
    public Member UsignUp(String firstname,String lastname, String password, String email) {
        User newUser = new User(firstname,lastname, password,email);
        members.add(newUser);
        DataFileHandler.saveMemberData(members, DataFile);
        return newUser;
    }
    @Override
    public Member Slogin(String password , String email){
        for (Member member : members) {
            if (member.email.equals(email) && member.password.equals(password)) {
                return member;
            }
        }
        return null;
    }
}
