package com.lishuangqi.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by michael on 2017/11/1.
 */
public class SqlBuilder {
    protected StringBuilder sqlBuf = new StringBuilder();
    protected List<Object> values = new ArrayList<Object>();
    protected Map<String, Object> paramMap = new HashMap<String, Object>();

    public SqlBuilder appendSql(String sql) {
        sqlBuf.append(sql);
        return this;
    }

    public SqlBuilder appendValue(Object value) {
        sqlBuf.append('?');
        values.add(value);
        return this;
    }

    public SqlBuilder appendValues(Object[] values) {
        sqlBuf.append('(');
        for (int i = 0, c = values.length; i < c; ++i) {
            sqlBuf.append('?').append(',');
            this.values.add(values[i]);
        }
        int last = sqlBuf.length() - 1;
        if (last > 0 && sqlBuf.charAt(last) == ',') {
            sqlBuf.setCharAt(last, ')');
        }
        return this;
    }

    public SqlBuilder appendEqParam(String param, Object value) {
        sqlBuf.append(param).append(" = :").append(param);
        paramMap.put(param, value);
        return this;
    }

    public SqlBuilder appendLtParam(String param, Object value) {
        sqlBuf.append(param).append(" < :").append(param);
        paramMap.put(param, value);
        return this;
    }

    public SqlBuilder appendGtParam(String param, Object value) {
        sqlBuf.append(param).append(" > :").append(param);
        paramMap.put(param, value);
        return this;
    }

    public SqlBuilder appendInParam(String param, Object ... values) {
        if(values == null) {
            return this;
        }
        sqlBuf.append(param).append(" in (");
        int len = values.length;
        for(int i = 0; i < len; i++) {
            if(i != 0) {
                sqlBuf.append(", ");
            }
            sqlBuf.append(":").append(param).append(i);
            paramMap.put(param+i, values[i]);
        }
        sqlBuf.append(")");
        return this;
    }

    public SqlBuilder appendLikeParam(String param, Object value) {
        sqlBuf.append(param).append(" like :").append(param);
        paramMap.put(param, "%"+value+"%");
        return this;
    }

    public String getSql() {
        return sqlBuf.toString();
    }

    public Object[] getValues() {
        return values.toArray();
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }
}