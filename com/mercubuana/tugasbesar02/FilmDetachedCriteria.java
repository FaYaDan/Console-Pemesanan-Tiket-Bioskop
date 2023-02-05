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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class FilmDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idFiilm;
	public final StringExpression judulFilm;
	public final CharacterExpression kategoriFilm;
	public final IntegerExpression jumlahKursi;
	public final IntegerExpression sisaKursi;
	public final CollectionExpression pemesan;
	
	public FilmDetachedCriteria() {
		super(com.mercubuana.tugasbesar02.Film.class, com.mercubuana.tugasbesar02.FilmCriteria.class);
		idFiilm = new IntegerExpression("idFiilm", this.getDetachedCriteria());
		judulFilm = new StringExpression("judulFilm", this.getDetachedCriteria());
		kategoriFilm = new CharacterExpression("kategoriFilm", this.getDetachedCriteria());
		jumlahKursi = new IntegerExpression("jumlahKursi", this.getDetachedCriteria());
		sisaKursi = new IntegerExpression("sisaKursi", this.getDetachedCriteria());
		pemesan = new CollectionExpression("ORM_Pemesan", this.getDetachedCriteria());
	}
	
	public FilmDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.mercubuana.tugasbesar02.FilmCriteria.class);
		idFiilm = new IntegerExpression("idFiilm", this.getDetachedCriteria());
		judulFilm = new StringExpression("judulFilm", this.getDetachedCriteria());
		kategoriFilm = new CharacterExpression("kategoriFilm", this.getDetachedCriteria());
		jumlahKursi = new IntegerExpression("jumlahKursi", this.getDetachedCriteria());
		sisaKursi = new IntegerExpression("sisaKursi", this.getDetachedCriteria());
		pemesan = new CollectionExpression("ORM_Pemesan", this.getDetachedCriteria());
	}
	
	public PemesanDetachedCriteria createPemesanCriteria() {
		return new PemesanDetachedCriteria(createCriteria("ORM_Pemesan"));
	}
	
	public Film uniqueFilm(PersistentSession session) {
		return (Film) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Film[] listFilm(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Film[]) list.toArray(new Film[list.size()]);
	}
}

