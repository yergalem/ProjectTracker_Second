package edu.mum.cs544.l01.repository;

import java.io.Serializable;

import edu.mum.cs544.l01.core.CustomEntity;

public interface BaseRepositoryDAO<T extends CustomEntity> {

	/* Project , User and Task and Other Entities Setup*/
    public void setupEntityClass(Class clazz) ;
	
    public void insert(T object);

       
    public void update(T object);

   
    public void insertOrUpdate(T object);

   
    public void delete(T object);

    
    public T findById( long id);
   
	
}
