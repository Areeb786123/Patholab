package com.areeb.patholab.Model;

public class pathlabModel {
    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getPhone() {
        return Phone;
    }


    public pathlabModel(){}

    public pathlabModel(String fullname, String phone, String adminemail,String adminId,String profilePic) {
        Fullname = fullname;
        Phone = phone;
        AdminEmail = adminemail;
        AdminId = adminId;
        ProfilePic= profilePic;
    }

    public void setProfilePic(String profilePic){
        ProfilePic = profilePic;
    }

    public String getProfilePic(){
        return ProfilePic;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
    public String getAdminId(){
        return AdminId;
    }

    public void setAdminId(String adminId){
        AdminId = adminId;
    }

    public String getAdminEmail() {
        return AdminEmail;
    }

    public void setAdminEmail(String userEmail) {
        AdminEmail = userEmail;
    }

    String Fullname,Phone,AdminEmail,AdminId,ProfilePic;


}
