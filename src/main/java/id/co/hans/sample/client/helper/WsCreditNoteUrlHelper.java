package id.co.hans.sample.client.helper;

import com.google.gwt.http.client.UrlBuilder;
import com.google.gwt.json.client.JSONObject;

public class WsCreditNoteUrlHelper {
  private static final String WS_CREDIT_NOTE_PREFIX = "Ws_CreditNote/";
  private static final String NAMA_BANK_URL = WS_CREDIT_NOTE_PREFIX + "ambilNamaBank.json";
  private static final String DATA_CN_URL = WS_CREDIT_NOTE_PREFIX + "ambilDataCN.json";
  private static final String SIMPAN_DATA_CN_URL = WS_CREDIT_NOTE_PREFIX + "simpanDataCN.json";

  public static String simpanDataCN(JSONObject ds, Boolean bEdit) {
    UrlBuilder builder = new UrlBuilder();
    builder.setPath(SIMPAN_DATA_CN_URL);
    builder.setParameter("ds", ds.toString());
    builder.setParameter("bEdit", bEdit.toString());
    return builder.toString();
  }
}
