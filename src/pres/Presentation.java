package pres;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;



import dao.DaoImpl;
import dao.IDao;
import metier.IMetier;
import metier.MetierImpl;

public class Presentation {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
// Injection des dépendances par instanciation "statique" => new
		DaoImpl dao = new DaoImpl();
		MetierImpl metier = new MetierImpl();
		metier.setDao(dao);
		System.out.println(metier.calcul());
		
// 2eme méthode "dynamique"
		// lire le fichier config
		Scanner sc = new Scanner(new File("Config.txt"));
		
		// lire la 1ere ligne de fichier config (qui est le nom du classe)
		String daoClassname = sc.nextLine();
		
		// créér (charger) la classe dans mémoire
		Class cdao = Class.forName(daoClassname);
		
		// creer instance de la classe 
		IDao dao1 = (IDao) cdao.newInstance();
		System.out.println(dao1.getData());
		
		String metierClassname = sc.nextLine();
		Class cMetier = Class.forName(metierClassname);
		IMetier metier1 = (IMetier) cMetier.newInstance();
		
		// appler la méthode setDao() dynamiquement, Pour statique: metier.setDao(dao); 
		Method m = cMetier.getMethod("setDao", IDao.class);
		m.invoke(metier1, dao1);
		
		System.out.println(metier.calcul());
		
	}

}

