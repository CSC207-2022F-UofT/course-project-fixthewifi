package client.interface_adapters.model.model_entities;

import java.util.List;

public abstract class Chat
{
    private final int chatUid;
    private final ChatProfile profile;
    private final List<Message> messages;

    public Chat(int chatUid, ChatProfile profile, List<Message> messages)
    {
        this.chatUid = chatUid;
        this.profile = profile;
        this.messages = messages;
    }

    @Override
    public abstract String toString();

    public int getUid()
    {
        return chatUid;
    }

    public String getName() {
        return profile.getName();
    }

    public void setName(String name) {
        profile.setName(name);
    }

    public String getDescription() {
        return profile.getDescription();
    }

    public void setDescription(String description) {
        profile.setDescription(description);
    }

    public ProfilePicture getProfilePicture() {
        return profile.getProfilePicture();
    }

    public void setProfilePicture(ProfilePicture pic) {setProfilePicture(pic); }

    public void addMsg(Message msg)
    {
        messages.add(msg);
    }

    public void deleteMsgContent(int msgUid)
    {
        messages.get(msgUid).setContent("DELETED");
    }

    public abstract List<Integer> getMembersUid();
    public void updateMsgContent(int msgUid, String newContent)
    {
        messages.get(msgUid).setContent(newContent);
    }

}
