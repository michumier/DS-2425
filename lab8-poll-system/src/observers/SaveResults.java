package observers;

import poll.Poll;

public class SaveResults implements VoteObserver{

    @Override
    public void recivedVote(Poll poll) {
        System.out.println("\nGUARDAR RESULTADOS: Guardando resultados...");
        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nResultados guardados con éxito.");
    }

}
