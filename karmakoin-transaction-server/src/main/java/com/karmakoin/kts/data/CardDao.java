package com.karmakoin.kts.data;

import com.karmakoin.kts.entity.CardEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CardDao extends CrudRepository<CardEntity, Integer> {


    @Query(value = "SELECT * FROM [dbo].[kot_ts_cards] with(nolock) WHERE pin_hash = :pin_hash", nativeQuery = true)
    CardEntity findCardByPin(@Param("pin_hash") byte[] pinHash);
}
