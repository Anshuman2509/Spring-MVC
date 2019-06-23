package validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CarValidator implements ConstraintValidator<IsValidCar, String> {
	private String validCars;
	@Override
	public void initialize(IsValidCar cars) {
		validCars=cars.listOfValidCars();
	}

	@Override
	public boolean isValid(String car, ConstraintValidatorContext arg1) {
		if(car==null)
		return false;
		if(car.matches(validCars))
			return true;
		else
			return false;
	}

}
