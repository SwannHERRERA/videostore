package esgi.kata.videostore;

public class Rental {
  private Movie movie;
  private int daysRented;

  public Rental(Movie movie, int daysRented) {
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public int getDaysRented() {
    return daysRented;
  }

  public Movie getMovie() {
    return movie;
  }

  public MoviePriceCode getMoviePriceCode() {
    return movie.getMoviePriceCode();
  }
}