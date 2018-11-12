package com.example.springboot.postgrehibernate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="Theatre")
@Getter
@Setter
@ToString
public class Theatre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String theatreName;
	private String location;
	
	public Theatre() {
		
	}
	public Theatre(int id, String theatreName, String location) {
		
		this.id = id;
		this.theatreName = theatreName;
		this.location = location;
	}
	

}
