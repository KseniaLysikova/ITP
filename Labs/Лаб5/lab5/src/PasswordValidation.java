public class PasswordValidation {
    public static void main(String[] args) {
        String password = "JAdhbnmfeib7";
        String regex = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}";
        if (password.matches(regex)) {
            System.out.println("TRUE");
        } else {
            System.out.println("False");
        }
    }
}
