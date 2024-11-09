package observers;

import poll.Poll;

public class BarChart implements VoteObserver{

    @Override
    public void recivedVote(Poll poll) {
        System.out.println("\nDibujando grafico de barras");
		int yesVotes=poll.yeses();
		int noVotes=poll.nos();
		System.out.print("SI: ");
		while (yesVotes > 0){
			System.out.print("X");
			yesVotes--;
		}
		System.out.print("\nNO: ");
		while (noVotes > 0){
			System.out.print("X");
			noVotes--;
		}
		System.out.println("\nFin grafico de barras");
    }

}
