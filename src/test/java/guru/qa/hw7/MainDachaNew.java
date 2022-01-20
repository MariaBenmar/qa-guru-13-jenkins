package guru.qa.hw7;


public class MainDachaNew {
    public static void main(String[] args) {
        DachaNew dacha = new DachaNew();
        dacha.price = 100;
        dacha.address = "derevnya Gorka, 10";
        dacha.printAddress();
        System.out.println("When season is high the price is " + DachaNew.figuredPrice("high", dacha.price) +
                ". For other time the price is " + DachaNew.figuredPrice("low", dacha.price));
    }
}
