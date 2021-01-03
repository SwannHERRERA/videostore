package esgi.kata.videostore;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerTest {

  @Test
  public void name() {
    Customer customer = new Customer("Jean-Loup");
    assertEquals("Jean-Loup", customer.getName());
  }
}
