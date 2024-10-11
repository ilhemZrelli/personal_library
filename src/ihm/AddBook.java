package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import connexion.ConnexionBD;

public class AddBook extends JFrame implements ActionListener {
	private JLabel titre;
	private JButton livres;
	private JButton ajoutLivre;
	private JButton seanceLecture;
	final Color ROSE=new Color(244,194,194);
	 final Color BLEU=new Color(121,210,230);
	 final Color VIOLET=new Color(204,169,221);
	 private JLabel sous_titre;
	 private JLabel isbn_label;
	 private JTextField isbn_text;
	 private JLabel titre_label;
	 private JTextField titre_text;
	 private JLabel auteur_label;
	 private JTextField auteur_text;
	 private JLabel nbPages_label;
	 private JTextField nbPages_text;
	 private JLabel nbCopies_label;
	 private JTextField nbCopies_text;
	 private JLabel etat_label;
	 private JComboBox etat_text;
	 private String[] etats;
	 private JLabel presence_label;
	 private JComboBox presence_text;
	 private String[] presence;
	 private JLabel etagere_label;
	 private JComboBox etagere_text;
	 private String[] etagere;
	 private JLabel note_label;
	 private JTextField note_text;
	 private JLabel resume_label;
	 private JTextArea resume_text;
	 private JLabel citation_label;
	 private JTextArea citation_text;
	 private JButton ajouter;
	 private int note;
	 private int nbPages;
	 private int nbCopies;
	 private  Connection connection;
	 
