package com.gtmarttiles.test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gtmarttiles.dao.Repo;
import com.gtmarttiles.dto.Quantity;
import com.gtmarttiles.dto.Tiles;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context=new ClassPathXmlApplicationContext("/com/gtmarttiles/resources/applicationContext.xml");
		Repo repo=(Repo)context.getBean("tilesdao");
		while(true)
		{
			System.out.println();
			System.out.println("**** Welcome to GT MART Tiles ****");
			Scanner sc=new Scanner(System.in);
			System.out.println("Select the available options :");
			System.out.println("1. Add tiles");
			System.out.println("2. Search tiles");
			System.out.println("3. Update tiles");
			System.out.println("4. Delete tiles");
			System.out.println("5. Exit");
            int option=sc.nextInt();
        	Tiles tiles=new Tiles();
        	String status="";
        	String designNo="";
            switch(option)
            {
            case 1: 
            	System.out.println("Addition");
        		Quantity quantity=new Quantity();
        		System.out.println("Enter box size");
        		tiles.setBoxSize(sc.next());
        		System.out.println("Enter Design No");
        		tiles.setDesignNo(sc.next());
        		System.out.println("Enter L value");
        		quantity.setL(sc.nextInt());
        		System.out.println("Enter HL value");
        		quantity.setHl(sc.nextInt());
        		System.out.println("Enter D value");
        		quantity.setD(sc.nextInt());
        		System.out.println("Enter F value");
        		quantity.setF(sc.nextInt());
        		tiles.setQuantity(quantity);
        		System.out.println("Enter Prize value");
        		tiles.setPrize(sc.nextInt());
        		status=repo.add(tiles);
        		System.out.println(status);	
        		break;
            case 2:
            	System.out.println("Search");
            	System.out.println("Enter Design No ");
            	designNo=sc.next();
            	tiles=repo.searchtiles(designNo);
            	if(tiles==null)
            	{
            	    System.out.println("Design Number Does Not Existed");	
            	}
            	else System.out.println(tiles);
            	break;
            case 3:
            	System.out.println("Update");
            	System.out.println("Enter Design No ");
            	designNo=sc.next();
            	tiles=repo.searchtiles(designNo);
            	if(tiles==null)
            	{
            	    System.out.println("Design Number Does Not Existed");	
            	}
            	else {
            		Tiles newTiles=new Tiles();
            		Quantity OldQuantity=tiles.getQuantity();
            		Quantity newQuantity=new Quantity();
            		newTiles.setDesignNo(designNo);
            		System.out.println("Old Box Size :["+tiles.getBoxSize()+"] Enter New Value");
            	    newTiles.setBoxSize(sc.next());
            		System.out.println("Old Light :["+OldQuantity.getL()+"] Enter New Value");
                    newQuantity.setL(sc.nextInt());
                    System.out.println("Old HighLighter :["+OldQuantity.getHl()+"] Enter New Value");
                    newQuantity.setHl(sc.nextInt());    
                    System.out.println("Old Dark :["+OldQuantity.getD()+"] Enter New Value");
                    newQuantity.setD(sc.nextInt());    
                    System.out.println("Old Flooring :["+OldQuantity.getF()+"] Enter New Value");
                    newQuantity.setF(sc.nextInt());    
            		newTiles.setQuantity(newQuantity);
            		System.out.println("Old Prize :["+tiles.getPrize()+"] Enter New Value");
            	    newTiles.setPrize(sc.nextInt());
            	    status=repo.update(newTiles);
            	    System.out.println(status);
            	}
            	break;
            case 4:
            	System.out.println("Delete");
            	System.out.println("Enter Design No ");
            	designNo=sc.next();
            	status=repo.delete(designNo);
            	System.out.println(status);
            	break;
            case 5:
            	System.out.println("####Thanks for using Tiles application######");
            	System.exit(0);
            default:
            	System.out.println("Please provide a value between 1 to 5");
            	
            }
		}
	}

}
