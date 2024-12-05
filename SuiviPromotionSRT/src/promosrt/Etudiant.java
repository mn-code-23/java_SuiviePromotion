package promosrt;

import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class Etudiant extends JFrame implements ActionListener{
	private JPanel pane,paneH,paneM,paneB,paneProfil,paneModifier,paneAmis;
	private JButton monProfil,modifierProfil,amis,deconnect,modifiInfos,modifiCursus,modifiParcour,modifiMaster,enregistrerModif,addPar,supPar,add,sup,plus;
	private JLabel label1,label2,label3,label4,label5,label6,label7,labelB1;
	private JTextField text1,text2,text3,text4,text5,text6,text7,text;
	private JScrollPane parcourpro;
	private JTextArea infosEtudiant,cursus,parcour,inscriMaster;
	private int i = 0;
	private String annee = "";
	String email = "";
	
	public Etudiant() {
		setTitle("Etudiant de l'UADB");
		setSize(1250,800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pane = new JPanel();
		paneB = new JPanel();
		pane.setLayout(null);
		pane.setSize(1250,700);
		
		paneB.setBounds(0,610,1250,70);
		paneB.setBackground(Color.gray);
	
//		###############################################PANEl du Haut##################################################
		paneH = new JPanel();
		paneH.setLayout(null);
		paneH.setBounds(0,0,1250,60);
		paneH.setBackground(new Color(61, 135, 172));
		
		monProfil = new JButton("Mon Profil");
		modifierProfil = new JButton("Modifier Profil");
		amis = new JButton("Amis(es)");
		deconnect = new JButton("Deconnection");
		
		monProfil.setBackground(new Color(61, 135, 172));
		modifierProfil.setBackground(new Color(61, 135, 172));
		amis.setBackground(new Color(61, 135, 172));
		deconnect.setBackground(new Color(61, 135, 172));
		monProfil.setForeground(new Color(255, 255, 255));
		modifierProfil.setForeground(new Color(255, 255, 255));
		amis.setForeground(new Color(255, 255, 255));
		deconnect.setForeground(new Color(255, 255, 255));
		deconnect.setBorder(null);
		
		monProfil.setFont(new Font("Times New Roman", 1, 18));
		modifierProfil.setFont(new Font("Times New Roman", 1, 18));
		amis.setFont(new Font("Times New Roman", 1, 18));
		deconnect.setFont(new Font("Times New Roman", 1, 18));
		
		monProfil.setBounds(0,0,130,60);
		modifierProfil.setBounds(130,0,155,60);
		amis.setBounds(285,0,130,60);
		deconnect.setBounds(1105,0,140,60);
		
		monProfil.addActionListener(this);
		modifierProfil.addActionListener(this);
		amis.addActionListener(this);
		deconnect.addActionListener(this);
		
		paneH.add(monProfil);
		paneH.add(modifierProfil);
		paneH.add(amis);
		paneH.add(deconnect);
		
//		#########################################################PANEl du Milieu########################################################################
		paneM = new JPanel();
		paneM.setLayout(null);
		paneM.setBounds(0,60,1250,600);
//		###############################################PANEl Mon Profil##################################################
		paneProfil = new JPanel();
		paneProfil.setBounds(0,0,1250,550);
		paneProfil.setLayout(null);
		
//		recuperation de la variable au niveau de la classe mainpromo
		String name = (String) getData.username;
		
		JLabel infos = new JLabel("Information de l'Etudiant");
		JTextArea textArea = new JTextArea();
		JScrollPane qwer = new JScrollPane(textArea);
		textArea.setEditable(false);
		
		JTextArea textArea1 = new JTextArea();
		JScrollPane qwer1 = new JScrollPane(textArea1);
		textArea1.setEditable(false);
		JLabel infos1 = new JLabel("Cursus Universitaire");
		
		JTextArea textArea2 = new JTextArea();
		JScrollPane qwer2 = new JScrollPane(textArea2);
		textArea2.setEditable(false);
		JLabel infos2 = new JLabel("Parcour Professionnel");
		
		JTextArea textArea3 = new JTextArea();
		JScrollPane qwer3 = new JScrollPane(textArea3);
		textArea3.setEditable(false);
		JLabel infos3 = new JLabel("Inscription Master");

	        try {
	        	ConnecBase con = new ConnecBase();
	        	PreparedStatement recup =con.con.prepareStatement("select * from infosetudiant "
						+ "inner join cursusuniver "
						+ "on infosetudiant.id = cursusuniver.etudiantID "
						+ "where email = ?");
	            recup.setString(1, name);
	            ResultSet resultSet = recup.executeQuery();

	            StringBuilder data = new StringBuilder();
	            StringBuilder data1 = new StringBuilder();
	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                i=id;
	                String prenom = resultSet.getString("prenom");
	                String nom = resultSet.getString("nom");
	                String domicil = resultSet.getString("domicil");
	                String tel = resultSet.getString("tel");
	                String email = resultSet.getString("email");
	                String pwd = resultSet.getString("pwd");
	                
	                String anneeD = resultSet.getString("anneeD");
	                annee = anneeD;
	                String anneeF = resultSet.getString("anneeF");
	                String diplome = resultSet.getString("diplome");
	                String etabliss = resultSet.getString("etabliss");

	                data.append("Code Permanent : ").append(id).append("\n").
	                append("Prenom : ").append(prenom).append("\n").
	                append("Nom : ").append(nom).append("\n").
	                append("Domicil : ").append(domicil).append("\n").
	                append("Telephone : ").append(tel).append("\n").
	                append("Email : ").append(email).append("\n").
	                append("Mot de Passe : ").append(pwd).append("\n");
	                
	                data1.append("Annee de Debut : ").append(anneeD).append("\n").
	                append("Annee de Fin : ").append(anneeF).append("\n").
	                append("Nom Diplome").append(diplome).append("\n").
	                append("Nom de L'Universite : ").append(etabliss).append("\n");
	            }
	            
	            PreparedStatement recup1 = con.con.prepareStatement("SELECT * FROM parcourpro where etudiantID = ?");
				recup1.setInt(1, i);
	            ResultSet resultSet1 = recup1.executeQuery();

	            StringBuilder data2 = new StringBuilder();
	            while (resultSet1.next()) {
	                String anneeD = resultSet1.getString("anneeD");
	                String anneeF = resultSet1.getString("anneeF");
	                String poste = resultSet1.getString("poste");
	                String contrat = resultSet1.getString("contrat");
	                String entreprise = resultSet1.getString("entreprise");
	             
	                data2.append("Annee de Debut : ").append(anneeD).append("\n").
	                append("Annee de Fin : ").append(anneeF).append("\n").
	                append("Poste Occupe : ").append(poste).append("\n").
	                append("Type de Contrat : ").append(contrat).append("\n").
	                append("Entreprise : ").append(entreprise).append("\n").
	                append("_____________________________________________").append("\n");

	            }
	            
	            PreparedStatement recup3 = con.con.prepareStatement("SELECT * FROM master where etudiantID = ?");
				recup3.setInt(1, i);
	            ResultSet resultSet3 = recup3.executeQuery();

	            StringBuilder data3 = new StringBuilder();
	            while (resultSet3.next()) {
	                String niveauM = resultSet3.getString("niveauM");
	                String etabliss = resultSet3.getString("etabliss");
	             
	                data3.append("Niveau Master : ").append(niveauM).append("\n").
	                append("Etablissemnt : ").append(etabliss).append("\n");
	            }

	            textArea3.setText(data3.toString());

	            textArea2.setText(data2.toString());

	            textArea.setText(data.toString());
	            textArea1.setText(data1.toString());

	            con.con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

		textArea.setFont(new Font("Times New Roman", 1,18));
		textArea1.setFont(new Font("Times New Roman", 1,18));
		textArea2.setFont(new Font("Times New Roman", 1,18));
		textArea3.setFont(new Font("Times New Roman", 1,18));
		
		infos.setFont(new Font("Times New Roman", 2,22));
		infos1.setFont(new Font("Times New Roman", 2,22));
		infos2.setFont(new Font("Times New Roman", 2,22));
		infos3.setFont(new Font("Times New Roman", 2,22));
		
		qwer.setBounds(50,70,250,300);
		qwer1.setBounds(320,70,250,300);
		qwer2.setBounds(580,70,250,300);
		qwer3.setBounds(840,70,250,300);
		
		infos.setBounds(50,40,250,20);
		infos1.setBounds(320,40,250,20);
		infos2.setBounds(580,40,250,20);
		infos3.setBounds(840,40,250,20);
		
		paneProfil.add(infos);
		paneProfil.add(infos1);
		paneProfil.add(infos2);
		paneProfil.add(infos3);
		paneProfil.add(qwer);
		paneProfil.add(qwer1);
		paneProfil.add(qwer2);
		paneProfil.add(qwer3);
		
		paneM.add(paneProfil);
		
//		###############################################PANEl du Modifier Mon profil##################################################
		paneModifier = new JPanel();
		paneModifier.setBounds(0,0,1250,550);
		paneModifier.setLayout(null);
		
		add = new JButton();
		sup = new JButton();
		
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		label6 = new JLabel();
		label7 = new JLabel();
		
		text1 = new JTextField();
		text2 = new JTextField();
		text3 = new JTextField();
		text4 = new JTextField();
		text5 = new JTextField();
		text6 = new JTextField();
		text7 = new JTextField();
		
		modifiCursus = new JButton("Cursus Universitaire");
		modifiInfos = new JButton("Information Etudiant");
		modifiParcour = new JButton("Parcour Pro");
		modifiMaster = new JButton("Inscrition Master");
		enregistrerModif = new JButton("Enregistrer");
		addPar = new JButton("Nouveau Parcour");
		supPar = new JButton("Supprimer Parcour");
		
		modifiInfos.setBounds(10,30,190,20);
		modifiCursus.setBounds(210,30,180,20);
		modifiParcour.setBounds(400,30,120,20);
		modifiMaster.setBounds(530,30,160,20);
		addPar.setBounds(850,30,135,30);
		supPar.setBounds(1050,30,150,30);

		modifiInfos.setFont(new Font("Tahoma",1,14));
		modifiCursus.setFont(new Font("Tahoma",1,14));
		modifiParcour.setFont(new Font("Tahoma",1,14));
		modifiMaster.setFont(new Font("Tahoma",1,14));
		addPar.setFont(new Font("Agency FB",1,17));
		supPar.setFont(new Font("Agency FB",1,17));

		modifiInfos.setBackground(new Color(238, 238, 238));
		modifiCursus.setBackground(new Color(238, 238, 238));
		modifiParcour.setBackground(new Color(238, 238, 238));
		modifiMaster.setBackground(new Color(238, 238, 238));
		addPar.setBackground(new Color(43, 168,43));
		supPar.setBackground(new Color(202, 82,73));
		
		modifiInfos.setForeground(new Color(3,67,104));
		modifiCursus.setForeground(new Color(3,67,104));
		modifiParcour.setForeground(new Color(3,67,104));
		modifiMaster.setForeground(new Color(3,67,104));
		addPar.setForeground(new Color(255, 255, 255));
		supPar.setForeground(new Color(255, 255, 255));
		
		modifiInfos.setBorder(null);
		modifiCursus.setBorder(null);
		modifiParcour.setBorder(null);
		modifiMaster.setBorder(null);
 		
		paneModifier.add(modifiCursus);
		paneModifier.add(modifiInfos);
		paneModifier.add(modifiParcour);
		paneModifier.add(modifiMaster);
		paneModifier.add(addPar);
		paneModifier.add(supPar);
		
		paneModifier.add(label1);
		paneModifier.add(label2);
		paneModifier.add(label3);
		paneModifier.add(label4);
		paneModifier.add(label5);
		paneModifier.add(label6);
		paneModifier.add(label7);
		paneModifier.add(text1);
		paneModifier.add(text2);
		paneModifier.add(text3);
		paneModifier.add(text4);
		paneModifier.add(text5);
		paneModifier.add(text6);
		paneModifier.add(text7);
		paneModifier.add(enregistrerModif);
		paneModifier.add(add);
		paneModifier.add(sup);
		
		paneM.add(paneModifier);
		
//		###############################################PANEl DES AMIS##################################################
		paneAmis = new JPanel();
		paneAmis.setBounds(0,0,1250,550);
		paneAmis.setLayout(null);	

		cursus = new JTextArea();
        infosEtudiant = new JTextArea();
        parcour = new JTextArea();
        inscriMaster = new JTextArea();
        parcourpro = new JScrollPane(parcour);

        int y = 30;
		try {
		ConnecBase con = new ConnecBase();
		PreparedStatement recup = con.con.prepareStatement("select prenom, nom from infosetudiant "
				+ "inner join cursusuniver "
				+ "on infosetudiant.id = cursusuniver.etudiantID "
				+ "where anneeD = ?");
		recup.setString(1, annee);
		ResultSet result = recup.executeQuery();
		while(result.next()) {
			String preno = result.getString("prenom");
			String no = result.getString("nom");
			
			JLabel label = new JLabel(preno+" "+no);
			label.setFont(new Font("Times New Roman",1,25));
			label.setForeground(Color.black);
			
			label.setBounds(10,y,getWidth(),30);
			y+=30;
			paneAmis.add(label);		
		}
		JLabel label = new JLabel();
		text = new JTextField();
		label.setText("Pour afficher plus d'information sur l'un(e) de vos amis(e), Veillez saisir son prénom");
		label.setBounds(600,30,getWidth(),20);
		label.setFont(new Font("Tahoma",2,15));
		label.setForeground(new Color(61, 135, 172));
		paneAmis.add(label);
		
		text.setFont(new Font("Times New Roman",1,15));
		text.setBounds(800, 60, 200, 30);
		paneAmis.add(text);
		
		plus = new JButton("+");
		plus.setFont(new Font("Tahoma",1,20));
		plus.setBackground(new Color(43, 168,43));
		plus.setForeground(new Color(255, 255, 255, 255));
		plus.setBounds(1010,60,50,30);
		paneAmis.add(plus);

		}catch (Exception e) {

		}
		
		paneAmis.add(infosEtudiant);
		paneAmis.add(parcourpro);
		paneAmis.add(inscriMaster);
		paneM.add(paneAmis);

	
//		###############################################PANEl du Bas##################################################
		paneB.setBounds(0,640,1250,135);
		paneB.setBackground(Color.gray);
		paneB.setLayout(null);
		
		labelB1 = new JLabel();
		
		labelB1.setForeground(new Color(255,255,255));
		
		labelB1.setFont(new Font("Times New Roman", 1,16));
		
		labelB1.setBounds(30,50,getWidth(),30);
		
		paneB.add(labelB1);
		
		paneProfil.setVisible(true);
		paneModifier.setVisible(false);
		paneAmis.setVisible(false);
		pane.add(paneH);
		pane.add(paneM);
		pane.add(paneB);
		this.getContentPane().add(pane);
		setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == monProfil.getText()) {
			paneProfil.setVisible(true);
			paneModifier.setVisible(false);
			paneAmis.setVisible(false);
		}
		
		else if(e.getActionCommand() == modifierProfil.getText()) {
			paneProfil.setVisible(false);
			paneModifier.setVisible(true);
			paneAmis.setVisible(false);

			
			modifiInfos.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					modifierInfos();
					
				}
			});
			modifiCursus.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					modifierCursus();
					
				}
			});
            modifiParcour.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					modifierParcour();
					
				}
			});
            modifiMaster.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					modifierMaster();
					
				}
			});
            
            addPar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					newPar();
					
				}
			});
            
            supPar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					deletePar();
					
				}
			});
		}
		
		else if(e.getActionCommand() == amis.getText()) {
			paneProfil.setVisible(false);
			paneModifier.setVisible(false);
			paneAmis.setVisible(true);
			
			plus.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getActionCommand() == plus.getText()) {
						int j=0;
						try {
							ConnecBase con = new ConnecBase();
							PreparedStatement recup =con.con.prepareStatement("select * from infosetudiant "
									+ "inner join cursusuniver "
									+ "on infosetudiant.id = cursusuniver.etudiantID "
									+ "where prenom = ?");
							recup.setString(1, text.getText());
							ResultSet result = recup.executeQuery();
							StringBuilder donnee = new StringBuilder();
							while(result.next()) {
								int i = result.getInt("id");
								String prenom = result.getString("prenom");
				                String nom = result.getString("nom");
				                String domicil = result.getString("domicil");
				                String tel = result.getString("tel");
				                String email = result.getString("email");
				                j=i;
				                String anneeD = result.getString("anneeD");
				                String anneeF = result.getString("anneeF");
				                String diplome = result.getString("diplome");
				                
				                donnee.append("Prenom : ").append(prenom).append("\n").
				                append("Nom : ").append(nom).append("\n").
				                append("Domicil : ").append(domicil).append("\n").
				                append("Telephone : ").append(tel).append("\n").
				                append("Email : ").append(email).append("\n").
				                
				                append("__________________________________").append("\n").
				                append("Annee de Debut : ").append(anneeD).append("\n").
				                append("Annee de Fin : ").append(anneeF).append("\n").
				                append("Diplome : ").append(diplome).append("\n");
				                
							}
							
							PreparedStatement recup1 =con.con.prepareStatement("select * from parcourpro where etudiantID = ?");
							recup1.setInt(1, j);
							ResultSet result1 = recup1.executeQuery();
							StringBuilder donnee1 = new StringBuilder();
							while(result1.next()) {
				                String anneeDP = result1.getString("anneeD");
				                String anneeFP = result1.getString("anneeF");
				                String poste = result1.getString("poste");
				                String contrat = result1.getString("contrat");
				                String entreprise = result1.getString("entreprise");
				          
				                donnee1.append("Annee de Debut : ").append(anneeDP).append("\n").
				                append("Annee de Fin : ").append(anneeFP).append("\n").
				                append("Poste Occupé : ").append(poste).append("\n").
				                append("Type de contrat : ").append(contrat).append("\n").
				                append("Nom de L'entreprise : ").append(entreprise).append("\n").
				                append("__________________________________").append("\n");
							}
							parcour.setText(donnee1.toString());
							parcour.setFont(new Font("Times New Roman", 1,16));
							parcourpro.setBounds(900,120,250,190);
							
							PreparedStatement recup2 =con.con.prepareStatement("select * from master where etudiantID = ?");
							recup2.setInt(1, j);
							ResultSet result2 = recup2.executeQuery();
							StringBuilder donnee2 = new StringBuilder();
							while(result2.next()) {
				                String niveauM = result2.getString("niveauM");
				                String etabliss = result2.getString("etabliss");
				          
				                donnee2.append("Niveau Master : ").append(niveauM).append("\n").
				                append("Université : ").append(etabliss).append("\n");
							}
							inscriMaster.setText(donnee2.toString());
							inscriMaster.setFont(new Font("Times New Roman", 1,16));
							inscriMaster.setBounds(750,330,250,100);
							
							infosEtudiant.setText(donnee.toString());
							infosEtudiant.setFont(new Font("Times New Roman", 1,16));
							infosEtudiant.setBounds(600,120,250,190);
						}catch (Exception ex) {

						}
					}
				}
					
			});
		}
		
		else if(e.getActionCommand() == deconnect.getText()) {
			MainPromo main = new MainPromo();
			dispose();
		}
		
	}
	
		
	public void modifierInfos() {
		label1.setText("Prenom");
		label2.setText("Nom");
		label3.setText("Domicil");
		label4.setText("Telephone");
		label5.setText("Email");
		label6.setText("Mot de passe");
		label7.setText("");
				
		label1.setFont(new Font("Tahoma",1,14));
		label2.setFont(new Font("Tahoma",1,14));
		label3.setFont(new Font("Tahoma",1,14));
		label4.setFont(new Font("Tahoma",1,14));
		label5.setFont(new Font("Tahoma",1,14));
		label6.setFont(new Font("Tahoma",1,14));
		label7.setFont(new Font("Tahoma",1,14));
		
		text1.setFont(new Font("Times New Roman",1,14));
		text2.setFont(new Font("Times New Roman",1,14));
		text3.setFont(new Font("Times New Roman",1,14));
		text4.setFont(new Font("Times New Roman",1,14));
		text5.setFont(new Font("Times New Roman",1,14));
		text6.setFont(new Font("Times New Roman",1,14));
		text7.setFont(new Font("Times New Roman",1,14));
				
		enregistrerModif.setFont(new Font("Agency FB",1,18));
		enregistrerModif.setForeground(new Color(255,255,255,255));
		enregistrerModif.setBackground(new Color(3,67,104));
		enregistrerModif.setBounds(450,170,120,30);

		label1.setBounds(30,80,130,20);
		label2.setBounds(30,120,130,20);
		label3.setBounds(30,160,130,20);
		label4.setBounds(30,200,130,20);
		label5.setBounds(30,240,130,20);
		label6.setBounds(30,280,130,20);
		label7.setBounds(30,320,130,20);
		
		text1.setBounds(170,80,200,30);
		text2.setBounds(170,120,200,30);
		text3.setBounds(170,160,200,30);
		text4.setBounds(170,200,200,30);
		text5.setBounds(170,240,200,30);
		text6.setBounds(170,280,200,30);
		text7.setBounds(170,320,200,30);
		
		
		
		try {
        	ConnecBase con = new ConnecBase();
			PreparedStatement recup = con.con.prepareStatement("SELECT * FROM infosetudiant where id = ?");
			recup.setInt(1, i);
            ResultSet resultSet = recup.executeQuery();

            while (resultSet.next()) {
                String prenom = resultSet.getString("prenom");
                String nom = resultSet.getString("nom");
                String domicil = resultSet.getString("domicil");
                String tel = resultSet.getString("tel");
                email = resultSet.getString("email");
                String pwd = resultSet.getString("pwd");
                
                text1.setText(prenom);
                text2.setText(nom);
                text3.setText(domicil);
                text4.setText(tel);
                text5.setText(email);
                text6.setText(pwd);
                
               
            }
            con.con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		enregistrerModif.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ConnecBase con = new ConnecBase();
					PreparedStatement state = con.con.prepareStatement("UPDATE infosetudiant SET prenom=?, nom=?,domicil=?, tel=?, email=?, pwd=? WHERE id = ?");
					state.setString(1, text1.getText());
					state.setString(2, text2.getText());
					state.setString(3,  text3.getText());
					state.setString(4,  text4.getText());
					state.setString(5,  text5.getText());
					state.setString(6,  text6.getText());
					state.setInt(7, i);
					
					PreparedStatement state1 = con.con.prepareStatement("UPDATE authentification SET users=?, pwd=? WHERE users = ?");
					state1.setString(1,  text5.getText());
					state1.setString(2,  text6.getText());
					state1.setString(3, email);
					
					state.executeUpdate();
					state1.executeUpdate();
					labelB1.setText("Modification effectuée avec succée");
					state.close();
					state1.close();
				}catch (Exception ex) {
					labelB1.setText("Echec de la modification 1 "+ex);
				}				
			}
		});
		
		label1.setVisible(true);
		label2.setVisible(true);
		label3.setVisible(true);
		label4.setVisible(true);
		label5.setVisible(true);
		label6.setVisible(true);
		label7.setVisible(false);
		
		text1.setVisible(true);
		text2.setVisible(true);
		text3.setVisible(true);
		text4.setVisible(true);
		text5.setVisible(true);
		text6.setVisible(true);
		text7.setVisible(false);
		
		add.setVisible(false);
		sup.setVisible(false);
		enregistrerModif.setVisible(true);
	}
	
	public void modifierCursus() {
		label1.setText("Annee de debut");
		label2.setText("Annee de Fin");
		label3.setText("Nom Diplome");
		label4.setText("Universite");
		
		label1.setFont(new Font("Tahoma",1,14));
		label2.setFont(new Font("Tahoma",1,14));
		label3.setFont(new Font("Tahoma",1,14));
		label4.setFont(new Font("Tahoma",1,14));
		
		text1.setFont(new Font("Times New Roman",1,14));
		text2.setFont(new Font("Times New Roman",1,14));
		text3.setFont(new Font("Times New Roman",1,14));
		text4.setFont(new Font("Times New Roman",1,14));
		
		enregistrerModif.setFont(new Font("Agency FB",1,18));
		enregistrerModif.setForeground(new Color(255,255,255,255));
		enregistrerModif.setBackground(new Color(3,67,104));
		enregistrerModif.setBounds(450,170,120,30);

		label1.setBounds(30,80,130,20);
		label2.setBounds(30,120,130,20);
		label3.setBounds(30,160,130,20);
		label4.setBounds(30,200,130,20);
		
		text1.setBounds(170,80,200,30);
		text2.setBounds(170,120,200,30);
		text3.setBounds(170,160,200,30);
		text4.setBounds(170,200,200,30);
		
		try {
        	ConnecBase con = new ConnecBase();
        	PreparedStatement recup = con.con.prepareStatement("SELECT * FROM cursusuniver where etudiantID = ?");
			recup.setInt(1, i);
            ResultSet resultSet = recup.executeQuery();

            while (resultSet.next()) {
                String anneeD = resultSet.getString("anneeD");
                String anneeF = resultSet.getString("anneeF");
                String diplome = resultSet.getString("diplome");
                String etabliss = resultSet.getString("etabliss");
                
                text1.setText(anneeD);
                text2.setText(anneeF);
                text3.setText(diplome);
                text4.setText(etabliss);
            }

            con.con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
        enregistrerModif.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					ConnecBase con = new ConnecBase();
					PreparedStatement state = con.con.prepareStatement("UPDATE cursusuniver SET anneeD=?, anneeF=?, diplome=?, etabliss=? WHERE etudiantID = ?");
					state.setString(1, text1.getText());
					state.setString(2, text2.getText());
					state.setString(3,  text3.getText());
					state.setString(4,  text4.getText());
					state.setInt(5, i);
					state.executeUpdate();
					labelB1.setText("Modification effectuée avec succée");
					state.close();
				}catch (Exception ex) {
					labelB1.setText("Echec de la modification 2 "+ex);
				}				
			}
		});
		
		label1.setVisible(true);
		label2.setVisible(true);
		label3.setVisible(true);
		label4.setVisible(true);
		label5.setVisible(false);
		label6.setVisible(false);
		label7.setVisible(false);
		
		text1.setVisible(true);
		text2.setVisible(true);
		text3.setVisible(true);
		text4.setVisible(true);
		text5.setVisible(false);
		text6.setVisible(false);
		text7.setVisible(false);
		
		add.setVisible(false);
		sup.setVisible(false);
		enregistrerModif.setVisible(true);
	}
	
	public void modifierParcour() {

		label1.setText("Annee de debut");
		label2.setText("Annee de Fin");
		label3.setText("Poste Occupee");
		label4.setText("Contrat");
		label5.setText("Entreprise");
		
		text1.setText("");
        text2.setText("");
        text3.setText("");
        text4.setText("");
        text5.setText("");
        
		label1.setFont(new Font("Tahoma",1,14));
		label2.setFont(new Font("Tahoma",1,14));
		label3.setFont(new Font("Tahoma",1,14));
		label4.setFont(new Font("Tahoma",1,14));
		label5.setFont(new Font("Tahoma",1,14));
		
		text1.setFont(new Font("Times New Roman",1,14));
		text2.setFont(new Font("Times New Roman",1,14));
		text3.setFont(new Font("Times New Roman",1,14));
		text4.setFont(new Font("Times New Roman",1,14));
		text5.setFont(new Font("Times New Roman",1,14));

		enregistrerModif.setFont(new Font("Agency FB",1,18));
		enregistrerModif.setForeground(new Color(255,255,255,255));
		enregistrerModif.setBackground(new Color(3,67,104));
		enregistrerModif.setBounds(450,170,120,30);

		label1.setBounds(30,80,130,20);
		label2.setBounds(30,120,130,20);
		label3.setBounds(30,160,130,20);
		label4.setBounds(30,200,130,20);
		label5.setBounds(30,240,130,20);

		text1.setBounds(170,80,200,30);
		text2.setBounds(170,120,200,30);
		text3.setBounds(170,160,200,30);
		text4.setBounds(170,200,200,30);
		text5.setBounds(170,240,200,30);
		
		try {
        	ConnecBase con = new ConnecBase();
        	PreparedStatement recup = con.con.prepareStatement("SELECT * FROM parcourpro where etudiantID = ?");
			recup.setInt(1, i);          
            ResultSet resultSet = recup.executeQuery();

            while (resultSet.next()) {
                String anneeD = resultSet.getString("anneeD");
                String anneeF = resultSet.getString("anneeF");
                String poste = resultSet.getString("poste");
                String contrat = resultSet.getString("contrat");
                String entreprise = resultSet.getString("entreprise");
                
                text1.setText(anneeD);
                text2.setText(anneeF);
                text3.setText(poste);
                text4.setText(contrat);
                text5.setText(entreprise);
            }

            con.con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		 enregistrerModif.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {

					try {
						ConnecBase con = new ConnecBase();
						PreparedStatement state = con.con.prepareStatement("UPDATE parcourpro SET anneeD=?, anneeF=?, poste=?, contrat=?, entreprise=? WHERE etudiantID = ?");
						state.setString(1, text1.getText());
						state.setString(2, text2.getText());
						state.setString(3,  text3.getText());
						state.setString(4,  text4.getText());
						state.setString(5,  text5.getText());
						state.setInt(6, i);
						state.executeUpdate();
						labelB1.setText("Modification effectuée avec succée");
						state.close();
					}catch (Exception ex) {
						labelB1.setText("Echec de la modification 3 "+ex);
					}				
				}
			});

		label1.setVisible(true);
		label2.setVisible(true);
		label3.setVisible(true);
		label4.setVisible(true);
		label5.setVisible(true);
		label6.setVisible(false);
		label7.setVisible(false);
		
		text1.setVisible(true);
		text2.setVisible(true);
		text3.setVisible(true);
		text4.setVisible(true);
		text5.setVisible(true);
		text6.setVisible(false);
		text7.setVisible(false);
		
		add.setVisible(false);
		sup.setVisible(false);
		enregistrerModif.setVisible(true);
	}
	
	public void modifierMaster() {
		label1.setText("Niveau Master");
		label2.setText("Universite");
		
		 text1.setText("");
		 text2.setText("");
		
		label1.setFont(new Font("Tahoma",1,14));
		label2.setFont(new Font("Tahoma",1,14));
		
		text1.setFont(new Font("Times New Roman",1,14));
		text2.setFont(new Font("Times New Roman",1,14));
		
		enregistrerModif.setFont(new Font("Agency FB",1,18));
		enregistrerModif.setForeground(new Color(255,255,255,255));
		enregistrerModif.setBackground(new Color(3,67,104));
		enregistrerModif.setBounds(450,170,120,30);

		label1.setBounds(30,80,130,20);
		label2.setBounds(30,120,130,20);

		text1.setBounds(170,80,200,30);
		text2.setBounds(170,120,200,30);
		
		 try {
	        	ConnecBase con = new ConnecBase();
	        	PreparedStatement recup = con.con.prepareStatement("SELECT * FROM master where etudiantID = ?");
				recup.setInt(1, i);
	            ResultSet resultSet = recup.executeQuery();

	            while (resultSet.next()) {
	                String niveauM = resultSet.getString("niveauM");
	                String etabliss = resultSet.getString("etabliss");
	                
	                text1.setText(niveauM);
	                text2.setText(etabliss);
	             
	            }

	            con.con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 
		 enregistrerModif.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {

					try {
						ConnecBase con = new ConnecBase();
						PreparedStatement state = con.con.prepareStatement("UPDATE master SET niveauM=?, etabliss=? WHERE etudiantID = ?");
						state.setString(1, text1.getText());
						state.setString(2, text2.getText());
						state.setInt(3, i);
						state.executeUpdate();
						labelB1.setText("Modification effectuée avec succée");
						state.close();
					}catch (Exception ex) {
						labelB1.setText("Echec de la modification 4 "+ex);
					}				
				}
			});
			
		label1.setVisible(true);
		label2.setVisible(true);
		label3.setVisible(false);
		label4.setVisible(false);
		label5.setVisible(false);
		label6.setVisible(false);
		label7.setVisible(false);
		
		text1.setVisible(true);
		text2.setVisible(true);
		text3.setVisible(false);
		text4.setVisible(false);
		text5.setVisible(false);
		text6.setVisible(false);
		text7.setVisible(false);
		
		add.setVisible(false);
		sup.setVisible(false);
		enregistrerModif.setVisible(true);
	}
	
	public void newPar() {
		add.setText("Ajouter");
		sup.setText("Annuler");
		
		label1.setText("Annee de debut");
		label2.setText("Annee de Fin");
		label3.setText("Poste Occupee");
		label4.setText("Contrat");
		label5.setText("Entreprise");
		
		text1.setText("");
		text2.setText("");
		text3.setText("");
		text4.setText("");
		text5.setText("");


		label1.setFont(new Font("Tahoma",1,14));
		label2.setFont(new Font("Tahoma",1,14));
		label3.setFont(new Font("Tahoma",1,14));
		label4.setFont(new Font("Tahoma",1,14));
		label5.setFont(new Font("Tahoma",1,14));
		
		text1.setFont(new Font("Times New Roman",1,14));
		text2.setFont(new Font("Times New Roman",1,14));
		text3.setFont(new Font("Times New Roman",1,14));
		text4.setFont(new Font("Times New Roman",1,14));
		text5.setFont(new Font("Times New Roman",1,14));

		add.setFont(new Font("Agency FB",1,18));
		add.setForeground(new Color(255,255,255,255));
		add.setBackground(new Color(3,67,104));
		add.setBounds(900,300,100,30);
		
		sup.setBounds(1050,300,100,30);
		sup.setFont(new Font("Agency FB",1,18));
		sup.setForeground(new Color(255,255,255,255));
		sup.setBackground(new Color(202, 82,73));

		label1.setBounds(860,80,130,20);
		label2.setBounds(860,120,130,20);
		label3.setBounds(860,160,130,20);
		label4.setBounds(860,200,130,20);
		label5.setBounds(860,240,130,20);

		text1.setBounds(1000,80,200,30);
		text2.setBounds(1000,120,200,30);
		text3.setBounds(1000,160,200,30);
		text4.setBounds(1000,200,200,30);
		text5.setBounds(1000,240,200,30);
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ConnecBase con = new ConnecBase();
					PreparedStatement state = con.con.prepareStatement("insert into parcourpro (anneeD, anneeF, poste, contrat, entreprise,etudiantID) values(?,?,?,?,?,?)");
					state.setString(1, text1.getText());
					state.setString(2, text2.getText());
					state.setString(3,  text3.getText());
					state.setString(4,  text4.getText());
					state.setString(5,  text5.getText());
					state.setInt(6, i);
					state.executeUpdate();
					labelB1.setText("Ajout d'un nouveau parcour professionnel avec succée");
					state.close();
				}catch (Exception ex) {
					labelB1.setText("Echec de l'ajout du nouveau parcour professionnel"+ex);
				}				
			}
		});
		
		sup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				text1.setText("");	
				text2.setText("");	
				text3.setText("");	
				text4.setText("");	
				text5.setText("");	
			}
		});


		label1.setVisible(true);
		label2.setVisible(true);
		label3.setVisible(true);
		label4.setVisible(true);
		label5.setVisible(true);
		label6.setVisible(false);
		label7.setVisible(false);
		
		text1.setVisible(true);
		text2.setVisible(true);
		text3.setVisible(true);
		text4.setVisible(true);
		text5.setVisible(true);
		text6.setVisible(false);
		text7.setVisible(false);
		
		add.setVisible(true);
		sup.setVisible(true);
		enregistrerModif.setVisible(false);
	}
	
	public void deletePar() {
		add.setText("Exécuter");
		sup.setText("Annuler");
		
		label1.setText("Veillez saisir l'annee de debut du parcour que vous voulez supprimer");
		
		text1.setText("2000-01-20");

		label1.setFont(new Font("Tahoma",2,14));
		
		text1.setFont(new Font("Times New Roman",1,14));

		add.setFont(new Font("Agency FB",1,18));
		add.setForeground(new Color(255,255,255,255));
		add.setBackground(new Color(3,67,104));
		add.setBounds(900,170,100,30);
		
		sup.setBounds(1050,170,100,30);
		sup.setFont(new Font("Agency FB",1,18));
		sup.setForeground(new Color(255,255,255,255));
		sup.setBackground(new Color(202, 82,73));

		label1.setBounds(790,90,getWidth(),20);

		text1.setBounds(950,120,100,30);
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ConnecBase con = new ConnecBase();
					PreparedStatement recup = con.con.prepareStatement("delete from parcourpro where anneeD = ? and etudiantID = ?");
		            recup.setString(1, text1.getText());
		            recup.setInt(2, i);
		            int ligne = recup.executeUpdate();
					if(ligne>0) {
						JOptionPane.showMessageDialog(null, "Suppression reussi");
					}
					else {
						JOptionPane.showMessageDialog(null, "La date saisi n'existe ou ne vous appartient pas");
					}
		            
		            
				}catch (Exception ex) {
					// TODO: handle exception
				}
				
			}
		});
		
		sup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				text1.setText("");				
			}
		});

		label1.setVisible(true);
		label2.setVisible(false);
		label3.setVisible(false);
		label4.setVisible(false);
		label5.setVisible(false);
		label6.setVisible(false);
		label7.setVisible(false);
		
		text1.setVisible(true);
		text2.setVisible(false);
		text3.setVisible(false);
		text4.setVisible(false);
		text5.setVisible(false);
		text6.setVisible(false);
		text7.setVisible(false);
		
		add.setVisible(true);
		sup.setVisible(true);
		enregistrerModif.setVisible(false);
	}
	
	public void amis() {
		
	}

}
