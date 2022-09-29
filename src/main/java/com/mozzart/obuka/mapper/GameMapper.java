package com.mozzart.obuka.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.mozzart.obuka.domain.Game;

@Mapper
public interface GameMapper {
  
	Game findById(Long id);


}
