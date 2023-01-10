/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import java.io.*;

/**
 *
 * @author Rafaly Antoni
 */
public class Classe implements Serializable{
        private int idJour;
	private String nomJour;
	private static final long serialVersionUID = 1L;  
        //*****hebdo
        private int idHeb;
        private String nomHeb;
        private String Jour;
        //***** mensuel
        private int idMen;
        private String nomMen;
        private String Semaine;
        //*********TrimSem
        private int idTri;
        private String nomTri;
        private String Mois;
        private String SemaineT;
        private String Type;
        //*********livre
        private String date;
        private String heure;
        private String semaine2;
        private String periode;
        private String equipement;
        private String type2;
        private String obs;
        private String act;
        //********* constructeur
        public Classe(String Date,String Heure,String sem,String Period,String equip, String type, String observe,String acteur){
            super();
            this.date=Date;
            this.heure=Heure;
            this.semaine2=sem;
            this.periode=Period;
            this.equipement=equip;
            this.type2=type;
            this.obs=observe;
            this.act=acteur;
        }
        public Classe(){
        
        }
        public Classe(String nomjour ) 
	{
		super();
		this.nomJour = nomjour;
	}
        public Classe(String nomheb,String jour ) //hebdo ou  mensuel
	{
		super();
		this.nomHeb = nomheb;
                this.Jour = jour;
	}
         public Classe(	String nomtrim,String mois,String semaine,String type) 
	{
		super();
		this.nomTri = nomtrim;
                this.Mois = mois;
                this.Semaine = semaine;
                this.Type = type;
	}
         public String getNomJour() {
		return nomJour;
	}
         public String getNomHeb() {
		return nomHeb;
	}
         public String getJour() {
		return Jour;
	}
         public String getNomTri() {
		return nomTri;
	}
         public String getMois() {
		return Mois;
	}
         public String getSemaine() {
		return Semaine;
	}
         public String getType() {
		return Type;
	}
         //*************
         public String getDat() {
		return date;
	}
         public String getheur() {
		return heure;
	}
         public String getSemain2() {
		return semaine2;
	}
         public String getPeriod() {
		return periode;
	}
         public String getEquipemnt() {
		return equipement;
	}
         public String getType2() {
		return type2;
	}
         public String getObs() {
		return obs;
	}
         public String getActeur() {
		return act;
	}
    
}
