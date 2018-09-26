package car.tp4.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import car.tp4.entity.Book;

public class booksTest {

	@Test
	public void testVideBook() {
		Book b = new Book();
		assertNotNull(b);

	}

	@Test
	public void testNormalBook() {
		Book b = new Book("car", "roman", 2018, 80);
		assertNotNull(b);

	}

	@Test
	public void testGetTitre() {
		Book b = new Book("car", "roman", 2018, 80);
		assertEquals(b.getTitle(), "car");
	}

	@Test
	public void testGetAuthor() {
		Book b = new Book("car", "roman", 2018, 80);
		assertEquals(b.getAuthor(), "roman");
	}
	@Test
	public void testGetAnnee() {
		Book b = new Book("car", "roman", 2018, 80);
		assertEquals(b.getYear(), 2018);
	}
	@Test
	public void testGetQuantite() {
		Book b = new Book("car", "roman", 2018, 80);
		assertEquals(b.getQuantite(), 80);
	}
	@Test
	public void testSetTitre() {
		Book b = new Book("car", "roman", 2018, 80);
		b.setTitle("miku");
		assertEquals(b.getTitle(), "miku");
	}

	@Test
	public void testSetAuthor() {
		Book b = new Book("car", "roman", 2018, 80);
		b.setAuthor("jack");
		assertEquals(b.getAuthor(), "jack");
	}
	public void tesSetAnnee() {
		Book b = new Book("car", "roman", 2018, 80);
		b.setYear(2017);
		assertEquals(b.getYear(), 2017);
	}
	@Test
	public void testSetQuantite() {
		Book b = new Book("car", "roman", 2018, 80);
		b.setQuantite(180);
		assertEquals(b.getQuantite(), 180);
	}

}
