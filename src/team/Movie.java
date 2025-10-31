package team;

import java.util.Vector;

public class Movie {

    private String _title;
    private Price _price;

    public Movie(String title, Price.Code priceCode) {
        _title = title;
        _price = new Price(priceCode);
    }

    public String getTitle() {
        return _title;
    }

    public Price getPrice() {
        return _price;
    }

    public Price.Code getPriceCode() {
        return _price.getCode();
    }

    // Delegaciones opcionales para mantener compatibilidad con llamadas existentes
    public double getRentalAmount(int daysRented) {
        return _price.getRentalAmount(daysRented);
    }

    public int getFrequentRentalPoints(int daysRented) {
        return _price.getFrequentRentalPoints(daysRented);
    }

    // --- Tu clase Customer tal cual estaba ---
    public static class Customer {
        private String _name;
        private Vector<Rental> _rentals = new Vector<Rental>();

        public Customer(String name) {
            this._name = name;
        }

        public void addRental(Rental arg) {
            _rentals.addElement(arg);
        }

        public String getName() {
            return _name;
        }

        public int getaRentalAmount() {
            int totalAmount = 0;
            for (Rental each : _rentals) {
                totalAmount += each.getAmount();
            }
            return totalAmount;
        }

        public int getTotalFrequentRenterPoints() {
            int frequentRenterPoints = 0;
            for (Rental each : _rentals) {
                frequentRenterPoints = each.getFrequentRentalPoints(frequentRenterPoints);
            }
            return frequentRenterPoints;
        }

        public String statement() {
            String result = "Rental Record for " + getName() + "\n";

            for (Rental each : _rentals) {
                double thisAmount = each.getAmount();
                result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
            }

            result += "Amount owed is " + getaRentalAmount() + "\n";
            result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
            return result;
        }

        public String htmlStatement() {
            String result = "<h1>Rental Record for <em>" + getName() + "</em></h1>\n<ul>";

            for (Rental each : _rentals) {
                double thisAmount = each.getAmount();
                result += "<li>" + each.getMovie().getTitle() + ": " + thisAmount + "</li>\n";
            }

            result += "</ul>\n<p>Amount owed is <em>" + getaRentalAmount() + "</em></p>\n";
            result += "<p>You earned <em>" + getTotalFrequentRenterPoints() + "</em> frequent renter points</p>";

            return result;
        }
    }
}
