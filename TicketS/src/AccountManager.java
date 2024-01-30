import java.util.List;

public class AccountManager implements IAccountManager {
    private List<Member> members;
    private String DataFile ;
    private boolean flg=true;
    public AccountManager(String DataFile) {
        this.DataFile = DataFile;
        this.members = AuthHandler.loadMemberData(DataFile);
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
    public boolean UsignUp(String firstname,String lastname, String password, String email) {
        for (Member member : members){
            if(member.email.equals(email)) {
                flg = false;
            }
        }
        User newUser = new User(firstname,lastname, password,email);
        members.add(newUser);
        AuthHandler.saveMemberData(members, DataFile);
        return flg;
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
