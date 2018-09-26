package car.tp4.entity;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * la classe pour gerer les commandes
 * 
 * @author shaqianqian
 *
 */
@Entity
public class Panier implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	/**
	 * id du panier
	 */
	private Long id;

	/**
	 * nbre de livre du panier
	 */
	private int quantite;

	/**
	 * Dans la commande pour preciser les livres dans certain command
	 */
	private String id_livres;

	/**
	 * Obtenir les ids des livres de certain command
	 * 
	 * @return
	 * 		obtenir les ids de livres dans la command
	 */
	public String getId_livres() {
		return id_livres;
	}

	/**
	 * Pour changer les ids des libres de certain command
	 * 
	 * @param id_livres
	 * 		les ids de ce command
	 */
	public void setId_livres(String id_livres) {
		this.id_livres = id_livres;
	}

	/**
	 * les livres de la commande
	 */
	private List<Book> books_in_panier;

	/**
	 * Construction
	 */
	public Panier() {
		this.books_in_panier = new ArrayList<Book>();
		this.quantite = 0;
		this.id_livres = "";
	}

	/**
	 * Getter de l'identifiant du panier
	 * 
	 * @return l'identifiant du panier
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Getter de la liste des livres
	 * 
	 * @return la liste des livres de la commande
	 */
	public List<Book> getBooks() {
		return this.books_in_panier;
	}


	
	/**
	 * Setter de la quantite de livres
	 * @param quantite
	 * 
	 * 		la quantite de livres de la commande
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	/**
	 * Getter de la quantite de livres
	 * 
	 * @return la quantite de livres de la commande
	 */
	public int getQuantite() {
		return this.quantite;
	}


	/**
	 * Setter de la liste des livres
	 * @param livres
	 * 		la liste des livres de la commande
	 */
	public void setLivres(List<Book> livres) {
		this.books_in_panier = livres;
	}


	/**
	 * Methode permettant d'ajouter un livre a la commande, on incremente de un la
	 * quantite.
	 * @param book
	 * 		 livre a ajouter
	 */
	public void addBook(Book book) {
		this.books_in_panier.add(book);
		this.quantite++;
		this.id_livres = book.getId() + " " + this.id_livres;
	}

	/**
	 * Methode permettant de retirer un livre de la commande, on decremente de un la
	 * quantite.
	 * 
	 * @param book
	 * 		 livre a retirer	             
	 */
	public void removeBook(Book book) {
		if (this.books_in_panier.contains(book)) {
			this.books_in_panier.remove(book);
			this.quantite--;
			this.id_livres = this.id_livres.replaceFirst(book.getId() + " ", "");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Panier panier = (Panier) o;

		return id == panier.id;
	}

	@Override
	public String toString() {
		return "Panier{" + "id='" + id + '\'' + '}';
	}
}
