package promosrt;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.Border;

public class MainPromo extends JFrame{
	private JPanel pane,pane1,pane2,InfosEtu,cursus,parcour,master;
	private JTextField user,status,prenom,nom,domicil,tel,email,codeP,anneeD,anneeF,nomDi,etabliss,anneeDP,anneeFP,poste,contrat,entreprise,niveauM,etablissM;
	private JPasswordField pwd,mdp;
	private JButton login,sign,nextInfos,nextCursus,previousCursus,nextParcour,previousParcour,ignoreParcour,finish,previousMaster,ignoreMaster;
	private JLabel infos,userText,pwdText,statusText,textCode,textPrenom,textNom,textDom,textTel,textemail,textMdp,textD,textF,textNomDi,textEtabliss,textDP,textFP,textPoste,textContrat,textEntreprise,textNiveau,textEtablissM;
   
	PreparedStatement state;
	
	public MainPromo() {
		setTitle("Authentification");
		setSize(900,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		pane = new JPanel();
		pane.setSize(900,600);
		pane.setLayout(null);
		pane1 = new JPanel();
		pane2 = new JPanel();
		
//		############################################# PANE I ########################################
		//pane1.setSize(450,600);
		pane1.setBounds(0,0,450,600);
		pane1.setBackground(new Color(61, 135, 172));
		pane1.setLayout(null);
		infos = new JLabel("Si vous n'avez pas de compte veillez vous s'incrire !");
		sign = new JButton("Cliquez ici");
		sign.setBackground(new Color(8, 44, 58));
		sign.setForeground(new Color(255, 255, 255));
		sign.setBorder(null);
		
		infos.setFont(new Font("Tahoma", 2, 16));
		sign.setFont(new Font("Agency FB", 1, 16));
		
		infos.setBounds(25,200,400,30);
		sign.setBounds(150,235,100,30);
		
		sign.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == sign.getText()) {
					InfosEtu.setVisible(true);
					pane.setVisible(false);
				}	
			}	
		});

		pane1.add(infos);
		pane1.add(sign);
		
//		############################################# PANE II ########################################
		pane2.setBounds(450,0,450,600);
		pane2.setBackground(Color.gray);
		pane2.setLayout(null);
		userText = new JLabel("Nom d'utilisateur :");
		pwdText = new JLabel("Mot de passe :");
		statusText = new JLabel("Status :");
		user = new JTextField();
		pwd = new JPasswordField();
		status = new JTextField();
		login  = new JButton("Log In");
		login.setBackground(new Color(65, 185, 206));
		login.setForeground(new Color(255, 255, 255));
		
		userText.setFont(new Font("Tahoma", 1, 14));
		pwdText.setFont(new Font("Tahoma", 1, 14));
		statusText.setFont(new Font("Tahoma", 1, 14));
		user.setFont(new Font("Time To New Roman", 1, 14));
		pwd.setFont(new Font("Time To New Roman", 1, 14));
		status.setFont(new Font("Time To New Roman", 1, 14));
		login.setFont(new Font("Agency FB", 1, 24));
		
		userText.setBounds(50,150,150,30);
		pwdText.setBounds(50,200,150,30);
		statusText.setBounds(50,250,150,30);
    	user.setBounds(200,150,180,30);
		pwd.setBounds(200,200,180,30);
		status.setBounds(200,250,180,30);
		login.setBounds(205,300,170,40);
		
		pane2.add(userText);
		pane2.add(pwdText);
		pane2.add(statusText);
		pane2.add(user);
		pane2.add(pwd);
		pane2.add(status);
		pane2.add(login);
		
