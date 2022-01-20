package guru.qa.hw7;

public class DachaNew {
    int price;
    String address;

    public static int figuredPrice(String season, int priceRent) {
        if (season.equals("high"))
            return priceRent * 2;
        return priceRent;
    }

    public void printAddress() {
        System.out.println("There is address of the Dacha: " + address);
    }

}