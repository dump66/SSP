package de.hofuniversity.ssp.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import de.hofuniversity.ssp.data.Goal;
import de.hofuniversity.ssp.data.Match;
import de.hofuniversity.ssp.data.Player;
import de.hofuniversity.ssp.data.Stadium;
import de.hofuniversity.ssp.data.Team;

public class Persistence {

    private EntityManagerFactory factory = javax.persistence.Persistence.createEntityManagerFactory("fussballdb");
    
    public Persistence(){
	
    }
    
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
    
    public void addMatch(Match match){
	EntityManager m = factory.createEntityManager();
	m.getTransaction().begin();
	m.persist(match);
	m.getTransaction().commit();
	m.close();
    }
    
    public List<Match> getMatches(){
	EntityManager m = factory.createEntityManager();
	TypedQuery<Match> q = m.createQuery("from spiel", Match.class);
	List<Match> res = q.getResultList();
	m.close();
	return res;
    }
    
    public void deleteMatch(Match match){
	EntityManager m = factory.createEntityManager();
	m.getTransaction().begin();
	Match ma = m.find(Match.class, match.getId());
	m.remove(ma);
	m.getTransaction().commit();
	m.close();
    }
    
    public void addPlayer(Player p){
	EntityManager m = factory.createEntityManager();
	m.getTransaction().begin();
	m.persist(p);
	m.getTransaction().commit();
	m.close();
    }
    
    public List<Player> getPlayers(){
	EntityManager m = factory.createEntityManager();
	TypedQuery<Player> q = m.createQuery("from spieler", Player.class);
	List<Player> res = q.getResultList();
	m.close();
	return res;
    }
    
    public void deletePlayer(Player p){
	EntityManager m = factory.createEntityManager();
	m.getTransaction().begin();
	Player player = m.find(Player.class, p.getId());
	m.remove(player);
	m.getTransaction().commit();
	m.close();
    }
    
    public void addStadium(Stadium s){
	EntityManager m = factory.createEntityManager();
	m.getTransaction().begin();
	m.persist(s);
	m.getTransaction().commit();
	m.close();
    }
    
    public List<Stadium> getStadiums(){
	EntityManager m = factory.createEntityManager();
	TypedQuery<Stadium> q = m.createQuery("from stadion", Stadium.class);
	List<Stadium> res = q.getResultList();
	m.close();
	return res;
    }
    
    public void deleteStadium(Stadium s){
	EntityManager m = factory.createEntityManager();
	m.getTransaction().begin();
	Stadium stadium = m.find(Stadium.class, s.getId());
	m.remove(stadium);
	m.getTransaction().commit();
	m.close();
    }
    
    public void addTeam(Team t){
	EntityManager m = factory.createEntityManager();
	m.getTransaction().begin();
	m.persist(t);
	m.getTransaction().commit();
	m.close();
    }
    
    public List<Team> getTeams(){
	EntityManager m = factory.createEntityManager();
	TypedQuery<Team> q = m.createQuery("from verein", Team.class);
	List<Team> res = q.getResultList();
	m.close();
	return res;
    }
    
    public List<Player> getTeamPlayers(int teamID){
	EntityManager m = factory.createEntityManager();
	List<Player> res = m.createQuery("select s from spieler s where s.team = " + teamID, Player.class).getResultList();
	m.close();
	return res;
    }
    
    public void deleteTeam(Team t){
	EntityManager m = factory.createEntityManager();
	m.getTransaction().begin();
	Team team = m.find(Team.class, t.getId());
	m.remove(team);
	m.getTransaction().commit();
	m.close();
    }
}
