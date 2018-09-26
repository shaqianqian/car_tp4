package car.tp4.entity;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
/**
 * Le bean de panier
 * @author shaqianqian
 *
 */
@Stateless
@Local
public class PanierBean {

  @PersistenceContext(unitName = "panier-pu")
  private EntityManager entityManager;
  
 
  /**
   * Sauve la commande dans la base de donnee
   *
   * @param p commande a sauver dans la base de donnee
   */
  public void valide_panier(Panier p) {
	  entityManager.persist(p);
  }
/**
 * Pour obetenir tous les paniers dans l'histoire
 * @return
 * 		retourne les livres dans le panier
 */
  public List<Panier> getAllPanier(){
	  Query query = entityManager.createQuery("SELECT p FROM Panier as p");
	  return query.getResultList();
  }


}