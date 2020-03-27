package com.yedam.dev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		student s1= new student("Hong","S111",20);
		student s2= new student("Shin","S222",22);
		student s3= new student("Park","S333",30);
		System.out.println("==배열==");
		student[]studAry = {s1,s2,s3};
		for (student s:studAry) {
			System.out.println(s.toString());
			
		}
		System.out.println("==ArrayList==");
		List<student>list = new ArrayList<student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		for(student s: list) {
			System.out.println(s);
		}
		System.out.println("==Set==");
		Set<student> studSet = new HashSet<student>();
		studSet.add(s1);
		studSet.add(s2);
		studSet.add(s3);
		Iterator<student> iter=studSet.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("==Map=="); //key, value
		Map<Integer, student> studMap = new HashMap<Integer, student>();
		studMap.put(1, s1);
		studMap.put(1, s2);
		studMap.put(1, s3);
		Set<Integer> iSet = studMap.keySet();
		Iterator<Integer> iter2 = iSet.iterator();
		while(iter2.hasNext()) {
			Integer iKey = iter2.next();
			System.out.println("key: "+iKey+", value: "+studMap.get(iKey).toString());
		}
		System.out.println("==Map II==");
		Set<Map.Entry<Integer,student>>mSet = studMap.entrySet();
		Iterator<Map.Entry<Integer, student>>iter3 = mSet.iterator();
		while(iter3.hasNext()) {
			Map.Entry<Integer, student> rMap= iter3.next();
			System.out.println("key: "+rMap.getKey()+", value:" + rMap.getValue());
			
			
		}
		
				
	}
	}

