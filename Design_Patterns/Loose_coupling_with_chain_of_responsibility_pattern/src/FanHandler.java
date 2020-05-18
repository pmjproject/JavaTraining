public class FanHandler implements Handler {
    private Handler chain;

    @Override
    public void setNextChain(Handler nextChain) {
        this.chain=nextChain;

    }

    @Override
    public void forwardMail(Mail mailObj) {
        if(mailObj.getSubject().equalsIgnoreCase(Handler.FAN_MAIL)){
            System.out.println("Forwarding Mail to CEO.");
        }else{
            this.chain.forwardMail(mailObj);
        }

    }
}
