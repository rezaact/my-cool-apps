package id.co.hans.sample.client.helper;

import java.util.Date;

import com.google.gwt.http.client.UrlBuilder;
import com.google.gwt.i18n.client.DateTimeFormat;

/**
 * Kelas Helper Untuk membentuk url yang mengarah kepada WS UMUM Restful Service
 * 
 * @author yudhi karunia surtan
 * 
 */
public class WsUmumUrlHelper {

	private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";
	private static final DateTimeFormat DEFAULT_DATETIME_FORMATER = DateTimeFormat
			.getFormat(DATE_FORMAT_PATTERN);
	private static final String WS_UMUM_PREFIX = "Ws_Umum/";
	private static final String TANGGAL_DATABASE_URL = WS_UMUM_PREFIX
			+ "ambilTanggalDatabase.json";
	private static final String UNIT_UP_DARI_PETUGAS_URL = WS_UMUM_PREFIX
			+ "ambilUnitUPdariPetugas.json";
	private static final String NAMA_UP_URL = WS_UMUM_PREFIX
			+ "ambilNamaUp.json";
	private static final String KODE_PP_DARI_UNIT_UP_URL = WS_UMUM_PREFIX
			+ "ambilKodePPdariUnitUP.json";
	private static final String UNIT_UP_URL = WS_UMUM_PREFIX
			+ "ambilUnitUp.json";
	private static final String CARI_URAIAN_URL = WS_UMUM_PREFIX
			+ "cariUraian.json";
	private static final String CARI_URAIAN_ASLI_URL = WS_UMUM_PREFIX
			+ "cariUraianAsli.json";
	private static final String CARI_NOMOR_KONTRAK_DARI_NOMOR_PELANGGAN_URL = WS_UMUM_PREFIX
			+ "cariNoKont_dari_Nopel.json";
	private static final String CARI_TERBILANG_URL = WS_UMUM_PREFIX
			+ "cariTerbilang.json";
	private static final String URAIAN_TAHUN_BULAN_URL = WS_UMUM_PREFIX
			+ "uraianKeTahunBulan.json";
	private static final String CARI_IDPEL_DARI_KONTRAK_URL = WS_UMUM_PREFIX
			+ "cariIDPELdariKONTRAK.json";
	private static final String CARI_IDPEL_DARI_KONTROL_URL = WS_UMUM_PREFIX
			+ "cariIDPELdariKONTROL.json";
	private static final String AMBIL_DIL_PELANGGAN_URL = WS_UMUM_PREFIX
			+ "ambilDILPelanggan.json";
	private static final String LIHAT_NAMA_PP_DARI_KODE_PP_URL = WS_UMUM_PREFIX
			+ "lihatNAMAPPdariKODEPP.json";
	private static final String RUBAH_TANGGAL_URL = WS_UMUM_PREFIX
			+ "rubahTanggal.json";
	private static final String CREATE_TANGGAL_AGENDA_URL = WS_UMUM_PREFIX
			+ "createNoAgenda.json";
	private static final String CARI_JATUH_TEMPO_URL = WS_UMUM_PREFIX
			+ "cariJatuhTempo.json";
	private static final String CARI_JATUH_TEMPO_SIKLIS_URL = WS_UMUM_PREFIX
			+ "cariJatuhTempoSiklis.json";
	private static final String AMBIL_UNIT_UP_DARI_IDPEL = WS_UMUM_PREFIX
			+ "ambilUNITUPdariIDPEL.json";
	private static final String AMBIL_KODE_SIKLIS_DARI_IDPEL = WS_UMUM_PREFIX
			+ "ambilKODESIKLISdariIDPEL.json";
	private static final String AMBIL_KODE_PP = WS_UMUM_PREFIX
			+ "AmbilKodePP.json";
	private static final String AMBIL_BULAN_MINUS_SATU_URL = WS_UMUM_PREFIX
			+ "ambilBulanMinusSatu.json";
	private static final String AMBIL_BULAN_TAMBAH_SATU_URL = WS_UMUM_PREFIX
			+ "ambilBulanTambahSatu.json";
	private static final String CARI_JATUH_TEMPO_DARI_BULAN_URL = WS_UMUM_PREFIX
			+ "cariJatuhTempoDariBulan.json";
	private static final String AMBIL_DATA_SET_RANTING_RAYON_SEMUA = WS_UMUM_PREFIX
			+ "ambilDataSetRANTINGRAYONsemua.json";
	private static final String AMBIL_DATA_SET_RANTING_RAYON_UNIT_DEFAULT = WS_UMUM_PREFIX
			+ "ambilDataSetRANTINGRAYONunitdefault.json";
	private static final String AMBIL_KODE_UNIT_DEFAULT = WS_UMUM_PREFIX
			+ "ambilKODEUNITdefault.json";
	private static final String AMBIL_KODE_CABANG_DEFAULT = WS_UMUM_PREFIX
			+ "ambilKODECABANGdefault.json";
	private static final String AMBIL_KODE_WILAYAH_DEFAULT = WS_UMUM_PREFIX
			+ "ambilKODEWILAYAHdefault.json";
	private static final String AMBIL_NAMA_UNIT_DEFAULT = WS_UMUM_PREFIX
			+ "ambilNAMAUNITdefault.json";
	private static final String AMBIL_NAMA_CABANG_DEFAULT = WS_UMUM_PREFIX
			+ "ambilNAMACABANGdefault.json";
	private static final String AMBIL_NAMA_WILAYAH_DEFAULT = WS_UMUM_PREFIX
			+ "ambilNAMAWILAYAHdefault.json";
	private static final String AMBIL_ALAMAT_DEFAULT = WS_UMUM_PREFIX
			+ "ambilALAMATdefault.json";
	private static final String AMBIL_TANGGAL_DARI_THBL_DEFAULT = WS_UMUM_PREFIX
			+ "ambilTanggalDariTHBL.json";
	private static final String AMBIL_NAMA_UNIT_DARI_KODE_UNIT = WS_UMUM_PREFIX
			+ "ambilNamaUnitDariKodeUnit.json";
	private static final String REF_AMBIL_INDUK = WS_UMUM_PREFIX
			+ "ref_AmbilInduk.json";
	private static final String REF_AMBIL_CABANG = WS_UMUM_PREFIX
			+ "ref_AmbilCabang.json";
	private static final String REF_AMBIL_RANTING = WS_UMUM_PREFIX
			+ "ref_AmbilRanting.json";

