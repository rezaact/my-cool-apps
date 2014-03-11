package id.co.hans.sample.server.dao.impl;


import id.co.hans.sample.server.dao.ws_MonitoringDao;
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
public class ws_MonitoringDaoImpl implements ws_MonitoringDao {
    public static final Log log = LogFactory.getLog(ws_MonitoringDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> HelloWorld() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        retValue.put("wsReturn", "Hello World");
        return retValue;
    }


    @Override
    public Map<String, Object> getMonitoringKirimTerima(String unitkrm, String unittrm, String dtBln, String tglAwal, String tglAkhir) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();



        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "MonitoringKirimTerima ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("MonitoringKirimTerima", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> getPemantauanJurnal(String vJenis, String tUnitUP, String tUnitAP, String tTglmulai, String tTglsampai, Map<String, Object> dsFilter) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "getPemantauanJurnal ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("getPemantauanJurnal", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> getPemantauanJurnal(String vJenis, String tUnitUP, String tUnitAP, String tTglmulai, String tTglsampai) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "PemantauanJurnal ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("PemantauanJurnal", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> Set_ApprovalERP() {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "ApprovalERP ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("ApprovalERP", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }


    @Override
    public Map<String, Object> getCube_MonitoringAnja(Map<String, Object> dtFilter) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "MonitoringAnja ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("MonitoringAnja", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> getCubeDetil_MonitoringAnja(Map<String, Object> dsfilter) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "CubeDetil_MonitoringAnja ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("CubeDetil_MonitoringAnja", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> getCube_MonitoringDPH(Map<String, Object> dtFilter) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "Cube_MonitoringDPH ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("Cube_MonitoringDPH", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }


    @Override
    public Map<String, Object> getCubeDetil_MonitoringDPH(Map<String, Object> dsfilter) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "CubeDetil_MonitoringDPH ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("CubeDetil_MonitoringDPH", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> getCube_MonitoringSaldo(Map<String, Object> dtFilter) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "Cube_MonitoringSaldo ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("Cube_MonitoringSaldo", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> getCubeDetil_MonitoringSaldo(Map<String, Object> dsfilter) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "CubeDetil_MonitoringSaldo ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("CubeDetil_MonitoringSaldo", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }

    @Override
    public Map<String, Object> getCube_MonitoringSorek(Map<String, Object> dtFilter) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "Cube_MonitoringSorek ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("Cube_MonitoringSorek", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;     }

    @Override
    public Map<String, Object> getCubeDetil_MonitoringSorek(Map<String, Object> dsfilter) {
        Map<String, Object> retValue = new HashMap<String, Object>();
        List<Map<String,String>> lMapPetugas = new ArrayList<Map<String,String>>();

        try
        {
            Connection con = jdbcTemplate.getDataSource().getConnection();

            String sql = "CubeDetil_MonitoringSorek ";
            CallableStatement cst;
            cst = con.prepareCall(sql);

            ResultSet rs = cst.executeQuery();

            lMapPetugas = CommonModule.convertResultsetToListStr(rs);

            retValue.put("CubeDetil_MonitoringSorek", lMapPetugas);

            con.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return retValue;    }
}
