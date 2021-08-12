package com.dahal.w2d4OneToManyStatesAndResidents.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="states")
public class State {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
    @Size(min = 2, max = 100)
    private String name;
	
    @Size(min = 10, max = 200)
    private String description;
    
    @NotNull(message = "Capital is required!")
    @Size(min = 2, max = 100, message = "Capital must be between 2-100 characters")
    private String capital;
    
    @NotNull(message = "Animal for the state is required!")
    private String animal;
    
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
    
    
    //ONE TO MANY CONNECTION-> ONE STATE CAN HAVE MANY RESIDENTS
    @OneToMany(mappedBy="state", fetch = FetchType.LAZY)
    private List<Resident> residents;
    
    
    
    //empty constructor
    public State() {
    	
    }

	
    //loaded constructor
    public State(String name, String description, String capital, String animal) {
		this.name = name;
		this.description = description;
		this.capital = capital;
		this.animal = animal;
	}
    
    //REMEMBER TO HAVE GETTERS AND SETTERS!
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
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
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
	public List<Resident> getResidents() {
		return residents;
	}
	public void setResidents(List<Resident> residents) {
		this.residents = residents;
	}
	
	
	
	
    
	
	
    
    
    
    
    
    
    

}
