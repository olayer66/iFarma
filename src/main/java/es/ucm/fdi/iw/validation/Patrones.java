package es.ucm.fdi.iw.validation;

public class Patrones {
	//Patrones
	public static final String direccion="^[\\p{L}0-9\\-'./º ]+";
	public static final String texto="^[a-zA-Z0-9 ]+$";
	public static final String usuario="^[a-zA-Z0-9]+$";
	public static final String textoEspecial="^[\\p{L}\\-'. ]+";
	public static final String numero="[0-9]*";
	public static final String numColegiado="\\d{2}/\\d{2}/\\d{6}";
	
	//Mesajes de salida patrones
	public static final String menDireccion="No puede contener caracteres especiales(<,>,|,#,&,$,etc)";
	public static final String menTexto="Solo puede contener letras, numeros y espacios";
	public static final String menUsuario="Solo puede contener letras y numeros";
	public static final String menTextoEspecial="Solo puede contener letras y signos de puntuación";
	public static final String menNumero="Solo puede contener numeros";
	public static final String menNumColegiado="El numero de colegiado no es valido, debe de seguir el formato nn/mm/pppppp";
	
	//Otros mensajes de salida
	public static final String menVacio="El campo esta vacio";
	public static final String menCodPostal="El codigo postal ha de tener 5 digitos";
	public static final String menContrasenia="La contraseña debe de tener entre 4 y 8 caracteres alfanumericos";
	public static final String menTelefono="El telefono debe de tener 9 digitos";
	public static final String menEmail="La direccion email no es correcta";
	public static final String menCodSeg="El codigo de seguridad ha de tener tres digitos";
}
