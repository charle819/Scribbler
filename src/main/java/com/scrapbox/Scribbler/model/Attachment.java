package com.scrapbox.Scribbler.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="attachment")
public class Attachment {

	private int id;
	
	@NotNull
	@GeneratedValue(generator = "uuid_generator")
	@GenericGenerator(name = "uuid_generator", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(columnDefinition = "BINARY(16)", updatable = false)
	private UUID uuid;
	
	private String type;
	private String fileExtension;
	
	@Lob
	@Column(columnDefinition="mediumblob")
	private byte[] file;
	//data 
}
