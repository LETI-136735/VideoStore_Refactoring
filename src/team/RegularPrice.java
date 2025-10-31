package team;

public class RegularPrice extends Price {

    @Override
    public double getRentalAmount(int daysRented) {
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;
    }
}
