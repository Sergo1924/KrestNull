public class Main extends Thread{

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.start();
    }

    @Override
    public void run() {
        Window window = new Window();
        window.image();
    }
}
