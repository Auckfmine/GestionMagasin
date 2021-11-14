package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.EnumDeserializer;


public enum CategoryClient {
    @JsonDeserialize(using = EnumDeserializer.class)

    FIDELE,ORDINAIRE,PREMIUM
}
