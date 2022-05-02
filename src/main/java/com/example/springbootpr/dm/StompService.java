package com.example.springbootpr.dm;

import com.example.springbootpr.dm.model.DmMsgDomain;
import com.example.springbootpr.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StompService {
    private final DmMapper mapper;
    private final AuthenticationFacade auth;

    @Transactional
    public int insDmMsg(DmMsgDomain domain) {
        domain.setIuser(auth.getLoginUserPk());
        mapper.insDmMsg(domain);

        return mapper.updDmLastMsg(domain);
    }
}
