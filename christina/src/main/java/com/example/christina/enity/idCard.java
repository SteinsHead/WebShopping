package com.example.christina.enity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 身份证工具类
 *
 */

public class idCard {
    /** 中国公民一代身份证号码长度。 */
    public static final int CHINA_ID_MIN_LENGTH = 15;

    /** 中国公民二代身份证号码长度。 */
    public static final int CHINA_ID_MAX_LENGTH = 18;

    /**  数据字典-性别 男    */
    public static final String SEX_CODE_OF_MAN="1";

    /**  数据字典-性别 女    */
    public static final String SEX_CODE_OF_FEMALE="0";

    /** 省、直辖市代码表 */
    public static final String cityCode[] = {
            "11", "12", "13", "14", "15", "21", "22", "23", "31", "32", "33", "34", "35", "36", "37", "41",
            "42", "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", "64", "65", "71",
            "81", "82", "91"
    };

    /** 每位加权因子 */
    public static final int power[] = {
            7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2
    };

    /** 第18位校检码 */
    public static final String verifyCode[] = {
            "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"
    };

    /** 最低年限 */
    public static final int MIN = 1930;
    public static Map<String, String> cityCodes = new HashMap<String, String>();
    /** 台湾身份首字母对应数字 */
    public static Map<String, Integer> twFirstCode = new HashMap<String, Integer>();
    /** 香港身份首字母对应数字 */
    public static Map<String, Integer> hkFirstCode = new HashMap<String, Integer>();

    static {
        cityCodes.put("11", "北京");
        cityCodes.put("12", "天津");
        cityCodes.put("13", "河北");
        cityCodes.put("14", "山西");
        cityCodes.put("15", "内蒙古");
        cityCodes.put("21", "辽宁");
        cityCodes.put("22", "吉林");
        cityCodes.put("23", "黑龙江");
        cityCodes.put("31", "上海");
        cityCodes.put("32", "江苏");
        cityCodes.put("33", "浙江");
        cityCodes.put("34", "安徽");
        cityCodes.put("35", "福建");
        cityCodes.put("36", "江西");
        cityCodes.put("37", "山东");
        cityCodes.put("41", "河南");
        cityCodes.put("42", "湖北");
        cityCodes.put("43", "湖南");
        cityCodes.put("44", "广东");
        cityCodes.put("45", "广西");
        cityCodes.put("46", "海南");
        cityCodes.put("50", "重庆");
        cityCodes.put("51", "四川");
        cityCodes.put("52", "贵州");
        cityCodes.put("53", "云南");
        cityCodes.put("54", "西藏");
        cityCodes.put("61", "陕西");
        cityCodes.put("62", "甘肃");
        cityCodes.put("63", "青海");
        cityCodes.put("64", "宁夏");
        cityCodes.put("65", "新疆");
        cityCodes.put("71", "台湾");
        cityCodes.put("81", "香港");
        cityCodes.put("82", "澳门");
        cityCodes.put("91", "国外");
        twFirstCode.put("A", 10);
        twFirstCode.put("B", 11);
        twFirstCode.put("C", 12);
        twFirstCode.put("D", 13);
        twFirstCode.put("E", 14);
        twFirstCode.put("F", 15);
        twFirstCode.put("G", 16);
        twFirstCode.put("H", 17);
        twFirstCode.put("J", 18);
        twFirstCode.put("K", 19);
        twFirstCode.put("L", 20);
        twFirstCode.put("M", 21);
        twFirstCode.put("N", 22);
        twFirstCode.put("P", 23);
        twFirstCode.put("Q", 24);
        twFirstCode.put("R", 25);
        twFirstCode.put("S", 26);
        twFirstCode.put("T", 27);
        twFirstCode.put("U", 28);
        twFirstCode.put("V", 29);
        twFirstCode.put("X", 30);
        twFirstCode.put("Y", 31);
        twFirstCode.put("W", 32);
        twFirstCode.put("Z", 33);
        twFirstCode.put("I", 34);
        twFirstCode.put("O", 35);
        hkFirstCode.put("A", 1);
        hkFirstCode.put("B", 2);
        hkFirstCode.put("C", 3);
        hkFirstCode.put("R", 18);
        hkFirstCode.put("U", 21);
        hkFirstCode.put("Z", 26);
        hkFirstCode.put("X", 24);
        hkFirstCode.put("W", 23);
        hkFirstCode.put("O", 15);
        hkFirstCode.put("N", 14);
    }

    /**
     * 验证身份证是否合法，只验证内地
     */
    public static boolean validateCard(String idCard) {
        String card = toNotNullString(idCard).trim();
        if (validateIdCard18(card)) {
            return true;
        }
        if (validateIdCard15(card)) {
            return true;
        }
        return false;
    }

