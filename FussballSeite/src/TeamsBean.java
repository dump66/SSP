import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import de.hofuniversity.ssp.data.Team;
import de.hofuniversity.ssp.jpa.Persistence;

@ManagedBean
@SessionScoped
public class TeamsBean {

    Persistence p = new Persistence();
    List<Team> teams;
    
    public TeamsBean(){
	
    }

    public List<Team> getTeams() {
	if (teams == null){
	   teams = p.getTeams();
	}
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
    
    
    
}
