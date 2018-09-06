package AutoCreateTable;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ReadFields {
	/*public static void main(String[] args) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(
						"G:\\WORK\\java_work\\practice\\test1.txt")));
		String line = br.readLine();
		while((line)!=null){
			String[] strs = line.split("-");
			map.put(strs[0],strs[1]);
			line = br.readLine();
		}
		
//		Set<String> keys = map.keySet();
//		Iterator<String> it = keys.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
//		System.out.println("---------------");
//		Collection values =  map.values();
//		Iterator<String> it1 = values.iterator();
//		while(it1.hasNext()){
//			System.out.println(it1.next());
//		}
		
		Set<Entry<String, String>> maps = map.entrySet();
		Iterator<Entry<String, String>> it2 = maps.iterator();
		while(it2.hasNext()){
			Entry<String,String> entry = it2.next();
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+":"+value);
		}
	}*/
	
	public static Map<String,String> context() throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(
						"G:\\WORK\\java_work\\practice\\test1.txt")));
		String line = br.readLine();
		while((line)!=null){
			String[] strs = line.split("-");
			map.put(strs[0],strs[1]);
			line = br.readLine();
		}
		
		
		Set<Entry<String, String>> maps = map.entrySet();
		Iterator<Entry<String, String>> it2 = maps.iterator();
		while(it2.hasNext()){
			Entry<String,String> entry = it2.next();
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+":"+value);
		}
		return map;
	}
	public static void main(String[] args) {
		try {
			ReadFields.context();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
