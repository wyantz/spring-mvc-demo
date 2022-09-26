/**
 * 
 */
package com.prodemy.springmvc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.prodemy.springmvc.dao.MahasiswaDao;
import com.prodemy.springmvc.model.Mahasiswa;

/**
 * @author wyant
 *
 */
@Repository
public class MahasiswaDaoImpl implements MahasiswaDao {
	private Connection con = null;
	private String url = "jdbc:postgresql://localhost:54321/akademik";
	private String username = "postgres";
	private String password = "postgres";

	public MahasiswaDaoImpl() {
		try {
			Class.forName("org.postgresql.Driver");			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws Exception {
		if (con!=null) {
			if (con.isClosed()) {
				con = DriverManager.getConnection(url, username, password);
			}
		} else {
			con = DriverManager.getConnection(url, username, password);
		}
		return con;
	}
	
	@Override
	public Mahasiswa findById(String id) throws Exception {
		Mahasiswa result = null;

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			StringBuilder query = new StringBuilder("SELECT * FROM task1.mahasiswa WHERE mhs_id=?");
			ps = getConnection().prepareStatement(query.toString());
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = new Mahasiswa();
				result.setId(rs.getString("MHS_ID"));
				result.setNim(rs.getString("MHS_NIM"));
				result.setNama(rs.getString("MHS_NAMA"));
				result.setAlamat(rs.getString("MHS_ALAMAT"));
			}
		} finally {
			try {
				rs.close();
			} catch (Exception ignored) {}
			try {
				ps.close();
			} catch (Exception ignored) {}
		}
		
		return result;
	}

	@Override
	public void deleteById(String id) throws Exception {
		PreparedStatement ps = null;
		
		try {
			StringBuilder query = new StringBuilder("DELETE FROM task1.mahasiswa WHERE \"MHS_ID\"=?");
			ps = getConnection().prepareStatement(query.toString());
			ps.setString(1, id);
			ps.executeUpdate();
		} finally {
			try {
				ps.close();
			} catch (Exception ignored) {}			
		}
	}

	@Override
	public void insert(Mahasiswa mhs) throws Exception {
		PreparedStatement ps = null;
		
		try {
			StringBuilder query = new StringBuilder("INSERT INTO task1.mahasiswa (mhs_id,mhs_nim,mhs_nama,mhs_alamat) VALUES (?,?,?,?)");
			ps = getConnection().prepareStatement(query.toString());
			ps.setString(1, mhs.getId());
			ps.setString(2, mhs.getNim());
			ps.setString(3, mhs.getNama());
			ps.setString(4, mhs.getAlamat());
			ps.executeUpdate();
		} finally {
			try {
				ps.close();
			} catch (Exception ignored) {}			
		}
	}

	@Override
	public void update(Mahasiswa mhs) throws Exception {
		PreparedStatement ps = null;
		
		try {
			StringBuilder query = new StringBuilder("UPDATE task1.mahasiswa SET MHS_NIM=?, MHS_NAMA=?, MHS_ALAMAT=? WHERE MHS_ID=?");
			ps = getConnection().prepareStatement(query.toString());
			ps.setString(1, mhs.getNim());
			ps.setString(2, mhs.getNama());
			ps.setString(3, mhs.getAlamat());
			ps.setString(4, mhs.getId());
			ps.executeUpdate();
		} finally {
			try {
				ps.close();
			} catch (Exception ignored) {}			
		}
	}

	@Override
	public List<Mahasiswa> findAll() throws Exception {
		List<Mahasiswa> result = null;

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			StringBuilder query = new StringBuilder("SELECT * FROM task1.mahasiswa");
			ps = getConnection().prepareStatement(query.toString());
			rs = ps.executeQuery();
			if (rs.next()) {
				result = new ArrayList<>();
				do {
					Mahasiswa mhs = new Mahasiswa();
					mhs.setId(rs.getString("MHS_ID"));
					mhs.setNim(rs.getString("MHS_NIM"));
					mhs.setNama(rs.getString("MHS_NAMA"));
					mhs.setAlamat(rs.getString("MHS_ALAMAT"));
					
					result.add(mhs);
				} while (rs.next());
			}
		} finally {
			try {
				rs.close();
			} catch (Exception ignored) {}
			try {
				ps.close();
			} catch (Exception ignored) {}
		}
		
		return result;	}

}
