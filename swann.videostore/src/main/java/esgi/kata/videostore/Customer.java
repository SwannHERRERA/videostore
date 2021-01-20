package esgi.kata.videostore;

public class Customer {
	private String name;
	private RentalList rentals = new RentalList();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		String statement = "Rental Record for " + getName() + "\n";
		statement += getSummaryBySale();
		statement += "You owed " + String.valueOf(rentals.getTotalAmount()) + "\n";
		statement += "You earned " + String.valueOf(rentals.getFideltyPoints()) + " frequent renter points\n";

		return statement;
	}

	private String getSummaryBySale() {
		String summary = "";

		for (Rental rental : rentals.rentals) {
			summary += "\t" + rental.getMovieTitle() + "\t" + String.valueOf(rental.calculateAmount()) + "\n";
		}

		return summary;
	}
}