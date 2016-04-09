package domein;
import  java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author anjana
 */
public class Taal {

	private Locale locale;
	private final ResourceBundle resourceBundle;
	
    /**
     *
     * @param l
     */
    public Taal (String l){
		if (l.equalsIgnoreCase("nl")) this.locale = new Locale("nl");
		if (l.equalsIgnoreCase("en")) this.locale = new Locale("en");
		if (l.equalsIgnoreCase("fr")) this.locale = new Locale("fr");	 
		resourceBundle = ResourceBundle.getBundle("resource", locale);		
	}
	
    /**
     *
     * @param key
     * @return
     */
    public String getText(String key){
		return resourceBundle.getString(key);
	}
}