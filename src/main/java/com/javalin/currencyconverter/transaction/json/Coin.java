package com.javalin.currencyconverter.transaction.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Coin {

    @JsonProperty
    private String orign;

    @JsonProperty
    private String target;

    public Coin() {}

    public Coin(String orign, String target) {
        this.orign = orign;
        this.target = target;
    }

    @JsonIgnore
    public boolean hasOrign() {
        return StringUtils.isNotBlank(this.orign);
    }

    @JsonIgnore
    public boolean hasTarget() {
        return StringUtils.isNotBlank(this.target);
    }

}
