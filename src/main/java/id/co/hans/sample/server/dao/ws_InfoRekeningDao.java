package id.co.hans.sample.server.dao;

import java.util.Map;

public interface ws_InfoRekeningDao {
    public Map<String, Object> ambilDilWhere(String sqlWhere);
     
    // #Region "view info"
    public Map<String, Object> getPiutangInfo(String[] clsAR, String strXMLschema);
    // #End Region
    
    public Map<String, Object> cariIdPelDIL(String idpel);
    public Map<String, Object> cariIdPelDIS(String idpel);
    public Map<String, Object> ambilDil(String idpel);
    public Map<String, Object> ambilDis1(String idpel);
    public Map<String, Object> ambilDis2(String idpel);
    public Map<String, Object> ambilDis3(String idpel);
    public Map<String, Object> ambilDis4(String idpel);
    public Map<String, Object> ambilDis5(String idpel, String bulanrek, String kdgerak);
    public Map<String, Object> ambilDis6(String idpel, String bulanrek, String kdgerak);
    public Map<String, Object> ambilDildata(String idpel, String thbl);
    public Map<String, Object> ambilInfo(String idpel, String blnawal, String blnakhir);
    public Map<String, Object> ambilTunggakan(String idpel);
}
