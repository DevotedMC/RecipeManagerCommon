package haveric.recipeManagerCommon.data;

import java.util.UUID;

public class AbstractBlockID {
    private transient int hash;

    protected UUID wid;
    protected int x;
    protected int y;
    protected int z;

    public AbstractBlockID() { }

    protected void buildHash() {
        hash = (wid.toString() + ":" + x + ":" + y + ":" + z + ":").hashCode();
    }

    public UUID getWorldID() {
        return wid;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }


    /**
     * @return coordinates in x,y,z format string
     */
    public String getCoordsString() {
        return x + "," + y + "," + z;
    }

    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof AbstractBlockID)) {
            return false;
        }

        AbstractBlockID b = (AbstractBlockID) obj;

        return (b.x == x && b.y == y && b.z == z && b.wid.equals(wid));
    }
}
