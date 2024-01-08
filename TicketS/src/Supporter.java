public class Supporter {
    protected String firstname;
    protected String lastname;

    protected String password;
    protected String email;

    public Supporter(String firstname,String lastname, String password , String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
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

    public void displaySupporter() {
        System.out.println("Supporter: " + firstname + " "+ lastname );
    }

    @Override
    public String toString() {
        return firstname + ","+ lastname +"," + password + "," + email;
    }
}
