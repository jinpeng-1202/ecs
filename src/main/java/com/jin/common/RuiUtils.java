package com.jin.common;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RuiUtils {

    private static final Logger logger = LoggerFactory.getLogger(RuiUtils.class);


    public static String sortMap(Map<String, String> params) {
        //参数按字母升序排列
        List<String> keyLst = new ArrayList<>();
        keyLst.addAll(params.keySet());
        Collections.sort(keyLst);
        StringBuffer data = new StringBuffer("");
        for (String key : keyLst) {
            if ("sign".equals(key)) {
                continue;
            }
            if (StringUtils.isNotEmpty(data.toString())) {
                data.append("&");
            }
            data.append(key + "=" + params.get(key));
        }
        return data.toString();
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public static String getRandomByLength(Integer length) {
        String str = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            boolean b = random.nextBoolean();
            if (b) { // 字符串
                // int choice = random.nextBoolean() ? 65 : 97; 取得65大写字母还是97小写字母
                str += (char) (65 + random.nextInt(26));// 取得大写字母
            } else { // 数字
                str += String.valueOf(random.nextInt(10));
            }
        }
        return str;
    }


    public static String getBirthByIdNo(String id) {
        String year = id.substring(6, 10);// 截取年
        String month = id.substring(10, 12);// 截取月份
        String day = id.substring(12, 14);// 截取天
        StringBuffer stringBuffer = new StringBuffer("");
        stringBuffer.append(year).append("-").append(month).append("-").append(day);
        return stringBuffer.toString();
    }

    public static String getRandomEstateCode() {
        Random rand = new Random();
        return String.valueOf(rand.nextInt(7) + 1);
    }






    public static String judgeSexByIdNo(String no) {

        String sex = "0";
        try {
            String[] applGender = RuiUtils.getBirthAndGender(no);
            if (applGender[1].equals("男")) {
                sex = "1";
            } else if (applGender[1].equals("女")) {
                sex = "0";
            }
        } catch (Exception e) {
        }
        return sex;
    }

    public static String getRandomEduLevel() {
        Random rand = new Random();
        return String.valueOf(rand.nextInt(7) + 1);
    }


    public static Double getRandomMonthIncome() {
        Random rand = new Random();
        return Double.valueOf((rand.nextInt(10) + 1) * 1000);
    }

    /**
     * 判断字符串是否为null 或者 trim后为"";
     *
     * @param str
     * @return
     */
    public static boolean isTrimEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否 不 为null 而且 trim后 不 等于"";
     *
     * @param str
     * @return
     */
    public static boolean isNotTrimEmpty(String str) {
        return !isTrimEmpty(str);
    }

    /**
     * 获取指定日期格式
     *
     * @param date
     * @param format
     * @return
     */
    public static String defaultFormate(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static String[] getBirthAndGender(String zjNo) throws Exception {
        String[] identityAry = new String[]{"", ""};
        if (RuiUtils.isNotTrimEmpty(zjNo) && zjNo.toUpperCase().matches("[0-9]{15}|[0-9]{17}([0-9]|X)")) {
            //15位身份证
            if (zjNo.length() == 15) {
                String birth = zjNo.substring(6, 12);
                String gender = Integer.parseInt(zjNo.substring(14)) % 2 == 0 ? "女" : "男";
                identityAry[0] = "19" + birth;
                identityAry[1] = gender;
            } else if (zjNo.length() == 18) {
                //18位身份证
                String birth = zjNo.substring(6, 14);
                String gender = Integer.parseInt(zjNo.substring(16, 17)) % 2 == 0 ? "女" : "男";
                identityAry[0] = birth;
                identityAry[1] = gender;
            }
        }
        return identityAry;
    }

    /**
     * 获取6位随机数
     *
     * @return
     */
    public static String getTransSeq() {
        String seq = String.valueOf(Math.random());
        seq = seq.substring(seq.indexOf('.') + 1);
        if (seq.length() < 6) {
            seq = RuiUtils.fillString(seq, '0', 6, false);
        } else if (seq.length() > 6) {
            seq = seq.substring(0, 6);
        }
        return seq;
    }

    /**
     * @param value       传入的字符
     * @param filler      用来填充的数字
     * @param totalLength 总的字符长度
     * @param atEnd       数字房子头部或者结尾
     * @return
     */
    public static String fillString(String value, char filler,
                                    int totalLength, boolean atEnd) {
        byte[] tempbyte = value.getBytes();
        int currentLength = tempbyte.length;
        int delta = totalLength - currentLength;
        for (int i = 0; i < delta; i++) {
            /**
             * 将数字放在头部
             */
            if (atEnd) {
                value += filler;
            } else {
                /**
                 * 将数字放在结尾
                 */
                value = filler + value;
            }
        }
        return value;
    }

    /**
     * 判断Collection是否为空
     *
     * @param collection 需要判断的Collection
     * @return boolean
     */
    public static boolean collectionIsEmpty(Collection collection) {
        if (collection == null || collection.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断Collection是否不为空
     *
     * @param collection 需要判断的Collection
     * @return boolean
     */
    public static boolean collectionIsNotEmpty(Collection collection) {
        return !collectionIsEmpty(collection);
    }

    /**
     * 随机获取四位数字
     *
     * @return
     */
    public static String getFourRandom() {
        Random random = new Random();
        String fourRandom = random.nextInt(10000) + "";
        int randLength = fourRandom.length();
        if (randLength < 4) {
            for (int i = 1; i <= 4 - randLength; i++)
                fourRandom = "0" + fourRandom;
        }
        return fourRandom;
    }



    /**
     * 随机获取6位数字
     *
     * @return
     */
    public static String getSixRandom() {
        Double d = (Math.random() * 9 + 1) * 100000;
        return new BigDecimal(d).setScale(0, BigDecimal.ROUND_DOWN).toString();
    }


    /**
     * 计算时间差
     *
     * @throws Exception
     */
    public static int daysBetween(String smdate, String bdate) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Math.abs(Integer.parseInt(String.valueOf(between_days)));


    }

    /**
     * 计算两个时间之间相差秒数	(endTime-startTime)
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static Long betweenTimes(String startTime, String endTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar cal = Calendar.getInstance();
        long time1 = 0;
        long time2 = 0;
        try {
            cal.setTime(sdf.parse(startTime));
            time1 = cal.getTimeInMillis();
            cal.setTime(sdf.parse(endTime));
            time2 = cal.getTimeInMillis();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return (time2 - time1) / 1000;
    }

    public static long getLongValue(Long lon) {
        if (lon == null) {
            return new Long(0).longValue();
        } else {
            return lon.longValue();
        }
    }

    /**
     * 生成固定长度的随机整数
     *
     * @param length
     * @return
     * @Title: getFourRandom
     * @date 2017年7月6日 下午7:42:39
     * @author 邓夫
     * @modifier
     * @modifydate
     */
    public static String getFourRandom(int length) {
        StringBuffer sb = new StringBuffer();
        String str = "0123456789";
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            int num = r.nextInt(str.length());
            sb.append(str.charAt(num));
            str = str.replace((str.charAt(num) + ""), "");
        }
        return sb.toString();
    }


    /**
     * Map 转 javaBean
     *
     * @param type
     * @param map
     * @return
     * @throws Exception
     */
    public static Object convertMapTobean(Class type, Map map) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
        Object obj = type.newInstance(); // 创建 JavaBean 对象
        // 给 JavaBean 对象的属性赋值
        PropertyDescriptor[] propertyDescriptors = beanInfo
                .getPropertyDescriptors();
        for (PropertyDescriptor descriptor : propertyDescriptors) {
            String propertyName = descriptor.getName();
            if (map.containsKey(propertyName)) {
                // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
                try {
                    Object value = map.get(propertyName);
                    Object[] args = new Object[1];
                    args[0] = value;
                    descriptor.getWriteMethod().invoke(obj, args);
                } catch (Exception e) {
                    logger.info("error");
                }
            }
        }
        return obj;
    }

    /**
     * 获取制定位数的随机数
     *
     * @return
     */
    public static String getTransSeqByNumber(int number) {
        String seq = String.valueOf(Math.random());
        seq = seq.substring(seq.indexOf('.') + 1);
        if (seq.length() < number) {
            seq = RuiUtils.fillString(seq, '0', number, false);
        } else if (seq.length() > number) {
            seq = seq.substring(0, number);
        }
        return seq;
    }

    /**
     * url参数转Map
     *
     * @param paramStr
     * @return
     */
    public static Map convertUrlStrToMap(String paramStr) {
        String[] params = paramStr.split("&");
        Map<String, String> map = new HashMap<>();
        for (String param : params) {
            String[] items = param.split("=");
            if (items.length == 2) {
                map.put(items[0], items[1]);
            }
        }
        return map;
    }

    /**
     * 校验银行卡卡号 只校验长度和数字
     */
    public static boolean checkBankCard(String bankCard) {
        if (bankCard.length() < 15 || bankCard.length() > 19) {
            return false;
        }
        return bankCard.matches("[0-9]+");
    }

    /**
     * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位
     *
     * @param nonCheckCodeBankCard
     * @return
     */
    public static char getBankCardCheckCode(String nonCheckCodeBankCard) {
        if (nonCheckCodeBankCard == null || nonCheckCodeBankCard.trim().length() == 0
                || !nonCheckCodeBankCard.matches("\\d+")) {
            //如果传的不是数据返回N
            return 'N';
        }
        char[] chs = nonCheckCodeBankCard.trim().toCharArray();
        int luhmSum = 0;
        for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if (j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;
        }
        return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
    }



    public static List<String> convertList(String[] strings) {
        List<String> list = new ArrayList<>();
        if (strings != null && strings.length > 0) {
            for (String s : strings) {
                list.add(s);
            }
        }
        return list;
    }
}
