package appfactory.web;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liweinan
 * Date: 13-8-25
 * Time: PM7:41
 * To change this template use File | Settings | File Templates.
 */
public class AbstractBaseController {

    @ModelAttribute("function_code_map")
    public Map<String, String> getFunctionCodeMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("CONTACT_INFO", "一键呼叫");
        map.put("POST_CATEGORY", "文章分类");
        map.put("POST", "文章");
        return map;
    }

}
