package helpers;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SubjectTerm;


public class EmailUtils {
    private Folder folder;

    public enum EmailFolder {
        INBOX("INBOX");
        private String text;
        private EmailFolder(String text){
            this.text = text;
        }
        public String getText() {
            return text;
        }
    }

    public EmailUtils(UserModel user, EmailFolder emailFolder) throws MessagingException {
        Properties properties = new Properties();
        Session session = Session.getInstance(properties);
        Store store = session.getStore("imaps");
        store.connect(Globals.GMAIL_HOST, Globals.GMAIL_PORT, user.gmailEmail, user.gmailAppPassword);
        folder = store.getFolder(emailFolder.getText());
        folder.open(Folder.READ_WRITE);
    }

    public int getNumberOfUnreadMessages() throws MessagingException {
        return folder.getUnreadMessageCount();
    }

    public void setAllMessagesAsRead() throws MessagingException {

        if (this.getNumberOfUnreadMessages() == 0) {
            return;
        }
        Message[] messages = folder.getMessages();

        for (Message message : messages) {

            if (!message.isSet(Flags.Flag.SEEN)) {
                message.setFlag(Flags.Flag.SEEN, true);
            }
        }
    }

    public Message[] getUnreadMessagesBySubject(String partOfSubject) throws MessagingException {
        Message messages[] = folder.search(new SubjectTerm(partOfSubject), folder.getMessages());
        List<Message> unreadMessages = new ArrayList<Message>();

        for (Message message : messages) {

            if (!message.isSet(Flags.Flag.SEEN)) {
                unreadMessages.add(message);
            }
        }
        return unreadMessages.toArray(new Message[]{});
    }

    public Message waitForMessageWithSubject(String partOfSubject) throws MessagingException, InterruptedException {
        Message[] messages = null;
        Instant deadline = Instant.now().plusSeconds(60);

        while (Instant.now().isBefore(deadline)) {
            messages = this.getUnreadMessagesBySubject(partOfSubject);

            if (messages.length == 0) {
                Thread.sleep(1000);
                continue;
            }
            return messages[0];
        }
        return null;
    }

    public String getCode() throws MessagingException, InterruptedException, IOException {
        return this.waitForMessageWithSubject("Verification Code").getContent().toString().split(":")[1].trim();
    }

}
