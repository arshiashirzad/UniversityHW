public class Supporter extends Member {

    public Supporter(String firstname, String lastname, String password, String email) {
        super(firstname, lastname, password, email);
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }
    @Override
    public void displayInfo() {
        System.out.println("Supporter: " + firstname + " "+ lastname );
    }

}
