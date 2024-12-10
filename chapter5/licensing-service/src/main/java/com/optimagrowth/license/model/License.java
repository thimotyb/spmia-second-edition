package com.optimagrowth.license.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter @Setter @ToString
@NoArgsConstructor
@Entity
@Table(name="licenses")
public class License extends RepresentationModel<License> {

	@Id
	@Column(name = "license_id", nullable = false)
	private String licenseId;
	private String description;
	@Column(name = "organization_id", nullable = false)
	private String organizationId;
	@Column(name = "product_name", nullable = false)
	private String productName;
	@Column(name = "license_type", nullable = false)
	private String licenseType;
	@Column(name="comment")
	private String comment;

	public License withComment(String comment){
		this.setComment(comment);
		return this;
	}
}