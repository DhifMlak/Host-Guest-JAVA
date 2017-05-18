/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostguest;

import entites.Hote;
import entites.Offre;
import entites.Pack;
import entites.Reservation;
import entites.Sortie;
import entites.Voyageur;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import services.ServiceHote;
import services.ServicePack;
import services.ServiceReservation;
import services.ServiceSortie;
import services.ServiceVoyageur;
import utils.MyConnection;

/**
 *
 * @author Firas
 */
public class HostGuest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // MyConnection c=MyConnection.GetInstance();
        Pack pk = new Pack();
        Voyageur v = new Voyageur();
        ServiceVoyageur SV = new ServiceVoyageur();
        v = SV.GetVoyageurById(5);
        ServicePack SPK = new ServicePack();
        pk = SPK.getPackById(0);
        ServiceReservation SR =new  ServiceReservation();
        Hote h = new Hote();
        // Sortie s =new Sortie("kharja","carpe",7,"hjkhkh","jljlkjlhgl","bar","sortie",h);
        //Sortie k =new Sortie("pp", "lieu", 9, "description", "conditions", "typeSortie", 2, "typeOffre", h);
        Sortie SSS = new Sortie("titre15", "lieu", 5, "description", "conditions", "type3", "Sortie", h);
        Offre sp = new Sortie(14,"sortie1", "lieu1", 0, "description1", "conditions1", "typeSortie", "typeOffre", h);
     //   Reservation R1 = new Reservation(0, 6, 0, v, sp, pk);
       //         Reservation R2 = new Reservation(9,0, 5, 0, v, sp, pk);

                
      //SR.AjouterReservation(R1);

        ServiceSortie service_s = new ServiceSortie();
            service_s.AjouterSortie(SSS);
            /*
        service_s.getSortieById(14);
        sp = service_s.getSortieById(14).get(0);
        sp.setTitre("titre14");
        service_s.modifierSortie(sp);*/
      List<Reservation> ls = new ArrayList<>();
         ls = SR.getAllReservation();
for(int i = 0 ; i < SR.getAllReservation().size() ; i++){
    System.out.println(SR.getAllReservation().get(i).toString());
  //  service_s.SupprimerSortie(service_s.getAllSortie().get(i));
   
}
       

System.out.println(SR.getReservationById(8));
//SR.SupprimerReservation(R2);
//SR.modifierReservation(R2);
/*
service_s.SupprimerSortieById(7);*/

    }

}
