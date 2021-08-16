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
@Table(name="users")
public class User {
	
	//member variables (id, name, createdat, updated at)--FIELDS IN THE SQL TABLE (COLUMN NAMES)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull(message= "Name is required!")
    @Size(min = 1, max = 200, message= "Name must be between 1-200 characters")
    private String name;

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
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "categories_products", 
//        joinColumns = @JoinColumn(name = "product_id"), 
//        inverseJoinColumns = @JoinColumn(name = "category_id")
//    )
//    private List<Category> categories;
    @ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(
    		name= "orgs_members",
    		joinColumns = @JoinColumn(name= "user_id"),
    		inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private List<Group> groupsJoined;
    
    
    
    //empty constructor
    public User() {
    	
    }
    

    //loaded constructor
	public User(String name) {
		this.name = name;
	}
	
	
	//generate getters and setters-> please remember to generate getters and setters
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
	public List<Group> getGroupsJoined() {
		return groupsJoined;
	}
	public void setGroupsJoined(List<Group> groupsJoined) {
		this.groupsJoined = groupsJoined;
	}
	
	
	
	
    
    
    
    

}
