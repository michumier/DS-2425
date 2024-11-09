package observers;

import poll.Poll;

public class StateLine implements VoteObserver{

    @Override
    public void recivedVote(Poll poll) {
        System.out.println("\nVOTOS RECIBIDOS: SI = " + poll.yeses() + " / NO = " + poll.nos());
    }

}
