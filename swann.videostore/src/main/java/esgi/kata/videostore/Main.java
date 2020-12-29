package esgi.kata.videostore;

public class Main {
  public static void main(String[] args) {
    Customer customer = new Customer("Fred");
    customer.addRental(new Rental(new Movie("The Cell", Movie.NEW_RELEASE), 3));
    customer.addRental(new Rental(new Movie("The Tigger Movie", Movie.NEW_RELEASE), 3));
    String res = customer.statement();
    System.out.println(res);
  }
}
