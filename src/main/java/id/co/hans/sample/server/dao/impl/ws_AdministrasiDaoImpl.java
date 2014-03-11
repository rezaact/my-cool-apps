package id.co.hans.sample.server.dao.impl;


import id.co.hans.sample.server.dao.clsUsers;
import id.co.hans.sample.server.dao.cls_Administrasi;
import id.co.hans.sample.server.dao.ws_AdministrasiDao;
import id.co.hans.sample.server.utility.CommonModule;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ws_AdministrasiDaoImpl implements ws_AdministrasiDao {
    public static final Log log = LogFactory.getLog(ws_AdministrasiDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> wsPetugas_lihatRolesbaru() {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_Administrasi kelasAdmin = new cls_Administrasi();
        retValue = kelasAdmin.lihatRolesbaru();

        return retValue;
    }

    @Override
    public Map<String, Object> wsPetugas_lihatPetugas() {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_Administrasi kelasAdmin = new cls_Administrasi();
        retValue = kelasAdmin.lihatPetugas();

        return retValue;
    }

    @Override
    public Map<String, Object> wsPetugas_eksekusiPetugas(clsUsers tUsers) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_Administrasi kelasAdmin = new cls_Administrasi();
        retValue = kelasAdmin.eksekusiPetugas(tUsers.KODEPETUGAS, tUsers.NAMAPETUGAS, tUsers.KELAMIN, tUsers.NIP, tUsers.UNITUP,
                tUsers.KODEPP, tUsers.PASSWORD, tUsers.ROLEID, tUsers.SK, tUsers.FROMDATE, tUsers.THRUDATE, tUsers.PETUGAS_CATAT,
                tUsers.RIGHTSLOGIN);

        return retValue;
    }
    //--- End Administrasi Pengguna Aplikasi

    //--- Start Administrasi Kewenangan Petugas
    @Override
    public Map<String, Object> wsRoles_GetRolesMenus(Integer RoleID) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_Administrasi kelasAdmin = new cls_Administrasi();
        retValue = kelasAdmin.GetRolesMenus(RoleID);

        return retValue;
    }


    @Override
    public Map<String, Object> wsRoles_GetMenus() {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_Administrasi kelasAdmin = new cls_Administrasi();
        retValue = kelasAdmin.GetMenus();

        return retValue;
    }


    @Override
    public Map<String, Object> wsRoles_GetRoles() {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_Administrasi kelasAdmin = new cls_Administrasi();
        retValue = kelasAdmin.GetRoles();

        return retValue;
    }


    @Override
    public Map<String, Object> wsRoles_UpdateRoles(Integer RoleID, List<Map<String, String>> arr) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_Administrasi kelasAdmin = new cls_Administrasi();
        retValue = kelasAdmin.UpdateRoles(RoleID, arr);

        return retValue;
    }


    @Override
    public Map<String, Object> wsRoles_insertRolebaru(String tIdRolesBaru, String tNew, String tDesc) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_Administrasi kelasAdmin = new cls_Administrasi();
        retValue = kelasAdmin.insertRolebaru(tIdRolesBaru, tNew, tDesc);

        return retValue;
    }


    @Override
    public Map<String, Object> wsRoles_selectMaxRole() {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_Administrasi kelasAdmin = new cls_Administrasi();
        retValue = kelasAdmin.selectMaxRole();

        return retValue;
    }
    //--- End Administrasi Kewenangan Petugas

    //--- Start Administrasi Buka Tutup IDPEL di SOPP ONLINE
    @Override
    public Map<String, Object> wsFlagSOPP_EksekusiBukaTutup(String petugas, String idPel, String inkaso, String flagSopp) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_Administrasi kelasAdmin = new cls_Administrasi();
        retValue = kelasAdmin.EksekusiBukaTutup(petugas, idPel, inkaso, flagSopp);

        return retValue;
    }

    @Override
    public Map<String, Object> wsFlagSOPP_lihatLogFlagSOPP() {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_Administrasi kelasAdmin = new cls_Administrasi();
        retValue = kelasAdmin.lihatLogFlagSOPP();

        return retValue;
    }

    @Override
    public Map<String, Object> wsFlagSOPP_cekFlagSOPPIdpel(String idPel) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_Administrasi kelasAdmin = new cls_Administrasi();
        retValue = kelasAdmin.cekFlagSOPPIdpel(idPel);

        return retValue;
    }
    //--- End Administrasi Buka Tutup IDPEL di SOPP ONLINE

    //--- Start Administrasi Role Rupiah Cicilan
    @Override
    public Map<String, Object> wsRupiah_lihatRoleCicilan() {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_Administrasi kelasAdmin = new cls_Administrasi();
        retValue = kelasAdmin.lihatRoleCicilan();

        return retValue;
    }

    @Override
    public Map<String, Object> wsRupiah_simpanRoleCicilan(String role, String rpMin, String rpMax, String kaliMin, String kaliMax, String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_Administrasi kelasAdmin = new cls_Administrasi();
        retValue = kelasAdmin.simpanRoleCicilan(role, rpMin, rpMax, kaliMin, kaliMax, petugas);

        return retValue;
    }
    //--- End Administrasi Role Rupiah Cicilan

    //--- Start Administrasi Role Rupiah Cicilan
    @Override
    public Map<String, Object> wsRupiah_lihatRoleKoreksi() {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_Administrasi kelasAdmin = new cls_Administrasi();
        retValue = kelasAdmin.lihatRoleKoreksi();

        return retValue;
    }

    @Override
    public Map<String, Object> wsRupiah_simpanRoleKoreksi(String role, String rpMin, String rpMax, String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_Administrasi kelasAdmin = new cls_Administrasi();
        retValue = kelasAdmin.simpanRoleKoreksi(role, rpMin, rpMax, petugas);

        return retValue;
    }
    //--- End Administrasi Role Rupiah Cicilan

    //--- Cek Role untuk Rupiah Koreksi Rekening dan Cicilan Rekening
    @Override
    public Map<String, Object> wsRupiah_cekBolehKoreksiRp(Double rp, String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_Administrasi kelasAdmin = new cls_Administrasi();
        retValue = kelasAdmin.cekBolehKoreksiRp(rp, petugas);

        return retValue;
    }


    @Override
    public Map<String, Object> wsRupiah_cekBolehCicilanRp(Double rp, Integer kali, String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_Administrasi kelasAdmin = new cls_Administrasi();
        retValue = kelasAdmin.cekBolehCicilanRp(rp, kali, petugas);

        return retValue;
    }
    //--- End Cek

    //--- Start Administrasi Role Pembatalan
    @Override
    public Map<String, Object> wsBatal_lihatMenubatal() {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_Administrasi kelasAdmin = new cls_Administrasi();
        retValue = kelasAdmin.lihatMenubatal();

        return retValue;
    }

    @Override
    public Map<String, Object> wsBatal_lihatRolebatal() {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_Administrasi kelasAdmin = new cls_Administrasi();
        retValue = kelasAdmin.lihatRolebatal();

        return retValue;
    }

    @Override
    public Map<String, Object> wsBatal_simpanRoleBatal(String roleId, String menuId, String menuName, Integer status, String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_Administrasi kelasAdmin = new cls_Administrasi();
        retValue = kelasAdmin.simpanRoleBatal(roleId, menuId, menuName, status, petugas);

        return retValue;
    }
    //--- End Administrasi Role Pembatalan


    @Override
    public Map<String, Object> gantiPassword(String sUserID,
                                             String sPasswordLama,
                                             String sPasswordBaru,
                                             String sPasswordBaruKonfirm) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        cls_Administrasi kelasAdmin = new cls_Administrasi();
        retValue = kelasAdmin.gantiPassword(sUserID, sPasswordLama, sPasswordBaru, sPasswordBaruKonfirm);

        return retValue;
    }
}
