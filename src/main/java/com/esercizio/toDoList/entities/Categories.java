package com.esercizio.toDoList.entities;

public class Categories extends Entity {

    private String name_;

    public Categories(int id, String name_) {
        super(id);
        this.name_ = name_;
    }
    public String getName_() {
        return name_;
    }
    public void setName_(String name_) {
        this.name_ = name_;
    }
    @Override
    public String toString() {
        return "Categories [name_=" + name_ + "]";
    }
    
    
}
