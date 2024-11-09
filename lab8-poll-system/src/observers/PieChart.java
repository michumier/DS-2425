package observers;

import poll.Poll;

public class PieChart implements VoteObserver {

    @Override
    public void recivedVote(Poll poll) {
        double gvs=poll.yeses();
		double gvn=poll.nos();
		double vsdegree=(gvs/(gvs+gvn))*360;
		double vndegree=(gvn/(gvs+gvn))*360;
		System.out.println("\nDibujando grafico circular--> si: "+vsdegree+" grados no: "+vndegree+" grados");
    }

}
