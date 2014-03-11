package id.co.hans.sample.server.dao;

import java.util.Date;
import java.util.Map;

public interface ws_ReportBADao {
    public Map<String, Object> ambilUnitPetugas( String petugas);
    public Map<String, Object> rptVIEW_BA21_Upload( String unitup, String tgltransaksi, String tglbayar, String kdpp, String transaksiby);

    public Map<String, Object> rptVIEW_BA21_Entri( String unitup, String tgltransaksi, String tglbayar, String kdpp, String transaksiby);
    public Map<String, Object> rptVIEW_BA21Daftar_Entri( String unitup, String tgltransaksi, String tglbayar, String kdpp, String transaksiby);
    public Map<String, Object> rptVIEW_BADENDA( String unitup, String tgltransaksi, String transaksiby);
    public Map<String, Object> rptVIEW_BA11( String unitUp, String siklis, String blth, Date tempo);

    // ----tambahan sumbar sorek oratoora
    public Map<String, Object> rptVIEW_BA13upload( String unitUp, String siklis, String blth, Date tempo);
    // ----end tambahan sumbar sorek oratoora

    // TAMBAHAN CICILAN REKENING
    public Map<String, Object> rpt_BA_CicilanRek( String petugas, String idpel, String blth);
    // END TAMBAHAN CICILAN REKENING

    //======BA KIRIM UNIT--
    public Map<String, Object> rpt_BA_23KirimUnit( String tPetugas, String tUnitKirim, String tTglKirim);
    //======END BA KIRIM UNIT

    //=== BA TERIMA UNIT ===
    public Map<String, Object> rpt_BA_23TerimaUnit( String tPetugas, String tUnitKirim, String tTglKirim);
    //=== END BA TERIMA UNIT

    //BA Koreksi Rekening
    public Map<String, Object> rpt_BA_12KoreksiRekening( String tIDPEL, String tBLTH);
    public Map<String, Object> rpt_BA23Pusat_Daftar( String tglBayar, String petugas, String kode, String kdkirim);
    //Kuitansi Resup
    public Map<String, Object> rpt_Kuitansi_RESUP( String tIDPEL);
}
