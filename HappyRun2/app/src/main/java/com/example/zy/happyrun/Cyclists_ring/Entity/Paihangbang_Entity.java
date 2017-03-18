package com.example.zy.happyrun.Cyclists_ring.Entity;

/**
 * Created by zy on 2017/3/18.
 */

public class Paihangbang_Entity {
    private int id;
    private int icon ;
    private String name;
    private String jifen;
    private String numofzan;
    private int zan_icon;
    public Paihangbang_Entity(){
        super();
    }
    public Paihangbang_Entity(int id, int icon, String name, String jifen, String numofzan, int zan_icon) {
        this.id = id;
        this.icon = icon;
        this.name = name;
        this.jifen = jifen;
        this.numofzan = numofzan;
        this.zan_icon = zan_icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumofzan() {
        return numofzan;
    }

    public void setNumofzan(String numofzan) {
        this.numofzan = numofzan;
    }

    public String getJifen() {
        return jifen;
    }

    public void setJifen(String jifen) {
        this.jifen = jifen;
    }

    public int getZan_icon() {
        return zan_icon;
    }

    public void setZan_icon(int zan_icon) {
        this.zan_icon = zan_icon;
    }

    @Override
    public String toString() {
        return "Paihangbang_Entity{" +
                "id=" + id +
                ", icon=" + icon +
                ", name='" + name + '\'' +
                ", jifen='" + jifen + '\'' +
                ", numofzan='" + numofzan + '\'' +
                ", zan_icon=" + zan_icon +
                '}';
    }
}
