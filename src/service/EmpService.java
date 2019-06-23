package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.Emp;
import dao.EmpDao;
@Service
public class EmpService {
	@Autowired
	private EmpDao dao;
	
	public List<Emp> getEmps(){
		return dao.getAllEmps();
	}
	
	public void save(Emp emp) {
		dao.insertEmp(emp);
	}
	public Emp getEmpById(int empId) {
		return dao.getEmpById(empId);
	}
	public void empDelete(int empId) {
		dao.delete(empId);
	}
	public Emp searchEmp(int id) {
		return dao.searchEmpById(id);
	}
	public void updateEmp(Emp emp) {
		dao.updateEmp(emp);
	}
}
