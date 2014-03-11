package id.co.hans.sample.server.dao.impl;


import id.co.hans.sample.server.dao.clsDPP;
import id.co.hans.sample.server.dao.clsPelunasan;
import id.co.hans.sample.server.dao.ws_UmumDao;
import id.co.hans.sample.server.utility.CommonModule;
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
public class ws_UmumDaoImpl implements ws_UmumDao {
    public static final Log log = LogFactory.getLog(ws_UmumDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> ambilTanggalHariIni() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select sysdate from dual";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilTanggalHariIni", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> cariUraian(Date jthtempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "cariUraian";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("cariUraian", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> cariUraianAsli(Date jthtempo) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "cariUraianAsli";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("cariUraianAsli", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> cariNoKont_dari_Nopel(String nopel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select * from dil where IDPEL = '" + nopel + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("cariUraianAsli", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> CariTerbilang(Double numerik) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "CariTerbilang";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("CariTerbilang", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> UraianKeTahunBulan(String Uraianinput) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "UraianKeTahunBulan";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("UraianKeTahunBulan", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> CariIDPELdariKONTRAK(String kont) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " select no_pelanggan from dil where no_kontrak = '" + kont + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("CariIDPELdariKONTRAK", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> CariIDPELdariKONTROL(String kont) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select no_pelanggan from dil where no_kontrol = '" + kont + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("CariIDPELdariKONTROL", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> AmbilDILPelanggan(String idpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" select ";
            sql += " NO_PELANGGAN, NO_KONTRAK, NO_KONTRAK_TETANGGA, NO_KTP, ";
            sql += " NAMA_PELANGGAN, JALAN, NAMA_JALAN, NO_BANGUNAN, KODE_BANGUNAN, ";
            sql += " RT, RW, KODEDESA, KELURAHAN_DESA, KECAMATAN, KODYA_KABUPATEN, ";
            sql += " KODE_POS, TELEPON, FAX, KODE_GOLONGAN, TARIP, TIPE_PELANGGAN, ";
            sql += " KD_PT, DAYA, KODE_KVA, KODE_RANTING, KODE_RANTING_NUMERIK, ";
            sql += " KODE_SEWA_TRAFO, KODE_GARDU, NO_TIANG, TGL_PDL, NO_PDL, TGL_NYALA, ";
            sql += " BL_TH_MUTASI_TERAKHIR, MUTASI_KOREKSI, TGL_PEREMAJAAN, ";
            sql += " JENIS_MUTASI_KOREKSI_TERAKHIR, KODE_ABUNEMEN_METER, ";
            sql += " JENIS_MUTASI_KOREKSI, STATUS, TGL_KUITANSI_UJL, TANDA_UJL, RPUJL, ";
            sql += " NO_KUITANSI_UJL, KODEPP, TGL_KUITANSI_BP, RPBP, NO_KUITANSI_BP, ";
            sql += " NO_KUITANSI_LAINNYA, NO_KUITANSI_INSTALASI, NO_KUITANSI_MATERIAL, ";
            sql += " KODEPETUGAS, PEREMAJAAN, PAKETKANTONG, PEREMAJAANBARU, ";
            sql += " COPYREK, KDREKENING, KELOMPOK_BAYAR, NO_KONTROL ";
            sql += " from DIL ";
            sql += " WHERE No_Pelanggan = '" + idpel + "'";
            sql += "";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilDILPelanggan", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> lihatNAMAPPdariKODEPP(String kodepp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" select namapp from payment_point where kodepp = '" + kodepp + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("lihatNAMAPPdariKODEPP", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> RubahTanggal(Date picker) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql ="RubahTanggal ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("RubahTanggal", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> createNoAgenda(String ikdupnumerik) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql ="createNoAgenda ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("createNoAgenda", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> cariJatuhTempo(Date tgl, String kdupnumerik) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" select tanggal from refverifikasi ";
            sql += " where tahun = '"; // + tahun + "' " ;
            sql += " and bulan = '"; // + bulan + "' " ;
            sql += " and kode_ranting_numerik = '" + kdupnumerik + "' ";
            sql += " and kategori = 'JT' ";
            sql = " select TGLJTTEMPO from SOREK ";
            sql += " where KODERANTINGNUMERIK = '"; // + kdupnumerik + "' "
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("cariJatuhTempo", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> cariJatuhTempoSiklis(String idpel, Date tgl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" select jatuhtempo from tab_jatuhtempo";
            sql = sql + " where unitup = RTRIM(LTRIM('"; // + unitup + "')) ";
            sql = sql + " and thbl = '"; // + thbl + "' " ;
            sql = sql + " and kodesiklis = '"; // + siklis + "'" ;
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("cariJatuhTempoSiklis", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilUNITUPdariIDPEL(String idpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select unitup from dil where idpel = '"; // + idpel + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilUNITUPdariIDPEL", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> ambilKODESIKLISdariIDPEL(String idpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select kelompok_bayar from dil where no_pelanggan = '"; // + idpel + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilKODESIKLISdariIDPEL", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> AmbilKodePP() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select kodepp, namapp from payment_point order by kodepp ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("AmbilKodePP", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilBulanMinusSatu(String thbl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambilBulanMinusSatu";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilBulanMinusSatu", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilBulanTambahSatu(String thbl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambilBulanTambahSatu";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilBulanTambahSatu", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> cariJatuhTempoDariBulan(String thbl, String kdupnumerik) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " select tanggal from refverifikasi ";
            sql += " where tahun = '"; // + tahun + "' " ;
            sql += " and bulan = '"; // + bulan + "' ";
            sql += " and kode_ranting_numerik = '"; // + kdupnumerik + "' " ;
            sql += " and kategori = 'JT' ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("cariJatuhTempoDariBulan", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilDataSetRANTINGRAYONsemua() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " select * from rantingrayon order by kode_ranting_numerik ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDataSetRANTINGRAYONsemua", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilDataSetRANTINGRAYONunitdefault() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " select * from rantingrayon where kode_ranting_numerik ='"; // + ambilKODEUNITdefault() + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilDataSetRANTINGRAYONunitdefault", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    //--- Parameter Euy
    @Override
    public Map<String, Object> ambilKODEUNITdefault() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " select kodeunit from unit ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilKODEUNITdefault", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilKODECABANGdefault() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " select kode_cabang_numerik from unit where kodeunit = '"; // + ambilKODEUNITdefault() + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilKODECABANGdefault", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilKODEWILAYAHdefault() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select kode_induk_numerik from cabang where kode_cabang_numerik = '"; // + ambilKODECABANGdefault() + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilKODEWILAYAHdefault", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }
    //--- End Euy

    //--- Parameter Report
    @Override
    public Map<String, Object> ambilNAMAUNITdefault() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" select UNIT from unit where kodeunit = '"; // + ambilKODEUNITdefault() + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilNAMAUNITdefault", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilNAMACABANGdefault() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" select nama_cabang from cabang where kode_cabang_numerik = '"; // + ambilKODECABANGdefault() + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilNAMACABANGdefault", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> ambilNAMAWILAYAHdefault() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" select nama_induk from induk where kode_induk_numerik = '"; // + ambilKODEWILAYAHdefault() + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilNAMAWILAYAHdefault", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilALAMATdefault() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" select alamat from rantingrayon where kode_ranting_numerik = '"; // + ambilKODEUNITdefault() + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilALAMATdefault", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }
    //--- End Report

    @Override
    public Map<String, Object> ambilTanggalDariTHBL(String thbl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" select to_date('"; // + thbl + "','yyyymm') from dual ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilTanggalDariTHBL", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilNamaUnitDariKodeUnit(String kodeunit) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" select nama as nama_ranting from unitup where unitup = RTRIM(LTRIM('"; // + kodeunit + "')) ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilNamaUnitDariKodeUnit", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    //--- Start REFERENSI
    @Override
    public Map<String, Object> ref_AmbilInduk() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" select kode_induk_numerik, nama_induk from induk order by kode_induk_numerik ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ref_AmbilInduk", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ref_AmbilCabang(String induk) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select kode_cabang_numerik, nama_cabang, kode_induk_numerik from cabang";
            sql = sql + " where kode_induk_numerik = RTRIM(LTRIM('"; // + induk + "')) order by kode_cabang_numerik ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ref_AmbilCabang", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ref_AmbilRanting(String cabang) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select kode_ranting_numerik, nama_ranting, kode_cabang_numerik from rantingrayon";
            sql = sql + " where kode_cabang_numerik = RTRIM(LTRIM('"; // + cabang + "')) order by kode_ranting_numerik ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ref_AmbilRanting", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> ref_AmbilRantingDngnSemua(String cabang) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "  select NULL as kode_ranting_numerik, ' ' as nama_ranting, null as kode_cabang_numerik from dual";
            sql = sql + " select kode_ranting_numerik, nama_ranting, kode_cabang_numerik from rantingrayon";
            sql = sql + " where kode_cabang_numerik = RTRIM(LTRIM('"; // + cabang + "')) order by kode_ranting_numerik " ;
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ref_AmbilRantingDngnSemua", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ref_AmbilPaymentPoint(String ranting) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select kodepp, namapp, kode_ranting_numerik from payment_point";
            sql = sql + " where kode_ranting_numerik = RTRIM(LTRIM('"; // + ranting + "')) order by kodepp ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ref_AmbilPaymentPoint", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ref_AmbilPetugas(String pp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" select kodepetugas, namapetugas, kodepp from petugas";
            sql = sql + " where kodepp = '"; // + pp + "' order by kodepetugas ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ref_AmbilPetugas", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilTanggalDatabase() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" select sysdate from dual ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilTanggalDatabase", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilNamaApdariUp(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" ambilNamaApdariUp ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilNamaApdariUp", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> getNamaApDariUP(String unitUP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" select nama as nama_cabang from unitap where unitap = ";
            sql = sql = " (";
            sql = sql + " select unitap from unitup ";
            sql = sql + " where unitup = RTRIM(LTRIM('"; // + unitUP + "')) ";
            sql = sql + " )";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getNamaApDariUP", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> ambilNamaKddariUp(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql ="ambilNamaKddariUp";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilNamaKddariUp", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> getNamaKdDariUP(String UnitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" select nama as nama_induk from unitupi where unitupi =";
            sql = sql + " (";
            sql = sql + " select unitupi from unitap where unitap = " ;
            sql = sql + " (";
            sql = sql + " select unitap from unitup ";
            sql = sql + " where unitup = RTRIM(LTRIM('"; // + UnitUp + "')) ";
            sql = sql + " )";
            sql = sql + " ) ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getNamaKdDariUP", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilNamaKddariAP(String unitAp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" select nama as nama_induk from unitupi ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilNamaKddariAP", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilNamaAP(String unitAp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" select nama as nama_induk from unitap where unitap = RTRIM(LTRIM('"; // + unitAp + "'))  ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilNamaAP", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilAlamatdariUp(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" ambilAlamatdariUp  ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilAlamatdariUp", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> getAlamatdariUP(String Unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" select alamat from unitup where unitup = RTRIM(LTRIM('"; // + Unitup + "')) ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getAlamatdariUP", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilIDPELfromKONTRAKKONTROLDIL(String kontrak, String kontrol) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" select idpel from dil where nopel = '"; // + kontrak + "' and ketnodlmrt = '"; // + kontrol + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilIDPELfromKONTRAKKONTROLDIL", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilUnitUPdariPetugas(String petugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =" select unitup ";
            sql += " from petugas where kodepetugas = '"; // + petugas + "' ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilUnitUPdariPetugas", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilKodePPdariUnitUP(String unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select kodepp,namapp ";
            sql += " from paymentpointbaru where unitup = RTRIM(LTRIM('"; // + unitup + "')) ";
            sql += " order by kodepp ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilKodePPdariUnitUP", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilUnitUp() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select unitup kode_ranting_numerik from unitup order by unitup ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilUnitUp", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilNamaUp(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambilNamaUp";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilNamaUp", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> getNamaUP(String UnitUP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select nama as nama_ranting from unitup where unitup = RTRIM(LTRIM('"; // + UnitUP + "')) ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getNamaUP", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    //public String getNamaUP(String UnitUP);
    @Override
    public Map<String, Object> ambilNamaPaymentPointdariKodePp(String kodepp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " select nama as nama_ranting from unitup where unitup = RTRIM(LTRIM('"; // + UnitUP + "')) ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilNamaPaymentPointdariKodePp", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> getPetugasDariTableUsers(String strData) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = " SELECT * FROM USERSBARU ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getPetugasDariTableUsers", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> getPiutangInfo(String[] clsAR) //SOPPserver_vb.clsReturnValue
    {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "";
            String msql;
            String err = "";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getPiutangInfo", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> getPelunasanIndividu(String JENPIUTANG, String[] clsAR) //SOPPserver_vb.clsReturnValue
    {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "";
            String msql;
            String err = "";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getPelunasanIndividu", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> Inform(String idpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SELECT TGLBAYAR,kdpp,blth ,kdpembpp,idpel,KDGERAKKELUAR FROM DPP partition(lunas) WHERE IDPEL = '"; // + idpel + "'";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("Inform", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> dsOracle(String mSql, String dsName) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "dsOracle";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("dsOracle", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> cariPelIndividu(clsPelunasan clsPel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "cariPelIndividu";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("cariPelIndividu", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> carMasterPelangganIndividu(clsPelunasan clsPel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "carMasterPelangganIndividu";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("carMasterPelangganIndividu", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> getDil(clsDPP clsdpp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SELECT IDPEL,NOPEL,NAMA,NVL(NAMAPNJ,' ') as NAMAPNJ,TARIP,DAYA FROM dil ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getDil", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> getDPPIndividu(clsDPP clsdpp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  "";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getDPPIndividu", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> ConnOracle() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  "ConnOracle";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ConnOracle", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> caridilinfo(clsPelunasan clsPel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  "caridilinfo";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("caridilinfo", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> carDPPInfo(clsPelunasan clsPel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  "carDPPInfo";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("carDPPInfo", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> getDPPinfo(clsDPP clsdpp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  "SELECT *  ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getDPPinfo", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> getDilinfo(clsDPP clsdpp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  "SELECT IDPEL,NOPEL,NAMA,NVL(NAMAPNJ,' ') as NAMAPNJ,TARIP,DAYA FROM dil ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getDilinfo", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilKodesiklis(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " SELECT DISTINCT kodesiklis FROM tab_jatuhtempo WHERE unitup = '"; // + unitUp + "' ";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilKodesiklis", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> ambilPejabatID01(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " select namaJabatan,namaPejabat from view_pejabat ";
            sql += " where unitup = '" + unitUp + "' and idPejabat = '01' ";
            sql += " and statusAktif = 1 and skfromdate <= sysdate and skenddate >= sysdate ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilPejabatID01", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public  Map<String, Object> ambilPejabatID02(String unitUp) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " select namaJabatan,namaPejabat from view_pejabat ";
            sql += " where unitup = '"; // + unitUp + "' and idPejabat = '02' ";
            sql += " and statusAktif = 1 and skfromdate <= sysdate and skenddate >= sysdate ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilPejabatID02", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> cetakInfo(String Idpel, String BlnAwal, String BlnAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " select idpel, nama, namapnj as alamat, ' ' NO_TIANG, ' ' KODE_GARDU, slalwbp,sahlwbp,substr(tgljttempo,7,2) || '/' || substr(tgljttempo,5,2) || '/' || substr(tgljttempo,1,4) as tgljttempo, ";
            String Sql = " kogol, tarip, daya, substr(tglbayar,7,2) || '-' || substr(tglbayar,5,2) || '-' || substr(tglbayar,1,4) as tglbayar,";
            Sql += " blth, kdpembayar as petugas, sum(kwhlwbp) as kwhlwbp, sum(kwhwbp) as kwhwbp, ";
            Sql += " sum(blok3+kwhkvarh) as kwhblok3, sum(pemkwh+kwhkvarh) as totalkwh, FAKM,FAKMKVARH,sum(rplwbp) as rplwbp, sum(rpwbp) as rpwbp, ";
            Sql += " sum(rpblok3) as rpblok3, sum(rpkvarh) as rpkvarh, sum(rpbeban) as rpbeban, sum(rpppn) as rpppn, sum(rpbpju) as rpbpju, ";
            Sql += " sum(rptrafo) as rptrafo, sum(rpmat) as rpmat, sum(rpangsa+rpangsb+rpangsc) as rpangs,";
            Sql += " sum(rpreduksi) as rpreduksi, sum(rpttlb) as rpttlb, sum(nvl(rptag,0)+nvl(rpbk1,0)+nvl(rpbk2,0)+nvl(rpbk3,0)) as rptag, sum(rpbk1+rpbk2+rpbk3) as rpbk, kdpp, kddk ";
            Sql += " from dpp where idpel = '"; // + Idpel + "' and blth >= '" + BlnAwal + "' and blth <= '" + BlnAkhir + "'";
            Sql += " group by idpel, nama, namapnj, slalwbp,sahlwbp,FAKM,FAKMKVARH, tgljttempo, kogol, tarip, daya, tglbayar, blth, kdpembayar, kdpp, kddk order by blth desc";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("cetakInfo", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> cetakInvoice(String Idpel, String BlnAwal, String BlnAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " select * from view_info_cetak_invoice";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("cetakInvoice", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> getMasterKolektif() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  "SELECT * FROM view_master_kolektif";

            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getMasterKolektif", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> LihatHistoTrans(String Idpel, String BLTH) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql =  " select b.nama,b.namapnj,a.idpel,a.blth,a.tglbayar,a.wktbayar,a.kdpp,a.rptag,a.rpbk,a.keterangan,a.kdkirim,a.kdgerakmasuk,a.kdgerakkeluar,a.tglupdate,a.updateby ";
            String Sql = " from view_info_histotrans a,dil b where a.idpel=b.idpel ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("LihatHistoTrans", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }
}
