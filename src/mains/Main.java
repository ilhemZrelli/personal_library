package mains;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import connexion.ConnexionBD;
import ihm.AddBook;
import ihm.BooksFrame;
import ihm.PrincipalFrame;

public class Main {
   
	public static void main(String[] args) throws SQLException {
		
		// TODO Auto-generated method stub
      ConnexionBD cnx=new ConnexionBD();
      
		cnx.connect();
		 System.out.println("La connexion est effectuée");
		 cnx.createNewTable();
		 cnx.insert("978-200", "les dieux voyagent ingognito", "laurent gounelle", 475, 1, "en bon etat" , "dans ma bibiothèque", "en train de lire", 4, null, null);
		 cnx.select();
		 PrincipalFrame pf=new PrincipalFrame("IlhemThèque");
		 
     
      
	}

}
