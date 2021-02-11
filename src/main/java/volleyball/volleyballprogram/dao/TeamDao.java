package volleyball.volleyballprogram.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import volleyball.volleyballprogram.entity.Team;

public interface TeamDao extends JpaRepository<Team,Integer> {
}
