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

	public static String getCariUraianURL(Date jthTempo) {
		UrlBuilder builder = new UrlBuilder();
		builder.setParameter("jthTempo",
				DEFAULT_DATETIME_FORMATER.format(jthTempo));
		builder.setPath(CARI_URAIAN_URL);
		return builder.toString();
	}

	/**
	 * URL untuk mengambil KODE_PP_DARI_UNIT_UP_URL dari WS UMUM REST Service
	 * 
	 * @param unitUp
	 * @return URL location
	 */
	public static String getKodePpURL(String unitUp) {
		UrlBuilder builder = new UrlBuilder();
		builder.setParameter("unitUp", unitUp);
		builder.setPath(KODE_PP_DARI_UNIT_UP_URL);
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

}