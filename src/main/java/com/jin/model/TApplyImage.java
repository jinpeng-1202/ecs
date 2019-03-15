package  com.jin.model; 

import java.util.Date;

/**
*t_apply_image
* 表名：
*/
public class TApplyImage extends BaseModel {
    /**  */ 
    private Long  id; 
    /**  */ 
    private Long  userId; 
    /**  */ 
    private Long  applyId; 
    /**  */ 
    private String  imageType; 
    /**  */ 
    private String  imageUrl; 
    /**  */ 
    private Integer  upload; 
    /**  */ 
    private String  description; 
    /**  */ 
    private String  supplementImg; 
    /**  */ 
    private Date  createTime; 
    /**  */ 
    private Date  updateTime; 
    /**  */ 
    private String  outImageUrl; 
    /**  */ 
    private String  download; 
    /**  */ 
    private String  supplementStatus; 
    /**  */ 
    private String  ossImageUrl; 
    /**  */ 
    private String  valid; 

    /**  */ 
    public Long getId(){
        return id;
    }

    /**  */ 
    public void setId(Long  id){
        this.id = id;
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
    public Long getApplyId(){
        return applyId;
    }

    /**  */ 
    public void setApplyId(Long  applyId){
        this.applyId = applyId;
    }
    /**  */ 
    public String getImageType(){
        return imageType;
    }

    /**  */ 
    public void setImageType(String  imageType){
        this.imageType = imageType;
    }
    /**  */ 
    public String getImageUrl(){
        return imageUrl;
    }

    /**  */ 
    public void setImageUrl(String  imageUrl){
        this.imageUrl = imageUrl;
    }
    /**  */ 
    public Integer getUpload(){
        return upload;
    }

    /**  */ 
    public void setUpload(Integer  upload){
        this.upload = upload;
    }
    /**  */ 
    public String getDescription(){
        return description;
    }

    /**  */ 
    public void setDescription(String  description){
        this.description = description;
    }
    /**  */ 
    public String getSupplementImg(){
        return supplementImg;
    }

    /**  */ 
    public void setSupplementImg(String  supplementImg){
        this.supplementImg = supplementImg;
    }
    /**  */ 
    public Date getCreateTime(){
        return createTime;
    }

    /**  */ 
    public void setCreateTime(Date  createTime){
        this.createTime = createTime;
    }
    /**  */ 
    public Date getUpdateTime(){
        return updateTime;
    }

    /**  */ 
    public void setUpdateTime(Date  updateTime){
        this.updateTime = updateTime;
    }
    /**  */ 
    public String getOutImageUrl(){
        return outImageUrl;
    }

    /**  */ 
    public void setOutImageUrl(String  outImageUrl){
        this.outImageUrl = outImageUrl;
    }
    /**  */ 
    public String getDownload(){
        return download;
    }

    /**  */ 
    public void setDownload(String  download){
        this.download = download;
    }
    /**  */ 
    public String getSupplementStatus(){
        return supplementStatus;
    }

    /**  */ 
    public void setSupplementStatus(String  supplementStatus){
        this.supplementStatus = supplementStatus;
    }
    /**  */ 
    public String getOssImageUrl(){
        return ossImageUrl;
    }

    /**  */ 
    public void setOssImageUrl(String  ossImageUrl){
        this.ossImageUrl = ossImageUrl;
    }
    /**  */ 
    public String getValid(){
        return valid;
    }

    /**  */ 
    public void setValid(String  valid){
        this.valid = valid;
    }
}
