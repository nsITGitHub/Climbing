package jp.co.bol.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.bol.entity.Climbing;
import jp.co.bol.entity.News;
import jp.co.bol.service.jim.Jim_All;
import jp.co.bol.service.jim.Jim_news_Nobolock;
import jp.co.bol.modal.Jim;
import jp.co.bol.repository.ClimbingRepository;
import jp.co.bol.repository.NewsRepository;

@Service
public class ClimbingService {

	@Autowired
	private ClimbingRepository climRepo;
	@Autowired
	private NewsRepository newsRepo;
	@Autowired
	private Jim_All jim_All;
	
	public List<Climbing> findAll(){
		return climRepo.findAll();
	}
	
	public List<News> newsFindAll(){
		return newsRepo.findAll();
	}
	
	public List<Climbing> display(List<String> name_jim) {
		List<Climbing>listAll = findAll();
		List<Climbing> resultList = new ArrayList<>();
		
		if(name_jim.contains("All")) {
			resultList = listAll;
		}
		else{
			for(String nj : name_jim) {
			for(Climbing list : listAll) {
				if(nj.contains(list.getBolJim()) && nj.contains(list.getBolName())){
					resultList.add(list);
				}
			}
		}
		}
		return resultList;
	}

	public List<Jim> category(){
		List<Climbing> listAll = findAll();
		List<Jim> jims = new ArrayList<>(); 
		
		for(int i=0; i<listAll.size(); i++) {
			boolean boo = false;
			Jim jim = new Jim();
			String BolName = listAll.get(i).getBolName();
			String Boljim = listAll.get(i).getBolJim();
			jim.setBolName(BolName);
			jim.setBolJim(Boljim);
		
			for(int j = 0; j<jims.size();j++) {
				if(jims.get(j).getBolName().contains(jim.getBolName()) && jims.get(j).getBolJim().contains(jim.getBolJim())) {
					boo = true;
					break;
				}
			}
			
			if(boo == true) continue;
			jims.add(jim);
		}	
		return jims;
	}
	
	
	public void delete() {
		List<Climbing> list = findAll();
		climRepo.deleteAll(list);
		List<News> listNews = newsFindAll();
		newsRepo.deleteAll(listNews);
		
	}
	
	public void update() {
		List<Climbing> listAll = findAll();
		List<Climbing> list = jim_All.climingList();
		
		for(int i=0; i<list.size(); i++) {
			boolean equal = false;
			
			Climbing clim = new Climbing();
			clim = list.get(i);
			for(int j = 0; j<listAll.size(); j++) {
				if(clim.getBolDate()==(listAll.get(j).getBolDate() )
				&& clim.getBolMonth()==(listAll.get(j).getBolMonth()) 
				&& clim.getBolName().equals(listAll.get(j).getBolName()) 
				&& clim.getBolText().equals(listAll.get(j).getBolText()) 
				){
					equal = true;
					break;
				}
			}
			if(equal == true) continue;
			climRepo.save(clim);
		}
		
	}
	public void updateNews() throws UnsupportedEncodingException {
		List<News> listAll = newsFindAll();
		List<News> listNews = jim_All.newsList();
		//System.out.println(listNews.get(4).getBolnews());
		for(News news : listNews) {
			//System.out.println(news.getBolnews());
			boolean equal = false;
			
			for(News list : listAll) {
				if(news.getBolYear()==list.getBolYear() 
				&& news.getBolMonth()==list.getBolMonth()
				&& news.getBolDate() == list.getBolDate()
				&& news.getBolnews().equals(list.getBolnews())) {
					equal = true;
					break;
				}
			}
			if(equal == true) continue;
			newsRepo.save(news);
		}
	}
	
}
