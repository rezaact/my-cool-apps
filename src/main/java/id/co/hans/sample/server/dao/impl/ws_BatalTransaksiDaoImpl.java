package id.co.hans.sample.server.dao.impl;


import id.co.hans.sample.server.dao.ws_BatalTransaksiDao;
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
public class ws_BatalTransaksiDaoImpl implements ws_BatalTransaksiDao{
    public static final Log log = LogFactory.getLog(ws_BatalTransaksiDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> HelloWorld() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "HelloWorld ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("HelloWorld", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> BatalTransaksi_idpel(String Transaksi,
                                                    String tpel,
                                                    String vJenis,
                                                    String tKode,
                                                    String tPetugas,
                                                    String tblthbuku) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "BatalTransaksi_idpel ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("BatalTransaksi_idpel", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
   public Map<String, Object> SetDataIdpelBatal_11(Map<String, Object> dtrans,
                                             String tTransaksiBy,
                                             String tAlasan,
                                             String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SetDataIdpelBatal_11 ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetDataIdpelBatal_11", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> SetDataIdpelBatal_12ABCG(Map<String, Object> dtrans,
                                                        String tTransaksiBy,
                                                        String tAlasan,
                                                        String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SetDataIdpelBatal_12ABCG ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetDataIdpelBatal_12ABCG", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> SetDataIdpelBatal_12DSuplisi(Map<String, Object> dtrans,
                                                            String tTransaksiBy,
                                                            String tAlasan,
                                                            String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SetDataIdpelBatal_12DSuplisi ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetDataIdpelBatal_12DSuplisi", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> SetDataIdpelBatal_12DRestitusi(Map<String, Object> dtrans,
                                                              String tTransaksiBy,
                                                              String tAlasan,
                                                              String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SetDataIdpelBatal_12DRestitusi ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetDataIdpelBatal_12DRestitusi", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> SetDataIdpelBatal_13(Map<String, Object> dtrans,
                                                    String tTransaksiBy,
                                                    String tAlasan,
                                                    String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SetDataIdpelBatal_13 ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetDataIdpelBatal_13", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> SetDataIdpelBatal_21(Map<String, Object> dtrans,
                                                    String tTransaksiBy,
                                                    String tAlasan,
                                                    String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SetDataIdpelBatal_21 ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetDataIdpelBatal_21", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> SetDataIdpelBatal_21Suplisi(Map<String, Object> dtrans,
                                                           String tTransaksiBy,
                                                           String tAlasan,
                                                           String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SetDataIdpelBatal_21Suplisi ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetDataIdpelBatal_21Suplisi", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> SetDataIdpelBatal_23NOTA(Map<String, Object> dtrans,
                                                        String tTransaksiBy,
                                                        String tAlasan,
                                                        String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SetDataIdpelBatal_23NOTA ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetDataIdpelBatal_23NOTA", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> SetDataIdpelBatal_23DLT(Map<String, Object> dtrans,
                                                       String tTransaksiBy,
                                                       String tAlasan,
                                                       String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SetDataIdpelBatal_23DLT ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetDataIdpelBatal_23DLT", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> SetDataIdpelBatal_31(Map<String, Object> dtrans,
                                                    String tTransaksiBy,
                                                    String tAlasan,
                                                    String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SetDataIdpelBatal_31 ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetDataIdpelBatal_31", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> SetDataIdpelBatal_41(Map<String, Object> dtrans,
                                                    String tTransaksiBy,
                                                    String tAlasan,
                                                    String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SetDataIdpelBatal_41 ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetDataIdpelBatal_41", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> SetDataIdpelBatal_32(Map<String, Object> dtrans,
                                                    String tTransaksiBy,
                                                    String tAlasan,
                                                    String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SetDataIdpelBatal_32 ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetDataIdpelBatal_32", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> SetDataIdpelBatal_23Kirim(Map<String, Object> dtrans,
                                                         String tTransaksiBy,
                                                         String tAlasan,
                                                         String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SetDataIdpelBatal_23Kirim ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetDataIdpelBatal_23Kirim", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> SetDataIdpelBatal_23Terima(Map<String, Object> dtrans,
                                                          String tTransaksiBy,
                                                          String tAlasan,
                                                          String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SetDataIdpelBatal_23Terima ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetDataIdpelBatal_23Terima", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> SetDataIdpelBatal_CicilRek(Map<String, Object> dtrans,
                                                          String tTransaksiBy,
                                                          String tAlasan,
                                                          String tglTransaksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "SetDataIdpelBatal_CicilRek ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetDataIdpelBatal_CicilRek", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> SetDataIdpelBatal_23NOTA_Each(String _inTransaksiBy,
                                                             String _inIdpel,
                                                             String _inKdPembPP,
                                                             String _inKdGerakKeluar,
                                                             String _inBlth,
                                                             String _inStatus,
                                                             String _inNorek,
                                                             String _inAlasan,
                                                             String _inTglBayar,
                                                             String _inTransaksiId) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapRecords = CommonModule.convertResultsetToListStr(rs);

            retValue.put("SetDataIdpelBatal_23NOTA_Each", lMapRecords);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }
}
