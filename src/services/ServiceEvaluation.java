/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Evaluation;
import entites.Hote;
import entites.Offre;
import entites.Voyageur;
import java.sql.Array;
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
public class ServiceEvaluation {
   Connection cnx;
    Statement stmt;
    public ServiceEvaluation() {
        cnx=MyConnection.GetInstance();
        try {
            stmt=cnx.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvaluation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Evaluation> getEvaluationByOffre(Offre offre) throws SQLException{
        String req="select * from evaluations where id_offre="+offre.getId();
        ResultSet rs = stmt.executeQuery(req);
        List<Evaluation> evaluations= new ArrayList<Evaluation>();
        Evaluation evaluation;
        ServiceVoyageur serviceVoyageur=new ServiceVoyageur();
        while(rs.next()) {
            Voyageur voyageur = serviceVoyageur.GetVoyageurById(rs.getInt(5));
            evaluation = new Evaluation(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), voyageur);
            evaluations.add(evaluation);
        }
        return evaluations;
    }
    
    public void ajouterEvaluation(Offre offre, Voyageur voyageur,Evaluation evaluation) throws SQLException {
        String req="insert into evaluations(titre,note,commentaire,id_voyageur,id_offre) values('"+evaluation.getTitre()+"',"+evaluation.getNote()+",'"+evaluation.getCommantaire()+"',"+voyageur.getId()+","+offre.getId()+")";
        stmt.executeUpdate(req);
    }
    
    
}
