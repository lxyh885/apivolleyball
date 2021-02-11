package volleyball.volleyballprogram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import volleyball.volleyballprogram.dao.TeamDao;
import volleyball.volleyballprogram.entity.Team;

import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    TeamDao teamDao;
    public void addTeam(Team team) {
        teamDao.save(team);
    }

    public Page<Team> getTeamByColllegeName(String name, Pageable pageable) {
        Team team=new Team();
        team.setTeamCollege(name);
        return teamDao.findAll(Example.of(team),pageable);
    }


    public Optional<Team> getTeamByTeamName(String name) {
        Team team=new Team();
        team.setTeamName(name);
        return teamDao.findOne(Example.of(team));
    }
}
