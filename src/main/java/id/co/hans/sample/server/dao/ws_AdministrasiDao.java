package id.co.hans.sample.server.dao;

import java.util.List;
import java.util.Map;

public interface ws_AdministrasiDao {
    public Map<String, Object> wsPetugas_lihatRolesbaru();
    public Map<String, Object> wsPetugas_lihatPetugas();
    public Map<String, Object> wsPetugas_eksekusiPetugas(clsUsers tUsers);
    //--- End Administrasi Pengguna Aplikasi

    //--- Start Administrasi Kewenangan Petugas
    public Map<String, Object> wsRoles_GetRolesMenus(Integer RoleID);
    public Map<String, Object> wsRoles_GetMenus();
    public Map<String, Object> wsRoles_GetRoles();
    public Map<String, Object> wsRoles_UpdateRoles(Integer RoleID,  List<Map<String, String>> arr);
    public Map<String, Object> wsRoles_insertRolebaru(String tIdRolesBaru, String tNew, String tDesc);
    public Map<String, Object> wsRoles_selectMaxRole();
    //--- End Administrasi Kewenangan Petugas

    //--- Start Administrasi Buka Tutup IDPEL di SOPP ONLINE
    public Map<String, Object> wsFlagSOPP_EksekusiBukaTutup(String petugas, String idPel, String inkaso, String flagSopp);
    public Map<String, Object> wsFlagSOPP_lihatLogFlagSOPP();
    public Map<String, Object> wsFlagSOPP_cekFlagSOPPIdpel(String idPel);
    //--- End Administrasi Buka Tutup IDPEL di SOPP ONLINE

    //--- Start Administrasi Role Rupiah Cicilan
    public Map<String, Object> wsRupiah_lihatRoleCicilan();
    public Map<String, Object> wsRupiah_simpanRoleCicilan(String role, String rpMin, String rpMax, String kaliMin, String kaliMax, String petugas);
    //--- End Administrasi Role Rupiah Cicilan

    //--- Start Administrasi Role Rupiah Cicilan
    public Map<String, Object> wsRupiah_lihatRoleKoreksi();
    public Map<String, Object> wsRupiah_simpanRoleKoreksi(String role, String rpMin, String rpMax, String petugas);
    //--- End Administrasi Role Rupiah Cicilan

    //--- Cek Role untuk Rupiah Koreksi Rekening dan Cicilan Rekening
    public Map<String, Object> wsRupiah_cekBolehKoreksiRp(Double rp, String petugas);
    public Map<String, Object> wsRupiah_cekBolehCicilanRp(Double rp, Integer kali, String petugas);
    //--- End Cek

    //--- Start Administrasi Role Pembatalan
    public Map<String, Object> wsBatal_lihatMenubatal();
    public Map<String, Object> wsBatal_lihatRolebatal();
    public Map<String, Object> wsBatal_simpanRoleBatal(String roleId, String menuId, String menuName, Integer status, String petugas);
    //--- End Administrasi Role Pembatalan


    public Map<String, Object> gantiPassword(String sUserID,
                                             String sPasswordLama,
                                             String sPasswordBaru,
                                             String sPasswordBaruKonfirm);
}
