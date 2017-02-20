package com.viseo.companion.events.dao;

import java.util.Collection;
import java.util.List;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viseo.companion.events.domain.Event;


@Repository
public class EventDAO {

	@PersistenceContext
	EntityManager em;

	@Transactional
	public Event getEvent(long id){
		return em.find(Event.class, id);
	}

	@Transactional
	public void addEvent(String name, Date date, String description, String KeyWords, String place){
		Event event = new Event();		
		event.setDatetime(date);
		event.setDescription(description);
		event.setName(name);
		event.setPlace(place);
		event.setKeyWords(KeyWords);
		em.persist(event);		
	}

	@Transactional
	public void addEvent(Event event){
		em.persist(event);
	}

	public boolean isEventAlreadySaved(String event){
		Collection<Event> list = null;
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Event> q = cb.createQuery(Event.class);
		Root<Event> c = q.from(Event.class);
		q.select(c).where(cb.equal(c.get("event"), event));
		list = (Collection<Event>) em.createQuery(q).getResultList();
		return !list.isEmpty(); //return true if the list is not avoid
	}

	public List<Event> GetAllEvent() {
		return em.createQuery("select a from Event a order by a.datetime", Event.class).getResultList();
	}
}
