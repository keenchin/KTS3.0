package com.karmakoin.kts.service;

import com.karmakoin.kts.data.CardDao;
import com.karmakoin.kts.entity.CardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
@Path("/card")
public class CardService {

    @Autowired
    private CardDao dao;


    @GET
    @Path("/{pin}")
    @Produces(MediaType.APPLICATION_JSON)
    public CardEntity getCard(@PathParam("pin") String pin) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] hashedPin = toSha1Bytes(pin);

        CardEntity entity = this.dao.findCardByPin(hashedPin);
        return entity;
    }

    private static String toSha1String(String src) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        crypt.reset();
        crypt.update(src.getBytes("UTF-8"));
        return new BigInteger(1, crypt.digest()).toString(16);
    }

    private static byte[] toSha1Bytes(String src) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        crypt.reset();
        crypt.update(src.getBytes("UTF-8"));
        return crypt.digest();
    }
/*
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String echo(@PathParam("id") int id) {
        if (id == -1) {
            UserEntity user1 = new UserEntity("Lee", 33);
            UserEntity user2 = new UserEntity("Han", 48);
            this.dao.save(user1);
            this.dao.save(user2);
            return "Add";
        }
        else {
            UserEntity user = this.dao.findOne(id);
            return user.toString();
        }

    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public String allUsers() {

        Iterable<UserEntity> entities = this.dao.findAll();
        String response = new String();

        for (UserEntity entity : entities) {
            response += entity.toString();
        }

        return response;

    }
    */
}



