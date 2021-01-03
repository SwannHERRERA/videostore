package esgi.kata.videostore;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MovieRegularTest {
  private Movie movie = new MovieRegular("Test Movie New Release");
  private int defaultValue = 2;

  @Test
  public void calculateAmountLimitDefaultValue() {
    int daysRented = 2;// 2 is the limit value
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
    double expectedAmount = 6.5;
    double amount = movie.calculateAmount(daysRented);

    assertEquals(amount, expectedAmount, 0);
  }
}
