package es.ucm.fdi.iw.customValidation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import es.ucm.fdi.iw.validation.ValidarPaciente;

@Component
public class ValidarContrasenia  implements Validator {
 
    public boolean supports(Class<?> clazz) {
        return ValidarPaciente.class.isAssignableFrom(clazz);
    }
 
    public void validate(Object target, Errors errors) {
        ValidarPaciente Contrasenia = (ValidarPaciente)target;
        String password = Contrasenia.getContrasenia();
        String confPassword = Contrasenia.getContraseniaRep(); 
        //Validacion de si son iguales
        if(!password.equals(confPassword)){
            errors.rejectValue("contraseniaRep","messageCode","La confirmacion no coincide con la contraseña escrita");
        } 
    }
}