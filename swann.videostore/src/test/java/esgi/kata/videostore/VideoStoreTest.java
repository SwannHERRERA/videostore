package esgi.kata.videostore;

import org.junit.Test;

import junit.framework.*;

public class VideoStoreTest extends TestCase {

  private Customer customer;
  private Movie theCell = new MovieNewRelease("The Cell");
  private Movie theTiggerMovie = new MovieNewRelease("The Tigger Movie");
  private Movie theLionMovie = new MovieChildren("The Lion Movie");
  private Movie plan9FromOuterSpaceMovie = new MovieRegular("Plan 9 from Outer Space");
  private Movie heightOneByTwo = new MovieRegular("8 1/2");
  private Movie eraserheadMovie = new MovieRegular("Eraserhead");

  public VideoStoreTest(String name) {
    super(name);
  }

  protected void setUp() {
    customer = new Customer("Fred");
  }

  @Test
  public void testSingleNewReleaseStatement() {
    Rental theCellRental = new Rental(theCell, 3);
    customer.addRental(theCellRental);

    assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n",
        customer.statement());
  }

  @Test
  public void testDualNewReleaseStatement() {
    Rental theCellRental = new Rental(theCell, 3);
    Rental theTiggerMovieRental = new Rental(theTiggerMovie, 3);

    customer.addRental(theCellRental);
    customer.addRental(theTiggerMovieRental);

    assertEquals(
        "Rental Record for Fred\n\tThe Cell\t9.0\n\tThe Tigger Movie\t9.0\nYou owed 18.0\nYou earned 4 frequent renter points\n",
        customer.statement());
  }

  @Test
  public void testSingleChildrensStatement() {
    Rental theLionRental = new Rental(theLionMovie, 3);

    customer.addRental(theLionRental);

    assertEquals("Rental Record for Fred\n\tThe Lion Movie\t1.5\nYou owed 1.5\nYou earned 1 frequent renter points\n",
        customer.statement());
  }

  @Test
  public void testMultipleRegularStatement() {
    Rental plan9FromOuterSpaceMovieRental = new Rental(plan9FromOuterSpaceMovie, 1);
    Rental heightOneByTwoRental = new Rental(heightOneByTwo, 2);
    Rental eraserheadMovieRental = new Rental(eraserheadMovie, 3);

    customer.addRental(plan9FromOuterSpaceMovieRental);
    customer.addRental(heightOneByTwoRental);
    customer.addRental(eraserheadMovieRental);

    assertEquals(
        "Rental Record for Fred\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserhead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n",
        customer.statement());
  }
}