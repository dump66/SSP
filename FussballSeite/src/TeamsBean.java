import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import de.hofuniversity.ssp.data.Player;
import de.hofuniversity.ssp.data.Team;
import de.hofuniversity.ssp.jpa.Persistence;

@ManagedBean
@SessionScoped
public class TeamsBean {

    Persistence p = new Persistence();
    List<Team> teams;
    List<Player> teamPlayer;
    
    public List<Player> getTeamPlayer() {
	if (teamPlayer == null){
	    teamPlayer = p.getTeamPlayers(40);
	}
        return teamPlayer;
    }

    public void setTeamPlayer(List<Player> teamPlayer) {
        this.teamPlayer = teamPlayer;
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
