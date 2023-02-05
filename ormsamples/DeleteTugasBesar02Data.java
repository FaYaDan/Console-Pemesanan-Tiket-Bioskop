/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class DeleteTugasBesar02Data {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = com.mercubuana.tugasbesar02.TugasBesar02PersistentManager.instance().getSession().beginTransaction();
		try {
			com.mercubuana.tugasbesar02.Film lcommercubuanatugasbesar02Film = com.mercubuana.tugasbesar02.FilmDAO.loadFilmByQuery(null, null);
			// Delete the persistent object
			com.mercubuana.tugasbesar02.FilmDAO.delete(lcommercubuanatugasbesar02Film);
			com.mercubuana.tugasbesar02.Pemesan lcommercubuanatugasbesar02Pemesan = com.mercubuana.tugasbesar02.PemesanDAO.loadPemesanByQuery(null, null);
			// Delete the persistent object
			com.mercubuana.tugasbesar02.PemesanDAO.delete(lcommercubuanatugasbesar02Pemesan);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteTugasBesar02Data deleteTugasBesar02Data = new DeleteTugasBesar02Data();
			try {
				deleteTugasBesar02Data.deleteTestData();
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
