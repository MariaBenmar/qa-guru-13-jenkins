package guru.qa.hw3;

public class Main {
    public static void main(String[] args) {
        Dacha dacha = new Dacha();
        dacha.price = 100;
        dacha.address = "derevnya Gorka, 10";
        dacha.printAddress();
        System.out.println("When season is high the price is " + Dacha.figuredPrice("high", dacha.price) +
                ". For other time the price is " + Dacha.figuredPrice("low", dacha.price));
    }
}
