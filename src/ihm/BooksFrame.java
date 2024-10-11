package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import connexion.ConnexionBD;

public class BooksFrame extends JFrame implements ActionListener {
	private JLabel titre;
	private JButton livres;
	private JButton ajoutLivre;
	private JButton seanceLecture;
	final Color ROSE=new Color(244,194,194);
	 final Color BLEU=new Color(121,210,230);
	 final Color VIOLET=new Color(204,169,221);
	 private JTable table;
	 private JScrollPane sp;
	 private ConnexionBD cnx; 
	 Vector columnNames ;
     Vector data;
	 
	public BooksFrame(String titre) throws SQLException {
		super(titre);

		init();
		build();
		
		
	}
	
	
	public void init() {
		this.setSize(900,500);
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
		
          //recupérer les données de la base 
          columnNames=new Vector();
          data=new Vector();
          try {
        	 
              Connection con = DriverManager.getConnection(
                      "jdbc:sqlite:theque.sqlite");
        	  
        	  String sql = "SELECT * FROM books; ";
              Statement statement = con.createStatement();
              ResultSet resultSet = statement.executeQuery(sql);
              ResultSetMetaData metaData = resultSet.getMetaData();
              int columns = metaData.getColumnCount();
              for (int i = 1; i <= columns; i++) {
                 
                  columnNames.addElement(metaData.getColumnName(i));
                  
              }
              while (resultSet.next()) {
                  Vector row = new Vector(columns);
                  for (int i = 1; i <= columns; i++) {
                      row.addElement(resultSet.getObject(i));
                  }
                  data.addElement(row);
              }
              resultSet.close();
              statement.close();
          } catch (Exception e) {
              System.out.println(e);
          }
          
          
 table=new JTable(data,columnNames);
          
          table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );       
          table.setPreferredScrollableViewportSize(new Dimension(850,200));
          JTableHeader header = table.getTableHeader();
          header.setBackground(BLEU);
          
          TableColumnModel columnModel =table.getColumnModel();
         
          columnModel.getColumn(1).setPreferredWidth(200);
          columnModel.getColumn(1).setMaxWidth(200);
          columnModel.getColumn(2).setPreferredWidth(150);
          columnModel.getColumn(2).setMaxWidth(150);
          columnModel.getColumn(3).setPreferredWidth(150);
          columnModel.getColumn(3).setMaxWidth(150);
          columnModel.getColumn(4).setPreferredWidth(150);
          columnModel.getColumn(5).setMaxWidth(100);
          columnModel.getColumn(5).setPreferredWidth(100);
          columnModel.getColumn(6).setPreferredWidth(150);
          columnModel.getColumn(6).setMaxWidth(150);
          columnModel.getColumn(7).setPreferredWidth(150);
          columnModel.getColumn(7).setMaxWidth(150);
          columnModel.getColumn(4).setMaxWidth(150);
          columnModel.getColumn(8).setPreferredWidth(250);
          columnModel.getColumn(8).setMaxWidth(150);
          columnModel.getColumn(9).setPreferredWidth(250);
          columnModel.getColumn(9).setMaxWidth(250);
          columnModel.getColumn(10).setPreferredWidth(250);
          columnModel.getColumn(10).setMaxWidth(250);
          sp=new JScrollPane(table);  
          
		
		
	}
	public void build() {
		
		JPanel btn_panel=new JPanel(new GridLayout(1,3));
		JPanel mainPanel=new JPanel(new BorderLayout());
		JPanel titrePanel=new JPanel();
		JPanel espace=new JPanel();
		JPanel tablePanel=new JPanel();
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
		this.ajoutLivre.addActionListener(this);
		titrePanel.add(titre);
		
		btn_panel.add(livres);
		btn_panel.add(ajoutLivre);
		btn_panel.add(seanceLecture);
		tablePanel.add(sp);
		mainPanel.add(header,BorderLayout.NORTH);
		mainPanel.add(tablePanel);

		
		this.getContentPane().add(mainPanel);
		
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
		
	}

}
