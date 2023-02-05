/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class CreateTugasBesar02Data {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = com.mercubuana.tugasbesar02.TugasBesar02PersistentManager.instance().getSession().beginTransaction();
		try {
			com.mercubuana.tugasbesar02.Film lcommercubuanatugasbesar02Film = com.mercubuana.tugasbesar02.FilmDAO.createFilm();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : pemesan, sisaKursi, jumlahKursi, kategoriFilm, judulFilm
			com.mercubuana.tugasbesar02.FilmDAO.save(lcommercubuanatugasbesar02Film);
			com.mercubuana.tugasbesar02.Pemesan lcommercubuanatugasbesar02Pemesan = com.mercubuana.tugasbesar02.PemesanDAO.createPemesan();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : filmid_film, kategoriFilm, tanggalPemesanan, namaPemesan
			com.mercubuana.tugasbesar02.PemesanDAO.save(lcommercubuanatugasbesar02Pemesan);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateTugasBesar02Data createTugasBesar02Data = new CreateTugasBesar02Data();
			try {
				createTugasBesar02Data.createTestData();
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
