package id.co.hans.sample.server.dao;

import java.util.Date;

public class cls_view_report_dphoffline {
    private Date tglserverdb;
    //    'pak aditia ini setoran yang sudah di tuning, kayaknya sudah cepat .....

    public cls_view_report_dphoffline(Date TglServer) {
        tglserverdb = TglServer;
    }

//  #Region "clsReport_Transaksi.vb"
//  '=========================================================================
//  'Public=========================================================================
    public String GetReport_21rekap(String vJenis,
                                    String tBLTH,
                                    String tparUp,
                                    String tPetugas,
                                    String tanggal,
                                    String tanggalend,
                                    String kode) {
        String mSQL = "";

        if (vJenis.toUpperCase() == "21UNIT_PP" ) {
            mSQL = GetReport_21rekap_21UNIT_PP();
        } else if ( vJenis.toLowerCase() == "21unit_mypp" ) {
//        'mSQL = GetReport_21rekap_21unit_mypp(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode)
            mSQL = GetReport_21rekap_21unit_mypp();

        } else if ( vJenis.toLowerCase() == "21unit_pptglrekap" ) {
            mSQL = GetReport_21rekap_21unit_pptglrekap(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode);

        } else if ( vJenis.toLowerCase() == "21unit_mypptglrekap" ) {
            mSQL = GetReport_21rekap_21unit_mypptglrekap(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode);
        }

        if (vJenis.toUpperCase() == "21UNIT_502" ) {
            mSQL = GetReport_21rekap_21UNIT_502();

        } else if ( vJenis.toUpperCase() == "21UNIT_502B" ) {
            mSQL = GetReport_21rekap_21UNIT_502b();

        } else if ( vJenis.toLowerCase() == "21unit_my502" ) {
//        ' mSQL = GetReport_21rekap_21unit_my502(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode)
            mSQL = GetReport_21rekap_21unit_my502();

        } else if ( vJenis.toLowerCase() == "21unit_kirimunit" ) {
    //    'mSQL = GetReport_21rekap_21unit_kirimunit(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode)
            mSQL = GetReport_21rekap_21unit_kirimunit();

        } else if ( vJenis.toLowerCase() == "21unit_kirim502" ) {
    //    'mSQL = GetReport_21rekap_21unit_kirim502(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode)
            mSQL = GetReport_21rekap_21unit_kirim502();
        } else if ( vJenis.toLowerCase() == "21unit_kirimunittglrekap" ) {
                mSQL = GetReport_21rekap_21unit_kirimunittglrekap(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode);

        } else if ( vJenis.toLowerCase() == "21unit_terimaunit" ) {
    //    'mSQL = GetReport_21rekap_21unit_terimaunit(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode)
            mSQL = GetReport_21rekap_21unit_terimaunit();

        } else if ( vJenis.toLowerCase() == "21unit_terima502" ) {
    //    'mSQL = GetReport_21rekap_21unit_terima502(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode)
            mSQL = GetReport_21rekap_21unit_terima502();
        } else if ( vJenis.toLowerCase() == "21unit_terimaunittglrekap" ) {
            mSQL = GetReport_21rekap_21unit_terimaunittglrekap(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode);
        }

        if ( vJenis.toUpperCase() == "21UNIT_404" ) {
            mSQL = GetReport_21rekap_21UNIT_404_TRANS(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode);

        } else if ( vJenis.toLowerCase() == "21unit_my404" ) {
    //    'mSQL = GetReport_21rekap_21unit_my404(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode)
            mSQL = GetReport_21rekap_21unit_my404();

        } else if ( vJenis.toLowerCase() == "21unit_kirim404" ) {
    //    'mSQL = GetReport_21rekap_21unit_kirim404(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode)
            mSQL = GetReport_21rekap_21unit_kirim404();

        } else if ( vJenis.toLowerCase() == "21unit_terima404" ) {
    //    'mSQL = GetReport_21rekap_21unit_terima404(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode)
            mSQL = GetReport_21rekap_21unit_terima404();
        }

        if ( vJenis.toLowerCase() == "21unit_pptgldaftar" ) {
            mSQL = GetReport_21rekap_21unit_pptgldaftar(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode);

        } else if ( vJenis.toLowerCase() == "21unit_mypptgldaftar" ) {
            mSQL = GetReport_21rekap_21unit_mypptgldaftar(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode);

        } else if ( vJenis.toLowerCase() == "21unit_kirimunittgldaftar" ) {
            mSQL = GetReport_21rekap_21unit_kirimunittgldaftar(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode);

        } else if ( vJenis.toLowerCase() == "21unit_terimaunittgldaftar" ) {
            mSQL = GetReport_21rekap_21unit_terimaunittgldaftar(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode);
        }

        return mSQL;
    }
    //Region "21UNIT_PP"
    public String GetReport_21rekap_21UNIT_PP(String vJenis,
                                              String tBLTH,
                                              String tparUp,
                                              String tPetugas,
                                              String tanggal,
                                              String tanggalend,
                                              String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);

//        ' FROM VIEW_REPORT_21UNITPP
//        'bulan
        mSQL = "SELECT SYSDATE AS TGLCETAK, TGLBUKU as TANGGAL, KOGOL, SUM(LEMBAR) AS LEMBAR, ";
        mSQL = mSQL + " SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, ";
        mSQL = mSQL + " SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, ";
        mSQL = mSQL + " SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, ";
        mSQL = mSQL + " SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, ";
        mSQL = mSQL + " SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, ";
        mSQL = mSQL + " SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3, ";
        mSQL = mSQL + " KDGERAK,KDPEMBPP,STATUS, UNITUP, UNITUPKDPP, KDPP,JALANTUNGGAK ";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
//        'untuk bulan ambil dari rekaptransaksi
        mSQL = mSQL + " SELECT  ";
        mSQL = mSQL + " TGLBUKU, KOGOL, ";
        mSQL = mSQL + " SUM(LEMBAR) AS LEMBAR,   SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL,   SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,   SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,   SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,   SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI,   SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,   SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
        mSQL = mSQL + " KDGERAK,KDPEMBPP,STATUS, UNITUP, UNITUPKDPP, KDPP, JALANTUNGGAK ";
        mSQL = mSQL + " FROM ( ";

        String tindex = "/*+index(rekapDPHOFFLINEkdpp idx_rekap21kdpp_tglbuku, idx_rekap21kdpp_unitup)*/";
        String tpartisi = "";
        String twhere = "";

        twhere = twhere + " WHERE ";
        twhere = twhere + " UNITUP  = '" + tparUp.trim() + "'";
        twhere = twhere + " AND TGLBUKU  >= '" + tBLTH + "01" + "'";
        twhere = twhere + " AND TGLBUKU  <= '" + tBLTH + "31" + "'";
        twhere = twhere + " AND kdpembpp = 'R1'";
        twhere = twhere + " and KDGERAK = '21' ";
        mSQL = mSQL + getReport_21rekap_VIEW_REPORT_21UNITPP(tindex, tpartisi, twhere);
        mSQL = mSQL + " ) ";
        mSQL = mSQL + " GROUP BY UNITUP,TGLBUKU,KDPEMBPP,KOGOL,STATUS,UNITUPKDPP,KDGERAK, KDPP,JALANTUNGGAK";
//        'untuk hari ini ambil dari tabel transaksi
        mSQL = mSQL + " union all ";
        mSQL = mSQL + " select /*+index(a idx_dphoffline_unitup) (a idx_dphoffline_tgltransaksi)*/ ";
        mSQL = mSQL + " tglbayar AS TGLBUKU,  KOGOL,";
        mSQL = mSQL + " COUNT(idpel) AS LEMBAR,   SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL,   SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,   SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,   SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,   SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI,   SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,   SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
        mSQL = mSQL + " kdgerakkeluar AS KDGERAK,KDPEMBPP as KDPEMBPP,STATUS,   UNITUP , NVL(UNITLUNAS,UNITUP) AS UNITUPKDPP, KDPP,";
        mSQL = mSQL + " decode(substr(tglbayar,1,6),a.blth,'BERJALAN','TUNGGAKAN') AS JALANTUNGGAK  ";
        mSQL = mSQL + " FROM DPHOFFLINE partition(" + partisi + ") a";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUP  = '" + tparUp.trim() + "'";
        mSQL = mSQL + " AND (tgltransaksi >= trunc(sysdate) ";
        mSQL = mSQL + "      and tgltransaksi < (trunc(sysdate) + 1)) ";
        mSQL = mSQL + " AND TGLBATALTRANS IS NULL";
        mSQL = mSQL + " AND kdpembpp = 'R1'";
        mSQL = mSQL + " AND (KODEGAGAL = '0' OR KODEGAGAL IS NULL)";
        mSQL = mSQL + " and kdgerakkeluar = '21' ";
        mSQL = mSQL + " GROUP BY UNITUP,tglbayar,KDPEMBPP,KOGOL,STATUS,UNITLUNAS,kdgerakkeluar, KDPP,decode(substr(tglbayar,1,6),a.blth,'BERJALAN','TUNGGAKAN')";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " Group by TGLBUKU, KOGOL,KDGERAK,KDPEMBPP,STATUS, UNITUP, UNITUPKDPP, KDPP,JALANTUNGGAK ";
        mSQL = mSQL + " order by KDPP asc,TGLBUKU asc";

        return mSQL;
    }

    public String GetReport_21rekap_21UNIT_PP() {
        String mSQL = "";
//        ' FROM VIEW_REPORT_21UNITPP
        mSQL = "SELECT * FROM B$_RPT_21UNITPP";
        return mSQL;
    }

    public String GetReport_21rekap_21unit_mypp(String vJenis,
                                                String tBLTH,
                                                String tparUp,
                                                String tPetugas,
                                                String tanggal,
                                                String tanggalend,
                                                String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);

//        'bulan
        mSQL = "SELECT SYSDATE AS TGLCETAK, TGLBUKU as TANGGAL, KOGOL, SUM(LEMBAR) AS LEMBAR, ";
        mSQL = mSQL + " SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, ";
        mSQL = mSQL + " SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, ";
        mSQL = mSQL + " SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, ";
        mSQL = mSQL + " SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, ";
        mSQL = mSQL + " SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, ";
        mSQL = mSQL + " SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3, ";
        mSQL = mSQL + " KDGERAK,KDPEMBPP,STATUS, UNITUP, UNITUPKDPP, KDPP ";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
//        'untuk bulan ambil dari rekaptransaksi
        mSQL = mSQL + " SELECT  TGLBUKU, KOGOL, ";
        mSQL = mSQL + " SUM(LEMBAR) AS LEMBAR,   SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL,   SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,   SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,   SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,   SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI,   SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,   SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
        mSQL = mSQL + " KDGERAK,KDPEMBPP,STATUS, UNITUP, UNITUPKDPP, KDPP ";
        mSQL = mSQL + " FROM ( ";

        String tindex = "/*+index(rekapDPHOFFLINEkdpp idx_rekap21kdpp_tglbuku, idx_rekap21kdpp_unitup)*/";
        String tpartisi = "";
        String twhere = "";

        twhere = twhere + " WHERE ";
        twhere = twhere + " UNITUP  = '" + tparUp.trim() + "'";
        twhere = twhere + " AND TGLBUKU  >= '" + tBLTH + "01" + "'";
        twhere = twhere + " AND TGLBUKU  <= '" + tBLTH + "31" + "'";
        twhere = twhere + " AND kdpembpp = 'R1'";
        twhere = twhere + " and KDGERAK = '21' ";
        mSQL = mSQL + getReport_21rekap_VIEW_REPORT_21UNITPP(tindex, tpartisi, twhere);
        mSQL = mSQL + " ) ";
        mSQL = mSQL + " GROUP BY UNITUP,TGLBUKU,KDPEMBPP,KOGOL,STATUS,UNITUPKDPP,KDGERAK, KDPP";
//        'untuk hari ini ambil dari tabel transaksi
        mSQL = mSQL + " union all ";
        mSQL = mSQL + " select /*+index(a idx_dphoffline_unitup) (a idx_dphoffline_tgltransaksi)*/ ";
        mSQL = mSQL + " tglbayar AS TGLBUKU,  KOGOL,";
        mSQL = mSQL + " COUNT(idpel) AS LEMBAR,   SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL,   SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,   SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,   SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,   SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI,   SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,   SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
        mSQL = mSQL + " kdgerakkeluar AS KDGERAK,KDPEMBPP as KDPEMBPP,STATUS,   UNITUP , NVL(UNITLUNAS,UNITUP) AS UNITUPKDPP, KDPP";
        mSQL = mSQL + " FROM DPHOFFLINE partition(" + partisi + ") a";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUP  = '" + tparUp.trim() + "'";
        mSQL = mSQL + " AND (tgltransaksi >= trunc(sysdate) ";
        mSQL = mSQL + "      and tgltransaksi < (trunc(sysdate) + 1)) ";
        mSQL = mSQL + " AND TGLBATALTRANS IS NULL";
        mSQL = mSQL + " AND kdpembpp = 'R1'";
        mSQL = mSQL + " AND (KODEGAGAL = '0' OR KODEGAGAL IS NULL)";
        mSQL = mSQL + " and kdgerakkeluar = '21' ";
        mSQL = mSQL + " GROUP BY UNITUP,tglbayar,KDPEMBPP,KOGOL,STATUS,UNITLUNAS,kdgerakkeluar, KDPP";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUPKDPP  = Rtrim()(Ltrim()('" + tparUp + "'))";
        mSQL = mSQL + " Group by TGLBUKU, KOGOL,KDGERAK,KDPEMBPP,STATUS, UNITUP, UNITUPKDPP, KDPP ";
        mSQL = mSQL + " order by KDPP asc,TGLBUKU asc";
        return mSQL;
    }

    public String GetReport_21rekap_21unit_mypp() {
        String mSQL = " SELECT * FROM B$_RPT_21UNIT_MYPP";
        return mSQL;
    }

    public String GetReport_21rekap_21unit_pptglrekap(String vJenis,
                                                      String tBLTH,
                                                      String tparUp,
                                                      String tPetugas,
                                                      String tanggal,
                                                      String tanggalend,
                                                      String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);

//        'tanggal sum
        mSQL = "SELECT SYSDATE AS TGLCETAK, TGLBUKU as TANGGAL, KOGOL, SUM(LEMBAR) AS LEMBAR, ";
        mSQL = mSQL + " SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, ";
        mSQL = mSQL + " SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, ";
        mSQL = mSQL + " SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, ";
        mSQL = mSQL + " SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, ";
        mSQL = mSQL + " SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, ";
        mSQL = mSQL + " SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3, ";
        mSQL = mSQL + " KDGERAK,KDPEMBPP,STATUS, UNITUP, UNITUPKDPP, KDPP ";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
        mSQL = mSQL + " select /*+index(a idx_dphoffline_02)*/ ";
        mSQL = mSQL + " tglbayar AS TGLBUKU,  KOGOL,";
        mSQL = mSQL + " COUNT(idpel) AS LEMBAR,   SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL,   SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,   SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,   SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,   SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI,   SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,   SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
        mSQL = mSQL + " kdgerakkeluar AS KDGERAK,KDPEMBPP as KDPEMBPP,STATUS,   UNITUP , NVL(UNITLUNAS,UNITUP) AS UNITUPKDPP, KDPP";
        mSQL = mSQL + " FROM DPHOFFLINE partition(" + partisi + ") a";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUP  = '" + tparUp.trim() + "'";
        mSQL = mSQL + " AND tglbayar  >= '" + tBLTH + tanggal + "'";
        mSQL = mSQL + " AND tglbayar  <= '" + tBLTH + tanggalend + "'";
        mSQL = mSQL + " AND KDPP  = '" + kode + "'";
        mSQL = mSQL + " AND TGLBATALTRANS IS NULL";
        mSQL = mSQL + " AND kdpembpp = 'R1'";
        mSQL = mSQL + " AND (KODEGAGAL = '0' OR KODEGAGAL IS NULL)";
        mSQL = mSQL + " and kdgerakkeluar = '21' ";
        mSQL = mSQL + " GROUP BY UNITUP,tglbayar,KDPEMBPP,KOGOL,STATUS,UNITLUNAS,kdgerakkeluar, KDPP";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " Group by TGLBUKU, KOGOL,KDGERAK,KDPEMBPP,STATUS, UNITUP, UNITUPKDPP, KDPP ";
        mSQL = mSQL + " order by TGLBUKU asc";

        return mSQL;
    }

    public String GetReport_21rekap_21unit_mypptglrekap(String vJenis,
                                                        String tBLTH,
                                                        String tparUp,
                                                        String tPetugas,
                                                        String tanggal,
                                                        String tanggalend,
                                                        String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);
//        'tanggal sum
        mSQL = "SELECT SYSDATE AS TGLCETAK, TGLBUKU as TANGGAL, KOGOL, SUM(LEMBAR) AS LEMBAR, ";
        mSQL = mSQL + " SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, ";
        mSQL = mSQL + " SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, ";
        mSQL = mSQL + " SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, ";
        mSQL = mSQL + " SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, ";
        mSQL = mSQL + " SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, ";
        mSQL = mSQL + " SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3, ";
        mSQL = mSQL + " KDGERAK,KDPEMBPP,STATUS, UNITUP, UNITUPKDPP, KDPP ";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
        mSQL = mSQL + " select /*+index(a idx_dphoffline_02)*/ ";
        mSQL = mSQL + " tglbayar AS TGLBUKU,  KOGOL,";
        mSQL = mSQL + " COUNT(idpel) AS LEMBAR,   SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL,   SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,   SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,   SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,   SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI,   SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,   SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
        mSQL = mSQL + " kdgerakkeluar AS KDGERAK,KDPEMBPP as KDPEMBPP,STATUS,   UNITUP , NVL(UNITLUNAS,UNITUP) AS UNITUPKDPP, KDPP";
        mSQL = mSQL + " FROM DPHOFFLINE partition(" + partisi + ") a";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUP  = '" + tparUp.trim() + "'";
        mSQL = mSQL + " AND tglbayar  >= '" + tBLTH + tanggal + "'";
        mSQL = mSQL + " AND tglbayar  <= '" + tBLTH + tanggalend + "'";
        mSQL = mSQL + " AND KDPP  = '" + kode + "'";
        mSQL = mSQL + " AND TGLBATALTRANS IS NULL";
        mSQL = mSQL + " AND kdpembpp = 'R1'";
        mSQL = mSQL + " AND (KODEGAGAL = '0' OR KODEGAGAL IS NULL)";
        mSQL = mSQL + " and kdgerakkeluar = '21' ";
        mSQL = mSQL + " and UNITLUNAS  = '" + tparUp.trim() + "'";
        mSQL = mSQL + " GROUP BY UNITUP,tglbayar,KDPEMBPP,KOGOL,STATUS,UNITLUNAS,kdgerakkeluar, KDPP";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " Group by TGLBUKU, KOGOL,KDGERAK,KDPEMBPP,STATUS, UNITUP, UNITUPKDPP, KDPP ";
        mSQL = mSQL + " order by TGLBUKU asc";
        
        return mSQL;
    }
    //End Region
    
    
    //Region "21UNIT_502"
    public String GetReport_21rekap_21UNIT_502(String vJenis,
                                               String tBLTH,
                                               String tparUp,
                                               String tPetugas,
                                               String tanggal,
                                               String tanggalend,
                                               String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);

//        'FROM VIEW_REPORT_21UNIT502
//        'bulan
        mSQL = "SELECT SYSDATE AS TGLCETAK, TGLBUKU as TANGGAL, KOGOL, SUM(LEMBAR) AS LEMBAR, ";
        mSQL = mSQL + " SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, ";
        mSQL = mSQL + " SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, ";
        mSQL = mSQL + " SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, ";
        mSQL = mSQL + " SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, ";
        mSQL = mSQL + " SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, ";
        mSQL = mSQL + " SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3, ";
        mSQL = mSQL + " KDGERAK,KDPEMBPP,STATUS, UNITUP ";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
//        'untuk bulan ambil dari rekaptransaksi
        mSQL = mSQL + " SELECT  TGLBUKU, KOGOL, ";
        mSQL = mSQL + " SUM(LEMBAR) AS LEMBAR,   SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL,   SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,   SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,   SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,   SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI,   SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,   SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
        mSQL = mSQL + " KDGERAK,KDPEMBPP,STATUS, UNITUP, UNITUPKDPP ";
        mSQL = mSQL + " FROM ( ";
        String tindex = "/*+index(rekapDPHOFFLINEkdpp idx_rekap21kdpp_tglbuku, idx_rekap21kdpp_unitup)*/";
        String tpartisi  = "";
        String twhere  = "";
        twhere = twhere + " WHERE ";
        twhere = twhere + " UNITUP  = '" + tparUp.trim() + "'";
        twhere = twhere + " AND TGLBUKU  >= '" + tBLTH + "01" + "'";
        twhere = twhere + " AND TGLBUKU  <= '" + tBLTH + "31" + "'";
        twhere = twhere + " AND kdpembpp = 'R1'";
        twhere = twhere + " and KDGERAK = '21' ";
        mSQL = mSQL + getReport_21rekap_VIEW_REPORT_21UNIT502(tindex, tpartisi, twhere);
        mSQL = mSQL + " ) ";
        mSQL = mSQL + " GROUP BY UNITUP,TGLBUKU,KDPEMBPP,KOGOL,STATUS,UNITUPKDPP,KDGERAK";
//        'untuk hari ini ambil dari tabel transaksi
        mSQL = mSQL + " union all ";
        mSQL = mSQL + " select /*+index(a idx_dphoffline_unitup) (a idx_dphoffline_tgltransaksi)*/ ";
        mSQL = mSQL + " tglbayar AS TGLBUKU,  KOGOL,";
        mSQL = mSQL + " COUNT(idpel) AS LEMBAR,   SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL,   SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,   SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,   SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,   SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI,   SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,   SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
        mSQL = mSQL + " kdgerakkeluar AS KDGERAK,KDPEMBPP as KDPEMBPP,STATUS,   UNITUP , NVL(UNITLUNAS,UNITUP) AS UNITUPKDPP ";
        mSQL = mSQL + " FROM DPHOFFLINE partition(" + partisi + ") a";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUP  = '" + tparUp.trim() + "'";
        mSQL = mSQL + " AND (tgltransaksi >= trunc(sysdate) ";
        mSQL = mSQL + "      and tgltransaksi < (trunc(sysdate) + 1)) ";
        mSQL = mSQL + " AND TGLBATALTRANS IS NULL";
        mSQL = mSQL + " AND kdpembpp = 'R1'";
        mSQL = mSQL + " AND (KODEGAGAL = '0' OR KODEGAGAL IS NULL)";
        mSQL = mSQL + " and kdgerakkeluar = '21' ";
        mSQL = mSQL + " GROUP BY UNITUP,tglbayar,KDPEMBPP,KOGOL,STATUS,UNITLUNAS,kdgerakkeluar";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " Group by TGLBUKU, KOGOL,KDGERAK,KDPEMBPP,STATUS, UNITUP";
        mSQL = mSQL + " order by TGLBUKU asc";

        return mSQL;
    }

    public String GetReport_21rekap_21UNIT_502() {
        String mSQL = "";
        mSQL = "SELECT * FROM B$_RPT_21UNIT502 " ;
        return mSQL;
    }

    public String GetReport_21rekap_21UNIT_502b() {
        String mSQL = "";
        mSQL = "SELECT * FROM B$_RPT_21UNIT502B ";
        return mSQL;
    }

    public String GetReport_21rekap_21unit_my502(String vJenis,
                                             String tBLTH,
                                             String tparUp,
                                             String tPetugas,
                                             String tanggal,
                                             String tanggalend,
                                             String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);

//        'FROM VIEW_REPORT_21UNIT502
//        'bulan
        mSQL = "SELECT SYSDATE AS TGLCETAK, TGLBUKU as TANGGAL, KOGOL, SUM(LEMBAR) AS LEMBAR, ";
        mSQL = mSQL + " SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, ";
        mSQL = mSQL + " SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, ";
        mSQL = mSQL + " SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, ";
        mSQL = mSQL + " SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, ";
        mSQL = mSQL + " SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, ";
        mSQL = mSQL + " SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3, ";
        mSQL = mSQL + " KDGERAK,KDPEMBPP,STATUS, UNITUP ";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
