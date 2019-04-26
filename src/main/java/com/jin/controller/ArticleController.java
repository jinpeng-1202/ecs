package com.jin.controller;

import com.jin.bean.ApiResponse;
import com.jin.common.RedisUtil;
import com.jin.model.TArticle;
import com.jin.model.TUser;
import com.jin.service.TArticleService;
import com.jin.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author jinpeng
 * @date 2019/4/25.
 */
@RestController
@RequestMapping("/v1/open")
public class ArticleController {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private TUserService userService;
    @Autowired
    private TArticleService articleService;

    /**
     * 初始化文章,放入hash
     * 1: 分值score=vote*436+time
     * 2: 文章排序 zset:时间-文章 zset:分值-文章
     * 3: 每篇文章只能被用户投票一次 set: 文章-uid, 为set设置过期时间,文章被投票的有效期
     */

    @PostMapping("/init")
    public ApiResponse init(HttpServletResponse response, HttpServletRequest request) throws IOException {
        TUser user = new TUser();
        List<TUser> users = userService.queryList(user);
        for (int i = 0; i < 10; i++) {
            TUser user1 = users.get(new Random().nextInt(200));
            Double time = Double.valueOf(System.currentTimeMillis()) / 1000;

            TArticle article = new TArticle();
            article.setUrl("http://" + user1.getAppUserId());
            article.setTime(time + "");
            article.setTitle("title" + user1.getRealName() + user1.getIdcardAddr() + user1.getId());
            article.setUserId(user1.getId());
            article.setVotes(0);
            articleService.insert(article);


            Map<String, Object> map = new HashMap<>();
            map.put("title", "title" + user1.getRealName() + user1.getIdcardAddr() + user1.getId());
            map.put("url", "http://" + user1.getAppUserId());
            map.put("time", time + "");
            map.put("userId", user1.getId() + "");
            map.put("votes", 0 + "");
            map.put("articleId", article.getId()+"");

            redisUtil.hash().putAll("article:" + article.getId(), map);
            Double score = time + 436 * 0;
            redisUtil.zSet().add("article:score", article.getId() + "", score);
            redisUtil.zSet().add("article:time", article.getId() + "", time);
        }

        return new ApiResponse();
    }

    @PostMapping("/vote")
    public ApiResponse vote() {
        TArticle article = new TArticle();
        List<TArticle> articles = articleService.queryList(new TArticle());
        for (int i = 0; i < 10; i++) {
            article = articles.get(new Random().nextInt(articles.size()));
            //票数+1
            redisUtil.hash().increment("article:" + article.getId(), "votes", 1);
            //计算分值
            redisUtil.zSet().incrementScore("article:score", article.getId() + "", 436);
        }
        return new ApiResponse();
    }


    @PostMapping("/sort/score")
    public ApiResponse sortScore() {
        ApiResponse res = new ApiResponse();
        Set<ZSetOperations.TypedTuple<String>> scoreSet = redisUtil.zSet()
                .reverseRangeWithScores("article:score", 0, 5);

        List<Map<String, Object>> articles = new ArrayList<>();
        for (ZSetOperations.TypedTuple<String> item : scoreSet) {
            Map<String, Object> amap = new HashMap<>();
            //获取所有键值对
            Map<String, Object> hmap = redisUtil.hash().entries("article:" + item.getValue());
            amap.put("id", item.getValue());
            amap.put("title", hmap.get("title"));
            amap.put("score", item.getScore());
            articles.add(amap);
        }
        res.setData(articles);
        return res;
    }

    @PostMapping("/sort/time")
    public ApiResponse sortTime() {
        ApiResponse res = new ApiResponse();
        Set<ZSetOperations.TypedTuple<String>> scoreSet = redisUtil.zSet()
                .reverseRangeWithScores("article:time", 0, -1);

        List<Map<String, Object>> articles = new ArrayList<>();
        for (ZSetOperations.TypedTuple<String> item : scoreSet) {
            Map<String, Object> amap = new HashMap<>();
            //获取所有键值对
            Map<String, Object> hmap = redisUtil.hash().entries("article:" + item.getValue());
            amap.put("id", item.getValue());
            amap.put("title", hmap.get("title"));
            amap.put("time", item.getScore());
            articles.add(amap);
        }
        res.setData(articles);
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Double.valueOf(System.currentTimeMillis() / 1000));
    }

}
