package  com.jin.model; 

import java.util.Date;

/**
*t_apply_msg
* 表名：进件申请信息
*/
public class TApplyMsg extends BaseModel {
    /** 主键ID  */ 
    private Long  id; 
    /** 用户ID  */ 
    private Long  userId; 
    /** 平台编码 */ 
    private String  platformCode; 
    /** 医院编码 */ 
    private String  hosCode; 
    /** 医院名称 */ 
    private String  hosName; 
    /** 项目编码 */ 
    private String  projCode; 
    /** 项目名称 */ 
    private String  projName; 
    /** 手机号 */ 
    private String  mobile; 
    /** 身份证名称 */ 
    private String  idcardName; 
    /** 身份证号 */ 
    private String  idcardNo; 
    /** 申请金额  */ 
    private Double  applyAmount; 
    /** 审批通过金额 */ 
    private Double  passAmount; 
    /** 申请期数  */ 
    private Integer  applyPeriod; 
    /** 每月还款金额  */ 
    private Double  monthRepayAmount; 
    /** 聚泛合同号 */ 
    private String  contractNumbers; 
    /** 聚泛唯一请求号 */ 
    private String  requestNumber; 
    /** 进件渠道 android, ios, wechat */ 
    private String  applyChannel; 
    /** 1000 初始状态，1001 三要素验证,1002 绑定银行卡,1003 贷款申请,1004 个人信息,1005 职业信息,1006 联系人信息,1007 运营商信息,1008 照片信息,1030 审核中,1031审核通过,1032拒绝,1033还款期,1034已逾期,1035严重逾期,1036结束 */ 
    private String  status; 
    /** 进件子状态，补件的时候用 */ 
    private String  childStatus; 
    /** 申请日期  */ 
    private Date  applyTime; 
    /** 审核时间 */ 
    private Date  reviewTime; 
    /** 记录创建时间  */ 
    private Date  createTime; 
    /** 修改时间时间  */ 
    private Date  updateTime; 
    /** 商户编码 */ 
    private String  merCode; 
    /** 商户名称 */ 
    private String  merName; 
    /** 预留字段1 */ 
    private String  reseverFirst; 
    /** 预留字段2 */ 
    private String  reseverTwo; 
    /** 预留字段3,放款状态 1:放款成功 2:放款失败 */ 
    private String  reseverThree; 
    /** 旷视业务流水号 */ 
    private String  faceBizid; 
    /** 人脸识别状态 */ 
    private String  faceStatus; 
    /** 当前还款期数 */ 
    private String  currentPeriod; 
    /** 补传附件内容，进件子状态是待补件的时候用 */ 
    private String  supplementInfo; 
    /** 经度 */ 
    private String  longitude; 
    /** 纬度 */ 
    private String  latitude; 
    /** 分期协议合同 */ 
    private String  contractUrl; 
    /** 审核通过时间 */ 
    private Date  reviewConfirmTime; 
    /** 放款时间 */ 
    private Date  loanTime; 
    /** 是否自持 0和null 是 非自持  1 是自持 */ 
    private String  selfHold; 
    /** 0 或null 是 自有，1-资管 */ 
    private String  assetSign; 
    /**  */ 
    private String  bankType; 
    /**  */ 
    private String  bankAccount; 
    /** 行业 */ 
    private String  industry; 
    /** 当前的还款计划类型(0或null:正常还款计划; 1:提前结清的还款计划) */ 
    private String  repaymentType; 
    /** 提前结清试算数据 */ 
    private String  advanceInfo; 
    /** 进件推送资管状态 */ 
    private String  assetPushResult; 
    /** 进件推送资管错误次数 */ 
    private Integer  assetPushCount; 
    /** 渠道 */ 
    private String  channel; 
    /** 错误信息 */ 
    private String  errorInfo; 
    /** 降额确认标识：null，0=无降额，1=降额待确认，2=降额确认完成 */ 
    private String  isConfirmAmt; 
    /** 信审拒绝原因 */ 
    private String  rejectMsg; 
    /**  */ 
    private String  verifyCode; 
    /** 申请天数 */ 
    private String  applyDay; 
    /** 接口时的额外数据 */ 
    private String  loanItem; 
    /** 快递数据 */ 
    private String  expressItem; 
    /** 资质审核标记 */ 
    private String  qualificationAuditPass; 
    /** 业务模式 默认1 为传统分期 */ 
    private String  bizType; 
    /** 费率编码：默认 default， */ 
    private String  feeCode; 
    /** 项目集合 */ 
    private String  projectList; 
    /** 0或null:关闭; 1:开启多级项目,商户未确认; 2:商户已确认 */ 
    private String  isSelectProject; 
    /** 需要额外签署的合同 */ 
    private String  caList; 
    /** 运营商授权的token */ 
    private String  creditToken; 
    /** 加密后的商户id */ 
    private String  accountNum; 
    /** 是否为收益前置  */ 
    private String  earlyIncomeFlag; 
    /** 收益前置的总金额  */ 
    private String  earlyIncomeAmount; 
    /** 临时二维码标志：是=true */ 
    private String  tempQrcodeMark; 
    /**  */ 
    private String  riskUserMemo; 
    /** 海尔的标识  */ 
    private String  capitalCode; 

