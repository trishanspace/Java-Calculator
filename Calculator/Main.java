public class Main {
    public static void main(String[] args) {
        CalculableFactory calculableFactory = new CalculatorFactory();
        GetData view = new GetData(calculableFactory);
        view.getting_data();
    }
}