import javax.management.relation.Role;
import java.util.Scanner;
public class TicketSMain {
    public static void main(String[] args){
        Validator valid = new Validator();

        Scanner input = new Scanner(System.in);

        System.out.println("""
                            +==WELCOME=TO=TICKETS======+
                            |                          |
                            | 1. User                  |
                            | 2. Admin                 |
                            | 3. Exit                  |
                            |                          |
                            +==========================+""");
        System.out.println("Enter your role:");
        int RoleNo = input.nextInt();
        while(RoleNo< 1 || RoleNo>3){
            System.out.println("WRONG!Please enter a valid option: ");
            RoleNo = input.nextInt();
        }
        if(RoleNo ==1){
            MembersService mem =new MembersService("Users.txt");
            System.out.println("""
                            +==SignUp=Or=Login=========+
                            |                          |
                            | 1. SignUp                |
                            | 2. Login                 |
                            |                          |
                            +==========================+""");
            int op = input.nextInt();
            if(op ==1 ){
                System.out.println("enter your firstname: ");
                String firstname= input.nextLine();
                System.out.println("enter your lastname: ");
                String lastname= input.nextLine();
                System.out.println("CAUTION! YOUR PASSWORD must include at least 8 characters, including at least one digit, one lowercase, and one uppercase letter");
                System.out.println("enter your password: ");
                String password= input.nextLine();
                while(!valid.isValidPassword(password)){
                    System.out.println("WRONG PASSWORD FORMAT!enter your password in correct form: ");
                     password= input.nextLine();
                }
                System.out.println("enter your email: ");
                String email= input.nextLine();
                while(!valid.isValidEmail(email)){
                    System.out.println("WRONG email FORMAT!enter your email in correct form: ");
                    email= input.nextLine();
                }
                mem.UsignUp(firstname,lastname,password,email);
                System.out.println("SignUp operation done successfully!");
            }
        }
    }

}
