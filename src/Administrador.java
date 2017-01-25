/**
 * Clase del administrador del sistema. Solo hay un administrador por lo que
 * es un singleton.
 * @author Alba y Eva.
 *
 */
public class Administrador {
	private final String user;
	private final String password;
	private static Administrador admin;
	
	private Administrador(){
		user = "admin";
		password = "EvAlba";
		admin = this;
	}
	
	public static Administrador getAdmin(){
		if(admin == null){
			return new Administrador();
		}else{
			return admin;
		}
	}

	public String getPassword() {
		return password;
	}

	public String getUser() {
		return user;
	}

	public void crearMedico() {
		// TODO Auto-generated method stub
		
	}
	
	public void editarMedico(Medico medico) {
		// TODO Auto-generated method stub
		
	}
	
	public void eliminarMedico(Medico medico) {
		// TODO Auto-generated method stub
		
	}
	
	public void crearFarmacia(){
		
	}

	public void editarFarmacia(String cif) {
		// TODO Auto-generated method stub
		
	}
	
	public void eliminarFarmacia(Farmacia farmacia) {
		// TODO Auto-generated method stub
		
	}
	

}
