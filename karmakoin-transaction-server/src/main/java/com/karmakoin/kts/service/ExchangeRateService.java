package com.karmakoin.kts.service;

import com.karmakoin.kts.data.ExchangeRateDao;
import com.karmakoin.kts.entity.ExchangeRateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path("/exchange")
public class ExchangeRateService {
    @Autowired
    private ExchangeRateDao dao;


    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<ExchangeRateEntity> allExchangeRate() {
        Iterable<ExchangeRateEntity> exchanges = dao.findAll();
        return exchanges;
    }

    @GET
    @Path("/{no}")
    @Produces(MediaType.APPLICATION_JSON)
    public ExchangeRateEntity getExchangeRate(@PathParam("no") int no) {
        ExchangeRateEntity entity = dao.findOne(no);

        return entity;
    }
}
