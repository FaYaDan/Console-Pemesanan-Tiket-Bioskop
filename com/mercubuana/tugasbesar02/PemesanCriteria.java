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

public class PemesanCriteria extends AbstractORMCriteria {
	public final IntegerExpression idPemesan;
	public final StringExpression namaPemesan;
	public final DateExpression tanggalPemesanan;
	public final CharacterExpression kategoriFilm;
	public final IntegerExpression filmid_filmId;
	public final AssociationExpression filmid_film;
	
	public PemesanCriteria(Criteria criteria) {
		super(criteria);
		idPemesan = new IntegerExpression("idPemesan", this);
		namaPemesan = new StringExpression("namaPemesan", this);
		tanggalPemesanan = new DateExpression("tanggalPemesanan", this);
		kategoriFilm = new CharacterExpression("kategoriFilm", this);
		filmid_filmId = new IntegerExpression("filmid_film.idFiilm", this);
		filmid_film = new AssociationExpression("filmid_film", this);
	}
	
	public PemesanCriteria(PersistentSession session) {
		this(session.createCriteria(Pemesan.class));
	}
	
	public PemesanCriteria() throws PersistentException {
		this(TugasBesar02PersistentManager.instance().getSession());
	}
	
	public FilmCriteria createFilmid_filmCriteria() {
		return new FilmCriteria(createCriteria("filmid_film"));
	}
	
	public Pemesan uniquePemesan() {
		return (Pemesan) super.uniqueResult();
	}
	
	public Pemesan[] listPemesan() {
		java.util.List list = super.list();
		return (Pemesan[]) list.toArray(new Pemesan[list.size()]);
	}
}

