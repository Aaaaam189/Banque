package tp.banque;
import java.util.Scanner;   // java.util à Vector, List, LinkedList, ArrayList ...
import java.io.Serializable;
import java.util.ArrayList;
abstract public class Compte implements Serializable{
    private int numéro;
    private String nom;
    protected double solde;
    private ArrayList<Opération> opérations=new ArrayList<Opération>();
    static private int nbComptes = 0;
    
    public Compte(Compte compte){
        this.numéro = compte.numéro;
        this.nom = compte.nom;
        this.solde = compte.solde;
        this.opérations = new ArrayList<>();
    }
    
    
    public void add(Opération Op) {
    	opérations.add(Op);
    }
    
    public void remove(Opération Op) {
    	opérations.remove(Op);
    }
    
    public String relevé() {
    	String R="";
    	double SF=this.solde;
    	R+="Numéro = "+this.nbComptes +"\tNom = "+this.nom;
    	R += "\tType de compte = " + this.typeDeCompte();
    	
    	for(Opération Op : opérations ) {
    		R+="\n"+Op;  //Op.toString()
    		if (Op.gettype()==Opération.DEPOT) SF+=Op.getmontant();
    		else if (Op.gettype()==Opération.RETRAIT) SF-=Op.getmontant();
    	}
    	//R+="\n\t\t\t\t"+"Solde:"+SF;
    	this.nbComptes++;
    	return R;
    }
    
    public void déposer(double montant) {
        this.solde += montant;
    }

    public void retirer(double montant) throws soldeInsuffisantException {
    	if(solde>=montant)
        this.solde -= montant;
    	else throw new soldeInsuffisantException("Solde Insuffisant");
    	/*soldeInsuffisantException X 
    	  = new soldeInsuffisantException("Solde Insuffisant");
    	  throw X;
    	 */
    	//new pour créer l'objet qui représente l'exception
    	//throw pour déclencher cette exception
    }

    public void virer(double montant,Compte C){
        this.solde -= montant; // retirer(montant) OU this.retirer(montant) OU solde -= montant
        C.solde += montant;
    }

    public Compte(String nom, double solde){  // Constructeur
        if (nom == null) {Scanner S=new Scanner(System.in);
        }
        this.nom = nom;
        this.solde = solde;
        nbComptes ++; this.numéro = nbComptes;
    }

    public Compte(){
        this("Titulaire inconnu",0.0);
    }

    public void ajouterop(Opération op) {
    	if (opérations != null) {
    	this.opérations.add(op);}
    }

    public String toString() {
		String s="";
		s+="Numero = "+numéro;
		s+="\tNom = "+nom;
		s+="\tSolde = "+solde;
		return s;
	 }
    
    public boolean equals(Compte compte) {
 	   return numéro==compte.numéro && solde==compte.solde && nom.equals(compte.nom);
    }
   // setters
   public void Setnuméro(int numéro){
       this.numéro = numéro;
   }

   public void Setnom(String nom){
       this.nom = nom;
   }

   public void Setsolde(double solde){
       this.solde = solde;
   }

   // getters
   public int Getnuméro(){
       return this.numéro;
   }

   public String Getnom(){
       return this.nom;
   }
   
   public double Getsolde(){
       return this.solde;
   }
   
   public abstract String typeDeCompte();
   
}


