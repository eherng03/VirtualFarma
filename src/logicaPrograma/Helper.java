package logicaPrograma;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.JButton;

public class Helper {
	
	private static Helper help;
	
	private Helper(){
	}
	
	public static Helper getInstance(){
		if(help == null){
			help = new Helper();
		}
		return help;
	}
	
	public void openHelp(JButton button, String target) throws MalformedURLException, HelpSetException{
		// Carga el fichero de ayuda
		File fichero = new File("help/help.hs");
		URL hsURL = fichero.toURI().toURL();

		// Crea el HelpSet
		HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
		HelpBroker helpBroker = helpset.createHelpBroker();
		
		// Ayuda al hacer click en el button 
		helpBroker.enableHelpOnButton(button, target, helpset);
	}
}
