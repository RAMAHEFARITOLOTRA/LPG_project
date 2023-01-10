/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;
import java.io.Serializable;
/**
 *
 * @author Snow
 */
public class Materiel implements Serializable
{
    private int id_personnel;
    private String code;
    private String fonction;
    private String Squantite;
    private String mat_id;
    private int id_mat;
    private String nom;
    private int quantite2;
    private String date;
    private Object quantite;
    private String etat;
    private String emplacement;
    private String type;
    private String commentaire;
    private String id_pers;
    private int nombre;
    
    public Materiel(){}         // 
    
     /*public Materiel (String Squantite, String nom, String date){          // *********** modification utliser materiel
        super();                                                    //             et materiel retirer
        this.Squantite= Squantite;
        this.nom= nom;
        this.date= date;
    }
     */
     public Materiel (String nom, String date, String Squantite){          // *********** affichage bilan
        super();                                                    //   
        this.Squantite= Squantite;
        this.nom= nom;
        this.date= date;
    }
     
     public Materiel (int nombre, String nom, String date){          // *********** affichage bilan
        super();                                                    //   
        this.nombre= nombre;
        this.nom= nom;
        this.date= date;
    }
     
     
 /* public Materiel (String nom, String annee, Object quantite){
      super();
    this.nom = nom;
    this.date = annee;
    this.quantite = quantite;
  }
  */
/*  public Materiel (String nom, String code, String fonction){     //  ********** enregistrer personnel
    super();
    this.nom = nom;
    this.code = code;
    this.fonction = fonction;
   }
  */
  public Materiel (int id, String nom, String code, String fonction){     //  ********** afficher personnel
    super();
    this.id_personnel= id;
    this.nom = nom;
    this.code = code;
    this.fonction = fonction;
   }
   
  
   public Materiel (String nom, String date, String Squantite, String pers){     //  ********** mis corbeille
    super();
    this.nom = nom;
    this.date = date;
    this.Squantite = Squantite;
    this.id_pers= pers;
   }
   
   /*public Materiel (String nom, String date, String Squantite, String id_mat){     //  ********** Teste Quantite
    super();
    this.nom = nom;
    this.date = date;
    this.quantite2 = quantite2;
    this.mat_id= id_mat;
   }
   */
    public Materiel (String nom, String date, String Squantite, String commentaire, String id_pers){    //  **** materiel utiliser
    super();                                                                                           // Modif ADMIN corbeille
    this.nom = nom;
    this.date = date;
    this.Squantite = Squantite;
    this.commentaire = commentaire;
    this.id_pers= id_pers;
    }
    
    public Materiel(String nom, String date, String Squantite,  String emplacement, String type, String id_pers){ //**  enregistrement
    super();                                                                                                     // modif ADMIN utiliser
    this.nom = nom;
    this.date = date;
    this.Squantite = Squantite;
    this.emplacement = emplacement;
    this.type = type;
    this.id_pers= id_pers;
    }
    
    public Materiel (String nom, String date, String Squantite, String etat , String emplacement, String type, String id_pers){ //* materiel reutilisable
    super();                                                                                                                    // et modif ADMIN materiel
    this.nom = nom;
    this.date = date;
    this.Squantite = Squantite;
    this.etat = etat;
    this.emplacement = emplacement;
    this.type = type;
    this.id_pers= id_pers;
    }
    
    ///****************************************  FIN ENTREE DONNEE *****************************************////
    
    
    /// ---------------------------------------  DEBUT AFFICHAGE DONNEE -------------------------------------- ///
    public Materiel (int id_bilan, String nom, int annee, String Squantite, String type){
    super();                                                                        //    Afficher bilan total entree et total utiliser
    this.id_mat=id_bilan;
    this.nom=nom;
    this.nombre=annee;
    this.Squantite=Squantite;
    this.type=type;
    }
    
