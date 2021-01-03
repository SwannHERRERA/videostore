package esgi.kata.videostore;

public class MovieRegular extends Movie {
  MovieRegular(String title) {
    super(title);
  }

  public double calculateAmount(int daysRented) {
    double coeff = 1.5;
    double defaultValue = 2;
    int daySubstract = 2;

    if (daysRented <= 2) {
      return defaultValue;
    }
    return defaultValue + (daysRented - daySubstract) * coeff;
  }
}