package pres;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import metier.IMetier;

public class PresAvecSpringAnnotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new AnnotationConfigApplicationContext("dao", "metier"); //scanner les classe qui appartient a ces 2 packages qui contioent des annotations component
		IMetier metier = ctx.getBean(IMetier.class);
		System.out.println(metier.calcul());
		
	}

}
