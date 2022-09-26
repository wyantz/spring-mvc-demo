/**
 * 
 */
package com.prodemy.springmvc.model;

/**
 * @author wyant
 *
 */
public class Mahasiswa {
	private String id;
	private String nim;
	private String nama;
	private String alamat;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the nim
	 */
	public String getNim() {
		return nim;
	}
	/**
	 * @param nim the nim to set
	 */
	public void setNim(String nim) {
		this.nim = nim;
	}
	/**
	 * @return the nama
	 */
	public String getNama() {
		return nama;
	}
	/**
	 * @param nama the nama to set
	 */
	public void setNama(String nama) {
		this.nama = nama;
	}
	/**
	 * @return the alamat
	 */
	public String getAlamat() {
		return alamat;
	}
	/**
	 * @param alamat the alamat to set
	 */
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
}
