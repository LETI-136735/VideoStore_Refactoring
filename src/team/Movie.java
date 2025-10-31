package team;

import java.util.Vector;

public class Movie {

	public enum Code {REGULAR, CHILDRENS, NEW_RELEASE};
	
	private String _title;
	private Code _priceCode;
	
	public Movie(String title, Code priceCode) {
		_title = title;
		_priceCode = priceCode;
	}

	public String getTitle() {
		return _title;
	}

	public Code getPriceCode() {
		return _priceCode;
	}

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