package  com.jin.model; 

import java.util.Date;

/**
*t_article
* 表名：
*/
public class TArticle extends BaseModel {
    /**  */ 
    private Long  id; 
    /** 标题 */ 
    private String  title; 
    /**  */ 
    private String  url; 
    /**  */ 
    private Long  userId; 
    /**  */ 
    private String  time; 
    /** 投票数 */ 
    private Integer  votes; 

    /**  */ 
    public Long getId(){
        return id;
    }

    /**  */ 
    public void setId(Long  id){
        this.id = id;
    }
    /** 标题 */ 
    public String getTitle(){
        return title;
    }

    /** 标题 */ 
    public void setTitle(String  title){
        this.title = title;
    }
    /**  */ 
    public String getUrl(){
        return url;
    }

    /**  */ 
    public void setUrl(String  url){
        this.url = url;
    }
    /**  */ 
    public Long getUserId(){
        return userId;
    }

    /**  */ 
    public void setUserId(Long  userId){
        this.userId = userId;
    }
    /**  */ 
    public String getTime(){
        return time;
    }

    /**  */ 
    public void setTime(String  time){
        this.time = time;
    }
    /** 投票数 */ 
    public Integer getVotes(){
        return votes;
    }

    /** 投票数 */ 
    public void setVotes(Integer  votes){
        this.votes = votes;
    }
}
