package jp.co.bol.service.jim;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.bol.entity.Climbing;
import jp.co.bol.entity.News;

@Service
public class Jim_All {
	
	@Autowired
	private Jim_calendar_Nobolock J_Nobo;
	@Autowired
	private Jim_news_Nobolock J_news_Nobo;
	
	//各ジムのlistを一つにまとめる
	public List<Climbing> climingList(){
		List<Climbing> listAll = new ArrayList<>();
		
		//listAllに格納
		listAll.addAll(J_Nobo.Jim_Nobolock());
		
		System.out.println(listAll.size());
		return listAll;
	}
	
	
	public List<News> newsList() throws UnsupportedEncodingException{
		List<News> newsAll = new ArrayList<>();
		
		//listAllに格納
		newsAll.addAll(J_news_Nobo.jm_news_Nobolock());
		return newsAll;
	}
	
}
