package help;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;

public class Help {
	
	public void openHelp() throws MalformedURLException, HelpSetException{
		// Carga el fichero de ayuda
		File fichero = new File("help.hs");
		URL hsURL = fichero.toURI().toURL();

		// Crea el HelpSet
		HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
		
		HelpBroker helpBroker = helpset.createHelpBroker();
		
		// Ayuda al hacer click en el JMenuItem itemAyuda. 
		helpBroker.enableHelpOnButton(itemAyuda, "aplicacion", helpset);

		// Ayuda al pulsar F1 sobre la ventana principal 
		helpBroker.enableHelpKey(principal.getContentPane(), "ventana_principal", helpset);

		// Ayuda al pulsar F1 sobre la ventana secundaria 
		helpBroker.enableHelpKey(secundaria.getContentPane(), "ventana_secundaria", helpset);
	}
}
