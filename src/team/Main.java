package team;

/***********************************************************
 * Filename: Main.java
 * @author fba 6 de Mai de 2013
 ***********************************************************/
public abstract class Main
{

	/***********************************************************
	 * @param args
	 ***********************************************************/
	public static void main(String[] args)
	{
		Movie.Customer who = new Movie.Customer("Barack Obama");
		Movie m1 = new Movie("Life of Amalia", Price.Code.REGULAR);
		Movie m2 = new Movie("Peter Pan", Price.Code.CHILDRENS);
		Movie m3 = new Movie("Donna del Lago", Price.Code.NEW_RELEASE);

		who.addRental(new Rental(m1, 1));
		who.addRental(new Rental(m2, 2));
		who.addRental(new Rental(m3, 3));
		
		System.out.println(who.statement());
	}

}
