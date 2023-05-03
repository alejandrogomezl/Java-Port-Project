package PaqI01;

public class Container {
    int ID;
    int weight;
    String org;
    boolean inspected;
    int priority;
    String description;
    String sender;
    String reciver;

    public Container() {

    }

    public Container(int ID, int weight, String org, boolean inspected, int priority, String description, String sender, String reciver) {
        this.ID = ID;
        this.weight = weight;
        this.org = org;
        this.inspected = inspected;
        this.priority = priority;
        this.description = description;
        this.sender = sender;
        this.reciver = reciver;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public boolean isInspected() {
        return inspected;
    }

    public void setInspected(boolean inspected) {
        this.inspected = inspected;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciver() {
        return reciver;
    }

    public void setReciver(String reciver) {
        this.reciver = reciver;
    }
    @Override
    public String toString() {
        return "Container [id=" + ID + ", weight=" + weight + ", countryOfOrigin=" + org
                + ", isCustomsInspected=" + inspected + ", priorityLevel=" + priority
                + ", contentDescription=" + description + ", sendingCompany=" + sender
                + ", receivingCompany=" + reciver + "]";
    }

}