//        'untuk bulan ambil dari rekaptransaksi
        mSQL = mSQL + " SELECT  TGLBUKU, KOGOL, ";
        mSQL = mSQL + " SUM(LEMBAR) AS LEMBAR,   SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL,   SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,   SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,   SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,   SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI,   SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,   SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
        mSQL = mSQL + " KDGERAK,KDPEMBPP,STATUS, UNITUP, UNITUPKDPP ";
        mSQL = mSQL + " FROM ( ";
        String tindex = "/*+index(rekapDPHOFFLINEkdpp idx_rekap21kdpp_tglbuku, idx_rekap21kdpp_unitup)*/";
        String tpartisi = "";
        String twhere = "";
        twhere = twhere + " WHERE ";
        twhere = twhere + " UNITUP  = '" + tparUp.trim() + "'";
        twhere = twhere + " AND TGLBUKU  >= '" + tBLTH + "01" + "'";
        twhere = twhere + " AND TGLBUKU  <= '" + tBLTH + "31" + "'";
        twhere = twhere + " AND kdpembpp = 'R1'";
        twhere = twhere + " and KDGERAK = '21' ";
        mSQL = mSQL + getReport_21rekap_VIEW_REPORT_21UNIT502(tindex, tpartisi, twhere);
        mSQL = mSQL + " ) ";
        mSQL = mSQL + " GROUP BY UNITUP,TGLBUKU,KDPEMBPP,KOGOL,STATUS,UNITUPKDPP,KDGERAK";
//        'untuk hari ini ambil dari tabel transaksi
        mSQL = mSQL + " union all ";
        mSQL = mSQL + " select /*+index(a idx_dphoffline_unitup) (a idx_dphoffline_tgltransaksi)*/ ";
        mSQL = mSQL + " tglbayar AS TGLBUKU,  KOGOL,";
        mSQL = mSQL + " COUNT(idpel) AS LEMBAR,   SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL,   SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,   SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,   SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,   SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI,   SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,   SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
        mSQL = mSQL + " kdgerakkeluar AS KDGERAK,KDPEMBPP as KDPEMBPP,STATUS,   UNITUP , NVL(UNITLUNAS,UNITUP) AS UNITUPKDPP ";
        mSQL = mSQL + " FROM DPHOFFLINE partition(" + partisi + ") a";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUP  = '" + tparUp.trim() + "'";
        mSQL = mSQL + " AND (tgltransaksi >= trunc(sysdate) ";
        mSQL = mSQL + "      and tgltransaksi < (trunc(sysdate) + 1)) ";
        mSQL = mSQL + " AND TGLBATALTRANS IS NULL";
        mSQL = mSQL + " AND kdpembpp = 'R1'";
        mSQL = mSQL + " AND (KODEGAGAL = '0' OR KODEGAGAL IS NULL)";
        mSQL = mSQL + " and kdgerakkeluar = '21' ";
        mSQL = mSQL + " GROUP BY UNITUP,tglbayar,KDPEMBPP,KOGOL,STATUS,UNITLUNAS,kdgerakkeluar";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUPKDPP  = Rtrim()(Ltrim()('" + tparUp + "'))";
        mSQL = mSQL + " Group by TGLBUKU, KOGOL,KDGERAK,KDPEMBPP,STATUS, UNITUP";
        mSQL = mSQL + " order by TGLBUKU asc";
        
        return mSQL;
    }

    public String GetReport_21rekap_21unit_my502() {
        String mSQL = "SELECT * FROM B$_RPT_21UNIT_MY502";
        return mSQL;
    }
    
    public String GetReport_21rekap_21unit_kirimunit(String vJenis,
                                                     String tBLTH,
                                                     String tparUp,
                                                     String tPetugas,
                                                     String tanggal,
                                                     String tanggalend,
                                                     String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);
//        'bulan
        mSQL = "SELECT SYSDATE AS TGLCETAK, TGLBUKU as TANGGAL, KOGOL, SUM(LEMBAR) AS LEMBAR, ";
        mSQL = mSQL + " SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, ";
        mSQL = mSQL + " SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, ";
        mSQL = mSQL + " SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, ";
        mSQL = mSQL + " SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, ";
        mSQL = mSQL + " SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, ";
        mSQL = mSQL + " SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3, ";
        mSQL = mSQL + " KDGERAK,KDPEMBPP,STATUS, UNITUP , UNITUPKDPP ";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
//        'untuk bulan ambil dari rekaptransaksi
        mSQL = mSQL + " SELECT  TGLBUKU, KOGOL, ";
        mSQL = mSQL + " SUM(LEMBAR) AS LEMBAR,   SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL,   SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,   SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,   SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,   SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI,   SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,   SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
        mSQL = mSQL + " KDGERAK,KDPEMBPP,STATUS, UNITUP, UNITUPKDPP ";
        mSQL = mSQL + " FROM ( ";
        String tindex = "/*+index(rekapDPHOFFLINEkdpp idx_rekap21kdpp_tglbuku, idx_rekap21kdpp_unitup)*/";
        String tpartisi = "";
        String twhere = "";
        twhere = twhere + " WHERE ";
        twhere = twhere + " UNITUP  = '" + tparUp.trim() + "'";
        twhere = twhere + " AND TGLBUKU  >= '" + tBLTH + "01" + "'";
        twhere = twhere + " AND TGLBUKU  <= '" + tBLTH + "31" + "'";
        twhere = twhere + " AND kdpembpp = 'R1'";
        twhere = twhere + " and KDGERAK = '21' ";
        mSQL = mSQL + getReport_21rekap_VIEW_REPORT_21UNIT502(tindex, tpartisi, twhere);
        mSQL = mSQL + " ) ";
        mSQL = mSQL + " GROUP BY UNITUP,TGLBUKU,KDPEMBPP,KOGOL,STATUS,UNITUPKDPP,KDGERAK";
//        'untuk hari ini ambil dari tabel transaksi
        mSQL = mSQL + " union all ";
        mSQL = mSQL + " select /*+index(a idx_dphoffline_unitup) (a idx_dphoffline_tgltransaksi)*/ ";
        mSQL = mSQL + " tglbayar AS TGLBUKU,  KOGOL,";
        mSQL = mSQL + " COUNT(idpel) AS LEMBAR,   SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL,   SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,   SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,   SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,   SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI,   SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,   SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
        mSQL = mSQL + " kdgerakkeluar AS KDGERAK,KDPEMBPP as KDPEMBPP,STATUS,   UNITUP , NVL(UNITLUNAS,UNITUP) AS UNITUPKDPP ";
        mSQL = mSQL + " FROM DPHOFFLINE partition(" + partisi + ") a";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUP  = '" + tparUp.trim() + "'";
        mSQL = mSQL + " AND (tgltransaksi >= trunc(sysdate) ";
        mSQL = mSQL + "      and tgltransaksi < (trunc(sysdate) + 1)) ";
        mSQL = mSQL + " AND TGLBATALTRANS IS NULL";
        mSQL = mSQL + " AND kdpembpp = 'R1'";
        mSQL = mSQL + " AND (KODEGAGAL = '0' OR KODEGAGAL IS NULL)";
        mSQL = mSQL + " and kdgerakkeluar = '21' ";
        mSQL = mSQL + " GROUP BY UNITUP,tglbayar,KDPEMBPP,KOGOL,STATUS,UNITLUNAS,kdgerakkeluar";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUPKDPP  != '" + tparUp.trim() + "'";
        mSQL = mSQL + " Group by TGLBUKU, KOGOL,KDGERAK,KDPEMBPP,STATUS, UNITUP, UNITUPKDPP";
        mSQL = mSQL + " order by UNITUPKDPP asc,TGLBUKU asc";
        
        return mSQL;
    }

    public String GetReport_21rekap_21unit_kirimunit() {
        String mSQL = "";
//        'bulan
        mSQL = " SELECT * FROM B$_RPT_21UNIT_KIRIMUNIT";

        return mSQL;
    }

    public String GetReport_21rekap_21unit_kirim502(String vJenis,
                                                    String tBLTH,
                                                    String tparUp,
                                                    String tPetugas,
                                                    String tanggal,
                                                    String tanggalend,
                                                    String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);
//        'bulan
        mSQL = "SELECT SYSDATE AS TGLCETAK, TGLBUKU as TANGGAL, KOGOL, SUM(LEMBAR) AS LEMBAR, ";
        mSQL = mSQL + " SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, ";
        mSQL = mSQL + " SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, ";
        mSQL = mSQL + " SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, ";
        mSQL = mSQL + " SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, ";
        mSQL = mSQL + " SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, ";
        mSQL = mSQL + " SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3, ";
        mSQL = mSQL + " KDGERAK,KDPEMBPP,STATUS, UNITUP ";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
//        'untuk bulan ambil dari rekaptransaksi
        mSQL = mSQL + " SELECT  TGLBUKU, KOGOL, ";
        mSQL = mSQL + " SUM(LEMBAR) AS LEMBAR,   SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL,   SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,   SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,   SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,   SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI,   SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,   SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
        mSQL = mSQL + " KDGERAK,KDPEMBPP,STATUS, UNITUP, UNITUPKDPP ";
        mSQL = mSQL + " FROM ( ";
        String tindex = "/*+index(rekapDPHOFFLINEkdpp idx_rekap21kdpp_tglbuku, idx_rekap21kdpp_unitup)*/";
        String tpartisi = "";
        String twhere = "";
        twhere = twhere + " WHERE ";
        twhere = twhere + " UNITUP  = Rtrim()(Ltrim()('" + tparUp + "'))";
        twhere = twhere + " AND TGLBUKU  >= '" + tBLTH + "01" + "'";
        twhere = twhere + " AND TGLBUKU  <= '" + tBLTH + "31" + "'";
        twhere = twhere + " AND kdpembpp = 'R1'";
        twhere = twhere + " and KDGERAK = '21' ";
        mSQL = mSQL + getReport_21rekap_VIEW_REPORT_21UNIT502(tindex, tpartisi, twhere);
        mSQL = mSQL + " ) ";
        mSQL = mSQL + " GROUP BY UNITUP,TGLBUKU,KDPEMBPP,KOGOL,STATUS,UNITUPKDPP,KDGERAK";
//        'untuk hari ini ambil dari tabel transaksi
        mSQL = mSQL + " union all ";
        mSQL = mSQL + " select /*+index(a idx_dphoffline_unitup) (a idx_dphoffline_tgltransaksi)*/ ";
        mSQL = mSQL + " tglbayar AS TGLBUKU,  KOGOL,";
        mSQL = mSQL + " COUNT(idpel) AS LEMBAR,   SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL,   SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,   SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,   SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,   SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI,   SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,   SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
        mSQL = mSQL + " kdgerakkeluar AS KDGERAK,KDPEMBPP as KDPEMBPP,STATUS,   UNITUP , NVL(UNITLUNAS,UNITUP) AS UNITUPKDPP ";
        mSQL = mSQL + " FROM DPHOFFLINE partition(" + partisi + ") a";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUP  = '" + tparUp.trim() + "'";
        mSQL = mSQL + " AND (tgltransaksi >= trunc(sysdate) ";
        mSQL = mSQL + "      and tgltransaksi < (trunc(sysdate) + 1)) ";
        mSQL = mSQL + " AND TGLBATALTRANS IS NULL";
        mSQL = mSQL + " AND kdpembpp = 'R1'";
        mSQL = mSQL + " AND (KODEGAGAL = '0' OR KODEGAGAL IS NULL)";
        mSQL = mSQL + " and kdgerakkeluar = '21' ";
        mSQL = mSQL + " GROUP BY UNITUP,tglbayar,KDPEMBPP,KOGOL,STATUS,UNITLUNAS,kdgerakkeluar";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUPKDPP  != '" + tparUp.trim() + "'";
        mSQL = mSQL + " Group by TGLBUKU, KOGOL,KDGERAK,KDPEMBPP,STATUS, UNITUP";
        mSQL = mSQL + " order by TGLBUKU asc";

        return mSQL;
    }

    public String GetReport_21rekap_21unit_kirim502() {
        String mSQL = " SELECT * FROM B$_RPT_21UNIT_KIRIM502";
        return mSQL;
    }

    public String GetReport_21rekap_21unit_kirimunittglrekap(String vJenis,
                                                             String tBLTH,
                                                             String tparUp,
                                                             String tPetugas,
                                                             String tanggal,
                                                             String tanggalend,
                                                             String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);
//        'tanggal sum
        mSQL = "SELECT SYSDATE AS TGLCETAK, TGLBUKU as TANGGAL, KOGOL, SUM(LEMBAR) AS LEMBAR, ";
        mSQL = mSQL + " SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, ";
        mSQL = mSQL + " SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, ";
        mSQL = mSQL + " SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, ";
        mSQL = mSQL + " SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, ";
        mSQL = mSQL + " SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, ";
        mSQL = mSQL + " SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3, ";
        mSQL = mSQL + " KDGERAK,KDPEMBPP,STATUS, UNITUP , UNITUPKDPP ";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
        mSQL = mSQL + " select /*+index(a idx_dphoffline_02)*/ ";
        mSQL = mSQL + " tglbayar AS TGLBUKU,  KOGOL,";
        mSQL = mSQL + " COUNT(idpel) AS LEMBAR,   SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL,   SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,   SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,   SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,   SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI,   SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,   SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
        mSQL = mSQL + " kdgerakkeluar AS KDGERAK,KDPEMBPP as KDPEMBPP,STATUS,   UNITUP , NVL(UNITLUNAS,UNITUP) AS UNITUPKDPP ";
        mSQL = mSQL + " FROM DPHOFFLINE partition(" + partisi + ") a";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUP  = '" + tparUp.trim() + "'";
        mSQL = mSQL + " AND tglbayar  >= '" + tBLTH + tanggal + "'";
        mSQL = mSQL + " AND tglbayar  <= '" + tBLTH + tanggalend + "'";
        mSQL = mSQL + " AND TGLBATALTRANS IS NULL";
        mSQL = mSQL + " AND kdpembpp = 'R1'";
        mSQL = mSQL + " AND (KODEGAGAL = '0' OR KODEGAGAL IS NULL)";
        mSQL = mSQL + " and kdgerakkeluar = '21' ";
        mSQL = mSQL + " and UNITLUNAS  = '" + kode + "'";
        mSQL = mSQL + " AND UNITLUNAS  != '" + tparUp + "'";
        mSQL = mSQL + " GROUP BY UNITUP,tglbayar,KDPEMBPP,KOGOL,STATUS,UNITLUNAS,kdgerakkeluar";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " Group by TGLBUKU, KOGOL,KDGERAK,KDPEMBPP,STATUS, UNITUP,UNITUPKDPP";
        mSQL = mSQL + " order by TGLBUKU asc";

        return mSQL;
    }

    public String GetReport_21rekap_21unit_terimaunit(String vJenis,
                                                      String tBLTH,
                                                      String tparUp,
                                                      String tPetugas,
                                                      String tanggal,
                                                      String tanggalend,
                                                      String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);
//        'bulan
        mSQL = "SELECT SYSDATE AS TGLCETAK, TGLBUKU as TANGGAL, KOGOL, SUM(LEMBAR) AS LEMBAR, ";
        mSQL = mSQL + " SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, ";
        mSQL = mSQL + " SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, ";
        mSQL = mSQL + " SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, ";
        mSQL = mSQL + " SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, ";
        mSQL = mSQL + " SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, ";
        mSQL = mSQL + " SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3, ";
        mSQL = mSQL + " KDGERAK,KDPEMBPP,STATUS, UNITUP , UNITUPKDPP ";
//        'mSQL = mSQL + " FROM VIEW_REPORT_21UNIT502";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
//        'untuk bulan ambil dari rekaptransaksi
        mSQL = mSQL + " SELECT  TGLBUKU, KOGOL, ";
        mSQL = mSQL + " SUM(LEMBAR) AS LEMBAR,   SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL,   SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,   SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,   SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,   SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI,   SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,   SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
        mSQL = mSQL + " KDGERAK,KDPEMBPP,STATUS, UNITUP, UNITUPKDPP ";
        mSQL = mSQL + " FROM ( ";
        String tindex = "/*+index(rekapDPHOFFLINEkdpp idx_rekap21kdpp_tglbuku, idx_rekap21kdpp_unitup)*/";
        String tpartisi = "";
        String twhere = "";
        twhere = twhere + " WHERE ";
        twhere = twhere + " UNITUP  != Rtrim()(Ltrim()('" + tparUp + "'))";
        twhere = twhere + " AND TGLBUKU  >= '" + tBLTH + "01" + "'";
        twhere = twhere + " AND TGLBUKU  <= '" + tBLTH + "31" + "'";
        twhere = twhere + " AND kdpembpp = 'R1'";
        twhere = twhere + " and KDGERAK = '21' ";
        mSQL = mSQL + getReport_21rekap_VIEW_REPORT_21UNIT502(tindex, tpartisi, twhere);
        mSQL = mSQL + " ) ";
        mSQL = mSQL + " GROUP BY UNITUP,TGLBUKU,KDPEMBPP,KOGOL,STATUS,UNITUPKDPP,KDGERAK";
//        'untuk hari ini ambil dari tabel transaksi;
        mSQL = mSQL + " union all ";
        mSQL = mSQL + " select /*+index(a idx_dphoffline_unitup) (a idx_dphoffline_tgltransaksi)*/ ";
        mSQL = mSQL + " tglbayar AS TGLBUKU,  KOGOL,";
        mSQL = mSQL + " COUNT(idpel) AS LEMBAR,   SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL,   SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,   SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,   SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,   SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI,   SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,   SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
        mSQL = mSQL + " kdgerakkeluar AS KDGERAK,KDPEMBPP as KDPEMBPP,STATUS,   UNITUP , NVL(UNITLUNAS,UNITUP) AS UNITUPKDPP ";
        mSQL = mSQL + " FROM DPHOFFLINE partition(" + partisi + ") a";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUP  != '" + tparUp.trim() + "'";
        mSQL = mSQL + " AND (tgltransaksi >= trunc(sysdate) ";
        mSQL = mSQL + "      and tgltransaksi < (trunc(sysdate) + 1)) ";
        mSQL = mSQL + " AND TGLBATALTRANS IS NULL";
        mSQL = mSQL + " AND kdpembpp = 'R1'";
        mSQL = mSQL + " AND (KODEGAGAL = '0' OR KODEGAGAL IS NULL)";
        mSQL = mSQL + " and kdgerakkeluar = '21' ";
        mSQL = mSQL + " GROUP BY UNITUP,tglbayar,KDPEMBPP,KOGOL,STATUS,UNITLUNAS,kdgerakkeluar";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUPKDPP  = '" + tparUp.trim() + "'";
        mSQL = mSQL + " Group by TGLBUKU, KOGOL,KDGERAK,KDPEMBPP,STATUS, UNITUP, UNITUPKDPP";
        mSQL = mSQL + " order by unitup asc,TGLBUKU asc";

        return mSQL;
    }

    public String GetReport_21rekap_21unit_terimaunit() {
        String mSQL = " select * from B$_RPT_21UNIT_TERIMAUNIT";

        return mSQL;
    }

    public String GetReport_21rekap_21unit_terima502(String vJenis,
                                                     String tBLTH,
                                                     String tparUp,
                                                     String tPetugas,
                                                     String tanggal,
                                                     String tanggalend,
                                                     String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);
//        'bulan
        mSQL = "SELECT SYSDATE AS TGLCETAK, TGLBUKU as TANGGAL, KOGOL, SUM(LEMBAR) AS LEMBAR, ";
        mSQL = mSQL + " SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, ";
        mSQL = mSQL + " SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, ";
        mSQL = mSQL + " SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, ";
        mSQL = mSQL + " SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, ";
        mSQL = mSQL + " SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, ";
        mSQL = mSQL + " SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3, ";
        mSQL = mSQL + " KDGERAK,KDPEMBPP,STATUS, UNITUPKDPP,JALANTUNGGAK ";
//        'mSQL = mSQL + " FROM VIEW_REPORT_21UNIT502"
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
//        'untuk bulan ambil dari rekaptransaksi
        mSQL = mSQL + " SELECT  TGLBUKU, KOGOL, ";
        mSQL = mSQL + " SUM(LEMBAR) AS LEMBAR,   SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL,   SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,   SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,   SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,   SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI,   SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,   SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
        mSQL = mSQL + " KDGERAK,KDPEMBPP,STATUS, UNITUP, UNITUPKDPP,JALANTUNGGAK ";
        mSQL = mSQL + " FROM ( ";
        String tindex = "/*+index(rekapDPHOFFLINEkdpp idx_rekap21kdpp_tglbuku, idx_rekap21kdpp_unitup)*/";
        String tpartisi = "";
        String twhere = "";
        twhere = twhere + " WHERE ";
        twhere = twhere + " UNITUP  != '" + tparUp.trim() + "'";
        twhere = twhere + " AND TGLBUKU  >= '" + tBLTH + "01" + "'";
        twhere = twhere + " AND TGLBUKU  <= '" + tBLTH + "31" + "'";
        twhere = twhere + " AND kdpembpp = 'R1'";
        twhere = twhere + " and KDGERAK = '21' ";
        mSQL = mSQL + getReport_21rekap_VIEW_REPORT_21UNIT502(tindex, tpartisi, twhere);
        mSQL = mSQL + " ) ";
        mSQL = mSQL + " GROUP BY UNITUP,TGLBUKU,KDPEMBPP,KOGOL,STATUS,UNITUPKDPP,KDGERAK,JALANTUNGGAK";
//        'untuk hari ini ambil dari tabel transaksi
        mSQL = mSQL + " union all ";
        mSQL = mSQL + " select /*+index(a idx_dphoffline_unitup) (a idx_dphoffline_tgltransaksi)*/ ";
        mSQL = mSQL + " tglbayar AS TGLBUKU,  KOGOL,";
        mSQL = mSQL + " COUNT(idpel) AS LEMBAR,   SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL,   SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,   SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,   SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,   SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI,   SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,   SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
        mSQL = mSQL + " kdgerakkeluar AS KDGERAK,KDPEMBPP as KDPEMBPP,STATUS,   UNITUP , NVL(UNITLUNAS,UNITUP) AS UNITUPKDPP ";

        mSQL = mSQL + " ,(CASE WHEN TO_NUMBER(BLTH) >= TO_NUMBER(SUBSTR(TGLBAYAR,1,6)) ) { 'BERJALAN'";
        mSQL = mSQL + "   WHEN TO_NUMBER(BLTH) < TO_NUMBER(SUBSTR(TGLBAYAR,1,6)) ) { 'TUNGGAKAN'";
        mSQL = mSQL + "   ELSE '' END ) AS JALANTUNGGAK";

        mSQL = mSQL + " FROM DPHOFFLINE partition(" + partisi + ") a";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUP  != '" + tparUp.trim() + "'";
        mSQL = mSQL + " AND (tgltransaksi >= trunc(sysdate) ";
        mSQL = mSQL + "      and tgltransaksi < (trunc(sysdate) + 1)) ";
        mSQL = mSQL + " AND TGLBATALTRANS IS NULL";
        mSQL = mSQL + " AND kdpembpp = 'R1'";
        mSQL = mSQL + " AND (KODEGAGAL = '0' OR KODEGAGAL IS NULL)";
        mSQL = mSQL + " and kdgerakkeluar = '21' ";
        mSQL = mSQL + " GROUP BY UNITUP,tglbayar,KDPEMBPP,KOGOL,STATUS,UNITLUNAS,kdgerakkeluar,BLTH";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUPKDPP  = '" + tparUp.trim() + "'";
        mSQL = mSQL + " Group by TGLBUKU, KOGOL,KDGERAK,KDPEMBPP,STATUS, UNITUPKDPP,JALANTUNGGAK";
        mSQL = mSQL + " order by TGLBUKU asc";

        return mSQL;
    }

    public String GetReport_21rekap_21unit_terima502() {
        String mSQL = "SELECT * FROM B$_RPT_21UNIT_TERIMA502";
        return mSQL;
    }

    public String GetReport_21rekap_21unit_terimaunittglrekap(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);
//        'tanggal sum
        mSQL = "SELECT SYSDATE AS TGLCETAK, TGLBUKU as TANGGAL, KOGOL, SUM(LEMBAR) AS LEMBAR, ";
        mSQL = mSQL + " SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, ";
        mSQL = mSQL + " SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, ";
        mSQL = mSQL + " SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, ";
        mSQL = mSQL + " SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, ";
        mSQL = mSQL + " SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, ";
        mSQL = mSQL + " SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3, ";
        mSQL = mSQL + " KDGERAK,KDPEMBPP,STATUS, UNITUP , UNITUPKDPP ";
//        'mSQL = mSQL + " FROM VIEW_REPORT_21UNIT502"
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
        mSQL = mSQL + " select /*+index(a idx_dphoffline_02)*/ ";
        mSQL = mSQL + " tglbayar AS TGLBUKU,  KOGOL,";
        mSQL = mSQL + " COUNT(idpel) AS LEMBAR,   SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL,   SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,   SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,   SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,   SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI,   SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,   SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
        mSQL = mSQL + " kdgerakkeluar AS KDGERAK,KDPEMBPP as KDPEMBPP,STATUS,   UNITUP , NVL(UNITLUNAS,UNITUP) AS UNITUPKDPP ";
        mSQL = mSQL + " FROM DPHOFFLINE partition(" + partisi + ") a";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUP  != '" + tparUp.trim() + "'";
        mSQL = mSQL + " AND tglbayar  >= '" + tBLTH + tanggal + "'";
        mSQL = mSQL + " AND tglbayar  <= '" + tBLTH + tanggalend + "'";
        mSQL = mSQL + " AND TGLBATALTRANS IS NULL";
        mSQL = mSQL + " AND kdpembpp = 'R1'";
        mSQL = mSQL + " AND (KODEGAGAL = '0' OR KODEGAGAL IS NULL)";
        mSQL = mSQL + " and kdgerakkeluar = '21' ";
        mSQL = mSQL + " AND UNITUP  = '" + kode.trim() + "'";
        mSQL = mSQL + " and UNITLUNAS  = '" + tparUp + "'";
        mSQL = mSQL + " GROUP BY UNITUP,tglbayar,KDPEMBPP,KOGOL,STATUS,UNITLUNAS,kdgerakkeluar";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " Group by TGLBUKU, KOGOL,KDGERAK,KDPEMBPP,STATUS, UNITUP,UNITUPKDPP";
        mSQL = mSQL + " order by TGLBUKU asc";

        return mSQL;
    }
    //End Region

    //Region "21UNIT_404"
    public String GetReport_21rekap_21UNIT_404(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);
