package id.co.hans.sample.server.dao.impl;


import id.co.hans.sample.server.dao.clsJatelicon;
import id.co.hans.sample.server.dao.ws_JateliconDao;
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
public class ws_JateliconDaoImpl implements ws_JateliconDao{
    public static final Log log = LogFactory.getLog(ws_JateliconDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;
//    public Map<String, Object> HelloWorld() {
//        Map<String, Object> retValue = new HashMap<String, Object>();
//        List<Map<String,String>> lMapRecords = new ArrayList<Map<String,String>>();
//
//        try
//        {
//            Connection con = jdbcTemplate.getDataSource().getConnection();
//
//            String sql = "HelloWorld ";
//            CallableStatement cst;
//            cst = con.prepareCall(sql);
//
//            ResultSet rs = cst.executeQuery();
//
//            lMapRecords = CommonModule.convertResultsetToListStr(rs);
//
//            retValue.put("HelloWorld", lMapRecords);
//
//            con.close();
//        } catch (Exception ex)
//        {
//            ex.printStackTrace();
//        }
//        return retValue;    }

    @Override
    public Map<String, Object> getPelangganKoreksi(String sIdpel,
                                                   String sBlth,
                                                   String sKDKoreksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsJatelicon clsJathel = new clsJatelicon();
        retValue = clsJathel.getPelangganKoreksi(sIdpel, sBlth, sKDKoreksi);

        return retValue;
    }

    @Override
    public Map<String, Object> setPelangganKoreksi(List<Map<String, String>> sRsXML,
                                                   String sUserTrans,
                                                   String sKDKoreksi) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsJatelicon clsJathel = new clsJatelicon();
        retValue = clsJathel.setPelangganKoreksi(sRsXML, sUserTrans, sKDKoreksi);

        return retValue;
    }


    @Override
    public Map<String, Object> setBatalKoreksi(String sIdpel,
                                               String sBlth,
                                               String sUserKoreksi,
                                               String sTglKoreksi,
                                               String sAlasan) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsJatelicon clsJathel = new clsJatelicon();
        retValue = clsJathel.setBatalPelangganKorensi(sIdpel, sBlth, sUserKoreksi, sTglKoreksi, sAlasan);

        return retValue;
    }

    @Override
    public Map<String, Object> getInfoPelanggan(String sIdpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsJatelicon clsJathel = new clsJatelicon();
        retValue = clsJathel.getInfoPelanggan(sIdpel);

        return retValue;
    }

    @Override
    public Map<String, Object> getNotul603(String sIdpel) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsJatelicon clsJathel = new clsJatelicon();
        retValue = clsJathel.getNotul603(sIdpel);

        return retValue;
    }

    @Override
    public Map<String, Object> getPelangganLunas(String sIdpel,
                                                 String sBlth) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsJatelicon clsJathel = new clsJatelicon();
        retValue = clsJathel.getPelangganLunas(sIdpel, sBlth);

        return retValue;
    }

    @Override
    public Map<String, Object> setLunasKoreksi(String sIdpel,
                                               String sBlth,
                                               String sPetugas,
                                               String sKdpp,
                                               Double dRptag,
                                               String sTglBayar,
                                               String sWktBayar,
                                               String sUnitlunas) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsJatelicon clsJathel = new clsJatelicon();
        retValue = clsJathel.setLunasKoreksi(sIdpel, sBlth, sPetugas, sKdpp, dRptag.intValue(), sTglBayar, sWktBayar, sUnitlunas);

        return retValue;
    }

    @Override
    public Map<String, Object> getPelangganBatalLunasKoreksi(String sIdpel,
                                                             String sBlth) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsJatelicon clsJathel = new clsJatelicon();
        retValue = clsJathel.getPelangganBatalLunasKoreksi(sIdpel, sBlth);

        return retValue;
    }


    @Override
    public Map<String, Object> setBatalLunasKoreksi(String sIdpel,
                                                    String sBlth,
                                                    String sPetugasLns,
                                                    String sPetugasBatal,
                                                    String sAlasan) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsJatelicon clsJathel = new clsJatelicon();
        retValue = clsJathel.setBatalLunasKoreksi(sIdpel, sBlth, sPetugasLns, sPetugasBatal, sAlasan);

        return retValue;
    }

    @Override
    public Map<String, Object> getInfoDPPPelanggan(String sIdpel,
                                            String sBlth) {
        Map<String, Object> retValue = new HashMap<String, Object>();

        clsJatelicon clsJathel = new clsJatelicon();
        retValue = clsJathel.getInfoDPPPelanggan(sIdpel, sBlth);

        return retValue;
    }
}
