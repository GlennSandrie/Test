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
    
    /**
     *
     * @param speler
     */
    public void registreerSpeler(Speler speler) {

        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("INSERT INTO speler (spelerId)"
                    + "VALUES (?)");
            query.setString(1, speler.getNaam());
//            query.setString(2, speler.getVoornaam());
//            query.setString(3, speler.getEmailadres());
            
            query.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
