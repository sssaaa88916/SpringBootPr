package com.example.springbootpr.dm;

import com.example.springbootpr.dm.model.DmDomain;
import com.example.springbootpr.dm.model.DmDto;
import com.example.springbootpr.dm.model.DmMsgDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dm")
public class DmController {
    private final DmService service;

    @GetMapping
    public String dm() {
        return "dm/index";
    }

    @GetMapping("/reg")
    @ResponseBody
    public DmDomain insDm(DmDto dto) {
        return service.insDm(dto);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<DmDomain> selDmList(DmDto dto) {
        return service.selDmList(dto);
    }

    @GetMapping("/msg/list")
    @ResponseBody
    public List<DmMsgDomain> selDmMsgList(DmDto dto) {
        System.out.println(dto);
        return service.selDmMsgList(dto);
    }
}