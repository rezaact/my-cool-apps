package id.co.hans.sample.server.dao;


import id.co.hans.sample.server.utility.CommonModule;
import oracle.jdbc.OracleTypes;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

@Service
public class cls_Administrasi {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //--- Start Administrasi Pengguna Aplikasi
    public Map<String, Object> lihatPetugas() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = " select * from view_adminpetugas " ;

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> lihatRolesbaru() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = " select * from ROLESBARU " ;

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> eksekusiPetugas(String tKODEPETUGAS, String tNAMAPETUGAS,
                                               String tKELAMIN, String tNIP, String tUNITUP, String tKODEPP,
                                               String tPASSWORD, String tROLEID, String tSK, String tFROMDATE,
                                               String tTHRUDATE, String tPETUGAS_CATAT, String tRIGHTSLOGIN) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call Proc_ADMIN_PETUGAS(?,?,?,?,?,?,?,?,?,?,?,?,?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, tKODEPETUGAS);
            cst.setString(2, tNAMAPETUGAS);
            cst.setString(3, tKELAMIN);
            cst.setString(4, tNIP);
            cst.setString(5, tUNITUP);
            cst.setString(6, tKODEPP);
            cst.setString(7, tPASSWORD);
            cst.setString(8, tROLEID);
            cst.setString(9, tSK);
            cst.setString(10, tFROMDATE);
            cst.setString(11, tTHRUDATE);
            cst.setString(12, tPETUGAS_CATAT);
            cst.setString(13, tRIGHTSLOGIN);
            cst.execute();

