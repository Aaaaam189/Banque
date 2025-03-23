package tp.banque;

import java.io.Serializable;

public class soldeInsuffisantException extends Exception implements Serializable{
   private String msg;
   
   public soldeInsuffisantException(String msg) {
	   this.msg =msg;
   }
   
   public void afficher() {
	   System.out.println(msg);
   }
}
