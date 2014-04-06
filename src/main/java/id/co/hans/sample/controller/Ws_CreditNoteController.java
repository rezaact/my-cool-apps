package id.co.hans.sample.controller;

import id.co.hans.sample.server.dao.ws_CreditNoteDao;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ws_CreditNoteController {
  public static final org.apache.commons.logging.Log log = LogFactory
      .getLog(Ws_CreditNoteController.class);

  @Autowired
  ws_CreditNoteDao ws_creditNoteDao;

  @RequestMapping(value = "**/Ws_CreditNote/ambilDataCN.json", method = RequestMethod.GET,
      produces = "application/json")
  public @ResponseBody
  JSONObject ambilDataCN(@RequestParam(value = "unitup", defaultValue = "") String unitup,
      @RequestParam(value = "kdpp", defaultValue = "") String kdpp, @RequestParam(
          value = "tglbayar", defaultValue = "") String tglbayar) {
    Map<String, Object> retValue = new HashMap<String, Object>();
    JSONObject obj = new JSONObject();
    StringWriter out = new StringWriter();

    String retVal = "Init";
    try {
      retValue = ws_creditNoteDao.ambilDataCN(unitup, kdpp, tglbayar);
      obj.put("result", retValue);
      // obj.put("records", ws_usersDao.getPengelola());
      // obj.writeJSONString(out);
      // retVal = out.toString();
    } catch (Exception ex) {
      retVal = "Error parsing JSON. Msg: " + ex.getMessage();
    }

    return obj;

  }


  @RequestMapping(value = "**/Ws_CreditNote/ambilDataCNPengelola.json", method = RequestMethod.GET,
      produces = "application/json")
  public @ResponseBody
  JSONObject ambilDataCNPengelola(@RequestParam(value = "unitup", defaultValue = "") String unitup,
      @RequestParam(value = "kdpengelola", defaultValue = "") String kdpengelola, @RequestParam(
          value = "tglbayar", defaultValue = "") String tglbayar) {
    Map<String, Object> retValue = new HashMap<String, Object>();
    JSONObject obj = new JSONObject();
    StringWriter out = new StringWriter();

    String retVal = "Init";
    try {
      retValue = ws_creditNoteDao.ambilDataCNPengelola(unitup, kdpengelola, tglbayar);
      obj.put("result", retValue);
      // obj.put("records", ws_usersDao.getPengelola());
      // obj.writeJSONString(out);
      // retVal = out.toString();
    } catch (Exception ex) {
      retVal = "Error parsing JSON. Msg: " + ex.getMessage();
    }

    return obj;

  }


  @RequestMapping(value = "**/Ws_CreditNote/ambilDataCNPetugas.json", method = RequestMethod.GET,
      produces = "application/json")
  public @ResponseBody
  JSONObject ambilDataCNPetugas(@RequestParam(value = "unitup", defaultValue = "") String unitup,
      @RequestParam(value = "kdpp", defaultValue = "") String kdpp, @RequestParam(
          value = "tglbayar", defaultValue = "") String tglbayar, @RequestParam(value = "ptgbayar",
          defaultValue = "") String ptgbayar) {
    Map<String, Object> retValue = new HashMap<String, Object>();
    JSONObject obj = new JSONObject();
    StringWriter out = new StringWriter();

    String retVal = "Init";
    try {
      retValue = ws_creditNoteDao.ambilDataCNPetugas(unitup, kdpp, tglbayar, ptgbayar);
      obj.put("result", retValue);
      // obj.put("records", ws_usersDao.getPengelola());
      // obj.writeJSONString(out);
      // retVal = out.toString();
    } catch (Exception ex) {
      retVal = "Error parsing JSON. Msg: " + ex.getMessage();
    }

    return obj;

  }


  @RequestMapping(value = "**/Ws_CreditNote/ambilDataDanaperTglPp.json",
      method = RequestMethod.GET, produces = "application/json")
  public @ResponseBody
  JSONObject ambilDataDanaperTglPp(
      @RequestParam(value = "unitup", defaultValue = "") String unitup, @RequestParam(
          value = "kdpp", defaultValue = "") String kdpp, @RequestParam(value = "tglAwal",
          defaultValue = "") String tglAwal,
      @RequestParam(value = "tglAkhir", defaultValue = "") String tglAkhir) {
    Map<String, Object> retValue = new HashMap<String, Object>();
    JSONObject obj = new JSONObject();
    StringWriter out = new StringWriter();

    String retVal = "Init";
    try {
      retValue = ws_creditNoteDao.ambilDataDanaperTglPp(unitup, kdpp, tglAwal, tglAkhir);
      obj.put("result", retValue);
      // obj.put("records", ws_usersDao.getPengelola());
      // obj.writeJSONString(out);
      // retVal = out.toString();
    } catch (Exception ex) {
      retVal = "Error parsing JSON. Msg: " + ex.getMessage();
    }

    return obj;

  }

  @RequestMapping(value = "**/Ws_CreditNote/ambilFormatCN.json", method = RequestMethod.GET,
      produces = "application/json")
  public @ResponseBody
  JSONObject ambilFormatCN() {
    Map<String, Object> retValue = new HashMap<String, Object>();
    JSONObject obj = new JSONObject();
    StringWriter out = new StringWriter();

    String retVal = "Init";
    try {
      retValue = ws_creditNoteDao.ambilFormatCN();
      obj.put("result", retValue);
      // obj.put("records", ws_usersDao.getPengelola());
      // obj.writeJSONString(out);
      // retVal = out.toString();
    } catch (Exception ex) {
      retVal = "Error parsing JSON. Msg: " + ex.getMessage();
    }

    return obj;

  }


  @RequestMapping(value = "**/Ws_CreditNote/ambilFormatCNPengelola.json",
      method = RequestMethod.GET, produces = "application/json")
  public @ResponseBody
  JSONObject ambilFormatCNPengelola() {
    Map<String, Object> retValue = new HashMap<String, Object>();
    JSONObject obj = new JSONObject();
    StringWriter out = new StringWriter();

    String retVal = "Init";
    try {
      retValue = ws_creditNoteDao.ambilFormatCNPengelola();
      obj.put("result", retValue);
      // obj.put("records", ws_usersDao.getPengelola());
      // obj.writeJSONString(out);
      // retVal = out.toString();
    } catch (Exception ex) {
      retVal = "Error parsing JSON. Msg: " + ex.getMessage();
    }

    return obj;

  }

  @RequestMapping(value = "**/Ws_CreditNote/ambilFormatCNPerPlg.json", method = RequestMethod.GET,
      produces = "application/json")
  public @ResponseBody
  JSONObject ambilFormatCNPerPlg() {
    Map<String, Object> retValue = new HashMap<String, Object>();
    JSONObject obj = new JSONObject();
    StringWriter out = new StringWriter();

    String retVal = "Init";
    try {
      retValue = ws_creditNoteDao.ambilFormatCNPerPlg();
      obj.put("result", retValue);
      // obj.put("records", ws_usersDao.getPengelola());
      // obj.writeJSONString(out);
      // retVal = out.toString();
    } catch (Exception ex) {
      retVal = "Error parsing JSON. Msg: " + ex.getMessage();
    }

    return obj;

  }


  @RequestMapping(value = "**/Ws_CreditNote/ambilNamaBank.json", method = RequestMethod.GET,
      produces = "application/json")
  public @ResponseBody
  JSONObject ambilNamaBank(@RequestParam(value = "unitup", defaultValue = "") String unitup) {
    Map<String, Object> retValue = new HashMap<String, Object>();
    JSONObject obj = new JSONObject();
    StringWriter out = new StringWriter();

    String retVal = "Init";
    try {
      retValue = ws_creditNoteDao.ambilNamaBank(unitup);
      obj.put("result", retValue);
      // obj.put("records", ws_usersDao.getPengelola());
      // obj.writeJSONString(out);
      // retVal = out.toString();
    } catch (Exception ex) {
      retVal = "Error parsing JSON. Msg: " + ex.getMessage();
    }

    return obj;

  }


  @RequestMapping(value = "**/Ws_CreditNote/ambilRekapCN.json", method = RequestMethod.GET,
      produces = "application/json")
  public @ResponseBody
  JSONObject ambilRekapCN(@RequestParam(value = "Jenis", defaultValue = "") String Jenis,
      @RequestParam(value = "unitup", defaultValue = "") String unitup, @RequestParam(
          value = "kdpp", defaultValue = "") String kdpp, @RequestParam(value = "tglAwal",
          defaultValue = "") String tglAwal,
      @RequestParam(value = "tglAkhir", defaultValue = "") String tglAkhir) {
    Map<String, Object> retValue = new HashMap<String, Object>();
    JSONObject obj = new JSONObject();
    StringWriter out = new StringWriter();

    String retVal = "Init";
    try {
      retValue = ws_creditNoteDao.ambilRekapCN(Jenis, unitup, kdpp, tglAwal, tglAkhir);
      obj.put("result", retValue);
      // obj.put("records", ws_usersDao.getPengelola());
      // obj.writeJSONString(out);
      // retVal = out.toString();
    } catch (Exception ex) {
      retVal = "Error parsing JSON. Msg: " + ex.getMessage();
    }

    return obj;

  }


  @RequestMapping(value = "**/Ws_CreditNote/isCNExist.json", method = RequestMethod.GET,
      produces = "application/json")
  public @ResponseBody
  JSONObject isCNExist(@RequestParam(value = "kdpp", defaultValue = "") String kdpp, @RequestParam(
      value = "tglbayar", defaultValue = "") String tglbayar) {
    Map<String, Object> retValue = new HashMap<String, Object>();
    JSONObject obj = new JSONObject();
    StringWriter out = new StringWriter();

    String retVal = "Init";
    try {
      retValue = ws_creditNoteDao.isCNExist(kdpp, tglbayar);
      obj.put("result", retValue);
      // obj.put("records", ws_usersDao.getPengelola());
      // obj.writeJSONString(out);
      // retVal = out.toString();
    } catch (Exception ex) {
      retVal = "Error parsing JSON. Msg: " + ex.getMessage();
    }

    return obj;

  }


  @RequestMapping(value = "**/Ws_CreditNote/isCNPengelolaExist.json", method = RequestMethod.GET,
      produces = "application/json")
  public @ResponseBody
  JSONObject isCNPengelolaExist(
      @RequestParam(value = "kdpengelola", defaultValue = "") String kdpengelola, @RequestParam(
          value = "tglbayar", defaultValue = "") String tglbayar) {
    Map<String, Object> retValue = new HashMap<String, Object>();
    JSONObject obj = new JSONObject();
    StringWriter out = new StringWriter();

    String retVal = "Init";
    try {
      retValue = ws_creditNoteDao.isCNPengelolaExist(kdpengelola, tglbayar);
      obj.put("result", retValue);
      // obj.put("records", ws_usersDao.getPengelola());
      // obj.writeJSONString(out);
      // retVal = out.toString();
    } catch (Exception ex) {
      retVal = "Error parsing JSON. Msg: " + ex.getMessage();
    }

    return obj;

  }

  @RequestMapping(value = "**/Ws_CreditNote/isCNPetugasExist.json", method = RequestMethod.GET,
      produces = "application/json")
  public @ResponseBody
  JSONObject isCNPetugasExist(@RequestParam(value = "unitup", defaultValue = "") String unitup,
      @RequestParam(value = "kdpp", defaultValue = "") String kdpp, @RequestParam(
          value = "tglbayar", defaultValue = "") String tglbayar) {
    Map<String, Object> retValue = new HashMap<String, Object>();
    JSONObject obj = new JSONObject();
    StringWriter out = new StringWriter();

    String retVal = "Init";
    try {
      retValue = ws_creditNoteDao.isCNPetugasExist(unitup, kdpp, tglbayar);
      obj.put("result", retValue);
      // obj.put("records", ws_usersDao.getPengelola());
      // obj.writeJSONString(out);
      // retVal = out.toString();
    } catch (Exception ex) {
      retVal = "Error parsing JSON. Msg: " + ex.getMessage();
    }

    return obj;

  }


  @RequestMapping(value = "**/Ws_CreditNote/isCNPetugasExist2.json", method = RequestMethod.GET,
      produces = "application/json")
  public @ResponseBody
  JSONObject isCNPetugasExist2(@RequestParam(value = "kdpp", defaultValue = "") String kdpp,
      @RequestParam(value = "tglbayar", defaultValue = "") String tglbayar) {
    Map<String, Object> retValue = new HashMap<String, Object>();
    JSONObject obj = new JSONObject();
    StringWriter out = new StringWriter();

    String retVal = "Init";
    try {
      retValue = ws_creditNoteDao.isCNPetugasExist(kdpp, tglbayar);
      obj.put("result", retValue);
      // obj.put("records", ws_usersDao.getPengelola());
      // obj.writeJSONString(out);
      // retVal = out.toString();
    } catch (Exception ex) {
      retVal = "Error parsing JSON. Msg: " + ex.getMessage();
    }

    return obj;

  }


  @RequestMapping(value = "**/Ws_CreditNote/simpanDataCN.json", method = RequestMethod.GET,
      produces = "application/json")
  public @ResponseBody
  JSONObject simpanDataCN(@RequestParam(value = "ds", defaultValue = "") JSONObject ds,
      @RequestParam(value = "kdpp", defaultValue = "") Boolean bEdit) {
    Map<String, Object> retValue = new HashMap<String, Object>();

    JSONObject obj = new JSONObject();
    StringWriter out = new StringWriter();

    String retVal = "Init";
    try {
      Map<String, Object> dsMap = new ObjectMapper().readValue(ds.toJSONString(), HashMap.class);
      retValue = ws_creditNoteDao.simpanDataCN(dsMap, bEdit);
      obj.put("result", retValue);
      // obj.put("records", ws_usersDao.getPengelola());
      // obj.writeJSONString(out);
      // retVal = out.toString();
    } catch (Exception ex) {
      retVal = "Error parsing JSON. Msg: " + ex.getMessage();
    }

    return obj;

  }

  @RequestMapping(value = "**/Ws_CreditNote/simpanDataCNPengelola.json",
      method = RequestMethod.GET, produces = "application/json")
  public @ResponseBody
  JSONObject simpanDataCNPengelola(
      @RequestParam(value = "ds", defaultValue = "") Map<String, Object> ds, @RequestParam(
          value = "kdpp", defaultValue = "") Boolean bEdit) {
    Map<String, Object> retValue = new HashMap<String, Object>();
    JSONObject obj = new JSONObject();
    StringWriter out = new StringWriter();

    String retVal = "Init";
    try {
      retValue = ws_creditNoteDao.simpanDataCNPengelola(ds, bEdit);
      obj.put("result", retValue);
      // obj.put("records", ws_usersDao.getPengelola());
      // obj.writeJSONString(out);
      // retVal = out.toString();
    } catch (Exception ex) {
      retVal = "Error parsing JSON. Msg: " + ex.getMessage();
    }

    return obj;

  }

  @RequestMapping(value = "**/Ws_CreditNote/simpanDataCNPerPetugas.json",
      method = RequestMethod.GET, produces = "application/json")
  public @ResponseBody
  JSONObject simpanDataCNPerPetugas(
      @RequestParam(value = "ds", defaultValue = "") Map<String, Object> ds, @RequestParam(
          value = "kdpp", defaultValue = "") Boolean bEdit) {
    Map<String, Object> retValue = new HashMap<String, Object>();
    JSONObject obj = new JSONObject();
    StringWriter out = new StringWriter();

    String retVal = "Init";
    try {
      retValue = ws_creditNoteDao.simpanDataCNPerPetugas(ds, bEdit);
      obj.put("result", retValue);
      // obj.put("records", ws_usersDao.getPengelola());
      // obj.writeJSONString(out);
      // retVal = out.toString();
    } catch (Exception ex) {
      retVal = "Error parsing JSON. Msg: " + ex.getMessage();
    }

    return obj;

  }
}
