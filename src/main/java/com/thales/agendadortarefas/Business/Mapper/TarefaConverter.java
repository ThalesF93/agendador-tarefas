package com.thales.agendadortarefas.Business.Mapper;

import com.thales.agendadortarefas.Business.Dto.TarefasDTO;
import com.thales.agendadortarefas.infraStructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);
}
