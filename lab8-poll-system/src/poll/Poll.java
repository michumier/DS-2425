package poll;

import java.util.List;

import observers.VoteObserver;

public class Poll 
{
	private int yeses;
	private int nos;
	private String question;
	private List<VoteObserver> observerList;
	
	public Poll(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public int yeses() {
		return yeses;
	}

	public int nos() {
		return nos;
	}

	public void incrementYeses() {
		yeses++;
		updateObserver();
	}

	public void incrementNos() {
		nos++;
		updateObserver();
	}

	public void addObserver(VoteObserver observer){
		observerList.add(observer);
	}

	public void removeObserver(VoteObserver observer){
		observerList.remove(observer);
	}

	public void updateObserver(){
		for(VoteObserver vo: observerList){
			vo.recivedVote(this);
		}
	}
}
