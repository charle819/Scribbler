package com.scrapbox.Scribbler.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "note")
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	@GeneratedValue(generator = "uuid_generator")
	@GenericGenerator(name = "uuid_generator", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(columnDefinition = "BINARY(16)", updatable = false)
	private UUID uuid;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(referencedColumnName = "id")
	private Topic topicId;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdOn;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date updatedOn;

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

	public Topic getTopicId() {
		return topicId;
	}

	public void setTopicId(Topic topicId) {
		this.topicId = topicId;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Note() {
		// for hibernate
	}

	public Note(int id, UUID uuid, Topic topicId, Date createdOn, Date updatedOn) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.topicId = topicId;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

}
