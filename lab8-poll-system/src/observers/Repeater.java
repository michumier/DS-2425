package observers;

import poll.Poll;

public class Repeater implements VoteObserver {

 
    private int counter, frequence;
    private VoteObserver observer;

    

    public Repeater(int counter, VoteObserver observer) {
        this.counter = this.frequence = counter;
        this.observer = observer;
    }


    @Override
    public void recivedVote(Poll poll) {
        if(counter == frequence){
            observer.recivedVote(poll);
            counter = 1;
        }
        else{
            counter++;
        }
    }
}
