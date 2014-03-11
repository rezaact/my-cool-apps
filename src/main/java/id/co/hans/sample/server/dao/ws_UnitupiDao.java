package id.co.hans.sample.server.dao;

import java.util.Map;

public interface ws_UnitupiDao {
    public Map<String, Object> GetUNITUPI();
    public String InsertUNITUPI(clsUNITUPI UNITUPI);
    public String UpdateUNITUPI(clsUNITUPI UNITUPI);
    public String DeleteUNITUPI(clsUNITUPI UNITUPI);
}
