package beans;

import java.util.ArrayList;
import java.util.List;

import daos.CandidateDao;
import daos.CandidateDaoImpl;
import entities.Candidate;

public class resultbin {

	private List<Candidate> candList;
	
	public resultbin() {
		this.candList=new ArrayList<Candidate>();
	}

	public List<Candidate> getCandList() {
		return candList;
	}

	public void setCandList(List<Candidate> candList) {
		this.candList = candList;
	}
	
	public void fetchCandidates() {
		try(CandidateDao candDao = new CandidateDaoImpl()){
			
			this.candList = candDao.findAll();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	
}
