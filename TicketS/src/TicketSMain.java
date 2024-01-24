import java.util.Scanner;
public class TicketSMain {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("""
                    +==WELCOME=TO=TICKETS======+
                    | 1. User                  |
                    | 2. Admin                 |
                    +==========================+""");
            System.out.println("Enter your role:");
            int RoleNo = input.nextInt();
            while (RoleNo < 1 || RoleNo > 3) {
                System.out.println("WRONG!Please enter a valid option: ");
                RoleNo = input.nextInt();
            }
            if (RoleNo == 1) {
                System.out.println("""
                        +==SignUp=Or=Login=========+
                        | 1. SignUp                |
                        | 2. Login                 |
                        +==========================+""");
                int op = input.nextInt();
                if (op == 1) {
                    URegister();
                } else if (op == 2) {
                    Member loggedInUser = Ulogin();
                    if (loggedInUser != null) {
                        System.out.println("LOGGED IN SUCCESSFULLY");
                        loggedInUser.displayInfo();
                    } else {
                        System.out.println("Password or Email is incorrect , try again!");
                    }
                }
            }
        }
    }
    public static void URegister(){
        MembersService mem =new MembersService("Users.txt");
        Validator valid = new Validator();
        Scanner input = new Scanner(System.in);
        System.out.println("enter your firstname: ");
        String firstname= input.nextLine();
        System.out.println("enter your lastname: ");
        String lastname= input.nextLine();
        System.out.println("CAUTION! YOUR PASSWORD must include at least 8 characters, including at least one digit, one lowercase, and one uppercase letter");
        System.out.println("enter your password: ");
        String password= input.nextLine();
        while(!valid.isValidPassword(password)){
            System.out.println("WRONG PASSWORD FORMAT!");
            password= input.nextLine();
        }
        System.out.println("enter your email: ");
        String email= input.nextLine();
        while(!valid.isValidEmail(email)){
            System.out.println("WRONG email FORMAT!");
            email= input.nextLine();
        }
        boolean isSignedUp= mem.UsignUp(firstname,lastname,password,email);
        if (isSignedUp){
            System.out.println("SignUp operation done successfully!");
        }else{
            System.out.println("Almost an account exists with the entered email");
        }
    }
    public static Member Ulogin(){
        MembersService mem =new MembersService("Users.txt");
        Validator valid = new Validator();
        Scanner input = new Scanner(System.in);
        System.out.println("enter your email: ");
        String email= input.nextLine();
        while(!valid.isValidEmail(email)) {
            System.out.println("WRONG email FORMAT!");
            email = input.nextLine();
        }
            System.out.println("enter your password: ");
            String password= input.nextLine();
            while(!valid.isValidPassword(password)){
                System.out.println("WRONG PASSWORD FORMAT!");
                password= input.nextLine();
            }
            return mem.Ulogin(password,email);
    }
}
