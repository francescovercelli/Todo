package com.esercizio.toDoList.Services;

import com.esercizio.toDoList.dao.CategoriesDao;

import com.esercizio.toDoList.entities.Categories;
import com.esercizio.toDoList.entities.Entity;
import com.esercizio.toDoList.entities.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {

        @Autowired
        private CategoriesDao categoriesDao;
        @Autowired
        private ApplicationContext context;

        public List<Categories> findAll(){

            //salvo i dati della read nella mappa che abbiamo chiamata data
            Map<Integer, Entity> data = categoriesDao.read();
            List<Categories> ris = new ArrayList<>();

            //con il ciclo for cicliamo i valori della mappa data e li salviamo nella lista paziente
            for(Entity e : data.values()){
                if(e instanceof Tasks){
                    ris.add((Categories) e);
                }
            }

            return ris;
        }

        public Categories findById(int id){
            Map<Integer, Entity> data = categoriesDao.read();

            return (Categories) data.get(id);
        }

        public List<Categories> findByNome(String nome){
            Map<Integer, Entity> data = categoriesDao.read();
            List<Categories> ris = new ArrayList<>();

            for(Entity e : data.values()){
                if(e instanceof Categories){
                    ris.add((Categories) e);
                }
            }

            return ris;
        }


        public void insertCategory(Map<String, String> params){
            Categories c = context.getBean(Categories.class, params);
            categoriesDao.create(c);
        }

        public void updateCategory(Map<String, String> params){
            Categories c = context.getBean(Categories.class, params);
            categoriesDao.update(c);
        }

        public void deleteCategory(int id){
            categoriesDao.delete(id);
        }
    

}
