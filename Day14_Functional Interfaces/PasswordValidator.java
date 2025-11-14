interface SecurityUtils {
    static boolean isStrong(String password) {
        return password.length() >= 8 && password.matches(".*[0-9].*");
    }
}

public class PasswordValidator {
    public static void main(String[] args) {
        System.out.println(SecurityUtils.isStrong("hello123"));
    }
}



