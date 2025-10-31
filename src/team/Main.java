package team;

public class Main {

    public static void main(String[] args) {
        Movie.Customer who = new Movie.Customer("Barack Obama");

        Movie m1 = new Movie("Life of Amalia", new RegularPrice());
        Movie m2 = new Movie("Peter Pan", new ChildrensPrice());
        Movie m3 = new Movie("Donna del Lago", new NewReleasePrice());

        who.addRental(new Rental(m1, 1));
        who.addRental(new Rental(m2, 2));
        who.addRental(new Rental(m3, 3));

        System.out.println(who.statement());
    }
}
