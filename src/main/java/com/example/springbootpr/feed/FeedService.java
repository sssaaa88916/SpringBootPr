package com.example.springbootpr.feed;

import com.example.springbootpr.common.MyFileUtils;
import com.example.springbootpr.feed.model.FeedDomain;
import com.example.springbootpr.feed.model.FeedDto;
import com.example.springbootpr.feed.model.FeedEntity;
import com.example.springbootpr.feed.model.FeedImgEntity;
import com.example.springbootpr.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;
    private final AuthenticationFacade auth;
    private final MyFileUtils myFileUtils;

    public int reg(MultipartFile[] imgs, FeedEntity entity) {
        if(imgs == null) { return 0; }
        entity.setIuser(auth.getLoginUserPk());

        int result = mapper.insFeed(entity);
        if(result == 0) { return 0; }

        String target = "feed/" + entity.getIfeed();

        FeedImgEntity imgEntity = new FeedImgEntity();
        imgEntity.setIfeed(entity.getIfeed());
        for(MultipartFile img : imgs) {
            String fileNm = myFileUtils.transferTo(img, target);
            imgEntity.setImg(fileNm);
            mapper.insFeedImg(imgEntity);
        }
        return 1;
    }

    public List<FeedDomain> selFeedList(FeedDto dto) {
        dto.setIuserForFav(auth.getLoginUserPk());
        return mapper.selFeedList(dto);
    }

}
