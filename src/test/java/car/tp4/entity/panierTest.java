package car.tp4.entity;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import car.tp4.entity.Book;
import car.tp4.entity.Panier;

public class panierTest {
	@Test
	public void testGetQuantite() {
		List<Book> books = null;
		Book a = new Book("car", "roman", 2018, 80);
		Book b = new Book("car", "roman", 2018, 80);
		Book c = new Book("car", "roman", 2018, 80);	
		Panier p=new Panier();
		p.addBook(a);
		p.addBook(b);
		p.addBook(c);
		assertEquals(p.getQuantite(), 3);
	}
	@Test
	public void testSetQuantite() {
		List<Book> books = null;
		Book a = new Book("car", "roman", 2018, 80);
		Book b = new Book("car", "roman", 2018, 80);
		Book c = new Book("car", "roman", 2018, 80);	
		Panier p=new Panier();
		p.addBook(a);
		p.addBook(b);
		p.addBook(c);
		assertEquals(p.getQuantite(), 3);
		p.setQuantite(5);
		assertEquals(p.getQuantite(), 5);
	}
	@Test
	public void testGetLivres() {
		List<Book> books = null;
		Book a = new Book("car", "roman", 2018, 80);
		Book b = new Book("car", "roman", 2018, 80);
		Book c = new Book("car", "roman", 2018, 80);	
		Panier p=new Panier();
		p.addBook(a);
		p.addBook(b);
		p.addBook(c);
		assertEquals(p.getBooks().size(), 3);

	}
	@Test
	public void testSetLivres() {
		List<Book> books = new ArrayList<Book>();
		Book a = new Book("car", "roman", 2018, 80);
		Book b = new Book("car", "roman", 2018, 80);
		books.add(a);
		books.add(b);
		Panier p=new Panier();
		p.setLivres(books);
      	assertEquals(p.getBooks().size(),2);

	}
	@Test
	public void testRemoveLivre() {
		List<Book> books = null;
		Book a = new Book("car", "roman", 2018, 80);
		Book b = new Book("car", "roman", 2018, 80);
		Book c = new Book("car", "roman", 2018, 80);	
		Panier p=new Panier();
		p.addBook(a);
		p.addBook(b);
		p.addBook(c);
		p.removeBook(b);
		assertEquals(p.getQuantite(), 2);
	}
}
