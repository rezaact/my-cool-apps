package id.co.hans.sample.client.helper;

import com.google.gwt.http.client.UrlBuilder;

/**
 * Kelas Helper Untuk membentuk url yang mengarah kepada WS TRANSAKSI Restful Service
 * 
 * @author yudhi karunia surtan
 * 
 */
public class WsTransaksiUrlHelper {

  private static final String WS_TRANSAKSI_PREFIX = "Ws_Transaksi/";
  private static final String TANGGAL_HARI_INI = WS_TRANSAKSI_PREFIX + "ambilTanggalHariIni.json";
  private static final String MASTER_UNIT = WS_TRANSAKSI_PREFIX + "getMasterUnit.json";
  private static final String MONITORING_UPLOAD_SOREK = WS_TRANSAKSI_PREFIX
      + "getMonitoringUploadSorek.json";
  private static final String DATA_KOLEKTIF_GIRALISASI = WS_TRANSAKSI_PREFIX
      + "GetDataKolektifGiralisasi.json";

  public String getDataKolektifGiralisasiURL() {
    UrlBuilder builder = new UrlBuilder();
    builder.setPath(DATA_KOLEKTIF_GIRALISASI);
    return builder.toString();
  }

  public String getMasterUnit(String unitPetugas) {
    UrlBuilder builder = new UrlBuilder();
    builder.setPath(MASTER_UNIT);
    builder.setParameter("in_unitpetugas", unitPetugas);
    return builder.toString();
  }

  public String getMonitoringUploadSorekURL(String unit, String blth, String satuan) {
    UrlBuilder builder = new UrlBuilder();
    builder.setPath(MONITORING_UPLOAD_SOREK);
    builder.setParameter("unit", unit);
    builder.setParameter("blth", blth);
    builder.setParameter("satuan", satuan);
    return builder.toString();
  }

  public String getTanggalHariIniURL() {
    UrlBuilder builder = new UrlBuilder();
    builder.setPath(TANGGAL_HARI_INI);
    return builder.toString();
  }
}
