package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import beans.Emp;
@Repository
public class EmpDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Emp> getAllEmps(){
		return jdbcTemplate.query("select * from employee order by empid", new ResultSetExtractor<List<Emp>>() {

			@Override
			public List<Emp> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Emp> emps=new ArrayList<Emp>();
				while(rs.next()) {
					Emp emp=new Emp();
					emp.setEmpId(rs.getInt(1));
					emp.setEmpName(rs.getString(2));
					emp.setDateOfJoining(rs.getDate(3));
					emp.setCar(rs.getString(6));
					emps.add(emp);
				}
				return emps;	
			}
		});
	}
	
	public void insertEmp(Emp emp) {
		jdbcTemplate.execute("insert into employee values(?,?,?,?,?,?)",new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, emp.getEmpId());
				ps.setString(2, emp.getEmpName());
				ps.setDate(3, new Date(emp.getDateOfJoining().getTime()));
				ps.setString(4, String.valueOf(emp.getGender()));
				ps.setString(5, emp.getCity());
				ps.setString(6, emp.getCar());
				return ps.execute();
			}
		});
	}
		
	public Emp getEmpById(int empId) {
		Emp emp=new Emp();
		return jdbcTemplate.query("select * from employee where empid="+empId, new ResultSetExtractor<Emp>() {

			@Override
			public Emp extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				while(rs.next()) {
					emp.setEmpId(rs.getInt(1));
					emp.setEmpName(rs.getString(2));
					SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy/dd/MM");
					java.util.Date date = null;
					try {
						date = dateFormat.parse(dateFormat.format(rs.getDate(3)));
					} catch (java.text.ParseException e) {
						e.printStackTrace();
					}
					emp.setDateOfJoining(date);
					emp.setGender(rs.getString(4).charAt(0));
					emp.setCity(rs.getString(5));
					emp.setCar(rs.getString(6));
				}
				return emp;
			}
			
		});	
	}
	
	public void delete(int empId) {
		jdbcTemplate.execute("delete from employee where empid=?",new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, empId);
				return ps.execute();
			}
			
		});
	}
	
	public Emp searchEmpById(int empId) {
		String query="select * from employee where empid="+empId;
		Emp emp=jdbcTemplate.queryForObject(query, new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int arg1) throws SQLException {
				Emp emp=new Emp();
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setDateOfJoining(rs.getDate(3));
				emp.setGender(rs.getString(4).charAt(0));
				emp.setCity(rs.getString(5));
				emp.setCar(rs.getString(6));
				return emp;
			}
			
		});
		return emp;
	}
	
	public void updateEmp(Emp emp) {
		jdbcTemplate.execute("update employee set empName=?,doj=?,gender=?,city=?,car=? where empId=?",new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, emp.getEmpName());
				ps.setDate(2, new Date(emp.getDateOfJoining().getTime()));
				ps.setString(3, String.valueOf(emp.getGender()));
				ps.setString(4, emp.getCity());
				ps.setString(5, emp.getCar());
				ps.setInt(6, emp.getEmpId());
				return ps.execute();
			}
		});

	}
}
