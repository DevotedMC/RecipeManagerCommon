package haveric.recipeManagerCommon.recipes;

public enum RMCRecipeType {
    ANY(null),
    BREW("brew"),
    CRAFT("craft"),
    COMBINE("combine"),
    WORKBENCH(null),
    SMELT("smelt"),
    FUEL("fuel"),
    SPECIAL("special");

    private final String directive;

    private RMCRecipeType(String newDirective) {
        directive = newDirective;
    }

    public String getDirective() {
        return directive;
    }
}
