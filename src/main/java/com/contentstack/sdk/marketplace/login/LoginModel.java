package com.contentstack.sdk.marketplace.login;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LoginModel {

    @SerializedName("notice")
    public String notice;
    @SerializedName("user")
    public UserModel user;
}


