package de.RepresentationalStateTransfer.controller;

import de.RepresentationalStateTransfer.model.Order;
import de.RepresentationalStateTransfer.model.OrderWrapper;
import de.RepresentationalStateTransfer.model.Product;
import de.RepresentationalStateTransfer.service.IShopService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ShopControllerTest {

    final List<Product> mockProducts = Arrays.asList(
            new Product(1, "Milch"),
            new Product(2, "Cola"),
            new Product(3, "Kellogs")
    );

    final Order mockOrder = Order.builder()
            .orderId(1)
            .orderProducts(mockProducts)
            .build();

    /// PRODUCTS ///

    @Test
    void getAllProducts() {
        // GIVEN
        IShopService mockService = Mockito.mock(IShopService.class);
        ShopController shopController = new ShopController(mockService);

        // WHEN
        Mockito.when(mockService.getAllProducts()).thenReturn(mockProducts);

        // THEN
        assertArrayEquals(mockProducts.toArray(), shopController.getAllProducts().toArray());
    }

    @Test
    void getProductById() {
        // GIVEN
        IShopService mockService = Mockito.mock(IShopService.class);
        ShopController shopController = new ShopController(mockService);

        // WHEN
        Mockito.when(mockService.getProductById(1)).thenReturn(mockProducts.get(0));

        // THEN
        assertEquals(mockProducts.get(0), shopController.getProductById(1));
    }

    @Test
    void getProductByName() {
        // GIVEN
        IShopService mockService = Mockito.mock(IShopService.class);
        ShopController shopController = new ShopController(mockService);

        // WHEN
        Mockito.when(mockService.getProductByName("Milk")).thenReturn(mockProducts.get(0));

        // THEN
        assertEquals(mockProducts.get(0), shopController.getProductByName("Milk"));
    }

    @Test
    void addProducts() {
        // GIVEN
        IShopService mockService = Mockito.mock(IShopService.class);
        ShopController shopController = new ShopController(mockService);

        // WHEN
        Mockito.when(mockService.addNewProducts(mockProducts.get(0))).thenReturn("Added products!");

        // THEN
        assertEquals("Added products!", shopController.addProducts(mockProducts.get(0)));
    }

    @Test
    void removeProduct() {
        // GIVEN
        IShopService mockService = Mockito.mock(IShopService.class);
        ShopController shopController = new ShopController(mockService);

        // WHEN
        Mockito.when(mockService.removeProducts(mockProducts.get(0))).thenReturn("Removed products!");

        // THEN
        assertEquals("Removed products!", shopController.removeProduct(mockProducts.get(0)));
    }

    /// ORDERS ///

    @Test
    void getAllOrders() {
        // GIVEN
        IShopService mockService = Mockito.mock(IShopService.class);
        ShopController shopController = new ShopController(mockService);

        // WHEN
        Mockito.when(mockService.getAllOrders()).thenReturn(Arrays.asList(mockOrder));

        // THEN
        assertEquals(Arrays.asList(mockOrder), shopController.getAllOrders());
    }

    @Test
    void getOrderById() {
        // GIVEN
        IShopService mockService = Mockito.mock(IShopService.class);
        ShopController shopController = new ShopController(mockService);

        // WHEN
        Mockito.when(mockService.getOrderById(1)).thenReturn(mockOrder);

        // THEN
        assertEquals(mockOrder, shopController.getOrderById(1));
    }

    @Test
    void createOrder() {
        // GIVEN
        IShopService mockService = Mockito.mock(IShopService.class);
        ShopController shopController = new ShopController(mockService);

        // WHEN
        OrderWrapper mockOrderWrapper = new OrderWrapper(1, mockProducts);
        Mockito.when(mockService.createNewOrder(1, mockProducts)).thenReturn("Created order!");

        // THEN
        assertEquals("Created order!", shopController.createOrder(mockOrderWrapper));
    }

    @Test
    void removeOrders() {
        // GIVEN
        IShopService mockService = Mockito.mock(IShopService.class);
        ShopController shopController = new ShopController(mockService);

        // WHEN
        Mockito.when(mockService.removeOrders()).thenReturn("Removed orders!");

        // THEN
        assertEquals("Removed orders!", shopController.removeOrders());
    }
}