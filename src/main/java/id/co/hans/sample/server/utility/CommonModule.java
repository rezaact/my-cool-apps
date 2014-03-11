package id.co.hans.sample.server.utility;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonModule {
	public static List<Map<String,Object>> convertResultsetToList(ResultSet rs){
    	List<Map<String,Object>> lst = new ArrayList<Map<String,Object>>();
    	try {    	
	    	ResultSetMetaData rsmd = rs.getMetaData();
                int colCount = rsmd.getColumnCount();

                while (rs.next()) {
                    HashMap<String,Object> map = new HashMap<String,Object>();
                    for (int i = 1; i <= colCount; i++) {
                        try{
                            
                            if(rs.getObject(i).getClass().getName().equals("java.sql.Date")){
                                map.put(rsmd.getColumnName(i).toLowerCase(), new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(rs.getDate(i)));
                            }else{
                                map.put(rsmd.getColumnName(i).toLowerCase(), rs.getObject(i));
                            }
                            
                        }catch(Exception e){
                            map.put(rsmd.getColumnName(i).toLowerCase(), "");
                        }
                    }
                    lst.add(map);
                }
        } catch (Exception ex){
                ex.printStackTrace();
        }
	    
    	return lst;
    }   
	
	public static List<Map<String,String>> convertResultsetToListStr(ResultSet rs){
    	List<Map<String,String>> lst = new ArrayList<Map<String,String>>();
    	try {    	
	    	ResultSetMetaData rsmd = rs.getMetaData();
		    int colCount = rsmd.getColumnCount();
	            String value = "";
	        
		    while (rs.next()) {
		        HashMap<String,String> map = new HashMap<String,String>();
		        for (int i = 1; i <= colCount; i++) {
	                    try{
	                        if (rs.getObject(i).toString().equals("") || rs.getObject(i).toString().equals("null")){
	                            value = " ";
	                        }else{
	                            value = rs.getObject(i).toString();
	                        }
	                    }catch(Exception e){
	                        value = " ";
	                    }
		            map.put(rsmd.getColumnName(i).toLowerCase(), value);
		        }
		        lst.add(map);
		    }
		    
		    
	    	} catch (Exception ex)
			{
				ex.printStackTrace();
			}
	    
    	return lst;
    }
	
	public static String getNamaBulan(String bulan) {      
        String v_blth = bulan;
        String ret = "Error";
        String namabulan = "";
        try {
            if (v_blth.equals("01")) {
                namabulan = "JANUARI";
            } else if (v_blth.equals("02")) {
                namabulan = "FEBRUARI";
            } else if (v_blth.equals("03")) {
                namabulan = "MARET";
            } else if (v_blth.equals("04")) {
                namabulan = "APRIL";
            } else if (v_blth.equals("05")) {
                namabulan = "MEI";
            } else if (v_blth.equals("06")) {
                namabulan = "JUNI";
            } else if (v_blth.equals("07")) {
                namabulan = "JULI";
            } else if (v_blth.equals("08")) {
                namabulan = "AGUSTUS";
            } else if (v_blth.equals("09")) {
                namabulan = "SEPTEMBER";
            } else if (v_blth.equals("10")) {
                namabulan = "OKTOBER";
            } else if (v_blth.equals("11")) {
                namabulan = "NOVEMBER";
            } else if (v_blth.equals("12")) {
                namabulan = "DESEMBER";     
            }
            
            ret = namabulan;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ret;
    }

}
