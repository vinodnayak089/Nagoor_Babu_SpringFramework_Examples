package com.gtmarttiles.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.gtmarttiles.entity.Tiles;

public class TilesDaoImpl implements TilesDao {
	
	HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	

	@Transactional
	@Override
	public String insert(Tiles tiles) {
		String status="";
        try {
        	hibernateTemplate.save(tiles);
            status="insertion success";
		} catch (Exception e) {
            status="insertion failed";
            e.printStackTrace();
		}  
		return status;
	}

	@Override
	public String update(Tiles tiles) {
		return null;

	}

	@Override
	public void delete(String designNo) {

	}

	@Override
	public Tiles get(String designNo) {
		return null;
	}

}
