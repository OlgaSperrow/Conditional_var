package ait.messeges;

import ait.messeges.Service.Receiver;
import ait.messeges.Service.Sender;
import ait.messeges.model.MessageBox;
import ait.messeges.model.MessageBoxB;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MessageBoxApp {
    private static final int N_MESSAGES = 20;
    private static final int N_RECEIVERS = 5;
private static MessageBox messageBox= new MessageBoxB();
    public static void main(String[] args) throws InterruptedException {
        Thread sender = new Thread(new Sender(messageBox, N_MESSAGES));
        for (int i = 0; i < N_RECEIVERS; i++) {
            Thread receiver = new Thread(new Receiver(messageBox));
            receiver.setDaemon(true);
            receiver.start();

        }
        Thread.sleep(100);
        sender.start();
        sender.join();
        Thread.sleep(100);
    }
}
