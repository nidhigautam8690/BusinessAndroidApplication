package com.example.businessapplication;

public class Users {

    private String user_mobile;
    private String cp_pass;
    private String cp_confirmpass;
    private String business_name;
    private String business_contact;
    private String business_address;
    private String business_email;

    private String business_workinghours;

    private String business_web;
    private String profile_name;
    private String profile_address;
    private String profile_mobile;
    private String profile_email;
    private String profile_vehicle_no;
    private String profile_vehicle_type;
    private String profile_vehicle_brand;
    private String profile_vehicle_subbrand;
    private String profile_vehicle_fueltype;










    public Users(){

    }

    public String getProfile_name() {
        return profile_name;
    }

    public void setProfile_name(String profile_name) {
        this.profile_name = profile_name;
    }

    public String getProfile_address() {
        return profile_address;
    }

    public void setProfile_address(String profile_address) {
        this.profile_address = profile_address;
    }

    public String getProfile_mobile() {
        return profile_mobile;
    }

    public void setProfile_mobile(String profile_mobile) {
        this.profile_mobile = profile_mobile;
    }

    public String getProfile_email() {
        return profile_email;
    }

    public void setProfile_email(String profile_email) {
        this.profile_email = profile_email;
    }

    public String getProfile_vehicle_no() {
        return profile_vehicle_no;
    }

    public void setProfile_vehicle_no(String profile_vehicle_no) {
        this.profile_vehicle_no = profile_vehicle_no;
    }

    public String getProfile_vehicle_type() {
        return profile_vehicle_type;
    }

    public void setProfile_vehicle_type(String profile_vehicle_type) {
        this.profile_vehicle_type = profile_vehicle_type;
    }
    public String getProfile_vehicle_brand() {
        return profile_vehicle_brand;
    }

    public void setProfile_vehicle_brand(String profile_vehicle_brand) {
        this.profile_vehicle_subbrand = profile_vehicle_brand;
    }


    public String getProfile_vehicle_subbrand() {
        return profile_vehicle_subbrand;
    }

    public void setProfile_vehicle_subbrand(String profile_vehicle_subbrand) {
        this.profile_vehicle_subbrand = profile_vehicle_subbrand;
    }

    public String getProfile_vehicle_fueltype() {
        return profile_vehicle_fueltype;
    }

    public void setProfile_vehicle_fueltype(String profile_vehicle_fueltype) {
        this.profile_vehicle_fueltype = profile_vehicle_fueltype;
    }

    public Users(String user_mobile, String cp_pass, String cp_confirmpass, String business_name, String business_contact, String business_address, String business_email, String business_workinghours,
                 String profile_name, String profile_address, String profile_mobile, String profile_email, String profile_vehicle_no, String profile_vehicle_type, String profile_vehicle_fueltype,  String profile_vehicle_brand, String profile_vehicle_subbrand) {
        this.user_mobile = user_mobile;
        this.cp_pass = cp_pass;
        this.cp_confirmpass = cp_confirmpass;
        this.business_name=business_name;
        this.business_contact=business_contact;
        this.business_address=business_address;
        this.business_email=business_email;
        this.business_workinghours=business_workinghours;
        this.profile_name= profile_name;
        this.profile_email= profile_email;
        this.profile_address = profile_address;
        this.profile_mobile = profile_mobile;
        this.profile_vehicle_no = profile_vehicle_no;
        this.profile_vehicle_type= profile_vehicle_type;
        this.profile_vehicle_fueltype= profile_vehicle_fueltype;
        this.profile_vehicle_brand= profile_vehicle_brand;
        this.profile_vehicle_subbrand= profile_vehicle_subbrand;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getBusiness_contact() {
        return business_contact;
    }

    public void setBusiness_contact(String business_contact) {
        this.business_contact = business_contact;
    }

    public String getBusiness_address() {
        return business_address;
    }

    public void setBusiness_address(String business_address) {
        this.business_address = business_address;
    }

    public String getBusiness_email() {
        return business_email;
    }

    public void setBusiness_email(String business_email) {
        this.business_email = business_email;
    }

    public String getBusiness_workinghours() {
        return business_workinghours;
    }

    public void setBusiness_workinghours(String business_workinghours) {
        this.business_workinghours = business_workinghours;
    }
    public String getBusiness_web() {
        return business_web;
    }

    public void setBusiness_web(String business_web) {
        this.business_web = business_web;
    }




    public String getUser_mobile() {
        return user_mobile;
    }

    public void setUser_mobile(String user_mobile) {
        this.user_mobile = user_mobile;
    }

    public String getCp_pass() {
        return cp_pass;
    }

    public void setCp_pass(String cp_pass) {
        this.cp_pass = cp_pass;
    }

    public String getCp_confirmpass() {
        return cp_confirmpass;
    }

    public void setCp_confirmpass(String cp_confirmpass) {
        this.cp_confirmpass = cp_confirmpass;
    }






}
