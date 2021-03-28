package com.myWebsite.dto;

public class ChangePassword {
    private String old_pass;
    private String new_pass;
    private Long user_id;

    public ChangePassword() {
    }

    public ChangePassword(String old_pass, String new_pass, Long user_id) {
        this.old_pass = old_pass;
        this.new_pass = new_pass;
        this.user_id = user_id;
    }

    public String getOld_pass() {
        return old_pass;
    }

    public void setOld_pass(String old_pass) {
        this.old_pass = old_pass;
    }

    public String getNew_pass() {
        return new_pass;
    }

    public void setNew_pass(String new_pass) {
        this.new_pass = new_pass;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