    public Materiel(String nom){                                                    ///  affichage choix materiel
    super();                                                                        //    choix utiliser
    this.nom= nom;                                                                  //    choix personnel
    }
    
    
    public Materiel(int id_mat, String nom, String date, String Squantite, String tat, String emplacement, String type, String id_pers){ //** Affochage Materiel
    super();
    this.id_mat= id_mat;
    this.nom = nom;
    this.date = date;
    this.Squantite = Squantite;
    this.etat=tat;
    this.emplacement = emplacement;
    this.type = type;
    this.id_pers= id_pers;
    }
     
     public Materiel (int id_mat ,String nom, String date, String Squantite, String pers){     //  ********** mis corbeille
    super();
    this.id_mat=id_mat;
    this.nom = nom;
    this.date = date;
    this.Squantite = Squantite;
    this.id_pers= pers;
   }
     
     public Materiel(int id_mat, String nom, String date, String Squantite, String commentaire, String pers){  // afficher materiel utiliser
       super();
    this.id_mat=id_mat;
    this.nom = nom;
    this.date = date;
    this.Squantite = Squantite;
    this.commentaire= commentaire;
    this.id_pers= pers;
    
     }
     
    /// *****************************************  FIN AFFICHAGE **************************************** ////
     
    
    
     // -----------------------------------------  DEBUT TRAITEMENT DONNE ADMIN ----------------------------- ///
   /*  public Materiel(String nom, String date,  Object quantite, String emplacement, String type, String pers, String mat_id){    // modification materiel
     super();    
    this.nom = nom;
    this.date = date;
    this.quantite = quantite;
    this.emplacement=emplacement;
    this.type= type;
    this.id_pers= pers;    
    this.id_mat=id_mat;     
     }
     */
    /* public Materiel(String nom, String date,  Object quantite, String commentaire, String pers, int id_mat){  // modifier M utiliser
      super();    
    this.nom = nom;
    this.date = date;
    this.quantite = quantite;
    this.commentaire=commentaire;
    this.id_pers= pers;    
    this.id_mat=id_mat;       
     }
     */
     /*
     public Materiel(String nom, String date, Object quantite, String pers,int id_mat ){      // modifier corbeille
      super();
    this.nom = nom;
    this.date = date;
    this.quantite = quantite;
    this.id_pers= pers;   
    this.id_mat=id_mat;     
     }
     */
     // ******************************************  FIN TRAITEMENT DONNE ADMIN ****************************** ///
     
    public int getId_mat(){
        return id_mat;
    }
    public void setId_mat(int id_mat){
        this.id_mat=id_mat;
    }
    
    public String getNom() {
		return nom;
	}
    public void setNom(String nom) {
		this.nom = nom;
	}
    
    public String getDate() {
		return date;
	}
    public void setDate(String date) {
		this.date = date;
	}
    
    public Object getQuantite() {
		return quantite;
	}
    public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
    
     public int getQuantite2() {
		return quantite2;
	}
    public void setQuantite2(int quantite) {
		this.quantite2 = quantite;
	}
    
    public String getEtat() {
		return etat;
	}
    public void setEtat(String etat) {
		this.etat = etat;
	}
    public String getEmplacement() {
		return emplacement;
	}
    public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;      
	}
    
    public String getType() {
		return type;
	}
    public void setType(String type) {
		this.type = type;
	}
    
    public String getCommentaire() {
		return commentaire;
	}
    public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
    
     public String getId_pers() {
		return id_pers;
	}
    public void setId_pers(String pers) {
		this.id_pers = pers;
	}
    
    public int getNombre() {
		return nombre;
	}
    public void setNombre(int nbr) {
		this.nombre = nbr;
	}
    
    public String getMat_id() {
		return mat_id;
	}
    public void setNombre(String mat_id) {
		this.mat_id = mat_id;
	}
    
     public String getSquantite() {
		return Squantite;
	}
    public void setSquantite(String squantite) {
		this.Squantite = squantite;
	}
    
    public String getCode() {
		return code;
	}
    public void setCode(String code) {
		this.code = code;
	}
    public String getFonction() {
		return fonction;
	}
    public void setFonction(String fonction) {
		this.fonction = fonction;
	}
     public int getIdpersonnel() {
		return id_personnel;
	}
    public void setIdpersonnel(int pers) {
		this.id_personnel = pers;
	}
   
}
