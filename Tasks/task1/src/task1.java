// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class task1 {
    public static void main(String[] args) {
        System.out.println("____task 1____");
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));
        System.out.println("____task 2____");
        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));
        System.out.println("____task 3____");
        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));
        System.out.println("____task 4____");
        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));
        System.out.println("____task 5____");
        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));
        System.out.println("____task 6____");
        System.out.println(howManyItems(22, 1.4, 2));
        System.out.println(howManyItems(45, 1.8, 1.9));
        System.out.println(howManyItems(100, 2, 2));
        System.out.println("____task 7____");
        System.out. println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));
        System.out.println("____task 8____");
        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));
        System.out.println("____task 9____");
        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));
        System.out.println("____task 10____");
        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));
    }

    public static float convert(int x) {
        return x * 3.785f;
    }

    public static double fitCalc (double x, double y) {
        return (x*y);
    }

    public static int containers(int x, int y, int z) {
        return x * 20 + y * 50 + z * 100;
    }

    public static String triangleType(int x, int y, int z) {
        if ((x + y < z) || (x + z < y) || (y + z < x)) {
            return "not a triangle";
        }
        else if (((x == y) && (x != z)) || (x == z) && (x != y) || (y == z) && (y != x)) {
            return "equilateral";
        }
        else if (x == z && y == z) {
            return "isosceles";
        }
        else return "different-sided";
    }

    public static int ternaryEvaluation(int x, int y) {
        return x > y ? x : y;
    }

    public static int howManyItems(int x,  double y, double z) {
        return (int) (x/(z*y*2));
    }

    public static int factorial(int x) {
        int y = x;
        while (y > 1) {
            y -= 1;
            x *= y;
        }
        return x;
    }

    public static int gcd(int x, int y) {
        int result = 1;
        for (int i = 1; i <= x && i <= y; i++) {
            if (x % i == 0 && y % i == 0) {
                result = i;
            }
        }
        return result;
    }

    public static int ticketSaler(int x, int y) {
        double commission = 0.72;
        int result = (int) (x * y * commission);
        return result;
    }

    public static int tables (int x, int y) {
        if (y * 2 >= x) {
            return 0;
        }
        else return (x / 2 - y) + 1;
    }
}