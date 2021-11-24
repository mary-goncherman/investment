package com.invest.operations.domain;

import com.invest.operations.infrastructure.OperationStorageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ExtraOperationStorageDataImpl implements ExtraOperationStorageData {

    private Logger logger = LoggerFactory.getLogger(ExtraOperationStorageDataImpl.class);

    @Autowired
    private EntityManager em;

    @Override
    public boolean operationExists(String stockCode, LocalDateTime operationTime) throws OperationStorageException {
        try {
            List<Operation> operations = em.createQuery(
                    "select operation from Operation operation where operation.stockCode = :code and operation.operationTime = :time", Operation.class)
                    .setParameter("code", stockCode)
                    .setParameter("time", operationTime)
                    .getResultList();

            return !operations.isEmpty();
        } catch (Exception e) {
            throw new OperationStorageException(e.getMessage());
        }
    }
}