package es.ucm.fdi.iw.controller.resp;

public class RespLogin {
	private boolean acceso;
	private String role;
	public boolean isAcceso() {
		return acceso;
	}
	public void setAcceso(boolean acceso) {
		this.acceso = acceso;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
