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
     * methode die de spelernamen van een bepaald spel uit de databank ophaald
     *
     * @param spel
     * @return lijst van spelers van het gekozen spel
     */
    public List<String> geefSpelersVanSpel(String spel)
    {
        List<String> spelerNamen = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL))
        {
            PreparedStatement query = conn.prepareStatement("SELECT spelerId FROM speler WHERE spelId = ?");
            query.setString(1, spel);
            try (ResultSet rs = query.executeQuery())
            {
                while (rs.next())
                {
                    String speler = rs.getString("spelerId");

                    spelerNamen.add(speler);
                }
            }
        } catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }

        return spelerNamen;
    }

    /**
     * methode die het geboorte jaar van de spelers uit de databank ophaalt
     *
     * @param speler
     * @return geboortejaar van een speler
     */
    public int geefGeboortejaar(String speler)
    {
        int geboortejaar = 0;
        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL))
        {
            PreparedStatement query = conn.prepareStatement("SELECT geboortejaar FROM speler WHERE spelerId = ?");
            query.setString(1, speler);
            try (ResultSet rs = query.executeQuery())
            {
                while (rs.next())
                {
                    geboortejaar = rs.getInt("geboortejaar");
                }
            }
        } catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }

        return geboortejaar;
    }

    /**
     * methode die de kleur van de spelers uit de databank ophaalt
     *
     * @param speler
     * @return
     */
    public String geefKleur(String speler)
    {
        String kleur = "";
        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL))
        {
            PreparedStatement query = conn.prepareStatement("SELECT kleur FROM speler WHERE spelerId = ?");
            query.setString(1, speler);
            try (ResultSet rs = query.executeQuery())
            {
                while (rs.next())
                {
                    kleur = rs.getString("kleur");
                }
            }
        } catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }

        return kleur;
    }

    public void opslaanSpeler(String spelNaam, Speler speler, int x, int y, int beurt, String doelkaarten)
    {
        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL))
        {
            PreparedStatement query = conn.prepareStatement("INSERT INTO speler (spelerId, spelId, kleur, geboortejaar, xPositie, yPositie, volgorde, doelkaarten) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            query.setString(1, speler.getNaam());
            query.setString(2, spelNaam);
            query.setString(3, speler.getKleur().getKleurNaam());
            query.setInt(4, speler.getGeboortejaar());
            query.setInt(5, x);
            query.setInt(6, y);
            query.setInt(7, beurt);
            query.setString(8, doelkaarten);
            query.executeUpdate();

        } catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }
    }
    
    public void updateSpeler(String spelNaam, String naam, int x, int y, int beurt, String doelkaarten)
    {
        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL))
        {
            PreparedStatement query = conn.prepareStatement("UPDATE speler SET xPositie = ?, yPositie = ?, volgorde = ?, doelkaarten = ? WHERE spelerId = ? AND spelId = ?");
            query.setInt(1, x);
            query.setInt(2, y);
            query.setInt(3, beurt);
            query.setString(4,doelkaarten);
            query.setString(5,naam);
            query.setString(6, spelNaam);
            query.executeUpdate();

        } catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }
    }
    
    public String[][] geefGegevensSpelers(int aantal, String spel)
    {
        String[][] gegevens = new String[aantal][5];
        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL))
        {
            PreparedStatement query = conn.prepareStatement("SELECT spelerId, xPositie, yPositie, volgorde, doelkaarten FROM speler WHERE spelId = ?");
            query.setString(1, spel);
            try (ResultSet rs = query.executeQuery())
            {
                int teller = 0;
                while (rs.next())
                {
                    gegevens[teller][0] = rs.getString("spelerId");
                    gegevens[teller][1] = String.format("%d",rs.getInt("xPositie"));
                    gegevens[teller][2] = String.format("%d",rs.getInt("yPositie"));
                    gegevens[teller][3] = String.format("%d",rs.getInt("volgorde"));
                    gegevens[teller][4] = rs.getString("doelkaarten");
                    teller++;
                }
            }
        } catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }

        return gegevens;
    }
}
