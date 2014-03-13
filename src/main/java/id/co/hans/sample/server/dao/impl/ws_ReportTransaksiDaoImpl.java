package id.co.hans.sample.server.dao.impl;


import id.co.hans.sample.server.dao.ws_ReportTransaksiDao;
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
public class ws_ReportTransaksiDaoImpl implements ws_ReportTransaksiDao{
    public static final Log log = LogFactory.getLog(ws_ReportTransaksiDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> ref_AmbilInduk() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ref_AmbilInduk ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ref_AmbilInduk", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ref_AmbilCabang(String induk) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ref_AmbilCabang ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ref_AmbilCabang", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ref_AmbilRanting(String cabang) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ref_AmbilRanting ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ref_AmbilRanting", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetReport_41rekap(String vJenis,
                                                 String tBLTH,
                                                 String tparAp,
                                                 String tparUp,
                                                 String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_41rekap ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_41rekap", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> GetReport_32rekap(String vJenis,
                                                 String tBLTH,
                                                 String tparUp,
                                                 String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_32rekap ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_32rekap", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetReport_23notarekap(String vJenis,
                                                     String tBLTH,
                                                     String tparAp,
                                                     String tparUp,
                                                     String tPetugas,
                                                     String tanggal,
                                                     String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_23notarekap ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_23notarekap", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetReport_24notarekap(String vJenis,
                                                     String tBLTH,
                                                     String tparUPI,
                                                     String tparAp,
                                                     String tparUp,
                                                     String tPetugas,
                                                     String tanggal,
                                                     String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_24notarekap ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_24notarekap", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    //---tgl 26 jan 07 00.00.00
    @Override
    public Map<String, Object> Get_KODEPP(String unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "Get_KODEPP ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("Get_KODEPP", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetViewKODEKOLEKTIF23NOTA() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetViewKODEKOLEKTIF23NOTA ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetViewKODEKOLEKTIF23NOTA", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> GetViewKODEsiklisUNIT(String tTHBL,
                                                     String tUNIT) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetViewKODEsiklisUNIT ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetViewKODEsiklisUNIT", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetViewKODEsiklisUNITWithSemua(String tTHBL,
                                                              String tUNIT) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetViewKODEsiklisUNITWithSemua ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetViewKODEsiklisUNITWithSemua", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetReport_21rekap(String vJenis,
                                                 String tBLTH,
                                                 String tparUp,
                                                 String tPetugas,
                                                 String tanggal,
                                                 String tanggalend,
                                                 String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_21rekap ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_21rekap", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetReport_21_BA(String vJenis,
                                               String tBLTH,
                                               String tparUp,
                                               String tPetugas,
                                               String tanggal,
                                               String tanggalend,
                                               String kode,
                                               String pengelola) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_21_BA ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_21_BA", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetReport_21kdpp(String vJenis,
                                                String tBLTH,
                                                String tparUp,
                                                String tPetugas,
                                                String tanggal,
                                                String tanggalend,
                                                String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_21kdpp ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_21kdpp", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetReport_21upload(String vJenis,
                                                  String tBLTH,
                                                  String tparUp,
                                                  String tPetugas,
                                                  String tanggal,
                                                  String tanggalend,
                                                  String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_21upload ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_21upload", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetReport_31rekap(String vJenis,
                                                 String tBLTH,
                                                 String tparAp,
                                                 String tparUp,
                                                 String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_31rekap ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_31rekap", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetReport_22kdpp(String vJenis,
                                                String tBLTH,
                                                String tparUp,
                                                String tPetugas,
                                                String tanggal,
                                                String tanggalend,
                                                String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_22kdpp ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_22kdpp", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetReport_22kdpp_v2(String vJenis,
                                                   String tBLTH,
                                                   String tanggal,
                                                   String tanggalend,
                                                   String tparup,
                                                   String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_22kdpp_v2 ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_22kdpp_v2", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetReport_22kdpp_v3(String vJenis,
                                                   String tBLTH,
                                                   String tanggal,
                                                   String tanggalend,
                                                   String tparup,
                                                   String tparap,
                                                   String tparupi,
                                                   String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_22kdpp_v3 ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_22kdpp_v3", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetReport_22rekap(String vJenis,
                                                 String tBLTH,
                                                 String tparUp,
                                                 String tPetugas,
                                                 String tanggal,
                                                 String tanggalend,
                                                 String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_22rekap ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_22rekap", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetReport_22rekap_V2(String vJenis,
                                                    String tBLTH,
                                                    String tparUp,
                                                    String tPetugas,
                                                    String tanggal,
                                                    String tanggalend,
                                                    String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_22rekap_V2 ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_22rekap_V2", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetReport_22rekap_V3(String vJenis,
                                                    String tBLTH,
                                                    String tparUp,
                                                    String tparAp,
                                                    String tparUpi,
                                                    String tPetugas,
                                                    String tanggal,
                                                    String tanggalend,
                                                    String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_22rekap_V3 ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_22rekap_V3", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetReport_22rekap_ap(String vJenis,
                                                    String tBLTH,
                                                    String tparUp,
                                                    String tPetugas,
                                                    String tanggal,
                                                    String tanggalend,
                                                    String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_22rekap_ap ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_22rekap_ap", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetReport_13rekap(String vJenis,
                                                 String tBLTH,
                                                 String tparAp,
                                                 String tparUp,
                                                 String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_13rekap ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_13rekap", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetReport_12rekap(String vJenis,
                                                 String tBLTH,
                                                 String tparUp,
                                                 String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_12rekap ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_12rekap", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetReport_12RekapGabungan(String vJenis,
                                                         String tBLTH,
                                                         String tparUp,
                                                         String tPetugas,
                                                         String tParAP,
                                                         String in_unitupi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_12RekapGabungan ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_12RekapGabungan", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetReport_12jnskoreksi(String vJenis,
                                                      String tBLTH,
                                                      String tparUp,
                                                      String tPetugas,
                                                      String kdKoreksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_12jnskoreksi ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_12jnskoreksi", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }



