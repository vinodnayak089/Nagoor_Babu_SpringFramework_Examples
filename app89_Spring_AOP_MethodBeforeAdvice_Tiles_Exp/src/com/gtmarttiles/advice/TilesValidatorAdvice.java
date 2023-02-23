package com.gtmarttiles.advice;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;
import com.gtmarttiles.dto.Quantity;
import com.gtmarttiles.dto.Tiles;

public class TilesValidatorAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] params, Object target) throws Throwable {
		Tiles tile= (Tiles)params[0];
		Quantity quantity= tile.getQuantity();
		
        System.out.println("*** Validator method ***"+method.getName());
		
		if(!(tile.getDesignNo()!= null && tile.getDesignNo().matches("^[a-zA-Z0-9]*$"))) {
			System.out.println("Should not be null and should alphanumeric");
		}
		
		if(!(tile.getBoxSize()!= null && tile.getBoxSize().equals("12X18"))) {
			System.out.println("Should be equal to 12X18");
		}
		if(!(quantity.getL()>= 0 && quantity.getL()<500)) {
			System.out.println("Light range should be in between 1 to 499");
		}
		if(!(quantity.getHl()>= 0 && quantity.getHl()<500)) {
			System.out.println("Highlighter range should be in between 1 to 499");
		}
		if(!(quantity.getD()>= 0 && quantity.getD()<500)) {
			System.out.println("Dark range should be in between 1 to 499");
		}
		if(!(quantity.getF()>= 0 && quantity.getF()<500)) {
			System.out.println("Flooring should be in between 1 to 499");
		}
		if(tile.getPrize()!=250) {
			System.out.println("Should be equal to 250");
		}
		if(!(tile.getEmail()!= null && tile.getEmail().endsWith("@gtmarttiles.com"))) {
			System.out.println("Should Contains @gtmarttiles.com");
		}
		if(!(tile.getMobileNum()!= null && tile.getMobileNum().startsWith("91-"))) {
			System.out.println("Should Contains 91-");
		}
		
		
		
	}

}
