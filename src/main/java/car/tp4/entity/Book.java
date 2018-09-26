package car.tp4.entity;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * L'entite Book represente un livre. 
 * @author shaqianqian
 *
 */
@Entity
public class Book implements Serializable, Comparable<Book> {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  /**
   *  identifiant du livre
   */
  private long id;
  /**
   *  auteur du livre
   */
  private String author;
  /**
   *  titre du livre
   */
  private String title;
  /**
   *  annee de parution
   */
  private int year;
  /**
   *  quantite de livre disponible
   */
  private int quantite;

 
  public Book(String title, String author, int year, int quantite) {
    this.author = author;
    this.title = title;
    this.year = year;
    this.quantite = quantite;
  }
  
  /**
   * Constructeur d'un Book vide
   */
  public Book() {

  }
  /**
   * Getter l id de livre
   * @return l'id de livre
   */
  public long getId(){
    return this.id;
  }
  /**
   * Getter de l'auteur
   * @return l'auteur du livre
   */

  public String getAuthor() {
    return author;
  }

  /**
   * Setter de l'auteur
   * @param author
   *    L'auteur du livre a ajouter
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * Getter du titre du livre
   * @return le titre du livre
   */
  public String getTitle() {
    return title;
  }
  
  /**
   * Setter du titre du livre
   * @param title
   * 	Le titre du livre a ajouter
   */   
  public void setTitle(String title) {
    this.title = title;
  }


  /**
   * Getter de l'annee de parution du livre
   * @return  
   * 	l'annee de parution du livre
   */
  public int getYear() {
    return year;
  }
  

  /**
   * Setter de l'annee de parution du livre
   * @param year
   * 	L'annee de parution du livre a ajouter
   */
  public void setYear(int year) {
    this.year = year;
  }
  
  /**
   * Getter de la quantite de livres disponbile
   * @return 
   * 	la quantite de livres disponbile
   */
  public int getQuantite() {
    return this.quantite;
  }
  
 
  /**
   * Setter la quantite de livres disponbile
   * @param quantite
   * 	la quantite de livres disponbile
   */
  public void setQuantite(int quantite) {
    this.quantite = quantite;
  }
  /**
   * pour faire la parution de annees,mise en ordre
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Book book = (Book) o;

    if (id != book.id) return false;
    if (!author.equals(book.author)) return false;
    if (year != book.year) return false;
    return title.equals(book.title);
  }

  @Override
  public int hashCode() {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + author.hashCode();
    result = 31 * result + title.hashCode();
    return result;
  }
/**
 * pour output les resultats
 */
  @Override
  public String toString() {
    return "Book{" +
      "author = '" + author + '\'' +
      ", title = '" + title + '\'' +
      ", annee de parution = '" + year + '\''+
      ", quantite = '" + quantite + '\''+
      '}';
  }
  

  public int compareTo(Book b){
	  int res;
	  if(b.getYear() == this.getYear())
		  return 0;
	  else {

		res = (b.getYear() > this.getYear())?-1:1;
	 }
	  
	  return res;
  }
/**
 * changer le id de livre
 * @param id
 * 	 l'id de livre
 * 
 */
public void setId(long id) {
	this.id = id;
}
}
