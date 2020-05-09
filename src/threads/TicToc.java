package threads;

class ResourceLock{
    public int flag = 1;
}

class Task1 extends Thread {
	ResourceLock lock;
	 
    Task1 (ResourceLock lock){
        this.lock = lock;
    }
 
    @Override
    public void run() {
 
        try{
            synchronized (lock) {
 
                for (int i = 0; i < 10; i++) {
 
                    while(lock.flag!=1){
                        lock.wait();
                    }
 
                    System.out.println("Tic");
                    Thread.sleep(100);
                    lock.flag = 2;
                    lock.notifyAll();
                }
 
            }
        }catch (Exception e) {
            System.out.println("Exception Task1");
        }
 
    }
}

class Task2 extends Thread {
	ResourceLock lock;
	 
    Task2 (ResourceLock lock){
        this.lock = lock;
    }
 
    @Override
    public void run() {
 
        try{
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    while(lock.flag!=2){
                        lock.wait();
                    }
                    System.out.println("Toc");
                    Thread.sleep(1000);
                    lock.flag = 1;
                    lock.notifyAll();
                }
 
            }
        }catch (Exception e) {
            System.out.println("Exception Task2");
        }
    }
    
}
public class TicToc {
	public static void main(String[] args) {
		
		ResourceLock lock = new ResourceLock();
		 
        Task1 task1 = new Task1(lock);
        Task2 task2 = new Task2(lock);
 
        task1.start();
        task2.start();
	}
}
