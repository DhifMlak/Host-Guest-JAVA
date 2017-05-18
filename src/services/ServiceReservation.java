/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Offre;
import entites.Pack;
import entites.Reservation;
import entites.Voyageur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyConnection;

/**
 *
 * @author Dhif Abdelmlak
 */
public class ServiceReservation {

    Connection cnx;
    Statement stmt;

    public ServiceReservation() {
        cnx = MyConnection.GetInstance();
        try {
            stmt = cnx.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void AjouterReservation(Reservation reservation) throws SQLException {
        String req = "insert into reservations(etat,nbReservation,type,id_voyageur,id_offre,id_pack,date_Deb,date_Fin,id_Hote) values('" + reservation.getEtat() + "','" + reservation.getNbReservation() + "','" + reservation.getType() + "','" + reservation.getVoyageur().getId() + "','" + reservation.getOffre().getId() + "','" + reservation.getPack().getId() + "','" + reservation.getDate_Deb()+ "','" + reservation.getDate_Fin()+ "','" + reservation.getOffre().getHote().getId()+ "')";
        stmt.executeUpdate(req);

    }

    public List<Reservation> getAllReservation() throws SQLException {
        String req = "select * from reservations";
        ResultSet rs = stmt.executeQuery(req);
        List<Reservation> reservations = new ArrayList<Reservation>();
        Reservation reservation;
        Voyageur v;
        Pack p;
        Date date;
        Offre o;
        ServiceVoyageur SV = new ServiceVoyageur();

        ServicePack SPK = new ServicePack();
        ServiceOffre SO = new ServiceOffre();
        ServiceReservation SR = new ServiceReservation();
        while (rs.next()) {
            v = SV.GetVoyageurById(5);
            p = SPK.getPackById(0);
            o = SO.getOffreById(0);
          //  reservation = new Reservation(rs.getInt("id"), rs.getInt("etat"), rs.getInt("nbReservation"), rs.getInt("type"), v, o, p,rs.getString("date_Deb"),rs.getString("date_fin"));
                        reservation = new Reservation(rs.getInt("id"), rs.getInt("etat"), rs.getInt("nbReservation"), rs.getInt("type"), v, o, p,"","");

            reservations.add(reservation);

        }
        return reservations;

    }

    public Reservation getReservationById(int id) throws SQLException {
        String req = "select * from reservations  where id=" + id;
        ResultSet rs = stmt.executeQuery(req);
        List<Reservation> reservations = new ArrayList<Reservation>();
        Reservation reservation = null;
        Voyageur v = null;
        Pack p = null;
        Date date;
        Offre o = null;
        ServiceVoyageur SV = new ServiceVoyageur();

        ServicePack SPK = new ServicePack();
        ServiceOffre SO = new ServiceOffre();
        ServiceReservation SR = new ServiceReservation();

        while (rs.next()) {
            v = SV.GetVoyageurById(5);
            p = SPK.getPackById(0);
            o = SO.getOffreById(0);

            reservation = new Reservation(rs.getInt("id"), rs.getInt("etat"), rs.getInt("nbReservation"), rs.getInt("type"), v, o, p,rs.getString("date_Deb"),rs.getString("date_fin"));

        }
        return reservation;
    }

    public void modifierReservation(Reservation reservation) throws SQLException {
        String req = "update reservations set etat='" + reservation.getEtat() + "',nbReservation='" + reservation.getNbReservation()
                + "',type='" + reservation.getType() + "',id_voyageur=" + reservation.getVoyageur().getId()
                + ",id_offre='" + reservation.getOffre().getId() + "',id_pack='" + reservation.getPack().getId() + "',date_Deb='" + reservation.getDate_Deb()+ "',date_Fin='" + reservation.getDate_Fin()+"' WHERE id=" + reservation.getId();
        stmt.executeUpdate(req);
    }

    public void modifierReservationById(int id) throws SQLException {
        ServiceReservation SR = new ServiceReservation();
        Reservation reservation = null;
        reservation = SR.getReservationById(id);
        String req = "update reservations set etat='" + reservation.getEtat() + "',nbReservation='" + reservation.getNbReservation()
                + "',type='" + reservation.getType() + "',id_voyageur=" + reservation.getVoyageur().getId()
                + ",id_offre='" + reservation.getOffre().getId() + "',id_pack='" + reservation.getPack().getId() + "',date_Deb='" + reservation.getDate_Deb()+ "',date_Fin='" + reservation.getDate_Fin()+"' WHERE id=" + reservation.getId();
        stmt.executeUpdate(req);
    }

    public void SupprimerReservation(Reservation reservation) throws SQLException {
        String req = "delete from reservations where id=" + reservation.getId();
        stmt.executeUpdate(req);
        System.out.println("deleted");
    }

    public void SupprimerReservationById(int id) throws SQLException {
        String req = "delete from reservations where id=" + id;
        stmt.executeUpdate(req);
        System.out.println("deleted");
    }

}
