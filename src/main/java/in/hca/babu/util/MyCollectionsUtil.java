package in.hca.babu.util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface MyCollectionsUtil {

	public static Map<Integer,String> convertToMap(List<Object[]> list) {

Map<Integer,String> map = list.stream().
collect(Collectors.toMap(ob->Integer.valueOf(ob[0].toString()),ob->ob[1].toString()));

		return map;
	}

	public static Map<Integer, String> convertToMapIndex(List<Object[]> list) {
		
	Map<Integer,String> map=list.stream().collect(Collectors.toMap(ob->Integer.valueOf(ob[0].toString()),
	ob->ob[1].toString()+" "+ob[2].toString()));
		
	
		return map;
	}
	


}
