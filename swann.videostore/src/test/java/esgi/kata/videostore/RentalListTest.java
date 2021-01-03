package esgi.kata.videostore;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RentalListTest {

  private Movie movie1 = new MovieChildren("Test Movie Children");
  private Movie movie2 = new MovieNewRelease("Test Movie New Release");

  @Test
  public void testAdd() {
    RentalList rentalList = new RentalList();
    Rental rental1 = new Rental(movie1, 2);
    Rental rental2 = new Rental(movie2, 4);

    rentalList.add(rental1);
    assertEquals(1, rentalList.rentals.size());
    assertEquals(1.5, rentalList.getTotalAmount(), 0);
    assertEquals(1, rentalList.getFideltyPoints());

    rentalList.add(rental2);
    assertEquals(2, rentalList.rentals.size());
    assertEquals(13.5, rentalList.getTotalAmount(), 0);
    assertEquals(3, rentalList.getFideltyPoints());
  }
}