    /** 主键ID  */ 
    public Long getId(){
        return id;
    }

    /** 主键ID  */ 
    public void setId(Long  id){
        this.id = id;
    }
    /** 用户ID  */ 
    public Long getUserId(){
        return userId;
    }

    /** 用户ID  */ 
    public void setUserId(Long  userId){
        this.userId = userId;
    }
    /** 平台编码 */ 
    public String getPlatformCode(){
        return platformCode;
    }

    /** 平台编码 */ 
    public void setPlatformCode(String  platformCode){
        this.platformCode = platformCode;
    }
    /** 医院编码 */ 
    public String getHosCode(){
        return hosCode;
    }

    /** 医院编码 */ 
    public void setHosCode(String  hosCode){
        this.hosCode = hosCode;
    }
    /** 医院名称 */ 
    public String getHosName(){
        return hosName;
    }

    /** 医院名称 */ 
    public void setHosName(String  hosName){
        this.hosName = hosName;
    }
    /** 项目编码 */ 
    public String getProjCode(){
        return projCode;
    }

    /** 项目编码 */ 
    public void setProjCode(String  projCode){
        this.projCode = projCode;
    }
    /** 项目名称 */ 
    public String getProjName(){
        return projName;
    }

    /** 项目名称 */ 
    public void setProjName(String  projName){
        this.projName = projName;
    }
    /** 手机号 */ 
    public String getMobile(){
        return mobile;
    }

    /** 手机号 */ 
    public void setMobile(String  mobile){
        this.mobile = mobile;
    }
    /** 身份证名称 */ 
    public String getIdcardName(){
        return idcardName;
    }

    /** 身份证名称 */ 
    public void setIdcardName(String  idcardName){
        this.idcardName = idcardName;
    }
    /** 身份证号 */ 
    public String getIdcardNo(){
        return idcardNo;
    }

    /** 身份证号 */ 
    public void setIdcardNo(String  idcardNo){
        this.idcardNo = idcardNo;
    }
    /** 申请金额  */ 
    public Double getApplyAmount(){
        return applyAmount;
    }

    /** 申请金额  */ 
    public void setApplyAmount(Double  applyAmount){
        this.applyAmount = applyAmount;
    }
    /** 审批通过金额 */ 
    public Double getPassAmount(){
        return passAmount;
    }

    /** 审批通过金额 */ 
    public void setPassAmount(Double  passAmount){
        this.passAmount = passAmount;
    }
    /** 申请期数  */ 
    public Integer getApplyPeriod(){
        return applyPeriod;
    }

    /** 申请期数  */ 
    public void setApplyPeriod(Integer  applyPeriod){
        this.applyPeriod = applyPeriod;
    }
    /** 每月还款金额  */ 
    public Double getMonthRepayAmount(){
        return monthRepayAmount;
    }

    /** 每月还款金额  */ 
    public void setMonthRepayAmount(Double  monthRepayAmount){
        this.monthRepayAmount = monthRepayAmount;
    }
    /** 聚泛合同号 */ 
    public String getContractNumbers(){
        return contractNumbers;
    }

    /** 聚泛合同号 */ 
    public void setContractNumbers(String  contractNumbers){
        this.contractNumbers = contractNumbers;
    }
    /** 聚泛唯一请求号 */ 
    public String getRequestNumber(){
        return requestNumber;
    }

