/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistentie;

import domein.Speler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aïssa
 */
public class SpelerMapper
{

    /**
     *
     * @param spel
     * @return
     */
    public List<String> geefSpelersVanSpel(String spel)
    {
        List<String> spelerNamen = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL))
        {
            PreparedStatement query = conn.prepareStatement("SELECT spelerId FROM speler WHERE spelId = ?");
            query.setString(1, spel);
            try (ResultSet rs = query.executeQuery()) {
                while (rs.next()) {
                    String speler = rs.getString("spelerId");
                    
                    spelerNamen.add(speler);
                }
            }
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
        return spelerNamen;
    }
    
    public int geefGeboortejaar(String speler)
    {
        int geboortejaar=0;
        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL))
        {
            PreparedStatement query = conn.prepareStatement("SELECT geboortejaar FROM speler WHERE spelerId = ?");
            query.setString(1, speler);
            try (ResultSet rs = query.executeQuery()) {
                while (rs.next()) {
                    geboortejaar = rs.getInt("geboortejaar");
                }
            }
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
        return geboortejaar;
    }
    
    public String geefKleur(String speler)
    {
        String kleur = "";
        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL))
        {
            PreparedStatement query = conn.prepareStatement("SELECT kleur FROM speler WHERE spelerId = ?");
            query.setString(1, speler);
            try (ResultSet rs = query.executeQuery()) {
                while (rs.next()) {
                    kleur = rs.getString("kleur");
                }
            }
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
        return kleur;
    }
    
    /**
     *
     * @param speler
     */
    public void registreerSpeler(Speler speler) {

        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("INSERT INTO speler (spelerId, kleur, geboortejaar)"
                    + "VALUES (?, ?, ?)");
            query.setString(1, speler.getNaam());
            query.setString(2, speler.getKleur().getKleurNaam());
            query.setInt(3, speler.getGeboortejaar());
            
            query.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    
}
