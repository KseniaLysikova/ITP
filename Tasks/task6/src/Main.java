import java.util.List;
import java.util.Stack;

public class Main {
    // Вспомогательная функция для возврата приоритета данного оператора.
    // Обратите внимание, что выше приоритет, ниже его значение
    public static int prec(char c)
    {
        // Умножение и деление
        if (c == '*' || c == '/') {
            return 3;
        }

        // Сложение и вычитание
        if (c == '+' || c == '-') {
            return 4;
        }

        return Integer.MAX_VALUE;            // для открывающей скобки '('
    }

    // Вспомогательная функция для проверки, является ли данный токен операндом
    public static boolean isOperand(Character s)
    {
        return (s >= '0' && s <= '9');
    }

    // Функция для преобразования инфиксного выражения в постфиксное выражение.
    // Эта функция ожидает корректное инфиксное выражение
    public static String infixToPostfix(String infix)
    {
        // базовый вариант


        // создаем пустой stack для хранения операторов
        Stack<Character> s = new Stack<>();

        // создаем строку для хранения постфиксного выражения
        String postfix = "";

        // обрабатываем инфиксное выражение слева направо
        for (char c: infix.toCharArray())
        {
            // Случай 1. Если текущий токен является открывающей скобкой '(',
            // помещаем его в stack
            if (c == '(') {
                s.add(c);
            }
            // Случай 2. Если текущий токен является закрывающей скобкой ')'
            else if (c == ')')
            {
                // извлекать токены из stack до соответствующего открытия
                // скобка '(' удалена. Добавляем каждый оператор в конце
                // постфиксного выражения
                while (s.peek() != '(') {
                    postfix += s.pop();
                }
                s.pop();
            }

            // Случай 3. Если текущий токен является операндом, добавляем его в конец
            // постфиксного выражения
            else if (isOperand(c)) {
                postfix += s.pop();
            }

            // Случай 4. Если текущий токен является оператором
            else {
                // удаляем из stack операторы с более высоким или равным приоритетом
                // и добавляем их в конец постфиксного выражения
                while (!s.isEmpty() && prec(c) >= prec(s.peek())) {
                    postfix += s.pop();
                }


                // наконец, помещаем текущий оператор на вершину stack
                s.add(c);
            }
        }

        // добавляем все оставшиеся операторы в stack в конце
        // постфиксного выражения
        while (!s.isEmpty()) {
            postfix += s.pop();
        }

        // возвращаем постфиксное выражение
        return postfix;
    }

    public static void main(String[] args)
    {
        String infix = "6 - 18 / ( -1 + 4)";


        String postfix = infixToPostfix(infix);
        System.out.println(infix);
        System.out.println(postfix);

        Stack<Double> st = new Stack<>();
        double a1,a2,r;
        String[] cmd = postfix.split("");
        String a;
        char c;
        int i;
        for (i=0; i<cmd.length; i++)
        {
            a=cmd[i];
            c=a.charAt(0);
            if (c>='0' && c<='9')
            {
                st.push(Double.parseDouble(a));
            }
            else
            {
                switch (c)
                {
                    case '+':
                        a2=st.pop();
                        a1=st.pop();
                        r=a1+a2;
                        st.push(r);
                        break;
                    case '-':
                        a2=st.pop();
                        a1=st.pop();
                        r=a1-a2;
                        st.push(r);
                        break;
                    case '*':
                        a2=st.pop();
                        a1=st.pop();
                        r=a1*a2;
                        st.push(r);
                        break;
                    case '/':
                        a2=st.pop();
                        a1=st.pop();
                        r=a1/a2;
                        st.push(r);
                        break;
                }
            }
        }
        System.out.println(st.pop());
    }
}