    /** 聚泛唯一请求号 */ 
    public void setRequestNumber(String  requestNumber){
        this.requestNumber = requestNumber;
    }
    /** 进件渠道 android, ios, wechat */ 
    public String getApplyChannel(){
        return applyChannel;
    }

    /** 进件渠道 android, ios, wechat */ 
    public void setApplyChannel(String  applyChannel){
        this.applyChannel = applyChannel;
    }
    /** 1000 初始状态，1001 三要素验证,1002 绑定银行卡,1003 贷款申请,1004 个人信息,1005 职业信息,1006 联系人信息,1007 运营商信息,1008 照片信息,1030 审核中,1031审核通过,1032拒绝,1033还款期,1034已逾期,1035严重逾期,1036结束 */ 
    public String getStatus(){
        return status;
    }

    /** 1000 初始状态，1001 三要素验证,1002 绑定银行卡,1003 贷款申请,1004 个人信息,1005 职业信息,1006 联系人信息,1007 运营商信息,1008 照片信息,1030 审核中,1031审核通过,1032拒绝,1033还款期,1034已逾期,1035严重逾期,1036结束 */ 
    public void setStatus(String  status){
        this.status = status;
    }
    /** 进件子状态，补件的时候用 */ 
    public String getChildStatus(){
        return childStatus;
    }

    /** 进件子状态，补件的时候用 */ 
    public void setChildStatus(String  childStatus){
        this.childStatus = childStatus;
    }
    /** 申请日期  */ 
    public Date getApplyTime(){
        return applyTime;
    }

    /** 申请日期  */ 
    public void setApplyTime(Date  applyTime){
        this.applyTime = applyTime;
    }
    /** 审核时间 */ 
    public Date getReviewTime(){
        return reviewTime;
    }

