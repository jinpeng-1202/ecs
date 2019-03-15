package  com.jin.model; 

import java.util.Date;

/**
*t_user
* 表名：用户表
*/
public class TUser extends BaseModel {
    /** 主键ID  */ 
    private Long  id; 
    /** 手机号  */ 
    private String  mobile; 
    /**  */ 
    private String  outUserId; 
    /**  */ 
    private String  appMobile; 
    /**  */ 
    private String  appUserId; 
    /** 微信令牌  */ 
    private String  wechatNo; 
    /** 登录密码 8位以上，字母+数字，SHA-512保存,需要与登录名一起HASH */ 
    private String  password; 
    /** 姓名  */ 
    private String  realName; 
    /** 身份证号  */ 
    private String  idNo; 
    /** 推送ID  */ 
    private String  pushId; 
    /** 设备类型 IOS:苹果手机 ADNROID:安卓手机  */ 
    private String  appType; 
    /** 设备版本  */ 
    private String  deviceVersion; 
    /** 设备操作系统  */ 
    private String  operatingSystem; 
    /** 注册渠道 android, ios,wechat */ 
    private String  registerChannel; 
    /** 平台编码 */ 
    private String  platformCode; 
    /** 帐号状态 1正常 2 已锁定  */ 
    private String  status; 
    /** 记录创建时间  */ 
    private Date  createTime; 
    /** 修改时间时间  */ 
    private Date  updateTime; 
    /** 保留字段 */ 
    private String  resever; 
    /** 人脸识别校验时间 */ 
    private String  faceTime; 
    /** 颜玖的主页面url */ 
    private String  backIndexUrl; 
    /** 颜玖商品页面url */ 
    private String  backShopUrl; 
    /** 推送乔融的openid */ 
    private String  openId; 
    /** 身份证有效期起止时间 */ 
    private String  idcardStartDate; 
    /** 身份证有效期终止时间 */ 
    private String  idcardEndDate; 
    /** 身份证签发机关 */ 
    private String  issueAgency; 
    /**  */ 
    private String  extMobile; 
    /** 合同平台注册标识：true=已注册，false=未注册 */ 
    private String  contractRegMark; 
    /**  */ 
    private String  idcardAddr; 
    /** 乔融的多个out_user_id */ 
    private String  extOutUserId; 

    /** 主键ID  */ 
    public Long getId(){
        return id;
    }

    /** 主键ID  */ 
    public void setId(Long  id){
        this.id = id;
    }
    /** 手机号  */ 
    public String getMobile(){
        return mobile;
    }

    /** 手机号  */ 
    public void setMobile(String  mobile){
        this.mobile = mobile;
    }
    /**  */ 
    public String getOutUserId(){
        return outUserId;
    }

    /**  */ 
    public void setOutUserId(String  outUserId){
        this.outUserId = outUserId;
    }
    /**  */ 
    public String getAppMobile(){
        return appMobile;
    }

    /**  */ 
    public void setAppMobile(String  appMobile){
        this.appMobile = appMobile;
    }
    /**  */ 
    public String getAppUserId(){
        return appUserId;
    }

    /**  */ 
    public void setAppUserId(String  appUserId){
        this.appUserId = appUserId;
    }
    /** 微信令牌  */ 
    public String getWechatNo(){
        return wechatNo;
    }

    /** 微信令牌  */ 
    public void setWechatNo(String  wechatNo){
        this.wechatNo = wechatNo;
    }
    /** 登录密码 8位以上，字母+数字，SHA-512保存,需要与登录名一起HASH */ 
    public String getPassword(){
        return password;
    }

    /** 登录密码 8位以上，字母+数字，SHA-512保存,需要与登录名一起HASH */ 
    public void setPassword(String  password){
        this.password = password;
    }
    /** 姓名  */ 
    public String getRealName(){
        return realName;
    }

    /** 姓名  */ 
    public void setRealName(String  realName){
        this.realName = realName;
    }
    /** 身份证号  */ 
    public String getIdNo(){
        return idNo;
    }

    /** 身份证号  */ 
    public void setIdNo(String  idNo){
        this.idNo = idNo;
    }
    /** 推送ID  */ 
    public String getPushId(){
        return pushId;
    }

    /** 推送ID  */ 
    public void setPushId(String  pushId){
        this.pushId = pushId;
    }
    /** 设备类型 IOS:苹果手机 ADNROID:安卓手机  */ 
    public String getAppType(){
        return appType;
    }

    /** 设备类型 IOS:苹果手机 ADNROID:安卓手机  */ 
    public void setAppType(String  appType){
        this.appType = appType;
    }
    /** 设备版本  */ 
    public String getDeviceVersion(){
        return deviceVersion;
    }

