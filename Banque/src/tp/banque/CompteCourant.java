package tp.banque;

import java.io.Serializable;

public class CompteCourant extends Compte implements Serializable{
  private double découvertAutorisé;
  
  public CompteCourant(String N,double S,double DA) {
	  super(N,S); //appel constructeur de la super-classe pour créer la partie données héritées et toujours la première
	  découvertAutorisé=DA;
  }
  
  // même si retirer est deja hérité de la classe compte, il doit être redéfinie pour insérer découvertAutorisée
  public void retirer(double montant) {
	  double soldeVirtuel= solde + découvertAutorisé;
	  if(montant<=soldeVirtuel) solde-=montant;
  }

  public String toString() {
	  String S=super.toString();
	  S+="\t"+découvertAutorisé;
	  return S;
  }
  @Override
  public String typeDeCompte() {
      return "Compte Courant";
  }


}
