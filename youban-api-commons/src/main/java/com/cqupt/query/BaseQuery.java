package com.cqupt.query;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;


@Data
public class BaseQuery {
    private Integer page=1;
    private Integer limit=6;

    public Map<String, Object> getMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("page", page);
        map.put("limit", limit);
        return map;
    }
}
