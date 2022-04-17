package com.example.springbootpr.feed;

import com.example.springbootpr.ResultVo;
import com.example.springbootpr.feed.model.FeedDomain;
import com.example.springbootpr.feed.model.FeedDto;
import com.example.springbootpr.feed.model.FeedEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/feed")
public class FeedController {
    private final FeedService service;

    @GetMapping
    public String index() {
        return "feed/index";
    }

    @ResponseBody
    @PostMapping("/reg")
    public ResultVo reg(MultipartFile[] imgs, FeedEntity entity) {
        return new ResultVo(service.reg(imgs, entity));
    }

    @ResponseBody
    @GetMapping("/list")
    public List<FeedDomain> selFeedList(FeedDto dto) {
        return service.selFeedList(dto);
    }
}
