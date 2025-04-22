package ait.messeges.model;

public class MessageBoxA implements MessageBox{
    private String message;

    @Override
    public synchronized void post(String message) {
        this.message = message;
        notify();

    }

    @Override
    public String get() {
        while ( message == null){
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String res = message;
        message= null;
        return res;
    }
}
