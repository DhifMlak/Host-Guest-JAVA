/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Offre;
import entites.Pack;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyConnection;

/**
 *
 * @author Firas
 */
public class ServicePackOffre {
    Connection cnx;
    Statement stmt;
    public ServicePackOffre() {
        cnx=MyConnection.GetInstance();
        try {
            stmt=cnx.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePackOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Offre> GetOffresByPack(Pack pack) throws SQLException {
        String req="select * from pack_offre where id_pack="+pack.getId();
        ResultSet rs = stmt.executeQuery(req);
        List<Offre> offres = new ArrayList<Offre>();
        Offre offre;
        ServiceOffre serviceOffre = new ServiceOffre();
        while (rs.next()) {
            offre=serviceOffre.getOffreById(rs.getInt(3));
            offres.add(offre);
        }
        return offres;
    } 
    public void AddOffreToPack(Offre offre,Pack pack) throws SQLException {
        String req="insert into pack_offre(id_pack,id_offre) values("+pack.getId()+","+offre.getId()+")";
        stmt.executeUpdate(req);
    }
    public void DeleteOffreFromPack(Offre offre, Pack pack) throws SQLException {
        String req="delete from pack_offre where id_pack="+pack.getId()+" and id_offre="+offre.getId();
        stmt.executeUpdate(req);
    }
    
}
