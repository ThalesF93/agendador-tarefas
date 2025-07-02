package com.thales.agendadortarefas.infraStructure.repository;

import com.thales.agendadortarefas.infraStructure.entity.TarefasEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefasRepository extends MongoRepository<TarefasEntity, String> {

}
