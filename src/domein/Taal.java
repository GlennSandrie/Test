package domein;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author anjana
 */
public class Taal
{

    private Locale locale;
    private final ResourceBundle resourceBundle;

    /**
     * constructor, stelt de juiste taal in
     *
     * @param l
     */
    public Taal(String l)
    {
        if (l.equalsIgnoreCase("nl"))
        {
            this.locale = new Locale("nl");
        }
        if (l.equalsIgnoreCase("en"))
        {
            this.locale = new Locale("en");
        }
        if (l.equalsIgnoreCase("fr"))
        {
            this.locale = new Locale("fr");
        }
        resourceBundle = ResourceBundle.getBundle("resource", locale);
    }

    /**
     * methode die de tekst van een recourcebundle retourneert
     *
     * @param key
     * @return de juiste tekst in de juiste gekozen taal
     */
    public String getText(String key)
    {
        return resourceBundle.getString(key);
    }
}
