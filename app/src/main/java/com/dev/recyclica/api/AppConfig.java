package com.dev.recyclica.api;

import com.dev.recyclica.pojo.InformationAboutUtil;
import com.dev.recyclica.pojo.ProfileOption;

import java.util.ArrayList;
import java.util.List;

public class AppConfig {
    public static final String BASE_URL = "https://recyclica.pearx.net/";
    public static final String MAP_KEY = "b4c32dd3-4199-4b53-b8e1-dda31ec96cd0";

    public static List<InformationAboutUtil> getFishInformation() {
        List<InformationAboutUtil> list = new ArrayList<>();
        list.add(new InformationAboutUtil("Батарейки", 15, 15));
        list.add(new InformationAboutUtil("Батарейки", 15, 15));
        list.add(new InformationAboutUtil("Батарейки", 15, 15));

        return list;
    }

    public static List<ProfileOption> getFishOptions() {
        List<ProfileOption> list = new ArrayList<>();
        list.add(new ProfileOption("Темная тема", "Lorem ipsum for description", false));
        list.add(new ProfileOption("Хранить историю", "Lorem ipsum for description", false));
        list.add(new ProfileOption("Радуга", "Lorem ipsum for description", false));
        return list;
    }
}
