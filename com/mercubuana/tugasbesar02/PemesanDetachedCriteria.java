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

public class PemesanDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idPemesan;
	public final StringExpression namaPemesan;
	public final DateExpression tanggalPemesanan;
	public final CharacterExpression kategoriFilm;
	public final IntegerExpression filmid_filmId;
	public final AssociationExpression filmid_film;
	
	public PemesanDetachedCriteria() {
		super(com.mercubuana.tugasbesar02.Pemesan.class, com.mercubuana.tugasbesar02.PemesanCriteria.class);
		idPemesan = new IntegerExpression("idPemesan", this.getDetachedCriteria());
		namaPemesan = new StringExpression("namaPemesan", this.getDetachedCriteria());
		tanggalPemesanan = new DateExpression("tanggalPemesanan", this.getDetachedCriteria());
		kategoriFilm = new CharacterExpression("kategoriFilm", this.getDetachedCriteria());
		filmid_filmId = new IntegerExpression("filmid_film.idFiilm", this.getDetachedCriteria());
		filmid_film = new AssociationExpression("filmid_film", this.getDetachedCriteria());
	}
	
	public PemesanDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.mercubuana.tugasbesar02.PemesanCriteria.class);
		idPemesan = new IntegerExpression("idPemesan", this.getDetachedCriteria());
		namaPemesan = new StringExpression("namaPemesan", this.getDetachedCriteria());
		tanggalPemesanan = new DateExpression("tanggalPemesanan", this.getDetachedCriteria());
		kategoriFilm = new CharacterExpression("kategoriFilm", this.getDetachedCriteria());
		filmid_filmId = new IntegerExpression("filmid_film.idFiilm", this.getDetachedCriteria());
		filmid_film = new AssociationExpression("filmid_film", this.getDetachedCriteria());
	}
	
	public FilmDetachedCriteria createFilmid_filmCriteria() {
		return new FilmDetachedCriteria(createCriteria("filmid_film"));
	}
	
	public Pemesan uniquePemesan(PersistentSession session) {
		return (Pemesan) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Pemesan[] listPemesan(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Pemesan[]) list.toArray(new Pemesan[list.size()]);
	}
}

