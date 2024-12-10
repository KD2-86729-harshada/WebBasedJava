package com.cdac.dao;

import com.cdac.entities.Players;

public interface PlayersDao {
	String signUpPlayers(Long teamId, Players newPlayers);

	String deletePlayersFromTeam(Long teamId, Long playerId);
}
