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

public class Film {
	public Film() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_FILM_PEMESAN) {
			return ORM_pemesan;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int idFiilm;
	
	private String judulFilm;
	
	private char kategoriFilm;
	
	private int jumlahKursi;
	
	private int sisaKursi;
	
	private java.util.Set ORM_pemesan = new java.util.HashSet();
	
	private void setIdFiilm(int value) {
		this.idFiilm = value;
	}
	
	public int getIdFiilm() {
		return idFiilm;
	}
	
	public int getORMID() {
		return getIdFiilm();
	}
	
	public void setJudulFilm(String value) {
		this.judulFilm = value;
	}
	
	public String getJudulFilm() {
		return judulFilm;
	}
	
	public void setKategoriFilm(char value) {
		this.kategoriFilm = value;
	}
	
	public char getKategoriFilm() {
		return kategoriFilm;
	}
	
	public void setJumlahKursi(int value) {
		this.jumlahKursi = value;
	}
	
	public int getJumlahKursi() {
		return jumlahKursi;
	}
	
	public void setSisaKursi(int value) {
		this.sisaKursi = value;
	}
	
	public int getSisaKursi() {
		return sisaKursi;
	}
	
	private void setORM_Pemesan(java.util.Set value) {
		this.ORM_pemesan = value;
	}
	
	private java.util.Set getORM_Pemesan() {
		return ORM_pemesan;
	}
	
	public final com.mercubuana.tugasbesar02.PemesanSetCollection pemesan = new com.mercubuana.tugasbesar02.PemesanSetCollection(this, _ormAdapter, ORMConstants.KEY_FILM_PEMESAN, ORMConstants.KEY_PEMESAN_FILMID_FILM, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		//return String.valueOf(getIdFilm());
		return String.valueOf(getJudulFilm());
	}
}
