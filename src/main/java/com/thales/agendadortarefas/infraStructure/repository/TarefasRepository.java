package com.thales.agendadortarefas.infraStructure.repository;

import com.thales.agendadortarefas.infraStructure.Enuns.StatusNotificacaoEnum;
import com.thales.agendadortarefas.infraStructure.entity.TarefasEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TarefasRepository extends MongoRepository<TarefasEntity, String> {

    List<TarefasEntity> findByDataEventoBetweenAndStatusNotificacaoEnum(LocalDateTime dataInicial, LocalDateTime dataFinal, StatusNotificacaoEnum status);

    List<TarefasEntity> findByEmailUsuario(String email);
}
