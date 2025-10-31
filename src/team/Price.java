package team;

public class Price {

    public enum Code { REGULAR, CHILDRENS, NEW_RELEASE }

    private final Code code;

    public Price(Code code) {
        this.code = code;
    }

    public Code getCode() {
        return code;
    }

    // Code smell v8: sigue habiendo switch aquí (se elimina en v9 con subclases)
    public double getRentalAmount(int daysRented) {
        double result;
        switch (code) {
            case REGULAR:
                result = 2;
                if (daysRented > 2) result += (daysRented - 2) * 1.5;
                break;
            case CHILDRENS:
                result = 1.5;
                if (daysRented > 3) result += (daysRented - 3) * 1.5;
                break;
            case NEW_RELEASE:
                result = daysRented * 3;
                break;
            default:
                throw new IllegalStateException("Unknown price code: " + code);
        }
        return result;
    }

    public int getFrequentRentalPoints(int daysRented) {
        if (code == Code.NEW_RELEASE && daysRented > 1) return 2;
        return 1;
    }
}
