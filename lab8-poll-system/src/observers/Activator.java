package observers;

import poll.Poll;

public class Activator implements VoteObserver {

    private int counter;
    private VoteObserver observer;

    

    public Activator(int counter, VoteObserver observer) {
        this.counter = counter;
        this.observer = observer;
    }


    @Override
    public void recivedVote(Poll poll) {
        if(counter == 1){
            observer.recivedVote(poll);
        }
        else{
            counter--;
        }
    }

}
