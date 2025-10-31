package team;

public abstract class Price {

    public abstract double getRentalAmount(int daysRented);

    public int getFrequentRentalPoints(int daysRented) {
        return 1;
    }
}