//        'FROM VIEW_REPORT_21UNIT404
//        'bulan
        mSQL = "SELECT  SYSDATE AS TGLCETAK, A.KDGERAK, ";
        mSQL = mSQL + "  A.UNITUP,A.KOGOL,A.TGLBUKU as TANGGAL,A.JALANTUNGGAK,A.KDPEMBPP,A.STATUS, ";
        mSQL = mSQL + " SUM(A.LEMBAR) AS LEMBAR, ";
        mSQL = mSQL + " SUM(A.RPTAG) AS RPTAG,SUM(A.RPPTL) AS RPPTL, ";
        mSQL = mSQL + " SUM(A.RPTB) AS RPTB, SUM(A.RPPPN) AS RPPPN, SUM(A.RPBPJU) AS RPBPJU, ";
        mSQL = mSQL + " SUM(A.RPTRAFO) AS RPTRAFO, SUM(A.RPSEWATRAFO) AS RPSEWATRAFO, SUM(A.RPSEWAKAP) AS RPSEWAKAP, ";
        mSQL = mSQL + " SUM(A.RPANGSA) AS RPANGSA, SUM(A.RPANGSB) AS RPANGSB, SUM(A.RPANGSC) AS RPANGSC, ";
        mSQL = mSQL + " SUM(A.RPMAT) AS RPMAT, SUM(A.RPPLN) AS RPPLN, SUM(A.RPREDUKSI) AS RPREDUKSI, ";
        mSQL = mSQL + " SUM(A.RPINSENTIF) AS RPINSENTIF, SUM(A.RPDISINSENTIF) AS RPDISINSENTIF, ";
        mSQL = mSQL + " SUM(A.RPBK1) AS RPBK1, SUM(A.RPBK2) AS RPBK2, SUM(A.RPBK3) AS RPBK3 ";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
//        'untuk bulan ambil dari rekaptransaksi
        mSQL = mSQL + " SELECT  ";
        mSQL = mSQL + " KDGERAK,";
        mSQL = mSQL + " UNITUP,KOGOL,TGLBUKU,JALANTUNGGAK,KDPEMBPP,STATUS, UNITUPKDPP,";
        mSQL = mSQL + " SUM(LEMBAR) AS LEMBAR, SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,  SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,  SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,  SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,  SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3";
        mSQL = mSQL + " FROM ( ";
        String tindex = "/*+index(rekapDPHOFFLINEkdpp idx_rekap21kdpp_tglbuku, idx_rekap21kdpp_unitup)*/";
        String tpartisi = "";
        String twhere = "";
        twhere = twhere + " WHERE ";
        twhere = twhere + " UNITUP  = '" + tparUp.trim() + "'";
        twhere = twhere + " AND TGLBUKU  >= '" + tBLTH + "01" + "'";
        twhere = twhere + " AND TGLBUKU  <= '" + tBLTH + "31" + "'";
        twhere = twhere + " AND kdpembpp = 'R1'";
        twhere = twhere + " and KDGERAK = '21' ";
        mSQL = mSQL + getReport_21rekap_VIEW_REPORT_21UNIT404(tindex, tpartisi, twhere);
        mSQL = mSQL + " ) ";
        mSQL = mSQL + " GROUP BY UNITUP,TGLBUKU,KDPEMBPP,KOGOL,STATUS,JALANTUNGGAK,UNITUPKDPP,KDGERAK ";
        mSQL = mSQL + " union all ";
        mSQL = mSQL + " SELECT  ";
        mSQL = mSQL + " b.KDGERAK,";
        mSQL = mSQL + " b.UNITUP,b.KOGOL,b.TGLBUKU,b.JALANTUNGGAK,b.KDPEMBPP,b.STATUS, b.UNITUPKDPP,";
        mSQL = mSQL + " SUM(b.LEMBAR) AS LEMBAR, SUM(b.RPTAG) AS RPTAG,SUM(b.RPPTL) AS RPPTL, SUM(b.RPTB) AS RPTB, SUM(b.RPPPN) AS RPPPN, SUM(b.RPBPJU) AS RPBPJU,  SUM(b.RPTRAFO) AS RPTRAFO, SUM(b.RPSEWATRAFO) AS RPSEWATRAFO, SUM(b.RPSEWAKAP) AS RPSEWAKAP,  SUM(b.RPANGSA) AS RPANGSA, SUM(b.RPANGSB) AS RPANGSB, SUM(b.RPANGSC) AS RPANGSC,  SUM(b.RPMAT) AS RPMAT, SUM(b.RPPLN) AS RPPLN, SUM(b.RPREDUKSI) AS RPREDUKSI, SUM(b.RPINSENTIF) AS RPINSENTIF, SUM(b.RPDISINSENTIF) AS RPDISINSENTIF,  SUM(b.RPBK1) AS RPBK1, SUM(b.RPBK2) AS RPBK2, SUM(b.RPBK3) AS RPBK3";
        mSQL = mSQL + " FROM  (";
        mSQL = mSQL + " SELECT /*+index(c idx_dphoffline_unitup) (c idx_dphoffline_tgltransaksi)*/ ";
        mSQL = mSQL + " tglbayar AS TGLBUKU,kdgerakkeluar  AS KDGERAK ,KDPEMBPP,STATUS,KOGOL,UNITUP,   NVL(UNITLUNAS,UNITUP) AS UNITUPKDPP ,";
        mSQL = mSQL + " RPTAG,RPPTL,RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA,  RPANGSB, RPANGSC,  RPMAT, RPPLN,   RPREDUKSI, RPINSENTIF, RPDISINSENTIF, NVL(RPBK1,0) RPBK1, NVL(RPBK2,0) RPBK2, NVL(RPBK3,0) RPBK3,";
        mSQL = mSQL + " (CASE WHEN TO_NUMBER(BLTH) >= TO_NUMBER(SUBSTR(TGLBAYAR,1,6)) ) { 'BERJALAN'";
        mSQL = mSQL + "   WHEN TO_NUMBER(BLTH) < TO_NUMBER(SUBSTR(TGLBAYAR,1,6)) ) { 'TUNGGAKAN'";
        mSQL = mSQL + "   ELSE '' END ) AS JALANTUNGGAK,";
        mSQL = mSQL + " 1 AS LEMBAR";
        mSQL = mSQL + " FROM DPHOFFLINE partition(" + partisi + ") c";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUP  = '" + tparUp.trim() + "'";
        mSQL = mSQL + " AND (tgltransaksi >= trunc(sysdate) ";
        mSQL = mSQL + "      and tgltransaksi < (trunc(sysdate) + 1)) ";
        mSQL = mSQL + " AND TGLBATALTRANS IS NULL";
        mSQL = mSQL + " AND kdpembpp = 'R1'";
        mSQL = mSQL + " AND (KODEGAGAL = '0' OR KODEGAGAL IS NULL)";
        mSQL = mSQL + " and kdgerakkeluar = '21' ";
        mSQL = mSQL + "      ) b";
        mSQL = mSQL + "      GROUP BY b.UNITUP,b.TGLBUKU,b.KDPEMBPP,b.KOGOL,b.STATUS,b.JALANTUNGGAK,b.UNITUPKDPP,b.KDGERAK";
        mSQL = mSQL + " ) a";
        mSQL = mSQL + " ";
        mSQL = mSQL + " Group by A.KDGERAK,A.UNITUP,A.KOGOL,A.TGLBUKU,A.JALANTUNGGAK,A.KDPEMBPP,A.STATUS";
        mSQL = mSQL + " order by A.TGLBUKU asc";

        return mSQL;

    }

    public String GetReport_21rekap_21UNIT_404_TRANS(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode) {
        String mSQL = "";
        mSQL = " SELECT * FROM B$_RPT_21UNIT404";
        return mSQL;
    }

    public String GetReport_21rekap_21unit_my404(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);
//        'bulan
        mSQL = "SELECT  SYSDATE AS TGLCETAK, A.KDGERAK, ";
        mSQL = mSQL + "  A.UNITUP,A.KOGOL,A.TGLBUKU as TANGGAL,A.JALANTUNGGAK,A.KDPEMBPP,A.STATUS, ";
        mSQL = mSQL + " SUM(A.LEMBAR) AS LEMBAR, ";
        mSQL = mSQL + " SUM(A.RPTAG) AS RPTAG,SUM(A.RPPTL) AS RPPTL, ";
        mSQL = mSQL + " SUM(A.RPTB) AS RPTB, SUM(A.RPPPN) AS RPPPN, SUM(A.RPBPJU) AS RPBPJU, ";
        mSQL = mSQL + " SUM(A.RPTRAFO) AS RPTRAFO, SUM(A.RPSEWATRAFO) AS RPSEWATRAFO, SUM(A.RPSEWAKAP) AS RPSEWAKAP, ";
        mSQL = mSQL + " SUM(A.RPANGSA) AS RPANGSA, SUM(A.RPANGSB) AS RPANGSB, SUM(A.RPANGSC) AS RPANGSC, ";
        mSQL = mSQL + " SUM(A.RPMAT) AS RPMAT, SUM(A.RPPLN) AS RPPLN, SUM(A.RPREDUKSI) AS RPREDUKSI, ";
        mSQL = mSQL + " SUM(A.RPINSENTIF) AS RPINSENTIF, SUM(A.RPDISINSENTIF) AS RPDISINSENTIF, ";
        mSQL = mSQL + " SUM(A.RPBK1) AS RPBK1, SUM(A.RPBK2) AS RPBK2, SUM(A.RPBK3) AS RPBK3 ";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
//        'untuk bulan ambil dari rekaptransaksi
        mSQL = mSQL + " SELECT  ";
        mSQL = mSQL + " KDGERAK,";
        mSQL = mSQL + " UNITUP,KOGOL,TGLBUKU,JALANTUNGGAK,KDPEMBPP,STATUS, UNITUPKDPP,";
        mSQL = mSQL + " SUM(LEMBAR) AS LEMBAR, SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,  SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,  SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,  SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,  SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3";
        mSQL = mSQL + " FROM ( ";
        String tindex = "/*+index(rekapDPHOFFLINEkdpp idx_rekap21kdpp_tglbuku, idx_rekap21kdpp_unitup)*/";
        String tpartisi = "";
        String twhere = "";
        twhere = twhere + " WHERE ";
        twhere = twhere + " UNITUP  = '" + tparUp + "'";
        twhere = twhere + " AND TGLBUKU  >= '" + tBLTH + "01" + "'";
        twhere = twhere + " AND TGLBUKU  <= '" + tBLTH + "31" + "'";
        twhere = twhere + " AND UNITUPKDPP  = '" + tparUp + "'";
        twhere = twhere + " AND kdpembpp = 'R1'";
        twhere = twhere + " and KDGERAK = '21' ";
        mSQL = mSQL + getReport_21rekap_VIEW_REPORT_21UNIT404(tindex, tpartisi, twhere);
        mSQL = mSQL + " ) ";
        mSQL = mSQL + " GROUP BY UNITUP,TGLBUKU,KDPEMBPP,KOGOL,STATUS,JALANTUNGGAK,UNITUPKDPP,KDGERAK ";
        mSQL = mSQL + " union all ";
        mSQL = mSQL + " SELECT  ";
        mSQL = mSQL + " b.KDGERAK,";
        mSQL = mSQL + " b.UNITUP,b.KOGOL,b.TGLBUKU,b.JALANTUNGGAK,b.KDPEMBPP,b.STATUS, b.UNITUPKDPP,";
        mSQL = mSQL + " SUM(b.LEMBAR) AS LEMBAR, SUM(b.RPTAG) AS RPTAG,SUM(b.RPPTL) AS RPPTL, SUM(b.RPTB) AS RPTB, SUM(b.RPPPN) AS RPPPN, SUM(b.RPBPJU) AS RPBPJU,  SUM(b.RPTRAFO) AS RPTRAFO, SUM(b.RPSEWATRAFO) AS RPSEWATRAFO, SUM(b.RPSEWAKAP) AS RPSEWAKAP,  SUM(b.RPANGSA) AS RPANGSA, SUM(b.RPANGSB) AS RPANGSB, SUM(b.RPANGSC) AS RPANGSC,  SUM(b.RPMAT) AS RPMAT, SUM(b.RPPLN) AS RPPLN, SUM(b.RPREDUKSI) AS RPREDUKSI, SUM(b.RPINSENTIF) AS RPINSENTIF, SUM(b.RPDISINSENTIF) AS RPDISINSENTIF,  SUM(b.RPBK1) AS RPBK1, SUM(b.RPBK2) AS RPBK2, SUM(b.RPBK3) AS RPBK3";
        mSQL = mSQL + " FROM  (";
        mSQL = mSQL + " SELECT /*+index(c idx_dphoffline_unitup) (c idx_dphoffline_tgltransaksi)*/ ";
        mSQL = mSQL + " tglbayar AS TGLBUKU,kdgerakkeluar  AS KDGERAK ,KDPEMBPP,STATUS,KOGOL,UNITUP,   NVL(UNITLUNAS,UNITUP) AS UNITUPKDPP ,";
        mSQL = mSQL + " RPTAG,RPPTL,RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA,  RPANGSB, RPANGSC,  RPMAT, RPPLN,   RPREDUKSI, RPINSENTIF, RPDISINSENTIF, NVL(RPBK1,0) RPBK1, NVL(RPBK2,0) RPBK2, NVL(RPBK3,0) RPBK3,";
        mSQL = mSQL + " (CASE WHEN TO_NUMBER(BLTH) >= TO_NUMBER(SUBSTR(TGLBAYAR,1,6)) ) { 'BERJALAN'";
        mSQL = mSQL + "   WHEN TO_NUMBER(BLTH) < TO_NUMBER(SUBSTR(TGLBAYAR,1,6)) ) { 'TUNGGAKAN'";
        mSQL = mSQL + "   ELSE '' END ) AS JALANTUNGGAK,";
        mSQL = mSQL + " 1 AS LEMBAR";
        mSQL = mSQL + " FROM DPHOFFLINE partition(" + partisi + ") c";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUP  = '" + tparUp.trim() + "'";
        mSQL = mSQL + " AND (tgltransaksi >= trunc(sysdate) ";
        mSQL = mSQL + "      and tgltransaksi < (trunc(sysdate) + 1)) ";
        mSQL = mSQL + " AND TGLBATALTRANS IS NULL";
        mSQL = mSQL + " AND kdpembpp = 'R1'";
        mSQL = mSQL + " AND (KODEGAGAL = '0' OR KODEGAGAL IS NULL)";
        mSQL = mSQL + " and kdgerakkeluar = '21' ";
        mSQL = mSQL + "      ) b";
        mSQL = mSQL + "      WHERE ";
        mSQL = mSQL + "      b.UNITUPKDPP  = '" + tparUp + "'";
        mSQL = mSQL + "      GROUP BY b.UNITUP,b.TGLBUKU,b.KDPEMBPP,b.KOGOL,b.STATUS,b.JALANTUNGGAK,b.UNITUPKDPP,b.KDGERAK";
        mSQL = mSQL + " ) a";
        mSQL = mSQL + " ";
        mSQL = mSQL + " Group by A.KDGERAK,A.UNITUP,A.KOGOL,A.TGLBUKU,A.JALANTUNGGAK,A.KDPEMBPP,A.STATUS";
        mSQL = mSQL + " order by A.TGLBUKU asc";

        return mSQL;
    }

    public String GetReport_21rekap_21unit_my404() {
        String mSQL = " SELECT * FROM B$_RPT_21UNIT_MY404";
        return mSQL;
        }

    public String GetReport_21rekap_21unit_kirim404(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);
//        'bulan
        mSQL = "SELECT  SYSDATE AS TGLCETAK, A.KDGERAK, ";
        mSQL = mSQL + "  A.UNITUP,A.KOGOL,A.TGLBUKU as TANGGAL,A.JALANTUNGGAK,A.KDPEMBPP,A.STATUS, ";
        mSQL = mSQL + " SUM(A.LEMBAR) AS LEMBAR, ";
        mSQL = mSQL + " SUM(A.RPTAG) AS RPTAG,SUM(A.RPPTL) AS RPPTL, ";
        mSQL = mSQL + " SUM(A.RPTB) AS RPTB, SUM(A.RPPPN) AS RPPPN, SUM(A.RPBPJU) AS RPBPJU, ";
        mSQL = mSQL + " SUM(A.RPTRAFO) AS RPTRAFO, SUM(A.RPSEWATRAFO) AS RPSEWATRAFO, SUM(A.RPSEWAKAP) AS RPSEWAKAP, ";
        mSQL = mSQL + " SUM(A.RPANGSA) AS RPANGSA, SUM(A.RPANGSB) AS RPANGSB, SUM(A.RPANGSC) AS RPANGSC, ";
        mSQL = mSQL + " SUM(A.RPMAT) AS RPMAT, SUM(A.RPPLN) AS RPPLN, SUM(A.RPREDUKSI) AS RPREDUKSI, ";
        mSQL = mSQL + " SUM(A.RPINSENTIF) AS RPINSENTIF, SUM(A.RPDISINSENTIF) AS RPDISINSENTIF, ";
        mSQL = mSQL + " SUM(A.RPBK1) AS RPBK1, SUM(A.RPBK2) AS RPBK2, SUM(A.RPBK3) AS RPBK3 ";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
//        'untuk bulan ambil dari rekaptransaksi
        mSQL = mSQL + " SELECT  ";
        mSQL = mSQL + " KDGERAK,";
        mSQL = mSQL + " UNITUP,KOGOL,TGLBUKU,JALANTUNGGAK,KDPEMBPP,STATUS, UNITUPKDPP,";
        mSQL = mSQL + " SUM(LEMBAR) AS LEMBAR, SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,  SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,  SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,  SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,  SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3";
        mSQL = mSQL + " FROM ( ";
        String tindex = "/*+index(rekapDPHOFFLINEkdpp idx_rekap21kdpp_tglbuku, idx_rekap21kdpp_unitup)*/";
        String tpartisi = "";
        String twhere = "";
        twhere = twhere + " WHERE ";
        twhere = twhere + " UNITUP  = '" + tparUp + "'";
        twhere = twhere + " AND TGLBUKU  >= '" + tBLTH + "01" + "'";
        twhere = twhere + " AND TGLBUKU  <= '" + tBLTH + "31" + "'";
        twhere = twhere + " AND UNITUPKDPP  != '" + tparUp + "'";
        twhere = twhere + " AND kdpembpp = 'R1'";
        twhere = twhere + " and KDGERAK = '21' ";
        mSQL = mSQL + getReport_21rekap_VIEW_REPORT_21UNIT404(tindex, tpartisi, twhere);
        mSQL = mSQL + " ) ";
        mSQL = mSQL + " GROUP BY UNITUP,TGLBUKU,KDPEMBPP,KOGOL,STATUS,JALANTUNGGAK,UNITUPKDPP,KDGERAK ";
//        'untuk hari ini ambil dari tabel transaksi
        mSQL = mSQL + " union all ";
        mSQL = mSQL + " SELECT  ";
        mSQL = mSQL + " b.KDGERAK,";
        mSQL = mSQL + " b.UNITUP,b.KOGOL,b.TGLBUKU,b.JALANTUNGGAK,b.KDPEMBPP,b.STATUS, b.UNITUPKDPP,";
        mSQL = mSQL + " SUM(b.LEMBAR) AS LEMBAR, SUM(b.RPTAG) AS RPTAG,SUM(b.RPPTL) AS RPPTL, SUM(b.RPTB) AS RPTB, SUM(b.RPPPN) AS RPPPN, SUM(b.RPBPJU) AS RPBPJU,  SUM(b.RPTRAFO) AS RPTRAFO, SUM(b.RPSEWATRAFO) AS RPSEWATRAFO, SUM(b.RPSEWAKAP) AS RPSEWAKAP,  SUM(b.RPANGSA) AS RPANGSA, SUM(b.RPANGSB) AS RPANGSB, SUM(b.RPANGSC) AS RPANGSC,  SUM(b.RPMAT) AS RPMAT, SUM(b.RPPLN) AS RPPLN, SUM(b.RPREDUKSI) AS RPREDUKSI, SUM(b.RPINSENTIF) AS RPINSENTIF, SUM(b.RPDISINSENTIF) AS RPDISINSENTIF,  SUM(b.RPBK1) AS RPBK1, SUM(b.RPBK2) AS RPBK2, SUM(b.RPBK3) AS RPBK3";
        mSQL = mSQL + " FROM  (";
        mSQL = mSQL + " SELECT /*+index(c idx_dphoffline_unitup) (c idx_dphoffline_tgltransaksi)*/ ";
        mSQL = mSQL + " tglbayar AS TGLBUKU,kdgerakkeluar  AS KDGERAK ,KDPEMBPP,STATUS,KOGOL,UNITUP,   NVL(UNITLUNAS,UNITUP) AS UNITUPKDPP ,";
        mSQL = mSQL + " RPTAG,RPPTL,RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA,  RPANGSB, RPANGSC,  RPMAT, RPPLN,   RPREDUKSI, RPINSENTIF, RPDISINSENTIF, NVL(RPBK1,0) RPBK1, NVL(RPBK2,0) RPBK2, NVL(RPBK3,0) RPBK3,";
        mSQL = mSQL + " (CASE WHEN TO_NUMBER(BLTH) >= TO_NUMBER(SUBSTR(TGLBAYAR,1,6)) ) { 'BERJALAN'";
        mSQL = mSQL + "   WHEN TO_NUMBER(BLTH) < TO_NUMBER(SUBSTR(TGLBAYAR,1,6)) ) { 'TUNGGAKAN'";
        mSQL = mSQL + "   ELSE '' END ) AS JALANTUNGGAK,";
        mSQL = mSQL + " 1 AS LEMBAR";
        mSQL = mSQL + " FROM DPHOFFLINE partition(" + partisi + ") c";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUP  = '" + tparUp.trim() + "'";
        mSQL = mSQL + " AND (tgltransaksi >= trunc(sysdate) ";
        mSQL = mSQL + "      and tgltransaksi < (trunc(sysdate) + 1)) ";
        mSQL = mSQL + " AND TGLBATALTRANS IS NULL";
        mSQL = mSQL + " AND kdpembpp = 'R1'";
        mSQL = mSQL + " AND (KODEGAGAL = '0' OR KODEGAGAL IS NULL)";
        mSQL = mSQL + " and kdgerakkeluar = '21' ";
        mSQL = mSQL + "      ) b";
        mSQL = mSQL + "      WHERE ";
        mSQL = mSQL + "      b.UNITUPKDPP  != '" + tparUp + "'";
        mSQL = mSQL + "      GROUP BY b.UNITUP,b.TGLBUKU,b.KDPEMBPP,b.KOGOL,b.STATUS,b.JALANTUNGGAK,b.UNITUPKDPP,b.KDGERAK";
        mSQL = mSQL + " ) a";
        mSQL = mSQL + " ";
        mSQL = mSQL + " Group by A.KDGERAK,A.UNITUP,A.KOGOL,A.TGLBUKU,A.JALANTUNGGAK,A.KDPEMBPP,A.STATUS";
        mSQL = mSQL + " order by a.TGLBUKU asc";

        return mSQL;
    }

    public String GetReport_21rekap_21unit_kirim404() {
        String mSQL = " SELECT * FROM B$_RPT_21UNIT_KIRIM404";
        return mSQL;
    }

    public String GetReport_21rekap_21unit_terima404(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);
