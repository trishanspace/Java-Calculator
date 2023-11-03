import java.util.Scanner;

public class GetData {

    private CalculableFactory calculableFactory;

    public GetData(CalculableFactory calculableFactory) {
        this.calculableFactory = calculableFactory;
    }

    public void getting_data() {
        while (true) {
            int primaryArg = promptInt("Введите первое значение: ");
            Calculable calculator = calculableFactory.create(primaryArg, true);
            while (true) {
                String command = prompt("Введите команду (*, +, =) : ");
                if (command.equals("*")) {
                    int arg = promptInt("Введите второе значение: ");
                    calculator.multi(arg);
                    continue;
                }
                if (command.equals("+")) {
                    int arg = promptInt("Введите второе значение: ");
                    calculator.sum(arg);
                    continue;
                }
                if (command.equals("=")) {
                    int result = calculator.getResult();
                    System.out.printf("Результат %d\n", result);
                    break;
                }
            }
            String command = prompt("Продолжить? (Yep/Nope): ");
            if (command.equals("Yep")) {
                continue;
            }
            else System.out.print("Ok(");
            break;
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private int promptInt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return Integer.parseInt(in.nextLine());
    }
}