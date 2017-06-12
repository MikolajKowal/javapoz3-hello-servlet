package com.sda.todo;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class TodoUtil  {

    public static boolean isWriteRequest(HttpServletRequest request){
        Map<String, String[]> parameterMap = request.getParameterMap();
        return exists("name", parameterMap) &&
                exists("description", parameterMap) &&
                exists("priority", parameterMap) &&
                exists("date", parameterMap);

    }

    private static boolean exists (String param, Map<String, String[]> map){
        return map.containsKey(param) && StringUtils.isNotEmpty(map.get(param)[0]);
    }
}