	public static String getBulanMinusSatuURL(String thbl) {
		UrlBuilder builder = new UrlBuilder();
		builder.setParameter("thbl", thbl);
		builder.setPath(AMBIL_BULAN_MINUS_SATU_URL);
		return builder.toString();
	}

	public static String getBulanTambahSatuURL(String thbl) {
		UrlBuilder builder = new UrlBuilder();
		builder.setParameter("thbl", thbl);
		builder.setPath(AMBIL_BULAN_TAMBAH_SATU_URL);
		return builder.toString();
	}

	public static String getCariIdPelangganDariKontrakURL(String kontrak) {
		UrlBuilder builder = new UrlBuilder();
		builder.setParameter("kont", kontrak);
		builder.setPath(CARI_IDPEL_DARI_KONTRAK_URL);
		return builder.toString();
	}

	public static String getCariIdPelangganDariKontrolURL(String kontrol) {
		UrlBuilder builder = new UrlBuilder();
		builder.setParameter("kont", kontrol);
		builder.setPath(CARI_IDPEL_DARI_KONTROL_URL);
		return builder.toString();
	}

	public static String getCariJatuhTempoDariBulaURL(String thbl,
			String kdupnumerik) {
		UrlBuilder builder = new UrlBuilder();
		builder.setParameter("thbl", thbl);
		builder.setParameter("kdupnumerik", kdupnumerik);
		builder.setPath(CARI_JATUH_TEMPO_DARI_BULAN_URL);
		return builder.toString();
	}

	public static String getCariJatuhTempoSiklisURL(String idPelanggan,
			Date tanggal) {
		UrlBuilder builder = new UrlBuilder();
		builder.setParameter("idpel", idPelanggan);
		builder.setParameter("tgl", DEFAULT_DATETIME_FORMATER.format(tanggal));
		builder.setPath(CARI_JATUH_TEMPO_SIKLIS_URL);
		return builder.toString();
	}

	public static String getCariJatuhTempoURL(Date tanggal, String ikdupnumerik) {
		UrlBuilder builder = new UrlBuilder();
		builder.setParameter("tgl", DEFAULT_DATETIME_FORMATER.format(tanggal));
		builder.setParameter("kdupnumerik", ikdupnumerik);
		builder.setPath(CARI_JATUH_TEMPO_URL);
		return builder.toString();
	}

