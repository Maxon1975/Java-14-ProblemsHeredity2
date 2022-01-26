package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    Product first = new Book(1, "Анна Каренина", 1000, "Толстой");
    Product second = new Book(2, "Война и мир", 1100, "Толстой");
    Product third = new Book(3, "Человек футляр", 800, "Чехов");
    Product fourth = new Smartphone(4, "Apple", 4100, "IND");
    Product fifth = new Smartphone(5, "Sony", 3300, "RTF");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    void searchByName() {

        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("Человек футляр");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesNameBook() {

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Война и мир");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesAuthor() {

        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("Чехов");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesManufacture() {

        Product[] expected = new Product[]{fifth};
        Product[] actual = manager.searchBy("RTF");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesNameSmartphone() {

        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searchBy("Apple");
        assertArrayEquals(expected, actual);
    }


    @Test
    void searchAllByAuthor() {

        Product[] expected = new Product[]{first, second};
        Product[] actual = manager.searchBy("Толстой");
        assertArrayEquals(expected, actual);
    }


    @Test
    void searchAll() {

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("null");
        assertArrayEquals(expected, actual);
    }


}
