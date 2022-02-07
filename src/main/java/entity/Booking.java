package entity;

import java.io.Serializable;

public class Booking implements Serializable {
    private long id;
    private User user;
    private Master master;

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Master getMaster() {
        return master;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMaster(Master master) {
        this.master = master;
    }
}
