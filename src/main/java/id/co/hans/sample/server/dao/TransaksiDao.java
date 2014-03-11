package id.co.hans.sample.server.dao;

import java.util.Map;

public interface TransaksiDao {
    // 
    // dimasukkan ke dalam parameter balikan function

    public Map<String, Object> parameterViewOracle(String pName, String pView);
    public Map<String, Object> parameterViewSorek(String pName, String pView);
    public Map<String, Object> parameterViewSorekNew(String pName, String pView, String pPackage);
    public Map<String, Object> getIdpel(String vJenis, String tPEL);

    // ------ tambahan sumbar oratoora
    public Map<String, Object> getView_SorekOraToOra(String unitAp, String unitUp, String  thbl, String KdKelompok, String strGlobalKodePetugas);
    public Map<String, Object> getView_SorekOraToOraNew(String unitAp, String unitUp, String thbl, String KdKelompok, String strGlobalKodePetugas, String pPackage);
    public Map<String, Object> getView_SusulanOraToOra(String unitAp, String unitUp, String thbl, String KdKelompok, String strGlobalKodePetugas);
    // ------ end tambahan sumbar oratoora

    public Map<String, Object> getViewIdpel_21entri(String tpel, String vJenis, String tBLTH, String tPetugas);

    // Download 21 by range tanggal dan unitup
    public Map<String, Object> getView21(String unitUp, String tglAwal, String tglAkhir);
    public Map<String, Object> setKdGerak(String vKdGerak);
    public Map<String, Object> getViewIdpel_21Suplisi(String tpel, String blth, String tglKoreksi, String tPetugas);
    public Map<String, Object> getViewIdpel_21HapusGagal(String tpel, String vJenis, String tBLTH, String tPetugas, String tglBayar, String tKodePp);
    public Map<String, Object> getViewIdpel_PembatalanDenda(String tpel, String vJenis, String tBLTH, String tPetugas);


    public Map<String, Object> getViewIdpel_31Suplisi(String tpel, String vJenis, String tBLTH, String tPetugas);
    public Map<String, Object> getViewIdpel_41DUPR(String tpel, String vJenis, String tBLTH, String tPetugas);

    public Map<String, Object> getViewIdpel_32DUPP(String tpel, String vJenis, String tBLTH, String tPetugas);

    public Map<String, Object> getViewIdpel_41(String tpel, String vJenis, String tBLTH, String tPetugas);
    public Map<String, Object> getViewIdpel_32(String tpel, String vJenis, String tBLTH, String tPetugas);

    // strXMLschema sebagai parameter balikan function
    public Map<String, Object> getViewIdpel_32dupp(String tKodeKolektif, String tBLTH, String tPetugas);
    public Map<String, Object> getViewIdpel_41dupr(String tKodeKolektif, String tBLTH, String tPetugas);


    public Map<String, Object> GetViewKolektif_23NOTA(String tkodekolektif, String tBLTH, String tPetugas);


    public Map<String, Object> GetViewKolektif_21Giralisasi(String tkodekolektif, String tBLTH, String tPetugas);
    public Map<String, Object> GetViewKolektif_23Pusat(String tkodekolektif, String tBLTH, String tPetugas);
    public Map<String, Object> GetViewIdPel_23KIRIMUNIT(String tpel, String vJenis, String tBLTH, String tPetugas);
    public Map<String, Object> GetViewIdPel_23KIRIMUNITKolektif(String kodekolektif, String vJenis, String tBLTH, String tPetugas);
    public Map<String, Object> SaveTemp_23KIRIMUNIT(String tPetugas, String tUnitKirim, String tTglKirim);
    public Map<String, Object> SaveTemp_23KIRIMUNIT(String tPetugas, String tUnitKirim, String sTransID, String tTglKirim);

    public Map<String, Object> GetViewIdPel_23TERIMAUNIT(String tpel, String vJenis, String tBLTH, String tPetugas, String tKdTerima);
    public Map<String, Object> GetViewIdPel_12ABC(String tpel, String vJenis, String tBLTH, String tPetugas);
    public Map<String, Object> GetViewIdPel_12ABCORATOORA(String tpel, String vJenis, String tBLTH, String tPetugas, Boolean oratoora, String kdkrs);
    public Map<String, Object> GetViewIdPel_12DE(String tpel, String vJenis, String tBLTH, String tPetugas);
    
    public Map<String, Object> GetViewIdPel_12D(String tpel, String vJenis, String tBLTH, String tPetugas);
    public Map<String, Object> GetViewIdPel_13LAMA(String tpel, String vJenis, String tBLTH, String tPetugas);
    public Map<String, Object> GetViewIdPel_13BARU(String tpel, String vJenis, String tBLTH, String tPetugas);
    public Map<String, Object> ambilTanggalHariIni();
    public Map<String, Object> GetViewALASANHAPUSBK(String vJenis, String tPetugas);
    public Map<String, Object> GetViewKODEPP(String vJenis, String parUp);
    public Map<String, Object> GetViewKODEKOLEKTIF21GIRALISASI();

    public Map<String, Object> GetViewKODEKOLEKTIF21GIRALISASI(String tUnitup);
    public Map<String, Object> GetViewKODEKOLEKTIF23PUSAT();
    public Map<String, Object> GetViewKODEKOLEKTIF23PUSAT(String tUnitup);
    public Map<String, Object> GetViewKODEKOLEKTIF23NOTA();

