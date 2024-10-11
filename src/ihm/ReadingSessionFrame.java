package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import threads.SessionThread;

public class ReadingSessionFrame extends JFrame implements ActionListener{
	private JTextField minutes;
	private JButton demarrer;
	private SessionThread st;
	private JButton pause;
	private JButton reprendre;
	private JButton annuler;
	private JPanel principalPanel;
	private JLabel concentration;
	private JLabel motivation;
	 final Color VIOLET=new Color(204,169,221);
	public ReadingSessionFrame(String titre) {
		super(titre);
		this.init();
		this.build();
		
	}
	public void init() {
		this.setSize(600,500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		minutes=new JTextField(4);
		demarrer=new JButton("Démarrer");
		demarrer.addActionListener(this);
		demarrer.setPreferredSize( new Dimension( 120, 50 ) );
		demarrer.setBackground(VIOLET);
		demarrer.setFont(new Font("Itim", Font.PLAIN, 16));
		
		pause=new JButton("Pause");
		pause.addActionListener(this);
		pause.setPreferredSize( new Dimension( 120, 50 ) );
		pause.setBackground(VIOLET);
		pause.setFont(new Font("Itim", Font.PLAIN, 16));
		
		reprendre=new JButton("Reprendre");
		reprendre.addActionListener(this);
		reprendre.setPreferredSize( new Dimension( 120, 50 ) );
		reprendre.setBackground(VIOLET);
		reprendre.setFont(new Font("Itim", Font.PLAIN, 16));
		
		annuler=new JButton("Réinitialiser");
		annuler.addActionListener(this);
		annuler.setPreferredSize( new Dimension( 120, 50 ) );
		annuler.setBackground(VIOLET);
		annuler.setFont(new Font("Itim", Font.PLAIN, 16));
		
		
		concentration=new JLabel("Concentre toi !!!");
		concentration.setFont(new Font("Itim", Font.PLAIN, 18));
		concentration.setPreferredSize( new Dimension( 520, 50 ) );
		
		motivation=new JLabel("Prends ton livre et commence une séance de lecture !!!");
		motivation.setFont(new Font("Itim", Font.PLAIN, 18));
		motivation.setPreferredSize( new Dimension( 520, 50 ) );
		
	}
	public void build() {
		JPanel composants=new JPanel();
		
		principalPanel=new JPanel();
		principalPanel.add(motivation);
		principalPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		principalPanel.add(minutes);
		principalPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		principalPanel.add(demarrer);
		BoxLayout bl=new BoxLayout(principalPanel,BoxLayout.Y_AXIS);
		principalPanel.setLayout(bl);
		composants.add(principalPanel);
		this.getContentPane().add(composants);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		if(e.getSource()==demarrer && this.minutes.getText()!="") {
			this.principalPanel.add(concentration);
			demarrer.setVisible(false);
			motivation.setVisible(false);
		    this.principalPanel.add(pause);
		    principalPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		    this.principalPanel.add(reprendre);
		    principalPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		    this.principalPanel.add(annuler);
		    this.pause.setVisible(true);
			this.reprendre.setVisible(true);
			this.annuler.setVisible(true);
           
			
			
			
			this.st=new SessionThread(this.minutes);
			Thread t=new Thread(this.st);
			t.start();
			
			
			
		}
		else if(e.getSource()==pause) {
			st.stop();
		}
		else if(e.getSource()==annuler) {
			this.minutes.setText("0");
			st.stop();
	
			this.demarrer.setVisible(true);
			this.pause.setVisible(false);
			this.reprendre.setVisible(false);
			this.annuler.setVisible(false);
		}
		else if(e.getSource()==reprendre) {
			
			this.st=new SessionThread(this.minutes);
			Thread t=new Thread(this.st);
			t.start();
			
		}
		}catch(NumberFormatException ex) {
			ex.getMessage();
		}
		
	
		
	}

}