//        'bulan
        mSQL = "SELECT  SYSDATE AS TGLCETAK, A.KDGERAK, ";
        mSQL = mSQL + "  A.UNITUPKDPP,A.KOGOL,A.TGLBUKU as TANGGAL,A.JALANTUNGGAK,A.KDPEMBPP,A.STATUS, ";
        mSQL = mSQL + " SUM(A.LEMBAR) AS LEMBAR, ";
        mSQL = mSQL + " SUM(A.RPTAG) AS RPTAG,SUM(A.RPPTL) AS RPPTL, ";
        mSQL = mSQL + " SUM(A.RPTB) AS RPTB, SUM(A.RPPPN) AS RPPPN, SUM(A.RPBPJU) AS RPBPJU, ";
        mSQL = mSQL + " SUM(A.RPTRAFO) AS RPTRAFO, SUM(A.RPSEWATRAFO) AS RPSEWATRAFO, SUM(A.RPSEWAKAP) AS RPSEWAKAP, ";
        mSQL = mSQL + " SUM(A.RPANGSA) AS RPANGSA, SUM(A.RPANGSB) AS RPANGSB, SUM(A.RPANGSC) AS RPANGSC, ";
        mSQL = mSQL + " SUM(A.RPMAT) AS RPMAT, SUM(A.RPPLN) AS RPPLN, SUM(A.RPREDUKSI) AS RPREDUKSI, ";
        mSQL = mSQL + " SUM(A.RPINSENTIF) AS RPINSENTIF, SUM(A.RPDISINSENTIF) AS RPDISINSENTIF, ";
        mSQL = mSQL + " SUM(A.RPBK1) AS RPBK1, SUM(A.RPBK2) AS RPBK2, SUM(A.RPBK3) AS RPBK3 ";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
//        'untuk bulan ambil dari rekaptransaksi
        mSQL = mSQL + " SELECT  ";
        mSQL = mSQL + " KDGERAK,";
        mSQL = mSQL + " UNITUP,KOGOL,TGLBUKU,JALANTUNGGAK,KDPEMBPP,STATUS, UNITUPKDPP,";
        mSQL = mSQL + " SUM(LEMBAR) AS LEMBAR, SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,  SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,  SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,  SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,  SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3";
        mSQL = mSQL + " FROM ( ";
        String tindex = "/*+index(rekapDPHOFFLINEkdpp idx_rekap21kdpp_tglbuku, idx_rekap21kdpp_unitup)*/";
        String tpartisi = "";
        String twhere = "";
        twhere = twhere + " WHERE ";
        twhere = twhere + " UNITUP  != Rtrim()(Ltrim()('" + tparUp + "'))";
        twhere = twhere + " AND TGLBUKU  >= '" + tBLTH + "01" + "'";
        twhere = twhere + " AND TGLBUKU  <= '" + tBLTH + "31" + "'";
        twhere = twhere + " AND UNITUPKDPP  = '" + tparUp + "'";
        twhere = twhere + " AND kdpembpp = 'R1'";
        twhere = twhere + " and KDGERAK = '21' ";
        mSQL = mSQL + getReport_21rekap_VIEW_REPORT_21UNIT404(tindex, tpartisi, twhere);
        mSQL = mSQL + " ) ";
        mSQL = mSQL + " GROUP BY UNITUP,TGLBUKU,KDPEMBPP,KOGOL,STATUS,JALANTUNGGAK,UNITUPKDPP,KDGERAK ";
//        'untuk hari ini ambil dari tabel transaksi
        mSQL = mSQL + " union all ";
        mSQL = mSQL + " SELECT  ";
        mSQL = mSQL + " b.KDGERAK,";
        mSQL = mSQL + " b.UNITUP,b.KOGOL,b.TGLBUKU,b.JALANTUNGGAK,b.KDPEMBPP,b.STATUS, b.UNITUPKDPP,";
        mSQL = mSQL + " SUM(b.LEMBAR) AS LEMBAR, SUM(b.RPTAG) AS RPTAG,SUM(b.RPPTL) AS RPPTL, SUM(b.RPTB) AS RPTB, SUM(b.RPPPN) AS RPPPN, SUM(b.RPBPJU) AS RPBPJU,  SUM(b.RPTRAFO) AS RPTRAFO, SUM(b.RPSEWATRAFO) AS RPSEWATRAFO, SUM(b.RPSEWAKAP) AS RPSEWAKAP,  SUM(b.RPANGSA) AS RPANGSA, SUM(b.RPANGSB) AS RPANGSB, SUM(b.RPANGSC) AS RPANGSC,  SUM(b.RPMAT) AS RPMAT, SUM(b.RPPLN) AS RPPLN, SUM(b.RPREDUKSI) AS RPREDUKSI, SUM(b.RPINSENTIF) AS RPINSENTIF, SUM(b.RPDISINSENTIF) AS RPDISINSENTIF,  SUM(b.RPBK1) AS RPBK1, SUM(b.RPBK2) AS RPBK2, SUM(b.RPBK3) AS RPBK3";
        mSQL = mSQL + " FROM  (";
        mSQL = mSQL + " SELECT /*+index(c idx_dphoffline_unitup) (c idx_dphoffline_tgltransaksi)*/ ";
        mSQL = mSQL + " tglbayar AS TGLBUKU,kdgerakkeluar  AS KDGERAK ,KDPEMBPP,STATUS,KOGOL,UNITUP,   NVL(UNITLUNAS,UNITUP) AS UNITUPKDPP ,";
        mSQL = mSQL + " RPTAG,RPPTL,RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA,  RPANGSB, RPANGSC,  RPMAT, RPPLN,   RPREDUKSI, RPINSENTIF, RPDISINSENTIF, NVL(RPBK1,0) RPBK1, NVL(RPBK2,0) RPBK2, NVL(RPBK3,0) RPBK3,";
        mSQL = mSQL + " (CASE WHEN TO_NUMBER(BLTH) >= TO_NUMBER(SUBSTR(TGLBAYAR,1,6)) ) { 'BERJALAN'";
        mSQL = mSQL + "   WHEN TO_NUMBER(BLTH) < TO_NUMBER(SUBSTR(TGLBAYAR,1,6)) ) { 'TUNGGAKAN'";
        mSQL = mSQL + "   ELSE '' END ) AS JALANTUNGGAK,";
        mSQL = mSQL + " 1 AS LEMBAR";
        mSQL = mSQL + " FROM DPHOFFLINE partition(" + partisi + ") c";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUP  != '" + tparUp.trim() + "'";
        mSQL = mSQL + " AND (tgltransaksi >= trunc(sysdate) ";
        mSQL = mSQL + "      and tgltransaksi < (trunc(sysdate) + 1)) ";
        mSQL = mSQL + " AND TGLBATALTRANS IS NULL";
        mSQL = mSQL + " AND kdpembpp = 'R1'";
        mSQL = mSQL + " AND (KODEGAGAL = '0' OR KODEGAGAL IS NULL)";
        mSQL = mSQL + " and kdgerakkeluar = '21' ";
        mSQL = mSQL + "      ) b";
        mSQL = mSQL + "      WHERE ";
        mSQL = mSQL + "      b.UNITUPKDPP  = '" + tparUp + "'";
        mSQL = mSQL + "      GROUP BY b.UNITUP,b.TGLBUKU,b.KDPEMBPP,b.KOGOL,b.STATUS,b.JALANTUNGGAK,b.UNITUPKDPP,b.KDGERAK";
        mSQL = mSQL + " ) a";
        mSQL = mSQL + " ";
        mSQL = mSQL + " group by A.KDGERAK,A.UNITUPKDPP,A.KOGOL,A.TGLBUKU,A.JALANTUNGGAK,A.KDPEMBPP,A.STATUS";
        mSQL = mSQL + " order by A.TGLBUKU asc";

        return mSQL;
    }

    public String GetReport_21rekap_21unit_terima404() {
        String mSQL = "SELECT * FROM B$_RPT_21UNIT_TERIMA404";
        return mSQL;
    }
    //End Region

    //Region "21UNIT_daftar"
    public String GetReport_21rekap_21unit_pptgldaftar(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);
//        'FROM VIEW_REPORT_21DAFTARREKG";
//        'tanggal daftar
        mSQL = "SELECT SYSDATE AS TGLCETAK, TGLBUKU as TANGGAL, IDPEL, KOGOL, BLTH, ";
        mSQL = mSQL + " KDPEMBPP, STATUS, NOREK, NAMA, NAMAPNJ, ";
        mSQL = mSQL + " RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, ";
        mSQL = mSQL + " RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, ";
        mSQL = mSQL + " RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, ";
        mSQL = mSQL + " RPDISINSENTIF, RPBK1, RPBK2, RPBK3, KDGERAK, ";
        mSQL = mSQL + " UNITUP, UNITKJ, KDINKASO, KDKELOMPOK, PEMDA, ";
        mSQL = mSQL + " KDPPJ, TARIP, DAYA, KDKIRIM, UNITUPKDPP, ";
        mSQL = mSQL + " KDPP";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
        mSQL = mSQL + " SELECT /*+index(DH idx_dphoffline_02)*/ ";
        mSQL = mSQL + " DH.TGLBAYAR AS TGLBUKU, WKTBAYAR,";
        mSQL = mSQL + " DH.IDPEL,  DH.KOGOL,  DH.BLTH,DH.KDPEMBPP,DH.STATUS,DH.NOREK, DIL.NAMA, DIL.NAMAPNJ,";
        mSQL = mSQL + " DH.RPTAG,DH.RPPTL,DH.RPTB, DH.RPPPN, DH.RPBPJU, DH.RPTRAFO, DH.RPSEWATRAFO, DH.RPSEWAKAP,";
        mSQL = mSQL + " DH.RPANGSA,  DH.RPANGSB, DH.RPANGSC,  DH.RPMAT, DH.RPPLN,   DH.RPREDUKSI,  DH.RPINSENTIF, DH.RPDISINSENTIF, DH.RPBK1, DH.RPBK2, DH.RPBK3,";
        mSQL = mSQL + " DH.KDGERAKKELUAR AS KDGERAK, DH.UNITUP, DH.UNITKJ, DH.KDINKASO, DH.KDKELOMPOK, DH.PEMDA,DH.KDPPJ,DH.TARIP, DH.DAYA , DH.KDKIRIM,";
        mSQL = mSQL + " NVL(DH.UNITLUNAS,DH.UNITUP) AS UNITUPKDPP , KDPP";
        mSQL = mSQL + " FROM DPHOFFLINE partition(" + partisi + ") DH ";
        mSQL = mSQL + " INNER JOIN DIL ON DH.IDPEL = DIL.IDPEL";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " DH.UNITUP  = '" + tparUp.trim() + "'";
        mSQL = mSQL + " AND DH.TGLBAYAR  >= '" + tBLTH + tanggal + "'";
        mSQL = mSQL + " AND DH.TGLBAYAR  <= '" + tBLTH + tanggalend + "'";
        mSQL = mSQL + " AND DH.KDPP  = '" + kode + "'";
        mSQL = mSQL + " AND DH.TGLBATALTRANS IS NULL";
        mSQL = mSQL + " AND DH.kdpembpp = 'R1'";
        mSQL = mSQL + " AND (DH.KODEGAGAL = '0' OR DH.KODEGAGAL IS NULL)";
        mSQL = mSQL + " and DH.kdgerakkeluar = '21' ";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " order by TGLBUKU asc";
        
        return mSQL;
    }
    public String GetReport_21rekap_21unit_mypptgldaftar(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);
//        'tanggal daftar
        mSQL = "SELECT SYSDATE AS TGLCETAK, TGLBUKU as TANGGAL, IDPEL, KOGOL, BLTH, ";
        mSQL = mSQL + " KDPEMBPP, STATUS, NOREK, NAMA, NAMAPNJ, ";
        mSQL = mSQL + " RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, ";
        mSQL = mSQL + " RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, ";
        mSQL = mSQL + " RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, ";
        mSQL = mSQL + " RPDISINSENTIF, RPBK1, RPBK2, RPBK3, KDGERAK, ";
        mSQL = mSQL + " UNITUP, UNITKJ, KDINKASO, KDKELOMPOK, PEMDA, ";
        mSQL = mSQL + " KDPPJ, TARIP, DAYA, KDKIRIM, UNITUPKDPP, ";
        mSQL = mSQL + " KDPP";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
        mSQL = mSQL + " SELECT /*+index(DH idx_dphoffline_02)*/ ";
        mSQL = mSQL + " DH.TGLBAYAR AS TGLBUKU, WKTBAYAR,";
        mSQL = mSQL + " DH.IDPEL,  DH.KOGOL,  DH.BLTH,DH.KDPEMBPP,DH.STATUS,DH.NOREK, DIL.NAMA, DIL.NAMAPNJ,";
        mSQL = mSQL + " DH.RPTAG,DH.RPPTL,DH.RPTB, DH.RPPPN, DH.RPBPJU, DH.RPTRAFO, DH.RPSEWATRAFO, DH.RPSEWAKAP,";
        mSQL = mSQL + " DH.RPANGSA,  DH.RPANGSB, DH.RPANGSC,  DH.RPMAT, DH.RPPLN,   DH.RPREDUKSI,  DH.RPINSENTIF, DH.RPDISINSENTIF, DH.RPBK1, DH.RPBK2, DH.RPBK3,";
        mSQL = mSQL + " DH.KDGERAKKELUAR AS KDGERAK, DH.UNITUP, DH.UNITKJ, DH.KDINKASO, DH.KDKELOMPOK, DH.PEMDA,DH.KDPPJ,DH.TARIP, DH.DAYA , DH.KDKIRIM,";
        mSQL = mSQL + " NVL(DH.UNITLUNAS,DH.UNITUP) AS UNITUPKDPP , KDPP";
        mSQL = mSQL + " FROM DPHOFFLINE partition(" + partisi + ") DH ";
        mSQL = mSQL + " INNER JOIN DIL ON DH.IDPEL = DIL.IDPEL";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " DH.UNITUP  = '" + tparUp.trim() + "'";
        mSQL = mSQL + " AND DH.TGLBAYAR  >= '" + tBLTH + tanggal + "'";
        mSQL = mSQL + " AND DH.TGLBAYAR  <= '" + tBLTH + tanggalend + "'";
        mSQL = mSQL + " AND DH.KDPP  = '" + kode + "'";
        mSQL = mSQL + " AND DH.TGLBATALTRANS IS NULL";
        mSQL = mSQL + " AND DH.kdpembpp = 'R1'";
        mSQL = mSQL + " AND (DH.KODEGAGAL = '0' OR DH.KODEGAGAL IS NULL)";
        mSQL = mSQL + " and DH.kdgerakkeluar = '21' ";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUPKDPP  = Rtrim()(Ltrim()('" + tparUp + "'))";
        mSQL = mSQL + " order by TGLBUKU asc";
        
        return mSQL;
    }
    public String GetReport_21rekap_21unit_kirimunittgldaftar(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);
//        'tanggal daftar
        mSQL = "SELECT SYSDATE AS TGLCETAK, TGLBUKU as TANGGAL, IDPEL, KOGOL, BLTH, ";
        mSQL = mSQL + " KDPEMBPP, STATUS, NOREK, NAMA, NAMAPNJ, ";
        mSQL = mSQL + " RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, ";
        mSQL = mSQL + " RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, ";
        mSQL = mSQL + " RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, ";
        mSQL = mSQL + " RPDISINSENTIF, RPBK1, RPBK2, RPBK3, KDGERAK, ";
        mSQL = mSQL + " UNITUP, UNITKJ, KDINKASO, KDKELOMPOK, PEMDA, ";
        mSQL = mSQL + " KDPPJ, TARIP, DAYA, KDKIRIM, UNITUPKDPP, ";
        mSQL = mSQL + " KDPP";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
        mSQL = mSQL + " SELECT /*+index(DH idx_dphoffline_02)*/ ";
        mSQL = mSQL + " DH.TGLBAYAR AS TGLBUKU, WKTBAYAR,";
        mSQL = mSQL + " DH.IDPEL,  DH.KOGOL,  DH.BLTH,DH.KDPEMBPP,DH.STATUS,DH.NOREK, DIL.NAMA, DIL.NAMAPNJ,";
        mSQL = mSQL + " DH.RPTAG,DH.RPPTL,DH.RPTB, DH.RPPPN, DH.RPBPJU, DH.RPTRAFO, DH.RPSEWATRAFO, DH.RPSEWAKAP,";
        mSQL = mSQL + " DH.RPANGSA,  DH.RPANGSB, DH.RPANGSC,  DH.RPMAT, DH.RPPLN,   DH.RPREDUKSI,  DH.RPINSENTIF, DH.RPDISINSENTIF, DH.RPBK1, DH.RPBK2, DH.RPBK3,";
        mSQL = mSQL + " DH.KDGERAKKELUAR AS KDGERAK, DH.UNITUP, DH.UNITKJ, DH.KDINKASO, DH.KDKELOMPOK, DH.PEMDA,DH.KDPPJ,DH.TARIP, DH.DAYA , DH.KDKIRIM,";
        mSQL = mSQL + " NVL(DH.UNITLUNAS,DH.UNITUP) AS UNITUPKDPP , KDPP";
        mSQL = mSQL + " FROM DPHOFFLINE partition(" + partisi + ") DH ";
        mSQL = mSQL + " INNER JOIN DIL ON DH.IDPEL = DIL.IDPEL";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " DH.UNITUP  = '" + tparUp.trim() + "'";
        mSQL = mSQL + " AND DH.TGLBAYAR  >= '" + tBLTH + tanggal + "'";
        mSQL = mSQL + " AND DH.TGLBAYAR  <= '" + tBLTH + tanggalend + "'";
        mSQL = mSQL + " AND DH.TGLBATALTRANS IS NULL";
        mSQL = mSQL + " AND DH.kdpembpp = 'R1'";
        mSQL = mSQL + " AND (DH.KODEGAGAL = '0' OR DH.KODEGAGAL IS NULL)";
        mSQL = mSQL + " and DH.kdgerakkeluar = '21' ";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUPKDPP  = Rtrim()(Ltrim()('" + kode + "'))";
        mSQL = mSQL + " AND UNITUPKDPP  != Rtrim()(Ltrim()('" + tparUp + "'))";
        mSQL = mSQL + " order by TGLBUKU asc";
        
        return mSQL;
    }
    public String GetReport_21rekap_21unit_terimaunittgldaftar(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);
//        'tanggal daftar;
        mSQL = "SELECT SYSDATE AS TGLCETAK, TGLBUKU as TANGGAL, IDPEL, KOGOL, BLTH, ";
        mSQL = mSQL + " KDPEMBPP, STATUS, NOREK, NAMA, NAMAPNJ, ";
        mSQL = mSQL + " RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, ";
        mSQL = mSQL + " RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, ";
        mSQL = mSQL + " RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, ";
        mSQL = mSQL + " RPDISINSENTIF, RPBK1, RPBK2, RPBK3, KDGERAK, ";
        mSQL = mSQL + " UNITUP, UNITKJ, KDINKASO, KDKELOMPOK, PEMDA, ";
        mSQL = mSQL + " KDPPJ, TARIP, DAYA, KDKIRIM, UNITUPKDPP, ";
        mSQL = mSQL + " KDPP";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
        mSQL = mSQL + " SELECT /*+index(DH idx_dphoffline_02)*/ ";
        mSQL = mSQL + " DH.TGLBAYAR AS TGLBUKU, WKTBAYAR,";
        mSQL = mSQL + " DH.IDPEL,  DH.KOGOL,  DH.BLTH,DH.KDPEMBPP,DH.STATUS,DH.NOREK, DIL.NAMA, DIL.NAMAPNJ,";
        mSQL = mSQL + " DH.RPTAG,DH.RPPTL,DH.RPTB, DH.RPPPN, DH.RPBPJU, DH.RPTRAFO, DH.RPSEWATRAFO, DH.RPSEWAKAP,";
        mSQL = mSQL + " DH.RPANGSA,  DH.RPANGSB, DH.RPANGSC,  DH.RPMAT, DH.RPPLN,   DH.RPREDUKSI,  DH.RPINSENTIF, DH.RPDISINSENTIF, DH.RPBK1, DH.RPBK2, DH.RPBK3,";
        mSQL = mSQL + " DH.KDGERAKKELUAR AS KDGERAK, DH.UNITUP, DH.UNITKJ, DH.KDINKASO, DH.KDKELOMPOK, DH.PEMDA,DH.KDPPJ,DH.TARIP, DH.DAYA , DH.KDKIRIM,";
        mSQL = mSQL + " NVL(DH.UNITLUNAS,DH.UNITUP) AS UNITUPKDPP , KDPP";
        mSQL = mSQL + " FROM DPHOFFLINE partition(" + partisi + ") DH ";
        mSQL = mSQL + " INNER JOIN DIL ON DH.IDPEL = DIL.IDPEL";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " DH.UNITUP  != '" + tparUp.trim() + "'";
        mSQL = mSQL + " AND DH.TGLBAYAR  >= '" + tBLTH + tanggal + "'";
        mSQL = mSQL + " AND DH.TGLBAYAR  <= '" + tBLTH + tanggalend + "'";
        mSQL = mSQL + " AND dh.UNITUP  = '" + kode.trim() + "'";
        mSQL = mSQL + " AND DH.TGLBATALTRANS IS NULL";
        mSQL = mSQL + " AND DH.kdpembpp = 'R1'";
        mSQL = mSQL + " AND (DH.KODEGAGAL = '0' OR DH.KODEGAGAL IS NULL)";
        mSQL = mSQL + " and DH.kdgerakkeluar = '21' ";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " UNITUPKDPP  = Rtrim()(Ltrim()('" + tparUp + "'))";
        mSQL = mSQL + " order by TGLBUKU asc";
        
        return mSQL;
        
    }
    //End Region
    //Region "21UNIT_view"
    public String getReport_21rekap_VIEW_REPORT_21UNITPP(String tindex, String tpartisi, String twhere) {
        String sql = "";
        sql = "   SELECT  ";
        sql = sql + tindex;
        sql = sql + "   TGLBUKU,  ";
        sql = sql + "   KOGOL,  ";
        sql = sql + "   SUM(GERAK*LEMBAR) AS LEMBAR,  ";
        sql = sql + "   SUM(GERAK*RPTAG) AS RPTAG,  ";
        sql = sql + "   SUM(GERAK*RPPTL) AS RPPTL,  ";
        sql = sql + "   SUM(GERAK*RPTB) AS RPTB,  ";
        sql = sql + "   SUM(GERAK*RPPPN) AS RPPPN,  ";
        sql = sql + "   SUM(GERAK*RPBPJU) AS RPBPJU,  ";
        sql = sql + "   SUM(GERAK*RPTRAFO) AS RPTRAFO,  ";
        sql = sql + "   SUM(GERAK*RPSEWATRAFO) AS RPSEWATRAFO,  ";
        sql = sql + "   SUM(GERAK*RPSEWAKAP) AS RPSEWAKAP,  ";
        sql = sql + "   SUM(GERAK*RPANGSA) AS RPANGSA,  ";
        sql = sql + "   SUM(GERAK*RPANGSB) AS RPANGSB,  ";
        sql = sql + "   SUM(GERAK*RPANGSC) AS RPANGSC,  ";
        sql = sql + "   SUM(GERAK*RPMAT) AS RPMAT,  ";
        sql = sql + "   SUM(GERAK*RPPLN) AS RPPLN,  ";
        sql = sql + "   SUM(GERAK*RPREDUKSI) AS RPREDUKSI,  ";
        sql = sql + "   SUM(GERAK*RPINSENTIF) AS RPINSENTIF,  ";
        sql = sql + "   SUM(GERAK*RPDISINSENTIF) AS RPDISINSENTIF,  ";
        sql = sql + "   SUM(GERAK*RPBK1) AS RPBK1,  ";
        sql = sql + "   SUM(GERAK*RPBK2) AS RPBK2,  ";
        sql = sql + "   SUM(GERAK*RPBK3) AS RPBK3,  ";
        sql = sql + "   KDGERAK,KDPEMBPP,STATUS,UNITUP,UNITUPKDPP,KDPP,JLNTGK AS JALANTUNGGAK  ";
        sql = sql + "   FROM rekapDPHOFFLINEkdpp  ";
        sql = sql + tpartisi;
        sql = sql + " ";
        sql = sql + twhere;
        sql = sql + "   GROUP BY KDGERAK,UNITUP,TGLBUKU,KOGOL,KDPEMBPP,STATUS,UNITUPKDPP,  KDPP,JLNTGK  ";

        return sql;
    }
    public String getReport_21rekap_VIEW_REPORT_21UNIT502(String tindex, String tpartisi, String twhere) {
        String sql = "";
        sql = "   SELECT  ";
        sql = sql + tindex;
        sql = sql + "   TGLBUKU,  ";
        sql = sql + "   KOGOL,  ";
        sql = sql + "   SUM(GERAK*LEMBAR) AS LEMBAR,  ";
        sql = sql + "   SUM(GERAK*RPTAG) AS RPTAG,  ";
        sql = sql + "   SUM(GERAK*RPPTL) AS RPPTL,  ";
        sql = sql + "   SUM(GERAK*RPTB) AS RPTB,  ";
        sql = sql + "   SUM(GERAK*RPPPN) AS RPPPN,  ";
        sql = sql + "   SUM(GERAK*RPBPJU) AS RPBPJU,  ";
        sql = sql + "   SUM(GERAK*RPTRAFO) AS RPTRAFO,  ";
        sql = sql + "   SUM(GERAK*RPSEWATRAFO) AS RPSEWATRAFO,  ";
        sql = sql + "   SUM(GERAK*RPSEWAKAP) AS RPSEWAKAP,  ";
        sql = sql + "   SUM(GERAK*RPANGSA) AS RPANGSA,  ";
        sql = sql + "   SUM(GERAK*RPANGSB) AS RPANGSB,  ";
        sql = sql + "   SUM(GERAK*RPANGSC) AS RPANGSC,  ";
        sql = sql + "   SUM(GERAK*RPMAT) AS RPMAT,  ";
        sql = sql + "   SUM(GERAK*RPPLN) AS RPPLN,  ";
        sql = sql + "   SUM(GERAK*RPREDUKSI) AS RPREDUKSI,  ";
        sql = sql + "   SUM(GERAK*RPINSENTIF) AS RPINSENTIF,  ";
        sql = sql + "   SUM(GERAK*RPDISINSENTIF) AS RPDISINSENTIF,  ";
        sql = sql + "   SUM(GERAK*RPBK1) AS RPBK1,  ";
        sql = sql + "   SUM(GERAK*RPBK2) AS RPBK2,  ";
        sql = sql + "   SUM(GERAK*RPBK3) AS RPBK3,  ";
        sql = sql + "   KDGERAK,KDPEMBPP,STATUS,UNITUP,UNITUPKDPP,JLNTGK AS JALANTUNGGAK ";
        sql = sql + "   FROM rekapDPHOFFLINEkdpp  ";
        sql = sql + tpartisi;
        sql = sql + " ";
        sql = sql + twhere;
        sql = sql + "   GROUP BY KDGERAK,UNITUP,TGLBUKU,KOGOL,KDPEMBPP,STATUS,UNITUPKDPP,JLNTGK ";

        return sql;
    }
    public String getReport_21rekap_VIEW_REPORT_21UNIT404(String tindex, String tpartisi, String twhere) {
        String sql = "";
        sql = "   SELECT  ";
        sql = sql + tindex;
        sql = sql + "   TGLBUKU,  ";
        sql = sql + "   KOGOL,  ";
        sql = sql + "   SUM(GERAK*LEMBAR) AS LEMBAR,  ";
        sql = sql + "   SUM(GERAK*RPTAG) AS RPTAG,  ";
        sql = sql + "   SUM(GERAK*RPPTL) AS RPPTL,  ";
        sql = sql + "   SUM(GERAK*RPTB) AS RPTB,  ";
        sql = sql + "   SUM(GERAK*RPPPN) AS RPPPN,  ";
        sql = sql + "   SUM(GERAK*RPBPJU) AS RPBPJU,  ";
        sql = sql + "   SUM(GERAK*RPTRAFO) AS RPTRAFO,  ";
        sql = sql + "   SUM(GERAK*RPSEWATRAFO) AS RPSEWATRAFO,  ";
        sql = sql + "   SUM(GERAK*RPSEWAKAP) AS RPSEWAKAP,  ";
        sql = sql + "   SUM(GERAK*RPANGSA) AS RPANGSA,  ";
        sql = sql + "   SUM(GERAK*RPANGSB) AS RPANGSB,  ";
        sql = sql + "   SUM(GERAK*RPANGSC) AS RPANGSC,  ";
        sql = sql + "   SUM(GERAK*RPMAT) AS RPMAT,  ";
        sql = sql + "   SUM(GERAK*RPPLN) AS RPPLN,  ";
        sql = sql + "   SUM(GERAK*RPREDUKSI) AS RPREDUKSI,  ";
        sql = sql + "   SUM(GERAK*RPINSENTIF) AS RPINSENTIF,  ";
        sql = sql + "   SUM(GERAK*RPDISINSENTIF) AS RPDISINSENTIF,  ";
        sql = sql + "   SUM(GERAK*RPBK1) AS RPBK1,  ";
        sql = sql + "   SUM(GERAK*RPBK2) AS RPBK2,  ";
        sql = sql + "   SUM(GERAK*RPBK3) AS RPBK3,  ";
        sql = sql + "   KDGERAK,KDPEMBPP,STATUS,UNITUP,UNITUPKDPP, JLNTGK as JALANTUNGGAK  ";
        sql = sql + "   FROM rekapDPHOFFLINEkdpp  ";
        sql = sql + tpartisi;
        sql = sql + " ";
        sql = sql + twhere;
        sql = sql + "   GROUP BY KDGERAK,UNITUP,TGLBUKU,KOGOL,KDPEMBPP,STATUS,UNITUPKDPP, JLNTGK  ";

        return sql;
    }
    //End Region