	public static String getCariNomorKontrakURL(String nomorPelanggan) {
		UrlBuilder builder = new UrlBuilder();
		builder.setParameter("nopel", nomorPelanggan);
		builder.setPath(CARI_NOMOR_KONTRAK_DARI_NOMOR_PELANGGAN_URL);
		return builder.toString();
	}

	public static String getCariTerbilangURL(Double numerik) {
		UrlBuilder builder = new UrlBuilder();
		builder.setParameter("numerik", numerik.toString());
		builder.setPath(CARI_TERBILANG_URL);
		return builder.toString();
	}

	public static String getCariUraianAsliURL(Date jthTempo) {
		UrlBuilder builder = new UrlBuilder();
		builder.setParameter("jthTempo",
				DEFAULT_DATETIME_FORMATER.format(jthTempo));
		builder.setPath(CARI_URAIAN_ASLI_URL);
		return builder.toString();
	}

	/**
	 * URL untuk mengambil CARI_URAIAN_URL dari WS UMUM REST Service
	 * 
	 * @param jthTempo
	 * @return
	 */
	public static String getCariUraianURL(Date jthTempo) {
		UrlBuilder builder = new UrlBuilder();
		builder.setParameter("jthTempo",
				DEFAULT_DATETIME_FORMATER.format(jthTempo));
		builder.setPath(CARI_URAIAN_URL);
		return builder.toString();
	}

	public static String getCreateTanggalAgendaURL(String ikdupnumerik) {
		UrlBuilder builder = new UrlBuilder();
		builder.setParameter("ikdupnumerik", ikdupnumerik);
		builder.setPath(CREATE_TANGGAL_AGENDA_URL);
		return builder.toString();
	}

	public static String getDataSetRantingRayonSemuaURL() {
		UrlBuilder builder = new UrlBuilder();
		builder.setPath(AMBIL_DATA_SET_RANTING_RAYON_SEMUA);
		return builder.toString();
	}

	public static String getDataSetRantingRayonUnitDefaultURL() {
		UrlBuilder builder = new UrlBuilder();
		builder.setPath(AMBIL_DATA_SET_RANTING_RAYON_UNIT_DEFAULT);
		return builder.toString();
	}

	public static String getDILPelangganURL(String idPelanggan) {
		UrlBuilder builder = new UrlBuilder();
		builder.setParameter("idpel", idPelanggan);
		builder.setPath(AMBIL_DIL_PELANGGAN_URL);
		return builder.toString();
	}

	public static String getKodeCabangDefaultURL() {
		UrlBuilder builder = new UrlBuilder();
		builder.setPath(AMBIL_KODE_CABANG_DEFAULT);
		return builder.toString();
	}

	public static String getKodePPURL() {
		UrlBuilder builder = new UrlBuilder();
		builder.setPath(AMBIL_KODE_PP);
		return builder.toString();
	}

	/**
	 * URL untuk mengambil KODE_PP_DARI_UNIT_UP_URL dari WS UMUM REST Service
	 * 
	 * @param unitUp
	 * @return URL location
	 */
	public static String getKodePPURL(String unitUp) {
		UrlBuilder builder = new UrlBuilder();
		builder.setParameter("unitUp", unitUp);
		builder.setPath(KODE_PP_DARI_UNIT_UP_URL);
		return builder.toString();
	}

	public static String getKodeSiklisDariIdPelangganURL(String idPelanggan) {
		UrlBuilder builder = new UrlBuilder();
		builder.setParameter("idpel", idPelanggan);
		builder.setPath(AMBIL_KODE_SIKLIS_DARI_IDPEL);
		return builder.toString();
	}

	public static String getKodeUnitDefaultURL() {
		UrlBuilder builder = new UrlBuilder();
		builder.setPath(AMBIL_KODE_UNIT_DEFAULT);
		return builder.toString();
	}

	public static String getKodeWilayahDefaultURL() {
		UrlBuilder builder = new UrlBuilder();
		builder.setPath(AMBIL_KODE_WILAYAH_DEFAULT);
		return builder.toString();
	}

	public static final String getLihatNamaPPDariKodePPURL(String kodepp) {
		UrlBuilder builder = new UrlBuilder();
		builder.setParameter("kodepp", kodepp);
		builder.setPath(LIHAT_NAMA_PP_DARI_KODE_PP_URL);
		return builder.toString();
	}

	public static String getNamaAlamatDefaultURL() {
		UrlBuilder builder = new UrlBuilder();
		builder.setPath(AMBIL_ALAMAT_DEFAULT);
		return builder.toString();
	}

