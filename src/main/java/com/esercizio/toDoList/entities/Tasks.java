package com.esercizio.toDoList.entities;

import java.sql.Date;

public class Tasks extends Entity {

    private String description_;
    private Date due_date;
    private boolean completed;
    private int category_id;
    
    public Tasks(int id, String description_, Date due_date, boolean completed, int category_id) {
        super(id);
        this.description_ = description_;
        this.due_date = due_date;
        this.completed = completed;
        this.category_id = category_id;
    }

    public String getDescription_() {
        return description_;
    }

    public void setDescription_(String description_) {
        this.description_ = description_;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Tasks [description_=" + description_ + ", due_date=" + due_date + ", completed=" + completed
                + ", category_id=" + category_id + "]";
    }

    
}
