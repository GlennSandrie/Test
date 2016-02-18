/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.time.LocalDate;

/**
 *
 * @author anjana
 */
public class Speler 
{
    private String spelerId;
    private String voornaam;
    private String familienaam;
    private String email;
    private String wachtwoord;
    private LocalDate geboortedatum;
    private int score;
    private boolean adminrechten;

    public Speler(String spelerId, String voornaam, String familienaam, String email, String wachtwoord, LocalDate geboortedatum, int score, boolean adminrechten) 
    {
        this.spelerId = spelerId;
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.email = email;
        this.wachtwoord = wachtwoord;
        this.geboortedatum = geboortedatum;
        this.score = score;
        this.adminrechten = adminrechten;
    }

    private void controleerId(String id)
    {
        if (id.equals(""))
            throw new IllegalArgumentException("Id mag niet leeg zijn!");
    }
    public String getSpelerId() 
    {
        return spelerId;
    }
    public void setSpelerId(String spelerId) 
    {
        this.spelerId = spelerId;
    }

    private void controleerVoornaam(String vnaam)
    {
        if (vnaam.equals(""))
            throw new IllegalArgumentException("De voornaam mag niet leeg zijn!");
    }
    public String getVoornaam() 
    {
        return voornaam;
    }
    public void setVoornaam(String voornaam) 
    {
        this.voornaam = voornaam;
    }
    
    private void controleerFamilienaam(String fnaam)
    {
        if (fnaam.equals(""))
            throw new IllegalArgumentException("De familienaam mag niet leeg zijn!");
    }
    public String getFamilienaam() 
    {
        return familienaam;
    }
    public void setFamilienaam(String familienaam) 
    {
        this.familienaam = familienaam;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getWachtwoord() 
    {
        return wachtwoord;
    }
    public void setWachtwoord(String wachtwoord) 
    {
        this.wachtwoord = wachtwoord;
    }

    
    public LocalDate getGeboortedatum() 
    {
        return geboortedatum;
    }
    public void setGeboortedatum(LocalDate geboortedatum) 
    {
        this.geboortedatum = geboortedatum;
    }
    
    public int getScore() 
    {
        return score;
    }
    public void setScore(int score) 
    {
        this.score = score;
    }
    
    public boolean isAdminrechten() 
    {
        return adminrechten;
    }
    public void setAdminrechten(boolean adminrechten) 
    {
        this.adminrechten = adminrechten;
    }
    
 
}
