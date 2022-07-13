package com.mendonca.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idMusicName")
public class Music {
    // THIS ID IS GOING TO BE THE MUSIC NAME WITHOUT THE .MP3 PART
	@Id
	private String idMusicName; 
	
	private String musicName;
    private String musicType;	
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte musicData[];

	@ManyToMany
	private List<OwnerMusic> owners = new ArrayList<OwnerMusic>();
	
	public String getIdMusicName() {
		return idMusicName;
	}

	public void setIdMusicName(String idMusicName) {
		this.idMusicName = idMusicName;
	}

	public String getMusicName() {
		return musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	public String getMusicType() {
		return musicType;
	}

	public void setMusicType(String musicType) {
		this.musicType = musicType;
	}

	public byte[] getMusicData() {
		return musicData;
	}

	public void setMusicData(byte[] musicData) {
		this.musicData = musicData;
	}

	public List<OwnerMusic> getOwners() {
		return owners;
	}

	public void setOwners(ArrayList<OwnerMusic> owners) {
		this.owners = owners;
	}
	
	public void addOwner(OwnerMusic ownerMusic ) {
		owners.add(ownerMusic);
	}

}
