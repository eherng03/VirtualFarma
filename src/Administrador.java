
public class Administrador {
	private final String user = "admin";
	private final String password = "EvAlba";
	private static Administrador admin;
	
	
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

	public void editarFarmacia(Farmacia farmacia) {
		// TODO Auto-generated method stub
		
	}
	
	public void eliminarFarmacia(Farmacia farmacia) {
		// TODO Auto-generated method stub
		
	}
	

}
