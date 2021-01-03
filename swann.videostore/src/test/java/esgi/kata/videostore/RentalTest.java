package esgi.kata.videostore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RentalTest {
  private Movie movieNewRelease = new MovieNewRelease("The Cell");
  private Movie movieChildren = new MovieChildren("The Lion Movie");
  private Movie movieRegular = new MovieRegular("Plan 9 from Outer Space");

  @Test
  public void testRentalClassForMovieRegular() {
    int daysRented = 2;
    Rental rental = new Rental(movieRegular, daysRented);

    assertEquals(daysRented, rental.getDaysRented());

    assertEquals(rental.getMovieTitle(), "Plan 9 from Outer Space");

    assertFalse(rental.isFirstDay());

    assertEquals(movieRegular, rental.getMovie());

    assertEquals(2, rental.calculateAmount(), 2);
  }

  @Test
  public void isFirstDayForNewRelease() {
    int daysRented = 2;
    Rental rental = new Rental(movieNewRelease, daysRented);

    assertTrue(rental.isFirstDay());

    rental = new Rental(movieChildren, 0);

    assertFalse(rental.isFirstDay());
  }

  @Test
  public void isFirstDayForChildren() {
    int daysRented = 2;
    Rental rental = new Rental(movieChildren, daysRented);

    assertFalse(rental.isFirstDay());
  }
}
