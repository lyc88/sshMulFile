package com.metadata.bean;

import java.util.Set;

/**
 * Created by Administrator on 2016/8/13.
 */
public class Data {
    private int id;
    private String name;
    private String description;
    private Set<DataFile> files;

    public Set<DataFile> getFiles() {
        return files;
    }

    public void setFiles(Set<DataFile> files) {
        this.files = files;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
       // System.out.println("获取"+name+"----");
        return name;
    }

    public void setName(String name) {
       // System.out.println("注入"+name);
        this.name = name;
    }


    public String getDescription() {
      //  System.out.println("获取"+description);
        return description;
    }

    public void setDescription(String description) {
       // System.out.println("注入"+description);
        this.description = description;
    }
}
