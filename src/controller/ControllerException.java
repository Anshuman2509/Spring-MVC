package controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerException {
	@ExceptionHandler(value = ArithmeticException.class)
	public String aa() {
		return "arithemetic";
	}
	@ExceptionHandler(value = ArrayIndexOutOfBoundsException.class)
	public String bb() {
		return "arrayIndexBound";
	}
	@ExceptionHandler(value = Exception.class)
	public String cc() {
		return "exception";
	}
}

