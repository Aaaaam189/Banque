package tp.banque;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Opération implements Serializable{
   public static final int DEPOT=0, RETRAIT=1, VIREMENT=2;
   private int type;
   private double montant;
   private Date date;
   
   public Opération(int type,double montant,Date date) {
	   this.type = type;
	   this.montant = montant;
	   this.date = date;
   }
   
   public void settype(int type) {
	   this.type = type;
   }
   
   public void setmontant(double montant) {
	   this.montant = montant;
   }
   
   public void setdate(Date date) {
	   this.date = date;
   }
   
   public int gettype() {
	   return this.type;
   }
   
   public double getmontant() {
	   return this.montant;
   }
   
   public Date getdate() {
	   return this.date;
   }
   
   public boolean equals(Opération Op) {
	   return type==Op.type && montant==Op.montant && date.equals(Op.date);
   }
   
   public String toString() {
	   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    String dateStr = sdf.format(this.date);
	    String S = "";
	    S += dateStr;
	   S+=this.date;
	   switch(this.type) {
	   case Opération.DEPOT: S+="\tDépot"+"\t"+this.montant; break;
	   case Opération.RETRAIT: S+="\tRetrait"+"\t\t\t"+this.montant; break;
	   case Opération.VIREMENT: S+="\tVirement"+"\t\t\t"+this.montant;
	   }	   
	   return S;
	   
   }
   
   
}
