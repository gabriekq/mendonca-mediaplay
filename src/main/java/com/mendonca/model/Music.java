package com.mendonca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Music {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String musicOwner;
	private String musicName;
    private String musicType;	
	
	@Lob
	private byte musicData[];

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getMusicOwner() {
		return musicOwner;
	}

	public void setMusicOwner(String musicOwner) {
		this.musicOwner = musicOwner;
	}
	
	
	
	
}
