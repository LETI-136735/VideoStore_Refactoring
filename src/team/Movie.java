package team;

import java.util.Vector;

public class Movie {

    private String _title;
    private Price _price;

    public Movie(String title, Price price) {
        _title = title;
        _price = price;
    }

    public String getTitle() {
        return _title;
    }

    public Price getPrice() {
        return _price;
    }

    public double getRentalAmount(int daysRented) {
        return _price.getRentalAmount(daysRented);
    }

    public int getFrequentRentalPoints(int daysRented) {
        return _price.getFrequentRentalPoints(daysRented);
    }

    public static class Customer {
        private String _name;
        private Vector<Rental> _rentals = new Vector<>();

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
            StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

            for (Rental each : _rentals) {
                double thisAmount = each.getAmount();
                result.append("\t").append(each.getMovie().getTitle())
                        .append("\t").append(thisAmount).append("\n");
            }

            result.append("Amount owed is ").append(getaRentalAmount()).append("\n");
            result.append("You earned ").append(getTotalFrequentRenterPoints())
                    .append(" frequent renter points");
            return result.toString();
        }

        public String htmlStatement() {
            StringBuilder result = new StringBuilder("<h1>Rental Record for <em>")
                    .append(getName()).append("</em></h1>\n<ul>");

            for (Rental each : _rentals) {
                double thisAmount = each.getAmount();
                result.append("<li>").append(each.getMovie().getTitle())
                        .append(": ").append(thisAmount).append("</li>\n");
            }

            result.append("</ul>\n<p>Amount owed is <em>")
                    .append(getaRentalAmount()).append("</em></p>\n");
            result.append("<p>You earned <em>")
                    .append(getTotalFrequentRenterPoints())
                    .append("</em> frequent renter points</p>");

            return result.toString();
        }
    }
}
