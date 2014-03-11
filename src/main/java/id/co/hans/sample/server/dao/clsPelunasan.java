package id.co.hans.sample.server.dao;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class clsPelunasan {

    //----pencarian pelanggan variabeldari client
    public String IdPelanggan;
    public String NoPelanggan;
    public String Nama;
    public String Alamat;
    public String NOKONTRAK;
    public String NOKONTROL;
    public Boolean Persis;

    // buat pencarian nama whole word atau match case
    public Boolean TampilAll;

    // buat pencarian plg lunas atau belum
    public Boolean TampilLunas;

    // buat pencarian plg lunas saja
    //----end pencarian variabel dari client

    //--pelunasan variabel identitas petugas lunas dari client
    public String strLOGINPASSTRUE;
    public String UserId;
    public String UserName;
    public Integer LOKETID;
    public String KdPaymentPoint;
    //--end variabel identitas petugas lunas dari client

    //---variabel jumlah piutang yang akan dilunasi
    public Integer JmlLbr;
    public Double JumlahPiutang;
    public String KDGERAK;
    public Integer NumberingID;
    public String TransaksiID;
    //---end variabel jumlah piutang yang akan dilunasi

    //buat con
    public String TempConnectionString;

    //-----untuk proc pelunasan
    public String TGLBAYAR;

    //----
    //-----untuk transaksi pelanggan
    public Date TGLTRANSAKI;
    public String FlagAnja;
    public String BLTH;
    public String KDPEMBPP;
    public String Tarif;
    public Double Daya;
    public String STATUS;
    public Date TGLBAYARdate;
    public String TglJTempo;
    public Double RPBK1;
    public Double RPBK2;
    public Double RPBK3;
    public String KDKOLEKTIF;

    public Integer PIUTANGID;
    public String KODE_CABANG_NUMERIK;

    //-----untuk cetak ulang
    public String ALASAN;

    //-----untuk batal
    public String KODEBATAL;
    public String PETMINTA;

    //untuk laporan pelunasan
    public Date tanggalawal;
    public Date tanggalakhir;
    public Integer periode;
    public Integer rek;
    public Integer mati;
    public Integer ppju;
    public Integer ppn;
    public Integer bk;
    public Integer POT;
    public Integer trafo;
    public Integer lain;
    public Integer tag;
}
