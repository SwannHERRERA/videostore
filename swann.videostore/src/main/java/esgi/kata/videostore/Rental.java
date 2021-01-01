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

  public Boolean isFirstDay() {
    System.out.println(movie.getClass());

    return movie instanceof MovieNewRelease && getDaysRented() > 1;
  }

  public double calculateAmount() {
    return movie.calculateAmount(daysRented);
  }

  public String getMovieTitle() {
    return movie.getTitle();
  }
}