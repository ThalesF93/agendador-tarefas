package com.thales.agendadortarefas.Business;

import com.thales.agendadortarefas.Business.Dto.TarefasDTO;
import com.thales.agendadortarefas.Business.Mapper.TarefaConverter;
import com.thales.agendadortarefas.infraStructure.Enuns.StatusNotificacaoEnum;
import com.thales.agendadortarefas.infraStructure.entity.TarefasEntity;
import com.thales.agendadortarefas.infraStructure.repository.TarefasRepository;
import com.thales.agendadortarefas.infraStructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor

public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefaConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extrairEmailToken(token.substring(7));

        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);

        TarefasEntity entity = tarefaConverter.paraTarefaEntity(dto);

        return tarefaConverter.paraTarefaDTO(tarefasRepository.save(entity));
    }
}
