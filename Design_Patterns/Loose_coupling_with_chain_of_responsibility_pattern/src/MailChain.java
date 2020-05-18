public class MailChain {
    private Handler chain;

    public MailChain(){
        this.chain=new SpamHandler();

        Handler fanHandlerObj=new FanHandler();
        Handler complaingtHandlerObj=new ComplaintHandler();
        Handler newLocngtHandlerObj=new NewLocHandler();

        chain.setNextChain(fanHandlerObj);
        fanHandlerObj.setNextChain(complaingtHandlerObj);
        complaingtHandlerObj.setNextChain(newLocngtHandlerObj);

    }

    public static void main(String s[]) {

        MailChain mailChainObj =new MailChain();

        /*
         * calling a chain with Different Subject mail.
         */
        mailChainObj.chain.forwardMail(new Mail("SPAM_MAIL"));

        mailChainObj.chain.forwardMail(new Mail("FAN_MAIL"));

        mailChainObj.chain.forwardMail(new Mail("COMPLAINT_MAIL"));

        mailChainObj.chain.forwardMail(new Mail("NEW_LOC_MAIL"));

    }
}
