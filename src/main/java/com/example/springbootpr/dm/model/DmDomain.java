package com.example.springbootpr.dm.model;

import com.example.springbootpr.user.model.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DmDomain extends DmEntity {
    private UserEntity opponent;
}
