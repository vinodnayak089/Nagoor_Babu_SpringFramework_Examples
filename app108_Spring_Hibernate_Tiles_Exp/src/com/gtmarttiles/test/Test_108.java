package com.gtmarttiles.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gtmarttiles.dao.TilesDao;
import com.gtmarttiles.entity.Tiles;

public class Test_108 {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/com/gtmarttiles/resources/applicationContext.xml");
        TilesDao dao= (TilesDao) context.getBean("tilesDaoImpl");
		Tiles tiles = new Tiles();
		tiles.setBoxSize("12X18");
		tiles.setDesignNo("125");
		tiles.setPrize(255);
		String status;
		status=dao.insert(tiles);
		System.out.println(status);
		
	}

}
