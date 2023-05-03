package PaqI01;

public class Hub {
    private Container[][] hub;
    private int containersRow;

    public Hub() {
        hub = new Container[10][12];
        containersRow = 9;
    }

    public boolean stackContainer(Container container) {

        int col = -1;

        if (container.getPriority() == 1) {
            col = 0;
        } else if (container.getPriority() == 2) {
            col = 1;
        } else {
            for (int i = 2; i < 12; i++) {
                if (hub[0][i] == null) {
                    col = i;
                    break;
                }
            }
        }

        if (col != -1) {
            if (containersRow==0){
                col++;
                containersRow=9;
            }
            hub[containersRow][col] = container;
            containersRow--;
            return true;
        } else {
            return false;
        }
    }

    public void removeContainer(int column) {
        int i;
        for(i=9;i>0;i--){
            hub[i][column] = null;
            containersRow++;
        }
    }
    public String showDescription(int id){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (hub[i][j] != null && hub[i][j].getID() == id)
                    return hub[i][j].toString();
            }
        }
        return "null";
    }

    public Container getContainerById(int id) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                Container container = hub[i][j];
                if (container != null && container.getID() == id) {
                    return container;
                }
            }
        }
        System.out.println("Container not found.");
        return null;
    }

    public int count(String country){
        int x = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                Container container = hub[i][j];
                if (container != null && container.getOrg().equals(country)) {
                    x++;
                }
            }
        }
        return x;
    }

    public String printHub() {
        StringBuilder stringHub = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (hub[i][j] == null) {
                    stringHub.append("O ");
                } else if (hub[i][j] != null) {
                    stringHub.append("X ");
                }
            }
            stringHub.append("\n");
        }
        return stringHub.toString();
    }
}