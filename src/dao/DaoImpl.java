package dao;

import org.springframework.stereotype.Component;

@Component
// @Repository  comme component sauf que spring crée cet objet et il connait qu'il parti a couche base de données
public class DaoImpl implements IDao{

	@Override
	public double getData() {
		// TODO Auto-generated method stub
		System.out.println("Version Base de donnée ");
		double data = 44;
		return data;
	}
	
	public void init() {
		System.out.println("Initialisation de DaoImpl");
	}

}
