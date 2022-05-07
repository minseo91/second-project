package alcohol.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import alcohol.mvc.dto.FactoryDTO;
import alcohol.mvc.util.DbUtil;

public class FactoryDAOImpl implements FactoryDAO {
	
//private Properties proFile = new Properties();	
//	/**
//	 * dbQuery.properties 로딩해서 Properties객체에 저장 !!
//	 * */
//	public FactoryDAOImpl() {
//		try {
//			//proFile.load(new FileInputStream("src/~~"));
//			
//			//현재 프로젝트가 런타임(실행)될때, 즉 서버에서 실행될때 classes폴더의 위치를 동적으로 가져와서 경로를 설정해야한다.
//			
//			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));
//			
//			String value = proFile.getProperty("elec.select");
//			System.out.println("value = " + value);
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	

	@Override
	public List<FactoryDTO> factoryAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FactoryDTO> list = new ArrayList<FactoryDTO>();
		
		String sql = "SELECT * FROM FACTORY";
		
		try {
			con = DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				FactoryDTO factory = new FactoryDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				
				list.add(factory);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return list;
	}

	@Override
	public FactoryDTO factorySelect(String name) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		FactoryDTO factory = null;
		
		String sql = "SELECT * FROM FACTORY WHERE F_NAME=?";
		
		try {
			
			con = DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, name);		
			rs = ps.executeQuery();
			
			if(rs.next()) {
				factory = new FactoryDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return factory;

	}

}
