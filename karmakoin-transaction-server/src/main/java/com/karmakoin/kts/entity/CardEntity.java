package com.karmakoin.kts.entity;

import com.fasterxml.jackson.annotation.*;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.IntType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.EnumSet;


interface IntTypeEnum {
    int getValue();

    static <E extends Enum<E>> E toEnum(Class<E> elemType, int value) {
        for (E e : java.util.EnumSet.allOf(elemType)) {

            if (((IntTypeEnum)e).getValue() == value) {
                return e;
            }
        }
        return null;
    }
}

enum CardStatus implements IntTypeEnum {
    NONE {
        @Override
        public int getValue() {
            return -1;
        }
    },
    READY_TO_REDEEM {
        @Override
        public int getValue() {
            return 200;
        }
    },
    PENDING {
        @Override
        public int getValue() {
            return 201;
        }
    },
    FULL_REDEEMED {
        @Override
        public int getValue() {
            return 203;
        }
    },
    DEACTIVATED {
        @Override
        public int getValue() {
            return 203;
        }
    };
}

enum CardType implements IntTypeEnum {
    NEXON_CARD{
        @Override
        public int getValue() {
            return 1;
        }
    },
    KARMAKOIN_CARD{
        @Override
        public int getValue() {
            return 2;
        }
    };

}

@Entity
@Table(name = "kot_ts_cards", schema = "dbo")
@JsonTypeName("card")
@JsonTypeInfo(include= JsonTypeInfo.As.WRAPPER_OBJECT,use= JsonTypeInfo.Id.NAME)
public class CardEntity {
    @Id
    @Column(name="card_no")
    @JsonIgnore
    private long cardNo;

    @Column(name="pin_hash")
    @JsonIgnore
    private byte[] pinHash;

    @Column(name="prefix")
    @JsonIgnore
    private String prefix;

    @Column(name="card_status")
    private short status;

    @Column(name="product_type")
    @JsonIgnore
    private short productType;

    @Column(name="card_type")
    private short type;

    @Column(name="van_code")
    private String vanCode;

    @Column(name="balance_amount")
    private BigDecimal balance;

    @Column(name="unit_price")
    private BigDecimal unitPrice;

    @Column(name="card_currency")
    private String currency;

    @Column(name="redeemed_datetime")
    private java.sql.Timestamp redeemedDatetime;

    @Column(name="track_data1")
    @JsonIgnore
    private String trackData1;

    @Column(name="track_data2")
    @JsonIgnore
    private String trackData2;

    @Column(name="track_data3")
    @JsonIgnore
    private String trackData3;

    @Column(name="card_property1")
    @JsonIgnore
    private String cardProperty1;

    @Column(name="card_property2")
    @JsonIgnore
    private String cardProperty2;

    @Column(name="card_property3")
    @JsonIgnore
    private String cardProperty3;


    public long getCardNo() {
        return this.cardNo;
    }
    public byte[] getPinHash() {
        return this.pinHash;
    }
    public String getPrefix() {
        return this.prefix;
    }

    public CardStatus getStatus() {
        return IntTypeEnum.toEnum(CardStatus.class, this.status);
    }

    public short getProductType() {
        return this.productType;
    }

    public CardType getType() {
        return IntTypeEnum.toEnum(CardType.class, this.type);
    }
    public String getVanCode() {
        return this.vanCode;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    public String getCurrency() {
        return this.currency;
    }

    public java.sql.Timestamp getRedeemedDatetime() {
        return this.redeemedDatetime;
    }

    public String getTrackData1() {
        return this.trackData1;
    }

    public String getTrackData2() {
        return this.trackData2;
    }
    public String getTrackData3() {
        return this.trackData3;
    }

    public String getCardProperty1() {
        return this.cardProperty1;
    }

    public String getCardProperty2() {
        return this.cardProperty2;
    }
    public String getCardProperty3() {return this.cardProperty3; }

}


