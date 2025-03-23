package tp.banque;

import java.io.Serializable;

public class CompteEpargne extends Compte implements Serializable{
    private double taux;
    
    public CompteEpargne(String N,double S,double TA) {
    	super(N,S);
    	taux = TA;
    }
    
    public void déposer(double montant) {
    	double montantréel= montant*(1+taux);
    	super.déposer(montantréel);
    }
    
    public String toString() {
  	  String S=super.toString();
  	  S+="\t"+taux*100+"%";
  	  return S;
    }
    
    @Override
    public String typeDeCompte() {
        return "Compte Epargne (" + (int)(taux * 100) + "%)";
    }

}
