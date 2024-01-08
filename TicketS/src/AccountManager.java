public interface AccountManager {
    User Ulogin(String password, String email);
    User UsignUp(String firstname,String lastname, String password,  String email);
    Supporter Slogin(String password, String email);
}
