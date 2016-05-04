/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistentie;

import domein.Spel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anjana
 */
public class SpelMapper
{

    /**
     * methode die de spelnamen uit de databank ophaalt
     *
     * @return lijst van spelnamen uit de databank
     */
    public List<String> geefSpelnamen()
    {
        List<String> spelNamen = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL))
        {
            PreparedStatement query = conn.prepareStatement("SELECT spelId FROM spel");
            try (ResultSet rs = query.executeQuery())
            {
                while (rs.next())
                {
                    String spelId = rs.getString("spelId");
                    spelNamen.add(spelId);
                }
            }
        } catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }

        return spelNamen;
    }

    /**
     * methode kiezen van spel
     *
     * @param naam
     * @return gekozen spel
     */
    public Spel kiesSpel(String naam)
    {
        Spel spel = null;

        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL))
        {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM spel WHERE spelId = ?");
            query.setString(1, naam);
            try (ResultSet rs = query.executeQuery())
            {
                if (rs.next())
                {
                    //String spelbord = rs.getString("spelbord");
                    spel = new Spel(naam);
                }
            }
        } catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }

        return spel;
    }
    /**
     * methode die het spelbord wegschrijft naar de databank
     * @param spelnaam
     * @param spelbord 
     */
    public void opslaanSpelbord(String spelnaam, String spelbord)
    {
        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL))
        {
            PreparedStatement query = conn.prepareStatement("INSERT INTO spel (spelnaam, spelbord) VALUES (?, ?)");
            query.setString(1, spelnaam);
            query.setString(2, spelbord);
            query.executeUpdate();

        } catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }
    }
    
    public void updateSpelbord(String spelnaam, String spelbord)
    {
        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL))
        {
            PreparedStatement query = conn.prepareStatement("UPDATE spel SET spelbord = ? WHERE spelId = ?");
            query.setString(1, spelbord);
            query.setString(2, spelnaam);
            query.executeUpdate();

        } catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }
    }
    
    /**
     * 
     * @param naam
     * @return 
     */
    public String geefCodeSpelbord(String naam)
    {
        String spelbord = "";
        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL))
        {
            PreparedStatement query = conn.prepareStatement("SELECT spelbord FROM spel WHERE spelId = ?");
            query.setString(1, naam);
            try (ResultSet rs = query.executeQuery())
            {
                while (rs.next())
                {
                    spelbord = rs.getString("spelbord");
                }
            }
        } catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }

        return spelbord;
    }
}
