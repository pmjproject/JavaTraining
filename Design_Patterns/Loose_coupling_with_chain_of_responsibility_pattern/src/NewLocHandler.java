public class NewLocHandler implements Handler {
    private Handler chain;
    @Override
    public void setNextChain(Handler nextChain) {
        this.chain=nextChain;
    }

    @Override
    public void forwardMail(Mail mailObj) {
        if(mailObj.getSubject().equalsIgnoreCase(Handler.NEW_LOC_MAIL)){
            System.out.println("Forwarding Mail to  Development Group.");
        }else{
            this.chain.forwardMail(mailObj);
        }
    }
}
