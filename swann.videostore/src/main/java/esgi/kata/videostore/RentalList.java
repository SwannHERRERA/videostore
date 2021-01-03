package esgi.kata.videostore;

import java.util.ArrayList;

public class RentalList {
  public ArrayList<Rental> rentals = new ArrayList<Rental>();
  private double totalAmount = 0;
  private int fideltyPoints = 0;

  public void add(Rental rental) {
    rentals.add(rental);
    calculateTotalAmount(rental);
    calculateFidelityPoints();
  }

  public double getTotalAmount() {
    return totalAmount;
  }

  public int getFideltyPoints() {
    return fideltyPoints;
  }

  private void calculateTotalAmount(Rental rental) {
    totalAmount += rental.calculateAmount();
  }

  private void calculateFidelityPoints() {
    int count = rentals.size();
    // count += rentals.stream().filter(rental -> isFirstDay(rental)).count();
    for (Rental rental : rentals) {
      if (rental.isFirstDay()) {
        count += 1;
      }
    }
    fideltyPoints = count;
  }
}
