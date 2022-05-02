package com.example.springbootpr.dm.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DmEntity {
    private long idm;
    private String regdt;
    private String lastmsg;
    private String lastdt;
}