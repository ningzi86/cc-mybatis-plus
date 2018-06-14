package cn.golango.mybatis.utils;


import cn.golango.mybatis.common.Constant;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class PagerUtils {

    public static String getPager(Integer current) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();

        Map<String, String[]> maps = request.getParameterMap();
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("?%s=%d", Constant.PAGER_PARAM_KEY, current));
        for (Map.Entry<String, String[]> entry : maps.entrySet()) {
            if (!entry.getKey().equals(Constant.PAGER_PARAM_KEY)) {
                sb.append(String.format("&%s=%s", entry.getKey(), entry.getValue()[0]));
            }
        }

        return sb.toString();


    }
}