    /** 设备版本  */ 
    public void setDeviceVersion(String  deviceVersion){
        this.deviceVersion = deviceVersion;
    }
    /** 设备操作系统  */ 
    public String getOperatingSystem(){
        return operatingSystem;
    }

    /** 设备操作系统  */ 
    public void setOperatingSystem(String  operatingSystem){
        this.operatingSystem = operatingSystem;
    }
    /** 注册渠道 android, ios,wechat */ 
    public String getRegisterChannel(){
        return registerChannel;
    }

    /** 注册渠道 android, ios,wechat */ 
    public void setRegisterChannel(String  registerChannel){
        this.registerChannel = registerChannel;
    }
    /** 平台编码 */ 
    public String getPlatformCode(){
        return platformCode;
    }

    /** 平台编码 */ 
    public void setPlatformCode(String  platformCode){
        this.platformCode = platformCode;
    }
    /** 帐号状态 1正常 2 已锁定  */ 
    public String getStatus(){
        return status;
    }

    /** 帐号状态 1正常 2 已锁定  */ 
    public void setStatus(String  status){
        this.status = status;
    }
    /** 记录创建时间  */ 
    public Date getCreateTime(){
        return createTime;
    }

    /** 记录创建时间  */ 
    public void setCreateTime(Date  createTime){
        this.createTime = createTime;
    }
    /** 修改时间时间  */ 
    public Date getUpdateTime(){
        return updateTime;
    }

    /** 修改时间时间  */ 
    public void setUpdateTime(Date  updateTime){
        this.updateTime = updateTime;
    }
    /** 保留字段 */ 
    public String getResever(){
        return resever;
    }

    /** 保留字段 */ 
    public void setResever(String  resever){
        this.resever = resever;
    }
    /** 人脸识别校验时间 */ 
    public String getFaceTime(){
        return faceTime;
    }

    /** 人脸识别校验时间 */ 
    public void setFaceTime(String  faceTime){
        this.faceTime = faceTime;
    }
    /** 颜玖的主页面url */ 
    public String getBackIndexUrl(){
        return backIndexUrl;
    }

    /** 颜玖的主页面url */ 
    public void setBackIndexUrl(String  backIndexUrl){
        this.backIndexUrl = backIndexUrl;
    }
    /** 颜玖商品页面url */ 
    public String getBackShopUrl(){
        return backShopUrl;
    }

    /** 颜玖商品页面url */ 
    public void setBackShopUrl(String  backShopUrl){
        this.backShopUrl = backShopUrl;
    }
    /** 推送乔融的openid */ 
    public String getOpenId(){
        return openId;
    }

    /** 推送乔融的openid */ 
    public void setOpenId(String  openId){
        this.openId = openId;
    }
    /** 身份证有效期起止时间 */ 
    public String getIdcardStartDate(){
        return idcardStartDate;
    }

    /** 身份证有效期起止时间 */ 
    public void setIdcardStartDate(String  idcardStartDate){
        this.idcardStartDate = idcardStartDate;
    }
    /** 身份证有效期终止时间 */ 
    public String getIdcardEndDate(){
        return idcardEndDate;
    }

    /** 身份证有效期终止时间 */ 
    public void setIdcardEndDate(String  idcardEndDate){
        this.idcardEndDate = idcardEndDate;
    }
    /** 身份证签发机关 */ 
    public String getIssueAgency(){
        return issueAgency;
    }

    /** 身份证签发机关 */ 
    public void setIssueAgency(String  issueAgency){
        this.issueAgency = issueAgency;
    }
    /**  */ 
    public String getExtMobile(){
        return extMobile;
    }

    /**  */ 
    public void setExtMobile(String  extMobile){
        this.extMobile = extMobile;
    }
    /** 合同平台注册标识：true=已注册，false=未注册 */ 
    public String getContractRegMark(){
        return contractRegMark;
    }

    /** 合同平台注册标识：true=已注册，false=未注册 */ 
    public void setContractRegMark(String  contractRegMark){
        this.contractRegMark = contractRegMark;
    }
    /**  */ 
    public String getIdcardAddr(){
        return idcardAddr;
    }

    /**  */ 
    public void setIdcardAddr(String  idcardAddr){
        this.idcardAddr = idcardAddr;
    }
    /** 乔融的多个out_user_id */ 
    public String getExtOutUserId(){
        return extOutUserId;
    }

    /** 乔融的多个out_user_id */ 
    public void setExtOutUserId(String  extOutUserId){
        this.extOutUserId = extOutUserId;
    }
}
