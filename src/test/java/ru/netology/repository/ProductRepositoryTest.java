package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();
    Book book1 = new Book(1, "Just Masa", 600, "Boris Akunin", 448, 2020);
    Book book2 = new Book(2, "POST", 800, "Dmitry Glukhovsky", 310, 2020);
    Book book3 = new Book(3, "Inside the Killer", 900, "Mike Omer", 340, 2018);
    Book book4 = new Book(4, "Bad Blood", 500, "Robert Galbraith", 1100, 2020);

    @BeforeEach
    public void setUp() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
    }

    @Test
    void shouldRemoveByID1() {
        repository.removeById(2);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book1, book3, book4};
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldRemoveById2() {
        assertThrows(NotFoundException.class, () -> repository.removeById(5));
    }
}