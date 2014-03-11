package id.co.hans.sample.controller;

import id.co.hans.sample.server.dao.clsUsers;
import id.co.hans.sample.server.dao.ws_AdministrasiDao;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Ws_AdministrasiController {
    //
    public static final org.apache.commons.logging.Log log = LogFactory.getLog(Ws_AdministrasiController.class);

    @Autowired
    ws_AdministrasiDao ws_administrasiDao;

    @RequestMapping(value = "**/Ws_Administrasi/wsPetugas_lihatRolesbaru.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject wsPetugas_lihatRolesbaru(){
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_administrasiDao.wsPetugas_lihatRolesbaru();
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

    @RequestMapping(value = "**/Ws_Administrasi/wsPetugas_lihatPetugas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject wsPetugas_lihatPetugas(){
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_administrasiDao.wsPetugas_lihatPetugas();
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

    @RequestMapping(value = "**/Ws_Administrasi/wsPetugas_eksekusiPetugas.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject wsPetugas_eksekusiPetugas(@RequestParam(value = "tUsers", defaultValue = "")clsUsers tUsers){
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_administrasiDao.wsPetugas_eksekusiPetugas(tUsers);
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
    //--- End Administrasi Pengguna Aplikasi

    //--- Start Administrasi Kewenangan Petugas

    @RequestMapping(value = "**/Ws_Administrasi/wsRoles_GetRolesMenus.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject wsRoles_GetRolesMenus(@RequestParam(value = "RoleID", defaultValue = "")Integer RoleID){
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_administrasiDao.wsRoles_GetRolesMenus(RoleID);
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


    @RequestMapping(value = "**/Ws_Administrasi/wsRoles_GetMenus.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject wsRoles_GetMenus(){
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_administrasiDao.wsRoles_GetMenus();
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


    @RequestMapping(value = "**/Ws_Administrasi/wsRoles_GetRoles.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject wsRoles_GetRoles(){
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_administrasiDao.wsRoles_GetRoles();
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

    @RequestMapping(value = "**/Ws_Administrasi/wsRoles_UpdateRoles.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject wsRoles_UpdateRoles(@RequestParam(value = "RoleID", defaultValue = "")Integer RoleID,
                                   @RequestParam(value = "arr", defaultValue = "")List<Map<String, String>> arr){
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_administrasiDao.wsRoles_UpdateRoles(RoleID,arr);
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


    @RequestMapping(value = "**/Ws_Administrasi/wsRoles_insertRolebaru.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject wsRoles_insertRolebaru(@RequestParam(value = "tIdRolesBaru", defaultValue = "")String tIdRolesBaru,
                                   @RequestParam(value = "tNew", defaultValue = "")String tNew,
                                   @RequestParam(value = "tDesc", defaultValue = "")String tDesc){
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_administrasiDao.wsRoles_insertRolebaru(tIdRolesBaru,tNew,tDesc);
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


    @RequestMapping(value = "**/Ws_Administrasi/wsRoles_selectMaxRole.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject wsRoles_selectMaxRole(){
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_administrasiDao.wsRoles_selectMaxRole();
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
    //--- End Administrasi Kewenangan Petugas

    //--- Start Administrasi Buka Tutup IDPEL di SOPP ONLINE

    @RequestMapping(value = "**/Ws_Administrasi/wsFlagSOPP_EksekusiBukaTutup.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject wsFlagSOPP_EksekusiBukaTutup(@RequestParam(value = "petugas", defaultValue = "")String petugas,
                                      @RequestParam(value = "idPel", defaultValue = "")String idPel,
                                      @RequestParam(value = "inkaso", defaultValue = "")String inkaso,
                                      @RequestParam(value = "flagSopp", defaultValue = "")String flagSopp){
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_administrasiDao.wsFlagSOPP_EksekusiBukaTutup(petugas,idPel,inkaso,flagSopp);
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


    @RequestMapping(value = "**/Ws_Administrasi/wsFlagSOPP_lihatLogFlagSOPP.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject wsFlagSOPP_lihatLogFlagSOPP(){
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_administrasiDao.wsFlagSOPP_lihatLogFlagSOPP();
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


    @RequestMapping(value = "**/Ws_Administrasi/wsFlagSOPP_cekFlagSOPPIdpel.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject wsFlagSOPP_cekFlagSOPPIdpel(@RequestParam(value = "idPel", defaultValue = "")String idPel){
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_administrasiDao.wsFlagSOPP_cekFlagSOPPIdpel(idPel);
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
    //--- End Administrasi Buka Tutup IDPEL di SOPP ONLINE

    //--- Start Administrasi Role Rupiah Cicilan

    @RequestMapping(value = "**/Ws_Administrasi/wsRupiah_lihatRoleCicilan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject wsRupiah_lihatRoleCicilan(){
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_administrasiDao.wsRupiah_lihatRoleCicilan();
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


    @RequestMapping(value = "**/Ws_Administrasi/wsRupiah_simpanRoleCicilan.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject wsRupiah_simpanRoleCicilan(@RequestParam(value = "role", defaultValue = "")String role,
                                            @RequestParam(value = "rpMin", defaultValue = "")String rpMin,
                                            @RequestParam(value = "rpMax", defaultValue = "")String rpMax,
                                            @RequestParam(value = "kaliMin", defaultValue = "")String kaliMin,
                                            @RequestParam(value = "kaliMax", defaultValue = "")String kaliMax,
                                            @RequestParam(value = "petugas", defaultValue = "")String petugas){
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_administrasiDao.wsRupiah_simpanRoleCicilan(role,rpMin,rpMax,kaliMin,kaliMax,petugas);
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
    //--- End Administrasi Role Rupiah Cicilan

    //--- Start Administrasi Role Rupiah Cicilan
    @RequestMapping(value = "**/Ws_Administrasi/wsRupiah_lihatRoleKoreksi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject wsRupiah_lihatRoleKoreksi(){
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_administrasiDao.wsRupiah_lihatRoleKoreksi();
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


    @RequestMapping(value = "**/Ws_Administrasi/wsRupiah_simpanRoleKoreksi.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject wsRupiah_simpanRoleKoreksi(@RequestParam(value = "role", defaultValue = "")String role,
                                         @RequestParam(value = "rpMin", defaultValue = "")String rpMin,
                                         @RequestParam(value = "rpMax", defaultValue = "")String rpMax,
                                         @RequestParam(value = "petugas", defaultValue = "")String petugas){
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_administrasiDao.wsRupiah_simpanRoleKoreksi(role,rpMin,rpMax,petugas);
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
    //--- End Administrasi Role Rupiah Cicilan

    //--- Cek Role untuk Rupiah Koreksi Rekening dan Cicilan Rekening

    @RequestMapping(value = "**/Ws_Administrasi/wsRupiah_cekBolehKoreksiRp.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject wsRupiah_cekBolehKoreksiRp(@RequestParam(value = "rp", defaultValue = "")Double rp,
                                          @RequestParam(value = "petugas", defaultValue = "")String petugas){
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_administrasiDao.wsRupiah_cekBolehKoreksiRp(rp,petugas);
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


    @RequestMapping(value = "**/Ws_Administrasi/wsRupiah_cekBolehCicilanRp.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject wsRupiah_cekBolehCicilanRp(@RequestParam(value = "rp", defaultValue = "")Double rp,
                                          @RequestParam(value = "kali", defaultValue = "")Integer kali,
                                          @RequestParam(value = "petugas", defaultValue = "")String petugas){
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_administrasiDao.wsRupiah_cekBolehCicilanRp(rp,kali,petugas);
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
    //--- End Cek

    //--- Start Administrasi Role Pembatalan


    @RequestMapping(value = "**/Ws_Administrasi/wsBatal_lihatMenubatal.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject wsBatal_lihatMenubatal(){
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_administrasiDao.wsBatal_lihatMenubatal();
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


    @RequestMapping(value = "**/Ws_Administrasi/wsBatal_lihatRolebatal.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject wsBatal_lihatRolebatal(){
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_administrasiDao.wsBatal_lihatRolebatal();
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

    @RequestMapping(value = "**/Ws_Administrasi/wsBatal_simpanRoleBatal.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject wsBatal_simpanRoleBatal(@RequestParam(value = "roleId", defaultValue = "")String roleId,
                                          @RequestParam(value = "menuId", defaultValue = "")String menuId,
                                          @RequestParam(value = "menuName", defaultValue = "")String menuName,
                                          @RequestParam(value = "status", defaultValue = "")Integer status,
                                          @RequestParam(value = "petugas", defaultValue = "")String petugas){
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_administrasiDao.wsBatal_simpanRoleBatal(roleId,menuId,menuName,status,petugas);
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
    //--- End Administrasi Role Pembatalan


    @RequestMapping(value = "**/Ws_Administrasi/gantiPassword.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JSONObject gantiPassword(@RequestParam(value = "sUserID", defaultValue = "")String sUserID,
                                          @RequestParam(value = "sPasswordLama", defaultValue = "")String sPasswordLama,
                                          @RequestParam(value = "sPasswordBaru", defaultValue = "")String sPasswordBaru,
                                          @RequestParam(value = "sPasswordBaruKonfirm", defaultValue = "")String sPasswordBaruKonfirm){
        Map<String, Object> retValue = new HashMap<String, Object>();
        JSONObject obj = new JSONObject();
        StringWriter out = new StringWriter();

        String retVal = "Init";
        try {
            retValue=  ws_administrasiDao.gantiPassword(sUserID,sPasswordLama,sPasswordBaru,sPasswordBaruKonfirm);
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