    @Override
    public Map<String, Object> GetReport_12Jenis(String vJenis,
                                                 String tBLTH,
                                                 String tparUp,
                                                 String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_12Jenis ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_12Jenis", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetReport_11rekap(String vJenis,
                                                 String tBLTH,
                                                 String tparUp,
                                                 String tPetugas,
                                                 String kode,
                                                 String tparAp,
                                                 String in_unitupi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_11rekap ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_11rekap", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;
    }

    //---tambahan BK
    @Override
    public Map<String, Object> GetReport_BK_212223rekap(String vJenis,
                                                        String tBLTH,
                                                        String tparUp,
                                                        String tPetugas,
                                                        String kode) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_BK_212223rekap ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_BK_212223rekap", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }
    //---end BK

    //------------------------------
    @Override
    public Map<String, Object> GetReport_23dltrekap(String vJenis,
                                                    String tBLTH,
                                                    String tparAp,
                                                    String tparUp,
                                                    String tPetugas,
                                                    String tanggal,
                                                    String kode,
                                                    String tparUPI) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_23dltrekap ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_23dltrekap", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetViewKODEKOLEKTIF23NOTATERPUSAT() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetViewKODEKOLEKTIF23NOTATERPUSAT ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetViewKODEKOLEKTIF23NOTATERPUSAT", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    //--- Laporan Kolektif
    @Override
    public Map<String, Object> GetReport_21Giral_Kode(String tBLTH,
                                                      String tPetugas,
                                                      String kode,
                                                      String jenis) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_21Giral_Kode ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_21Giral_Kode", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> GetReport_23Nota_Kode(String tBLTH,
                                                     String tPetugas,
                                                     String kode,
                                                     String jenis,
                                                     Integer tBebanKantor) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_23Nota_Kode ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_23Nota_Kode", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetReport_23Terpusat_Kode(String tBLTH,
                                                         String tPetugas,
                                                         String kode,
                                                         String jenis) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_23Terpusat_Kode ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_23Terpusat_Kode", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    //--- Cicilan Rekening
    @Override
    public Map<String, Object> GetReport_Cilrek_Jurnal(String tKode,
                                                       String tThbl,
                                                       String tParUp,
                                                       String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_Cilrek_Jurnal ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_Cilrek_Jurnal", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> GetReport_Cilrek_Daftar(String tKode,
                                                       String tThbl,
                                                       String tParUp,
                                                       String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_Cilrek_Daftar ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_Cilrek_Daftar", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> GetReport_Cilrek_Idpel(String tIdpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_Cilrek_Idpel ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_Cilrek_Idpel", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    //----End cicilan rekening

    //----REPORT KIRIM UNIT
    @Override
    public Map<String, Object> GetReport_23Kirim_Rekap(String tThbl,
                                                       String tParUp,
                                                       String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_23Kirim_Rekap ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_23Kirim_Rekap", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> GetReport_23Kirim_Daftar(String tThbl,
                                                        String tParUp,
                                                        String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_23Kirim_Daftar ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_23Kirim_Daftar", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }
    //---END REPORT KIRIM UNIT

    //---REPORT TERIMA UNIT
    @Override
    public Map<String, Object> GetReport_23Terima_Rekap(String tThbl,
                                                        String tParUp,
                                                        String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_23Terima_Rekap ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_23Terima_Rekap", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> GetReport_23Terima_Daftar(String tThbl,
                                                         String tParUp,
                                                         String tPetugas) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_23Terima_Daftar ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_23Terima_Daftar", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }
    //---END REPORT TERIMA UNIT

    @Override
    public Map<String, Object> getLaporan309(String jenis,
                                             String tparUP,
                                             String tParAP,
                                             String blth) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "getLaporan309 ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getLaporan309", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> getLaporan309perUnit(String jenis,
                                                    String tParUnit,
                                                    String blth) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "getLaporan309perUnit ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getLaporan309perUnit", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> setLaporan309(String jenis,
                                             String tparUP,
                                             String tParAP,
                                             String blth,
                                             String transaksiby) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "setLaporan309 ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("setLaporan309", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> GetReport_22rekap_Global(String vJenis,
                                                        String vFilterUnit,
                                                        String tparUpi,
                                                        String tparAp,
                                                        String tparUp,
                                                        String tanggal,
                                                        String tanggalend) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_22rekap_Global ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_22rekap_Global", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> GetReport_2122DoubleBayar(String sUnit,
                                                  String sBlnBayar,
                                                  String sKogol) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_2122DoubleBayar ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_2122DoubleBayar", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetReport_2122DoubleBayarNew(String sUnit,
                                                     String sBlnBayar) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_2122DoubleBayarNew ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_2122DoubleBayarNew", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ref_AmbilPetugas(String kodePP) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ref_AmbilPetugas ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ref_AmbilPetugas", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetReport_21petugas(String vJenis,
                                                   String tBLTH,
                                                   String tparUp,
                                                   String tPetugas,
                                                   String tanggal,
                                                   String tanggalend,
                                                   String kode,
                                                   String kdPembayar) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_21petugas ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_21petugas", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetReport_22petugas(String vJenis,
                                                   String tBLTH,
                                                   String tparUp,
                                                   String tPetugas,
                                                   String tanggal,
                                                   String tanggalend,
                                                   String kode,
                                                   String kdPembayar,
                                                   String sATM) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_22petugas ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_22petugas", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetReport_22petugasDaya(String vJenis,
                                                       String tBLTH,
                                                       String tparUp,
                                                       String tPetugas,
                                                       String tanggal,
                                                       String tanggalend,
                                                       String kode,
                                                       String kdPembayar,
                                                       String sATM,
                                                       String vDayaAwal,
                                                       String vDayaAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_22petugasDaya ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_22petugasDaya", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetReport_Pemda(String tparAP,
                                               String tparUp,
                                               String tBLTH,
                                               String vJenis,
                                               String tPetugas,
                                               String in_unitupi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport_Pemda ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport_Pemda", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> cetak_rekap11TglUpload(String Unitup,
                                                      String TglMulai,
                                                      String TglAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "cetak_rekap11TglUpload ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("cetak_rekap11TglUpload", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> getMonitoringSorekDJBB(String vUNITAP,
                                               String vTGLKIRIM) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "getMonitoringSorekDJBB ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getMonitoringSorekDJBB", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> getMonitoringLapSaldoTunggakan(String in_jenis,
                                                       String in_Unitupi,
                                                       String in_Unitap,
                                                       String in_Unitup) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "getMonitoringLapSaldoTunggakan ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getMonitoringLapSaldoTunggakan", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetTunggakanPemda(String in_unitupi,
                                          String in_unitap,
                                          String in_unitup,
                                          String in_blth,
                                          String in_jenis) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetTunggakanPemda ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetTunggakanPemda", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetReportRestitusi(String in_unitap,
                                           String in_unitup,
                                           String in_blth,
                                           String in_jenis) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReportRestitusi ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReportRestitusi", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilLaporan508(String vNoForm,
                                               String thbl,
                                               String CekSatker) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambilLaporan508 ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilLaporan508", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> ambilLaporan509(String vIDKotama,
                                               String thbl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambilLaporan509 ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilLaporan509", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> ambilLaporan509Rekap(String vIDKotama,
                                                    String thbl) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ambilLaporan509Rekap ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ambilLaporan509Rekap", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> GetReport21Restitusi(String in_unitupi,
                                             String in_unitap,
                                             String in_unitup,
                                             String in_blth,
                                             String in_jenis) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "GetReport21Restitusi ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("GetReport21Restitusi", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }
}
