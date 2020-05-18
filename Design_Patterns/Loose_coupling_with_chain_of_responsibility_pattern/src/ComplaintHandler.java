public class ComplaintHandler implements Handler {

    private Handler chain;
    @Override
    public void setNextChain(Handler nextChain) {
        this.chain=nextChain;
    }

    @Override
    public void forwardMail(Mail mailObj) {
        if(mailObj.getSubject().equalsIgnoreCase(Handler.COMPLAINT_MAIL)){
            System.out.println("Forwarding Mail to HR Department.");
        }else{
            this.chain.forwardMail(mailObj);
        }
    }
}
