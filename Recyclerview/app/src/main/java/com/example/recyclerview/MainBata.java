package com.example.recyclerview;

import android.text.Editable;

public class MainBata {
    private int iv_profile;
    private Editable name1;
    private String name2;

    public MainBata(int iv_profile, Editable name1, String name2) {
        this.iv_profile = iv_profile;
        this.name1 = name1;
        this.name2 = name2;
    }

    public int getIv_profile() {
        return iv_profile;
    }

    public void setIv_profile(int iv_profile) {
        this.iv_profile = iv_profile;
    }

    public Editable getName1() {
        return name1;
    }

    public void setName1(Editable name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

}
