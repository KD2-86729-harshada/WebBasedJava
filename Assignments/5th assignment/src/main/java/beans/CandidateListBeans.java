package beans;

import java.util.ArrayList;
import java.util.List;

import daos.CandidateDao;
import daos.CandidateDaoImpl;
import entities.Candidate;

public class CandidateListBeans {

	
	
	private List<Candidate>  candList;
	
	public CandidateListBeans(){
		this.candList=new ArrayList<>();
	}

	public List<Candidate> getCandList() {
		return candList;
	}

	public void setCandList(List<Candidate> candList) {
		this.candList = candList;
	}
	
	public void fetchCandidate() {
		try(CandidateDao candDao=new CandidateDaoImpl()){
			
			this.candList=candDao.findAll();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
