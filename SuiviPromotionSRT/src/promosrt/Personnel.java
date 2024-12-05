package promosrt;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Personnel extends JFrame implements ActionListener{
	private JPanel pane,paneH,paneM,paneB,paneGD,paneVerification,paneExploit;
	private JButton gb,verifie,exploit,deconnect,recherche,clear,ok,recherche1;
	private JTextField rechercher,plus,rechercher1;
	private JLabel rechercheEt,textplus,resultatR,resultatR1,error,anneeDC,anneeFC,nomD,etablissC,emploie,masters,parcours,statG;
	private JScrollPane etude,parcourpro,master;
	private JTextArea infosEtudiant,cursus,parcour,inscriMaster;
	
	
	PreparedStatement state,state1,state2,state3,state4;
	ResultSet result,result1,result2,result3,result4;
	public Personnel() {
		setTitle("Personnel de l'UADB");
		setSize(1250,800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pane = new JPanel();
		
		pane.setLayout(null);
		pane.setSize(1250,800);
		paneB = new JPanel();
		paneB.setBounds(0,640,1250,135 );
		paneB.setBackground(Color.gray);
	
//		###############################################PANEl du Haut##################################################
		paneH = new JPanel();
		paneH.setLayout(null);
		paneH.setBounds(0,0,1250,60);
		paneH.setBackground(new Color(61, 135, 172));
		
		gb = new JButton("Gestion Diplomes");
		verifie = new JButton("Verification Diplome");
		exploit = new JButton("Exploitation des Donnees");
		deconnect = new JButton("Deconnection");
		
		
		gb.setBackground(new Color(61, 135, 172));
		verifie.setBackground(new Color(61, 135, 172));
		exploit.setBackground(new Color(61, 135, 172));
		deconnect.setBackground(new Color(61, 135, 172));
		gb.setForeground(new Color(255, 255, 255));
		verifie.setForeground(new Color(255, 255, 255));
		exploit.setForeground(new Color(255, 255, 255));
		deconnect.setForeground(new Color(255, 255, 255));
		deconnect.setBorder(null);
		
		gb.setFont(new Font("Times New Roman", 1, 18));
		verifie.setFont(new Font("Times New Roman", 1, 18));
		exploit.setFont(new Font("Times New Roman", 1, 18));
		deconnect.setFont(new Font("Times New Roman", 1, 18));
		
		gb.setBounds(0,0,180,60);
		verifie.setBounds(180,0,200,60);
		exploit.setBounds(380,0,240,60);
		deconnect.setBounds(1105,0,140,60);
		
		gb.addActionListener(this);
		verifie.addActionListener(this);
		exploit.addActionListener(this);
		deconnect.addActionListener(this);
		
		paneH.add(gb);
		paneH.add(verifie);
		paneH.add(exploit);
		paneH.add(deconnect);
		
//		#########################################################PANEl du Milieu########################################################################
		paneM = new JPanel();
		paneM.setLayout(null);
		paneM.setBounds(0,60,1250,600);
		
//		#########################################################PANEl Gestion des diplomes#################################################
		paneGD = new JPanel();
		paneGD.setLayout(null);
    	paneGD.setBounds(0,0,1250,600);

    	gestionDiplome();
		
	    rechercher = new JTextField();
	    plus = new JTextField();
	    recherche = new JButton("Recherche");
	    clear = new JButton("Effacer");
	    ok = new JButton("OK");
	    textplus = new JLabel("Pour afficher plus d'information sur un etudiant; veillez saisir son code permanent !");
	    rechercheEt = new JLabel("Veillez saisir un prenom");
	    
	    infosEtudiant = new JTextArea();
	    cursus = new JTextArea();
	    parcour = new JTextArea();
	    inscriMaster = new JTextArea();
	    etude = new JScrollPane(cursus);
	    parcourpro = new JScrollPane(parcour);
	    master = new JScrollPane(inscriMaster);

	    rechercher.setFont(new Font("Times New Roman", 1, 18));
	    plus.setFont(new Font("Times New Roman", 1, 18));
		recherche.setFont(new Font("Agency FB", 1, 18));
		clear.setFont(new Font("Agency FB", 1, 18));
		ok.setFont(new Font("Agency FB", 1, 18));
		
		recherche.setBackground(new Color(61, 135,172));
		recherche.setForeground(new Color(255, 255, 255));
		clear.setBackground(new Color(61, 135,172));
		clear.setForeground(new Color(255, 255, 255));
		ok.setBackground(new Color(3,67,104));
		ok.setForeground(new Color(255, 255, 255));
		
		rechercher.setBounds(30,30,250,30);
		recherche.setBounds(290,30,100,30);
		clear.setBounds(1120,560,100,30);
		ok.setBounds(430,530,70,30);
		
	    textplus.setForeground(Color.BLACK);
	    textplus.setFont(new Font("Tahoma", 2,16));
	    rechercheEt.setForeground(Color.BLACK);
	    rechercheEt.setFont(new Font("Tahoma", 2,14));
	    
	    textplus.setBounds(30,490,650,20);
	    rechercheEt.setBounds(30,5,400,20);
	    plus.setBounds(180,530,240,30);
	    
	    ok.addActionListener(this);
	    clear.addActionListener(this);
	    recherche.addActionListener(this);
 
	    paneGD.add(textplus);
	    paneGD.add(rechercheEt);
	    paneGD.add(plus);
	    paneGD.add(ok);
	    paneGD.add(rechercher);
	    paneGD.add(recherche);
	    paneGD.add(clear);
	    paneGD.add(infosEtudiant);
	    paneGD.add(etude);
	    paneGD.add(master);
	    paneGD.add(parcourpro);
		paneM.add(paneGD);
		
//		#########################################################PANEl Vreification#################################################
		paneVerification = new JPanel();
		paneVerification.setLayout(null);
    	paneVerification.setBounds(0,0,1250,600);

		JLabel label = new JLabel("Veillez saisir le code permanent de l'etudiant");
	    rechercher1 = new JTextField();
	    recherche1 = new JButton("Recherche");
	    anneeDC = new JLabel();
		anneeFC = new JLabel();
		nomD = new JLabel();
		etablissC = new JLabel();
		
		anneeDC.setForeground(Color.BLACK);
		anneeFC.setForeground(Color.BLACK);
		nomD.setForeground(Color.BLACK);
		etablissC.setForeground(Color.BLACK);
		label.setForeground(Color.BLACK);

	    label.setFont(new Font("Tahoma", 2,14));
		anneeDC.setFont(new Font("Tahoma", 0,16));
		anneeFC.setFont(new Font("Tahoma", 0,16));
		nomD.setFont(new Font("Tahoma", 0,16));
		etablissC.setFont(new Font("Tahoma", 0,16));
	    
	    recherche1.setBackground(new Color(61, 135,172));
	    recherche1.setForeground(new Color(255, 255, 255));
		
	    rechercher1.setFont(new Font("Times New Roman", 1, 18));
	    recherche1.setFont(new Font("Agency FB", 1, 18));
	    
	    rechercher1.setBounds(30,30,250,30);
	    recherche1.setBounds(290,30,100,30);
	    label.setBounds(30,5,400,20);
	   
	    anneeDC.setBounds(30,100,250,20);
	    anneeFC.setBounds(30,140,250,20);
	    nomD.setBounds(30,180,300,20);
	    etablissC.setBounds(30,220,250,20);
	    
        recherche1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resultatR.setVisible(true);
				ConnecBase con = new ConnecBase();
				String query1 = "SELECT * FROM cursusuniver  WHERE etudiantID = ?";
				ResultSet resultSet,result;
		        try {
		        	
		        	state1 = con.con.prepareStatement(query1);
		        	state1.setString(1, rechercher1.getText());
		            resultSet = state1.executeQuery();
		            if (resultSet.next()) {
		            	String anneeD = resultSet.getString("anneeD");
		            	String anneeF = resultSet.getString("anneeF");
		            	String diplome = resultSet.getString("diplome");
		            	String etabliss = resultSet.getString("etabliss");
		            	
		            	anneeDC.setText("Annee de debut : "+anneeD);
		            	anneeFC.setText("Annee de fin : "+anneeF);
		            	nomD.setText("Nom du diplome : "+diplome);
		            	etablissC.setText("Universite d'acceuil : "+etabliss);
		            	
		            	anneeDC.setVisible(true);
		            	anneeFC.setVisible(true);
		            	nomD.setVisible(true);
		            	etablissC.setVisible(true);
		            	
		            	resultatR.setText("Cet etudiant a bien eu son diplome");
		            }
		            else {
		            	anneeDC.setVisible(false);
		            	anneeFC.setVisible(false);
		            	nomD.setVisible(false);
		            	etablissC.setVisible(false);
		            	resultatR.setText("Cet etudiant n'a pas eu son diplome ou bien vous avec mal ecrit son code permanent");
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
				
			}
		});	 
		
	    paneVerification.add(anneeDC);
	    paneVerification.add(anneeFC);
	    paneVerification.add(nomD);
	    paneVerification.add(etablissC);
	    paneVerification.add(rechercher1);
	    paneVerification.add(recherche1);
	    paneVerification.add(label);
		paneM.add(paneVerification);
		
//		#########################################################PANEl Exploitation#################################################
		paneExploit = new JPanel();
		paneExploit.setLayout(null);
		paneExploit.setBounds(0,0,1250,600);

		emploie = new JLabel("Statistique sur l'emploie des nouveau diplomes");
		masters = new JLabel("Statistique sur les inscriptions en master");
		parcours = new JLabel("Analyse sur le parcour professionnel des anciens etudiants");
		statG = new JLabel("Statistique General");
		
		emploie.setBounds(20,30,390,30);
		masters.setBounds(680,30,330,30);
		parcours.setBounds(20,400,475,30);
		statG.setBounds(680,255,200,30);
				
		emploie.setFont(new Font("Tahoma", 1, 16));
		masters.setFont(new Font("Tahoma", 1, 16));
		parcours.setFont(new Font("Tahoma", 1, 16));
		statG.setFont(new Font("Tahoma", 1, 16));
		
		emploie.setForeground(new Color(61, 135, 172));
		masters.setForeground(new Color(61, 135, 172));
		parcours.setForeground(new Color(61, 135, 172));
		statG.setForeground(new Color(61, 135, 172));
		
		nombreEt();
		obtentionEm();
		inscriptionmaster();
		parcourpro();
		
		
		paneExploit.add(emploie);
		paneExploit.add(masters);
		paneExploit.add(parcours);
		paneExploit.add(statG);
		paneM.add(paneExploit);
		
//		###############################################PANEl du Bas###############################################################
		paneB = new JPanel();
		paneB.setBounds(0,640,1250,135 );
		paneB.setBackground(Color.gray);
		paneB.setLayout(null);
		
		resultatR = new JLabel();
		resultatR1 = new JLabel();
		error = new JLabel();
		
		resultatR.setForeground(Color.WHITE);
		resultatR.setFont(new Font("Times New Roman", 1,16));
		resultatR.setBounds(50,50,1000,50);
		error.setForeground(Color.WHITE);
		error.setFont(new Font("Times New Roman", 1,16));
		error.setBounds(50,50,1000,50);
		resultatR1.setForeground(Color.WHITE);
		resultatR1.setFont(new Font("Times New Roman", 1,16));
		resultatR1.setBounds(50,50,1000,50);
		paneB.add(resultatR);
		paneB.add(resultatR1);
		paneB.add(error);
		
		paneGD.setVisible(true);
		paneVerification.setVisible(false);
		paneExploit.setVisible(false);
		
		pane.add(paneH);
		pane.add(paneM);
		pane.add(paneB);
		this.getContentPane().add(pane);
		setVisible(true);
	}
	
	public void gestionDiplome() {
		JScrollPane test;
		JTable table;
		ArrayList<String[]>  donnee = new ArrayList<>();
		DefaultTableModel model;
       
		
		try {
			ConnecBase con = new ConnecBase();
			Statement recup = con.con.createStatement();
			ResultSet result = recup.executeQuery("select * from infosetudiant");
			while(result.next()) {
				donnee.add(new String[] {result.getString("id"),result.getString("prenom"),result.getString("nom"),result.getString("domicil"),result.getString("tel"),result.getString("email")});
			}
		}catch(Exception e) {
			
		}
		int numRows = donnee.size();
		int numCols = 6;
		Object[][] tableauD = new Object[numRows][numCols];
		
		for(int i = 0; i<numRows;i++) {
			tableauD[i] = donnee.get(i);
		}
		
		String[] title = {"Code Permanent","Prenom","Nom","Domicil","Telephone","Email"};
		model = new DefaultTableModel(tableauD,title);
	    table = new JTable(model);
		test = new JScrollPane(table);
		JTableHeader header = table.getTableHeader();
		
		header.setFont(new Font("Tahoma", 1, 13));
		table.setFont(new Font("Times New Roman", 0, 14));
		header.setBackground(new Color(61, 135, 172));
		header.setForeground(Color.WHITE);
	    test.setBounds(15,70,700,400);
	   
	    
	    paneGD.add(test);

	}
	
	public void nombreEt() {
		JLabel textinfos1 = new JLabel();
		JLabel textinfos = new JLabel();
		JLabel textinfos2 = new JLabel();
		JLabel textinfos3 = new JLabel();
		JLabel textinfos4 = new JLabel();
		try {
			ConnecBase con = new ConnecBase();
			state = con.con.prepareStatement("SELECT COUNT(DISTINCT id)  FROM infosetudiant");
			result = state.executeQuery();
			
			state1 = con.con.prepareStatement("SELECT COUNT(DISTINCT etudiantID)  FROM master");
			result1 = state1.executeQuery();
			
			state2 = con.con.prepareStatement("SELECT COUNT(DISTINCT etudiantID)  FROM parcourpro where poste = 'Technicien réseau'");
			result2 = state2.executeQuery();
			
			state3 = con.con.prepareStatement("SELECT (COUNT(DISTINCT id)-(SELECT COUNT(DISTINCT etudiantID) FROM cursusuniver where diplome = 'Technicien réseau')) \r\n"
					+ "AS pasDiplome \r\n"
					+ "FROM infosetudiant");
			result3 = state3.executeQuery();
			
			state4 = con.con.prepareStatement("SELECT (COUNT(DISTINCT etudiantID)-((SELECT COUNT(DISTINCT etudiantID) FROM parcourpro where poste = 'Technicien réseau')\r\n"
					+ "+(SELECT COUNT(DISTINCT etudiantID) FROM master)))\r\n"
					+ "AS chomeur \r\n"
					+ "FROM cursusuniver");
			result4 = state4.executeQuery();
			
			while(result.next()&& result1.next() && result2.next()&& result3.next() && result4.next()) {
				String totalEt = result.getString("COUNT(DISTINCT id)");
				textinfos.setText("Le nombre total d'étudiant est de : "+totalEt);
				
				String totalMaster = result1.getString("COUNT(DISTINCT etudiantID)");
				textinfos1.setText("Le nombre total d'étudiant inscrit en master est de : "+totalMaster);
				
				String totalEm = result2.getString("COUNT(DISTINCT etudiantID)");
				textinfos2.setText("Les diplomés qui ont eu un emploie sont de : "+totalEm);
				
				String pasDi = result3.getString("pasDiplome");
				textinfos3.setText("Le nombre d'étudiant qui n'ont pas de diplome : "+pasDi);
				
				String chomeur = result4.getString("chomeur");
				textinfos4.setText("Le nombre total d'étudiant chomeur est de : "+chomeur);
				
				paneExploit.add(textinfos);
				paneExploit.add(textinfos1);
				paneExploit.add(textinfos2);
				paneExploit.add(textinfos3);
				paneExploit.add(textinfos4);
			}
			con.con.close();
			
		}catch(Exception e) {
			
		}
		
		textinfos.setBounds(700,290,300,30);
		textinfos1.setBounds(700,325,400,30);
		textinfos2.setBounds(700,360,400,30);
		textinfos3.setBounds(700,395,400,30);
		textinfos4.setBounds(700,430,400,30);
		
		textinfos.setFont(new Font("Times New Roman", 1, 16));
		textinfos1.setFont(new Font("Times New Roman", 1, 16));
		textinfos2.setFont(new Font("Times New Roman", 1, 16));
		textinfos3.setFont(new Font("Times New Roman", 1, 16));
		textinfos4.setFont(new Font("Times New Roman", 1, 16));		

		
	}
	
	public void obtentionEm() {
		JLabel textContrat = new JLabel();
		JLabel textEmploi= new JLabel();
		JLabel textEntreprise = new JLabel();
		ArrayList<String[]> donnees = new ArrayList<String[]>();
		ArrayList<String[]> donnees1 = new ArrayList<String[]>();
		JTable table;
		DefaultTableModel model;
		JScrollPane test = new JScrollPane();
		
		try {
			ConnecBase con = new ConnecBase();
			state = con.con.prepareStatement("SELECT (COUNT(DISTINCT etudiantid)/(SELECT COUNT(DISTINCT id) FROM infosetudiant)*100) "
					+ "AS tauxEmploie FROM parcourpro "
					+ "where poste = 'Technicien réseau'");
			result = state.executeQuery();
			
			state1 = con.con.prepareStatement("SELECT contrat, COUNT(*) AS nombreC\r\n"
					+ "FROM parcourpro\r\n"
					+ "where poste = 'Technicien réseau'\r\n"
					+ "GROUP BY contrat\r\n"
					+ "ORDER BY nombreC DESC");
			result1 = state1.executeQuery();
			
			state2 = con.con.prepareStatement("SELECT entreprise, COUNT(*) AS nbrDi\r\n"
					+ "FROM parcourpro\r\n"
					+ "WHERE poste = 'Technicien réseau'\r\n"
					+ "GROUP BY entreprise\r\n"
					+ "ORDER BY nbrDi DESC");
			result2 = state2.executeQuery();
			
			while(result.next()) {
				String tauxEm = result.getString("tauxEmploie");		
				textEmploi.setText("Taux d'etudiant ayant obtenue un emploi apres la licence est de "+tauxEm+"%");
				paneExploit.add(textEmploi);
			}
			
			while(result1.next()) {
				textContrat.setText("les types de contrat obtenus par ces etudiants");
				donnees.add(new String[] {result1.getString("contrat"), result1.getString("nombreC")});
				paneExploit.add(textContrat);

			}
			
			while(result2.next()) {
				textEntreprise.setText("La repartition des diplomes dans les differents entreprise");
				donnees1.add(new String[] {result2.getString("entreprise"), result2.getString("nbrDi")});
				paneExploit.add(textEntreprise);

			}
			con.con.close();
			
		}catch(Exception e) {
			
		}
		int numRows = donnees.size();
		int numCols = 2;
		Object[][] tableauD = new Object[numRows][numCols];		
		for(int i = 0; i<numRows;i++) {
			tableauD[i] = donnees.get(i);
		}
		String[] title = {"Type de contrat","Nombre d'etudiant"};
		model = new DefaultTableModel(tableauD,title);
	    table = new JTable(model);
	    JTableHeader header = table.getTableHeader();
	    test = new JScrollPane(table);

	    paneExploit.add(test);
	    
		int numRows1 = donnees1.size();
		Object[][] tableauD1 = new Object[numRows1][numCols];
	    for(int i = 0; i<numRows1;i++) {
			tableauD1[i] = donnees1.get(i);
		}   
	    String[] title1 = {"Entreprise","Nbre Etudiant"};
		DefaultTableModel model1 = new DefaultTableModel(tableauD1,title1);
	    JTable table1 = new JTable(model1);
	    JScrollPane test1 = new JScrollPane(table1);
	    JTableHeader header1 = table1.getTableHeader();
	    paneExploit.add(test1);
	    
	    textEmploi.setBounds(25,70,500,30);
		textContrat.setBounds(25,110,350,30);
		test.setBounds(50,145,250,90);
		textEntreprise.setBounds(25,250,400,30);
		test1.setBounds(50,285,250,90);
		
		
		textEmploi.setFont(new Font("Times New Roman", 1, 16));
		textContrat.setFont(new Font("Times New Roman", 1, 16));
		table.setFont(new Font("Times New Roman", 1, 14));
		header.setFont(new Font("Times New Roman", 1, 14));
		textEntreprise.setFont(new Font("Times New Roman", 1, 16));
		table1.setFont(new Font("Times New Roman", 1, 14));
		header1.setFont(new Font("Times New Roman", 1, 14));
		
		header.setBackground(new Color(61, 135, 172));	
		header.setForeground(Color.WHITE);
		
		header1.setBackground(new Color(61, 135, 172));
		header1.setForeground(Color.WHITE);
	}
	
	public void inscriptionmaster() {
		JLabel textMaster = new JLabel();
		JLabel textInscritM = new JLabel();
		ArrayList<String[]> donnee = new ArrayList<String[]>();
		try {
			ConnecBase con = new ConnecBase();
			state = con.con.prepareStatement("SELECT (COUNT(DISTINCT etudiantID)/(SELECT COUNT(DISTINCT id) FROM infosetudiant)*100)"
					+ "AS taux FROM master");
			result = state.executeQuery();
			
			state1 = con.con.prepareStatement("SELECT etabliss, COUNT(*) AS nbrInscrit\r\n"
					+ "FROM master\r\n"
					+ "GROUP BY etabliss\r\n"
					+ "ORDER BY nbrInscrit DESC");
			result1 = state1.executeQuery();
			
			while(result.next()) {
				String taux = result.getString("taux");
				textMaster.setText("Le pourcentage des etudiant ayant ete inscrit en master sont de "+taux+"%");
				paneExploit.add(textMaster);
			}
			
			while(result1.next()) {
				textInscritM.setText("Liste des etudiants inscrits en master dans les differentes universite du senegal");
				donnee.add(new String[] {result1.getString("etabliss"), result1.getString("nbrInscrit")});
				//model.addRow(donnees);
				paneExploit.add(textInscritM);

			}
			con.con.close();
		}catch(Exception e) {
			
		}
		
		int numRows = donnee.size();
		int numCols = 2;
		Object[][] tableauD = new Object[numRows][numCols];		
		for(int i = 0; i<numRows;i++) {
			tableauD[i] = donnee.get(i);
		}
		String[] title = {"Universite","Nombre D'inscription"};
		DefaultTableModel model = new DefaultTableModel(tableauD,title);
	    JTable table = new JTable(model);
	    JScrollPane test = new JScrollPane();
		test = new JScrollPane(table);
	    JTableHeader header = table.getTableHeader();
	    paneExploit.add(test);
	    
	    textMaster.setBounds(690,70,500,30);
	    textInscritM.setBounds(690,110,530,30);
	    test.setBounds(800,145,300,90);
	    
	    textMaster.setFont(new Font("Times New Roman", 1, 16));
	    textInscritM.setFont(new Font("Times New Roman", 1, 16));
		table.setFont(new Font("Times New Roman", 1, 14));
	    header.setFont(new Font("Times New Roman", 1, 15));
	    
		header.setBackground(new Color(61, 135, 172));	
		
		header.setForeground(Color.WHITE);

	}
	
	public void parcourpro() {
		JLabel textParcour = new JLabel();
		ArrayList<String[]> donne = new ArrayList<String[]>();
		try {
			ConnecBase con = new ConnecBase();
			state = con.con.prepareStatement("SELECT poste, contrat, (COUNT(*)/(SELECT COUNT(DISTINCT etudiantID) FROM parcourpro)*100) AS tendanceC\r\n"
					+ "FROM parcourpro\r\n"
					+ "GROUP BY poste, contrat\r\n"
					+ "ORDER BY tendanceC DESC");
			result = state.executeQuery();
			
			while(result.next()) {
				textParcour.setText("Choix de cariere des diplomes concernant les postes occupees et les types de contrat");
				donne.add(new String[] {result.getString("poste"), result.getString("contrat"),result.getString("tendanceC")});
				paneExploit.add(textParcour);
			}
		}catch(Exception e) {
			
		}
		
		int numRows = donne.size();
		int numCols = 2;
		Object[][] tableauD = new Object[numRows][numCols];		
		for(int i = 0; i<numRows;i++) {
			tableauD[i] = donne.get(i);
		}
		String[] title = {"Poste Coccupe","Type de contrat","Tendance(%)"};
		DefaultTableModel model = new DefaultTableModel(tableauD,title);
	    JTable table = new JTable(model);
	    JScrollPane test = new JScrollPane();
		test = new JScrollPane(table);
	    JTableHeader header = table.getTableHeader();
	    paneExploit.add(test);

	    textParcour.setBounds(25,440,750,30);
	    test.setBounds(50,475,600,120);

	    textParcour.setFont(new Font("Times New Roman", 1, 16));
	    table.setFont(new Font("Times New Roman", 1, 14));
	    header.setFont(new Font("Times New Roman", 1, 15));
	    
		header.setBackground(new Color(61, 135, 172));	
		
		header.setForeground(Color.WHITE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == gb.getText()) {
			paneGD.setVisible(true);
			paneVerification.setVisible(false);
			paneExploit.setVisible(false);
			error.setVisible(false);
			resultatR.setVisible(false);
		}
		
		else if(e.getActionCommand() == verifie.getText()) {
			paneGD.setVisible(false);
			paneVerification.setVisible(true);
			paneExploit.setVisible(false);
			error.setVisible(false);
			resultatR.setVisible(false);
		}
		
		else if(e.getActionCommand() == exploit.getText()) {
			paneGD.setVisible(false);
			paneVerification.setVisible(false);
			paneExploit.setVisible(true);
			error.setVisible(false);
			resultatR.setVisible(false);
		}
		
		else if(e.getActionCommand() == deconnect.getText()) {
			MainPromo main = new MainPromo();
			dispose();
		}
		else if(e.getActionCommand() == ok.getText()) {
			 infosEtudiant.setEditable(false);
	         cursus.setEditable(false);
	         parcour.setEditable(false);
	         inscriMaster.setEditable(false);
				
			int i = Integer.parseInt(plus.getText());
				try {
					ConnecBase con = new ConnecBase();
					String query = "select id from infosetudiant where id = ?";
					state = con.con.prepareStatement(query);
					state.setInt(1, i);
					ResultSet result = state.executeQuery();
					if(result.next()) {
						int idC = result.getInt("id");
						if(i == idC) {
							try {
					        	state = con.con.prepareStatement("select * from infosetudiant where id=?");
								state.setInt(1,i);
								result = state.executeQuery();
					            StringBuilder data = new StringBuilder();
					            while (result.next()) {
					                int id = result.getInt("id");
					                String prenom = result.getString("prenom");
					                String nom = result.getString("nom");
					                String domicil = result.getString("domicil");
					                String tel = result.getString("tel");
					                String email = result.getString("email");

					                data.append("Code Permanent : ").append(id).append("\n").
					                append("Prenom : ").append(prenom).append("\n").
					                append("Nom : ").append(nom).append("\n").
					                append("Domicil : ").append(domicil).append("\n").
					                append("Telephone : ").append(tel).append("\n").
					                append("Email : ").append(email).append("\n");
					            }
					            infosEtudiant.setText(data.toString());
					            
					            state = con.con.prepareStatement("select * from cursusuniver where etudiantID=?");
								state.setInt(1,i);
								result = state.executeQuery();
					            StringBuilder data1 = new StringBuilder();
					            while (result.next()) {
					                String anneeD = result.getString("anneeD");
					                String anneeF = result.getString("anneeF");
					                String diplome = result.getString("diplome");
					                String etabliss = result.getString("etabliss");

					                data1.append("Annee de Debut : ").append(anneeD).append("\n").
					                append("Annee de Fin : ").append(anneeF).append("\n").
					                append("Nom du Diplome : ").append(diplome).append("\n").
					                append("Nom de l'universite : ").append(etabliss).append("\n");
					            }
					            
					            state = con.con.prepareStatement("select * from parcourpro where etudiantID=?");
								state.setInt(1,i);
								result = state.executeQuery();
					            StringBuilder data2 = new StringBuilder();
					            while (result.next()) {
					                String anneeD = result.getString("anneeD");
					                String anneeF = result.getString("anneeF");
					                String poste = result.getString("poste");
					                String contrat = result.getString("contrat");
					                String entreprise = result.getString("entreprise");

					                data2.append("Annee de Debut : ").append(anneeD).append("\n").
					                append("Annee de Fin : ").append(anneeF).append("\n").
					                append("Poste Occupee : ").append(poste).append("\n").
					                append("Type de contrat : ").append(contrat).append("\n").
					                append("Entreprise : ").append(entreprise).append("\n").
					                append("#################################").append("\n");
					            }
					        
					            state = con.con.prepareStatement("select * from master where etudiantID=?");
								state.setInt(1,i);
								result = state.executeQuery();
					            StringBuilder data3 = new StringBuilder();
					            while (result.next()) {
					                String niveauM = result.getString("niveauM");
					                String etabliss = result.getString("etabliss");

					                data3.append("Niveau Master : ").append(niveauM).append("\n").
					                append("Universite d'acceuil : ").append(etabliss).append("\n");
					            }
					            
					            cursus.setText(data1.toString());
			    	            parcour.setText(data2.toString());
					            inscriMaster.setText(data3.toString());
					            con.con.close();
					        } catch (Exception ex) {
					            ex.printStackTrace();
					        }
						     infosEtudiant.setFont(new Font("Times New Roman", 1,16));
							 infosEtudiant.setBounds(720,70,250,190);
							 cursus.setFont(new Font("Times New Roman", 1,16));
							 etude.setBounds(980,70,250,190);
							 parcour.setFont(new Font("Times New Roman", 1,16));
							 parcourpro.setBounds(720,275,250,190);
							 inscriMaster.setFont(new Font("Times New Roman", 1,16));
							 master.setBounds(980,275,250,190);
							 
							 infosEtudiant.setVisible(true);
							 etude.setVisible(true);
						   	 parcourpro.setVisible(true);
							 master.setVisible(true);
							
						}
						error.setVisible(false);
					}
					else {
						 infosEtudiant.setVisible(false);
						 etude.setVisible(false);
					   	 parcourpro.setVisible(false);
						 master.setVisible(false);
						error.setVisible(true);
						error.setText("Le code permanent saisi n'existe pas");
						resultatR.setVisible(false);
					}
				}catch (Exception e2) {
					error.setText("Veillez saisir un code permanent valide");
					}      
		}
		
		else if(e.getActionCommand() == clear.getText()) {
			infosEtudiant.setVisible(false);
			etude.setVisible(false);
			parcourpro.setVisible(false);
			master.setVisible(false);
		}
		
		else if(e.getActionCommand() == recherche.getText()) {
			error.setVisible(false);
			resultatR.setVisible(true);
			ConnecBase con = new ConnecBase();
			String query = "SELECT * FROM infosetudiant WHERE prenom = ?";
			ResultSet resultSet;
	        try {
	        	
	        	state = con.con.prepareStatement(query);
	        	state.setString(1, rechercher.getText());
	            resultSet = state.executeQuery();
	            if (resultSet.next()) {
	            	String id1 = resultSet.getString("id");
	            	String prenom1 = resultSet.getString("prenom");
	            	String nom1 = resultSet.getString("nom");
	            	String domicil1 = resultSet.getString("domicil");
	            	String tel1 = resultSet.getString("tel");
	            	String email1 = resultSet.getString("email");
	            	
	            	resultatR.setText("Code Permanent : "+id1+" | Prenom : "+prenom1+" | Nom : "+nom1+" | Domicil : "+domicil1+" | Telephone : "+tel1+" | Email : "+email1);
	            }
	            else {
	            	resultatR.setText("Le prenom saisi n'existe pas dans la base de donnee");
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        
		}
		
	}
	
	public static void main(String[] args) {
		Personnel test = new Personnel();
	}

}