	public static String getNamaCabangDefaultURL() {
		UrlBuilder builder = new UrlBuilder();
		builder.setPath(AMBIL_NAMA_CABANG_DEFAULT);
		return builder.toString();
	}

	public static String getNamaUnitDariKodeUnitURL(String kodeUnit) {
		UrlBuilder builder = new UrlBuilder();
		builder.setPath(AMBIL_NAMA_UNIT_DARI_KODE_UNIT);
		builder.setParameter("kodeunit", kodeUnit);
		return builder.toString();
	}

	public static String getNamaUnitDefaultURL() {
		UrlBuilder builder = new UrlBuilder();
		builder.setPath(AMBIL_NAMA_UNIT_DEFAULT);
		return builder.toString();
	}

	/**
	 * URL untuk mengambil NAMA_UP_URL dari WS UMUM REST Service
	 * 
	 * @param unitUp
	 * @return URL location
	 */
	public static String getNamaUpURL(String unitUp) {
		UrlBuilder builder = new UrlBuilder();
		builder.setParameter("unitUp", unitUp);
		builder.setPath(NAMA_UP_URL);
		return builder.toString();
	}

	public static String getNamaWilayahDefault() {
		UrlBuilder builder = new UrlBuilder();
		builder.setPath(AMBIL_NAMA_WILAYAH_DEFAULT);
		return builder.toString();
	}

	public static String getREFAmbilCabangURL(String induk) {
		UrlBuilder builder = new UrlBuilder();
		builder.setPath(REF_AMBIL_CABANG);
		builder.setParameter("induk", induk);
		return builder.toString();
	}

	public static String getREFAmbilIndukURL() {
		UrlBuilder builder = new UrlBuilder();
		builder.setPath(REF_AMBIL_INDUK);
		return builder.toString();
	}

	public static String getREFAmbilRanting(String cabang) {
		UrlBuilder builder = new UrlBuilder();
		builder.setPath(REF_AMBIL_RANTING);
		builder.setParameter("cabang", cabang);
		return builder.toString();
	}

	public static String getRubahTanggalURL(Date date) {
		UrlBuilder builder = new UrlBuilder();
		builder.setParameter("datepicker",
				DEFAULT_DATETIME_FORMATER.format(date));
		builder.setPath(RUBAH_TANGGAL_URL);
		return builder.toString();
	}

	public static String getTanggalDariTHBLDefaultURL(String thbl) {
		UrlBuilder builder = new UrlBuilder();
		builder.setPath(AMBIL_TANGGAL_DARI_THBL_DEFAULT);
		builder.setParameter("thbl", thbl);
		return builder.toString();
	}

	/**
	 * URL untuk mengambil TANGGAL_DATABASE_URL dari WS UMUM REST Service
	 * 
	 * @return URL location
	 */
	public static String getTanggalDatabaseURL() {
		UrlBuilder builder = new UrlBuilder();
		builder.setPath(TANGGAL_DATABASE_URL);
		return builder.toString();
	}

	public static String getUnitUpDariIdPelanggan(String idPelanggan) {
		UrlBuilder builder = new UrlBuilder();
		builder.setParameter("idpel", idPelanggan);
		builder.setPath(AMBIL_UNIT_UP_DARI_IDPEL);
		return builder.toString();
	}

	/**
	 * URL untuk mengambil UNIT_UP_URL dari WS UMUM REST Service
	 * 
	 * @return URL location
	 */
	public static String getUnitUpURL() {
		UrlBuilder builder = new UrlBuilder();
		builder.setPath(UNIT_UP_URL);
		return builder.toString();
	}

	/**
	 * URL untuk mengambil UNIT_UP_DARI_PETUGAS_URL dari WS UMUM REST Service
	 * 
	 * @param idCurrentUser
	 * @return URL location
	 */
	public static String getUnitUpURL(String idCurrentUser) {
		UrlBuilder builder = new UrlBuilder();
		builder.setParameter("petugas", idCurrentUser);
		builder.setPath(UNIT_UP_DARI_PETUGAS_URL);
		return builder.toString();
	}

	public static String getUraianTahunBulanURL(String uraianInput) {
		UrlBuilder builder = new UrlBuilder();
		builder.setParameter("Uraianinput", uraianInput);
		builder.setPath(URAIAN_TAHUN_BULAN_URL);
		return builder.toString();
	}

}