    /**
     * 验证身份证是否合法包括台湾、香港、澳门
     */
    public static boolean validateAllCard(String idCard) {
        String card = toNotNullString(idCard).trim();
        if (validateIdCard18(card)) {
            return true;
        }
        if (validateIdCard15(card)) {
            return true;
        }
        String[] cardval = validateIdCard10(card);
        if (cardval != null) {
            if (cardval[2].equals("true")) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取出生年月
     * @param SrcIDCard 身份证号码
     * @return YYYY-MM-DD
     */
    public static String getBirthday(String SrcIDCard){
        String IDCard = toNotNullString(SrcIDCard).trim();
        if(!validateCard(IDCard)){
            return "";
        }
        int lenOfCardID = IDCard.length();
        if(CHINA_ID_MIN_LENGTH == lenOfCardID){
            IDCard = conver15CardTo18(IDCard);
        }
        String year=IDCard.substring(6,10);
        String month=IDCard.substring(10,12);
        String day=IDCard.substring(12,14);
        return year + "-" + month + "-" + day;
    }
    /**
     * 获取出生年份
     * @param SrcIDCard
     * @return
     */
    public static Long getYearByIdcard(String SrcIDCard) {
        String IDCard = toNotNullString(SrcIDCard).trim();
        if(!validateCard(IDCard)){
            return null;
        }
        int lenOfCardID = IDCard.length();
        if(CHINA_ID_MIN_LENGTH == lenOfCardID){
            IDCard = conver15CardTo18(IDCard);
        }
        String year=IDCard.substring(6,10);

        return Long.valueOf(year);
    }

    /**
     * 获取日期类型的出生日期
     * @param SrcIDCard
     * @return
     * @throws ParseException
     */
    public static Date getBirthdayOfDate(String SrcIDCard){
        String birth = getBirthday(SrcIDCard);
        Date birthday = null;
        try{
            if(birth != "" && birth != null){
                birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birth);
            }
        } catch (ParseException e) {
            return birthday;
        }
        return birthday;
    }

    /**
     * 获取性别
     * @param SrcIDCard 身份证号码
     * @return 1-男 0-女
     */
    public static String getSex(String SrcIDCard){
        String IDCard = toNotNullString(SrcIDCard).trim();
        int lenOfCardID = IDCard.length();
        String sex = "";
        if(!validateCard(IDCard)){
            return null;
        }
        if(lenOfCardID == CHINA_ID_MIN_LENGTH){
            IDCard = conver15CardTo18(IDCard);
        }
        String sexFlag=IDCard.substring(16,17);
        if (Integer.parseInt(sexFlag)%2==0)
        {
            sex = SEX_CODE_OF_FEMALE;
        }else{
            sex = SEX_CODE_OF_MAN;
        }
        return sex;
    }
    /**
     *获取年龄
     *@param SrcIDCard 身份证号码
     */
    public static String getAge(String SrcIDCard){
        Date birthday = getBirthdayOfDate(SrcIDCard);
        if(birthday==null) return "";
        Calendar c1 = Calendar.getInstance();
        long nowmillSeconds = c1.getTimeInMillis();
        Calendar c2 = Calendar.getInstance();
        c2.setTime(birthday);
        long birmillSeconds = c2.getTimeInMillis();
        Calendar c3 = Calendar.getInstance();
        long millis = nowmillSeconds - birmillSeconds;
        c3.setTimeInMillis(millis);
        int year = c3.get(Calendar.YEAR);
        if (year >= 1970) {
            return (year - 1970)+"";
        }else{
            return "";
        }
    }

    /**
     * 将15位身份证号码转换为18位
     *
     * @param idCard
     *            15位身份编码
     * @return 18位身份编码
     */
    public static String conver15CardTo18(String idCard) {
        String idCard18 = "";
        if (idCard.length() != CHINA_ID_MIN_LENGTH) {
            return null;
        }
        if (isNum(idCard)) {
            // 获取出生年月日
            String birthday = idCard.substring(6, 12);
            Date birthDate = null;
            try {
                birthDate = new SimpleDateFormat("yyMMdd").parse(birthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar cal = Calendar.getInstance();
            if (birthDate != null)
                cal.setTime(birthDate);
            // 获取出生年(完全表现形式,如：2010)
            String sYear = String.valueOf(cal.get(Calendar.YEAR));
            idCard18 = idCard.substring(0, 6) + sYear + idCard.substring(8);
            // 转换字符数组
            char[] cArr = idCard18.toCharArray();
            if (cArr != null) {
                int[] iCard = converCharToInt(cArr);
                int iSum17 = getPowerSum(iCard);
                // 获取校验位
                String sVal = getCheckCode18(iSum17);
                if (sVal.length() > 0) {
                    idCard18 += sVal;
                } else {
                    return null;
                }
            }
        } else {
            return null;
        }
        return idCard18;
    }

    /**
     * 验证18位身份编码是否合法
     *
     * @param idCard 身份编码
     * @return 是否合法
     */
    public static boolean validateIdCard18(String idCard) {
        boolean bTrue = false;
        if (idCard.length() == CHINA_ID_MAX_LENGTH) {
            // 前17位
            String code17 = idCard.substring(0, 17);
            // 第18位
            String code18 = idCard.substring(17, CHINA_ID_MAX_LENGTH);
            if (isNum(code17)) {
                char[] cArr = code17.toCharArray();
                if (cArr != null) {
                    int[] iCard = converCharToInt(cArr);
                    int iSum17 = getPowerSum(iCard);
                    // 获取校验位
                    String val = getCheckCode18(iSum17);
                    if (val.length() > 0) {
                        if (val.equalsIgnoreCase(code18)) {
                            bTrue = true;
                        }
                    }
                }
            }
        }
        return bTrue;
    }

    /**
     * 验证15位身份编码是否合法
     *
     * @param idCard
     *            身份编码
     * @return 是否合法
     */
    public static boolean validateIdCard15(String idCard) {
        if (idCard.length() != CHINA_ID_MIN_LENGTH) {
            return false;
        }
        if (isNum(idCard)) {
            String proCode = idCard.substring(0, 2);
            if (cityCodes.get(proCode) == null) {
                return false;
            }
            String birthCode = idCard.substring(6, 12);
            Date birthDate = null;
            try {
                birthDate = new SimpleDateFormat("yy").parse(birthCode.substring(0, 2));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar cal = Calendar.getInstance();
            if (birthDate != null)
                cal.setTime(birthDate);
            if (!valiDate(cal.get(Calendar.YEAR), Integer.valueOf(birthCode.substring(2, 4)),
                    Integer.valueOf(birthCode.substring(4, 6)))) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * 验证10位身份编码是否合法
     *
     * @param idCard 身份编码
     * @return 身份证信息数组
     *         <p>
     *         [0] - 台湾、澳门、香港 [1] - 性别(男M,女F,未知N) [2] - 是否合法(合法true,不合法false)
     *         若不是身份证件号码则返回null
     *         </p>
     */
    public static String[] validateIdCard10(String idCard) {
        String[] info = new String[3];
        String card = idCard.replaceAll("[\\(|\\)]", "");
        if (card.length() != 8 && card.length() != 9 && idCard.length() != 10) {
            return null;
        }
        if (idCard.matches("^[a-zA-Z][0-9]{9}$")) { // 台湾
            info[0] = "台湾";
            String char2 = idCard.substring(1, 2);
            if (char2.equals("1")) {
                info[1] = "M";
            } else if (char2.equals("2")) {
                info[1] = "F";
            } else {
                info[1] = "N";
                info[2] = "false";
                return info;
            }
            info[2] = validateTWCard(idCard) ? "true" : "false";
        } else if (idCard.matches("^[1|5|7][0-9]{6}\\(?[0-9A-Z]\\)?$")) { // 澳门
            info[0] = "澳门";
            info[1] = "N";
            // TODO
        } else if (idCard.matches("^[A-Z]{1,2}[0-9]{6}\\(?[0-9A]\\)?$")) { // 香港
            info[0] = "香港";
            info[1] = "N";
            info[2] = validateHKCard(idCard) ? "true" : "false";
        } else {
            return null;
        }
        return info;
    }

    /**
     * 验证台湾身份证号码
     *
     * @param idCard
     *            身份证号码
     * @return 验证码是否符合
     */
    public static boolean validateTWCard(String idCard) {
        String start = idCard.substring(0, 1);
        String mid = idCard.substring(1, 9);
        String end = idCard.substring(9, 10);
        Integer iStart = twFirstCode.get(start);
        Integer sum = iStart / 10 + (iStart % 10) * 9;
        char[] chars = mid.toCharArray();
        Integer iflag = 8;
        for (char c : chars) {
            sum = sum + Integer.valueOf(c + "") * iflag;
            iflag--;
        }
        return (sum % 10 == 0 ? 0 : (10 - sum % 10)) == Integer.valueOf(end) ? true : false;
    }


    /**
     * 验证香港身份证号码
     *
     * 香港身份证号码由三部分组成：一个英文字母；6个数字；括号及0-9中的任一个数字，或者字母A。
     * 括号中的数字或字母A，是校验码，用于检验括号前面的号码的逻辑正确性。
     * 逻辑关系：
     * 先把首位字母改为数字，即A为1，B为2，C为3...Z为26，再乘以8；然后把字母后面的6个数字依次乘以7、6、5、4、3、2；
     * 再将以上所有乘积相加的和，除以11，得到余数；如果整除，则括号中的校验码为0，如果余数为1，则校验码为A，如果余数为2～10，则用11减去这个余数的差作校验码。

     * 例如：P103265（1），P，在字母表中排行16，则以16代表，则计算校验码：
     * 16×8＋1×7＋0×6＋3×5＋2×4＋6×3＋5×2＝186
     * 186÷11＝16......余10
     * 11－10＝1，即校验码为1。
     *
     *
     * @param idCard 身份证号码
     * @return 验证码是否符合
     */
    public static boolean validateHKCard(String idCard) {
        //此处只处理英文括号
        String card = idCard.replaceAll("[\\(|\\)]", "");
        Integer sum = 0;
        if(card.length() != 8) {
            return false;
        }
        //转换第一个字母并乘以加权因子
        sum = (Integer.valueOf(card.substring(0, 1).toUpperCase().toCharArray()[0]) - 64) * 8;

        String mid = card.substring(1, 7);
        String end = card.substring(7, 8);
        char[] chars = mid.toCharArray();
        Integer iflag = 7;
        for (char c : chars) {
            sum = sum + Integer.valueOf(c + "") * iflag;
            iflag--;
        }

        if (end.toUpperCase().equals("A")) {
            sum = sum + 10;
        } else {
            sum = sum + Integer.valueOf(end);
        }
        return (sum % 11 == 0) ? true : false;
    }


    /**
     * 将字符数组转换成数字数组
     *
     * @param ca
     *            字符数组
     * @return 数字数组
     */
    public static int[] converCharToInt(char[] ca) {
        int len = ca.length;
        int[] iArr = new int[len];
        try {
            for (int i = 0; i < len; i++) {
                iArr[i] = Integer.parseInt(String.valueOf(ca[i]));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return iArr;
    }

    /**
     * 将身份证的每位和对应位的加权因子相乘之后，再得到和值
     *
     * @param iArr
     * @return 身份证编码。
     */
    public static int getPowerSum(int[] iArr) {
        int iSum = 0;
        if (power.length == iArr.length) {
            for (int i = 0; i < iArr.length; i++) {
                for (int j = 0; j < power.length; j++) {
                    if (i == j) {
                        iSum = iSum + iArr[i] * power[j];
                    }
                }
            }
        }
        return iSum;
    }

    /**
     * 将power和值与11取模获得余数进行校验码判断
     *
     * @param iSum
     * @return 校验位
     */
    public static String getCheckCode18(int iSum) {
        String sCode = "";
        switch (iSum % 11) {
            case 10:
                sCode = "2";
                break;
            case 9:
                sCode = "3";
                break;
            case 8:
                sCode = "4";
                break;
            case 7:
                sCode = "5";
                break;
            case 6:
                sCode = "6";
                break;
            case 5:
                sCode = "7";
                break;
            case 4:
                sCode = "8";
                break;
            case 3:
                sCode = "9";
                break;
            case 2:
                sCode = "x";
                break;
            case 1:
                sCode = "0";
                break;
            case 0:
                sCode = "1";
                break;
        }
        return sCode;
    }

    /**
     * 根据身份编号获取户籍省份
     *
     * @param idCard 身份编码
     * @return 省级编码。
     */
    public static String getProvinceByIdCard(String idCard) {
        int len = idCard.length();
        String sProvince = null;
        String sProvinNum = "";
        if (len == CHINA_ID_MIN_LENGTH || len == CHINA_ID_MAX_LENGTH) {
            sProvinNum = idCard.substring(0, 2);
        }
        sProvince = cityCodes.get(sProvinNum);
        return sProvince;
    }

    /**
     * 数字验证
     *
     * @param val
     * @return 提取的数字。
     */
    public static boolean isNum(String val) {
        return val == null || "".equals(val) ? false : val.matches("^[0-9]*$");
    }

    /**
     * 验证小于当前日期 是否有效
     *
     * @param iYear
     *            待验证日期(年)
     * @param iMonth
     *            待验证日期(月 1-12)
     * @param iDate
     *            待验证日期(日)
     * @return 是否有效
     */
    public static boolean valiDate(int iYear, int iMonth, int iDate) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int datePerMonth;
        if (iYear < MIN || iYear >= year) {
            return false;
        }
        if (iMonth < 1 || iMonth > 12) {
            return false;
        }
        switch (iMonth) {
            case 4:
            case 6:
            case 9:
            case 11:
                datePerMonth = 30;
                break;
            case 2:
                boolean dm = ((iYear % 4 == 0 && iYear % 100 != 0) || (iYear % 400 == 0))
                        && (iYear > MIN && iYear < year);
                datePerMonth = dm ? 29 : 28;
                break;
            default:
                datePerMonth = 31;
        }
        return (iDate >= 1) && (iDate <= datePerMonth);
    }

    /**
     * 得到不为null得字符串
     * @param obj
     * @return
     */
    public static String toNotNullString(Object obj){
        return obj==null?"":obj.toString();
    }
}
