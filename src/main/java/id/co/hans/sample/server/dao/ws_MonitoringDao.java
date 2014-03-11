package id.co.hans.sample.server.dao;

import java.util.Map;

public interface ws_MonitoringDao {
    public Map<String, Object> HelloWorld();

    public Map<String, Object> getMonitoringKirimTerima(String unitkrm,
                                                        String unittrm,
                                                        String dtBln,
                                                        String tglAwal,
                                                        String tglAkhir);
    public Map<String, Object> getPemantauanJurnal(String vJenis,
                                                   String tUnitUP,
                                                   String tUnitAP,
                                                   String tTglmulai,
                                                   String tTglsampai,
                                                   Map<String, Object> dsFilter);
    public Map<String, Object> Set_ApprovalERP();
    public Map<String, Object> getCube_MonitoringAnja(Map<String, Object> dtFilter);
    public Map<String, Object> getCubeDetil_MonitoringAnja(Map<String, Object> dsfilter);
    public Map<String, Object> getCube_MonitoringDPH(Map<String, Object> dtFilter);
    public Map<String, Object> getCubeDetil_MonitoringDPH(Map<String, Object> dsfilter);
    public Map<String, Object> getCube_MonitoringSaldo(Map<String, Object> dtFilter);
    public Map<String, Object> getCubeDetil_MonitoringSaldo(Map<String, Object> dsfilter);
    public Map<String, Object> getCube_MonitoringSorek(Map<String, Object> dtFilter);
    public Map<String, Object> getCubeDetil_MonitoringSorek(Map<String, Object> dsfilter);

    public Map<String, Object> getPemantauanJurnal(String vJenis,
                                                   String tUnitUP,
                                                   String tUnitAP,
                                                   String tTglmulai,
                                                   String tTglsampai);
}
