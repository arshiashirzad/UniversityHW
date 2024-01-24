public interface IAccountManager {
    Member Ulogin(String password, String email);
    boolean UsignUp(String firstname,String lastname, String password,  String email);
    Member Slogin(String password, String email);
}