//		######################################Panel Infos Etudiant##################################
		InfosEtu = new JPanel();
		InfosEtu.setSize(900,600);
		InfosEtu.setLayout(null);
		JPanel toppane = new JPanel();
		toppane.setLayout(null);
		JLabel texttop = new JLabel("Information personnelle de L'etudiant");
		textCode = new JLabel("Code Permanent");
		textPrenom = new JLabel("Prenom");
		textNom = new JLabel("Nom");
		textDom = new JLabel("Adresse domicil");
		textTel = new JLabel("Numero de telephone");
		textemail = new JLabel("Adresse mail");
		textMdp = new JLabel("Mot de passe");
		nextInfos = new JButton("Suivant");
		codeP = new JTextField();
		prenom = new JTextField();
		nom = new JTextField();
		domicil = new JTextField();
		tel = new JTextField();
		email = new JTextField();
		mdp = new JPasswordField();
		
		toppane.setBackground(new Color(61, 135, 172));
		texttop.setForeground(new Color(255, 255, 255));
		nextInfos.setBackground(new Color(61, 135,172));
		nextInfos.setForeground(new Color(255, 255, 255));
		
		texttop.setFont(new Font("Tahoma" ,1, 24));
		textCode.setFont(new Font("Tahoma", 0, 14));
		textPrenom.setFont(new Font("Tahoma", 0, 14));
		textNom.setFont(new Font("Tahoma", 0, 14));
		textDom.setFont(new Font("Tahoma", 0, 14));
		textTel.setFont(new Font("Tahoma", 0, 14));
		textemail.setFont(new Font("Tahoma", 0, 14));
		textMdp.setFont(new Font("Tahoma", 0, 14));
		codeP.setFont(new Font("Times New Roman", 1, 18));
		prenom.setFont(new Font("Times New Roman", 1, 18));
		nom.setFont(new Font("Times New Roman", 1, 18));
		domicil.setFont(new Font("Times New Roman", 1, 18));
		tel.setFont(new Font("Times New Roman", 1, 18));
		email.setFont(new Font("Times New Roman", 1, 18));
		mdp.setFont(new Font("Times New Roman", 1, 18));
		nextInfos.setFont(new Font("Agency FB", 1, 24));
		
		toppane.setBounds(0,0,900,60);
		texttop.setBounds(220,5,500,50);
		textCode.setBounds(50,120,120,30);
		textPrenom.setBounds(550,120,120,30);
		textNom.setBounds(50,200,120,30);
		textDom.setBounds(550,200,120,30);
		textTel.setBounds(50,280,150,30);
		textemail.setBounds(550,280,120,30);
		textMdp.setBounds(50,360,120,30);
		codeP.setBounds(50,152,250,30);
		prenom.setBounds(550,152,250,30);
		nom.setBounds(50,232,250,30);
		domicil.setBounds(550,232,250,30);
		tel.setBounds(50,312,250,30);
		email.setBounds(550,312,250,30);
		mdp.setBounds(50,392,250,30);
		nextInfos.setBounds(700,450,100,50);
		
		toppane.add(texttop);
		InfosEtu.add(toppane);
		InfosEtu.add(textCode);
		InfosEtu.add(textPrenom);
		InfosEtu.add(textNom);
		InfosEtu.add(textDom);
		InfosEtu.add(textTel);
		InfosEtu.add(textemail);
		InfosEtu.add(textMdp);
		InfosEtu.add(codeP);
		InfosEtu.add(prenom);
		InfosEtu.add(nom);
		InfosEtu.add(domicil);
		InfosEtu.add(tel);
		InfosEtu.add(email);
		InfosEtu.add(mdp);
		InfosEtu.add(nextInfos);
		
