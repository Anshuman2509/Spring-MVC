package validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CarValidator.class)  
@Target( { ElementType.METHOD, ElementType.FIELD } )  
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidCar {
	
	//include this property(any name) to make the annotation parameterized
	String listOfValidCars();
	//error message
	public String message() default "The values of car can only be Mercedes,Audi,BMW";
	//represents group of constraints     
    public Class<?>[] groups() default {};  
    //represents additional information about annotation  
    public Class<? extends Payload>[] payload() default {}; 
	
}
