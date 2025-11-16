import java.util.Scanner;


class InvalidCredentialException extends Exception {
    public InvalidCredentialException(String message) {
        super(message);
    }
}

class LoginSystem {
    private String validUser = "admin";
    private String validPass = "1234";

    public void login(String user, String pass) throws InvalidCredentialException {
        if (!user.equals(validUser) || !pass.equals(validPass)) {
            throw new InvalidCredentialException("Invalid Username or Password!");
        }
        System.out.println(user);
    }
}


public class LoginSystem1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LoginSystem loginSystem = new LoginSystem();

        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.print("Enter Username: ");
            String user = sc.nextLine();

            System.out.print("Enter Password: ");
            String pass = sc.nextLine();

            try {
                loginSystem.login(user, pass);
                loggedIn = true;
            } 
            catch (InvalidCredentialException e) {
                System.out.println(e.getMessage());
                System.out.println("Please try again.\n");
            }
        }

        sc.close();
    }
}
