package esgi.kata.videostore;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MovieNewReleaseTest {
  private Movie movie = new MovieNewRelease("Test Movie New Release");

  @Test
  public void calculateAmount() {
    int daysRented = 2;// 2 is the limit value
    double expectedAmount = 6;
    double amount = movie.calculateAmount(daysRented);

    assertEquals(amount, expectedAmount, 0);
  }

  @Test
  public void calculateAmount2() {
    int daysRented = 5;
    double expectedAmount = 15;
    double amount = movie.calculateAmount(daysRented);

    assertEquals(amount, expectedAmount, 0);
  }
}