    /** 审核时间 */ 
    public void setReviewTime(Date  reviewTime){
        this.reviewTime = reviewTime;
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
    /** 商户编码 */ 
    public String getMerCode(){
        return merCode;
    }

    /** 商户编码 */ 
    public void setMerCode(String  merCode){
        this.merCode = merCode;
    }
    /** 商户名称 */ 
    public String getMerName(){
        return merName;
    }

    /** 商户名称 */ 
    public void setMerName(String  merName){
        this.merName = merName;
    }
    /** 预留字段1 */ 
    public String getReseverFirst(){
        return reseverFirst;
    }

    /** 预留字段1 */ 
    public void setReseverFirst(String  reseverFirst){
        this.reseverFirst = reseverFirst;
    }
    /** 预留字段2 */ 
    public String getReseverTwo(){
        return reseverTwo;
    }

    /** 预留字段2 */ 
    public void setReseverTwo(String  reseverTwo){
        this.reseverTwo = reseverTwo;
    }
    /** 预留字段3,放款状态 1:放款成功 2:放款失败 */ 
    public String getReseverThree(){
        return reseverThree;
    }

    /** 预留字段3,放款状态 1:放款成功 2:放款失败 */ 
    public void setReseverThree(String  reseverThree){
        this.reseverThree = reseverThree;
    }
    /** 旷视业务流水号 */ 
    public String getFaceBizid(){
        return faceBizid;
    }

    /** 旷视业务流水号 */ 
    public void setFaceBizid(String  faceBizid){
        this.faceBizid = faceBizid;
    }
    /** 人脸识别状态 */ 
    public String getFaceStatus(){
        return faceStatus;
    }

    /** 人脸识别状态 */ 
    public void setFaceStatus(String  faceStatus){
        this.faceStatus = faceStatus;
    }
    /** 当前还款期数 */ 
    public String getCurrentPeriod(){
        return currentPeriod;
    }

    /** 当前还款期数 */ 
    public void setCurrentPeriod(String  currentPeriod){
        this.currentPeriod = currentPeriod;
    }
    /** 补传附件内容，进件子状态是待补件的时候用 */ 
    public String getSupplementInfo(){
        return supplementInfo;
    }

    /** 补传附件内容，进件子状态是待补件的时候用 */ 
    public void setSupplementInfo(String  supplementInfo){
        this.supplementInfo = supplementInfo;
    }
    /** 经度 */ 
    public String getLongitude(){
        return longitude;
    }

    /** 经度 */ 
    public void setLongitude(String  longitude){
        this.longitude = longitude;
    }
    /** 纬度 */ 
    public String getLatitude(){
        return latitude;
    }

    /** 纬度 */ 
    public void setLatitude(String  latitude){
        this.latitude = latitude;
    }
    /** 分期协议合同 */ 
    public String getContractUrl(){
        return contractUrl;
    }

    /** 分期协议合同 */ 
    public void setContractUrl(String  contractUrl){
        this.contractUrl = contractUrl;
    }
    /** 审核通过时间 */ 
    public Date getReviewConfirmTime(){
        return reviewConfirmTime;
    }

    /** 审核通过时间 */ 
    public void setReviewConfirmTime(Date  reviewConfirmTime){
        this.reviewConfirmTime = reviewConfirmTime;
    }
    /** 放款时间 */ 
    public Date getLoanTime(){
        return loanTime;
    }

    /** 放款时间 */ 
    public void setLoanTime(Date  loanTime){
        this.loanTime = loanTime;
    }
    /** 是否自持 0和null 是 非自持  1 是自持 */ 
    public String getSelfHold(){
        return selfHold;
    }

    /** 是否自持 0和null 是 非自持  1 是自持 */ 
    public void setSelfHold(String  selfHold){
        this.selfHold = selfHold;
    }
    /** 0 或null 是 自有，1-资管 */ 
    public String getAssetSign(){
        return assetSign;
    }

    /** 0 或null 是 自有，1-资管 */ 
    public void setAssetSign(String  assetSign){
        this.assetSign = assetSign;
    }
    /**  */ 
    public String getBankType(){
        return bankType;
    }

    /**  */ 
    public void setBankType(String  bankType){
        this.bankType = bankType;
    }
    /**  */ 
    public String getBankAccount(){
        return bankAccount;
    }

    /**  */ 
    public void setBankAccount(String  bankAccount){
        this.bankAccount = bankAccount;
    }
    /** 行业 */ 
    public String getIndustry(){
        return industry;
    }

    /** 行业 */ 
    public void setIndustry(String  industry){
        this.industry = industry;
    }
    /** 当前的还款计划类型(0或null:正常还款计划; 1:提前结清的还款计划) */ 
    public String getRepaymentType(){
        return repaymentType;
    }

    /** 当前的还款计划类型(0或null:正常还款计划; 1:提前结清的还款计划) */ 
    public void setRepaymentType(String  repaymentType){
        this.repaymentType = repaymentType;
    }
    /** 提前结清试算数据 */ 
    public String getAdvanceInfo(){
        return advanceInfo;
    }

    /** 提前结清试算数据 */ 
    public void setAdvanceInfo(String  advanceInfo){
        this.advanceInfo = advanceInfo;
    }
    /** 进件推送资管状态 */ 
    public String getAssetPushResult(){
        return assetPushResult;
    }

    /** 进件推送资管状态 */ 
    public void setAssetPushResult(String  assetPushResult){
        this.assetPushResult = assetPushResult;
    }
    /** 进件推送资管错误次数 */ 
    public Integer getAssetPushCount(){
        return assetPushCount;
    }

    /** 进件推送资管错误次数 */ 
    public void setAssetPushCount(Integer  assetPushCount){
        this.assetPushCount = assetPushCount;
    }
    /** 渠道 */ 
    public String getChannel(){
        return channel;
    }

    /** 渠道 */ 
    public void setChannel(String  channel){
        this.channel = channel;
    }
    /** 错误信息 */ 
    public String getErrorInfo(){
        return errorInfo;
    }

    /** 错误信息 */ 
    public void setErrorInfo(String  errorInfo){
        this.errorInfo = errorInfo;
    }
    /** 降额确认标识：null，0=无降额，1=降额待确认，2=降额确认完成 */ 
    public String getIsConfirmAmt(){
        return isConfirmAmt;
    }

    /** 降额确认标识：null，0=无降额，1=降额待确认，2=降额确认完成 */ 
    public void setIsConfirmAmt(String  isConfirmAmt){
        this.isConfirmAmt = isConfirmAmt;
    }
    /** 信审拒绝原因 */ 
    public String getRejectMsg(){
        return rejectMsg;
    }

    /** 信审拒绝原因 */ 
    public void setRejectMsg(String  rejectMsg){
        this.rejectMsg = rejectMsg;
    }
    /**  */ 
    public String getVerifyCode(){
        return verifyCode;
    }

    /**  */ 
    public void setVerifyCode(String  verifyCode){
        this.verifyCode = verifyCode;
    }
    /** 申请天数 */ 
    public String getApplyDay(){
        return applyDay;
    }

    /** 申请天数 */ 
    public void setApplyDay(String  applyDay){
        this.applyDay = applyDay;
    }
    /** 接口时的额外数据 */ 
    public String getLoanItem(){
        return loanItem;
    }

    /** 接口时的额外数据 */ 
    public void setLoanItem(String  loanItem){
        this.loanItem = loanItem;
    }
    /** 快递数据 */ 
    public String getExpressItem(){
        return expressItem;
    }

    /** 快递数据 */ 
    public void setExpressItem(String  expressItem){
        this.expressItem = expressItem;
    }
    /** 资质审核标记 */ 
    public String getQualificationAuditPass(){
        return qualificationAuditPass;
    }

    /** 资质审核标记 */ 
    public void setQualificationAuditPass(String  qualificationAuditPass){
        this.qualificationAuditPass = qualificationAuditPass;
    }
    /** 业务模式 默认1 为传统分期 */ 
    public String getBizType(){
        return bizType;
    }

    /** 业务模式 默认1 为传统分期 */ 
    public void setBizType(String  bizType){
        this.bizType = bizType;
    }
    /** 费率编码：默认 default， */ 
    public String getFeeCode(){
        return feeCode;
    }

    /** 费率编码：默认 default， */ 
    public void setFeeCode(String  feeCode){
        this.feeCode = feeCode;
    }
    /** 项目集合 */ 
    public String getProjectList(){
        return projectList;
    }

    /** 项目集合 */ 
    public void setProjectList(String  projectList){
        this.projectList = projectList;
    }
    /** 0或null:关闭; 1:开启多级项目,商户未确认; 2:商户已确认 */ 
    public String getIsSelectProject(){
        return isSelectProject;
    }

    /** 0或null:关闭; 1:开启多级项目,商户未确认; 2:商户已确认 */ 
    public void setIsSelectProject(String  isSelectProject){
        this.isSelectProject = isSelectProject;
    }
    /** 需要额外签署的合同 */ 
    public String getCaList(){
        return caList;
    }

    /** 需要额外签署的合同 */ 
    public void setCaList(String  caList){
        this.caList = caList;
    }
    /** 运营商授权的token */ 
    public String getCreditToken(){
        return creditToken;
    }

    /** 运营商授权的token */ 
    public void setCreditToken(String  creditToken){
        this.creditToken = creditToken;
    }
    /** 加密后的商户id */ 
    public String getAccountNum(){
        return accountNum;
    }

    /** 加密后的商户id */ 
    public void setAccountNum(String  accountNum){
        this.accountNum = accountNum;
    }
    /** 是否为收益前置  */ 
    public String getEarlyIncomeFlag(){
        return earlyIncomeFlag;
    }

    /** 是否为收益前置  */ 
    public void setEarlyIncomeFlag(String  earlyIncomeFlag){
        this.earlyIncomeFlag = earlyIncomeFlag;
    }
    /** 收益前置的总金额  */ 
    public String getEarlyIncomeAmount(){
        return earlyIncomeAmount;
    }

    /** 收益前置的总金额  */ 
    public void setEarlyIncomeAmount(String  earlyIncomeAmount){
        this.earlyIncomeAmount = earlyIncomeAmount;
    }
    /** 临时二维码标志：是=true */ 
    public String getTempQrcodeMark(){
        return tempQrcodeMark;
    }

    /** 临时二维码标志：是=true */ 
    public void setTempQrcodeMark(String  tempQrcodeMark){
        this.tempQrcodeMark = tempQrcodeMark;
    }
    /**  */ 
    public String getRiskUserMemo(){
        return riskUserMemo;
    }

    /**  */ 
    public void setRiskUserMemo(String  riskUserMemo){
        this.riskUserMemo = riskUserMemo;
    }
    /** 海尔的标识  */ 
    public String getCapitalCode(){
        return capitalCode;
    }

    /** 海尔的标识  */ 
    public void setCapitalCode(String  capitalCode){
        this.capitalCode = capitalCode;
    }
}
