/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateTugasBesar02Data {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = com.mercubuana.tugasbesar02.TugasBesar02PersistentManager.instance().getSession().beginTransaction();
		try {
			com.mercubuana.tugasbesar02.Film lcommercubuanatugasbesar02Film = com.mercubuana.tugasbesar02.FilmDAO.loadFilmByQuery(null, null);
			// Update the properties of the persistent object
			com.mercubuana.tugasbesar02.FilmDAO.save(lcommercubuanatugasbesar02Film);
			com.mercubuana.tugasbesar02.Pemesan lcommercubuanatugasbesar02Pemesan = com.mercubuana.tugasbesar02.PemesanDAO.loadPemesanByQuery(null, null);
			// Update the properties of the persistent object
			com.mercubuana.tugasbesar02.PemesanDAO.save(lcommercubuanatugasbesar02Pemesan);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Film by FilmCriteria");
		com.mercubuana.tugasbesar02.FilmCriteria lcommercubuanatugasbesar02FilmCriteria = new com.mercubuana.tugasbesar02.FilmCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommercubuanatugasbesar02FilmCriteria.idFiilm.eq();
		System.out.println(lcommercubuanatugasbesar02FilmCriteria.uniqueFilm());
		
		System.out.println("Retrieving Pemesan by PemesanCriteria");
		com.mercubuana.tugasbesar02.PemesanCriteria lcommercubuanatugasbesar02PemesanCriteria = new com.mercubuana.tugasbesar02.PemesanCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommercubuanatugasbesar02PemesanCriteria.idPemesan.eq();
		System.out.println(lcommercubuanatugasbesar02PemesanCriteria.uniquePemesan());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateTugasBesar02Data retrieveAndUpdateTugasBesar02Data = new RetrieveAndUpdateTugasBesar02Data();
			try {
				retrieveAndUpdateTugasBesar02Data.retrieveAndUpdateTestData();
				//retrieveAndUpdateTugasBesar02Data.retrieveByCriteria();
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
