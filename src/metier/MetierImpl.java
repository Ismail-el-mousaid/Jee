package metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.IDao;

@Component("metier")
//@Service spring sait que et classe appartient au couche metier
public class MetierImpl implements IMetier{
	// Couplage faible
	@Autowired    // pour injection des dépendances
	private IDao dao;
	
	// Pour injecter dans dao un objet d'une classe qui imlemente IDao
	public void setDao(IDao dao) {
		this.dao = dao;
		System.out.println("Injection des dépendances");
		}

	@Override
	public double calcul() {
		// TODO Auto-generated method stub
		double data = dao.getData();
		double res = data*Math.PI;
		return res;
	}
	
	public void init() {
		System.out.println("Initialisation de MetierImpl");
	}

	
}
