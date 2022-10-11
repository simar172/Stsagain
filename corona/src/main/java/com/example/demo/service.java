package com.example.demo;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class service {
	final String str = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_US.csv";

	List<getset> li=new ArrayList<>();
	
	
	@PostConstruct
	public void fetch() throws IOException, InterruptedException {
		var a = HttpRequest.newBuilder().GET().uri(URI.create(str)).build();
		var b = HttpClient.newBuilder().build();
		var c = b.send(a, HttpResponse.BodyHandlers.ofString());
		StringReader st=new StringReader(c.body());
		Iterable<CSVRecord> it=CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(st);
		for(CSVRecord rec:it) {
			String name=rec.get("Province_State");
			String cnt=rec.get("Country_Region");
			li.add(new getset(name, cnt,Integer.parseInt(rec.get(rec.size()-1))));
//			System.out.println(li);
		}
		
	}


	public List<getset> getLi() {
		return li;
	}


	public void setLi(List<getset> li) {
		this.li = li;
	}
}
