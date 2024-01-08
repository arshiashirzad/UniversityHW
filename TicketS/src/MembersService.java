import java.util.List;
public class MembersService implements AccountManager {
    private List<User> users;

    private List<Supporter> supporters;
    public MembersService(String userDataFile) {
        this.userDataFile = userDataFile;
        this.users = DataFileHandler.loadUserData(userDataFile);
    }
    @Override
    public User Ulogin(String password,String email) {
        for (User user : users) {
            if (user.email.equals(email) && user.password.equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User UsignUp(String firstname,String lastname, String password, String email) {
        User newUser = new User(firstname,lastname, password,email);
        users.add(newUser);
        DataFileHandler.saveUserData(users, userDataFile);
        return newUser;
    }
    @Override
    public Supporter Slogin(String password , String email){
        for (Supporter supporter : supporters) {
            if (supporter.email.equals(email) && supporter.password.equals(password)) {
                return supporter;
            }
        }
        return null;
    }
}
