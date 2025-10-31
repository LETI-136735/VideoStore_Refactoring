package team;

public class Rental {

    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public double getAmount() {
        return _movie.getRentalAmount(_daysRented);
    }

    public int getFrequentRentalPoints(int frequentRenterPoints) {
        frequentRenterPoints += _movie.getFrequentRentalPoints(_daysRented);
        return frequentRenterPoints;
    }
}
