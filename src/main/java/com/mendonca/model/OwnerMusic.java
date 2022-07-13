package com.mendonca.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="ownerLogin")
public class OwnerMusic {

	@Id
	private String  ownerLogin;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "owners" )
	private List<Music> musics = new ArrayList<Music>();


	public String getOwnerLogin() {
		return ownerLogin;
	}


	public void setOwnerLogin(String ownerLogin) {
		this.ownerLogin = ownerLogin;
	}


	public List<Music> getMusics() {
		return musics;
	}


	public void setMusics(ArrayList<Music> musics) {
		this.musics = musics;
	}
	
	public void addMusic(Music music) {
		musics.add(music);
	}
	
	
}
