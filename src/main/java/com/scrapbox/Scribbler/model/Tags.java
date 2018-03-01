package com.scrapbox.Scribbler.model;

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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tags")
public class Tags {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	@GeneratedValue(generator = "uuid_generator")
	@GenericGenerator(name = "uuid_generator", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(columnDefinition = "BINARY(16)", updatable = false)
	private UUID uuid;

	@NotNull
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "id")
	private Topic topicId;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Topic getTopicId() {
		return topicId;
	}

	public void setTopicId(Topic topicId) {
		this.topicId = topicId;
	}

	public Tags() {
		// for hibernate
	}

	public Tags(int id, UUID uuid, String name, Topic topicId) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.name = name;
		this.topicId = topicId;
	}

}
