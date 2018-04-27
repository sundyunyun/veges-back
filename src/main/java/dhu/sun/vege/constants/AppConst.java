package dhu.sun.vege.constants;


public interface AppConst {
    Integer HTTP_200_CODE = 200;

    Integer HTTP_400_CODE = 400;

    String HTTP_200_NAME = "msg";

    Integer HTTP_500_CODE = 500;

    String HTTP_SUCCESS_NAME = "success";

    String HTTP_CODE_NAME = "code";

    String HTTP_DATA_NAME = "data";

    String FORMAT_MINUTE = "yyyy-MM-dd HH:mm";

    String FORMAT_SECOND = "yyyy-MM-dd HH:mm:ss";

    String FROMAT_MILLIS = "yyyy-MM-dd HH:mm:ss SSS";

    long DAY_MILLIS = 1000 * 60 * 60 * 24;
    long HOUR_MILLS = 1000 * 60 * 60;

    /**
     * 邮箱验证
     */
    String EMAIL_REGULAR_EXPRESSION = "^[\\w.-]+@[\\w-]+(\\.[\\w-]+)+$";

    /**
     * 用户名验证:字母开头,字母数字下划线组成的   4-16位 字符串
     */
    String USERNAME_REGULAR_EXPRESSION = "^[a-zA-Z]{1}[a-zA-Z0-9_]{3,15}$";

    /**
     * 密码:字母数字下划线  6-18位
     */
    // TODO: 2018/2/13 密码的正则表达式需要完善
    String PASSWORD_REGULAR_EXPRESSION = "^[a-zA-Z0-9_]{6,18}$";

    String basePath="F:\\tool\\ngix\\nginx-1.14.0\\html\\";
}
