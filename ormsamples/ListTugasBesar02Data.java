/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class ListTugasBesar02Data {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Film...");
		com.mercubuana.tugasbesar02.Film[] commercubuanatugasbesar02Films = com.mercubuana.tugasbesar02.FilmDAO.listFilmByQuery(null, null);
		int length = Math.min(commercubuanatugasbesar02Films.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commercubuanatugasbesar02Films[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Pemesan...");
		com.mercubuana.tugasbesar02.Pemesan[] commercubuanatugasbesar02Pemesans = com.mercubuana.tugasbesar02.PemesanDAO.listPemesanByQuery(null, null);
		length = Math.min(commercubuanatugasbesar02Pemesans.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commercubuanatugasbesar02Pemesans[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Film by Criteria...");
		com.mercubuana.tugasbesar02.FilmCriteria lcommercubuanatugasbesar02FilmCriteria = new com.mercubuana.tugasbesar02.FilmCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommercubuanatugasbesar02FilmCriteria.idFiilm.eq();
		lcommercubuanatugasbesar02FilmCriteria.setMaxResults(ROW_COUNT);
		com.mercubuana.tugasbesar02.Film[] commercubuanatugasbesar02Films = lcommercubuanatugasbesar02FilmCriteria.listFilm();
		int length =commercubuanatugasbesar02Films== null ? 0 : Math.min(commercubuanatugasbesar02Films.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commercubuanatugasbesar02Films[i]);
		}
		System.out.println(length + " Film record(s) retrieved."); 
		
		System.out.println("Listing Pemesan by Criteria...");
		com.mercubuana.tugasbesar02.PemesanCriteria lcommercubuanatugasbesar02PemesanCriteria = new com.mercubuana.tugasbesar02.PemesanCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommercubuanatugasbesar02PemesanCriteria.idPemesan.eq();
		lcommercubuanatugasbesar02PemesanCriteria.setMaxResults(ROW_COUNT);
		com.mercubuana.tugasbesar02.Pemesan[] commercubuanatugasbesar02Pemesans = lcommercubuanatugasbesar02PemesanCriteria.listPemesan();
		length =commercubuanatugasbesar02Pemesans== null ? 0 : Math.min(commercubuanatugasbesar02Pemesans.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commercubuanatugasbesar02Pemesans[i]);
		}
		System.out.println(length + " Pemesan record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListTugasBesar02Data listTugasBesar02Data = new ListTugasBesar02Data();
			try {
				listTugasBesar02Data.listTestData();
				//listTugasBesar02Data.listByCriteria();
			}
			finally {
				com.mercubuana.tugasbesar02.TugasBesar02PersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
