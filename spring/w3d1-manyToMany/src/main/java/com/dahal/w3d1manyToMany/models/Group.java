package com.dahal.w3d1manyToMany.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="organizations")
public class Group {
	
	//member variables (id, name, description created at, updated at)--FIELDS IN THE SQL TABLE (COLUMN NAMES)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull(message= "Group Name is required!")
    @Size(min = 3, max = 200, message= "Group Name must be between 3-200 characters")
    private String name;
	
	@NotNull(message= "Group Description is required!")
    @Size(min = 10, max = 400, message= "Group Descriptiion must be between 10-400 characters")
    private String description;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
    
    ///end of member variables
    
    
    //beginning of many to many join
    
    @ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(
    		name= "orgs_members",
    		joinColumns = @JoinColumn(name= "group_id"),
    		inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> members;
    
    
    
    
    //empty constructor
    public Group() {
		
	}
    
    //loaded constructor
	public Group(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<User> getMembers() {
		return members;
	}
	public void setMembers(List<User> members) {
		this.members = members;
	}
	
	
	
	
	
    
    
    
    
    
    
    
    
    

}
