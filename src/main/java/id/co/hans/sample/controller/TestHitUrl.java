package id.co.hans.sample.controller;

import com.google.gwt.json.client.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestHitUrl {

    @RequestMapping(value = "**/thuGetString.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String getString(@RequestParam("name") String name) {

        return "{\"records\":[{\"kolom1\":\"kolom1\", \"kolom2\":\"kolom2\", \"kolom3\":\"kolom3\"}]}";
    }

    @RequestMapping(value = "**/thuGetString2.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String getString2() {

        return "{\"records\":[{\"kolomA\":\"Data A\", \"kolomB\":\"Data B\", \"kolomC\":\"Data C\", \"kolomD\":\"Data D\", \"kolomE\":\"Data E\"}]}";
    }


    @RequestMapping(value = "**/thuGetComboData.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String getComboData() {

        return "{\"records\":[{\"fieldValue\":\"aaaa\", \"displayValue\":\"ini a\"}, {\"fieldValue\":\"bbbb\", \"displayValue\":\"ini b\"}]}";
    }

    @RequestMapping(value = "**/thuGetComboData2.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String getComboData2() {

        return "{\"records\":[{\"fieldValue\":\"aa222\", \"displayValue\":\"ini a 2\"}, {\"fieldValue\":\"bb222\", \"displayValue\":\"ini b2\"}]}";
    }


    @RequestMapping(value = "**/thuGetComboTahun.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String getComboTahunData() {

        return "{\"records\":[{\"fieldValue\":\"2013\", \"displayValue\":\"2013\"}, {\"fieldValue\":\"2012\", \"displayValue\":\"2012\"}]}";
    }

    @RequestMapping(value = "**/thuGetComboBulan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String getComboBulanData() {

        return "{\"records\":[{\"fieldValue\":\"01\", \"displayValue\":\"Januari\"}, {\"fieldValue\":\"02\", \"displayValue\":\"Februari\"}]}";
    }

    @RequestMapping(value = "**/thuGetComboTanggal.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String getComboTanggalData() {

        return "{\"records\":[{\"fieldValue\":\"01\", \"displayValue\":\"1\"}, {\"fieldValue\":\"02\", \"displayValue\":\"2\"}, {\"fieldValue\":\"03\", \"displayValue\":\"3\"}, {\"fieldValue\":\"03\", \"displayValue\":\"4\"}, {\"fieldValue\":\"05\", \"displayValue\":\"5\"}, {\"fieldValue\":\"06\", \"displayValue\":\"6\"}, {\"fieldValue\":\"07\", \"displayValue\":\"7\"}, {\"fieldValue\":\"08\", \"displayValue\":\"8\"}, {\"fieldValue\":\"09\", \"displayValue\":\"9\"}, {\"fieldValue\":\"10\", \"displayValue\":\"10\"}]}";
    }



    @RequestMapping(value = "**/thuGetStringPost.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody String getStringPOST() {

        return "ACK-OK";
    }
}
