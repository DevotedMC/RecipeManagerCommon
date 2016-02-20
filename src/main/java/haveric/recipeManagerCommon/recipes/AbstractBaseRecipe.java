package haveric.recipeManagerCommon.recipes;

import haveric.recipeManagerCommon.RMCChatColor;

public abstract class AbstractBaseRecipe {
    protected String name;
    protected boolean customName;
    protected int hash;

    public AbstractBaseRecipe() { }

    public AbstractBaseRecipe(AbstractBaseRecipe newRecipe) {
        name = newRecipe.name;
        customName = newRecipe.customName;
        hash = newRecipe.hash;
    }

    public abstract RMCRecipeInfo getInfo();

    public RMCRecipeType getType() {
        return null;
    }

    /**
     * Returns the auto-generated name or the custom name (if set) of the recipe.
     *
     * @return recipe name, never null.
     */
    public String getName() {
        if (name == null) {
            resetName();
        }

        return name;
    }

    public abstract void setName(String newName);

    /**
     * @return true if recipe has custom name or false if it's auto-generated.
     */
    public boolean hasCustomName() {
        return customName;
    }

    /**
     * Reset name to the auto-generated one.
     */
    public void resetName() {
        name = "unknown recipe";
        customName = false;
    }

    public boolean isValid() {
        return false; // empty recipe, invalid!
    }

    public int getIndex() {
        return hash;
    }

    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof AbstractBaseRecipe)) {
            return false;
        }

        return obj.hashCode() == hashCode();
    }


    /**
     * @return Recipe short string for book contents index
     */
    public String printBookIndex() {
        return RMCChatColor.RED + "(undefined)";
    }

    /**
     * @return Recipe detail string that can fit inside a book.
     */
    public String printBook() {
        return RMCChatColor.RED + "(undefined)";
    }

    /**
     * @return Recipe detail string that can fit in the chat.
     */
    public String printChat() {
        String print = printBook();

        print = print.replace(RMCChatColor.WHITE.toString(), RMCChatColor.MAGIC.toString());
        print = print.replace(RMCChatColor.BLACK.toString(), RMCChatColor.WHITE.toString());
        print = print.replace(RMCChatColor.MAGIC.toString(), RMCChatColor.BLACK.toString());

        return print;
    }
}