//		######################################Panel Cursus Universitaire##################################
		cursus = new JPanel();
		cursus.setSize(900,600);
		cursus.setLayout(null);
		JPanel toppaneC = new JPanel();
		toppaneC.setLayout(null);
		JLabel texttopC = new JLabel("Cursur Universitaire");
		textD = new JLabel("Annee de debut");
		textF = new JLabel("Annee de fin");
		textNomDi = new JLabel("Nom du diplome");
		textEtabliss = new JLabel("Etablissement");
		nextCursus = new JButton("Suivant");
		previousCursus = new JButton("Precedent");
		anneeD = new JTextField();
		anneeF = new JTextField();
		nomDi = new JTextField();
		etabliss = new JTextField();
		
		toppaneC.setBackground(new Color(61, 135, 172));
		texttopC.setForeground(new Color(255, 255, 255));
		nextCursus.setBackground(new Color(61, 135,172));
		nextCursus.setForeground(new Color(255, 255, 255));
		previousCursus.setBackground(new Color(61, 135,172));
		previousCursus.setForeground(new Color(255, 255, 255));
		
		texttopC.setFont(new Font("Tahoma" ,1, 24));
		textD.setFont(new Font("Tahoma", 0, 14));
		textF.setFont(new Font("Tahoma", 0, 14));
		textNomDi.setFont(new Font("Tahoma", 0, 14));
		textEtabliss.setFont(new Font("Tahoma", 0, 14));
		anneeD.setFont(new Font("Times New Roman", 1, 18));
		anneeF.setFont(new Font("Times New Roman", 1, 18));
		nomDi.setFont(new Font("Times New Roman", 1, 18));
		etabliss.setFont(new Font("Times New Roman", 1, 18));
		nextCursus.setFont(new Font("Agency FB", 1, 24));
		previousCursus.setFont(new Font("Agency FB", 1, 24));
		
		toppaneC.setBounds(0,0,900,60);
		texttopC.setBounds(320,5,300,50);
		textD.setBounds(50,120,120,30);
		textF.setBounds(550,120,120,30);
		textNomDi.setBounds(50,200,120,30);
		textEtabliss.setBounds(550,200,120,30);
		anneeD.setBounds(50,152,250,30);
		anneeF.setBounds(550,152,250,30);
		nomDi.setBounds(50,232,250,30);
		etabliss.setBounds(550,232,250,30);
		nextCursus.setBounds(700,450,100,50);
		previousCursus.setBounds(50,450,120,50);
		
		toppaneC.add(texttopC);
		cursus.add(toppaneC);
		cursus.add(textD);
		cursus.add(textF);
		cursus.add(textNomDi);
		cursus.add(textEtabliss);
		cursus.add(anneeD);
		cursus.add(anneeF);
		cursus.add(nomDi);
		cursus.add(etabliss);
		cursus.add(previousCursus);
		cursus.add(nextCursus);
		
