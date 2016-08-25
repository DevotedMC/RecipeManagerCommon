package haveric.recipeManagerCommon.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractRecipeBook {
    private String id;
    private String title;
    private String author;
    private String description;
    protected String customEnd;
    protected List<Set<String>> volumes = new ArrayList<Set<String>>();
    private int recipesPerVolume = 50;
    protected boolean cover = true;
    protected boolean contents = true;
    private boolean end = true;

    /**
     * Blank recipe book.<br>
     * Use methods to add recipes to book, set title, etc.<br>
     * Then register/update it on {@link RecipeBooks} class.
     */
    public AbstractRecipeBook(String newId) {
        id = newId;
    }

    /**
     * @return True if book is valid, false otherwise.
     */
    public boolean isValid() {
        return (id != null && title != null && !volumes.isEmpty());
    }

    /**
     * @return Book ID (usually file name without extension)
     */
    public String getId() {
        return id;
    }

    /**
     * @return Book title - can be equal to ID if not defined in YML file.
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String newAuthor) {
        author = newAuthor;
    }

    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            Book description for first page.
     */
    public void setDescription(String newDescription) {
        description = newDescription;
    }

    public int getRecipesPerVolume() {
        return recipesPerVolume;
    }

    /**
     * Sets how many recipes are added per volume.<br>
     * This only affects recipes that are added by {@link #addRecipe(BaseRecipe)} method or 'recipe' node in the yml file.
     *
     * @param recipesPerVolume
     */
    public void setRecipesPerVolume(int newRecipesPerVolume) {
        recipesPerVolume = newRecipesPerVolume;
    }

    public boolean hasCoverPage() {
        return cover;
    }

    public void setCoverPage(boolean set) {
        cover = set;
    }

    public boolean hasContentsPage() {
        return contents;
    }

    public void setContentsPage(boolean set) {
        contents = set;
    }

    public boolean hasEndPage() {
        return end;
    }

    public void setEndPage(boolean set) {
        end = set;
    }

    public String getCustomEndPage() {
        return customEnd;
    }

    public void setCustomEndPage(String string) {
        if (string == null || string.isEmpty()) {
            customEnd = null;
        } else {
            customEnd = string;
        }
    }

    protected void addRecipe(String name) {
        Set<String> recipes = null;

        if (!volumes.isEmpty()) {
            recipes = volumes.get(volumes.size() - 1);
        }

        if (recipes == null || recipes.size() >= recipesPerVolume) {
            recipes = new LinkedHashSet<String>();
            volumes.add(recipes);
        }

        recipes.add(name);
    }

    public int addVolume(Collection<String> recipes) {
        volumes.add(new LinkedHashSet<String>(recipes));
        return volumes.size() - 1;
    }

    public List<Set<String>> getVolumes() {
        List<Set<String>> copy  = new ArrayList<Set<String>>();
        for (Set<String> set : volumes) {
            copy.add(new LinkedHashSet<String>(set));
        }

        return copy;
    }

    public Set<String> getVolumeRecipes(int volume) {
        volume = Math.min(Math.max(volume, 1), getVolumesNum() - 1);

        return volumes.get(volume);
    }

    public int getVolumesNum() {
        return volumes.size();
    }
}
