package esgi.kata.videostore;

import java.util.ArrayList;

public class Customer {
	private String name;
	private ArrayList<Rental> rentals = new ArrayList<Rental>();
	private double totalAmount = 0;

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
		int fidelityPoints = getFidelityPoints();
		calculateTotalAmount();

		String result = "Rental Record for " + getName() + "\n";
		result += getSummaryBySale();
		result += "You owed " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(fidelityPoints) + " frequent renter points\n";

		return result;
	}

	private int getFidelityPoints() {
		int count = rentals.size();
		// count += rentals.stream().filter(rental -> isFirstDay(rental)).count();
		for (Rental rental : rentals) {
			if (isFirstDay(rental)) {
				count += 1;
			}
		}
		return count;
	}

	private String getSummaryBySale() {
		String result = "";
		for (Rental rental : rentals) {
			double thisAmount = calculateAmount(rental);
			result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
		}
		return result;
	}

	private Boolean isFirstDay(Rental rental) {
		return rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1;
	}

	private void calculateTotalAmount() {
		for (Rental rental : rentals) {
			totalAmount += calculateAmount(rental);
		}
	}

	// TODO il faut qu'on fasse emerger une uniformité entre amount et price
	private double calculateAmount(Rental rental) {
		double amount = 0;
		int daysRented = rental.getDaysRented();
		switch (rental.getMoviePriceCode()) {
			case REGULAR:// une fonction par cas ?
				amount += 2;
				if (daysRented > 2)
					amount += (daysRented - 2) * 1.5;// une fonction qui fait ce calcule ?
				break;
			case NEW_RELEASE:
				amount += daysRented * 3;
				break;
			case CHILDRENS:
				amount += 1.5;
				if (daysRented > 3)
					amount += (daysRented - 3) * 1.5;
				break;
		}
		return amount;
	}
}