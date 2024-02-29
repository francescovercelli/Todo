package main.java.com.esercizio.toDoList.dao;

import java.util.Map;

public interface IDAO {
    public void create(Entity e);

    public Map<Integer, Entity> read();

    public void update(Entity e);

    public void delete(int id);
}
