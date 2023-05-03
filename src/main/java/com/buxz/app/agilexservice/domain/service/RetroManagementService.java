package com.buxz.app.agilexservice.domain.service;

import com.buxz.app.agilexservice.adapter.outbound.BoardMongoAdapter;
import com.buxz.app.agilexservice.domain.StatusEnum;
import com.buxz.app.agilexservice.domain.model.DomainRetroRequest;
import com.buxz.app.agilexservice.domain.port.RetroManagementUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

@Slf4j
@Service
public class RetroManagementService implements RetroManagementUseCase {

    private final BoardMongoAdapter mongoAdapter;

    @Autowired
    public RetroManagementService(BoardMongoAdapter mongoAdapter) {
        this.mongoAdapter = mongoAdapter;
    }

    @Override
    public DomainRetroRequest createNewRetroBoard(DomainRetroRequest retroRequest) {
        log.info("RetroManagementService#createNewRetroBoard: Creating a new retro board, date : {}", LocalDateTime.now());

        DomainRetroRequest domainRetroRequest = DomainRetroRequest.builder()
                .id(UUID.randomUUID())
                .boardCreator(retroRequest.getBoardCreator())
                .retroTitle(retroRequest.getRetroTitle())
                .retroDescription(retroRequest.getRetroDescription())
                .dateCreated(LocalDateTime.now())
                .status(StatusEnum.CREATED)
                .build();
        return mongoAdapter.createNewRetroBoard(domainRetroRequest);
    }

    @Override
    public Collection<DomainRetroRequest> retrieveAllBoards() {
        return null;
    }

    @Override
    public Collection<DomainRetroRequest> retrieveBoardByStatus(StatusEnum status) {
        return null;
    }

    @Override
    public DomainRetroRequest retrieveBoardByRetroId(UUID id) {
        return null;
    }

    @Override
    public void updateRetroBoardStatus(UUID retroId, StatusEnum status) {

    }
}