	 public AddBook(String titre) {
		 super(titre);
			init();
			build();
		 
	 }
	 public void init() {
			this.setSize(1200,700);
			this.setVisible(true);
			this.setLocationRelativeTo(null);
			
			titre=new JLabel("IlhemThèque");
			titre.setFont(new Font("Itim", Font.PLAIN, 18));
			
			livres=new JButton("Mes livres");
			livres.setFont(new Font("Itim", Font.PLAIN, 18));
			livres.setBackground(BLEU);
			ajoutLivre=new JButton("Ajouter Livre");
			ajoutLivre.setBackground(ROSE);
			ajoutLivre.setFont(new Font("Itim", Font.PLAIN, 18));
			seanceLecture=new JButton("Séance de lecture");
			seanceLecture.setBackground(VIOLET);
			seanceLecture.setFont(new Font("Itim", Font.PLAIN, 18));
			this.sous_titre=new JLabel("Un nouveau univers");
			sous_titre.setFont(new Font("Itim", Font.PLAIN, 18));
            isbn_label=new JLabel("ISBN:");
            this.isbn_text=new JTextField(10);
            this.titre_label=new JLabel("Titre: ");
            this.titre_text=new JTextField(10);
            this.auteur_label=new JLabel("Auteur");
            this.auteur_text=new JTextField(15);
            this.nbPages_label=new JLabel("Nombre de pages: ");
            this.nbPages_text=new JTextField(7);
            this.nbCopies_label=new JLabel("Nombre de copies: ");
            this.nbCopies_text=new JTextField(7);
            this.etat_label=new JLabel("Etat: ");
			etats=new String[3];
			etats[0]="Comme neuf";
			etats[1]="En bon état";
			etats[2]="Abimé";
            this.etat_text=new JComboBox(etats);
            
            this.presence_label=new JLabel("Presence: ");
			presence=new String[3];
			presence[0]="Dans ma bibliothèque";
			presence[1]="Emprunté";
			presence[2]="Vendu";
            this.presence_text=new JComboBox(presence);
            
            this.etagere_label=new JLabel("Etagere: ");
			etagere=new String[3];
			etagere[0]="A lire";
			etagere[1]="En train de lire";
			etagere[2]="Lu";
            this.etagere_text=new JComboBox(etagere);
            
            this.note_label=new JLabel("Note");
            this.note_text=new JTextField(4);
            
            this.resume_label=new JLabel("Résumé: ");
            this.resume_text=new JTextArea();
            
            this.citation_label=new JLabel("Citation: ");
            this.citation_text=new JTextArea();

            this.ajouter=new JButton("Ajouter");
            this.ajouter.addActionListener(this);
            
            ajouter.setPreferredSize( new Dimension( 120, 50 ) );
    		ajouter.setBackground(ROSE);
    		ajouter.setFont(new Font("Itim", Font.PLAIN, 16));
            
            
		}
		public void build() {
			
			JPanel btn_panel=new JPanel(new GridLayout(1,3));
			JPanel mainPanel=new JPanel(new BorderLayout());
			JPanel titrePanel=new JPanel();
			
			JPanel espace=new JPanel();
			JPanel principal_pane=new JPanel();
			JPanel formulaire_pane=new JPanel(new SpringLayout());
			Border border = formulaire_pane.getBorder();
			Border margin = new EmptyBorder(50,50,50,50);
			formulaire_pane.setBorder(new CompoundBorder(border, margin));
			

			
			formulaire_pane.add(isbn_label);
			formulaire_pane.add(isbn_text);
			
			formulaire_pane.add(titre_label);
			formulaire_pane.add(titre_text);
           
			formulaire_pane.add(auteur_label);
			formulaire_pane.add(auteur_text);

			
			formulaire_pane.add(nbPages_label);
			formulaire_pane.add(nbPages_text);

			formulaire_pane.add(nbCopies_label);
			formulaire_pane.add(nbCopies_text);

			formulaire_pane.add(etat_label);
			formulaire_pane.add(etat_text);
			
			formulaire_pane.add(etagere_label);
			formulaire_pane.add(etagere_text);

			formulaire_pane.add(note_label);
			formulaire_pane.add(note_text);

			formulaire_pane.add(resume_label);	
			formulaire_pane.add(resume_text);
			

			formulaire_pane.add(citation_label);
			formulaire_pane.add(citation_text);
			
			
			
			
			int nbLignes=10;
			int nbColonnes=2;
			SpringUtilities.makeCompactGrid(formulaire_pane, nbLignes, nbColonnes, 6, 6, 6, 6);
			
			JPanel sous_titre_panel=new JPanel();
			
			sous_titre_panel.setPreferredSize( new Dimension( 150, 50 ) );
			sous_titre_panel.add(sous_titre);
			sous_titre_panel.setBackground(ROSE);
			
			espace.setBackground(new Color(255,255,255));
			titrePanel.setPreferredSize( new Dimension( 500, 20 ) );
			titrePanel.setBackground(BLEU);
			titrePanel.setPreferredSize( new Dimension( 500, 50 ) );
			JPanel header=new JPanel(new BorderLayout());
			header.setSize(300, 100);
			header.add(titrePanel,BorderLayout.NORTH);
			header.add(espace,BorderLayout.CENTER);
			header.add(btn_panel,BorderLayout.SOUTH);
			btn_panel.setPreferredSize( new Dimension( 500, 60 ) );
			titrePanel.add(titre);
			
			btn_panel.add(livres);
			btn_panel.add(ajoutLivre);
			btn_panel.add(seanceLecture);
			principal_pane.add(sous_titre_panel);
			principal_pane.add(Box.createRigidArea(new Dimension(0, 10)));

			principal_pane.add(formulaire_pane);
			principal_pane.add(Box.createRigidArea(new Dimension(0, 10)));

			principal_pane.add(ajouter);
			mainPanel.add(header,BorderLayout.NORTH);
			mainPanel.add(principal_pane,BorderLayout.CENTER);
            mainPanel.add(ajouter,BorderLayout.SOUTH);
            
            BoxLayout bl=new BoxLayout(principal_pane,BoxLayout.Y_AXIS);
    		principal_pane.setLayout(bl);
			
			this.getContentPane().add(mainPanel);
			this.ajoutLivre.addActionListener(this);
			this.livres.addActionListener(this);
			
			
		}
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==livres) {
				try {
					BooksFrame bf=new BooksFrame("Mes livres");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			else if(e.getSource()==ajoutLivre)
			{
				AddBook ab=new AddBook("Ajouter livre");
			}
			else if(e.getSource()==ajouter) {
				
				try {
					connection = DriverManager.getConnection(
					          "jdbc:sqlite:theque.sqlite");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 String sql = "INSERT INTO books(ISBN,titre,auteur,nbPages,nbCopies,etat,presence,etagere,note,resume,citation) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

			        try (
			                PreparedStatement pstmt = connection.prepareStatement(sql)) {
			            pstmt.setString(1, isbn_text.getText());
			            pstmt.setString(2, titre_text.getText());
			            pstmt.setString(3, auteur_text.getText());
			            pstmt.setInt(4,Integer.parseInt( nbPages_text.getText()));
			            pstmt.setInt(5, Integer.parseInt(nbCopies_text.getText()));
			            pstmt.setString(6, etat_text.getSelectedItem().toString());
			            pstmt.setString(7, presence_text.getSelectedItem().toString());
			            pstmt.setString(8, etagere_text.getSelectedItem().toString());
			            pstmt.setInt(9, Integer.parseInt(note_text.getText()));
			            pstmt.setString(10, resume_text.getText());
			            pstmt.setString(11, citation_text.getText());
			            pstmt.executeUpdate();
			            
			        } catch (SQLException ex) {
			            System.out.println(ex.getMessage());
			        }
				
			}
			
		}
}
