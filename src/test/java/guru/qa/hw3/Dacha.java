package guru.qa.hw3;


public class Dacha {

    int price;
    String address;


    public static void main(String[] args) {
        Dacha dacha = new Dacha();
        dacha.price = 100;
        dacha.address = "derevnya Gorka, 10";
        dacha.setAddress();
        System.out.println("When season is high the price is " + figuredPrice("high", dacha.price) +
                ". For other time the price is " + figuredPrice("low", dacha.price));
    }

    public static int figuredPrice(String season, int priceRent) {
        if (season.equals("high"))
            return priceRent * 2;
        return priceRent;
    }

    public void setAddress() {
        System.out.println("There is address of the Dacha: " + address);
    }

}