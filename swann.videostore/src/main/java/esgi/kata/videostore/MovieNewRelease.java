package esgi.kata.videostore;

public class MovieNewRelease extends Movie {

  public MovieNewRelease(String title) {
    super(title);
  }

  public double calculateAmount(int daysRented) {
    double coeff = 3;
    return daysRented * coeff;
  }
}
