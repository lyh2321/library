package com.louyh.m.util;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.louyh.m.constant.Constant;
import com.louyh.m.domain.user.UserInfo;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Months;
import org.joda.time.Seconds;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Utils {
    private static Logger logger = LoggerFactory.getLogger(Utils.class);
    public static final DateTimeFormatter sdf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter sdfdate = DateTimeFormat.forPattern("yyyy-MM-dd");
    public static final DateTimeFormatter sdfdatecn = DateTimeFormat.forPattern("yyyy年MM月dd日");
    public static final DateTimeFormatter sdfdates = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
    public static final DateTimeFormatter nosymbolsdf = DateTimeFormat.forPattern("yyyyMMddHHmmss");
    public static final DateTimeFormatter nosymbolsdfs = DateTimeFormat.forPattern("yyyyMMddHHmmssSSS");
    public static final DateTimeFormatter sdfdatee = DateTimeFormat.forPattern("yyyyMMdd");
    public static final DateTimeFormatter year = DateTimeFormat.forPattern("yyyy");
    public static final DateTimeFormatter month = DateTimeFormat.forPattern("yyyyMM");
    public static final DateTimeFormatter monthday = DateTimeFormat.forPattern("MM-dd");

    public static String now() {
        return new DateTime().toString(sdf);
    }

    public static String nowDate() {
        return new DateTime().toString(sdfdate);
    }

    public static String nowDatecn() {
        return new DateTime().toString(sdfdatecn);
    }

    public static String nowymd() {
        return new DateTime().toString(sdfdatee);
    }

    public static String nowymd(Integer num) {
        DateTime dateTime = new DateTime();
        if (num > 0) {
            return dateTime.plusDays(num).toString(sdfdatee);// num天后的日期
        } else {
            return dateTime.minusDays(Math.abs(num)).toString(sdfdatee);// num天前的日期
        }
    }

    public static String month() {
        return new DateTime().toString(month);
    }

    public static String nowDates() {
        return new DateTime().toString(sdfdates);
    }

    public static String nowStr() {
        return new DateTime().toString(nosymbolsdf);
    }

    public static String nowStrSSS() {
        return new DateTime().toString(nosymbolsdfs);
    }

    public static String nowYear() {
        return new DateTime().toString(year);
    }

    public static String nowYear(int x) {
        if (x > 0) {
            return new DateTime().plusYears(x).toString(year);
        } else {
            return new DateTime().minusYears(Math.abs(x)).toString(year);
        }
    }

    public static String[] numArray = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

    public static String getuuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getuuidOLD() {
        return UUID.randomUUID().toString().toUpperCase();
    }

    /**
     * 转换为 yyyy年MM月dd日
     *
     * @param date
     * @return
     */
    public static String getsdfdatecn(String date) {
        return DateTime.parse(date, sdf).toString(sdfdatecn);
    }

    /**
     * 两个时间相差秒数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static Long differSecond(DateTime startDate, DateTime endDate) {
        Duration duration = new Duration(startDate, endDate);
        return duration.getStandardSeconds();
    }

    /**
     * double 除法
     *
     * @param d1
     * @param d2
     * @param scale 四舍五入 小数点位数
     * @return
     */
    public static double div(double d1, double d2, int scale) {
        return div(d1, d2, scale, BigDecimal.ROUND_HALF_UP);// 默认四舍五入
    }

    public static double div(double d1, double d2, int scale, int type) {
        // 当然在此之前，你要判断分母是否为0
        // 为0你可以根据实际需求做相应的处理
        if (d2 == 0) {
            return 0;
        }
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.divide(bd2, scale, type).doubleValue();
    }

    /**
     * double 乘法
     *
     * @param d1
     * @param d2
     * @return
     */
    public static double mul(double d1, double d2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.multiply(bd2).doubleValue();
    }

    /**
     * double 相加
     *
     * @param d1
     * @param d2
     * @return
     */
    public static double sum(double d1, double d2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.add(bd2).doubleValue();
    }

    /**
     * double 相减
     *
     * @param d1
     * @param d2
     * @return
     */
    public static double sub(double d1, double d2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.subtract(bd2).doubleValue();
    }

    /**
     * 对double数据进行取精度.
     *
     * @param value        double数据.
     * @param scale        精度位数(保留的小数位数).
     * @param roundingMode 精度取值方式. roundingMode 枚举
     * @return 精度计算后的数据.
     */
    public static double round(double value, int scale, int roundingMode) {
        BigDecimal bd = new BigDecimal(String.valueOf(value));
        bd = bd.setScale(scale, roundingMode);
        double d = bd.doubleValue();
        bd = null;
        return d;
    }

    public static UserInfo getUserInfo(HttpServletRequest request) {
//        return (UserInfo) request.getSession().getAttribute(Constant.USER_INFO);
        UserInfo userInfo = new UserInfo();
        userInfo.setId("1");
        return userInfo;
    }

    /**
     * 获取几分钟前时间
     * date，num(1表示一分钟后 -1表示一分钟前)
     */
    public static DateTime getMinute(DateTime date, Integer num) {
        if (num > 0) {
            return date.plusMinutes(num);// num分钟后的日期
        } else {
            return date.minusMinutes(Math.abs(num));// num分钟前的日期
        }
    }

    /**
     * 获取几天前时间
     * date，num(1表示一天后-1表示一天前)
     */
    public static DateTime getDay(DateTime date, Integer num) {
        if (num > 0) {
            return date.plusDays(num);// num天后的日期
        } else {
            return date.minusDays(Math.abs(num));// num天前的日期
        }
    }

    /**
     * 获取上一个月 -1， 获取下一个月 1
     *
     * @param date
     * @param num
     * @return
     */
    public static DateTime getBeforeMonth(DateTime date, int num) {
        if (num > 0) {
            return date.plusMonths(num);// num
        } else {
            return date.minusMonths(Math.abs(num));// num
        }
    }

    /**
     * 月初
     *
     * @param date 格式必须是 yyyy-MM-dd
     * @return yyyy-MM-dd
     */
    public static String geteMonthBegin(String date) {
        return DateTime.parse(date, sdfdate).dayOfMonth().withMinimumValue().toString(sdfdate);
    }

    /**
     * 月末
     *
     * @param date 格式必须是 yyyy-MM-dd
     * @return yyyy-MM-dd
     */
    public static String geteMonthEnd(String date) {
        return DateTime.parse(date, sdfdate).dayOfMonth().withMaximumValue().toString(sdfdate);
    }

    /**
     * 取得月最后一天
     *
     * @param date
     * @return 注意，返回的带 时分秒，且时分秒不是 59:59:59
     */
    public static DateTime getLastDateOfMonth(DateTime date) {
        return date.dayOfMonth().withMaximumValue();
    }

    /**
     * 取得月第一天
     *
     * @param date
     * @return 注意，返回的带 时分秒，且时分秒不是 00:00:00
     */
    public static DateTime getFirstDateOfMonth(DateTime date) {
        return date.dayOfMonth().withMinimumValue();
    }


    /**
     * 取得季度第一天
     *
     * @param date
     * @return
     */
    public static DateTime getFirstDateOfSeason(DateTime date) {
        return getSeasonDate(date)[0];
    }

    /**
     * 取得季度最后一天
     *
     * @param date
     * @return
     */
    public static DateTime getLastDateOfSeason(DateTime date) {
        return getSeasonDate(date)[1];
    }

    /**
     * 取得季度月
     * 第一季度：1月－3月
     * 第二季度：4月－6月
     * 第三季度：7月－9月
     * 第四季度：10月－12月
     *
     * @param date
     * @return Date[] 0-是季头 1-是季尾   日期的格式是 yyyy-MM-dd
     * 注意，返回的带 时分秒，且时分秒是 00:00:00
     */
    public static DateTime[] getSeasonDate(DateTime date) {
        DateTime[] dates = new DateTime[2];
        int year = date.getYear();
        int month = date.getMonthOfYear();
        if (month == 1 || month == 2 || month == 3) {
            dates[0] = DateTime.parse(year + "-01-01", sdfdate);
            dates[1] = DateTime.parse(year + "-03-01", sdfdate).dayOfMonth().withMaximumValue();
        } else if (month == 4 || month == 5 || month == 6) {
            dates[0] = DateTime.parse(year + "-04-01", sdfdate);
            dates[1] = DateTime.parse(year + "-06-01", sdfdate).dayOfMonth().withMaximumValue();
        } else if (month == 7 || month == 8 || month == 9) {
            dates[0] = DateTime.parse(year + "-07-01", sdfdate);
            dates[1] = DateTime.parse(year + "-09-01", sdfdate).dayOfMonth().withMaximumValue();
        } else if (month == 10 || month == 11 || month == 12) {
            dates[0] = DateTime.parse(year + "-10-01", sdfdate);
            dates[1] = DateTime.parse(year + "-12-01", sdfdate).dayOfMonth().withMaximumValue();
        }
        return dates;
    }

    /**
     * 与当前日期相差天数
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static long getDifferencedays(String date) {
        DateTime dateTime = DateTime.parse(date, sdf);
        return differentDays(DateTime.now(), dateTime);
    }

    public static int getWeek() {
        //一星期 60*60*24*7= 604800秒
        return 604800;
    }

    public static int getday() {
        //一天 60*60*24= 86400秒
        return 86400;
    }

    public static int getHour() {
        return 3600;
    }

    public static int getHour(int num) {
        return 3600 * num;
    }

    public static int getMinute() {
        return 60;
    }

    public static int get30second() {
        return 30;
    }

    /**
     * 32位 小写
     *
     * @param s
     * @return
     */
    public static String getMD5(String s) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(s.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getMinute(int num) {
        return 60 * num;
    }

    // 检查文件夹是否存在，不存在则创建
    public static void hasfolder(String folder) {
        File file = new File(folder);
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }
    }

    /**
     * 获得用户远程地址
     */
    public static String getRemoteAddr(HttpServletRequest request) {
        String remoteAddr = request.getHeader("X-Real-IP");
        if (StringUtils.isNotBlank(remoteAddr)) {
            remoteAddr = request.getHeader("X-Forwarded-For");
        } else if (StringUtils.isNotBlank(remoteAddr)) {
            remoteAddr = request.getHeader("Proxy-Client-IP");
        } else if (StringUtils.isNotBlank(remoteAddr)) {
            remoteAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
    }

    /**
     * 为值null的信息会被忽略
     *
     * @param obj
     * @return
     */
    public static Map java2Map(Object obj) {
        if (obj == null)
            return null;

        Map<String, Object> map = new HashMap<String, Object>();

        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(obj.getClass());
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (key.compareToIgnoreCase("class") == 0) {
                continue;
            }
            Method getter = property.getReadMethod();
            Object value = null;
            try {
                value = getter != null ? getter.invoke(obj) : null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            map.put(key, value);
        }
        return map;
    }

    public static Map java2MapRetain(Object obj) {
        if (obj == null)
            return null;

        Map<String, Object> map = new HashMap<String, Object>();

        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(obj.getClass());
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (key.compareToIgnoreCase("class") == 0) {
                continue;
            }
            Method getter = property.getReadMethod();
            Object value = null;
            try {
                value = getter != null ? getter.invoke(obj) : null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            if (value == null) continue;
            map.put(key, value);
        }
        return map;
    }

    public static String format(String c) {
        Pattern p1 = Pattern.compile("(line-height:.[0-9]*[^;^,^\"]*)");
        Matcher m1 = p1.matcher(c);
        while (m1.find()) {
            c = c.replaceAll(m1.group(), "line-height: 170%");
        }
        Pattern p2 = Pattern.compile("(font-size:.[0-9a-zA-z]*)");
        Matcher m2 = p2.matcher(c);
        while (m2.find()) {
            c = c.replaceAll(m2.group(), "font-size: 17px");
        }
        Pattern p3 = Pattern.compile("(text-indent:.[0-9a-zA-z]*)");
        Matcher m3 = p3.matcher(c);
        while (m3.find()) {
            c = c.replaceAll(m3.group(), "text-indent: 2em");
        }
        Pattern p4 = Pattern.compile("(font-family:.[0-9]*[^;^,^\"]*)");
        Matcher m4 = p4.matcher(c);
        while (m4.find()) {
            c = c.replaceAll(m4.group(), "font-family: 仿宋_gb2312");
        }
        c = c.replaceAll("<br/>", "").replaceAll("<span style=\"font-family: 仿宋_gb2312; font-size:17px;\">&nbsp;</span>", "");
        return c;
    }

    public static List<Integer> getDictDate() {
        List<Integer> list = Lists.newArrayList();

        Integer format = Integer.parseInt(new DateTime(new Date()).toString(year)) - 18;

        for (int i = format; i > format - 118; i--) {
            list.add(i);
        }

        return list;
    }

    public static String getMD5ByFile(MultipartFile multipartFile) {
        try {
            InputStream fileInputStream = multipartFile.getInputStream();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[8192];
            int length = -1;
            while ((length = fileInputStream.read(buffer, 0, 8192)) != -1) {
                messageDigest.update(buffer, 0, length);
            }
            BigInteger bigInt = new BigInteger(1, messageDigest.digest());
            return bigInt.toString(16).toLowerCase();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 这里返回的支付没头部斜杠，也没有结尾斜杠。
     *
     * @param md5
     * @return
     */
    public static String getPathByMD5(String md5) {
        return md5.substring(0, 2) + "/" + md5.substring(2, 4) + "/" + md5.substring(4, 6) + md5.substring(6, md5.length());
    }

    /**
     * 删除最后更新时间在day天的空文件夹
     */
    @Deprecated
    public static void removeNullFileByDay(File dir, int day) {
        File[] dirs = dir.listFiles();
        for (int i = 0; i < dirs.length; i++) {
            if (dirs[i].isDirectory()) {
                removeNullFileByDay(dirs[i], day);
            }
        }
        if (dir.isDirectory() && dir.listFiles().length <= 0) {
            long d = differentDays(new DateTime(dir.lastModified()), new DateTime());
            if (d > (day - 1)) {
                dir.delete();
            }
        }
    }

    public static boolean deleteDir(File dir, int day) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            // 递归删除目录中的子目录下
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]), day);
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        long d = differentDays(new DateTime(dir.lastModified()), new DateTime());
        if (d > (day - 1)) {
            return dir.delete();
        }
        return true;
    }

    /**
     * date2比date1多的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long differentDays(DateTime date1, DateTime date2) {
        Duration duration = new Duration(date1, date2);
        return duration.getStandardDays();
    }

    /**
     * 获取Cookie
     *
     * @param cookies
     * @param key
     * @return
     */
    public static String getCookie(Cookie[] cookies, String key) {
        for (Cookie cookie : cookies) {
            if (key.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return StringUtils.EMPTY;
    }

    /**
     * 获取外网地址
     *
     * @param strUrl
     * @return
     */
    public static String getWebIP(String strUrl) {
        try {
            //连接网页
            URL url = new URL(strUrl);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String s = "";
            StringBuffer sb = new StringBuffer("");
            String webContent = "";
            //读取网页信息
            while ((s = br.readLine()) != null) {
                sb.append(s + "\r\n");
            }
            br.close();
            //网页信息
            webContent = sb.toString();
            int start = webContent.indexOf("[") + 1;
            int end = webContent.indexOf("]");
            //获取网页中  当前 的 外网IP
            webContent = webContent.substring(start, end);
            return webContent;

        } catch (Exception e) {
            e.printStackTrace();
            return "error open url:" + strUrl;
        }
    }

    public static <T> List<T> deepCopy(List<T> src) {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(byteOut);
            out.writeObject(src);
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            @SuppressWarnings("unchecked")
            List<T> dest = (List<T>) in.readObject();
            return dest;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除所有的HTML标签
     *
     * @param source 需要进行除HTML的文本
     * @return
     */
    public static String deleteAllHTMLTag(String source) {

        if (source == null) {
            return "";
        }

        String s = source;
        /** 删除普通标签  */
        s = s.replaceAll("<(S*?)[^>]*>.*?|<.*? />", "");
        /** 删除转义字符 */
        s = s.replaceAll("&.{2,6}?;", "");
        return s;
    }

    // 获取本机IP地址-只能获取简单环境下的ip地址
    public static String getLocalIP() {
        String localIP = "";
        InetAddress addr = null;
        try {
            addr = (InetAddress) InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        //获取本机IP
        localIP = addr.getHostAddress().toString();
        return localIP;
    }

    // 获取本机ip-复杂环境下更能获取正确的ip
    public static String getLocalHostIPAddress() {
        return getLocalHostLANAddress().getHostAddress().toString();
    }

    // 获取本级ip
    public static InetAddress getLocalHostLANAddress() {
        try {
            InetAddress candidateAddress = null;
            // 遍历所有的网络接口
            for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements(); ) {
                NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
                // 在所有的接口下再遍历IP
                for (Enumeration inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements(); ) {
                    InetAddress inetAddr = (InetAddress) inetAddrs.nextElement();
                    if (!inetAddr.isLoopbackAddress()) {// 排除loopback类型地址
                        if (inetAddr.isSiteLocalAddress()) {
                            // 如果是site-local地址，就是它了
                            return inetAddr;
                        } else if (candidateAddress == null) {
                            // site-local类型的地址未被发现，先记录候选地址
                            candidateAddress = inetAddr;
                        }
                    }
                }
            }
            if (candidateAddress != null) {
                return candidateAddress;
            }
            // 如果没有发现 non-loopback地址.只能用最次选的方案
            InetAddress jdkSuppliedAddress = InetAddress.getLocalHost();
            return jdkSuppliedAddress;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getCreditDeclareType(int type) {
        switch (type) {
            case 0:
                return "脱产培训";
            case 1:
                return "中心组学习";
            case 2:
                return "专题报告";
            case 3:
                return "辅导讲座";
            case 4:
                return "集体学习";
            case 5:
                return "学习笔记";
            case 6:
                return "研究报告";
            case 7:
                return "学历学位进修";
            case 8:
                return "专业资格考试";
            case 9:
                return "实践锻炼";
            case 10:
                return "学习成果运用";
        }
        return "";
    }


    //比较实际   time1<time2
    // 如果time1<time2则返回true 其他都是false
    public static boolean compareTime(String time1, String time2) {
        if (time1.indexOf(":") == -1) {
            time1 = time1 + " 00:00:00";
        }
        if (time2.indexOf(":") == -1) {
            time2 = time2 + " 00:00:00";
        }
        Duration duration = new Duration(DateTime.parse(time1, sdf), DateTime.parse(time2, sdf));
        long l = duration.getStandardSeconds();
        if (l > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
//        System.out.println(getMonthSpace("2018-0-10 00:00:00", "2018-01-01 00:00:00"));
        System.out.println(getTimeDifferSecond("2018-01-01 00:00:00", "2018-01-02 00:00:00"));
    }

    //相差月份
    public static int getMonthSpace(String date1, String date2) {
        if (date1.indexOf(":") == -1) {
            date1 = date1 + " 00:00:00";
        }
        if (date2.indexOf(":") == -1) {
            date2 = date2 + " 00:00:00";
        }
        DateTime parse1 = DateTime.parse(date1, sdf);
        DateTime parse2 = DateTime.parse(date2, sdf);
        int months = Months.monthsBetween(parse1, parse2).getMonths();
        DateTime dateTime = parse1.plusMonths(months);
        int seconds = Seconds.secondsBetween(dateTime, parse2).getSeconds();

        if (seconds != 0) {
            months++;
        }
        return months;
    }


    //相差秒数
    public static long getTimeDifferSecond(String date1, String date2) {
        if (StringUtils.isBlank(date1) || StringUtils.isBlank(date2)) {
            return -1;
        }
        Duration duration = new Duration(DateTime.parse(date2, sdf), DateTime.parse(date1, sdf));
        return duration.getStandardSeconds();
    }

    public static <T extends Serializable> T clone(T obj) {
        T clonedObj = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            clonedObj = (T) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clonedObj;
    }


    public static String getTimeMinusSecond(String now, Integer surplustime) {
        DateTime parse = DateTime.parse(now, sdf);
        return parse.minusSeconds(surplustime).toString(sdf);

    }


    final static char[] digits = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P',
            'R', 'S', 'T', 'U', 'W', 'X', 'Y', 'Z'};

    /**
     * 将十进制的数字转换为指定进制的字符串。
     *
     * @param i      十进制的数字。
     * @param system 指定的进制，常见的2/8/16。
     * @return 转换后的字符串。
     */
    public static String numericToString(long i, int system) {
        long num = 0;
        if (i < 0) {
            num = ((long) 2 * 0x7fffffff) + i + 2;
        } else {
            num = i;
        }
        char[] buf = new char[32];
        int charPos = 32;
        while ((num / system) > 0) {
            buf[--charPos] = digits[(int) (num % system)];
            num /= system;
        }
        buf[--charPos] = digits[(int) (num % system)];
        return new String(buf, charPos, (32 - charPos));
    }

    /**
     * 将其它进制的数字（字符串形式）转换为十进制的数字。
     *
     * @param s      其它进制的数字（字符串形式）
     * @param system 指定的进制，常见的2/8/16。
     * @return 转换后的数字。
     */
    public static long stringToNumeric(String s, int system) {
        char[] buf = new char[s.length()];
        s.getChars(0, s.length(), buf, 0);
        long num = 0;
        for (int i = 0; i < buf.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                if (digits[j] == buf[i]) {
                    num += j * Math.pow(system, buf.length - i - 1);
                    break;
                }
            }
        }
        return num;
    }

    public static int random1000() {
        return (int) (Math.random() * 1000);
    }

    public static String replaced(String var, String replaced) {
        if (StringUtils.isBlank(replaced)) {
            return var;
        }
        String[] replacesd = replaced.split("#_#");
        for (String s : replacesd) {
            String[] r = s.split("#=#");
            int beginIndex = judgelastIndexOf(var, getStringArray(r, 0));
            if (beginIndex == -1) {
                continue;
            }
            int endIndex = 0;
            if (r.length < 2 || StringUtils.isBlank(getStringArray(r, 1))) {
                endIndex = var.length();
            } else {
                endIndex = judgelastIndexOf(var, getStringArray(r, 1));
                if (endIndex == -1) {
                    continue;
                }
                endIndex += getStringArray(r, 1).replace("#-", "").length();
            }

            if (beginIndex == -1 || beginIndex > endIndex) {
                continue;
            }
            String k = var.substring(beginIndex, endIndex);
            var = var.replace(k, r.length < 3 ? "" : getStringArray(r, 2)).trim();
        }
        return var;
    }

    private static String getStringArray(String[] r, int num) {
        return r[num].replace("$_$", "_");//处理#=#_#_#问题
    }

    private static int judgelastIndexOf(String value, String k) {
        if (k.indexOf("#-") == -1) {
            return value.indexOf(k);
        } else {
            return value.lastIndexOf(k.replace("#-", ""));
        }
    }

    /**
     * @param g
     * @param text       文本
     * @param lineHeight 行高
     * @param maxWidth   行宽
     * @param maxLine    最大行数
     * @param left       左边距
     * @param top        上边距
     */
    public static void drawString(Graphics2D g, String text, float lineHeight, float maxWidth, int maxLine, float left,
                                  float top) {
        if (text == null || text.length() == 0) return;


        FontMetrics fm = g.getFontMetrics();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            sb.append(c);
            int stringWidth = fm.stringWidth(sb.toString());
            if (c == '\n' || stringWidth > maxWidth) {
                if (c == '\n') {
                    i += 1;
                }
                if (maxLine > 1) {
                    g.drawString(text.substring(0, i), left, top);
                    drawString(g, text.substring(i), lineHeight, maxWidth, maxLine - 1, left, top + lineHeight);
                } else {
                    g.drawString(text.substring(0, i - 1) + "…", left, top);
                }
                return;
            }
        }


        g.drawString(text, left, top);
    }


    public static void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 身份证过滤 保留前3位 后4位
     * 111****************1234
     *
     * @param idcard
     * @return
     */
    public static String idcardfilter(String idcard) {
        if (StringUtils.isBlank(idcard) || idcard.length() < 7) {
            return idcard;
        }

        String decrypt = idcard.substring(0, 3);
        for (int i = 3; i < idcard.length() - 4; i++) {
            decrypt += "*";
        }
        decrypt += idcard.substring(idcard.length() - 4, idcard.length());
        return decrypt;
    }

    /**
     * 手机号码脱敏，也是前三后四
     *
     * @param phoneNumber
     * @return
     */
    public static String phoneNumberDesensitization(String phoneNumber) {
        return idcardfilter(phoneNumber);
    }


    public static void UserIsCheck(UserInfo userInfo) {

    }


    public static String getmap(String val) {
        Map<String, String> map = Maps.newHashMap();
        map.put("datadate", "数据日期");
        map.put("uname", "用户名");
        map.put("partisanid", "政治面貌");
        map.put("administrativelevelid", "行政级别");
        map.put("educationid", "学历");
        map.put("organid", "机构编号");
        map.put("organname", "机构名");
        map.put("courseid", "课程编号");
        map.put("coursename", "课程名称");
        map.put("categoryid", "一级课程目录");
        map.put("categoryname", "一级课程目录名称");
        map.put("categoryidsecond", "二级课程目录");
        map.put("categoryidsecondname", "二级课程目录名称");
        map.put("couorsetype", "课程类型 0-选修 1-必修");
        map.put("duration", "学习时长(分钟)");
        map.put("peoplenum", "总人数");
        map.put("name", "名称");
        map.put("passnum", "通过人数");
        map.put("learntime", "学习时间(分钟)");
        map.put("learners", "参加人数");
        map.put("examlearners", "考试人数");
        map.put("reexamcount", "重考次数");
        map.put("avgscores", "考试平均分");
        map.put("credithour", "平均学时");
        map.put("avgscore", "平均学时");
        map.put("avgcredithour", "平均学时");
        return map.get(val);
    }

    public static boolean judgeLetter(String temp) {
        if (StringUtils.isBlank(temp) && temp.length() > 2) {
            return false;
        }
        char letter = temp.substring(0, 1).charAt(0);
        String val = temp.substring(1, 2);
        if ((letter >= 'A' && letter <= 'Z') || (letter > 'a' && letter < 'z') && val.equals(".")) {
            return true;
        }
        return false;
    }

    public static Integer userinfoischeck(String date, Integer sex) {
        if (StringUtils.isBlank(date) || sex == null) {
            logger.info("date or sex is null!!!");
            return 1;// 默认考核
        }
        int yearnow = Integer.parseInt(now().substring(0, 4));
        int yeardt = Integer.parseInt(date.substring(0, 4));
        //sex 性别(0-女 1-男)
        if (sex == 0) {
            return yearnow - yeardt >= 50 ? 0 : 1;
        }
        return yearnow - yeardt >= 55 ? 0 : 1;
    }

    public static String getinstanceoftoString(Object value) {
        String val = "";
        if (value instanceof BigDecimal) {
            val = String.valueOf(((BigDecimal) value).longValue());
        } else {
            val = String.valueOf(value);
        }
        return val;
    }

    /**
     * 得到几天前的时间
     *  
     *
     * @param num
     * @return
     */
    public static String getnowymd(Integer num) {
        DateTime dateTime = new DateTime();
        if (num > 0) {
            return dateTime.plusDays(num).toString(monthday);// num天后的日期
        } else {
            return dateTime.minusDays(Math.abs(num)).toString(monthday);// num天前的日期
        }
    }

    public static String getExamuserName(String userid) {
        return "t_ex_examuser_" + userid.substring(userid.length() - 1, userid.length());
    }

    public static String getExamUserMarkScoreName(String examid) {
        return "t_ex_examusermarkscore_" + examid;
    }
}