//		######################################Panel Parcour Professionnel##################################
		parcour = new JPanel();
		parcour.setSize(900,600);
		parcour.setLayout(null);
		JPanel toppaneP = new JPanel();
		toppaneP.setLayout(null);
		JLabel texttopP = new JLabel("Parcour Professionnel");
		textDP = new JLabel("Annee de debut");
		textFP = new JLabel("Annee de fin");
		textPoste = new JLabel("Poste occuper");
		textContrat = new JLabel("Type de contrat");
		textEntreprise = new JLabel("Entreprise");
		nextParcour = new JButton("Suivant");
		previousParcour = new JButton("Precedent");
		ignoreParcour = new JButton("Ignorer");
		anneeDP = new JTextField();
		anneeFP = new JTextField();
		poste = new JTextField();
		contrat = new JTextField();
		entreprise = new JTextField();
		
		toppaneP.setBackground(new Color(61, 135, 172));
		texttopP.setForeground(new Color(255, 255, 255));
		nextParcour.setBackground(new Color(61, 135,172));
		nextParcour.setForeground(new Color(255, 255, 255));
		previousParcour.setBackground(new Color(61, 135,172));
		previousParcour.setForeground(new Color(255, 255, 255));
		ignoreParcour.setBackground(new Color(242,242,242));
		ignoreParcour.setForeground(new Color(61, 135, 172));
		ignoreParcour.setBorder(null);
		
		texttopP.setFont(new Font("Tahoma" ,1, 24));
		textDP.setFont(new Font("Tahoma", 0, 14));
		textFP.setFont(new Font("Tahoma", 0, 14));
		textPoste.setFont(new Font("Tahoma", 0, 14));
		textContrat.setFont(new Font("Tahoma", 0, 14));
		textEntreprise.setFont(new Font("Tahoma", 0, 14));
		anneeDP.setFont(new Font("Times New Roman", 1, 18));
		anneeFP.setFont(new Font("Times New Roman", 1, 18));
		poste.setFont(new Font("Times New Roman", 1, 18));
		contrat.setFont(new Font("Times New Roman", 1, 18));
		entreprise.setFont(new Font("Times New Roman", 1, 18));
		nextParcour.setFont(new Font("Agency FB", 1, 24));
		previousParcour.setFont(new Font("Agency FB", 1, 24));
		ignoreParcour.setFont(new Font("Agency FB", 1, 20));
		
		toppaneP.setBounds(0,0,900,60);
		texttopP.setBounds(320,5,300,50);
		textDP.setBounds(50,120,120,30);
		textFP.setBounds(550,120,120,30);
		textPoste.setBounds(50,200,120,30);
		textContrat.setBounds(550,200,120,30);
		textEntreprise.setBounds(50,280,120,30);
		anneeDP.setBounds(50,152,250,30);
		anneeFP.setBounds(550,152,250,30);
		poste.setBounds(50,232,250,30);
		contrat.setBounds(550,232,250,30);
		entreprise.setBounds(50,312,250,30);
		nextParcour.setBounds(700,450,100,50);
		previousParcour.setBounds(50,450,120,50);
		ignoreParcour.setBounds(800,70,100,30);
		
		
		
		toppaneP.add(texttopP);
		parcour.add(toppaneP);
		parcour.add(textDP);
		parcour.add(textFP);
		parcour.add(textPoste);
		parcour.add(textContrat);
		parcour.add(textEntreprise);
		parcour.add(anneeDP);
		parcour.add(anneeFP);
		parcour.add(poste);
		parcour.add(contrat);
		parcour.add(entreprise);
		parcour.add(previousParcour);
		parcour.add(nextParcour);
		parcour.add(ignoreParcour);
		
//		######################################Panel Inscription Master##################################
		master = new JPanel();
		master.setSize(900,600);
		master.setLayout(null);
		JPanel toppaneM = new JPanel();
		toppaneM.setLayout(null);
		JLabel texttopM = new JLabel("Inscription Master");
		textNiveau = new JLabel("Niveau Master");
		textEtablissM = new JLabel("Etablissement D'acceuil");
		finish = new JButton("Terminer");
		previousMaster = new JButton("Precedent");
		ignoreMaster = new JButton("Ignorer");
		niveauM = new JTextField();
		etablissM = new JTextField();
		
		toppaneM.setBackground(new Color(61, 135, 172));
		texttopM.setForeground(new Color(255, 255, 255));
		finish.setBackground(new Color(61, 135,172));
		finish.setForeground(new Color(255, 255, 255));
		previousMaster.setBackground(new Color(61, 135,172));
		previousMaster.setForeground(new Color(255, 255, 255));
		ignoreMaster.setBackground(new Color(242,242,242));
		ignoreMaster.setForeground(new Color(61, 135, 172));
		ignoreMaster.setBorder(null);
		
		texttopM.setFont(new Font("Tahoma" ,1, 24));
		textNiveau.setFont(new Font("Tahoma", 0, 14));
		textEtablissM.setFont(new Font("Tahoma", 0, 14));
		niveauM.setFont(new Font("Times New Roman", 1, 18));
		etablissM.setFont(new Font("Times New Roman", 1, 18));
		finish.setFont(new Font("Agency FB", 1, 24));
		previousMaster.setFont(new Font("Agency FB", 1, 24));
		ignoreMaster.setFont(new Font("Agency FB", 1, 20));
		
		toppaneM.setBounds(0,0,900,60);
		texttopM.setBounds(350,5,300,50);
		textNiveau.setBounds(50,120,120,30);
		textEtablissM.setBounds(550,120,150,30);
		niveauM.setBounds(50,152,250,30);
		etablissM.setBounds(550,152,250,30);
		finish.setBounds(650,450,150,50);
		previousMaster.setBounds(50,450,120,50);
		ignoreMaster.setBounds(800,70,100,30);
		
		toppaneM.add(texttopM);
		master.add(toppaneM);
		master.add(textNiveau);
		master.add(textEtablissM);
		master.add(niveauM);
		master.add(etablissM);
		master.add(finish);
		master.add(previousMaster);
		master.add(ignoreMaster);
		
		
		pane.add(pane1);
		pane.add(pane2);
		
