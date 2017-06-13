package org.Enity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by K550jk on 2017/4/28.
 */
public class UserEntity implements Serializable{
    private int uId;
    private String uName;
    private String uAge;
    private Timestamp uDate;

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

    public String getuAge() {
        return uAge;
    }

    public void setuAge(String uAge) {
        this.uAge = uAge;
    }

    public Timestamp getuDate() {
        return uDate;
    }

    public void setuDate(Timestamp uDate) {
        this.uDate =  uDate;
    }
}
