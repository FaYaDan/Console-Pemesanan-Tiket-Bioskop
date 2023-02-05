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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class FilmCriteria extends AbstractORMCriteria {
	public final IntegerExpression idFiilm;
	public final StringExpression judulFilm;
	public final CharacterExpression kategoriFilm;
	public final IntegerExpression jumlahKursi;
	public final IntegerExpression sisaKursi;
	public final CollectionExpression pemesan;
	
	public FilmCriteria(Criteria criteria) {
		super(criteria);
		idFiilm = new IntegerExpression("idFiilm", this);
		judulFilm = new StringExpression("judulFilm", this);
		kategoriFilm = new CharacterExpression("kategoriFilm", this);
		jumlahKursi = new IntegerExpression("jumlahKursi", this);
		sisaKursi = new IntegerExpression("sisaKursi", this);
		pemesan = new CollectionExpression("ORM_Pemesan", this);
	}
	
	public FilmCriteria(PersistentSession session) {
		this(session.createCriteria(Film.class));
	}
	
	public FilmCriteria() throws PersistentException {
		this(TugasBesar02PersistentManager.instance().getSession());
	}
	
	public PemesanCriteria createPemesanCriteria() {
		return new PemesanCriteria(createCriteria("ORM_Pemesan"));
	}
	
	public Film uniqueFilm() {
		return (Film) super.uniqueResult();
	}
	
	public Film[] listFilm() {
		java.util.List list = super.list();
		return (Film[]) list.toArray(new Film[list.size()]);
	}
}

