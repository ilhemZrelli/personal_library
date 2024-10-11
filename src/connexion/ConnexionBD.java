package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionBD {
	private ResultSet resultSet = null;
    private  Statement statement = null;
     private  Connection connection = null;
     public void connect() {
	        // SQLite connection string
    	 
	        String url = "jdbc:sqlite:theque.sqlite";
	        
	        try {
	            connection = DriverManager.getConnection(url);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
    	 }
	        
	    
     
	 public void createNewTable() {
	        // SQLite connection string
	       
	        
	        // SQL statement for creating a new table
	        String sql = "CREATE TABLE IF NOT EXISTS books (\n"
	                + "	ISBN text PRIMARY KEY,\n"
	                + "	titre text NOT NULL,\n"
	                + "	auteur text NOT NULL,\n"
	                + "	nbPages integer NOT NULL,\n"
	                + "	nbCopies integer NOT NULL,\n"
	                + "	etat text NOT NULL,\n"
	                + "	presence text NOT NULL,\n"
	                + "	etagere text NOT NULL,\n"
	                + "	note integer,\n"
	                + "	resume text,\n"
	                + "	citation text\n"
	                + ");";
	        
	        try (
	                Statement stmt = connection.createStatement()) {
	        	
	            // create a new table
	            stmt.executeUpdate(sql);
	            
	           
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	 public void insert(String isbn, String titre,String auteur,int nbPages,int nbCopies,String etat,String presence,String etagere, int note,String resume,String citation) {
	        String sql = "INSERT INTO books(ISBN,titre,auteur,nbPages,nbCopies,etat,presence,etagere,note,resume,citation) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

	        try (
	                PreparedStatement pstmt = connection.prepareStatement(sql)) {
	            pstmt.setString(1, isbn);
	            pstmt.setString(2, titre);
	            pstmt.setString(3, auteur);
	            pstmt.setInt(4, nbPages);
	            pstmt.setInt(5, nbCopies);
	            pstmt.setString(6, etat);
	            pstmt.setString(7, presence);
	            pstmt.setString(8, etagere);
	            pstmt.setInt(9, note);
	            pstmt.setString(10, resume);
	            pstmt.setString(11, citation);
	            pstmt.executeUpdate();
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	 
	 public void select() throws SQLException {
		   statement = connection.createStatement();
		     resultSet = statement.executeQuery( "SELECT * FROM books;" );
		      
		      while ( resultSet.next() ) {
		         String isbn=resultSet.getString("isbn");
		         String titre=resultSet.getString("titre");
		         String auteur=resultSet.getString("auteur");
		         int nbPages=resultSet.getInt("nbPages");
		         int  nbCopies=resultSet.getInt("nbCopies");
		         String etat=resultSet.getString("etat");
		         String presence=resultSet.getString("presence");
		         String etagere=resultSet.getString("etagere");
		         int note=resultSet.getInt("note");
		         String resume=resultSet.getString("resume");
		         String citation=resultSet.getString("citation");
		         
		    	  System.out.println("----------------Nouvelle Entité--------------------");

		         System.out.println( "isbn = " + isbn);
		         System.out.println( "titre= " + titre);
		         System.out.println( "auteur = " + auteur);
		         System.out.println( "nbPages = " + nbPages);
		         System.out.println( "nbCopies = " + nbCopies);
		         System.out.println( "etat = " + etat);
		         System.out.println( "presence = " + presence);
		         System.out.println( "etagere = " + etagere);
		         System.out.println( "note = " + note);
		         System.out.println( "resume = " + resume);
		         System.out.println( "citation = " + citation);
		         System.out.println("---------------------------------------------------");
		        
		      }
	 }
		     

}
