package com.lishuangqi.utils;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.util.Comparator;

/**
 * Created by michael on 2017/9/13.
 */
public class JsonComparator implements Comparator {
    private String sortname;
    private boolean isAsc;

    public JsonComparator(String sortname, boolean isAsc) {
        this.sortname = sortname;
        this.isAsc = isAsc;
    }

    @Override
    public int compare(Object a, Object b) {
        JSONObject aa = (JSONObject) a;
        JSONObject bb = (JSONObject) b;

        try {
            int valA = aa.getInt(sortname);
            int valB = bb.getInt(sortname);
            if (isAsc) {
                return valA - valB;
            } else {
                return valB - valA;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
        //if you want to change the sort order, simply use the following:
        //return -valA.compareTo(valB);
    }

}
