package com.mozzart.obuka.mapper;


import org.apache.ibatis.annotations.Mapper;


import com.mozzart.obuka.domain.MatchParticipant;

@Mapper
public interface MatchParticipantMapper {
  

	void insertMatchParticipant(MatchParticipant matchParticipant);


}
