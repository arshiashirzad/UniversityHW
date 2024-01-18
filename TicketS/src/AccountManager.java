public interface AccountManager {
    Member Ulogin(String password, String email);
    Member UsignUp(String firstname,String lastname, String password,  String email);
    Member Slogin(String password, String email);
}