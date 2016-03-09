/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistentie;

import domein.Spel;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author anjana
 */
public class SpelMapper 
{

    /**
     *
     * @return
     */
    public List<String> geefSpelnamen()
    {
        List<String> spelNamen = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL))
        {
            PreparedStatement query = conn.prepareStatement("SELECT spelId FROM spel");
            try (ResultSet rs = query.executeQuery()) {
                while (rs.next()) {
                    String spelId = rs.getString("spelId");
                    spelNamen.add(spelId);
                }
            }
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
        return spelNamen;
    }
    
    /**
     *
     * @param naam
     * @return
     */
    public Spel kiesSpel(String naam)
    {
        Spel spel = null;

        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM spel WHERE spelId = ?");
            query.setString(1, naam);
            try (ResultSet rs = query.executeQuery()) {
                if (rs.next()) {
                    spel = new Spel(naam);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return spel;
    }
}
