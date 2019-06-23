package service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.Automobile;
import dao.AutoDao;

@Service
public class AutoService {
	@Autowired
	private AutoDao autoDao;
	
	public List<Automobile> getAutos() throws ClassNotFoundException, SQLException{
		return autoDao.getAuto();
	}

}
