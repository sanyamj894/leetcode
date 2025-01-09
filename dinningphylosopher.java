public class dinningphylosopher {

    Object leftFork = new Object();
    Object rightFork = new Object();

    public DiningPhilosophers() {
        
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {

        synchronized (leftFork) {
            synchronized (rightFork) {
                pickLeftFork.run();
                pickRightFork.run();
                eat.run();
                putRightFork.run();
                putLeftFork.run();
            }

        }

    }
}
