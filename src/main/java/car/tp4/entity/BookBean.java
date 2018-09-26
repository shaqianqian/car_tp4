package car.tp4.entity;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Test;

import com.mysql.cj.api.jdbc.Statement;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * utliser la base de donnee
 * 
 * @author shaqianqian
 *
 */
@SuppressWarnings("unchecked")
@Stateless
@Local
public class BookBean {

	@PersistenceContext(unitName = "book-pu")
	private EntityManager entityManager;

	/**
	 * un vide constructor pour evider lexception
	 */
	public BookBean() {

	}

	/**
	 * connecte avec le vrai base de donnee, mais utilise pas dans ce tp.
	 * 
	 * @return un objet de Connection
	 */
	public Connection JdbcOutil() {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bdd_jee?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;

	}

	/**
	 * Ajoute un livre dans la base de donnee
	 * 
	 * @param book
	 *            le livre a ajouter
	 * @throws SQLException
	 *             retourne l'erruer de sql
	 */

	public void addBook(Book book) throws SQLException {

		entityManager.persist(book);

		//
		// Connection conn=JdbcOutil();
		// String sql;
		// sql="insert into bdd_jee.books values(null,?,?,?,?)";
		// PreparedStatement
		// ps=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		// ps.setString(1, book.getAuthor());
		// ps.setString(2, book.getTitle());
		// ps.setInt(3, book.getYear());
		// ps.setInt(4, book.getQuantite());
		// ps.executeUpdate();

	}

	public List<Book> getAllBooks() throws SQLException {
		// Connection conn=JdbcOutil();
		// java.sql.Statement st = conn.createStatement();
		// ResultSet rs = st.executeQuery("select * from bdd_jee.books");
		// List<Book> books=new ArrayList<Book>();
		// while (rs.next()) {
		// books.add(new Book(rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5))
		// );
		// }
		// books.addAll(query.getResultList());
		// return books;
		Query query = entityManager.createQuery("SELECT b from Book as b");
		return query.getResultList();

	}

	public List<String> getAllAuteur() {
		Query query = entityManager.createQuery("SELECT distinct book.auteur from Book as auteur");
		return query.getResultList();
	}

	public List<Long> getAllId() {
		Query query = entityManager.createQuery("SELECT b.id from Book as b");
		return query.getResultList();
	}

	/**
	 * 
	 * cherche les livres selons les cle mots de acteur ou la titre de livre
	 * 
	 * @param attribut
	 *            l'attribut que l'on va chercher, auteur ou titre
	 * @param keyword
	 *            le nom de l'auteur ou du titre
	 * @return la liste des livres contenus dans la base de donnee respectant le
	 *         critere
	 */
	public List<Book> getBooksWithSearch(String attribut, String keyword) {
		Query query = entityManager
				.createQuery("SELECT b FROM Book as b WHERE b." + attribut + " like '%" + keyword + "%'");
		return query.getResultList();
	}

	/**
	 * 
	 * renvoie la liste des livres corresppondants aux criteres
	 * 
	 * @param title
	 *            nom du livre a trouver partiellement ou entierement
	 * @param author
	 *            nom de l'auteur a trouver partiellement ou entierement
	 * @param year
	 *            la date de l'annee a rechercher
	 * @return la liste des livres contenus dans la base de donnee
	 */
	public List<Book> getBook(String title, String author, int year) {
		Query query = entityManager.createQuery("SELECT b FROM Book as b where b.title like '%" + title
				+ "%' and b.author like '%" + author + "%' and b.year=" + year);
		return query.getResultList();
	}

	/**
	 * 
	 * @param id
	 *            l'identifiant du livre
	 * @return la liste des livres correspondant a l'id passe en parametre
	 */
	public List<Book> getBookById(long id) {
		Query query = entityManager.createQuery("SELECT b FROM Book as b where b.id=" + id);
		return query.getResultList();

	}

	/**
	 * mise a jour de la quantite de livre disponible pour le livre corresppondant
	 * aux criteres
	 * 
	 * @param title
	 *            le nom du livre
	 * @param author
	 *            le nom de l'auteur du livre
	 * @param year
	 *            l'annee de parution du livre
	 * @param quantite
	 *            la nouvelle quantite restante du livre
	 */
	public void setQuantite(String title, String author, int year, int quantite) {
		Query query = entityManager.createQuery("UPDATE Book as b set b.quantite = " + quantite
				+ " where b.title like '%" + title + "%' and b.author like '%" + author + "%' and b.year=" + year);
		query.executeUpdate();
	}

	/**
	 * mise a jour de la quantite de livre disponible pour le livre corresppondant a
	 * l'id
	 * 
	 * @param id
	 *            l'identifiant du livre
	 * @param quantite
	 *            la nouvelle quantite restante du livre
	 */
	public void setQuantiteByID(long id, int quantite) {
		Query query = entityManager.createQuery("UPDATE Book as b set b.quantite = " + quantite + " where b.id=" + id);
		query.executeUpdate();
	}

	/**
	 * Supprime livre le livre corresppondant a l'id
	 * 
	 * @param id
	 *            l'identifiant du livre
	 */
	public void deleteBookOnly(long id) {
		Query queryDelete = entityManager.createQuery("DELETE from Book as m where m.id=" + id);
		queryDelete.executeUpdate();

	}

}