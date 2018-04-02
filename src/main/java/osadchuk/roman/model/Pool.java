package osadchuk.roman.model;

public class Pool {
    public int id;
    public SportBuilding sportBuilding;
    public int depth;
    public int width;
    public int length;
    public int maxHeight;

    public Pool(int id, SportBuilding sportBuilding, int depth, int width, int length, int maxHeight) {
        this.id = id;
        this.sportBuilding = sportBuilding;
        this.depth = depth;
        this.width = width;
        this.length = length;
        this.maxHeight = maxHeight;
    }

    public Pool() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SportBuilding getSportBuilding() {
        return sportBuilding;
    }

    public void setSportBuilding(SportBuilding sportBuilding) {
        this.sportBuilding = sportBuilding;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }
}
