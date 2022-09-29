
package com.mozzart.obuka.service.impl;

import com.mozzart.obuka.domain.Competition;
import com.mozzart.obuka.domain.Match;
import com.mozzart.obuka.domain.MatchParticipant;
import com.mozzart.obuka.domain.Participant;
import com.mozzart.obuka.domain.ParticipantType;
import com.mozzart.obuka.mapper.MatchMapper;
import com.mozzart.obuka.mapper.MatchParticipantMapper;
import com.mozzart.obuka.service.MatchService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService {

	@Autowired
	MatchMapper matchMapper;
	@Autowired
	MatchParticipantMapper matchParticipantMapper;

	public List<Match> findAll() {
		return this.matchMapper.findAllMatches();
	}

	public void save(Match match) {
		this.matchMapper.insertMatch(match);
		List<Participant> participants = match.getParticipants();

		if (participants.size() != 2) {
			for (Participant participant : participants) {
				MatchParticipant mp = new MatchParticipant(match.getId(), participant.getId(),ParticipantType.PARTICIPANT);
				this.matchParticipantMapper.insertMatchParticipant(mp);
			}
		} else {
			MatchParticipant mp1 = new MatchParticipant(match.getId(), participants.get(0).getId(),
					ParticipantType.HOME);
			this.matchParticipantMapper.insertMatchParticipant(mp1);
			MatchParticipant mp2 = new MatchParticipant(match.getId(), participants.get(1).getId(),
					ParticipantType.AWAY);
			this.matchParticipantMapper.insertMatchParticipant(mp2);
		}
	}


	public Competition getMatchCompetition(Long matchId) {
		return this.matchMapper.getMatchCompetition(matchId);
	}

	public Match getMatch(Long matchId) {
		return this.matchMapper.getMatch(matchId);
	}

	@Override
	public void update(Match match) {
		matchMapper.updateMatch(match);

	}
}