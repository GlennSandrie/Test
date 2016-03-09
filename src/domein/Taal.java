package domein;
import  java.util.Locale;
import java.util.ResourceBundle;


public class Taal {

	private Locale locale;
	private final ResourceBundle resourceBundle;
	
	public Taal (String l){
		if (l.equals("nl")) this.locale = new Locale("nl");
		if (l.equals("en")) this.locale = new Locale("en");
		if (l.equals("fr")) this.locale = new Locale("fr");	 
		resourceBundle = ResourceBundle.getBundle("resource", locale);		
	}
	
	public String getText(String key){
		return resourceBundle.getString(key);
	}
}