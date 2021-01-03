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
		String result = "Rental Record for " + getName() + "\n";
		result += getSummaryBySale();
		result += "You owed " + String.valueOf(rentals.getTotalAmount()) + "\n";
		result += "You earned " + String.valueOf(rentals.getFideltyPoints()) + " frequent renter points\n";

		return result;
	}

	private String getSummaryBySale() {
		String result = "";

		for (Rental rental : rentals.rentals) {
			result += "\t" + rental.getMovieTitle() + "\t" + String.valueOf(rental.calculateAmount()) + "\n";
		}

		return result;
	}
}