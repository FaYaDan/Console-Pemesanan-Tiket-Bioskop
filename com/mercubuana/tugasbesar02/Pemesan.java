/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package com.mercubuana.tugasbesar02;

public class Pemesan {
	public Pemesan() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_PEMESAN_FILMID_FILM) {
			this.filmid_film = (com.mercubuana.tugasbesar02.Film) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int idPemesan;
	
	private String namaPemesan;
	
	private java.util.Date tanggalPemesanan;
	
	private char kategoriFilm;
	
	private com.mercubuana.tugasbesar02.Film filmid_film;
	
	private void setIdPemesan(int value) {
		this.idPemesan = value;
	}
	
	public int getIdPemesan() {
		return idPemesan;
	}
	
	public int getORMID() {
		return getIdPemesan();
	}
	
	public void setNamaPemesan(String value) {
		this.namaPemesan = value;
	}
	
	public String getNamaPemesan() {
		return namaPemesan;
	}
	
	public void setTanggalPemesanan(java.util.Date value) {
		this.tanggalPemesanan = value;
	}
	
	public java.util.Date getTanggalPemesanan() {
		return tanggalPemesanan;
	}
	
	public void setKategoriFilm(char value) {
		this.kategoriFilm = value;
	}
	
	public char getKategoriFilm() {
		return kategoriFilm;
	}
	
	public void setFilmid_film(com.mercubuana.tugasbesar02.Film value) {
		if (filmid_film != null) {
			filmid_film.pemesan.remove(this);
		}
		if (value != null) {
			value.pemesan.add(this);
		}
	}
	
	public com.mercubuana.tugasbesar02.Film getFilmid_film() {
		return filmid_film;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Filmid_film(com.mercubuana.tugasbesar02.Film value) {
		this.filmid_film = value;
	}
	
	private com.mercubuana.tugasbesar02.Film getORM_Filmid_film() {
		return filmid_film;
	}
	
	public String toString() {
		return String.valueOf(getNamaPemesan());
	}
	
}