//        '=========================================================================
//        'Public =========================================================================
    public String GetReport_21kdpp(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode) {
        String mSQL = "";

        if ( vJenis.toUpperCase() == "21KDPP_PPTGLREKAP" ) {
        //'mSQL = GetReport_21kdpp_21KDPP_PPTGLREKAP(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode)
            mSQL = GetReport_21kdpp_21KDPP_PPTGLREKAP();
        } else if ( vJenis.toUpperCase() == "21KDPP_PPTGLREKAPGOL" ) {
            //mSQL = GetReport_21kdpp_21KDPP_PPTGLREKAPGOL(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode)
            mSQL = GetReport_21kdpp_21KDPP_PPTGLREKAPGOL();
        } else if ( vJenis.toUpperCase() == "21KDPP_UNITTGLREKAP" ) {
            //mSQL = GetReport_21kdpp_21KDPP_UNITTGLREKAP(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode)
            mSQL = GetReport_21kdpp_21KDPP_UNITTGLREKAP();
        } else if ( vJenis.toUpperCase() == "21KDPP_UNITTGLREKAPGOL" ) {
            //mSQL = GetReport_21kdpp_21KDPP_UNITTGLREKAPGOL(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode)
            mSQL = GetReport_21kdpp_21KDPP_UNITTGLREKAPGOL();
        }

        if ( vJenis.toUpperCase() == "21KDPP_PPTGLDAFTAR" ) {
            //mSQL = GetReport_21kdpp_21KDPP_PPTGLDAFTAR(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode)
            mSQL = GetReport_21kdpp_21KDPP_PPTGLDAFTAR();
        } else if ( vJenis.toUpperCase() == "21KDPP_UNITTGLDAFTAR" ) {
            //mSQL = GetReport_21kdpp_21KDPP_UNITTGLDAFTAR(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode)
            mSQL = GetReport_21kdpp_21KDPP_UNITTGLDAFTAR();
        }

        return mSQL;

    }
    //Region "21KDPP"
    public String GetReport_21kdpp_21KDPP_PPTGLREKAP(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);
        //FROM VIEW_REPORT_21KDPP
        mSQL = "SELECT SYSDATE AS TGLCETAK, TGLBUKU as TANGGAL, SUM(LEMBAR) AS LEMBAR, ";
        mSQL = mSQL + " SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, ";
        mSQL = mSQL + " SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, ";
        mSQL = mSQL + " SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, ";
        mSQL = mSQL + " SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, ";
        mSQL = mSQL + " SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, ";
        mSQL = mSQL + " SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3, ";
        mSQL = mSQL + " KDGERAK,KDPEMBPP,STATUS, KDPP ";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
        mSQL = mSQL + "    SELECT /*+index(a IDX_DPHOFFLINE_KDPP)*/  ";
        mSQL = mSQL + "    TGLBAYAR  AS TGLBUKU,";
        mSQL = mSQL + "    KOGOL, COUNT(idpel) AS LEMBAR,";
        mSQL = mSQL + "    SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL,   SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,   SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,   SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,   SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI,   SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,   SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
        mSQL = mSQL + "    KDGERAKKELUAR AS KDGERAK,KDPEMBPP,STATUS,";
        mSQL = mSQL + "    UNITUP , KDPP, NVL(UNITLUNAS,UNITUP) AS UNITUPKDPP";
        mSQL = mSQL + "    FROM DPHOFFLINE partition(" + partisi + ") a";
        mSQL = mSQL + "    WHERE ";
        mSQL = mSQL + "    KDPP  = '" + kode + "'";
        mSQL = mSQL + "    AND TGLBAYAR  >= '" + tBLTH + tanggal + "'";
        mSQL = mSQL + "    AND TGLBAYAR  <= '" + tBLTH + tanggalend + "'";
        mSQL = mSQL + "    AND TGLBATALTRANS IS NULL";
        mSQL = mSQL + "    AND kdpembpp = 'R1'";
        mSQL = mSQL + "    AND (KODEGAGAL = '0' OR KODEGAGAL IS NULL)";
        mSQL = mSQL + "    and kdgerakkeluar = '21' ";
        mSQL = mSQL + "    GROUP BY KDGERAKKELUAR,UNITUP,TGLBAYAR,KOGOL,KDPEMBPP,STATUS,KDPP,UNITLUNAS";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " Group by TGLBUKU, KDGERAK,KDPEMBPP,STATUS, KDPP ";
        mSQL = mSQL + " order by KDPP asc,TGLBUKU asc";
        return mSQL;
    }
    public String GetReport_21kdpp_21KDPP_PPTGLREKAP() {
        String mSQL = "select * from B$_RPT_21KDPP_PPTGLREKAP";
        return mSQL;
    }
    public String GetReport_21kdpp_21KDPP_PPTGLREKAPGOL(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);

        mSQL = "SELECT SYSDATE AS TGLCETAK, TGLBUKU as TANGGAL, KOGOL, SUM(LEMBAR) AS LEMBAR, ";
        mSQL = mSQL + " SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, ";
        mSQL = mSQL + " SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, ";
        mSQL = mSQL + " SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, ";
        mSQL = mSQL + " SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, ";
        mSQL = mSQL + " SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, ";
        mSQL = mSQL + " SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3, ";
        mSQL = mSQL + " KDGERAK,KDPEMBPP,STATUS,  KDPP ";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
        mSQL = mSQL + "    SELECT /*+index(a IDX_DPHOFFLINE_KDPP)*/  ";
        mSQL = mSQL + "    TGLBAYAR  AS TGLBUKU,";
        mSQL = mSQL + "    KOGOL, COUNT(idpel) AS LEMBAR,";
        mSQL = mSQL + "    SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL,   SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,   SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,   SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,   SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI,   SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,   SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
        mSQL = mSQL + "    KDGERAKKELUAR AS KDGERAK,KDPEMBPP,STATUS,";
        mSQL = mSQL + "    UNITUP , KDPP, NVL(UNITLUNAS,UNITUP) AS UNITUPKDPP";
        mSQL = mSQL + "    FROM DPHOFFLINE partition(" + partisi + ") a";
        mSQL = mSQL + "    WHERE ";
        mSQL = mSQL + "    KDPP  = '" + kode + "'";
        mSQL = mSQL + "    AND TGLBAYAR  >= '" + tBLTH + tanggal + "'";
        mSQL = mSQL + "    AND TGLBAYAR  <= '" + tBLTH + tanggalend + "'";
        mSQL = mSQL + "    AND TGLBATALTRANS IS NULL";
        mSQL = mSQL + "    AND kdpembpp = 'R1'";
        mSQL = mSQL + "    AND (KODEGAGAL = '0' OR KODEGAGAL IS NULL)";
        mSQL = mSQL + "    and kdgerakkeluar = '21' ";
        mSQL = mSQL + "    GROUP BY KDGERAKKELUAR,UNITUP,TGLBAYAR,KOGOL,KDPEMBPP,STATUS,KDPP,UNITLUNAS";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " Group by TGLBUKU, KOGOL,KDGERAK,KDPEMBPP,STATUS, KDPP ";
        mSQL = mSQL + " order by KDPP asc,KOGOL,TGLBUKU asc";
        return mSQL;
    }
    public String GetReport_21kdpp_21KDPP_PPTGLREKAPGOL() {
        String mSQL = " SELECT * FROM B$_RPT_21KDPP_PPTGLREKAPGOL";
        return mSQL;
    }
    public String GetReport_21kdpp_21KDPP_UNITTGLREKAP(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);

        mSQL = "SELECT SYSDATE AS TGLCETAK, TGLBUKU as TANGGAL, SUM(LEMBAR) AS LEMBAR, ";
        mSQL = mSQL + " SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, ";
        mSQL = mSQL + " SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, ";
        mSQL = mSQL + " SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, ";
        mSQL = mSQL + " SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, ";
        mSQL = mSQL + " SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, ";
        mSQL = mSQL + " SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3, ";
        mSQL = mSQL + " KDGERAK,KDPEMBPP,STATUS, UNITUP, KDPP ";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
        mSQL = mSQL + "    SELECT /*+index(a IDX_DPHOFFLINE_KDPP)*/  ";
        mSQL = mSQL + "    TGLBAYAR  AS TGLBUKU,";
        mSQL = mSQL + "    KOGOL, COUNT(idpel) AS LEMBAR,";
        mSQL = mSQL + "    SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL,   SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,   SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,   SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,   SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI,   SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,   SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
        mSQL = mSQL + "    KDGERAKKELUAR AS KDGERAK,KDPEMBPP,STATUS,";
        mSQL = mSQL + "    UNITUP , KDPP, NVL(UNITLUNAS,UNITUP) AS UNITUPKDPP";
        mSQL = mSQL + "    FROM DPHOFFLINE partition(" + partisi + ") a";
        mSQL = mSQL + "    WHERE ";
        mSQL = mSQL + "    KDPP  = '" + kode + "'";
        mSQL = mSQL + "    AND TGLBAYAR  >= '" + tBLTH + tanggal + "'";
        mSQL = mSQL + "    AND TGLBAYAR  <= '" + tBLTH + tanggalend + "'";
        mSQL = mSQL + "    AND TGLBATALTRANS IS NULL";
        mSQL = mSQL + "    AND kdpembpp = 'R1'";
        mSQL = mSQL + "    AND (KODEGAGAL = '0' OR KODEGAGAL IS NULL)";
        mSQL = mSQL + "    and kdgerakkeluar = '21' ";
        mSQL = mSQL + "    GROUP BY KDGERAKKELUAR,UNITUP,TGLBAYAR,KOGOL,KDPEMBPP,STATUS,KDPP,UNITLUNAS";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " Group by TGLBUKU, KDGERAK,KDPEMBPP,STATUS, UNITUP,  KDPP ";
        mSQL = mSQL + " order by KDPP asc,TGLBUKU asc, UNITUP asc";
        return mSQL;
    }

    public String GetReport_21kdpp_21KDPP_UNITTGLREKAP() {
        String mSQL = "SELECT * FROM B$_RPT_21KDPP_UNITTGLREKAP";
        return mSQL;
    }

    public String GetReport_21kdpp_21KDPP_UNITTGLREKAPGOL(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);

        mSQL = "SELECT SYSDATE AS TGLCETAK, TGLBUKU as TANGGAL, KOGOL, SUM(LEMBAR) AS LEMBAR, ";
        mSQL = mSQL + " SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, ";
        mSQL = mSQL + " SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, ";
        mSQL = mSQL + " SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, ";
        mSQL = mSQL + " SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, ";
        mSQL = mSQL + " SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, ";
        mSQL = mSQL + " SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3, ";
        mSQL = mSQL + " KDGERAK,KDPEMBPP,STATUS, UNITUP, KDPP ";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
        mSQL = mSQL + "    SELECT /*+index(a IDX_DPHOFFLINE_KDPP)*/  ";
        mSQL = mSQL + "    TGLBAYAR  AS TGLBUKU,";
        mSQL = mSQL + "    KOGOL, COUNT(idpel) AS LEMBAR,";
        mSQL = mSQL + "    SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL,   SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU,   SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP,   SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC,   SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI,   SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF,   SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3,";
        mSQL = mSQL + "    KDGERAKKELUAR AS KDGERAK,KDPEMBPP,STATUS,";
        mSQL = mSQL + "    UNITUP , KDPP, NVL(UNITLUNAS,UNITUP) AS UNITUPKDPP";
        mSQL = mSQL + "    FROM DPHOFFLINE partition(" + partisi + ") a";
        mSQL = mSQL + "    WHERE ";
        mSQL = mSQL + "    KDPP  = '" + kode + "'";
        mSQL = mSQL + "    AND TGLBAYAR  >= '" + tBLTH + tanggal + "'";
        mSQL = mSQL + "    AND TGLBAYAR  <= '" + tBLTH + tanggalend + "'";
        mSQL = mSQL + "    AND TGLBATALTRANS IS NULL";
        mSQL = mSQL + "    AND kdpembpp = 'R1'";
        mSQL = mSQL + "    AND (KODEGAGAL = '0' OR KODEGAGAL IS NULL)";
        mSQL = mSQL + "    and kdgerakkeluar = '21' ";
        mSQL = mSQL + "    GROUP BY KDGERAKKELUAR,UNITUP,TGLBAYAR,KOGOL,KDPEMBPP,STATUS,KDPP,UNITLUNAS";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " Group by TGLBUKU, KOGOL,KDGERAK,KDPEMBPP,STATUS, UNITUP,  KDPP ";
        mSQL = mSQL + " order by KDPP asc,TGLBUKU asc, UNITUP asc";
        return mSQL;
    }

    public String GetReport_21kdpp_21KDPP_UNITTGLREKAPGOL() {
        String mSQL = "SELECT * FROM B$_RPT_21KDPP_UNITTGLRKPGOL";
        return mSQL;
    }

    public String GetReport_21kdpp_21KDPP_PPTGLDAFTAR(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);

        //FROM VIEW_REPORT_21DAFTARREKG
        mSQL = "SELECT SYSDATE AS TGLCETAK, TANGGAL,WKTBAYAR, IDPEL, KOGOL, BLTH, ";
        mSQL = mSQL + " KDPEMBPP, STATUS, NOREK, NAMA, NAMAPNJ, ";
        mSQL = mSQL + " RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, ";
        mSQL = mSQL + " RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, ";
        mSQL = mSQL + " RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, ";
        mSQL = mSQL + " RPDISINSENTIF, RPBK1, RPBK2, RPBK3, KDGERAK, ";
        mSQL = mSQL + " UNITUP, UNITKJ, KDINKASO, KDKELOMPOK, PEMDA, ";
        mSQL = mSQL + " KDPPJ, TARIP, DAYA, KDKIRIM, ";
        mSQL = mSQL + " KDPP";
        //mSQL = mSQL + " FROM VIEW_REPORT_21DAFTARREKG"
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
        mSQL = mSQL + " SELECT /*+index(DH IDX_DPHOFFLINE_KDPP)*/ ";
        mSQL = mSQL + " DH.TGLBAYAR AS TANGGAL, WKTBAYAR,";
        mSQL = mSQL + " DH.IDPEL,  DH.KOGOL,  DH.BLTH,DH.KDPEMBPP,DH.STATUS,DH.NOREK, DIL.NAMA, DIL.NAMAPNJ,";
        mSQL = mSQL + " DH.RPTAG,DH.RPPTL,DH.RPTB, DH.RPPPN, DH.RPBPJU, DH.RPTRAFO, DH.RPSEWATRAFO, DH.RPSEWAKAP,";
        mSQL = mSQL + " DH.RPANGSA,  DH.RPANGSB, DH.RPANGSC,  DH.RPMAT, DH.RPPLN,   DH.RPREDUKSI,  DH.RPINSENTIF, DH.RPDISINSENTIF, DH.RPBK1, DH.RPBK2, DH.RPBK3,";
        mSQL = mSQL + " DH.KDGERAKKELUAR AS KDGERAK, DH.UNITUP, DH.UNITKJ, DH.KDINKASO, DH.KDKELOMPOK, DH.PEMDA,DH.KDPPJ,DH.TARIP, DH.DAYA , DH.KDKIRIM,";
        mSQL = mSQL + " NVL(DH.UNITLUNAS,DH.UNITUP) AS UNITUPKDPP , KDPP";
        mSQL = mSQL + " FROM DPHOFFLINE partition(" + partisi + ") DH ";
        mSQL = mSQL + " INNER JOIN DIL ON DH.IDPEL = DIL.IDPEL";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " DH.KDPP  = '" + kode + "'";
        mSQL = mSQL + " AND DH.TGLBAYAR  >= '" + tBLTH + tanggal + "'";
        mSQL = mSQL + " AND DH.TGLBAYAR  <= '" + tBLTH + tanggalend + "'";
        mSQL = mSQL + " AND DH.TGLBATALTRANS IS NULL";
        mSQL = mSQL + " AND DH.kdpembpp = 'R1'";
        mSQL = mSQL + " AND (DH.KODEGAGAL = '0' OR DH.KODEGAGAL IS NULL)";
        mSQL = mSQL + " and DH.kdgerakkeluar = '21' ";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " order by TANGGAL asc,WKTBAYAR asc";
        return mSQL;
    }
    public String GetReport_21kdpp_21KDPP_PPTGLDAFTAR() {
        String mSQL = "SELECT * FROM B$_RPT_21KDPP_PPTGLDAFTAR";
        return mSQL;
    }
    public String GetReport_21kdpp_21KDPP_UNITTGLDAFTAR(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);

        mSQL = "SELECT SYSDATE AS TGLCETAK, TANGGAL,WKTBAYAR, IDPEL, KOGOL, BLTH, ";
        mSQL = mSQL + " KDPEMBPP, STATUS, NOREK, NAMA, NAMAPNJ, ";
        mSQL = mSQL + " RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, ";
        mSQL = mSQL + " RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, ";
        mSQL = mSQL + " RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, ";
        mSQL = mSQL + " RPDISINSENTIF, RPBK1, RPBK2, RPBK3, KDGERAK, ";
        mSQL = mSQL + " UNITUP, UNITKJ, KDINKASO, KDKELOMPOK, PEMDA, ";
        mSQL = mSQL + " KDPPJ, TARIP, DAYA, KDKIRIM, UNITUPKDPP, ";
        mSQL = mSQL + " KDPP";
        //mSQL = mSQL + " FROM VIEW_REPORT_21DAFTARREKG"
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
        mSQL = mSQL + " SELECT /*+index(DH IDX_DPHOFFLINE_KDPP)*/ ";
        mSQL = mSQL + " DH.TGLBAYAR AS TANGGAL, WKTBAYAR,";
        mSQL = mSQL + " DH.IDPEL,  DH.KOGOL,  DH.BLTH,DH.KDPEMBPP,DH.STATUS,DH.NOREK, DIL.NAMA, DIL.NAMAPNJ,";
        mSQL = mSQL + " DH.RPTAG,DH.RPPTL,DH.RPTB, DH.RPPPN, DH.RPBPJU, DH.RPTRAFO, DH.RPSEWATRAFO, DH.RPSEWAKAP,";
        mSQL = mSQL + " DH.RPANGSA,  DH.RPANGSB, DH.RPANGSC,  DH.RPMAT, DH.RPPLN,   DH.RPREDUKSI,  DH.RPINSENTIF, DH.RPDISINSENTIF, DH.RPBK1, DH.RPBK2, DH.RPBK3,";
        mSQL = mSQL + " DH.KDGERAKKELUAR AS KDGERAK, DH.UNITUP, DH.UNITKJ, DH.KDINKASO, DH.KDKELOMPOK, DH.PEMDA,DH.KDPPJ,DH.TARIP, DH.DAYA , DH.KDKIRIM,";
        mSQL = mSQL + " NVL(DH.UNITLUNAS,DH.UNITUP) AS UNITUPKDPP , KDPP";
        mSQL = mSQL + " FROM DPHOFFLINE partition(" + partisi + ") DH ";
        mSQL = mSQL + " INNER JOIN DIL ON DH.IDPEL = DIL.IDPEL";
        mSQL = mSQL + " WHERE ";
        mSQL = mSQL + " DH.KDPP  = '" + kode + "'";
        mSQL = mSQL + " AND DH.TGLBAYAR  >= '" + tBLTH + tanggal + "'";
        mSQL = mSQL + " AND DH.TGLBAYAR  <= '" + tBLTH + tanggalend + "'";
        mSQL = mSQL + " AND DH.TGLBATALTRANS IS NULL";
        mSQL = mSQL + " AND DH.kdpembpp = 'R1'";
        mSQL = mSQL + " AND (DH.KODEGAGAL = '0' OR DH.KODEGAGAL IS NULL)";
        mSQL = mSQL + " and DH.kdgerakkeluar = '21' ";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " order by TANGGAL asc,WKTBAYAR asc";
        return mSQL;

    }

    public String GetReport_21kdpp_21KDPP_UNITTGLDAFTAR() {
        String mSQL = "select * from B$_RPT_21KDPP_UNITTGLDAFTAR";
        return mSQL;
    }

    public String getReport_21rekap_VIEW_REPORT_21KDPP(String tindex, String tpartisi, String twhere) {
        String sql = "";
        sql = "   SELECT  ";
        sql = sql + tindex;
        sql = sql + "   TGLBUKU,  ";
        sql = sql + "   KOGOL,  ";
        sql = sql + "   SUM(GERAK*LEMBAR) AS LEMBAR,  ";
        sql = sql + "   SUM(GERAK*RPTAG) AS RPTAG,  ";
        sql = sql + "   SUM(GERAK*RPPTL) AS RPPTL,  ";
        sql = sql + "   SUM(GERAK*RPTB) AS RPTB,  ";
        sql = sql + "   SUM(GERAK*RPPPN) AS RPPPN,  ";
        sql = sql + "   SUM(GERAK*RPBPJU) AS RPBPJU,  ";
        sql = sql + "   SUM(GERAK*RPTRAFO) AS RPTRAFO,  ";
        sql = sql + "   SUM(GERAK*RPSEWATRAFO) AS RPSEWATRAFO,  ";
        sql = sql + "   SUM(GERAK*RPSEWAKAP) AS RPSEWAKAP,  ";
        sql = sql + "   SUM(GERAK*RPANGSA) AS RPANGSA,  ";
        sql = sql + "   SUM(GERAK*RPANGSB) AS RPANGSB,  ";
        sql = sql + "   SUM(GERAK*RPANGSC) AS RPANGSC,  ";
        sql = sql + "   SUM(GERAK*RPMAT) AS RPMAT,  ";
        sql = sql + "   SUM(GERAK*RPPLN) AS RPPLN,  ";
        sql = sql + "   SUM(GERAK*RPREDUKSI) AS RPREDUKSI,  ";
        sql = sql + "   SUM(GERAK*RPINSENTIF) AS RPINSENTIF,  ";
        sql = sql + "   SUM(GERAK*RPDISINSENTIF) AS RPDISINSENTIF,  ";
        sql = sql + "   SUM(GERAK*RPBK1) AS RPBK1,  ";
        sql = sql + "   SUM(GERAK*RPBK2) AS RPBK2,  ";
        sql = sql + "   SUM(GERAK*RPBK3) AS RPBK3,  ";
        sql = sql + "   KDGERAK,KDPEMBPP,STATUS,UNITUP,UNITUPKDPP, KDPP  ";
        sql = sql + "   FROM rekapDPHOFFLINEkdpp  ";
        sql = sql + tpartisi;
        sql = sql + " ";
        sql = sql + twhere;
        sql = sql + "   GROUP BY KDGERAK,UNITUP,TGLBUKU,KOGOL,KDPEMBPP,STATUS,UNITUPKDPP, KDPP  ";

        return sql;
    }
    //End Region
