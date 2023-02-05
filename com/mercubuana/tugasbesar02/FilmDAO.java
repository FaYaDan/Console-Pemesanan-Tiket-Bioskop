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

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class FilmDAO {
	public static Film loadFilmByORMID(int idFiilm) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return loadFilmByORMID(session, idFiilm);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Film getFilmByORMID(int idFiilm) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return getFilmByORMID(session, idFiilm);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Film loadFilmByORMID(int idFiilm, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return loadFilmByORMID(session, idFiilm, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Film getFilmByORMID(int idFiilm, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return getFilmByORMID(session, idFiilm, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Film loadFilmByORMID(PersistentSession session, int idFiilm) throws PersistentException {
		try {
			return (Film) session.load(com.mercubuana.tugasbesar02.Film.class, Integer.valueOf(idFiilm));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Film getFilmByORMID(PersistentSession session, int idFiilm) throws PersistentException {
		try {
			return (Film) session.get(com.mercubuana.tugasbesar02.Film.class, Integer.valueOf(idFiilm));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Film loadFilmByORMID(PersistentSession session, int idFiilm, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Film) session.load(com.mercubuana.tugasbesar02.Film.class, Integer.valueOf(idFiilm), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Film getFilmByORMID(PersistentSession session, int idFiilm, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Film) session.get(com.mercubuana.tugasbesar02.Film.class, Integer.valueOf(idFiilm), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFilm(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return queryFilm(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFilm(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return queryFilm(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Film[] listFilmByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return listFilmByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Film[] listFilmByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return listFilmByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFilm(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mercubuana.tugasbesar02.Film as Film");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFilm(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mercubuana.tugasbesar02.Film as Film");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Film", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Film[] listFilmByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryFilm(session, condition, orderBy);
			return (Film[]) list.toArray(new Film[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Film[] listFilmByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryFilm(session, condition, orderBy, lockMode);
			return (Film[]) list.toArray(new Film[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Film loadFilmByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return loadFilmByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Film loadFilmByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return loadFilmByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Film loadFilmByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Film[] films = listFilmByQuery(session, condition, orderBy);
		if (films != null && films.length > 0)
			return films[0];
		else
			return null;
	}
	
	public static Film loadFilmByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Film[] films = listFilmByQuery(session, condition, orderBy, lockMode);
		if (films != null && films.length > 0)
			return films[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateFilmByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return iterateFilmByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFilmByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return iterateFilmByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFilmByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mercubuana.tugasbesar02.Film as Film");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFilmByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mercubuana.tugasbesar02.Film as Film");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Film", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Film createFilm() {
		return new com.mercubuana.tugasbesar02.Film();
	}
	
	public static boolean save(com.mercubuana.tugasbesar02.Film film) throws PersistentException {
		try {
			TugasBesar02PersistentManager.instance().saveObject(film);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(com.mercubuana.tugasbesar02.Film film) throws PersistentException {
		try {
			TugasBesar02PersistentManager.instance().deleteObject(film);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(com.mercubuana.tugasbesar02.Film film)throws PersistentException {
		try {
			com.mercubuana.tugasbesar02.Pemesan[] lPemesans = film.pemesan.toArray();
			for(int i = 0; i < lPemesans.length; i++) {
				lPemesans[i].setFilmid_film(null);
			}
			return delete(film);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(com.mercubuana.tugasbesar02.Film film, org.orm.PersistentSession session)throws PersistentException {
		try {
			com.mercubuana.tugasbesar02.Pemesan[] lPemesans = film.pemesan.toArray();
			for(int i = 0; i < lPemesans.length; i++) {
				lPemesans[i].setFilmid_film(null);
			}
			try {
				session.delete(film);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(com.mercubuana.tugasbesar02.Film film) throws PersistentException {
		try {
			TugasBesar02PersistentManager.instance().getSession().refresh(film);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(com.mercubuana.tugasbesar02.Film film) throws PersistentException {
		try {
			TugasBesar02PersistentManager.instance().getSession().evict(film);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Film loadFilmByCriteria(FilmCriteria filmCriteria) {
		Film[] films = listFilmByCriteria(filmCriteria);
		if(films == null || films.length == 0) {
			return null;
		}
		return films[0];
	}
	
	public static Film[] listFilmByCriteria(FilmCriteria filmCriteria) {
		return filmCriteria.listFilm();
	}
}
