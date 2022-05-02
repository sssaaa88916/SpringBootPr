package com.example.springbootpr.dm;

import com.example.springbootpr.dm.model.DmDomain;
import com.example.springbootpr.dm.model.DmDto;
import com.example.springbootpr.dm.model.DmMsgDomain;
import com.example.springbootpr.dm.model.DmUserEntity;
import com.example.springbootpr.user.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmMapper {
    int insDm(DmDto dto);
    List<DmDomain> selDmList(DmDto dto);
    UserEntity selDmOpponent(DmDto dto);
    int updDmLastMsg(DmMsgDomain domain);

    int insDmUser(DmUserEntity entity);

    int insDmMsg(DmMsgDomain domain);
    List<DmMsgDomain> selDmMsgList(DmDto dto);

}