//        '=========================================================================
//        'Public=========================================================================

    public String GetReport_21uploadkdpp(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode) {
        String mSQL = "";
        if ( vJenis.toUpperCase() == "21UPLOAD_REKAP" ) {
            mSQL = GetReport_21uploadkdpp_21UPLOAD_REKAP(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode);
        } else if ( vJenis.toUpperCase() == "21UPLOAD_DAFTARBERHASIL" ) {
            mSQL = GetReport_21uploadkdpp_21UPLOAD_DAFTARBERHASIL(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode);
        } else if ( vJenis.toUpperCase() == "21UPLOAD_DAFTARGAGAL" ) {
            mSQL = GetReport_21uploadkdpp_21UPLOAD_DAFTARGAGAL(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode);
        } else if ( vJenis.toUpperCase() == "21UPLOAD_DOUBLEREKAP" ) {
            mSQL = GetReport_21uploadkdpp_21UPLOAD_DOUBLEREKAP(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode);
        } else if ( vJenis.toUpperCase() == "21UPLOAD_DOUBLEDAFTAR" ) {
            mSQL = GetReport_21uploadkdpp_21UPLOAD_DOUBLEDAFTAR(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode);
        }

        return mSQL;

    }
    //Region "21uploadKDPP"

    public String GetReport_21uploadkdpp_21UPLOAD_REKAP(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode) {
        String sql = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);

        sql = "          select sysdate as tglcetak, tglbayar as tanggal, kdpp, lembar, rptagihan,  ";
        sql = sql + "         rpbk, lembar_lunas, rptagihan_lunas, rpbk_lunas, lembar_gagallunas,  ";
        sql = sql + "         rptagihan_gagallunas, rpbk_gagallunas ";
        sql = sql + "         from ( ";
        sql = sql + "		  select ";
        sql = sql + "          tglbayar, kdpp, sum(lembar) as lembar, sum(rptagihan) as rptagihan, ";
        sql = sql + "          sum(rpbk) as rpbk, sum(lembar_lunas) as lembar_lunas, sum(rptagihan_lunas) as rptagihan_lunas, ";
        sql = sql + "          sum(rpbk_lunas) as rpbk_lunas, sum(lembar_gagallunas) as lembar_gagallunas, ";
        sql = sql + "          sum(rptagihan_gagallunas) as rptagihan_gagallunas, sum(rpbk_gagallunas) as rpbk_gagallunas ";
        sql = sql + "          from ";
        sql = sql + "          ( ";
        sql = sql + "       select /*+index(c idx_dphoffline_kdpp)*/      ";
        sql = sql + "            		tglbayar,  ";
        sql = sql + "            		kdpp,  ";
        sql = sql + "            		count(idpel) as lembar,  ";
        sql = sql + "            		sum(rptag) as rptagihan,  ";
        sql = sql + "            		sum(rpbk1+rpbk2+rpbk3) as rpbk,  ";
        sql = sql + "            		decode(kodegagal,'0',count(idpel),0) as lembar_lunas,  ";
        sql = sql + "            		decode(kodegagal,'0',sum(rptag),0) as rptagihan_lunas,  ";
        sql = sql + "            		decode(kodegagal,'0',sum(rpbk1+rpbk2+rpbk3),0) as rpbk_lunas,  ";
        sql = sql + "            		decode(kodegagal,'0',0, count(idpel)) as lembar_gagallunas,  ";
        sql = sql + "            		decode(kodegagal,'0',0, sum(rptag)) as rptagihan_gagallunas,  ";
        sql = sql + "            		decode(kodegagal,'0',0, sum(rpbk1+rpbk2+rpbk3)) as rpbk_gagallunas  ";
        sql = sql + "            		from  dphoffline partition(" + partisi + ") c ";
        sql = sql + "					where   ";
        sql = sql + "                    kdpp  = '" + kode + "' ";
        sql = sql + "                    and tglpelunasan  >= to_date('" + tBLTH + tanggal + "','yyyymmdd')  ";
        sql = sql + "                    and tglpelunasan  < (to_date('" + tBLTH + tanggalend + "','yyyymmdd')+1) ";
        sql = sql + "                    and kdkirim = 'U' and tglbataltrans is null and kodegagal is not null ";
        sql = sql + "            	    group by kdpp,tglbayar,kodegagal ";
        sql = sql + "         ) a ";
        sql = sql + "         group by tglbayar, kdpp ";
        sql = sql + "		 ) b ";
        sql = sql + "         order by kdpp asc,tglbayar asc ";

        return sql;
    }
    public String GetReport_21uploadkdpp_21UPLOAD_DAFTARBERHASIL(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);
        //FROM(VIEW_REPORT_21UPLOAD_LUNASDPP)
        mSQL = "SELECT SYSDATE AS TGLCETAK, TANGGAL, WKTBAYAR, KDPP, IDPEL, ";
        mSQL = mSQL + " BLTH, NOREK, TGLTRANSAKSI, RPTAG, RPBK, ";
        mSQL = mSQL + " RPBK_DPP, KODEGAGAL";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
        mSQL = mSQL + "	        SELECT /*+index(c IDX_DPHOFFLINE_KDPP)*/ ";
        mSQL = mSQL + "			TGLBAYAR AS TANGGAL,WKTBAYAR,";
        mSQL = mSQL + "	        KDPP,";
        mSQL = mSQL + "			IDPEL,";
        mSQL = mSQL + "			BLTH,NOREK,";
        mSQL = mSQL + "			TGLTRANSAKSI,";
        mSQL = mSQL + "			RpTag,";
        mSQL = mSQL + "			(RpBK1+RPBK2+RPBK3) AS RpBK,";
        mSQL = mSQL + "			(RpBK1_DPP+RPBK2_DPP+RPBK3_DPP) AS RpBK_DPP,";
        mSQL = mSQL + "	        KODEGAGAL";
        mSQL = mSQL + "			FROM  DPHOFFLINE  partition(" + partisi + ") c";
        mSQL = mSQL + "	       WHERE";
        mSQL = mSQL + "        KDPP  = '" + kode + "'";
        mSQL = mSQL + "        AND TGLBAYAR  >= '" + tBLTH + tanggal + "'";
        mSQL = mSQL + "        AND TGLBAYAR  <= '" + tBLTH + tanggalend + "'";
        mSQL = mSQL + "        and KODEGAGAL = '0'  AND  kdkirim = 'U' AND tglbataltrans IS NULL		";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " order by TANGGAL asc,WKTBAYAR asc";
        return mSQL;
    }
    public String GetReport_21uploadkdpp_21UPLOAD_DAFTARGAGAL(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);
        //FROM VIEW_REPORT_21UPLOAD_GAGALDPP
        mSQL = "SELECT SYSDATE AS TGLCETAK, TANGGAL, WKTBAYAR, KDPP, IDPEL, ";
        mSQL = mSQL + " BLTH, NOREK, TGLTRANSAKSI, RPTAG, RPBK, ";
        mSQL = mSQL + " RPBK_DPP, KODEGAGAL, KDGERAKKELUAR_DPP, TGLBAYAR_DPP, KDPP_DPP";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
        mSQL = mSQL + "	        SELECT /*+index(c IDX_DPHOFFLINE_KDPP)*/ ";
        mSQL = mSQL + "			TGLBAYAR AS TANGGAL,WKTBAYAR,";
        mSQL = mSQL + "	        KDPP,";
        mSQL = mSQL + "			IDPEL,";
        mSQL = mSQL + "			BLTH,NOREK,";
        mSQL = mSQL + "			TGLTRANSAKSI,";
        mSQL = mSQL + "			RpTag,";
        mSQL = mSQL + "			(RpBK1+RPBK2+RPBK3) AS RpBK,";
        mSQL = mSQL + "			(RpBK1_DPP+RPBK2_DPP+RPBK3_DPP) AS RpBK_DPP,";
        mSQL = mSQL + "	        KODEGAGAL,";
        mSQL = mSQL + "		    KDGERAKKELUAR_DPP,TGLBAYAR_DPP,KDPP_DPP";
        mSQL = mSQL + "			FROM  DPHOFFLINE   partition(" + partisi + ") c";
        mSQL = mSQL + "	       WHERE";
        mSQL = mSQL + "        KDPP  = '" + kode + "'";
        mSQL = mSQL + "        AND TGLBAYAR  >= '" + tBLTH + tanggal + "'";
        mSQL = mSQL + "        AND TGLBAYAR  <= '" + tBLTH + tanggalend + "'";
        mSQL = mSQL + "        and KODEGAGAL != '0'  AND  kdkirim = 'U' AND tglbataltrans IS NULL		";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " order by TANGGAL asc,WKTBAYAR asc";
        return mSQL;
    }

    public String GetReport_21uploadkdpp_21UPLOAD_DOUBLEREKAP(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode) {
        String sql = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);

        sql = "   SELECT ";
        sql = sql + "  SYSDATE AS TGLCetak, ";
        sql = sql + "  TGLBAYAR AS TANGGAL, ";
        sql = sql + "  KDPP, COUNT(IDPel) AS LEMBAR, SUM(RpTag) AS RPTAGIHAN, ";
        sql = sql + "  SUM(RpBK1+RPBK2+RPBK3) AS RPBK ";
        sql = sql + "  FROM  DPHOFFLINE_DOUBLEUPLOAD ";
        sql = sql + "  WHERE ";
        sql = sql + "  TGLBAYAR  >= '" + tBLTH + tanggal + "'";
        sql = sql + "  AND TGLBAYAR  <= '" + tBLTH + tanggalend + "'";
        sql = sql + "  AND KDPP  = '" + kode + "'";
        sql = sql + "  GROUP BY ";
        sql = sql + "  TGLBAYAR , KdPP ";
        sql = sql + "  order by KDPP asc,TGLBAYAR asc";
        return sql;
    }
    public String GetReport_21uploadkdpp_21UPLOAD_DOUBLEDAFTAR(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode) {
        String sql = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);

        sql = " SELECT ";
        sql = sql + "		SYSDATE AS TGLCetak, ";
        sql = sql + "		TGLBAYAR AS TANGGAL,WKTBAYAR, ";
        sql = sql + "       KDPP, ";
        sql = sql + "		IDPEL, ";
        sql = sql + "		BLTH,NOREK, ";
        sql = sql + "		TGLCATAT,CATATBY, ";
        sql = sql + "		RpTag, ";
        sql = sql + "		(RpBK1+RPBK2+RPBK3) AS RpBK ";
        sql = sql + "		FROM  DPHOFFLINE_DOUBLEUPLOAD ";
        sql = sql + "		WHERE ";
        sql = sql + "		TGLBAYAR  >= '" + tBLTH + tanggal + "'";
        sql = sql + "		AND TGLBAYAR  <= '" + tBLTH + tanggalend + "'";
        sql = sql + "		AND KDPP  = '" + kode + "'";
        sql = sql + "		 order by TGLBAYAR asc,WKTBAYAR asc";

        return sql;

    }
    //End Region
//        '=========================================================================
//        'Public=========================================================================
    public String GetReport_21uploadunitup(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend) {
        String mSQL = "";
        if (vJenis.toUpperCase() == "21UPLOAD_REKAP" ) {
            mSQL = GetReport_21uploadunitup_21UPLOAD_REKAP(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend);

        } else if ( vJenis.toUpperCase() == "21UPLOAD_DAFTARBERHASIL" ) {
            mSQL = GetReport_21uploadunitup_21UPLOAD_DAFTARBERHASIL(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend);

        } else if ( vJenis.toUpperCase() == "21UPLOAD_DAFTARGAGAL" ) {
            mSQL = GetReport_21uploadunitup_21UPLOAD_DAFTARGAGAL(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend);

        } else if ( vJenis.toUpperCase() == "21UPLOAD_DOUBLEREKAP" ) {
            mSQL = GetReport_21uploadunitup_21UPLOAD_DOUBLEREKAP(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend);

        } else if ( vJenis.toUpperCase() == "21UPLOAD_DOUBLEDAFTAR" ) {
            mSQL = GetReport_21uploadunitup_21UPLOAD_DOUBLEDAFTAR(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend);

        }

        return mSQL;

    }
    //Region "21uploadunitup"

    public String GetReport_21uploadunitup_21UPLOAD_REKAP(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend) {
        String sql = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);
        sql = "          select sysdate as tglcetak, tglbayar as tanggal, UNITUP, lembar, rptagihan,  ";
        sql = sql + "         rpbk, lembar_lunas, rptagihan_lunas, rpbk_lunas, lembar_gagallunas,  ";
        sql = sql + "         rptagihan_gagallunas, rpbk_gagallunas ";
        sql = sql + "         from ( ";
        sql = sql + "		  select ";
        sql = sql + "          tglbayar, UNITUP, sum(lembar) as lembar, sum(rptagihan) as rptagihan, ";
        sql = sql + "          sum(rpbk) as rpbk, sum(lembar_lunas) as lembar_lunas, sum(rptagihan_lunas) as rptagihan_lunas, ";
        sql = sql + "          sum(rpbk_lunas) as rpbk_lunas, sum(lembar_gagallunas) as lembar_gagallunas, ";
        sql = sql + "          sum(rptagihan_gagallunas) as rptagihan_gagallunas, sum(rpbk_gagallunas) as rpbk_gagallunas ";
        sql = sql + "          from ";
        sql = sql + "          ( ";
        sql = sql + "       select /*+index(c idx_dphoffline_02)*/      ";
        sql = sql + "            		tglbayar,  ";
        sql = sql + "            		UNITUP,  ";
        sql = sql + "            		count(idpel) as lembar,  ";
        sql = sql + "            		sum(rptag) as rptagihan,  ";
        sql = sql + "            		sum(rpbk1+rpbk2+rpbk3) as rpbk,  ";
        sql = sql + "            		decode(kodegagal,'0',count(idpel),0) as lembar_lunas,  ";
        sql = sql + "            		decode(kodegagal,'0',sum(rptag),0) as rptagihan_lunas,  ";
        sql = sql + "            		decode(kodegagal,'0',sum(rpbk1+rpbk2+rpbk3),0) as rpbk_lunas,  ";
        sql = sql + "            		decode(kodegagal,'0',0, count(idpel)) as lembar_gagallunas,  ";
        sql = sql + "            		decode(kodegagal,'0',0, sum(rptag)) as rptagihan_gagallunas,  ";
        sql = sql + "            		decode(kodegagal,'0',0, sum(rpbk1+rpbk2+rpbk3)) as rpbk_gagallunas  ";
        sql = sql + "            		from  dphoffline partition(" + partisi + ") c ";
        sql = sql + "					where   ";
        sql = sql + "                    UNITUP  = '" + tparUp + "' ";
        sql = sql + "                    and tglbayar  >= '" + tBLTH + tanggal + "' ";
        sql = sql + "                    and tglbayar  <= '" + tBLTH + tanggalend + "' ";
        sql = sql + "                    and tglpelunasan  >= to_date('" + tBLTH + tanggal + "','yyyymmdd')  ";
        sql = sql + "                    and tglpelunasan  < (to_date('" + tBLTH + tanggalend + "','yyyymmdd')+1) ";
        sql = sql + "                    and kdkirim = 'U' and tglbataltrans is null and kodegagal is not null ";
        sql = sql + "            	    group by UNITUP,tglbayar,kodegagal ";
        sql = sql + "         ) a ";
        sql = sql + "         group by tglbayar, UNITUP ";
        sql = sql + "		 ) b ";
        sql = sql + "         order by UNITUP asc,tglbayar asc ";

        return sql;
    }

    public String GetReport_21uploadunitup_21UPLOAD_DAFTARBERHASIL(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);

        mSQL = "SELECT SYSDATE AS TGLCETAK, TGLBAYAR as TANGGAL, WKTBAYAR, UNITUP, KDPP,IDPEL, ";
        mSQL = mSQL + " BLTH, NOREK, TGLTRANSAKSI, RPTAG, RPBK, ";
        mSQL = mSQL + " RPBK_DPP, KODEGAGAL";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
        mSQL = mSQL + "	        SELECT /*+index(c idx_dphoffline_02)*/ ";
        mSQL = mSQL + "			TGLBAYAR,WKTBAYAR,";
        mSQL = mSQL + "	        UNITUP,KDPP,";
        mSQL = mSQL + "			IDPEL,";
        mSQL = mSQL + "			BLTH,NOREK,";
        mSQL = mSQL + "			TGLTRANSAKSI,";
        mSQL = mSQL + "			RpTag,";
        mSQL = mSQL + "			(RpBK1+RPBK2+RPBK3) AS RpBK,";
        mSQL = mSQL + "			(RpBK1_DPP+RPBK2_DPP+RPBK3_DPP) AS RpBK_DPP,";
        mSQL = mSQL + "	        KODEGAGAL";
        mSQL = mSQL + "			FROM  DPHOFFLINE  partition(" + partisi + ") c";
        mSQL = mSQL + "	       WHERE";
        mSQL = mSQL + "        UNITUP  = '" + tparUp + "'";
        mSQL = mSQL + "        AND TGLBAYAR  >= '" + tBLTH + tanggal + "'";
        mSQL = mSQL + "        AND TGLBAYAR  <= '" + tBLTH + tanggalend + "'";
        mSQL = mSQL + "        and KODEGAGAL = '0'  AND  kdkirim = 'U' AND tglbataltrans IS NULL		";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " order by TGLBAYAR asc,WKTBAYAR asc";
        return mSQL;
    }
    public String GetReport_21uploadunitup_21UPLOAD_DAFTARGAGAL(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);

        mSQL = "SELECT SYSDATE AS TGLCETAK, TGLBAYAR as TANGGAL, WKTBAYAR, UNITUP,KDPP, IDPEL, ";
        mSQL = mSQL + " BLTH, NOREK, TGLTRANSAKSI, RPTAG, RPBK, ";
        mSQL = mSQL + " RPBK_DPP, KODEGAGAL, KDGERAKKELUAR_DPP, TGLBAYAR_DPP, KDPP_DPP";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
        mSQL = mSQL + "	        SELECT /*+index(c idx_dphoffline_02)*/ ";
        mSQL = mSQL + "			TGLBAYAR,WKTBAYAR,";
        mSQL = mSQL + "	        UNITUP,KDPP,";
        mSQL = mSQL + "			IDPEL,";
        mSQL = mSQL + "			BLTH,NOREK,";
        mSQL = mSQL + "			TGLTRANSAKSI,";
        mSQL = mSQL + "			RpTag,";
        mSQL = mSQL + "			(RpBK1+RPBK2+RPBK3) AS RpBK,";
        mSQL = mSQL + "			(RpBK1_DPP+RPBK2_DPP+RPBK3_DPP) AS RpBK_DPP,";
        mSQL = mSQL + "	        KODEGAGAL,";
        mSQL = mSQL + "		    KDGERAKKELUAR_DPP,TGLBAYAR_DPP,KDPP_DPP";
        mSQL = mSQL + "			FROM  DPHOFFLINE  partition(" + partisi + ") c";
        mSQL = mSQL + "	       WHERE";
        mSQL = mSQL + "        UNITUP  = '" + tparUp + "'";
        mSQL = mSQL + "        AND TGLBAYAR  >= '" + tBLTH + tanggal + "'";
        mSQL = mSQL + "        AND TGLBAYAR  <= '" + tBLTH + tanggalend + "'";
        mSQL = mSQL + "        and KODEGAGAL != '0'  AND  kdkirim = 'U' AND tglbataltrans IS NULL		";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " order by TGLBAYAR asc,WKTBAYAR asc";

        return mSQL;
    }

    public String GetReport_21uploadunitup_21UPLOAD_DOUBLEREKAP(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);

        mSQL = "SELECT SYSDATE AS TGLCetak, TGLBAYAR AS TANGGAL, UNITUP,LEMBAR, RPTAGIHAN, ";
        mSQL = mSQL + " RPBK";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
        mSQL = mSQL + "	        SELECT 	";
        mSQL = mSQL + "	 		TGLBAYAR ,UNITUP,  COUNT(IDPel) AS LEMBAR, SUM(RpTag) AS RPTAGIHAN,  SUM(RpBK1+RPBK2+RPBK3) AS RPBK";
        mSQL = mSQL + "	 		FROM  DPHOFFLINE_DOUBLEUPLOAD";
        mSQL = mSQL + "         WHERE ";
        mSQL = mSQL + "         TGLBAYAR  >= '" + tBLTH + tanggal + "'";
        mSQL = mSQL + "         AND TGLBAYAR  <= '" + tBLTH + tanggalend + "'";
        mSQL = mSQL + "         AND UNITUP  = '" + tparUp + "'";
        mSQL = mSQL + "	 	    GROUP BY UNITUP, TGLBAYAR ";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " order by UNITUP asc,TGLBAYAR asc";
        return mSQL;
    }
    public String GetReport_21uploadunitup_21UPLOAD_DOUBLEDAFTAR(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend) {
        String mSQL = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);

        mSQL = "SELECT SYSDATE AS TGLCetak, TGLBAYAR AS TANGGAL, WKTBAYAR, UNITUP, KDPP,IDPEL, ";
        mSQL = mSQL + " BLTH, NOREK, TGLCATAT, CATATBY, RPTAG, ";
        mSQL = mSQL + " RPBK";
        mSQL = mSQL + " from (";
        mSQL = mSQL + " ";
        mSQL = mSQL + "	        SELECT  TGLBAYAR ,WKTBAYAR,";
        mSQL = mSQL + "	        UNITUP,KDPP,IDPEL, BLTH,NOREK,	TGLCATAT,CATATBY,RpTag,(RpBK1+RPBK2+RPBK3) AS RpBK";
        mSQL = mSQL + "			FROM  DPHOFFLINE_DOUBLEUPLOAD";
        mSQL = mSQL + "         WHERE ";
        mSQL = mSQL + "         TGLBAYAR  >= '" + tBLTH + tanggal + "'";
        mSQL = mSQL + "         AND TGLBAYAR  <= '" + tBLTH + tanggalend + "'";
        mSQL = mSQL + "         AND UNITUP  = '" + tparUp + "'";
        mSQL = mSQL + " ) b";
        mSQL = mSQL + " ";
        mSQL = mSQL + " order by TGLBAYAR asc,WKTBAYAR asc";

        return mSQL;

    }
    //End Region
