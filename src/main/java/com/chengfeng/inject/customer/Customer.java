package com.chengfeng.inject.customer;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by chengfeng on 2017/1/20.
 */
public class Customer {
    private List<Object> lists;
    private Map<Object, Object> maps;
    private Set<Object> sets;
    private Properties pros;

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Map<Object, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<Object, Object> maps) {
        this.maps = maps;
    }

    public Set<Object> getSets() {
        return sets;
    }

    public void setSets(Set<Object> sets) {
        this.sets = sets;
    }

    public Properties getPros() {
        return pros;
    }

    public void setPros(Properties pros) {
        this.pros = pros;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("Customer: \n");
        sb.append("lists: " + lists);
        sb.append("\n maps: " + maps);
        sb.append("\n sets: " + sets);
        sb.append("\n props: " + pros);

        return sb.toString();
    }
}
