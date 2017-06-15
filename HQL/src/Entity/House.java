package Entity;

import java.io.Serializable;

/**
 * Created by K550jk on 2017/6/15.
 */
public class House implements Serializable{
    private int hId;

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    private String hName;
    private String hDetail;

    public int gethId() {
        return hId;
    }

    public void sethId(int hId) {
        this.hId = hId;
    }


    public String gethDetail() {
        return hDetail;
    }

    public void sethDetail(String hDetail) {
        this.hDetail = hDetail;
    }

    public String gethAddress() {
        return hAddress;
    }

    public void sethAddress(String hAddress) {
        this.hAddress = hAddress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private String hAddress;
    private User user;
}
