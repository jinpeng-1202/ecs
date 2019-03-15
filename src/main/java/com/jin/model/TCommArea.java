package  com.jin.model; 

import java.util.Date;

/**
*t_comm_area
* 表名：
*/
public class TCommArea extends BaseModel {
    /**  */ 
    private Integer  ID; 
    /**  */ 
    private String  NAME; 
    /**  */ 
    private Integer  PARENTID; 
    /**  */ 
    private String  SHORTNAME; 
    /**  */ 
    private Integer  LEVELTYPE; 
    /**  */ 
    private String  CITYCODE; 
    /**  */ 
    private String  ZIPCODE; 
    /**  */ 
    private String  MERGERNAME; 
    /**  */ 
    private String  LNG; 
    /**  */ 
    private String  LAT; 
    /**  */ 
    private String  PINYIN; 

    /**  */ 
    public Integer getID(){
        return ID;
    }

    /**  */ 
    public void setID(Integer  ID){
        this.ID = ID;
    }
    /**  */ 
    public String getNAME(){
        return NAME;
    }

    /**  */ 
    public void setNAME(String  NAME){
        this.NAME = NAME;
    }
    /**  */ 
    public Integer getPARENTID(){
        return PARENTID;
    }

    /**  */ 
    public void setPARENTID(Integer  PARENTID){
        this.PARENTID = PARENTID;
    }
    /**  */ 
    public String getSHORTNAME(){
        return SHORTNAME;
    }

    /**  */ 
    public void setSHORTNAME(String  SHORTNAME){
        this.SHORTNAME = SHORTNAME;
    }
    /**  */ 
    public Integer getLEVELTYPE(){
        return LEVELTYPE;
    }

    /**  */ 
    public void setLEVELTYPE(Integer  LEVELTYPE){
        this.LEVELTYPE = LEVELTYPE;
    }
    /**  */ 
    public String getCITYCODE(){
        return CITYCODE;
    }

    /**  */ 
    public void setCITYCODE(String  CITYCODE){
        this.CITYCODE = CITYCODE;
    }
    /**  */ 
    public String getZIPCODE(){
        return ZIPCODE;
    }

    /**  */ 
    public void setZIPCODE(String  ZIPCODE){
        this.ZIPCODE = ZIPCODE;
    }
    /**  */ 
    public String getMERGERNAME(){
        return MERGERNAME;
    }

    /**  */ 
    public void setMERGERNAME(String  MERGERNAME){
        this.MERGERNAME = MERGERNAME;
    }
    /**  */ 
    public String getLNG(){
        return LNG;
    }

    /**  */ 
    public void setLNG(String  LNG){
        this.LNG = LNG;
    }
    /**  */ 
    public String getLAT(){
        return LAT;
    }

    /**  */ 
    public void setLAT(String  LAT){
        this.LAT = LAT;
    }
    /**  */ 
    public String getPINYIN(){
        return PINYIN;
    }

    /**  */ 
    public void setPINYIN(String  PINYIN){
        this.PINYIN = PINYIN;
    }
}
