import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.davshaw.classes.CarItem;
import org.davshaw.classes.Product;
import org.davshaw.classes.ShoppingCart;

public class ShoppingCartTests {

    @Test
    public void addItem_ValidProduct_AddsToCart() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Sample Product", 10.0);

        // Act
        cart.addItem(product, 2);

        // Assert
        assertEquals(1, cart.getItemCount());
    }

    @Test
    public void addItem_DuplicateProduct_IncrementsQuantity() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Sample Product", 10.0);

        // Act
        cart.addItem(product, 2);
        cart.addItem(product, 3);

        // Assert
        assertEquals(1, cart.getItemCount());
        assertEquals(5, cart.getItems().get(0).getQuantity());
    }


    @Test
    public void sortItems() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();
        Product p1 = new Product("Mango", 10.0);
        Product p2 = new Product("Manzana", 10.0);
        Product p3 = new Product("Pera",5.2);

        // Act
        cart.addItem(p1,3);
        cart.addItem(p3,10);
        cart.addItem(p2,90);
        cart.sortItems();

        List<CarItem> listaObjetos = cart.getItems();
        //Obtener solo nombres xd
        List<String> nombre1 = new ArrayList<String>();
        nombre1.add("Mango");
        nombre1.add("Manzana");
        nombre1.add("Pera");
        List<String> nombre2 = new ArrayList<String>();
        nombre2.add(listaObjetos.get(0).getProducto().getName());
        nombre2.add(listaObjetos.get(1).getProducto().getName());
        nombre2.add(listaObjetos.get(2).getProducto().getName());
        // Assert
        assertEquals(nombre1, nombre2);
    }



    @Test(expected = NullPointerException.class)
    public void addItem_IllegalProduct() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();
        Product product = null;

        // Act
        cart.addItem(product, 1);
    }


    @Test
    public void removeItem_ValidProduct_RemovesFromCart() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Sample Product", 10.0);
        cart.addItem(product, 2);

        // Act
        cart.removeItem(product);

        // Assert
        assertEquals(0, cart.getItemCount());
    }

    @Test
    public void calculateTotal_NoItems_ReturnsZero() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();

        // Act
        double total = cart.calculateTotal();

        // Assert
        assertEquals(0.0, total, 0.001);
    }

    @Test
    public void calculateTotal_MultipleItems_CalculatesCorrectTotal() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();
        Product product1 = new Product("Product 1", 10.0);
        Product product2 = new Product("Product 2", 20.0);
        cart.addItem(product1, 2);
        cart.addItem(product2, 1);

        // Act
        double total = cart.calculateTotal();

        // Assert
        assertEquals(40.0, total, 0.001);
    }

    @Test
    public void calculateTotal_DiscountApplied_CalculatesCorrectTotal() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Discounted Product", 100.0);
        cart.addItem(product, 2);

        // Apply a 20% discount
        double expectedTotal = 2 * product.getPrice() * 0.8;

        // Act
        double total = cart.calculateTotal(true);

        // Assert
        assertEquals(expectedTotal, total, 0.001);
    }



    @Test(expected = IllegalArgumentException.class)
    public void addItem_InvalidQuantity_ThrowsIllegalArgumentException() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Sample Product", 10.0);

        // Act
        cart.addItem(product, -1);
    }
}