            retValue.put("wsReturn", true);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }
    //--- End Administrasi Pengguna Aplikasi

    //--- Start Administrasi Kewenangan Petugas
    public Map<String, Object> GetRolesMenus(Integer RoleID) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "select * from ROLESMENUSBARU where ROLEID = " + RoleID.toString();

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> GetMenus() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = " select * from MENUSBARU ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> GetRoles() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = " select * from rolesmenusbaru ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> UpdateRoles(Integer RoleID, List<Map<String,String>> arr) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = " Delete ROLESMENUSBARU Where ROLEID = " + RoleID.toString();
            cst = con.prepareCall(sql);
            cst.execute();

            for (Integer i=0; i<arr.size()-1; i++) {
                sql = " SELECT * FROM ROLESMENUSBARU WHERE ROLEID=" + RoleID.toString() + " AND MENUSID='" + arr.get(i).get(0).toString() + "'";
                cst = con.prepareCall(sql);
                ResultSet rs = cst.executeQuery();
                lMapData = CommonModule.convertResultsetToListStr(rs);

                if (lMapData.size() == 0) {
                    sql = " Insert into ROLESMENUSBARU (ROLEID,MENUSID) Values (" + RoleID.toString() + ",'" + arr.get(i).get(0).toString() + "')";
                    cst = con.prepareCall(sql);
                    cst.execute();
                }
            }

            retValue.put("wsReturn", true);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> insertRolebaru(String tIdRolesBaru, String tNew, String tDesc) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = " insert into rolesbaru (ROLEID, ROLES, DESKRIPSI) VALUES (?,?,?) ";

            cst = con.prepareCall(sql);
            cst.setString(1, tIdRolesBaru);
            cst.setString(2, tNew);
            cst.setString(3, tDesc);
            cst.execute();

            retValue.put("wsReturn", true);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> selectMaxRole() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = " select max(RoleID) From RolesBaru ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }
    //--- End Administrasi Kewenangan Petugas

    //--- Start Administrasi Buka Tutup IDPEL di SOPP ONLINE
    public Map<String, Object> EksekusiBukaTutup(String petugas, String idPel, String inkaso, String flagSopp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call Proc_FlagSopp(?,?,?,?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, flagSopp);
            cst.setString(2, idPel);
            cst.setString(3, inkaso);
            cst.setString(4, petugas);
            cst.execute();

            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> lihatLogFlagSOPP() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = " select tanggal, transaksiby, log from log_flagsopp order by tanggal desc ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> cekFlagSOPPIdpel(String idPel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = " select flagsopp from dpp partition(saldo) where idpel = '" + idPel + "' ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData.get(0).get(0));
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }
    //--- End Administrasi Buka Tutup IDPEL di SOPP ONLINE

    //--- Start Administrasi Role Rupiah Cicilan
    public Map<String, Object> lihatRoleCicilan() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = " select ROLES, RPMIN, RPMAX, KALIMIN, KALIMAX, UPDATEBY, UPDATEAT from view_adminrolecicilan ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> simpanRoleCicilan(String role, String rpMin, String rpMax, String kaliMin,
                                                 String kaliMax, String petugas) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call Proc_Admin_RoleRpCicilan(?,?,?,?,?,?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, role);
            cst.setString(2, rpMin);
            cst.setString(3, rpMax);
            cst.setString(4, kaliMin);
            cst.setString(5, kaliMax);
            cst.setString(6, petugas);
            cst.execute();

            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }
    //--- End Administrasi Role Rupiah Cicilan

    //--- Start Administrasi Role Rupiah Cicilan
    public Map<String, Object> lihatRoleKoreksi() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = " select ROLES, RPMIN, RPMAX, UPDATEBY, UPDATEAT from view_adminrolekoreksi ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> simpanRoleKoreksi(String role, String rpMin, String rpMax, String petugas) {

        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call Proc_Admin_RoleRpKoreksi(?,?,?,?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, role);
            cst.setString(2, rpMin);
            cst.setString(3, rpMax);
            cst.setString(4, petugas);
            cst.execute();

            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }
    //--- End Administrasi Role Rupiah Cicilan

    //--- Cek Role untuk Rupiah Koreksi Rekening dan Cicilan Rekening
    public Map<String, Object> cekBolehKoreksiRp(Double rp, String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = " select count(*) from view_rolerupiahkoreksi ";
            sql += " where " + rp + " >= rpmin and " + rp + " <= rpmax ";
            sql += " and roleId = (select roleid from petugas where kodepetugas = '" + petugas + "') ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.get(0).get(0) == "1") {
                retValue.put("wsReturn", true);
            } else {
                retValue.put("wsReturn", false);
            }

            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> cekBolehCicilanRp(Double rp, Integer kali, String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = " select count(*) from view_rolerupiahcicilan ";
            sql += " where " + rp + " >= rpmin and " + rp + " <= rpmax ";
            sql += " and kaliMin <= " + kali + " and " + kali + " <= kaliMax ";
            sql += " and roleId = (select roleid from petugas where kodepetugas = '" + petugas + "') ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            if (lMapData.get(0).get(0) == "1") {
                retValue.put("wsReturn", true);
            } else {
                retValue.put("wsReturn", false);
            }

            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }
    //--- End Cek

    //--- Start Administrasi Role Pembatalan
    public Map<String, Object> lihatMenubatal() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = " select distinct menuid, menuname from view_rolepembatalan ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> lihatRolebatal() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = " select ROLEID, ROLES, MENUID, MENUNAME, STATUS from view_rolepembatalan ";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapData = CommonModule.convertResultsetToListStr(rs);

            retValue.put("wsReturn", lMapData);
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }

    public Map<String, Object> simpanRoleBatal(String roleId, String menuId, String menuName, Integer status, String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            CallableStatement cst;
            String sql;

            sql = "{ call Proc_Admin_RolePembatalan(?,?,?,?,?) }";
            cst = con.prepareCall(sql);
            cst.setString(1, roleId);
            cst.setString(2, menuId);
            cst.setString(3, menuName);
            cst.setString(4, status.toString());
            cst.setString(5, petugas);
            cst.execute();

            retValue.put("wsReturn", "");
            retValue.put("wsByRefError", "");

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", ex.getMessage());
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }
    //--- End Administrasi Role Pembatalan

    public Map<String, Object> gantiPassword(String sUserID, 
                                             String sPasswordLama,
                                             String sPasswordBaru,
                                             String sPasswordBaruKonfirm) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapData = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();


            if ( sPasswordBaru != sPasswordBaruKonfirm ) {
                throw new Exception("Password baru tidak sesuai dengan konfirmasi nya");
            }

            CallableStatement cst;
            String sql;

            sql = " SELECT KODEPETUGAS,PASSWORD ";
            sql = sql + "FROM PETUGAS ";
            sql = sql + " WHERE KODEPETUGAS='" + sUserID + "'";

            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();
            lMapData = CommonModule.convertResultsetToListStr(rs);

            Secman csecman = new Secman();

            if (lMapData.size() > 0) {
                if ((lMapData.get(0).get("PASSWORD") != sPasswordLama.toUpperCase()) &&
                    (lMapData.get(0).get("PASSWORD") != csecman.GetMD5(sPasswordLama.toUpperCase()))) {
                    throw new Exception("Password lama tidak sesuai");
                }

                sql = " UPDATE PETUGAS SET PASSWORD='" + csecman.GetMD5(sPasswordBaru) + "'";
                sql = sql + " WHERE KODEPETUGAS='" + sUserID + "'";

                cst = con.prepareCall(sql);
                cst.execute();

                retValue.put("wsReturn", true);
                retValue.put("wsByRefError", "");
            } else {
                throw new Exception("Pelanggan tidak ditemukan !");
            }

            con.close();
        } catch (Exception ex)
        {
            retValue.put("wsReturn", false);
            retValue.put("wsByRefError", ex.getMessage());
        }

        return retValue;
    }
}

