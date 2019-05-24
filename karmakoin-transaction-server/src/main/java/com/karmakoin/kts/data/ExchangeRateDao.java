package com.karmakoin.kts.data;

import com.karmakoin.kts.entity.ExchangeRateEntity;
import org.springframework.data.repository.CrudRepository;

public interface ExchangeRateDao extends CrudRepository<ExchangeRateEntity, Integer>{

}
