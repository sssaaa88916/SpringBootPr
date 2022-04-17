package com.example.springbootpr.feed;

import com.example.springbootpr.feed.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    /********************************************    feed   *********/
    int insFeed(FeedEntity entity);
    List<FeedDomain> selFeedList(FeedDto dto);

    /********************************************    img   *********/
    int insFeedImg(FeedImgEntity entity);

}
