package esgi.kata.videostore;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MovieChildrenTest {

  private Movie movie = new MovieChildren("Test Movie Children");
  private double defaultValue = 1.5;

  @Test
  public void getTitle() {
    String title = movie.getTitle();

    assertEquals("Test Movie Children", title);
  }

  @Test
  public void calculateAmountLimitDefaultValue() {
    int daysRented = 3;// 3 is the limit value
    double expectedAmount = defaultValue;
    double amount = movie.calculateAmount(daysRented);

    assertEquals(amount, expectedAmount, 0);
  }

  @Test
  public void calculateAmountDefaultValue() {
    int daysRented = 1;
    double expectedAmount = defaultValue;
    double amount = movie.calculateAmount(daysRented);

    assertEquals(amount, expectedAmount, 0);
  }

  @Test
  public void calculateAmount() {
    int daysRented = 5;
    double expectedAmount = 4.5;
    double amount = movie.calculateAmount(daysRented);

    assertEquals(amount, expectedAmount, 0);
  }
}