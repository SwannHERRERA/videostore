package esgi.kata.videostore;

public class MovieChildren extends Movie {

  MovieChildren(String title) {
    super(title);
  }

  public double calculateAmount(int daysRented) {
    double defaultValue = 1.5;
    double coeff = 1.5;
    int daySubstract = 3;

    if (daysRented <= 3) {
      return defaultValue;
    }
    return defaultValue + (daysRented - daySubstract) * coeff;
  }

}
