package com.Project.Management.domains;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Document(collection="Project")
public class Project {
	
	@Id
	@ApiModelProperty
	@NotNull
	private String id;

	@ApiModelProperty
	@NotNull
	private String productId;
	
	@ApiModelProperty
	@NotNull
	private String versionId;
	
	
	@ApiModelProperty
	@NotNull
	private ArrayList<String> owner;
	
	@ApiModelProperty
	@NotNull
	private ArrayList<String>developer;
	
	@ApiModelProperty
	@NotNull
	private ArrayList<String>stakeholder;
	
	@ApiModelProperty
	@NotNull
	private String Url;
	//constructors

	
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Project(String id, String productId, String versionId, ArrayList<String> owner, ArrayList<String> developer,
			ArrayList<String> stakeholder, String url) {
		super();
		this.id = id;
		this.productId = productId;
		this.versionId = versionId;
		this.owner = owner;
		this.developer = developer;
		this.stakeholder = stakeholder;
		Url = url;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getVersionId() {
		return versionId;
	}

	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

	public ArrayList<String> getOwner() {
		return owner;
	}

	public void setOwner(ArrayList<String> owner) {
		this.owner = owner;
	}

	public ArrayList<String> getDeveloper() {
		return developer;
	}

	public void setDeveloper(ArrayList<String> developer) {
		this.developer = developer;
	}

	public ArrayList<String> getStakeholder() {
		return stakeholder;
	}

	public void setStakeholder(ArrayList<String> stakeholder) {
		this.stakeholder = stakeholder;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}
    

}
