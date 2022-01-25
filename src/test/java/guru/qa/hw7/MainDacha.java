package guru.qa.hw7;


public class MainDacha {

    public static void main(String[] args) {
        OwnershipDacha dachaGorka = new OwnershipDacha(10000, "derevnya Gorka, 10", true, new OwnershipDacha.Ground(12, 500, "Kingisepp area"));

        System.out.println("The price of the dacha is " + dachaGorka.getPrice());
        System.out.println("The address of the dacha is : " + dachaGorka.getAddress());
        System.out.println("Availability for rent: " + dachaGorka.isAvailableRent());

        dachaGorka.ground.calculatedGroundPrice();
        dachaGorka.ground.setNumberOfAcres(15);
        dachaGorka.ground.calculatedGroundPrice();

        System.out.println("When season is high the price fo RENT is " + OwnershipDacha.calculateddachaPriceForSeason("high", dachaGorka.price) +
                ". For other time the price for RENT is " + OwnershipDacha.calculateddachaPriceForSeason("low", dachaGorka.price));
    }
}
