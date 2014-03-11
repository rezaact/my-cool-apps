package id.co.hans.sample.controller;

import id.co.hans.sample.server.dao.MasterDao;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MasterController {

    public static final org.apache.commons.logging.Log log = LogFactory.getLog(MasterController.class);

    @Autowired
    MasterDao masterDao;


    @RequestMapping(value = "**/Master/GetMasterUnit.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject getMasterUnit(@RequestParam(value = "inTipe", defaultValue = "")String inTipe,
                                     @RequestParam(value = "inValue", defaultValue = "")String inValue) {
//        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String, Object>> retValue = new ArrayList<Map<String, Object>>();

        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  masterDao.getMasterUnit(inTipe,inValue);
            obj.put("result", retValue);
//            obj.put("records", ws_usersDao.getPengelola());
//            obj.writeJSONString(out);
//            retVal = out.toString();
        }
        catch (Exception ex) {
            retVal = "Error parsing JSON. Msg: " + ex.getMessage();
        }

        return obj;

    }
}
