package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

public class PrincipalFrame extends JFrame implements ActionListener {
	private JLabel titre;
	private JLabel citation;
	private JLabel ecrivain;
	private JButton livres;
	private JButton ajoutLivre;
	private JButton seanceLecture;
	final Color ROSE=new Color(244,194,194);
	 final Color BLEU=new Color(121,210,230);
	 final Color VIOLET=new Color(204,169,221);
	public PrincipalFrame(String titre) {
		super(titre);
		init();
		build();
		
	}
	public void init() {
		this.setSize(800,500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.WHITE);
		titre=new JLabel("IlhemThèque");
		titre.setFont(new Font("Itim", Font.PLAIN, 18));
		
		citation=new JLabel("Un lecteur vit un millier de vies avant de mourir."+"\n"+" Celui qui ne lit pas n'en vit qu'une.");
		ecrivain=new JLabel("George.R.R.Martin");
		citation.setFont(new Font("Itim", Font.PLAIN, 18));
		citation.setPreferredSize( new Dimension( 520, 50 ) );
		livres=new JButton("Mes livres");
		livres.setFont(new Font("Itim", Font.PLAIN, 18));
		livres.setBackground(BLEU);
		
		ajoutLivre=new JButton("Ajouter Livre");
		ajoutLivre.setBackground(ROSE);
		ajoutLivre.setFont(new Font("Itim", Font.PLAIN, 18));
		seanceLecture=new JButton("Séance de lecture");
		
		seanceLecture.setBackground(VIOLET);
		seanceLecture.setFont(new Font("Itim", Font.PLAIN, 18));
		this.ajoutLivre.addActionListener(this);
		this.seanceLecture.addActionListener(this);
		
		
	}
	public void build() {
		
		JPanel btn_panel=new JPanel(new GridLayout(1,3));
		JPanel mainPanel=new JPanel(new BorderLayout());
		JPanel titrePanel=new JPanel();
		JPanel espace=new JPanel();
		JPanel citation_panel=new JPanel(new BorderLayout());
		citation_panel.setPreferredSize( new Dimension( 250, 150 ) );
		Border border = citation_panel.getBorder();
		Border margin = new EmptyBorder(50,50,50,50);
		citation_panel.setBorder(new CompoundBorder(border, margin));
		
		citation_panel.add(citation,BorderLayout.CENTER);
		citation_panel.add(ecrivain,BorderLayout.SOUTH);
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
		mainPanel.add(header,BorderLayout.NORTH);
		mainPanel.add(citation_panel,BorderLayout.CENTER);

		
		this.getContentPane().add(mainPanel);
		this.livres.addActionListener(this);
		
	}
	@Override
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
		else if(e.getSource()==seanceLecture) {
			ReadingSessionFrame seanceLecture=new ReadingSessionFrame("Séance de lecture");
		}
		
	}

}
