package promosrt;

import java.awt.Color;
//import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class Admin extends JFrame implements ActionListener {

	private JPanel pane,paneH,paneB,paneM,paneGU,paneGD;
	private JButton gestionUser,gestionDonnee,deconnect,newCompte,deleteCompt,modifCompt,enregistrer,annuler;
	private JTextField username,pwd,typeUser;
	private JLabel labelUser,labelPwd,labelType,labelB1;
	private ArrayList<String[]> donnee,donnee1;
	private String[] title = {"Identifiant","Nom d'utilisateur","Mot de passe","Type d'utilisateur"},title1 = {"Identifiant","Nom d'utilisateur","Mot de passe","Type d'utilisateur"};
	private DefaultTableModel model,model1;
	private JTable table,table1;
	private Object[][] tableauD,tableauD1;
	private JScrollPane test,test1;
	
	PreparedStatement state;
	ResultSet result;
	public Admin() {
		setTitle("Administrateur Systéme");
		setSize(1250,800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pane = new JPanel();
		paneB = new JPanel();
		pane.setLayout(null);
		pane.setSize(1250,800);
		
		paneB.setBounds(0,640,1250,135 );
		paneB.setBackground(Color.gray);
	
//		###############################################PANEl du Haut##################################################
		paneH = new JPanel();
		paneH.setLayout(null);
		paneH.setBounds(0,0,1250,60);
		paneH.setBackground(new Color(61, 135, 172));
		
		gestionUser = new JButton("Gestion des Utilisateurs");
		gestionDonnee = new JButton("Gestion des Donnees");
		deconnect = new JButton("Deconnection");
		
		gestionUser.addActionListener(this);
		gestionDonnee.addActionListener(this);
		deconnect.addActionListener(this);
		
		gestionUser.setBackground(new Color(61, 135, 172));
		gestionDonnee.setBackground(new Color(61, 135, 172));
		deconnect.setBackground(new Color(61, 135, 172));
		gestionUser.setForeground(new Color(255, 255, 255));
		gestionDonnee.setForeground(new Color(255, 255, 255));
		deconnect.setForeground(new Color(255, 255, 255));
		deconnect.setBorder(null);
		
		gestionUser.setFont(new Font("Times New Roman", 1, 18));
		gestionDonnee.setFont(new Font("Times New Roman", 1, 18));
		deconnect.setFont(new Font("Times New Roman", 1, 18));
		
		gestionUser.setBounds(0,0,220,60);
		gestionDonnee.setBounds(220,0,200,60);
		deconnect.setBounds(1105,0,140,60);
		
		
		paneH.add(gestionUser);
		paneH.add(gestionDonnee);
		paneH.add(deconnect);
		
//		#########################################################PANEl du Milieu########################################################################
		paneM = new JPanel();
		paneM.setLayout(null);
		paneM.setBounds(0,60,1250,600);
		
//		#########################################################PANEl de Gestion des Utilisateur##########################################
		paneGU = new JPanel();
		paneGU.setLayout(null);
		paneGU.setBounds(0,0,1250,600);
		
		charge();
	    paneGU.add(test);
	    paneGU.add(test1);

	    
//		#########################################################PANEl de Gestion des Donnees##########################################
		paneGD = new JPanel();
		paneGD.setLayout(null);
		paneGD.setBounds(0,0,1250,600);
		
		username = new JTextField();
		pwd = new JTextField();
		typeUser = new JTextField();
		
		labelUser = new JLabel();
		labelPwd = new JLabel();
		labelType = new JLabel();
		
		labelPwd.setFont(new Font("Tahoma",1,14));
		labelType.setFont(new Font("Tahoma",1,14));
		
		username.setFont(new Font("Times New Roman",1,14));
		pwd.setFont(new Font("Times New Roman",1,14));
		typeUser.setFont(new Font("Times New Roman",1,14));
		
		newCompte = new JButton("Nouveau Compte");
		deleteCompt = new JButton("Supprimer un compte");
		modifCompt = new JButton("Modifier un compte");
		enregistrer = new JButton();
		annuler = new JButton();
		
		enregistrer.setFont(new Font("Agency FB",1,18));
		enregistrer.setForeground(new Color(255,255,255,255));
		
		annuler.setFont(new Font("Agency FB",1,18));
		annuler.setForeground(new Color(255,255,255,255));
		annuler.setBackground(new Color(202, 82,73));
		
		newCompte.setBounds(10,30,130,20);
		deleteCompt.setBounds(170,30,160,20);
		modifCompt.setBounds(360,30,150,20);
				
		newCompte.setFont(new Font("Tahoma",1,14));
		deleteCompt.setFont(new Font("Tahoma",1,14));
		modifCompt.setFont(new Font("Tahoma",1,14));
		
		newCompte.setBackground(new Color(238, 238, 238));
		deleteCompt.setBackground(new Color(238, 238, 238));
		modifCompt.setBackground(new Color(238, 238, 238));
		
		newCompte.setForeground(new Color(3,67,104));
		deleteCompt.setForeground(new Color(3,67,104));
		modifCompt.setForeground(new Color(3,67,104));
		
		newCompte.setBorder(null);
		deleteCompt.setBorder(null);
		modifCompt.setBorder(null);
		
		labelUser.setVisible(false);
		labelPwd.setVisible(false);
		labelType.setVisible(false);
		username.setVisible(false);
		pwd.setVisible(false);
		typeUser.setVisible(false);
		enregistrer.setVisible(false);
		annuler.setVisible(false);

		paneGD.add(newCompte);
		paneGD.add(deleteCompt);
		paneGD.add(modifCompt);
		paneGD.add(enregistrer);
		paneGD.add(annuler);
		paneGD.add(labelUser);
		paneGD.add(labelPwd);
		paneGD.add(labelType);
		paneGD.add(username);
		paneGD.add(pwd);
		paneGD.add(typeUser);
		
//		###############################################PANEl du Bas##################################################
		paneB.setBounds(0,640,1250,135 );
		paneB.setBackground(Color.gray);
        paneB.setLayout(null);
		
		labelB1 = new JLabel();
		
		labelB1.setForeground(new Color(255,255,255));
		
		labelB1.setFont(new Font("Times New Roman", 1,16));
		
		labelB1.setBounds(30,50,getWidth(),30);
		
		paneB.add(labelB1);
	
		paneGD.setVisible(false);
	    paneGU.setVisible(true);
	    paneM.add(paneGD);
	    paneM.add(paneGU);
			
		pane.add(paneH);
		pane.add(paneM);
		pane.add(paneB);
		this.getContentPane().add(pane);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == gestionUser.getText()) {
			paneGU.setVisible(true);
			paneGD.setVisible(false);

		}
		
		else if(e.getActionCommand() == deconnect.getText()) {
			dispose();
			MainPromo test = new MainPromo();
		}
		else if(e.getActionCommand() == gestionDonnee.getText()) {
			paneGU.setVisible(false);
			paneGD.setVisible(true);
			
			newCompte.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					newCompt();
					
				}
			});
			
			deleteCompt.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					deleteCompt();					
				}
			});
			
			modifCompt.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					modifCompt();					
				}
			});

		}
	}
	
	public void charge() {
		donnee = new ArrayList<>();
		donnee1 = new ArrayList<>();
		try {
			ConnecBase con = new ConnecBase();
			
			Statement recup1 = con.con.createStatement();
			ResultSet result = recup1.executeQuery("select * from authentification where status = 'etudiant'");
			
			while(result.next()) {
				
				donnee.add(new String[] {result.getString("id"),result.getString("users"),result.getString("pwd"),result.getString("status")});
				

			}
		int numRows = donnee.size();
		int numCols = 4;
		tableauD = new Object[numRows][numCols];
	
		for(int i = 0; i<numRows;i++) {
			
			tableauD[i] = donnee.get(i);
		}
		
		model = new DefaultTableModel(tableauD,title);
	    table = new JTable(model);
		test = new JScrollPane(table);
	    test.setBounds(20,60,600,300);

        JTableHeader header = table.getTableHeader();
		
		header.setFont(new Font("Tahoma", 1, 14));
		table.setFont(new Font("Times New Roman", 0, 16));
		header.setBackground(new Color(61, 135, 172));
		header.setForeground(Color.WHITE);
		
		
		Statement recup2 = con.con.createStatement();
		ResultSet result2 = recup2.executeQuery("select * from authentification where status = 'personnel'");
		
		while(result2.next()) {
			
			donnee1.add(new String[] {result2.getString("id"),result2.getString("users"),result2.getString("pwd"),result2.getString("status")});
			

		}
	int numRows1 = donnee1.size();
	int numCols1 = 4;
	tableauD1 = new Object[numRows1][numCols1];

	for(int i = 0; i<numRows1;i++) {
		
		tableauD1[i] = donnee1.get(i);
	}
	
	model1 = new DefaultTableModel(tableauD1,title1);
    table1 = new JTable(model1);
	test1 = new JScrollPane(table1);
    test1.setBounds(650,60,550,300);

    JTableHeader header1 = table1.getTableHeader();
	
	header1.setFont(new Font("Tahoma", 1, 14));
	table1.setFont(new Font("Times New Roman", 0, 16));
	header1.setBackground(new Color(61, 135, 172));
	header1.setForeground(Color.WHITE);
			
		}catch (Exception e) {
			
		}
	}
	
	public void newCompt() {
		labelUser.setText("Username");
		labelPwd.setText("Mot de passe");
		labelType.setText("Status");
		enregistrer.setText("Enrégistrer");
		annuler.setText("Annuler");
		
		labelUser.setFont(new Font("Tahoma",1,14));
		enregistrer.setBackground(new Color(3,67,104));
		
		labelUser.setBounds(30,80,130,20);
		labelPwd.setBounds(30,120,130,20);
		labelType.setBounds(30,160,130,20);
		
		username.setBounds(170,80,200,30);
		pwd.setBounds(170,120,200,30);
		typeUser.setBounds(170,160,200,30);
		
		enregistrer.setBounds(70,230,120,30);
		annuler.setBounds(230,230,120,30);

		labelUser.setVisible(true);
		labelPwd.setVisible(true);
		labelType.setVisible(true);
		username.setVisible(true);
		pwd.setVisible(true);
		typeUser.setVisible(true);
		enregistrer.setVisible(true);
		annuler.setVisible(true);
		
		enregistrer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ConnecBase con =new ConnecBase();
					PreparedStatement state = con.con.prepareStatement("insert into authentification (users,pwd,status) values(?,?,?)");
					state.setString(1, username.getText());
					state.setString(2, pwd.getText());
					state.setString(3, typeUser.getText());
					state.executeUpdate();
					state.close();
					labelB1.setText("Le nouveau compte a été ajouté avec succés");
					username.setText("");
					pwd.setText("");
					typeUser.setText("");
					
				}catch (Exception ex) {
					labelB1.setText("Une erreur s'est produit lors de l'ajoute "+ex);
				}
				
			}
		});
		
		annuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				labelB1.setText("Le processus a été annulé avec succés");
				username.setText("");
				pwd.setText("");
				typeUser.setText("");
				
				labelUser.setVisible(false);
				labelPwd.setVisible(false);
				labelType.setVisible(false);
				username.setVisible(false);
				pwd.setVisible(false);
				typeUser.setVisible(false);
				enregistrer.setVisible(false);
				annuler.setVisible(false);
				
			}
		});
		
	}
	
	public void deleteCompt() {
		username.setText("");

		labelUser.setText("Saisir l'ID du compte que vous voulez supprimer");
		enregistrer.setText("Exécuter");
		
		labelUser.setFont(new Font("Times New Roman", 2, 18));
		enregistrer.setBackground(new Color(3,67,104));
		
		labelUser.setBounds(30,80,getHeight(),20);		
		username.setBounds(30,120,120,30);
		enregistrer.setBounds(160,120,100,30);
		
		labelUser.setVisible(true);
		username.setVisible(true);
		enregistrer.setVisible(true);
		
		labelPwd.setVisible(false);
		labelType.setVisible(false);
		pwd.setVisible(false);
		typeUser.setVisible(false);
		annuler.setVisible(false);
		
		enregistrer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(username.getText());
				try {
					ConnecBase con = new ConnecBase();
					PreparedStatement state = con.con.prepareStatement("delete from authentification where id = ?");
					state.setInt(1, i);
					int ligne = state.executeUpdate();
					if(ligne > 0 ) {
						username.setText("");
						labelB1.setText("Le compte a été supprimé avec succés");					
						}
					else {
						labelB1.setText("L'ID saisit n'éxiste pas !!!");
					}	
					
				}catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});
	}
	
	public void modifCompt() {
		username.setText("");

		labelUser.setText("Saisir l'ID du compte que vous voulez modifier");
		enregistrer.setText("OK");
		
		labelUser.setFont(new Font("Times New Roman", 2, 18));
		
		enregistrer.setBackground(new Color(43, 168,43));
		
		labelUser.setBounds(30,80,getHeight(),20);		
		username.setBounds(30,120,120,30);
		enregistrer.setBounds(160,120,100,30);
		
		labelUser.setVisible(true);
		username.setVisible(true);
		enregistrer.setVisible(true);
		
		labelPwd.setVisible(false);
		labelType.setVisible(false);
		pwd.setVisible(false);
		typeUser.setVisible(false);
		annuler.setVisible(false);
		
		enregistrer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				labelUser.setText("Username");
				labelPwd.setText("Mot de passe");
				labelType.setText("Status");
				enregistrer.setText("Appliquer");
				annuler.setText("Annuler");
		
				
				labelUser.setFont(new Font("Tahoma",1,14));
				enregistrer.setBackground(new Color(43, 168,43));
				
				labelUser.setBounds(30,80,130,20);
				labelPwd.setBounds(30,120,130,20);
				labelType.setBounds(30,160,130,20);
				
				username.setBounds(170,80,200,30);
				pwd.setBounds(170,120,200,30);
				typeUser.setBounds(170,160,200,30);
				
				enregistrer.setBounds(70,230,120,30);
				annuler.setBounds(230,230,120,30);

				labelUser.setVisible(true);
				labelPwd.setVisible(true);
				labelType.setVisible(true);
				username.setVisible(true);
				pwd.setVisible(true);
				typeUser.setVisible(true);
				enregistrer.setVisible(true);
				annuler.setVisible(true);
				
				String j = username.getText();
				int i = Integer.parseInt(username.getText());
				
				try {
					ConnecBase con = new ConnecBase();
					String query = "select * from authentification where id = ?";
					PreparedStatement state = con.con.prepareStatement(query);
					state.setInt(1, i);
					ResultSet result = state.executeQuery();
					if(result.next()) {
						username.setText(result.getString("users"));
						pwd.setText(result.getString("pwd"));
						typeUser.setText(result.getString("status"));
					}
					
					else {
						labelB1.setText("L'ID saisit n'éxiste pas !!!");
						
						labelUser.setVisible(false);
						labelPwd.setVisible(false);
						labelType.setVisible(false);
						username.setVisible(false);
						pwd.setVisible(false);
						typeUser.setVisible(false);
						enregistrer.setVisible(false);
						annuler.setVisible(false);
					}
					
				}catch (Exception ex) {
					// TODO: handle exception
				}
				
				enregistrer.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int k = Integer.parseInt(j);
						try {
							ConnecBase con = new ConnecBase();
							PreparedStatement state = con.con.prepareStatement("UPDATE authentification SET users=?, pwd=?, status=? WHERE id = ?");
							state.setString(1, username.getText());
							state.setString(2, pwd.getText());
							state.setString(3,  typeUser.getText());
							state.setInt(4,  k);
							state.executeUpdate();
							state.close();
							
							labelB1.setText("Le compte a été modifié avec succés");					
							username.setText("");
							pwd.setText("");
							typeUser.setText("");
							
						}catch (Exception ex) {
							labelB1.setText("Une erreur s'est produit lors du modification "+ex);
						}
						
					}
				});
				
				annuler.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						labelB1.setText("Le processus a été annulé avec succés");
						username.setText("");
						pwd.setText("");
						typeUser.setText("");
						
						labelUser.setVisible(false);
						labelPwd.setVisible(false);
						labelType.setVisible(false);
						username.setVisible(false);
						pwd.setVisible(false);
						typeUser.setVisible(false);
						enregistrer.setVisible(false);
						annuler.setVisible(false);
						
					}
				});
			}
		});
	}
	
}
