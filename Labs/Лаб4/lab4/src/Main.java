public class Main {
    public static void main(String[] args) {
        try {
            int age = 150;
            if (age < 0 || age > 120) {
                throw new CustomAgeException("Недопустимый возраст");
            } else {
                System.out.println(age);
            }
        } catch (CustomAgeException e) {
            ExceptionHandler.logException(e);
            System.out.println(e.getMessage());
        }
    }
}