//        '=========================================================================
//        'Public=========================================================================
    public String GetReport_21Giral_Kode(String tBLTH, String tPetugas, String kode) {
        String sql = "";
        sql = "  select sysdate as tglcetak, blth, idpel, nama, kdgerakmasuk, kdgerakkeluar, tglbayar, wktbayar, kdpp, kdpembayar, status, kdpembpp, kdpembayarsip3, unitup, pemda, tarip, daya, kogol, subkogol, kdppj, unitkj, kdinkaso, kdkelompok, rpptl, rptb, rpppn, rpbpju, rptrafo, rpsewatrafo, rpsewakap, rpangsa, rpangsb, rpangsc, rpmat, rppln, rptag, rpreduksi, rpinsentif, rpdisinsentif, rpbk1, rpbk2, rpbk3, rpselisih, norek, noagenda, flagsopp, flaganja, kdkirim  ";
        sql = sql + " from  ";
        sql = sql + " (  ";
        sql = sql + "     select  ";
        sql = sql + " 	  blth, a.idpel, a.nama, kdgerakmasuk, kdgerakkeluar, tglbayar, wktbayar, kdpp, kdpembayar, status, kdpembpp, kdpembayarsip3, a.unitup, a.pemda, a.tarip, a.daya, a.kogol, a.subkogol, a.kdppj, a.unitkj, a.kdinkaso, a.kdkelompok, rpptl, rptb, rpppn, rpbpju, rptrafo, rpsewatrafo, rpsewakap, rpangsa, rpangsb, rpangsc, rpmat, rppln, rptag, rpreduksi, rpinsentif, rpdisinsentif, rpbk1, rpbk2, rpbk3, rpselisih, norek, noagenda, flagsopp, flaganja, kdkirim  ";
        sql = sql + "     from dpp partition(saldo) a, kolektif21giralisasi b  ";
        sql = sql + "     where a.idpel = b.idpel  ";
        sql = sql + "     and b.kodekolektif = '" + kode + "'";
        sql = sql + "     and a.blth = '" + tBLTH + "'";
        sql = sql + "     and a.kdgerakkeluar is null  ";
        sql = sql + "     and a.status = 'L'  ";
        sql = sql + "     and a.kdpembpp = 'R1'  ";
        sql = sql + "     union all  ";
        sql = sql + "     select /*+index(a idx_dphoffline_kdpp)*/  ";
        sql = sql + " 	  blth, a.idpel, c.nama, kdgerakmasuk, kdgerakkeluar, tglbayar, wktbayar, kdpp, kdpembayar, status, kdpembpp, kdpembayarsip3, a.unitup, a.pemda, a.tarip, a.daya, a.kogol, a.subkogol, a.kdppj, a.unitkj, a.kdinkaso, a.kdkelompok, rpptl, rptb, rpppn, rpbpju, rptrafo, rpsewatrafo, rpsewakap, rpangsa, rpangsb, rpangsc, rpmat, rppln, rptag, rpreduksi, rpinsentif, rpdisinsentif, rpbk1, rpbk2, rpbk3, rpselisih, norek, noagenda, flagsopp, flaganja, kdkirim  ";
        sql = sql + "     from dphoffline a, dil c  ";
        sql = sql + "     where  ";
        sql = sql + "     a.idpel = c.idpel  ";
        sql = sql + "     and a.kdpp = '" + kode + "'";
        sql = sql + "     and a.blth = '" + tBLTH + "'";
        sql = sql + "     and a.kdpembpp = 'R1'  ";
        sql = sql + "     and a.kdgerakkeluar = '21'  ";
        sql = sql + "     and a.tglbataltrans is null  ";
        sql = sql + " )  ";

        return sql;

    }
//        '=========================================================================
//        'Public=========================================================================
    public String GetReport_21_BA(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode, String pengelola) {
        String sql = "";
        if ( vJenis.toUpperCase() == "21BA" ) {
        sql = GetReport_21_BA_21BA(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode, pengelola);

        } else if ( vJenis.toUpperCase() == "21REKAPLUNASOFFLINE" ) {
        sql = GetReport_21_BA_21REKAPLUNASOFFLINE(vJenis, tBLTH, tparUp, tPetugas, tanggal, tanggalend, kode, pengelola);

        }
        return sql;
    }

    public String GetReport_21_BA_21BA(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode, String pengelola) {
        String sql = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);

        if ( !pengelola.toUpperCase().equals("SEMUA") && !pengelola.trim().equals("") ) {
            sql = " SELECT * ";
            sql = sql + " FROM VIEW_REPORT_21_BA_OFFLINE ";
            sql = sql + "   WHERE  ";
            sql = sql + "   PENGELOLA  = Rtrim()(Ltrim()('" + pengelola + " ')) ";
        } else {
            sql = " SELECT  TGLLUNAS, TGLBAYAR, KOGOL,  ";
            sql = sql + "		SUM(LBR_LCR) AS LBR_LCR ,  ";
            sql = sql + "		SUM(LBR_TGK) AS LBR_TGK,  ";
            sql = sql + "		SUM(LBR_ROAMING) AS LBR_ROAMING,  ";
            sql = sql + "		SUM(LBR_DIROAMING) AS LBR_DIROAMING,  ";
            sql = sql + "		SUM(RP_LCR) AS RP_LCR,  ";
            sql = sql + "		SUM(RP_TGK) AS RP_TGK,  ";
            sql = sql + "		SUM(RP_ROAMING) AS RP_ROAMING,  ";
            sql = sql + "		SUM(RP_DIROAMING) AS RP_DIROAMING ";
            sql = sql + "FROM VIEW_REPORT_21_BA_OFFLINE ";
            sql = sql + "GROUP BY TGLLUNAS, TGLBAYAR, KOGOL ";
        }
        return sql;
    }
    public String GetReport_21_BA_21REKAPLUNASOFFLINE(String vJenis, String tBLTH, String tparUp, String tPetugas, String tanggal, String tanggalend, String kode, String pengelola) {
        String sql = "";
        String partisi = "";
        partisi = "lunas_" + tBLTH.substring(0, 4) + "_" + tBLTH.substring(4, 2);

        if ( !pengelola.toUpperCase().equals("SEMUA") && !pengelola.trim().equals("") ) {
            sql = " SELECT * ";
            sql += " FROM VIEW_REPORT21_REKAPTOTLNS ";
            sql += "   WHERE PENGELOLA  = Rtrim()(Ltrim()('" + pengelola + " ')) ";
            sql += " ORDER BY NOMOR,KOGOL,TGLLUNAS";
        } else {
            sql = " SELECT JNSLUNAS, TGLLUNAS, KOGOL, TGLBAYAR, NOMOR,  ";
            sql = sql + "	   SUM(LEMBAR) AS LEMBAR,  ";
            sql = sql + "	   SUM(RPMAT) AS RPMAT,  ";
            sql = sql + "	   SUM(RPPPJ) AS RPPPJ,  ";
            sql = sql + "	   SUM(RPPPN) AS RPPPN,  ";
            sql = sql + "	   SUM(RPANG) AS RPANG,  ";
            sql = sql + "	   SUM(RPSEWAKAPTRF) AS RPSEWAKAPTRF,  ";
            sql = sql + "	   SUM(RPBK) AS RPBK,  ";
            sql = sql + "	   SUM(RPPTL) AS RPPTL,  ";
            sql = sql + "	   SUM(RPTAG) AS RPTAG ";
            sql = sql + "FROM VIEW_REPORT21_REKAPTOTLNS ";
            sql = sql + "GROUP BY JNSLUNAS, TGLLUNAS, KOGOL, TGLBAYAR, NOMOR ";
            sql = sql + " ORDER BY NOMOR,KOGOL,TGLLUNAS";
        }

        return sql;
    }

//        '=========================================================================
//        '=========================================================================
    //End Region 'clsReport_Transaksi.vb'

    //Region "clsPemantauanTransaksi.vb"
//        '=========================================================================
//        'Public=========================================================================
    public String GetViewRekap_21(String vJenis, String vPilihTgl, String tUnitKJ, String tUnitUP, String tUnitAP, String tTglmulai, String tTglsampai, String tkode) {
        String mSQL = "";

        if ( vJenis.toUpperCase() == "DAFTAR" ) {
            if ( vPilihTgl.toUpperCase() == "PEMBUKUAN" ) {
                mSQL = GetViewRekap_21_DAFTAR_PEMBUKUAN(vJenis, vPilihTgl, tUnitKJ, tUnitUP, tUnitAP, tTglmulai, tTglsampai, tkode);
            } else if ( vPilihTgl.toUpperCase() == "TRANSAKSI" ) {
                mSQL = GetViewRekap_21_DAFTAR_TRANSAKSI(vJenis, vPilihTgl, tUnitKJ, tUnitUP, tUnitAP, tTglmulai, tTglsampai, tkode);
            }
        } else if ( vJenis.toUpperCase() == "REKAP" ) {
            if ( vPilihTgl.toUpperCase() == "PEMBUKUAN" ) {
                mSQL = GetViewRekap_21_REKAP_PEMBUKUAN(vJenis, vPilihTgl, tUnitKJ, tUnitUP, tUnitAP, tTglmulai, tTglsampai, tkode);
            } else if ( vPilihTgl.toUpperCase() == "TRANSAKSI" ) {
                mSQL = GetViewRekap_21_REKAP_TRANSAKSI(vJenis, vPilihTgl, tUnitKJ, tUnitUP, tUnitAP, tTglmulai, tTglsampai, tkode);
            }
        }

        return mSQL;
    }

    public String GetViewRekap_21_DAFTAR_PEMBUKUAN(String vJenis, String vPilihTgl, String tUnitKJ, String tUnitUP, String tUnitAP, String tTglmulai, String tTglsampai, String tkode) {
        String mSQL = "", sql = "";
        String partisi = "";
        partisi = "lunas_" + tTglmulai.substring(0, 4) + "_" + tTglmulai.substring(4, 2);
        tTglsampai = tTglmulai.substring(0, 6) + tTglsampai.substring(6, 2);

        //FROM VIEW_PANTAU_21_DFT_T
        mSQL = "SELECT ' ' AS NOMOR, sysdate as TGLCETAK,";
        mSQL = mSQL + "  TANGGAL, TGLBUKU, IDPEL, WKTLNS , KDPP, PETUGAS, KDGERAK, KOGOL, UNITUP, KDKELOMPOK, TARIP, DAYA, BLTH, KDPEMBPP, STATUS, NOREK, UNITKJ, KDINKASO, PEMDA, KDPPJ, KODE";
        mSQL = mSQL + "  ,RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3";
        mSQL = mSQL + " FROM ( ";
        mSQL = mSQL + " ";
        sql = mSQL + "      select /*+index(a idx_dphoffline_02)*/ ";
        sql = sql + "       to_char(tgltransaksi,'YYYYMMDD') as tanggal, tglbayar as tglbuku, idpel, ";
        sql = sql + "       wktbayar as wktlns , kdpp,kdpembayar as  petugas, ";
        sql = sql + "       kdgerakkeluar as  kdgerak, kogol, unitup, kdkelompok, ";
        sql = sql + "       tarip, daya, blth, kdpembpp, status, norek, ";
        sql = sql + "       unitkj, kdinkaso, pemda, kdppj, kdkirim as kode, ";
        sql = sql + "       rptag,rpptl,rptb, rpppn, rpbpju, rptrafo, rpsewatrafo, rpsewakap, rpangsa,  rpangsb, rpangsc, rpmat, rppln,   rpreduksi, rpinsentif, rpdisinsentif, rpbk1, rpbk2, rpbk3 ";
        sql = sql + "       from dphoffline  partition(" + partisi + ") a ";
        sql = sql + "       where ";
        if ( tUnitUP.toUpperCase() == "ALL" ) {
            sql = sql + "       UNITUP IN(SELECT UNITUP FROM UNITUP WHERE UNITAP = '" + tUnitAP + "')";
        } else {
            sql = sql + "       UNITUP  = '" + tUnitUP + "' ";
        }
        sql = sql + "       and tglbayar  >= '" + tTglmulai + "'";
        sql = sql + "       and tglbayar  <= '" + tTglsampai + "'";
        sql = sql + "       and kdgerakkeluar = '21' and (kodegagal = '0' or kodegagal is null) ";
        sql = sql + "       and tglbataltrans is null ";
        mSQL = sql + " ) v1 ";
        mSQL = mSQL + " ";
        mSQL = mSQL + " ORDER BY KDGERAK,UNITUP,TGLBUKU,TANGGAL,IDPEL, KOGOL,KDPEMBPP,STATUS ";

        return mSQL;
    }
    public String GetViewRekap_21_DAFTAR_TRANSAKSI(String vJenis, String vPilihTgl, String tUnitKJ, String tUnitUP, String tUnitAP, String tTglmulai, String tTglsampai, String tkode) {
        String mSQL = "", sql = "";
        String partisi = "";
        partisi = "lunas_" + tTglmulai.substring(0, 4) + "_" + tTglmulai.substring(4, 2);
        tTglsampai = tTglmulai.substring(0, 6) + tTglsampai.substring(6, 2);
        //FROM VIEW_PANTAU_21_DFT_T
        mSQL = "SELECT ' ' AS NOMOR, sysdate as TGLCETAK,";
        mSQL = mSQL + "  TANGGAL, TGLBUKU, IDPEL, WKTLNS , KDPP, PETUGAS, KDGERAK, KOGOL, UNITUP, KDKELOMPOK, TARIP, DAYA, BLTH, KDPEMBPP, STATUS, NOREK, UNITKJ, KDINKASO, PEMDA, KDPPJ, KODE";
        mSQL = mSQL + "  ,RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3";
        mSQL = mSQL + " FROM ( ";
        mSQL = mSQL + " ";
        sql = mSQL + "      select /*+index(a idx_dphoffline_tgltransaksi, idx_dphoffline_unitup)*/  ";
        sql = sql + "       to_char(tgltransaksi,'YYYYMMDD') as tanggal, tglbayar as tglbuku, idpel, ";
        sql = sql + "       wktbayar as wktlns , kdpp,kdpembayar as  petugas, ";
        sql = sql + "       kdgerakkeluar as  kdgerak, kogol, unitup, kdkelompok, ";
        sql = sql + "       tarip, daya, blth, kdpembpp, status, norek, ";
        sql = sql + "       unitkj, kdinkaso, pemda, kdppj, kdkirim as kode, ";
        sql = sql + "       rptag,rpptl,rptb, rpppn, rpbpju, rptrafo, rpsewatrafo, rpsewakap, rpangsa,  rpangsb, rpangsc, rpmat, rppln,   rpreduksi, rpinsentif, rpdisinsentif, rpbk1, rpbk2, rpbk3 ";
        sql = sql + "       from dphoffline a ";
        sql = sql + "       where ";
        if ( tUnitUP.toUpperCase() == "ALL" ) {
            sql = sql + "       UNITUP IN(SELECT UNITUP FROM UNITUP WHERE UNITAP = '" + tUnitAP + "')";
        } else {
            sql = sql + "       UNITUP  = '" + tUnitUP + "' ";
        }
        sql = sql + "       and tgltransaksi  >=  to_date('" + tTglmulai + "','YYYYMMDD')";
        sql = sql + "       and tgltransaksi  < (to_date('" + tTglsampai + "','YYYYMMDD') + 1)";
        sql = sql + "       and kdgerakkeluar = '21' and (kodegagal = '0' or kodegagal is null) ";
        sql = sql + "       and tglbataltrans is null ";
        mSQL = sql + " ) v1 ";
        mSQL = mSQL + " ";
        mSQL = mSQL + " ORDER BY KDGERAK,UNITUP,TANGGAL,TGLBUKU,IDPEL, KOGOL,KDPEMBPP,STATUS ";

        return mSQL;
    }
    public String GetViewRekap_21_REKAP_PEMBUKUAN(String vJenis, String vPilihTgl, String tUnitKJ, String tUnitUP, String tUnitAP, String tTglmulai, String tTglsampai, String tkode) {
        String mSQL = "", sql = "";
        String partisi = "";
        partisi = "lunas_" + tTglmulai.substring(0, 4) + "_" + tTglmulai.substring(4, 2);
        tTglsampai = tTglmulai.substring(0, 6) + tTglsampai.substring(6, 2);

        //FROM VIEW_PANTAU_21_REKAP_T
        mSQL = "SELECT ' ' AS NOMOR, sysdate as TGLCETAK,";
        mSQL = mSQL + " TANGGAL, TGLBUKU, KDGERAK, UNITUP, KOGOL, KDPEMBPP, STATUS,";
        mSQL = mSQL + "   SUM(LEMBAR) AS LEMBAR,SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3";
        mSQL = mSQL + " FROM ( ";
        mSQL = mSQL + " ";
        sql = mSQL + "    select /*+index(a idx_dphoffline_02)*/ ";
        sql = sql + "     to_char(tgltransaksi,'YYYYMMDD') as tanggal, ";
        sql = sql + "     tglbayar as tglbuku, ";
        sql = sql + "     kdgerakkeluar as kdgerak, ";
        sql = sql + "     unitup, kogol, kdpembpp, status, ";
        sql = sql + "     count(idpel) as lembar, ";
        sql = sql + "     sum(rptag) as rptag,sum(rpptl) as rpptl, ";
        sql = sql + "     sum(rptb) as rptb, sum(rpppn) as rpppn, sum(rpbpju) as rpbpju, ";
        sql = sql + "     sum(rptrafo) as rptrafo, sum(rpsewatrafo) as rpsewatrafo, sum(rpsewakap) as rpsewakap, ";
        sql = sql + "     sum(rpangsa) as rpangsa, sum(rpangsb) as rpangsb, sum(rpangsc) as rpangsc, ";
        sql = sql + "     sum(rpmat) as rpmat, sum(rppln) as rppln, sum(rpreduksi) as rpreduksi, ";
        sql = sql + "     sum(rpinsentif) as rpinsentif, sum(rpdisinsentif) as rpdisinsentif, ";
        sql = sql + "     sum(rpbk1) as rpbk1, sum(rpbk2) as rpbk2, sum(rpbk3) as rpbk3 ";
        sql = sql + "     from dphoffline  partition(" + partisi + ") a ";
        sql = sql + "     where ";
        if ( tUnitUP.toUpperCase() == "ALL" ) {
            sql = sql + "       UNITUP IN(SELECT UNITUP FROM UNITUP WHERE UNITAP = '" + tUnitAP + "')";
        } else {
            sql = sql + "       UNITUP  = '" + tUnitUP + "' ";
        }
        sql = sql + "     and tglbayar  >= '" + tTglmulai + "'";
        sql = sql + "     and tglbayar  <= '" + tTglsampai + "'";
        sql = sql + "     and kdgerakkeluar = '21' and (kodegagal = '0' or kodegagal is null) ";
        sql = sql + "     and tglbataltrans is null ";
        sql = sql + "     and kdpembpp = 'R1' ";
        sql = sql + "     group by to_char(tgltransaksi,'YYYYMMDD'),tglbayar,kdgerakkeluar,unitup, kogol,kdpembpp,status ";
        mSQL = sql + " ) v1 ";
        mSQL = mSQL + " ";
        mSQL = mSQL + " GROUP BY KDGERAK,UNITUP,TANGGAL,TGLBUKU,KOGOL,KDPEMBPP,STATUS ";
        mSQL = mSQL + " ORDER BY KDGERAK,UNITUP,TGLBUKU,TANGGAL,KOGOL,KDPEMBPP,STATUS ";

        return mSQL;
    }
    public String GetViewRekap_21_REKAP_TRANSAKSI(String vJenis, String vPilihTgl, String tUnitKJ, String tUnitUP, String tUnitAP, String tTglmulai, String tTglsampai, String tkode) {
        String mSQL = "", sql = "";
        String partisi = "";
        partisi = "lunas_" + tTglmulai.substring(0, 4) + "_" + tTglmulai.substring(4, 2);
        tTglsampai = tTglmulai.substring(0, 6) + tTglsampai.substring(6, 2);

        //FROM VIEW_PANTAU_21_REKAP_T
        mSQL = "SELECT ' ' AS NOMOR, sysdate as TGLCETAK,";
        mSQL = mSQL + " TANGGAL, TGLBUKU, KDGERAK, UNITUP, KOGOL, KDPEMBPP, STATUS,";
        mSQL = mSQL + "   SUM(LEMBAR) AS LEMBAR,SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3";
        mSQL = mSQL + " FROM ( ";
        mSQL = mSQL + " ";
        sql = mSQL + "    select  /*+index(a idx_dphoffline_tgltransaksi, idx_dphoffline_unitup)*/  ";
        sql = sql + "     to_char(tgltransaksi,'YYYYMMDD') as tanggal, ";
        sql = sql + "     tglbayar as tglbuku, ";
        sql = sql + "     kdgerakkeluar as kdgerak, ";
        sql = sql + "     unitup, kogol, kdpembpp, status, ";
        sql = sql + "     count(idpel) as lembar, ";
        sql = sql + "     sum(rptag) as rptag,sum(rpptl) as rpptl, ";
        sql = sql + "     sum(rptb) as rptb, sum(rpppn) as rpppn, sum(rpbpju) as rpbpju, ";
        sql = sql + "     sum(rptrafo) as rptrafo, sum(rpsewatrafo) as rpsewatrafo, sum(rpsewakap) as rpsewakap, ";
        sql = sql + "     sum(rpangsa) as rpangsa, sum(rpangsb) as rpangsb, sum(rpangsc) as rpangsc, ";
        sql = sql + "     sum(rpmat) as rpmat, sum(rppln) as rppln, sum(rpreduksi) as rpreduksi, ";
        sql = sql + "     sum(rpinsentif) as rpinsentif, sum(rpdisinsentif) as rpdisinsentif, ";
        sql = sql + "     sum(rpbk1) as rpbk1, sum(rpbk2) as rpbk2, sum(rpbk3) as rpbk3 ";
        sql = sql + "     from dphoffline a ";
        sql = sql + "     where ";
        if ( tUnitUP.toUpperCase() == "ALL" ) {
            sql = sql + "       UNITUP IN(SELECT UNITUP FROM UNITUP WHERE UNITAP = '" + tUnitAP + "')";
        } else {
            sql = sql + "       UNITUP  = '" + tUnitUP + "' ";
        }
        sql = sql + "       and tgltransaksi  >=  to_date('" + tTglmulai + "','YYYYMMDD')";
        sql = sql + "       and tgltransaksi  < (to_date('" + tTglsampai + "','YYYYMMDD') + 1)";
        sql = sql + "     and kdgerakkeluar = '21' and (kodegagal = '0' or kodegagal is null) ";
        sql = sql + "     and tglbataltrans is null ";
        sql = sql + "     and kdpembpp = 'R1' ";
        sql = sql + "     group by to_char(tgltransaksi,'YYYYMMDD'),tglbayar,kdgerakkeluar,unitup, kogol,kdpembpp,status ";
        mSQL = sql + " ) v1 ";
        mSQL = mSQL + " ";
        mSQL = mSQL + " GROUP BY KDGERAK,UNITUP,TANGGAL,TGLBUKU,KOGOL,KDPEMBPP,STATUS ";
        mSQL = mSQL + " ORDER BY KDGERAK,UNITUP,TANGGAL,TGLBUKU,KOGOL,KDPEMBPP,STATUS ";

        return mSQL;

    }
