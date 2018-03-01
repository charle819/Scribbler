package com.scrapbox.Scribbler.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable=false)
	private int id;
	
	@NotNull
	@GeneratedValue(generator="uuid_generator")
	@GenericGenerator(name="uuid_generator", strategy="org.hibernate.id.UUIDGenerator")
	@Column(columnDefinition = "BINARY(16)",updatable=false)
	private UUID uuid;
	
	@NotNull
	private String firstName;
	
	private String lastName;
	
	@NotNull
	private String userName;
	
	@NotNull
	private String password;
	
	@NotNull
	private String email;
	
	@Lob
	@Column(columnDefinition="mediumblob")
	private byte[] profilePicture;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdOn;
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modifiedOn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	public User() {
		// for hibernate
	}

	public User(int id, UUID uuid, String firstName, String lastName, String userName, String password, String email,
			byte[] profilePicture, Date createdOn, Date modifiedOn) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.profilePicture = profilePicture;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
	}
	
	
}
