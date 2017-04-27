package es.ucm.fdi.iw.customValidation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;

import org.springframework.validation.Errors;
import es.ucm.fdi.iw.validation.Contrasenia;

public class ValidarContrasenia  implements Validator {
 
    public boolean supports(Class<?> clazz) {
        return Contrasenia.class.isAssignableFrom(clazz);
    }
 
    public void validate(Object target, Errors errors) {
        Contrasenia Contrasenia = (Contrasenia)target;
        String password = Contrasenia.getContrasenia();
        String confPassword = Contrasenia.getConfContrasenia(); 
        //Validacion de si son iguales
        if(!password.equals(confPassword)){
            errors.rejectValue("contraseniaRep","La confirmacion no coincide con la contraseña escrita");
        } 
    }

	@Override
	public ExecutableValidator forExecutables() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BeanDescriptor getConstraintsForClass(Class<?> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Set<ConstraintViolation<T>> validate(T arg0, Class<?>... arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Set<ConstraintViolation<T>> validateProperty(T arg0, String arg1, Class<?>... arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Set<ConstraintViolation<T>> validateValue(Class<T> arg0, String arg1, Object arg2, Class<?>... arg3) {
		// TODO Auto-generated method stub
		return null;
	}
}