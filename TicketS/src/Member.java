public class Member {
    protected String firstname;
    protected String lastname;

    protected String password;
    protected String email;

    public Member(String firstname,String lastname, String password , String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
    }
    public void displayInfo() {
        System.out.println("Info: " + firstname + " "+ lastname );
    }
    @Override
    public String toString() {
        return firstname + ","+ lastname +"," + password + "," + email;
    }
}
