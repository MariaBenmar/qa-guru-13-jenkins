package guru.qa.hw7;

public class OwnershipDacha {
    int price;
    String address;
    boolean availableRent;
    Ground ground;
    public static boolean isRent;

    public OwnershipDacha(int price, String address, boolean availableRent, Ground ground) {
        this.price = price;
        this.address = address;
        this.availableRent = availableRent;
        this.ground = ground;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAvailableRent(boolean availableRent) {
        this.availableRent = availableRent;
    }

    public void setGround(Ground ground) {
        this.ground = ground;
    }

    public int getPrice() {
        return price;
    }

    public String getAddress() {
        return address;
    }

    public boolean isAvailableRent() {
        return availableRent;
    }

    public Ground getGround() {
        return ground;
    }

    public static int calculateddachaPriceForSeason(String season, int priceRent) {
        if (season.equals("high"))
            return priceRent * 2;
        return priceRent;
    }

    static class Ground {
        int numberOfAcres;
        int priceForAcr;
        String department;

        public Ground(int numberOfAcres, int priceForAcr, String department) {
            this.numberOfAcres = numberOfAcres;
            this.priceForAcr = priceForAcr;
            this.department = department;
        }

        public void setNumberOfAcres(int numberOfAcres) {
            this.numberOfAcres = numberOfAcres;
        }

        public void setPriceForAcr(int priceForAcr) {
            this.priceForAcr = priceForAcr;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public int getNumberOfAcres() {
            return numberOfAcres;
        }

        public int getPriceForAcr() {
            return priceForAcr;
        }

        public String getDepartment() {
            return department;
        }

        public void calculatedGroundPrice() {

            if (!isRent) {
                System.out.println("There current cost of the ground: " + getNumberOfAcres() * getPriceForAcr());
            } else {

                System.out.println("There UPDATED cost of the ground: " + getNumberOfAcres() * getPriceForAcr());
            }
            isRent = !isRent;

        }
    }
}