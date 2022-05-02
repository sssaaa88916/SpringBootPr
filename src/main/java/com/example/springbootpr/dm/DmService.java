package com.example.springbootpr.dm;

import com.example.springbootpr.dm.model.DmDomain;
import com.example.springbootpr.dm.model.DmDto;
import com.example.springbootpr.dm.model.DmMsgDomain;
import com.example.springbootpr.dm.model.DmUserEntity;
import com.example.springbootpr.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DmService {

    private final DmMapper mapper;
    private final AuthenticationFacade auth;

    //dm 채팅 방 만들기
    @Transactional
    public DmDomain insDm(DmDto dto) {
        mapper.insDm(dto);

        DmUserEntity p1 = new DmUserEntity();
        p1.setIdm(dto.getIdm());
        p1.setIuser(dto.getToiuser());
        mapper.insDmUser(p1);

        p1.setIuser(auth.getLoginUserPk());
        mapper.insDmUser(p1);

        dto.setFromiuser(auth.getLoginUserPk());
        DmDomain r = new DmDomain();
        r.setIdm(dto.getIdm());
        r.setOpponent(mapper.selDmOpponent(dto));
        return r;
    }


    public List<DmDomain> selDmList(DmDto dto) {
        dto.setFromiuser(auth.getLoginUserPk());
        return mapper.selDmList(dto);
    }

    public List<DmMsgDomain> selDmMsgList(DmDto dto) {
        return mapper.selDmMsgList(dto);
    }

}
