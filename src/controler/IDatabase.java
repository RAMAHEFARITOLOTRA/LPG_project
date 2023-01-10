/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import classe.Classe;
import classe.Materiel;
import java.util.ArrayList;


public interface IDatabase {
   
//  *********************** methode enregistrer dans stock
    public void EnregistrerPersonnel(String nom, String code, String fonction);
    public void EnregistrerMateriel(String nom, String date, String Squantite, String emplacement, String type, String pers );
    public void Enregistrerutiliser(String nom, String date, String Squantite, String commentaire, String pers);
        public void Effacer1 (int nombre, String nom, String date);
    public void Enregistrercorbeille(String nom, String date, String Squantite, String pers);   
    public void Enregisterreutilisable(String nom, String date, String Squantite, String tat, String emplacement, String type, String pers);    
        public void Effacer2 (int nombre, String nom, String date);    
 
//  *********************** methode affichage des donnees dans stock          
    public ArrayList<Materiel>TestQuestion1();    
    public ArrayList<Materiel>TestQuestion2();    
    public ArrayList<Materiel>Choix();    
    public ArrayList<Materiel>ChoixAnnee();    
    public ArrayList<Materiel>ChoixRetirer();    
    public ArrayList<Materiel>ChoixPers();    
    public ArrayList<Materiel>AfficherPersonnel();
    public ArrayList<Materiel>AfficherBilan(String type, int anne);
    public ArrayList<Materiel>AfficherBilanAdmin();
    public ArrayList<Materiel> AfficherPersonneTestNom(String nomtable, String nom, String code);
    public Boolean AfficherPersonneTest(String nomtable, String nom, String code);
    public ArrayList<Materiel>AfficherMateriel();
    public ArrayList<Materiel>AfficherUtiliser();
    public ArrayList<Materiel>AfficherCorbeille();
    public ArrayList<Materiel>AfficherMaterielGroupe();
    public ArrayList<Materiel>AfficherUtiliserGroupe();
    public ArrayList<Materiel>AfficherCorbeilleGroupe();
    public ArrayList<Materiel>AfficherRechercheMateriel(String nomcolumn, String mot);
    public ArrayList<Materiel>AfficherRechercheUtiliser(String nomcolumn, String mot);
    public ArrayList<Materiel>AfficherRechercheCorbeille(String nomcolumn, String mot);
    
//  ************************ methode insertion dans admin stock
    public void ModifierPersonnel(String nom, String code, String fonction, String id_personnel);
    public void ModifierMateriel(String nom, String date, String Squantite, String emplacement, String type, String pers, String id_mat); 
    public void ModifierUtiliser(String nom, String date,  String Squantite, String commentaire, String pers, String id_mat); 
    public void ModifierCorbeille(String nom, String date, String Squantite, String pers,String id_mat); 
    public void ModifierBilanAdmin(String nom, String annee, String Squantite, String type, String id);
    public void SuppMateriel(String id);
    public void SupprimerPersonnel(String id_personnel);
    public void SupprimerMateriel(String id_mat);
    public void SupprimerUtiliser(String id_mat);
    public void SupprimerStock(String id_mat);
    public void SupprimerbilanAdmin(String id_bilan);
    public void Supprimer_Tous_bilanAdmin(String annee);
    
//  ************************ methode enregistrer total entrer et utilliser
    public void EnregistrerTotalEntrer(String nom, String annee, String Squantite);
    public void EnregistrerTotalUtiliser(String nom, String annee, String Squantite);
    
    
 // **************************  Toni Toni ****************************************
    public int compterJour(String jour);
    public  ArrayList<Classe> afficheJour(String jour);
    public void MoisJour();
    public int compterTL();
    public void afficheTL();
    public int compterMensuel(String semaine);
    

    /**
     *
     * @param semaine
     * @return
     */
    public ArrayList<Classe> afficheMensuel(String semaine);
    public ArrayList<Classe> afficheMensuelCond();
    public void afficheMensuel2(String semaine,String []semain);
    //*****************Page*************
     public int compterContact();
     public ArrayList<Classe> compter2(String table, String nomC, String condition, String id);

    /**
     *
     * @return
     */
     public ArrayList <Classe> afficheContact(String table);
     public ArrayList<Classe> affiche2(int n, String nom, String table, String id, String Nomcondion, String condition);
     public int compterHebdo(String val);
     public void  textHeb(String jourss);
     public ArrayList <Classe> afficheAllHebdo(String table);

    /**
     *
     * @param table
     * @param type
     * @return
     */
    public ArrayList <Classe> afficheAllTrim(String table,String type);
     

    /**
     *
     * @param jour
     * @return
     */
     public ArrayList<Classe> afficheHebdo(String jour);
     public int compterMensuel();
     public ArrayList<Classe> afficheMensuel();
     public int compterTri();
     public void afficheTri();
     public int compterTafHebdo();
     public void afficheTafHebdo();
     //******************pageT**********
       public int compterS1M1(String semaine,String mois,String type);
       public ArrayList<Classe> afficheS1M1(String semaine,String mois,String type);
        public ArrayList<Classe> afficheNotif(String mois);
        public int donnePv(String nom, String table, String nomCond, String condition);
        public void enregistreContact(String date,String heure,int sem,String obs,String periode,int idjour,int idtaf,int idhedo,int idmen,int idtri);
        public void AddActeur(int pv,int pers);
        public int AddMax(String table, String id);
        public void AddTravailJour(String titre);
        public void AddTravailHeb(String titre, String jour);
        public void AddTravailMen(String titre,String Sem);
        public void AddTravailTri(String titre, String sem, String mois, String type);
        public void AddTaf(String Valeur, int jour, int heb, int men, int tri);
        public ArrayList<Classe> afficheLivre(String Table,String nom, String id);
        //*******************supression****
        public void DeleteTaf(String nom);
        public boolean DeleteAll(String table,String nom,String nomCond);
         public boolean modifierjour(String table,String nomJour,String nomnomCond,String valeur);
         public int AddMaxAjout(String table, String NomJour, String condition);
         public boolean modifierHeb(String table,String nomJour,String nomH, String nomJ,String valeurNomH, String valeurJ);
         public ArrayList<Classe> afficheLivreRech(String Table,String nom, String id,String cond,String text);
         public ArrayList<Classe> afficheToutMen(String Table);
         public ArrayList<Classe> afficheToutTri(String type);
         public void AddNotes(String date,String periode,String equipement,String type,String commentaire);
          public ArrayList<Classe> afficheNotes();
          public ArrayList<Classe> affichePers();
         
    
    
}
