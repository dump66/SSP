package de.hofuniversity.ssp.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import de.hofuniversity.ssp.data.Goal;

public class Persistence {

    private EntityManagerFactory factory = javax.persistence.Persistence.createEntityManagerFactory("FussballDB");
    
    public void addGoal(Goal g){
	EntityManager m = factory.createEntityManager();
	m.getTransaction().begin();
	m.persist(g);
	m.getTransaction().commit();
	m.close();
    }
    
    public List<Goal> getGoals(){
	EntityManager m = factory.createEntityManager();
	TypedQuery<Goal> q = m.createQuery("from tor", Goal.class);
	List<Goal> res = q.getResultList();
	m.close();
	return res;
    }
    
    public void deleteGoal(Goal g){
	EntityManager m = factory.createEntityManager();
	m.getTransaction().begin();
	Goal goal = m.find(Goal.class, g.getId());
	m.remove(goal);
	m.getTransaction().commit();
	m.close();
    }
}