//        '=========================================================================
//        'Public=========================================================================
    public String GetViewBatal_21(String vpilihtglsama, String vJenis, String vPilihTgl, String tUnitKJ, String tUnitUP, String tUnitAP, String tTglmulai, String tTglsampai, String tKode) {
        String mSQL = "";

        if ( vJenis.toUpperCase() == "DAFTAR" ) {
            if ( vPilihTgl.toUpperCase() == "PEMBUKUAN" ) {
                mSQL = GetViewBatal_21_DAFTAR_PEMBUKUAN(vJenis, vPilihTgl, tUnitKJ, tUnitUP, tUnitAP, tTglmulai, tTglsampai, tKode);
            } else if ( vPilihTgl.toUpperCase() == "TRANSAKSI" ) {
                mSQL = GetViewBatal_21_DAFTAR_TRANSAKSI(vJenis, vPilihTgl, tUnitKJ, tUnitUP, tUnitAP, tTglmulai, tTglsampai, tKode);
            }
        } else if ( vJenis.toUpperCase() == "REKAP" ) {
            if ( vPilihTgl.toUpperCase() == "PEMBUKUAN" ) {
                mSQL = GetViewBatal_21_REKAP_PEMBUKUAN(vJenis, vPilihTgl, tUnitKJ, tUnitUP, tUnitAP, tTglmulai, tTglsampai, tKode);
            } else if ( vPilihTgl.toUpperCase() == "TRANSAKSI" ) {
                mSQL = GetViewBatal_21_REKAP_TRANSAKSI(vJenis, vPilihTgl, tUnitKJ, tUnitUP, tUnitAP, tTglmulai, tTglsampai, tKode);
            }
        }

        return mSQL;
    }

    public String GetViewBatal_21_DAFTAR_PEMBUKUAN(String vJenis, String vPilihTgl, String tUnitKJ, String tUnitUP, String tUnitAP, String tTglmulai, String tTglsampai, String tkode) {
        String mSQL = "", sql = "";
        String partisi = "";
        partisi = "lunas_" + tTglmulai.substring(0, 4) + "_" + tTglmulai.substring(4, 2);
        tTglsampai = tTglmulai.substring(0, 6) + tTglsampai.substring(6, 2);

        //FROM VIEW_PANTAU_21_DFT_B
        mSQL = "SELECT ' ' AS NOMOR, sysdate as TGLCETAK,";
        mSQL = mSQL + "  TANGGAL, TGLBUKU, IDPEL, WKTLNS , KDPP, PETUGAS, KDGERAK, KOGOL, UNITUP, KDKELOMPOK, TARIP, DAYA, BLTH, KDPEMBPP, STATUS, NOREK, UNITKJ, KDINKASO, PEMDA, KDPPJ, KODE";
        mSQL = mSQL + "  ,RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3";
        mSQL = mSQL + " FROM ( ";
        mSQL = mSQL + " ";
        sql = mSQL + "      select /*+index(a idx_dphoffline_02)*/ ";
        sql = sql + "       to_char(TGLBATALTRANS,'YYYYMMDD') as tanggal, tglbayar as tglbuku, idpel, ";
        sql = sql + "       wktbayar as wktlns , kdpp,TRANSAKSIBATALBY as  petugas, ";
        sql = sql + "       kdgerakkeluar as  kdgerak, kogol, unitup, kdkelompok, ";
        sql = sql + "       tarip, daya, blth, kdpembpp, status, norek, ";
        sql = sql + "       unitkj, kdinkaso, pemda, kdppj, kdkirim as kode, ";
        sql = sql + "       rptag,rpptl,rptb, rpppn, rpbpju, rptrafo, rpsewatrafo, rpsewakap, rpangsa,  rpangsb, rpangsc, rpmat, rppln,   rpreduksi, rpinsentif, rpdisinsentif, rpbk1, rpbk2, rpbk3 ";
        sql = sql + "       from dphoffline  partition(" + partisi + ") a ";
        sql = sql + "       where ";
        if ( tUnitUP.toUpperCase() == "ALL" ) {
            sql = sql + "       UNITUP IN(SELECT UNITUP FROM UNITUP WHERE UNITAP = '" + tUnitAP + "')";
        } else {
            sql = sql + "       UNITUP  = '" + tUnitUP + "' ";
        }
        sql = sql + "       and tglbayar  >= '" + tTglmulai + "'";
        sql = sql + "       and tglbayar  <= '" + tTglsampai + "'";
        sql = sql + "       and kdgerakkeluar = '21' and (kodegagal = '0' or kodegagal is null) ";
        sql = sql + "       and tglbataltrans is not null ";
        mSQL = sql + " ) v1 ";
        mSQL = mSQL + " ";
        mSQL = mSQL + " ORDER BY KDGERAK,UNITUP,TGLBUKU,TANGGAL,IDPEL, KOGOL,KDPEMBPP,STATUS ";

        return mSQL;
    }

    public String GetViewBatal_21_DAFTAR_TRANSAKSI(String vJenis, String vPilihTgl, String tUnitKJ, String tUnitUP, String tUnitAP, String tTglmulai, String tTglsampai, String tkode) {
        String mSQL = "", sql = "";
        String partisi = "";
        partisi = "lunas_" + tTglmulai.substring(0, 4) + "_" + tTglmulai.substring(4, 2);
        tTglsampai = tTglmulai.substring(0, 6) + tTglsampai.substring(6, 2);
//        'FROM VIEW_PANTAU_21_DFT_B
        mSQL = "SELECT ' ' AS NOMOR, sysdate as TGLCETAK,";
        mSQL = mSQL + "  TANGGAL, TGLBUKU, IDPEL, WKTLNS , KDPP, PETUGAS, KDGERAK, KOGOL, UNITUP, KDKELOMPOK, TARIP, DAYA, BLTH, KDPEMBPP, STATUS, NOREK, UNITKJ, KDINKASO, PEMDA, KDPPJ, KODE";
        mSQL = mSQL + "  ,RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3";
        mSQL = mSQL + " FROM ( ";
        mSQL = mSQL + " ";
        sql = mSQL + "      select /*+index(a idx_dphoffline_tglbataltrans, idx_dphoffline_unitup)*/ ";
        sql = sql + "       to_char(TGLBATALTRANS,'YYYYMMDD') as tanggal, tglbayar as tglbuku, idpel, ";
        sql = sql + "       wktbayar as wktlns , kdpp,TRANSAKSIBATALBY as  petugas, ";
        sql = sql + "       kdgerakkeluar as  kdgerak, kogol, unitup, kdkelompok, ";
        sql = sql + "       tarip, daya, blth, kdpembpp, status, norek, ";
        sql = sql + "       unitkj, kdinkaso, pemda, kdppj, kdkirim as kode, ";
        sql = sql + "       rptag,rpptl,rptb, rpppn, rpbpju, rptrafo, rpsewatrafo, rpsewakap, rpangsa,  rpangsb, rpangsc, rpmat, rppln,   rpreduksi, rpinsentif, rpdisinsentif, rpbk1, rpbk2, rpbk3 ";
        sql = sql + "       from dphoffline a ";
        sql = sql + "       where ";
        if ( tUnitUP.toUpperCase() == "ALL" ) {
            sql = sql + "       UNITUP IN(SELECT UNITUP FROM UNITUP WHERE UNITAP = '" + tUnitAP + "')";
        } else {
            sql = sql + "       UNITUP  = '" + tUnitUP + "' ";
        }
        sql = sql + "       and TGLBATALTRANS  >=  to_date('" + tTglmulai + "','YYYYMMDD')";
        sql = sql + "       and TGLBATALTRANS  < (to_date('" + tTglsampai + "','YYYYMMDD') + 1)";
        sql = sql + "       and kdgerakkeluar = '21' and (kodegagal = '0' or kodegagal is null) ";
        sql = sql + "       and tglbataltrans is not null ";
        mSQL = sql + " ) v1 ";
        mSQL = mSQL + " ";
        mSQL = mSQL + " ORDER BY KDGERAK,UNITUP,TANGGAL,TGLBUKU,IDPEL, KOGOL,KDPEMBPP,STATUS ";

        return mSQL;
    }
    public String GetViewBatal_21_REKAP_PEMBUKUAN(String vJenis, String vPilihTgl, String tUnitKJ, String tUnitUP, String tUnitAP, String tTglmulai, String tTglsampai, String tkode) {
        String mSQL = "", sql = "";
        String partisi = "";
        partisi = "lunas_" + tTglmulai.substring(0, 4) + "_" + tTglmulai.substring(4, 2);
        tTglsampai = tTglmulai.substring(0, 6) + tTglsampai.substring(6, 2);

//        'FROM VIEW_PANTAU_21_REKAP_B
        mSQL = "SELECT ' ' AS NOMOR, sysdate as TGLCETAK,";
        mSQL = mSQL + " TANGGAL, TGLBUKU, KDGERAK, UNITUP, KOGOL, KDPEMBPP, STATUS,";
        mSQL = mSQL + "   SUM(LEMBAR) AS LEMBAR,SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3";
        mSQL = mSQL + " FROM ( ";
        mSQL = mSQL + " ";
        sql = mSQL + "    select /*+index(a idx_dphoffline_02)*/ ";
        sql = sql + "     to_char(TGLBATALTRANS,'YYYYMMDD') as tanggal, ";
        sql = sql + "     tglbayar as tglbuku, ";
        sql = sql + "     kdgerakkeluar as kdgerak, ";
        sql = sql + "     unitup, kogol, kdpembpp, status, ";
        sql = sql + "     count(idpel) as lembar, ";
        sql = sql + "     sum(rptag) as rptag,sum(rpptl) as rpptl, ";
        sql = sql + "     sum(rptb) as rptb, sum(rpppn) as rpppn, sum(rpbpju) as rpbpju, ";
        sql = sql + "     sum(rptrafo) as rptrafo, sum(rpsewatrafo) as rpsewatrafo, sum(rpsewakap) as rpsewakap, ";
        sql = sql + "     sum(rpangsa) as rpangsa, sum(rpangsb) as rpangsb, sum(rpangsc) as rpangsc, ";
        sql = sql + "     sum(rpmat) as rpmat, sum(rppln) as rppln, sum(rpreduksi) as rpreduksi, ";
        sql = sql + "     sum(rpinsentif) as rpinsentif, sum(rpdisinsentif) as rpdisinsentif, ";
        sql = sql + "     sum(rpbk1) as rpbk1, sum(rpbk2) as rpbk2, sum(rpbk3) as rpbk3 ";
        sql = sql + "     from dphoffline  partition(" + partisi + ") a ";
        sql = sql + "     where ";
        if ( tUnitUP.toUpperCase() == "ALL" ) {
            sql = sql + "       UNITUP IN(SELECT UNITUP FROM UNITUP WHERE UNITAP = '" + tUnitAP + "')";
        }else{
            sql = sql + "       UNITUP  = '" + tUnitUP + "' ";
        }
        sql = sql + "     and tglbayar  >= '" + tTglmulai + "'";
        sql = sql + "     and tglbayar  <= '" + tTglsampai + "'";
        sql = sql + "     and kdgerakkeluar = '21' and (kodegagal = '0' or kodegagal is null) ";
        sql = sql + "     and tglbataltrans is not null ";
        sql = sql + "     and kdpembpp = 'R1' ";
        sql = sql + "     group by to_char(TGLBATALTRANS,'YYYYMMDD'),tglbayar,kdgerakkeluar,unitup, kogol,kdpembpp,status ";
        mSQL = sql + " ) v1 ";
        mSQL = mSQL + " ";
        mSQL = mSQL + " GROUP BY KDGERAK,UNITUP,TANGGAL,TGLBUKU,KOGOL,KDPEMBPP,STATUS ";
        mSQL = mSQL + " ORDER BY KDGERAK,UNITUP,TGLBUKU,TANGGAL,KOGOL,KDPEMBPP,STATUS ";

        return mSQL;
    }
    public String GetViewBatal_21_REKAP_TRANSAKSI(String vJenis, String vPilihTgl, String tUnitKJ, String tUnitUP, String tUnitAP, String tTglmulai, String tTglsampai, String tkode) {
        String mSQL = "", sql = "";
        String partisi = "";
        partisi = "lunas_" + tTglmulai.substring(0, 4) + "_" + tTglmulai.substring(4, 2);
        tTglsampai = tTglmulai.substring(0, 6) + tTglsampai.substring(6, 2);

//        'FROM VIEW_PANTAU_21_REKAP_B
        mSQL = "SELECT ' ' AS NOMOR, sysdate as TGLCETAK,";
        mSQL = mSQL + " TANGGAL, TGLBUKU, KDGERAK, UNITUP, KOGOL, KDPEMBPP, STATUS,";
        mSQL = mSQL + "   SUM(LEMBAR) AS LEMBAR,SUM(RPTAG) AS RPTAG,SUM(RPPTL) AS RPPTL, SUM(RPTB) AS RPTB, SUM(RPPPN) AS RPPPN, SUM(RPBPJU) AS RPBPJU, SUM(RPTRAFO) AS RPTRAFO, SUM(RPSEWATRAFO) AS RPSEWATRAFO, SUM(RPSEWAKAP) AS RPSEWAKAP, SUM(RPANGSA) AS RPANGSA, SUM(RPANGSB) AS RPANGSB, SUM(RPANGSC) AS RPANGSC, SUM(RPMAT) AS RPMAT, SUM(RPPLN) AS RPPLN, SUM(RPREDUKSI) AS RPREDUKSI, SUM(RPINSENTIF) AS RPINSENTIF, SUM(RPDISINSENTIF) AS RPDISINSENTIF, SUM(RPBK1) AS RPBK1, SUM(RPBK2) AS RPBK2, SUM(RPBK3) AS RPBK3";
        mSQL = mSQL + " FROM ( ";
        mSQL = mSQL + " ";
        sql = mSQL + "    select  /*+index(a idx_dphoffline_tglbataltrans, idx_dphoffline_unitup)*/ ";
        sql = sql + "     to_char(TGLBATALTRANS,'YYYYMMDD') as tanggal, ";
        sql = sql + "     tglbayar as tglbuku, ";
        sql = sql + "     kdgerakkeluar as kdgerak, ";
        sql = sql + "     unitup, kogol, kdpembpp, status, ";
        sql = sql + "     count(idpel) as lembar, ";
        sql = sql + "     sum(rptag) as rptag,sum(rpptl) as rpptl, ";
        sql = sql + "     sum(rptb) as rptb, sum(rpppn) as rpppn, sum(rpbpju) as rpbpju, ";
        sql = sql + "     sum(rptrafo) as rptrafo, sum(rpsewatrafo) as rpsewatrafo, sum(rpsewakap) as rpsewakap, ";
        sql = sql + "     sum(rpangsa) as rpangsa, sum(rpangsb) as rpangsb, sum(rpangsc) as rpangsc, ";
        sql = sql + "     sum(rpmat) as rpmat, sum(rppln) as rppln, sum(rpreduksi) as rpreduksi, ";
        sql = sql + "     sum(rpinsentif) as rpinsentif, sum(rpdisinsentif) as rpdisinsentif, ";
        sql = sql + "     sum(rpbk1) as rpbk1, sum(rpbk2) as rpbk2, sum(rpbk3) as rpbk3 ";
        sql = sql + "     from dphoffline a ";
        sql = sql + "     where ";
        if ( tUnitUP.toUpperCase() == "ALL" ) {
            sql = sql + "       UNITUP IN(SELECT UNITUP FROM UNITUP WHERE UNITAP = '" + tUnitAP + "')";
        } else {
            sql = sql + "       UNITUP  = '" + tUnitUP + "' ";
        }
        sql = sql + "       and TGLBATALTRANS  >=  to_date('" + tTglmulai + "','YYYYMMDD')";
        sql = sql + "       and TGLBATALTRANS  < (to_date('" + tTglsampai + "','YYYYMMDD')+1)";
        sql = sql + "     and kdgerakkeluar = '21' and (kodegagal = '0' or kodegagal is null) ";
        sql = sql + "     and tglbataltrans is not null ";
        sql = sql + "     and kdpembpp = 'R1' ";
        sql = sql + "     group by to_char(TGLBATALTRANS,'YYYYMMDD'),tglbayar,kdgerakkeluar,unitup, kogol,kdpembpp,status ";
        mSQL = sql + " ) v1 ";
        mSQL = mSQL + " ";
        mSQL = mSQL + " GROUP BY KDGERAK,UNITUP,TANGGAL,TGLBUKU,KOGOL,KDPEMBPP,STATUS ";
        mSQL = mSQL + " ORDER BY KDGERAK,UNITUP,TANGGAL,TGLBUKU,KOGOL,KDPEMBPP,STATUS ";

        return mSQL;
    }

//        '=========================================================================
//        '=========================================================================
    //End Region 'clsPemantauanTransaksi.vb'

    //Region "cls_ReportBA.vb"

    public String rptVIEW_BA21_Upload(String unitup, String tgltransaksi, String tglbayar, String kdpp, String transaksiby) {
        String sql;
        String partisi = "";
        partisi = "lunas_" + tglbayar.substring(0, 4) + "_" + tglbayar.substring(4, 2);

//        'FROM VIEW_BA21
        sql = " SELECT ";
        sql = sql + " SYSDATE AS TGLCETAK, TGLTRANSAKSI, TO_DATE(TGLBAYAR,'yyyymmdd') as TGLBAYAR, KOGOL, LEMBAR, RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, KDGERAKKELUAR, KDPEMBPP, STATUS, KDKIRIM, UNITUP, KODEPP, NAMAPP, ALAMATPP, TRANSAKSIBY, KODEGAGAL ";
        sql = sql + " from (";
        sql = sql + " ";
        sql = sql + "     select  /*+index(dh idx_dphoffline_kdpp)*/   ";
        sql = sql + "     trunc(dh.tgltransaksi) as tgltransaksi, ";
        sql = sql + "     dh.tglbayar , ";
        sql = sql + "     dh.kogol, count(idpel) as lembar, ";
        sql = sql + "     sum(rptag) as rptag,sum(rpptl) as rpptl, ";
        sql = sql + "     sum(rptb) as rptb, sum(rpppn) as rpppn, sum(rpbpju) as rpbpju, ";
        sql = sql + "     sum(rptrafo) as rptrafo, sum(rpsewatrafo) as rpsewatrafo, sum(rpsewakap) as rpsewakap, ";
        sql = sql + "     sum(rpangsa) as rpangsa, sum(rpangsb) as rpangsb, sum(rpangsc) as rpangsc, ";
        sql = sql + "     sum(rpmat) as rpmat, sum(rppln) as rppln, sum(rpreduksi) as rpreduksi, ";
        sql = sql + "     sum(rpinsentif) as rpinsentif, sum(rpdisinsentif) as rpdisinsentif, ";
        sql = sql + "     sum(rpbk1) as rpbk1, sum(rpbk2) as rpbk2, sum(rpbk3) as rpbk3, ";
        sql = sql + "     kdgerakkeluar, kdpembpp, status, kdkirim, flaganja, ";
        sql = sql + "     dh.unitup ,pp.kodepp, pp.namapp,pp.alamat as alamatpp, dh.transaksiby, ";
        sql = sql + "     case when (dh.kodegagal='0') ) { 'BERHASIL' else 'GAGAL' end as kodegagal ";
        sql = sql + "     from dphoffline  partition(" + partisi + ") dh ";
        sql = sql + "     left outer join paymentpoint pp on ";
        sql = sql + "     dh.kdpp = pp.kodepp ";
        sql = sql + "     where  ";
        sql += " dh.KODEPP = '" + kdpp + "' ";
        sql += " AND dh.TGLBAYAR = '" + tglbayar + "'  ";
        sql += " AND trunc(dh.tgltransaksi) == to_date('" + tgltransaksi + "','yyyymmdd') ";
        sql += " AND kdkirim = 'U' ";
//        'sql += " AND TRANSAKSIBY = '" + transaksiby + "' "
        sql = sql + "     and kdgerakkeluar = '21' and tglbataltrans is null ";
        sql = sql + "     group by kdgerakkeluar,trunc(dh.tgltransaksi), ";
        sql = sql + "     tglbayar,kdkirim,flaganja,pp.kodepp, pp.namapp,pp.alamat ,dh.transaksiby, ";
        sql = sql + "     case when (dh.kodegagal='0') ) { 'BERHASIL' else 'GAGAL' end, ";
        sql = sql + "     dh.kogol, dh.kdpembpp, dh.status,dh.unitup ";
        sql = sql + " ) b";
        sql = sql + " ";
        return sql;
    }

    public String rptVIEW_BA21_Entri(String unitup, String tgltransaksi, String tglbayar, String kdpp, String transaksiby) {
        String sql;
        String partisi = "";
        partisi = "lunas_" + tglbayar.substring(0, 4) + "_" + tglbayar.substring(4, 2);

//        'FROM VIEW_BA21
        sql = " SELECT ";
        sql = sql + " SYSDATE AS TGLCETAK, TGLTRANSAKSI, TO_DATE(TGLBAYAR,'yyyymmdd') as TGLBAYAR, KOGOL, LEMBAR, RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, KDGERAKKELUAR, KDPEMBPP, STATUS, KDKIRIM, UNITUP, KODEPP, NAMAPP, ALAMATPP, TRANSAKSIBY, KODEGAGAL ";
        sql = sql + " from (";
        sql = sql + " ";
        sql = sql + "     select  /*+index(dh idx_dphoffline_kdpp)*/   ";
        sql = sql + "     trunc(dh.tgltransaksi) as tgltransaksi, ";
        sql = sql + "     dh.tglbayar , ";
        sql = sql + "     dh.kogol, count(idpel) as lembar, ";
        sql = sql + "     sum(rptag) as rptag,sum(rpptl) as rpptl, ";
        sql = sql + "     sum(rptb) as rptb, sum(rpppn) as rpppn, sum(rpbpju) as rpbpju, ";
        sql = sql + "     sum(rptrafo) as rptrafo, sum(rpsewatrafo) as rpsewatrafo, sum(rpsewakap) as rpsewakap, ";
        sql = sql + "     sum(rpangsa) as rpangsa, sum(rpangsb) as rpangsb, sum(rpangsc) as rpangsc, ";
        sql = sql + "     sum(rpmat) as rpmat, sum(rppln) as rppln, sum(rpreduksi) as rpreduksi, ";
        sql = sql + "     sum(rpinsentif) as rpinsentif, sum(rpdisinsentif) as rpdisinsentif, ";
        sql = sql + "     sum(rpbk1) as rpbk1, sum(rpbk2) as rpbk2, sum(rpbk3) as rpbk3, ";
        sql = sql + "     kdgerakkeluar, kdpembpp, status, kdkirim, flaganja, ";
        sql = sql + "     dh.unitup ,pp.kodepp, pp.namapp,pp.alamat as alamatpp, dh.transaksiby, ";
        sql = sql + "     'BERHASIL' as kodegagal ";
        sql = sql + "     from dphoffline  partition(" + partisi + ") dh ";
        sql = sql + "     left outer join paymentpoint pp on ";
        sql = sql + "     dh.kdpp = pp.kodepp ";
        sql = sql + "     where  ";
        sql += " dh.KODEPP = '" + kdpp + "' ";
        sql += " AND dh.TGLBAYAR = '" + tglbayar + "'  ";
        sql += " AND trunc(dh.tgltransaksi) == to_date('" + tgltransaksi + "','yyyymmdd') ";
//        'sql += " AND kdkirim = 'E' ";
//        'sql += " AND TRANSAKSIBY = '" + transaksiby + "' ";
        sql = sql + "     and kdgerakkeluar = '21' and tglbataltrans is null ";
        sql = sql + "     group by kdgerakkeluar,trunc(dh.tgltransaksi), ";
        sql = sql + "     tglbayar,kdkirim,flaganja,pp.kodepp, pp.namapp,pp.alamat ,dh.transaksiby, ";
        sql = sql + "     dh.kogol, dh.kdpembpp, dh.status,dh.unitup ";
        sql = sql + " ) b";
        sql = sql + " ";

        return sql;
    }

    public String rptVIEW_BA21Daftar_Entri(String unitup, String tgltransaksi, String tglbayar, String kdpp, String transaksiby) {
        String sql;
        String partisi = "";
        partisi = "lunas_" + tglbayar.substring(0, 4) + "_" + tglbayar.substring(4, 2);

//        'FROM VIEW_BA21_DAFTAR
        sql = " SELECT ";
        sql = sql + " SYSDATE AS TGLCETAK, TGLTRANSAKSI, IDPEL, KOGOL, BLTH, KDPEMBPP, STATUS, NOREK, RPTAG, RPPTL, RPTB, RPPPN, RPBPJU, RPTRAFO, RPSEWATRAFO, RPSEWAKAP, RPANGSA, RPANGSB, RPANGSC, RPMAT, RPPLN, RPREDUKSI, RPINSENTIF, RPDISINSENTIF, RPBK1, RPBK2, RPBK3, ";
        sql = sql + " KDGERAKKELUAR, TO_DATE(TGLBAYAR,'yyyymmdd') as TGLBAYAR, WKTBAYAR, KDPP, KDPEMBAYAR, KDKIRIM, UNITUP, UNITKJ, KDINKASO, KDKELOMPOK, PEMDA, KDPPJ, TARIP, DAYA, KODEPP, NAMAPP, ALAMATPP, TRANSAKSIBY, KODEGAGAL ";
        sql = sql + " from (";
        sql = sql + " ";
        sql = sql + "    select    /*+index(dh idx_dphoffline_kdpp)*/   ";
        sql = sql + "    trunc(dh.tgltransaksi) as tgltransaksi,  ";
        sql = sql + "    dh.idpel,  ";
        sql = sql + "    dh.kogol,  ";
        sql = sql + "    dh.blth,dh.kdpembpp,dh.status,dh.norek,  ";
        sql = sql + "    dh.rptag,rpptl,rptb, rpppn, rpbpju, rptrafo, rpsewatrafo, rpsewakap,  ";
        sql = sql + "    dh.rpangsa,  rpangsb, rpangsc,  ";
        sql = sql + "    dh.rpmat, rppln,   rpreduksi,  ";
        sql = sql + "    dh.rpinsentif, rpdisinsentif, rpbk1, rpbk2, rpbk3,  ";
        sql = sql + "    dh.kdgerakkeluar, tglbayar, dh.wktbayar, dh.kdpp, dh.kdpembayar,dh.kdkirim, dh.flaganja,  ";
        sql = sql + "    dh.unitup, dh.unitkj, dh.kdinkaso, kdkelompok, pemda,kdppj,tarip, daya , pp.kodepp,  ";
        sql = sql + "    pp.namapp,pp.alamat as alamatpp,  ";
        sql = sql + "    dh.transaksiby, dh.kodegagal  ";
        sql = sql + "    from dphoffline  partition(" + partisi + ") dh  ";
        sql = sql + "    left outer join paymentpoint pp on  ";
        sql = sql + "    dh.kdpp = pp.kodepp  ";
        sql = sql + "    where ";
        sql += " dh.KODEPP = '" + kdpp + "' ";
        sql += " AND dh.TGLBAYAR = '" + tglbayar + "'  ";
        sql += " AND trunc(dh.tgltransaksi) == to_date('" + tgltransaksi + "','yyyymmdd') ";
//        'sql += " AND kdkirim = 'E' "
//        'sql += " AND TRANSAKSIBY = '" + transaksiby + "' "
        sql = sql + "     and kdgerakkeluar = '21' and tglbataltrans is null ";
        sql = sql + " ) b";
        sql = sql + " ";

        return sql;
    }

    //End Region 'cls_ReportBA.vb'
}

