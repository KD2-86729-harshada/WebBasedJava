package beans;

import daos.CandidateDao;
import daos.CandidateDaoImpl;
import entities.Candidate;

public class addCandidate {
private int id;
private String name;
private String party;
private int vote;
private int res;



public addCandidate() {
	super();
}
public addCandidate(String name, String party) {
	super();
	this.name = name;
	this.party = party;
}

public int getRes() {
	return res;
}
public void setRes(int res) {
	this.res = res;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getParty() {
	return party;
}
public void setParty(String party) {
	this.party = party;
}
public int getVote() {
	return vote;
}
public void setVote(int vote) {
	this.vote = vote;
}

public void addCandidate() {
	
	try(CandidateDao candDao = new CandidateDaoImpl()){
		Candidate c=new Candidate(0,this.name,this.party,0);
		this.res=candDao.save(c);
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
}

}
