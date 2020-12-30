package esgi.kata.videostore;

public class Main {
  public static void main(String[] args) {
    Customer customer = new Customer("Fred");
    customer.addRental(new Rental(new MovieNewRelease("The Cell"), 3));
    customer.addRental(new Rental(new MovieNewRelease("The Tigger Movie"), 3));
    String res = customer.statement();
    System.out.println(res);
  }
}