//		***********************************************************Base de Donnee*******************************************************
		nextInfos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == nextInfos.getText()) {
					int i = Integer.parseInt(codeP.getText());
					int j = Integer.parseInt(tel.getText());
					try {
						ConnecBase con = new ConnecBase();
						//Ajouter d'element dans la table "liste_etudiant"
						state = con.con.prepareStatement("insert into infosetudiant (id,prenom,nom,domicil,tel,email,pwd) values(?,?,?,?,?,?,?)");
						state.setInt(1, i);
						state.setString(2, prenom.getText());
						state.setString(3, nom.getText());
						state.setString(4, domicil.getText());
						state.setInt(5, j);
						state.setString(6, email.getText());
						state.setString(7, mdp.getText());
						state.executeUpdate();
						JOptionPane.showMessageDialog(null, "Etudiant ajouter");
						state.close();
						cursus.setVisible(true);
						InfosEtu.setVisible(false);
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Echec de l'ajout"+ex);
					}	
				}
			}
		});
		
        nextCursus.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == nextCursus.getText()) {
					int i = Integer.parseInt(codeP.getText());
					try {
						ConnecBase con = new ConnecBase();
						//Ajouter d'element dans la table "liste_etudiant"
						state = con.con.prepareStatement("insert into cursusuniver (anneeD,anneeF,diplome,etabliss,etudiantID) values(?,?,?,?,?)");
						state.setString(1, anneeD.getText());
						state.setString(2, anneeF.getText());
						state.setString(3, nomDi.getText());
						state.setString(4, etabliss.getText());
						state.setInt(5, i);
						state.executeUpdate();
						JOptionPane.showMessageDialog(null, "cursus ajouter");
						state.close();
						parcour.setVisible(true);
						cursus.setVisible(false);
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Echec de cursus"+ex);
					}	
				}
			}
		});
		
        previousCursus.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == previousCursus.getText()) {
					InfosEtu.setVisible(true);
					cursus.setVisible(false);
					int i1 = Integer.parseInt(codeP.getText());
					try {
						ConnecBase con = new ConnecBase();
						state = con.con.prepareStatement("DELETE FROM infosetudiant WHERE id = ?");
						state.setInt(1,i1);
						int ligne = state.executeUpdate();
						if(ligne>0) {
						}
						
					}catch(Exception ex) {
						
					}
				}	
					
			}
		});
        
        nextParcour.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == nextParcour.getText()) {
					int i = Integer.parseInt(codeP.getText());
					try {
						ConnecBase con = new ConnecBase();
						//Ajouter d'element dans la table "liste_etudiant"
						state = con.con.prepareStatement("insert into parcourpro (anneeD,anneeF,poste,contrat,entreprise,etudiantID) values(?,?,?,?,?,?)");
						state.setString(1, anneeDP.getText());
						state.setString(2, anneeFP.getText());
						state.setString(3, poste.getText());
						state.setString(4, contrat.getText());
						state.setString(5, entreprise.getText());
						state.setInt(6, i);
						state.executeUpdate();
						JOptionPane.showMessageDialog(null, "parcour ajouter");
						state.close();
						master.setVisible(true);
						parcour.setVisible(false);
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Echec de parcour"+ex);
					}	
				}
				
				
			}
		});
		
		ignoreParcour.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == ignoreParcour.getText()) {
					master.setVisible(true);
					parcour.setVisible(false);
				}
				
			}
		});
		
		previousParcour.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == previousParcour.getText()) {
					cursus.setVisible(true);
					parcour.setVisible(false);
					int i1 = Integer.parseInt(codeP.getText());
					try {
						ConnecBase con = new ConnecBase();
						state = con.con.prepareStatement("DELETE FROM cursusuniver WHERE etudiantID = ?");
						state.setInt(1,i1);
						int ligne = state.executeUpdate();
						if(ligne>0) {
						}
						
					}catch(Exception ex) {
						
					}
				}
				
			}
		});
		
		finish.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == finish.getText()) {
					int i = Integer.parseInt(codeP.getText());
					try {
						ConnecBase con = new ConnecBase();
						//Ajouter d'element dans la table "liste_etudiant"
						state = con.con.prepareStatement("insert into master (niveauM,etabliss,etudiantID) values(?,?,?)");
						state.setString(1, niveauM.getText());
						state.setString(2, etablissM.getText());
						state.setInt(3, i);
						state.executeUpdate();
						JOptionPane.showMessageDialog(null, "master ajouter");
						
						PreparedStatement state1 = con.con.prepareStatement("insert into authentification (users,pwd) values(?,?)");
						state1.setString(1, email.getText());
						state1.setString(2, mdp.getText());
						state1.executeUpdate();
						state1.close();
						
						state.close();
						pane.setVisible(true);
						master.setVisible(false);
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Echec de master"+ex);
					}	
				}
				
			}
		});
		
		ignoreMaster.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == ignoreMaster.getText()) {
					try {
						ConnecBase con = new ConnecBase();
						PreparedStatement state1 = con.con.prepareStatement("insert into authentification (users,pwd) values(?,?)");
						state1.setString(1, email.getText());
						state1.setString(2, mdp.getText());
						state1.executeUpdate();
						state1.close();

						pane.setVisible(true);
						master.setVisible(false);
					}catch (Exception ex) {
						// TODO: handle exception
					}
				}
				
			}
		});
		
		previousMaster.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == previousMaster.getText()) {
					parcour.setVisible(true);
					master.setVisible(false);
					int i1 = Integer.parseInt(codeP.getText());
					try {
						ConnecBase con = new ConnecBase();
						state = con.con.prepareStatement("DELETE FROM parcourpro WHERE etudiantID = ?");
						state.setInt(1,i1);
						int ligne = state.executeUpdate();
						if(ligne>0) {
						}
						
					}catch(Exception ex) {
						
					}
				}
				
			}
		});
		
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = user.getText();
				String motdepasse = pwd.getText();
				String statu = status.getText();
				String type = "etudiant";
				String type1 = "personnel";
				String type2 = "admin";
				try {
					ConnecBase con = new ConnecBase();
					String query = "select pwd, status from authentification where users = ?";
					state = con.con.prepareStatement(query);
					state.setString(1, name);
					ResultSet result = state.executeQuery();
					if(result.next()) {
						String motdepasseDB = result.getString("pwd");
						String statusDB = result.getString("status");
						if(motdepasse.equals(motdepasseDB) && statu.equals(statusDB)) {
							getData.username=name;
							JOptionPane.showMessageDialog(null, "authentification reussi");

							if(statu.equals(type)) {
								dispose();
								Etudiant test = new Etudiant();
							}
							else if(statu.equals(type1)) {
								dispose();
								Personnel test1 = new Personnel();
							}
							else if(statu.equals(type2)) {
								dispose();
								Admin test2 = new Admin();
							}
							
						}
						else {
							JOptionPane.showMessageDialog(null, "Mot de passe ou Status incorrect");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Le nom d'utilisateur n'existe pas");
					}
				}catch (Exception ex) {
					// TODO: handle exception
				}
				
			}
		});
		
		pane.setVisible(true);
		InfosEtu.setVisible(false);
		cursus.setVisible(false);
		parcour.setVisible(false);
		master.setVisible(false);
		
		this.getContentPane().add(master);
		this.getContentPane().add(parcour);
		this.getContentPane().add(cursus);
		this.getContentPane().add(InfosEtu);
		this.getContentPane().add(pane);
		setVisible(true);
	}
	
	public static void main(String[] arg) {
		MainPromo main = new MainPromo();
	}

}
