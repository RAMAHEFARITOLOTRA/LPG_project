/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;
 
import classe.Materiel;
import classe.Classe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Snow
 */



public class Database implements IDatabase{
 Connection connex;
 Statement etat; 
 StringBuffer sql;
 ResultSet res;
 DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 
 public void connexionBase (){
        sql=new StringBuffer();
        connex=null;    etat=null;
        try{
           Class.forName("com.mysql.jdbc.Driver");
           connex=DriverManager.getConnection("jdbc:mysql://localhost/asecna","root","");
           etat=connex.createStatement();
           System.out.println("connection  base de donne reussi");
        }
          catch (ClassNotFoundException e){
              JOptionPane.showMessageDialog(null,"Pilote non configure");
          }
              catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Base de donne introuvables "); 
              }
        }
 
 public void BaseConnexion (){
        sql=new StringBuffer();
        connex=null;    etat=null;
        try{
           Class.forName("com.mysql.jdbc.Driver");
           connex=DriverManager.getConnection("jdbc:mysql://localhost/asecnatoni","root","");
           etat=connex.createStatement();
           System.out.println("connection  base de donne reussi deux");
        }
          catch (ClassNotFoundException e){
              JOptionPane.showMessageDialog(null,"Pilote non configure");
          }
              catch(SQLException e){
                 JOptionPane.showMessageDialog(null, e); 
              }
        }
 
 // -----------------------------------------------  DEBUT INSERTION DE DONNEE ---------------------------------------- ///
 
 @Override
  public void EnregistrerPersonnel(String nom, String code, String fonction){
        connexionBase();
        try{
             String req="insert into personnel (Nom,Code,Fonction)values('"+nom+"','"+code+"','"+fonction+"' ) ";
             sql.append(req); 
             etat.executeUpdate(sql.toString());
             System.out.println(" Nouveau personnel ajouter ");
       //      JOptionPane.showMessageDialog(null,"Materiels mis en service ajouter");        
        }catch(Exception e){
            
        }
    }
   
 
 
 @Override
    public void EnregistrerMateriel(String nom, String date, String quantite, String emplacement, String type, String pers ){
        connexionBase();
        String req="insert into materiel (Nom_mat,Date,Quantite,Etat,Emplacement,type,Id_pers)values('"+nom+"','"+date+"','"+quantite+"','Nouveau','"+emplacement+"','"+type+"','"+pers+"' ) ";
        try{
        sql.append(req); 
        etat.executeUpdate(sql.toString());
        System.out.println("Nouveau materiel ajouter ");
      //  JOptionPane.showMessageDialog(null,"Materiel inserer");
        }catch(Exception e){
        
        }
    }

 @Override
    public void Enregistrerutiliser(String nom, String date, String quantite, String commentaire, String pers){
        connexionBase();
        try{
             String req="insert into utiliser (Nom,Date,Nombre,Commentaire,Id_pers)values('"+nom+"','"+date+"','"+quantite+"','"+commentaire+"','"+pers+"' ) ";
             sql.append(req); 
             etat.executeUpdate(sql.toString());
             System.out.println(" Materiel mis en service ");
       //      JOptionPane.showMessageDialog(null,"Materiels mis en service ajouter");        
        }catch(Exception e){
            
        }
    }
    
 @Override
    public void Effacer1 (int nombre, String nom, String date){
        connexionBase();
    try{
          String req="UPDATE materiel set Quantite= "+nombre+" where Nom_mat= '"+nom+"' and Date = '"+date+"'  ";
          sql.append(req);
          etat.executeUpdate(sql.toString());
          System.out.println(" Quantite materiel en stock reduit pour utilisation");
}
         catch(SQLException e){
             
         }
        
    }
    
 @Override
    public void Enregistrercorbeille(String nom, String date, String quantite, String pers){
        connexionBase();
        try{
              String req="insert into corbeille (Nom,Date,Nombre,Id_pers)values('"+nom+"','"+date+"','"+quantite+"','"+pers+"' ) ";
              sql.append(req); 
              etat.executeUpdate(sql.toString());
        //      JOptionPane.showMessageDialog(null,"Materiels mis en corbeille");
             System.out.println(" Materiel en service mis en corbeille ");
         }
         
         catch(SQLException e){
            // JOptionPane.showMessageDialog(null,e.getMessage());//+);//e.getMessage());
         }
    }
    
 @Override
    public void Enregisterreutilisable(String nom, String date, String quantite, String tat, String emplacement, String type, String pers){
        connexionBase();
        try{
        String req="insert into materiel (Nom_mat,Date,Quantite,Etat,Emplacement,Type,Id_pers)values('"+nom+"','"+date+"','"+quantite+"','"+tat+"','"+emplacement+"','"+type+"','"+pers+"' ) ";
        sql.append(req);
        etat.executeUpdate(sql.toString());
        System.out.println(" Materiel en service remis en stock (reutilisable) ");
       // JOptionPane.showMessageDialog(null,"Materiels reincerer");
        } catch(Exception e){
      //       JOptionPane.showMessageDialog(null,e.getMessage());//+);//e.getMessage());
         }
}

 @Override
    public void Effacer2 (int nombre, String nom, String date){
    connexionBase();
    try{           
    String req="UPDATE utiliser set Nombre= '"+nombre+"' where Nom= '"+nom+"' and Date = '"+date+"'  ";
    sql.append(req);
    etat.executeUpdate(sql.toString());
    System.out.println(" Materiel en service reduit pour restockage ");
}
         catch(SQLException e){
        //     JOptionPane.showMessageDialog(null,e.getMessage());//+);//e.getMessage());
         }   
        
    }
    
    //*********************************************  FIN INSERTION DE DONNEE ***************************** ////
    
    
    // --------------------------------------------   DEBUT AFFICHAGE ------------------------------- ///
    
  /*  public ArrayList<Materiel>TestQuestionParametre(String id_mat, String Nom_mat, int quantite, String date){
        ArrayList<Materiel> List = new ArrayList<Materiel>();
        Materiel data;
        connexionBase();
        String req="select Nom_mat, Date, Quantite, Id_mat  from materiel ";
        String [] val = new String[0];
        String m=null;
        try{
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            int i=0;
            while(res.next()){
                if (res.getString(4).equals(id_mat)){
                    if (res.getString(1).equals(Nom_mat)){
                        if ( res.getString(3).equals(date)) {
                            if ( quantite > res.getInt(3)||  0 >= quantite ){
                             JOptionPane.showMessageDialog(null, " quantite incorectet");
                            }else{
                              JOptionPane.showMessageDialog(null, " mandalo entrer donne ");  
                              data=new Materiel(res.getString(1), res.getString(2), res.getInt(3), res.getString(4));
                              List.add(data);
                             
                            }
                        }
                           // JOptionPane.showMessageDialog(null, " date incorectet");
                               
                    }
                
                 //   JOptionPane.showMessageDialog(null, " choisisez dans le tableau ");
                }    
                
                i++;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "erreur");
        }
     return List;
     
    }
    */
 @Override
    public ArrayList<Materiel>TestQuestion1(){
        ArrayList<Materiel> List = new ArrayList<Materiel>();
        Materiel data;
        connexionBase();
        String req="select Nom_mat, Date, Quantite, Id_mat  from materiel ";
        String [] val = new String[0];
        String m=null;
        try{
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            int i=0;
            while(res.next()){
                data=new Materiel(res.getString(1), res.getString(2), res.getString(3), res.getString(4));
                List.add(data);
                i++;
            }
        }catch(Exception e){
            
        }
        System.out.println(" Teste si materiel correspond au quantite stocker ");
     return List;
     
    }
    
 @Override
    public ArrayList<Materiel>TestQuestion2(){
        ArrayList<Materiel> List = new ArrayList<Materiel>();
        Materiel data;
        connexionBase();
        String req="select Nom, Date, Nombre, Id_utiliser  from utiliser ";
        String [] val = new String[0];
        String m=null;
        try{
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            int i=0;
            while(res.next()){
                data=new Materiel(res.getString(1), res.getString(2), res.getString(3), res.getString(4));
                List.add(data);
                i++;
            }
        }catch(Exception e){
            
        }
        System.out.println(" Teste si materiel correspond au quantite en service ");
     return List;
     
    }
    
    
 @Override
     public ArrayList<Materiel>Choix(){
        ArrayList<Materiel> List = new ArrayList<Materiel>();
        Materiel data;
        connexionBase();
        String req=" SELECT Nom_mat from materiel group by Nom_mat";
        String [] val = new String[0];
        String m=null;
        try{
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            int i=0;
            while(res.next()){
                data=new Materiel(res.getString(1));
                List.add(data);
                i++;
            }
        }catch(Exception e){
            
        }
        System.out.println(" Choix materiel en stock pour mis en service ");
     return List;
     
    }
    
 @Override
      public ArrayList<Materiel>ChoixAnnee(){
        ArrayList<Materiel> List = new ArrayList<Materiel>();
        Materiel data;
        connexionBase();
        String req=" SELECT Annee from bilan group by Annee";
        String [] val = new String[0];
        String m=null;
        try{
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            int i=0;
            while(res.next()){
                data=new Materiel(res.getString(1));
                List.add(data);
                i++;
            }
        }catch(Exception e){
            
        }
        System.out.println(" Choix annee d'enregistrement ou de mis en service ");
     return List;
     
    }
    
 @Override
    public ArrayList<Materiel>ChoixRetirer(){
        ArrayList<Materiel> List = new ArrayList<Materiel>();
        Materiel data;
        connexionBase();
        String req=" SELECT Nom from utiliser group by Nom";
        String [] val = new String[0];
        String m=null;
        try{
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            int i=0;
            while(res.next()){
                data=new Materiel(res.getString(1));
                List.add(data);
                i++;
            }
        }catch(Exception e){
            
        }
        System.out.println(" Choix materiel mis en service pour fin service (Reutilisable/Inutilisable) ");
     return List;
     
    }
    
 @Override
    public ArrayList<Materiel>ChoixPers(){
        ArrayList<Materiel> List = new ArrayList<Materiel>();
        Materiel data;
        connexionBase();
        String req=" SELECT Nom from personnel";
        String [] val = new String[0];
        String m=null;
        try{
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            int i=0;
            while(res.next()){
                data=new Materiel(res.getString(1));
                List.add(data);
                i++;
            }
        }catch(Exception e){
            
        }
        System.out.println(" Choix du personnel technicien ");
     return List;
     
    }
    
 @Override
    public ArrayList<Materiel>AfficherPersonnel(){                          // afficher les personnel du MIRE
        ArrayList<Materiel> List = new ArrayList<Materiel>();
        Materiel data;
        connexionBase();
        String req="select * from personnel order by Id desc";
        String [] val = new String[0];
        String m=null;
        try{
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            int i=0;
            while(res.next()){
                data=new Materiel(res.getInt(1), res.getString(2), res.getString(3), res.getString(4));
                List.add(data);
                i++;
            }
        }catch(Exception e){
            
        }
        System.out.println(" Affichage de tous les personnels technicien ");
     return List;
     
    }
     
    
 @Override
    public ArrayList<Materiel>AfficherBilan(String type, int anne){
       // JOptionPane.showMessageDialog(null, " mande le affiche bilan");
        ArrayList<Materiel> List = new ArrayList<Materiel>();
        Materiel data;
        connexionBase();
        String req="select Nom_mat, Annee, SUM(Quantite) from bilan where Type='"+type+"' and Annee='"+anne+"' group by Nom_mat order by id_bilan desc" ;
        String [] val = new String[0];
        String m=null;
        try{
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            int i=0;
            while(res.next()){
                data=new Materiel(res.getString(1), res.getString(2), res.getString(3));
                List.add(data);
              //  JOptionPane.showMessageDialog(null, res.getString(8));
                i++;
            }
        }catch(Exception e){
        }
        System.out.println(" Affichage des materiels de type ('nouveau' ou 'en service') selon l'annee ");
     return List;
    }
    
    
 @Override
     public ArrayList<Materiel>AfficherBilanAdmin(){
       // JOptionPane.showMessageDialog(null, " mande le affiche bilan");
        ArrayList<Materiel> List = new ArrayList<Materiel>();
        Materiel data;
        connexionBase();
        String req="select id_bilan, Nom_mat, Annee, Quantite, Type from bilan  order by id_bilan desc" ;
        String [] val = new String[0];
        String m=null;
        try{
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            int i=0;
            while(res.next()){
                data=new Materiel(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4), res.getString(5));
                List.add(data);
              //  JOptionPane.showMessageDialog(null, res.getString(8));
                i++;
            }
        }catch(Exception e){
        }
        System.out.println(" Affichage des materiels de type ('nouveau' ou 'en service') pour admin ");
     return List;
    }
     
 @Override
    public ArrayList<Materiel> AfficherPersonneTestNom(String nomtable, String nom, String code){
      // JOptionPane.showMessageDialog(null, " mande le affiche  personne test");
        connexionBase();
       
        ArrayList<Materiel> List = new ArrayList<Materiel>();
        Materiel data;
        connexionBase();
        String req="select Id, Nom, Code from "+nomtable+" where Nom='"+nom+"' and Code='"+code+"' "  ;
        String [] val = new String[0];
        String m=null;
        try{
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            int i=0;
            while(res.next()){
                data=new Materiel(res.getString(1), res.getString(2), res.getString(3));
                List.add(data);
              //  JOptionPane.showMessageDialog(null, res.getString(8));
                i++;
            }
        }catch(Exception e){
        }
        System.out.println(" Affichage le personnel correspondant au code (identification) ");
     return List;
        
    }
    
    
 @Override
    public Boolean AfficherPersonneTest(String nomtable, String nom, String code){
      // JOptionPane.showMessageDialog(null, " mande le affiche  personne test");
        connexionBase();
        String req="select Id, Nom, Code from "+nomtable+" where Nom='"+nom+"' and Code='"+code+"' " ;
        Boolean k=false;
        try{
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            while(res.next()){
                 k=true;
              //   AfficherPersonneTestNom(nomtable, res.getString(2), res.getString(3));
            }
            
        }catch(Exception e){
        }
        System.out.println(" Test si personnel correspond au identification ");
     return k;
    }
    
 @Override
    public ArrayList<Materiel>AfficherMateriel(){
        ArrayList<Materiel> List = new ArrayList<Materiel>();
        Materiel data;
        connexionBase();
        String req="select * from materiel order by Id_mat desc";
        String [] val = new String[0];
        String m=null;
        try{
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            int i=0;
            while(res.next()){
                data=new Materiel(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8));
                List.add(data);
              //  JOptionPane.showMessageDialog(null, res.getString(8));
                i++;
            }
        }catch(Exception e){
        }
        System.out.println(" Affichage des materiels ");
     return List;
    }
    
 @Override
    public ArrayList<Materiel>AfficherMaterielGroupe(){
        ArrayList<Materiel> List = new ArrayList<Materiel>();
        Materiel data;
        connexionBase();
        String req="select Id_mat, Nom_mat, Date, SUM(Quantite), Etat, Emplacement, type, Id_pers from materiel group by Nom_mat order by Id_mat desc";
        String [] val = new String[0];
        String m=null;
        try{
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            int i=0;
            while(res.next()){
                data=new Materiel(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8));
                List.add(data);
              //  JOptionPane.showMessageDialog(null, res.getString(8));
                i++;
            }
        }catch(Exception e){
        }
        System.out.println(" Affichage des materiels regroupes ");
     return List;
    }
    
 @Override
     public ArrayList<Materiel>AfficherUtiliserGroupe(){
        ArrayList<Materiel> List = new ArrayList<Materiel>();
        Materiel data;
        connexionBase();
        String req="select Id_utiliser, Nom, Date, SUM(Nombre), Commentaire, Id_pers from utiliser group by Nom order by id_utiliser desc";
        String [] val = new String[0];
        String m=null;
        try{
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            int i=0;
            while(res.next()){
                data=new Materiel(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6));
                List.add(data);
                i++;
            }
        }catch(Exception e){
            
        }
        System.out.println(" Affichage des materiels en service regroupes ");
     return List;
     
    }
    
 @Override
    public ArrayList<Materiel>AfficherCorbeilleGroupe(){
        ArrayList<Materiel> List = new ArrayList<Materiel>();
        Materiel data;
        connexionBase();
        String req="select Id_corbeille, Nom, Date, SUM(Nombre), Id_pers from corbeille group by Nom order by id_corbeille desc";
        String [] val = new String[0];
        String m=null;
        try{
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            int i=0;
            while(res.next()){
                data=new Materiel(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
                List.add(data);
                i++;
            }
        }catch(Exception e){
            
        }
     System.out.println(" Affichage des materiels en corbeille regroupes ");   
     return List;
     
    }
     
 @Override
     public ArrayList<Materiel>AfficherCorbeille(){
        ArrayList<Materiel> List = new ArrayList<Materiel>();
        Materiel data;
        connexionBase();
        String req="select * from corbeille order by id_corbeille desc";
        String [] val = new String[0];
        String m=null;
        try{
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            int i=0;
            while(res.next()){
                data=new Materiel(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
                List.add(data);
                i++;
            }
        }catch(Exception e){
            
        }
        System.out.println(" Affichage des materiels en corbeille ");
     return List;
     
    }
     
 @Override
     public ArrayList<Materiel>AfficherUtiliser(){
        ArrayList<Materiel> List = new ArrayList<Materiel>();
        Materiel data;
        connexionBase();
        String req="select * from utiliser order by id_utiliser desc";
        String [] val = new String[0];
        String m=null;
        try{
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            int i=0;
            while(res.next()){
                data=new Materiel(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6));
                List.add(data);
                i++;
            }
        }catch(Exception e){
            
        }
        System.out.println(" Affichage des materiels en service ");
     return List;
  }
     
 @Override
     public ArrayList<Materiel>AfficherRechercheMateriel(String nomcolumn, String mot){
        ArrayList<Materiel> List = new ArrayList<Materiel>();
        Materiel data;
        connexionBase();
       String req=" SELECT * from materiel where "+nomcolumn+" like'"+ mot + "%' " ;
        String [] val = new String[0];
        String m=null;
        try{
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            int i=0;
            while(res.next()){
                data=new Materiel(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8));
                List.add(data);
                i++;
            }
        }catch(Exception e){
 //           JOptionPane.showMessageDialog(null, "erreur le affiche materiel");
        }
        System.out.println(" Recherche materiel ");
     return List;
     
    }
     
 @Override
     public ArrayList<Materiel>AfficherRechercheUtiliser(String nomcolumn, String mot){
        ArrayList<Materiel> List = new ArrayList<Materiel>();
        Materiel data;
        connexionBase();
       String req=" SELECT * from utiliser where "+nomcolumn+" like'"+ mot + "%' " ;
        String [] val = new String[0];
        String m=null;
        try{
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            int i=0;
            while(res.next()){
                data=new Materiel(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6));
                List.add(data);
                i++;
            }
        }catch(Exception e){
    //        JOptionPane.showMessageDialog(null, "erreur le affiche utiliser");
        }
        System.out.println(" Recherche materiel en service ");
     return List;
    }
     
 @Override
    public ArrayList<Materiel>AfficherRechercheCorbeille(String nomcolumn, String mot){
        ArrayList<Materiel> List = new ArrayList<Materiel>();
        Materiel data;
        connexionBase();
       String req=" SELECT * from corbeille where "+nomcolumn+" like'"+ mot + "%' " ;
        String [] val = new String[0];
        String m=null;
        try{
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            int i=0;
            while(res.next()){
                data=new Materiel(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
                List.add(data);
                i++;
            }
        }catch(Exception e){
      //      JOptionPane.showMessageDialog(null, "erreur le affiche corbeille");
        }
        System.out.println(" Recherche materiel en corbeille ");
     return List;
    } 
     
     /// ------------------------------------   DEBUT INSERTION ADMIN --------------------------///
    
 @Override
     public void ModifierPersonnel(String nom, String code, String fonction, String id_personnel){
        connexionBase();
        try{
         String req="UPDATE personnel set Nom= '"+nom+"', Code= '"+code+"', Fonction= '"+fonction+"' where Id= '"+id_personnel+"'  ";
        sql.append(req);
        etat.executeUpdate(sql.toString());
  //      JOptionPane.showMessageDialog(null, "Materiel dans utiliser modifier ");
         System.out.println(" Modification personnel ");
     }catch(Exception e){
        // JOptionPane.showMessageDialog(null, e);
     }
     }
    
    
 @Override
    public void ModifierMateriel(String nom, String date, String quantite, String emplacement, String type, String pers, String id_mat){
         connexionBase();
         try{
         String req="UPDATE materiel set Nom_mat= '"+nom+"', Date= '"+date+"', Quantite= '"+quantite+"', Emplacement= '"+emplacement+"', type= '"+type+"', Id_pers= '"+pers+"' where Id_mat= '"+id_mat+"'  ";
         sql.append(req);
         etat.executeUpdate(sql.toString());
         System.out.println(" Modification materiel ");
    //     JOptionPane.showMessageDialog(null, "Materiel dans materiel modifier ");
         }catch (Exception e){
         
     }
     }
     
 @Override
     public void ModifierUtiliser(String nom, String date,  String quantite, String commentaire, String pers, String id_mat){
        connexionBase();
        try{
         String req="UPDATE utiliser set Nom= '"+nom+"', Date= '"+date+"', Nombre= '"+quantite+"', Commentaire= '"+commentaire+"', Id_pers= '"+pers+"' where Id_utiliser= '"+id_mat+"'  ";
        sql.append(req);
        etat.executeUpdate(sql.toString());
        System.out.println(" Modification materiel en service ");
  //      JOptionPane.showMessageDialog(null, "Materiel dans utiliser modifier ");
         
     }catch(Exception e){
         
     }
     }
     
 @Override
     public void ModifierCorbeille(String nom, String date, String quantite, String pers,String id_mat){
         connexionBase();
         try{
         String req="UPDATE corbeille set Nom= '"+nom+"', Date= '"+date+"', Nombre= '"+quantite+"',  Id_pers= '"+pers+"' where Id_corbeille= '"+id_mat+"'  ";
         sql.append(req);
        etat.executeUpdate(sql.toString());
        System.out.println(" Modification materiel en corbeille ");
  //      JOptionPane.showMessageDialog(null, "Materiel dans corbeille modifier ");
    
    }
         catch(Exception e){
     //        JOptionPane.showMessageDialog(null,e.getMessage());//+);//e.getMessage());
     }
     }
     
 @Override
     public void ModifierBilanAdmin(String nom, String annee, String quantite, String type, String id){
         connexionBase();
        try{
         String req="UPDATE bilan set Nom_mat= '"+nom+"', Annee= '"+annee+"', Quantite= '"+quantite+"',  Type= '"+type+"' where Id_bilan= '"+id+"'  ";
         sql.append(req);
        etat.executeUpdate(sql.toString());
        System.out.println(" Modification du bilan (administrateur) ");
    //    JOptionPane.showMessageDialog(null, "Materiel dans bilan modifier ");
    
    }
         catch(Exception e){
      //       JOptionPane.showMessageDialog(null,e.getMessage());//+);//e.getMessage());
     }
     }
     
     
 @Override
 public void SupprimerPersonnel(String id_personnel){
          connexionBase();
 try {
        //JOptionPane.showMessageDialog(null,id_mat);   
  // JOptionPane.showMessageDialog(null,nom_table);   

   String req="delete  from personnel where Id ='"+id_personnel+"' ";
   sql.append(req);
   etat.executeUpdate(sql.toString());
   System.out.println(" Suppression personnel ");
   //JOptionPane.showMessageDialog(null,"materiel supprimer");
   }
   catch (SQLException e){
//   JOptionPane.showMessageDialog(null,"Personnel non supprimer");   

}
     }
     
 @Override
 public void SuppMateriel(String id){
     connexionBase();
     try{
         String req="delete from materiel where Id_mat='"+id+"' ";
         sql.append(sql);
         etat.executeUpdate(sql.toString());
     }catch(Exception e){
         JOptionPane.showMessageDialog(null, e.getMessage());
     }
     
 }    
 @Override
     public void SupprimerMateriel(String id_mat){
          connexionBase();
 try {
        JOptionPane.showMessageDialog(null,id_mat);   
   String req="delete  from materiel where Id_mat ='"+id_mat+"' ";
   sql.append(req);
   etat.executeUpdate(sql.toString());
   System.out.println(" Suppression Materiel ");
   JOptionPane.showMessageDialog(null,"materiel supprimer");
   }
   catch (SQLException e){
   JOptionPane.showMessageDialog(null,"materiel non supprimer");   

}
     }
     
 @Override
 public void SupprimerUtiliser(String id_mat){
          connexionBase();
 try {
        JOptionPane.showMessageDialog(null,id_mat);   
  // JOptionPane.showMessageDialog(null,nom_table);   

   String req="delete  from utiliser where Id_utiliser ='"+id_mat+"' ";
   sql.append(req);
   etat.executeUpdate(sql.toString());   
   System.out.println(" Suppression materiel en service ");
   JOptionPane.showMessageDialog(null,"materiel supprimer");
   }
   catch (SQLException e){
   JOptionPane.showMessageDialog(null,e.getMessage());   

}
     }


 @Override
 public void SupprimerStock(String id_mat){
          connexionBase();
 try {
        JOptionPane.showMessageDialog(null,id_mat);   
  // JOptionPane.showMessageDialog(null,nom_table);   

   String req="delete  from corbeille where Id_corbeille ='"+id_mat+"' ";
   sql.append(req);
   etat.executeUpdate(sql.toString());   
   System.out.println(" Suppression materiel en corbeille ");
 //  JOptionPane.showMessageDialog(null,"materiel supprimer");
   }
   catch (SQLException e){
//   JOptionPane.showMessageDialog(null,"materiel non supprimer");   

}
     }

 @Override
 public void SupprimerbilanAdmin(String id_bilan){
          connexionBase();
 try {
        JOptionPane.showMessageDialog(null,id_bilan);   
  // JOptionPane.showMessageDialog(null,nom_table);   

   String req="delete  from bilan where Id_bilan ='"+id_bilan+"' ";
   sql.append(req);
   etat.executeUpdate(sql.toString());   
   System.out.println(" Suppression bilan (administrateur) ");
 //  JOptionPane.showMessageDialog(null,"materiel supprimer");
   }
   catch (SQLException e){
 //  JOptionPane.showMessageDialog(null,"materiel non supprimer");   
}
     }

 @Override
 public void Supprimer_Tous_bilanAdmin(String annee){
          connexionBase();
 try {
        JOptionPane.showMessageDialog(null,annee);   
  // JOptionPane.showMessageDialog(null,nom_table);   

   String req="delete  from bilan where Annee='"+annee+"'  ";
   sql.append(req);
   etat.executeUpdate(sql.toString());   
   System.out.println(" Suppression tous les bilan selon annee ");
 //  JOptionPane.showMessageDialog(null,"materiel supprimer");
   }
 
   catch (SQLException e){
 //  JOptionPane.showMessageDialog(null,"materiel non supprimer");   
}
     }

     // *************************************   FIN INSERTION ADMIN     ************************* ///


// ---------------------------------------  DEBUT ENREGISTRER TOTAL ENTREE -------------------------------------- ////
 @Override
 public void EnregistrerTotalEntrer(String nom, String annee, String quantite){
    connexionBase();
    try{
        String req="insert into bilan (Nom_mat,Annee,Quantite,Type)values('"+nom+"','"+annee+"','"+quantite+"','nouveau') ";
        sql.append(req);
        etat.executeUpdate(sql.toString());
        System.out.println("Nouveau materiel enregistrer dans bilan ");
//        JOptionPane.showMessageDialog(null," Bilan Enregistrer ");
        } catch(Exception e){
//             JOptionPane.showMessageDialog(null,e.getMessage());//+);//e.getMessage());
         }
}

 @Override
 public void EnregistrerTotalUtiliser(String nom, String annee, String quantite){
    connexionBase();
    try{
        String req="insert into bilan (Nom_mat,Annee,Quantite,Type)values('"+nom+"','"+annee+"','"+quantite+"','utiliser') ";
        sql.append(req);
        etat.executeUpdate(sql.toString());
        System.out.println(" Materiel mis en service enregistrer dans bilan ");
      //  JOptionPane.showMessageDialog(null," Bilan " + nom);
        } catch(Exception e){
  //           JOptionPane.showMessageDialog(null,e.getMessage());//+);//e.getMessage());
         }
}

/*public void EnregistrerTotalStock(String nom, String annee, Object quantite){
    connexionBase();
    try{
        String req="insert into bilan (Nom_mat,Annee,Quantite,Type)values('"+nom+"','"+annee+"','"+quantite+"','stock') ";
        sql.append(req);
        etat.executeUpdate(sql.toString());
    //    JOptionPane.showMessageDialog(null," Bilan Enregistrer ");
        } catch(Exception e){
    //         JOptionPane.showMessageDialog(null,e.getMessage());//+);//e.getMessage());
         }
}


public void EnregistrerTotalStockReutilisable(String nom, String annee, Object quantite){
    connexionBase();
    try{
        String req="insert into bilan (Nom_mat,Annee,Quantite,Type)values('"+nom+"','"+annee+"','"+quantite+"','reutiliser') ";
        sql.append(req);
        etat.executeUpdate(sql.toString());
   //     JOptionPane.showMessageDialog(null," Bilan Enregistrer ");
        } catch(Exception e){
     //        JOptionPane.showMessageDialog(null,e.getMessage());//+);//e.getMessage());
         }
}
*/
 
 
 
 
 
 
 
 
 
 
 
 
 
 /*************************************   Toni DataBase *******************************************/
 /*************************************************************************************************/
 
    @Override
    public int compterJour(String jour) {
     System.out.println(" Compter jour ");
     return 0;
}

    @Override
    public ArrayList<Classe> afficheJour(String jour) {
        ArrayList<Classe> list = new ArrayList<Classe>();
        Classe data;
         BaseConnexion();
     String req = null;
   
        req=" select  * from hebdomadaire where jour='"+jour+"' ";
    try{
        sql.append(req);
        res=etat.executeQuery(sql.toString());
        while(res.next()){
            data = new Classe(res.getString("nomHebdo"),res.getString(3));
            list.add(data);
        }
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erreur de syntax "+e.getMessage());
    }
     System.out.println(" Affichage des jours ");
    return list;
    }

    @Override
    public void MoisJour() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compterTL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afficheTL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compterMensuel(String semaine) {
        int i=0;
        BaseConnexion();
       String req=" select * from mensuel where Semaine='"+semaine+"'  ";
       try
       {
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            while(res.next())
            {
               i++;
            }
        }
       catch(SQLException e)
       {
         JOptionPane.showMessageDialog(null, "Erreur de syntax "+e.getMessage());
       }
        System.out.println(" Compter mensuel ");
        return i;
    }

    @Override
    public ArrayList<Classe> afficheMensuel(String semaine) {
         ArrayList<Classe> list = new ArrayList<>();
        Classe data;
         BaseConnexion();
     String req =" select * from mensuel where Semaine='"+semaine+"'  ";
    try{
        sql.append(req);
        res=etat.executeQuery(sql.toString());
        while(res.next()){
            data = new Classe(res.getString(2),res.getString(3));
            list.add(data);
        }
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erreur de syntax "+e.getMessage());
    }
     System.out.println(" Affichage mensuel ");
    return list;
//To change body of generated methods, choose Tools | Templates.
    }
 
    @Override
    public ArrayList<Classe> afficheMensuelCond(){
        ArrayList<Classe> list = new ArrayList<>();
        Classe data;
         BaseConnexion();
     String req =" select * from mensuel where Semaine='semaine 4'or Semaine='semaine 5'  ";
    try{
        sql.append(req);
        res=etat.executeQuery(sql.toString());
        while(res.next()){
            data = new Classe(res.getString(2),res.getString(3));
            list.add(data);
        }
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erreur de syntax "+e.getMessage());
    }
     System.out.println(" Affichage mensuel si mensuel semaine 4 ou semaine 5 ");
    return list;
    }

    @Override
    public void afficheMensuel2(String semaine, String[] semain) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//*********************page
    @Override
    public int compterContact() {
        int i=0;
        BaseConnexion();
        String req=" select * from journalier ";
       try
       {
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            while(res.next())
            {
               i++;
            }
        }
       catch(SQLException e)
       {
         JOptionPane.showMessageDialog(null, "Erreur de syntax "+e.getMessage());
       }
        System.out.println(" Compter contact ");
        return i;
    }

    @Override
    public ArrayList<Classe> compter2(String table, String nomC, String condition, String id) {
        int i=0;
        BaseConnexion();
        ArrayList<Classe> list = new ArrayList<>();
        Classe data;
         connexionBase();
       String req=" select NomTaf from "+table+" Inner join taf on "+table+"."+id+"=taf."+id+" where "+nomC+"='"+condition+"'  ";
       try
       {
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            while(res.next())
            {
                data = new Classe(res.getString(1));
                list.add(data);
               i++;
            }
        }
       catch(SQLException e)
       {
         JOptionPane.showMessageDialog(null, "Erreur de syntax "+e.getMessage());
       }
        System.out.println(" Affichage des travails a faire ");
        return list;
    }

    @Override
    public ArrayList <Classe> afficheContact(String table) {
            //table1.setModel(new DefaultTableModel(colonneTab,n));
     ArrayList<Classe> list = new ArrayList<Classe>();
        Classe data;
         BaseConnexion();
    String req=" select * from "+table+" ";
    try{
        sql.append(req);
        res=etat.executeQuery(sql.toString());
        while(res.next()){
            data = new Classe(res.getString(2));
            list.add(data);
        }
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erreur de syntax ici  "+e.getMessage());
    }
     System.out.println(" Affichages des contacts  ");
    return list;
    }

    
    @Override
    public ArrayList<Classe> affiche2(int n,String nom, String table, String id, String Nomcondion, String condition) {
        ArrayList<Classe> list = new ArrayList<Classe>();
        Classe data;
         BaseConnexion();
         String req=" select "+nom+" from "+table+" Inner join taf on "+table+"."+id+"=taf."+id+" where "+Nomcondion+"='"+condition+"'  ";
         try{
        sql.append(req);
        res=etat.executeQuery(sql.toString());
        while(res.next()){
            data = new Classe(res.getString(n));
            list.add(data);
        }
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erreur de syntax "+e.getMessage());
    }
          System.out.println(" Affichage recherche MAYBE ");
         return list;
    }

    @Override
    public int compterHebdo(String jour) {
        int i=0;
        BaseConnexion();
       String req = null;
    if( "Mon".equals(jour)){
        req=" select * from hebdomadaire where jour='Lundi' ";
    }
    if( "Tue".equals(jour)){
        req=" select * from hebdomadaire where jour='Mardi' ";}
    if( "Wed".equals(jour)){
        req=" select * from hebdomadaire where jour='Mercredi' ";}
    if( "Thu".equals(jour)){
        req=" select * from hebdomadaire where jour='Jeudi' ";}
    if( "Fri".equals(jour)){
        req=" select * from hebdomadaire where jour='Vendredi' ";}
    if( "Sat".equals(jour)){
        req=" select * from hebdomadaire where jour='Samedi' ";}
    if( "Sun".equals(jour)){
        req=" select  * from hebdomadaire where jour='Dimanche' ";}
    else
        
       try
       {
            sql.append(req);
            res=etat.executeQuery(sql.toString());
            while(res.next())
            {
               i++;
            } 
        }
       catch(SQLException e)
       {
         JOptionPane.showMessageDialog(null, "Erreur de syntax "+e.getMessage());
       }
         System.out.println(" Compter HEBDO ");
        return i;
    }

    @Override
    public void textHeb(String jourss) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Classe> afficheHebdo(String jour) {
         ArrayList<Classe> list = new ArrayList<Classe>();
        Classe data;
         BaseConnexion();
     String req = null;
    if( "Mon".equals(jour)){
        req=" select * from hebdomadaire where jour='Lundi' ";
    }
    if( "Tue".equals(jour)){
        req=" select * from hebdomadaire where jour='Mardi' ";}
    if( "Wed".equals(jour)){
        req=" select * from hebdomadaire where jour='Mercredi' ";}
    if( "Thu".equals(jour)){
        req=" select * from hebdomadaire where jour='Jeudi' ";}
    if( "Fri".equals(jour)){
        req=" select * from hebdomadaire where jour='Vendredi' ";}
    if( "Sat".equals(jour)){
        req=" select * from hebdomadaire where jour='Samedi' ";}
    if( "Sun".equals(jour)){
        req=" select  * from hebdomadaire where jour='Dimanche' ";}
    try{
        sql.append(req);
        res=etat.executeQuery(sql.toString());
        while(res.next()){
            data = new Classe(res.getString("nomHebdo"),res.getString(3));
            list.add(data);
        }
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erreur de syntax "+e.getMessage());
    }
    System.out.println("Affichage lors du jour correspondant");
    return list;
    }

    @Override
    public int compterMensuel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Classe> afficheMensuel() {
        ArrayList<Classe> list = new ArrayList<>();
        Classe data;
         BaseConnexion();
     String req =" select * from mensuel  ";
    try{
        sql.append(req);
        res=etat.executeQuery(sql.toString());
        while(res.next()){
            data = new Classe(res.getString(2),res.getString(3));
            list.add(data);
        }
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erreur de syntax "+e.getMessage());
    }
    System.out.println("Affichage mensuels ");
    return list;
    }

    @Override
    public int compterTri() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afficheTri() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compterTafHebdo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afficheTafHebdo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compterS1M1(String semaine, String mois, String type) {
            int i=0;
                BaseConnexion();
                String req=" select NomTri from trisem where Semaine='"+semaine+"'and Mois='"+mois+"'and Type='"+type+"'  ";
                try
                {
                    sql.append(req);
                    res=etat.executeQuery(sql.toString());
                    while(res.next())
                     {
                         i++;
                     }
                }
                catch(SQLException e)
                {
                        JOptionPane.showMessageDialog(null, "Erreur de syntax "+e.getMessage());
                }
                System.out.println(" Compter Semaine 1 MOis 1 ");        
                return i;
    }

    @Override
    public ArrayList<Classe> afficheS1M1(String semaine, String mois, String type) {
             ArrayList<Classe> list = new ArrayList<>();
        Classe data;
         BaseConnexion();
    String req=" select * from trisem where Semaine='"+semaine+"'and Mois='"+mois+"'and Type='"+type+"'  ";
    try{
        sql.append(req);
        res=etat.executeQuery(sql.toString());
        while(res.next()){
            data = new Classe(res.getString("NomTri"),res.getString("Mois"),res.getString("Semaine"),res.getString("Type"));
            list.add(data);
        }
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erreur de syntax "+e.getMessage());
    }
    System.out.println("Affichage Semaine 1 mois 1");
    return list;
    }
    @Override
    public ArrayList<Classe> afficheNotif(String mois){
        ArrayList<Classe> list = new ArrayList<>();
        Classe data;
         BaseConnexion();
    String req=" select * from trisem where Mois='"+mois+"'  ";
    try{
        sql.append(req);
        res=etat.executeQuery(sql.toString());
        while(res.next()){
            data = new Classe(res.getString("NomTri"),res.getString("Mois"),res.getString("Semaine"),res.getString("Type"));
            list.add(data);
        }
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erreur de syntax "+e.getMessage());
    }
    System.out.println("Affichages des notifications ");
    return list;
    }
    @Override
    public int donnePv(String nom, String table, String nomCond, String condition){
         BaseConnexion();
         int n = 0;
    String req=" select "+nom+" from "+table+" where "+nomCond+"='"+condition+"' ";
    try{
        sql.append(req);
        res=etat.executeQuery(sql.toString());
        while(res.next()){
            n=res.getInt(1);
        }
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erreur de syntax "+e.getMessage());
    }
    System.out.println(" donnePV");
    return n;
    }
    //*****creatio database
    @Override
     public void enregistreContact(String date,String heure,int sem,String obs,String periode,int idjour,int idtaf,int idhedo,int idmen,int idtri){
    BaseConnexion();
    String req=" insert into pv (date,heure,semainePrevue,observation,periodicite,idJour,IdTaf,IdHebdo,IdMen,IdTrim) values ('"+date+"','"+heure+"',"+sem+",'"+obs+"','"+periode+"','"+idjour+"','"+idtaf+"','"+idhedo+"','"+idmen+"','"+idtri+"') ";
    try{
        sql.append(req);
        etat.executeUpdate(sql.toString());
        System.out.println("Pv du "+periode+" Ajoutee");
       // JOptionPane.showMessageDialog(null, "Personne inserer");
       
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Personne non inserer");
         System.out.println(e.getMessage());
    }
    System.out.println("Enregistrement des contacts");
    }
    @Override
      public void AddActeur(int pv,int pers){
           BaseConnexion();
    String req=" insert into acteur (idPv,IdPers) values ('"+pv+"','"+pers+"') ";
    try{
        sql.append(req);
        etat.executeUpdate(sql.toString());
      System.out.println("Personne num: "+pers+"  Ajoutee un pv num: "+pv);
       
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Acteur non inseree");
         System.out.println(e.getMessage());
    }
    System.out.println("Enregistrement acteurs ");
      }
    @Override
       public int AddMax(String table, String id){
         BaseConnexion();
         int n = 0;
    String req=" select MAX("+id+") from "+table+" ";
    try{
        sql.append(req);
        res=etat.executeQuery(sql.toString());
        while(res.next()){
            n=res.getInt(1);
        }
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erreur de syntax "+e.getMessage());
    }
    System.out.println("Addmax");
    return n;
    }

    @Override
    public void AddTravailJour(String titre) {
         BaseConnexion();
    String req=" insert into journalier (NomJour) values ('"+titre+"') ";
    try{
        sql.append(req);
        etat.executeUpdate(sql.toString());
        Date date;
        System.out.println(dateFormat.format(date=new Date())+" journalier  "+titre+" Ajoutee");
       // JOptionPane.showMessageDialog(null, "Personne inserer");
       
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Journalier non inserer");
         System.out.println(e.getMessage());
    }
    System.out.println("Enregistrement travail journalier");
    }

    @Override
    public void AddTravailHeb(String titre, String jour) {
        BaseConnexion();
    String req=" insert into hebdomadaire (NomHebdo,Jour) values ('"+titre+"','"+jour+"') ";
    try{
        sql.append(req);
        etat.executeUpdate(sql.toString());
        Date date;
        System.out.println(dateFormat.format(date=new Date())+",Hebdomadaire  "+titre+" Ajoutee");
       // JOptionPane.showMessageDialog(null, "Personne inserer");
       
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Journalier non inserer");
         System.out.println(e.getMessage());
    }
    System.out.println("Enregistrement travail hebdomadaire");
    }

    @Override
    public void AddTravailMen(String titre, String Sem) {
        BaseConnexion();
    String req=" insert into mensuel (NomMen,Semaine) values ('"+titre+"','"+Sem+"') ";
    try{
        sql.append(req);
        etat.executeUpdate(sql.toString());
        Date date;
        System.out.println(dateFormat.format(date=new Date())+",Travail Mensuel  "+titre+" Ajoutee");
       // JOptionPane.showMessageDialog(null, "Personne inserer");
       
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Travail Mensuel non Ajoutee");
         System.out.println(e.getMessage());
    }
    System.out.println("Enregistrement travail mensuel");
    }

    @Override
    public void AddTravailTri(String titre, String sem, String mois, String type) {
        BaseConnexion();
    String req=" insert into trisem (NomTri,Mois,Semaine,Type) values ('"+titre+"','"+mois+"','"+sem+"','"+type+"') ";
    try{
        sql.append(req);
        etat.executeUpdate(sql.toString());
        Date date;
        System.out.println(dateFormat.format(date=new Date())+",Travail Trimestriel ou Semestriel  "+titre+" Ajoutee");
       // JOptionPane.showMessageDialog(null, "Personne inserer");
       
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Travail Trimestriel ou Semestriel non inseree");
         System.out.println(e.getMessage());
    }
System.out.println("Enregistrement travail trimestriel");        
    }

    @Override
    public void AddTaf(String Valeur, int jour, int heb, int men, int tri) {
        BaseConnexion();
    String req=" insert into taf (NomTaf,IdJour,IdHebdo,IdMen,IdTri) values ('"+Valeur+"',"+jour+","+heb+","+men+","+tri+") ";
    try{
        sql.append(req);
        etat.executeUpdate(sql.toString());
        Date date;
        System.out.println(dateFormat.format(date=new Date())+" Type de travail  "+Valeur+" Ajoutee");
       // JOptionPane.showMessageDialog(null, "Personne inserer");
       
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "TAF non ajoutee probleme du table Taf");
         System.out.println(e.getMessage());
    }
    System.out.println("Enregistrement des travails a faires ");
    }

    @Override
    public ArrayList<Classe> afficheLivre(String Table,String nom, String id) {
        ArrayList<Classe> list = new ArrayList<>();
        Classe data;
         BaseConnexion();
    String req=" select NomPers,periodicite,"+nom+",NomTaf,observation,semainePrevue,heure,date from personnes inner join acteur inner join pv inner join taf inner join "+Table+" on personnes.IdPers=acteur.IdPers and acteur.IdPv=pv.IdPv and pv.IdTaf=taf.IdTaf and taf."+id+"="+Table+"."+id+" ORDER BY date  ";
    try{
        sql.append(req);
        res=etat.executeQuery(sql.toString());
        while(res.next()){
            data = new Classe(res.getString("date"), res.getString("heure"), res.getString("semainePrevue"), res.getString("periodicite"), res.getString(3), res.getString("NomTaf"), res.getString("observation"), res.getString("NomPers"));
            list.add(data);
        }
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erreur de syntax "+e.getMessage());
    }
    System.out.println("Affichage du livre ");
    return list;
    }

    @Override
    public ArrayList<Classe> afficheAllHebdo(String table) {
        ArrayList<Classe> list = new ArrayList<>();
        Classe data;
         BaseConnexion();
    String req=" select * from "+table+" ";
    try{
        sql.append(req);
        res=etat.executeQuery(sql.toString());
        while(res.next()){
            data = new Classe(res.getString(2), res.getString(3));
            list.add(data);
        }
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erreur de syntax "+e.getMessage());
    }
    System.out.println(" Affichage des taf hebdomadaire ");
    return list;
    }

    @Override
    public ArrayList<Classe> afficheAllTrim(String table,String type) {
        ArrayList<Classe> list = new ArrayList<>();
        Classe data;
         BaseConnexion();
    String req=" select * from "+table+" where Type='"+type+"' ";
    try{
        sql.append(req);
        res=etat.executeQuery(sql.toString());
        while(res.next()){
            data = new Classe(res.getString(2), res.getString(3), res.getString(4), res.getString(5));
           list.add(data);
        }
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erreur de syntax "+e.getMessage());
    }
    System.out.println(" Affichage des taf trimestriel ");
    return list;
    }

    @Override
    public boolean DeleteAll(String table, String nom,String nomCond) {
        BaseConnexion();
    String req="delete from "+table+" where "+nomCond+"='"+nom+"'";
    try{
        sql.append(req);
        etat.executeUpdate(sql.toString());
        JOptionPane.showMessageDialog(null, "journalier supprimer");
    }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null, "j non suppprimer"+e.getMessage());        
    }
    System.out.println(" Suppression reussi ");
    return true;
    }

    @Override
    public void DeleteTaf(String nom) {
         BaseConnexion();
    String req="DELETE from taf where NomTaf='"+nom+"'";
    try{
        sql.append(req);
        etat.executeUpdate(sql.toString());
        System.out.println("personnes supprimer");
    }
    catch(SQLException e){
         System.out.println( "personnes non suppprimer"+e.getMessage());        
    }
   System.out.println(" Suppression des travails a faire ");
    }

    @Override
    public boolean modifierjour(String table,String nomJour,String nomnomCond,String valeur) {
        BaseConnexion();
    String req="update "+table+" set "+nomnomCond+"='"+valeur+"' where "+nomnomCond+"='"+nomJour+"'";
    try{
        sql.append(req);
        etat.executeUpdate(sql.toString());
       System.out.println(  "journalier modifier");
        
    }
    catch(SQLException e){
        System.out.println(  "journalier non modifier");
    }
    System.out.println(" Modification du jour ");
    return true;}
    
    @Override
    public int AddMaxAjout(String table, String NomJour, String condition){
         BaseConnexion();
         int n = 0;
    String req=" select * from "+table+" where "+NomJour+"='"+condition+"' ";
    try{
        sql.append(req);
        res=etat.executeQuery(sql.toString());
        while(res.next()){
            n=res.getInt(1);
        }
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erreur de syntax "+e.getMessage());
    }
        System.out.println(" AddMaxAjout ");

    return n;
    }
    @Override
    public boolean modifierHeb(String table,String nomJour,String nomH, String nomJ,String valeurNomH, String valeurJ) {
        BaseConnexion();
    String req="update "+table+" set "+nomH+"='"+valeurNomH+"',"+nomJ+"='"+valeurJ+"' where "+nomH+"='"+nomJour+"'";
    try{
        sql.append(req);
        etat.executeUpdate(sql.toString());
       System.out.println("Hebdo modifier");
        
    }
    catch(SQLException e){
        System.out.println( "journalier non modifier");
    }
        System.out.println(" Modification hebdomadaire ");
    return true;}
    
    @Override
    public ArrayList<Classe> afficheLivreRech(String Table,String nom, String id,String cond,String text) {
        ArrayList<Classe> list = new ArrayList<>();
        Classe data;
         BaseConnexion();
    String req=" select NomPers,periodicite,"+nom+",NomTaf,observation,semainePrevue,heure,date from personnes inner join acteur inner join pv inner join taf inner join "+Table+" on personnes.IdPers=acteur.IdPers and acteur.IdPv=pv.IdPv and pv.IdTaf=taf.IdTaf and taf."+id+"="+Table+"."+id+" where "+cond+" LIKE'"+text+"%'ORDER BY periodicite DESC ";
    try{
        sql.append(req);
        res=etat.executeQuery(sql.toString());
        while(res.next()){
            data = new Classe(res.getString("date"), res.getString("heure"), res.getString("semainePrevue"), res.getString("periodicite"), res.getString(3), res.getString("NomTaf"), res.getString("observation"), res.getString("NomPers"));
            list.add(data);
        }
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erreur de syntax "+e.getMessage());
    }
        System.out.println(" Affichage des recherches dans livre ");

    return list;
    }

    @Override
    public ArrayList<Classe> afficheToutMen(String table) {
        ArrayList<Classe> list = new ArrayList<>();
        Classe data;
         BaseConnexion();
    String req=" select * from "+table+" ";
    try{
        sql.append(req);
        res=etat.executeQuery(sql.toString());
        while(res.next()){
            data = new Classe(res.getString(2),res.getString(3));
            list.add(data);
        }
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erreur de syntax "+e.getMessage());
    }
    System.out.println(" Affichage affichToutMen ");
return list;
    }

    @Override
    public ArrayList<Classe> afficheToutTri(String type) {
        ArrayList<Classe> list = new ArrayList<>();
        Classe data;
         BaseConnexion();
    String req=" select * from trisem where Type='"+type+"' ";
    try{
        sql.append(req);
        res=etat.executeQuery(sql.toString());
        while(res.next()){
            data = new Classe(res.getString(2),res.getString(3), res.getString(4), res.getString(5));
            list.add(data);  
        }
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erreur de syntax "+e.getMessage());
    }
        System.out.println(" Affichage AffichToutTri ");
    return list;
    }

    @Override
    public void AddNotes(String date,String periode,String equipement,String type,String commentaire) {
        BaseConnexion();
    String req=" insert into notes (date,periode,equipement,type,commentaire) values ('"+date+"','"+periode+"','"+equipement+"','"+type+"','"+commentaire+"') ";
    try{
        sql.append(req);
        etat.executeUpdate(sql.toString());
        System.out.println("Note du "+periode+" Ajoutee");
       // JOptionPane.showMessageDialog(null, "Personne inserer");
       
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Note non inserer");
         System.out.println(e.getMessage());
    }
        System.out.println(" AddNotes ");

    }
    @Override
    public ArrayList<Classe> afficheNotes() {
        ArrayList<Classe> list = new ArrayList<>();
        Classe data;
         BaseConnexion();
    String req=" select * from notes ";
    try{
        sql.append(req);
        res=etat.executeQuery(sql.toString());
        while(res.next()){
            data = new Classe(res.getString(2),"","",res.getString(3), res.getString(4), res.getString(5), res.getString(6),"");
            list.add(data);  
        }
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erreur de syntax "+e.getMessage());
    }
        System.out.println(" Affichage Notes ");
    return list;
    }

    @Override
    public ArrayList<Classe> affichePers() {
        ArrayList<Classe> list = new ArrayList<>();
        Classe data;
         BaseConnexion();
    String req=" select * from personnes "; 
    try{
        sql.append(req);
        res=etat.executeQuery(sql.toString());
        while(res.next()){
            data = new Classe(res.getString(2));
            list.add(data);  
        }
    }
    catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erreur de syntax "+e.getMessage());
    }
        System.out.println(" Affichage des personnels ");
    return list;
    }
}