package Entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by K550jk on 2017/6/13.
 */
public class User implements Serializable {
    private int uId;
    private String uName;
    private String uPassword;

    public String getuGender() {
        return uGender;
    }

    public void setuGender(String uGender) {
        this.uGender = uGender;
    }

    private String uGender;
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public Timestamp getuBirthday() {
        return uBirthday;
    }

    public void setuBirthday(Timestamp uBirthday) {
        this.uBirthday = uBirthday;
    }

    private Timestamp uBirthday;

}
