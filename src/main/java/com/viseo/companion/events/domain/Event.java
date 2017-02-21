package com.viseo.companion.events.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.viseo.companion.accountEvents.domain.AccountEvent;

@SuppressWarnings("serial")
@Entity
public class Event implements java.io.Serializable
{
	@Id
	@GeneratedValue
	private long id;
	@Version
	private long version;
	private long category;
	private String name;
	private Date datetime;
	private String description;
	private String keyWords;
	private String place;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.event", cascade = CascadeType.ALL)
	private Set<AccountEvent> accountEvents = new HashSet<AccountEvent>();
	
	public Event() {
	}
	
	public Event(String name, Date date, String description, String keyWords, String place){
		this.name = name;
		this.datetime = date;
		this.description= description;
		this.keyWords = keyWords;
		this.place = place;
		this.category = 0;
	}

	public long getId() {
		return id;
	}

	public long getCategory() {
		return category;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Date getDatetime(){
		return this.datetime;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String getKeyWords(){
		return this.keyWords;
	}

	public String getPlace(){
		return this.place;
	}

	public void setCategory(long category) {
		this.category = category;
	}
	
	public void setName(String event){
		this.name =event;
	}
	
	public void setDatetime(Date date){
		this.datetime =date;
	}
	
	public void setDescription(String description){
		this.description=description;
	}
	
	public void setKeyWords(String motclefs){
		this.keyWords =motclefs;
	}
	
	public void setPlace(String lieu){
		this.place =lieu;
	}

	@JsonBackReference
	public Set<AccountEvent> getAccountEvents(){
		return accountEvents;
	}
}
	
	
	
	
	

