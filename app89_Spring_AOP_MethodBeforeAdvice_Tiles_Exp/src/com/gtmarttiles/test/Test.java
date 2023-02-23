package com.gtmarttiles.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gtmarttiles.dto.Tiles;
import com.gtmarttiles.service.TilesService;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context=new ClassPathXmlApplicationContext("/com/gtmarttiles/resources/applicationContext.xml");
		Tiles tile= (Tiles)context.getBean("tilesBean");
		
		TilesService service= (TilesService) context.getBean("tilesProxy");
		service.displayTilesDetails(tile);
		service.getTilesDetails(tile);
	
	}
}
