package haveric.recipeManagerCommon.flags;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractArgs {
    private String playerName;
    private Object extra;

    private List<String> reasons;
    private List<String> effects;

    public void setPlayerName(String newPlayerName) {
        playerName = newPlayerName;
    }

    public void setExtra(Object newExtra) {
        extra = newExtra;
    }

    public String playerName() {
        return playerName;
    }

    public boolean hasPlayerName() {
        return playerName != null;
    }

    public Object extra() {
        return extra;
    }

    public boolean hasExtra() {
        return extra != null;
    }

    public List<String> reasons() {
        return reasons;
    }

    public boolean hasReasons() {
        return (reasons != null && !reasons.isEmpty());
    }

    public void addCustomReason(String message) {
        if (reasons == null) {
            reasons = new ArrayList<String>();
        }

        reasons.add(message);
    }

    public void clearReasons() {
        if (reasons != null) {
            reasons.clear();
        }
    }

    public List<String> effects() {
        return effects;
    }

    public boolean hasEffects() {
        return (effects != null && !effects.isEmpty());
    }

    public void addCustomEffect(String message) {
        if (effects == null) {
            effects = new ArrayList<String>();
        }

        effects.add(message);
    }

    public void clearEffects() {
        if (effects != null) {
            effects.clear();
        }
    }

    public void clear() {
        clearReasons();
        clearEffects();
    }
}