    public Map<String, Object> GetViewKODEKOLEKTIF23NOTA(String tUnitup, Integer iBebanKantor);
    public Map<String, Object> GetViewKODEKELOMPOK(String tTHBL, String tPetugas);
    public Map<String, Object> GetViewKODEKELOMPOKUNIT(String tTHBL, String tUNIT);
    public Map<String, Object> GetViewKODEKELOMPOKBYSIKLIS(String tTHBL, String tSIKLIS);
    public Map<String, Object> GetViewKODERR(String tUNIT);
    public Map<String, Object> GetTempSorek();
    public Map<String, Object> GetViewKODEKOREKSI();

    public Map<String, Object> GetTempDKRP();
    public Map<String, Object> GetViewIdPel_R2cicilan(String tpel, String vJenis, String tBLTH, String tPetugas);
    public Map<String, Object> getViewDppNonrek(String unitup, String sTglMulai, String sTglSelesai);

    public Map<String, Object> getViewDphNonrek(String unitup, String sTglMulai, String sTglSelesai);


//    'public Map<String, Object> GetViewIdPel_R2cicilan(String tpel, String vJenis, String tBLTH, String tPetugas);
//            '    Dim mSQL  = ""
//            '    mSQL = "SELECT BLTH, IDPEL, NOPEL, KDGERAKMASUK, UPLOADTIME, UPLOADBY, KDGERAKKELUAR, TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKOREKSI, TGKOREKSI, STATUS, KDPEMBPP, KDPEMBAYARSIP3, UNITUP, PEMDA, NAMA, PNJ, NAMAPNJ, NOBANG, KETNOBANG, RT, RW, NODLMRT, KETNODLMRT, LINGKUNGAN, KODEPOS, IDTARIP, TARIP, KDPEMBTRF, ABONMETER, DAYA, KDAYA, KOGOL, SUBKOGOL, FRT, FJN, KDPPJ, UNITKJ, KDINKASO, KDKELOMPOK, TGLJTTEMPO, KDDK, TGLBACA, SLALWBP, SAHLWBP, SLAWBP, SAHWBP, SLAKVARH, SAHKVARH, SKVAMAX, FAKM, FAKMKVARH, FAKMKVAMAX, KWHLWBP, KWHWBP, BLOK3, PEMKWH, KWHKVARH, KELBKVARH, RPLWBP, RPWBP, RPBLOK3, RPKVARH, RPBEBAN, CTTLB, RPTTLB, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, KDANGSA, RPANGSA, KDANGSB, RPANGSB, KDANGSC, RPANGSC, RPMAT, RPPLN, RPTAG, RPPRODUKSI, RPSUBSIDI, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, RPTDLLAMA, RPTDLBARU, RPSELISIH, NOREK, NOAGENDA, FLAGSOPP, FLAGANJA, KDKIRIM, KDTERIMA, TGLKONSLD, KONSLDKE, UPDATEBY, UPDATETIME "
//            '    mSQL = mSQL & " FROM VIEW_R2CICILAN_TAMPILFORM order by IDPEL,blth desc"
//            '    Dim ds As New DataSet
//            '    tpel = GetIdpel(vJenis, tpel, Err)
//            '    If Err <> "" Then Return Nothing
//            '    If parameterviewOracle(Err, "IDPEL", tpel) = False Then Return Nothing
//            '    If parameterviewOracle(Err, "BLTH", tBLTH) = False Then Return Nothing
//            '    If parameterviewOracle(Err, "PETUGAS", tPetugas) = False Then Return Nothing
//
//            '    ds = dsOracle(Err, mSQL, "dpp")
//            '    If Err <> "" Then Return Nothing
//            '    If ds.Tables(0).Rows.Count > 0 Then
//            '        Return ds
//            '    Else
//            '        Err = "Piutang tidak ditemukan."
//            '        Return Nothing
//            '    End If
//            'End Function

    public Map<String, Object> getDataHapusKolektif(Map<String, String> dsFilter);
    public Map<String, Object> getview212223Down(String TglMulai, String TglSampai, String Unitup, String sView);

    public Map<String, Object> GetParamDownload(String NmTabel);
    public Map<String, Object> GetDowndLunasBlmLunas(String TglMulai, String TglSampai, String Unitup, String Command, String THBLREP, String KDKIRIM);

    public Map<String, Object> GetBKxml(String vIDpel);
    public Map<String, Object> GetTunggakan(String vIDpel);
    public Map<String, Object> GetInfoPlgXML(String tIDpel, String tBLTH);
    public Map<String, Object> getMonitoringStatusPending(String unitup);
    public Map<String, Object> getMonitoringUploadSorek(String unit, String blth, String satuan);
    public Map<String, Object> GetViewIdPel_21entriRestitusi(String tpel, String vJenis);
    public Map<String, Object> getTingkatSatker();
    public Map<String, Object> GetKotama(String vUnitap);
    public Map<String, Object> getSatker(String vUnitap, String vIDKotama);
    public Map<String, Object> getdataSatker(String vIDSatker);
    public Map<String, Object> getdataKotama(String vIDKotama);
    public Map<String, Object> GetNoForm(String vUnitap);
    public Map<String, Object> getAnggotaSatket(String vNoForm);
    public Map<String, Object> getDataPelanggan(String vIdpel);
    public Map<String, Object> cekSatker(String vNoForm, String vBlth);
    public Map<String, Object> GetDataKoreksiBongkar(String vIdpel);
    public Map<String, Object> GetLogDKRPBongkar(String _strtgl, String _noTulAwal, String _noTulAkhir, String _unitup, String _LogID, String _Jenis);
}
