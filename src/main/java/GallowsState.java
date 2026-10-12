public enum GallowsState {

    NO_ERRORS("""
          +-----+
          |     |
                |
                |
                |
                |
        ========="""),
    FIRST_ERROR("""
          +-----+
          |     |
          O     |
                |
                |
                |
        ========="""),
    SECOND_ERROR("""
          +-----+
          |     |
          O     |
          |     |
                |
                |
        ========="""),
    THIRD_ERROR("""
          +-----+
          |     |
          O     |
         /|     |
                |
                |
        ========="""),
    FOURTH_ERROR("""
          +-----+
          |     |
          O     |
         /|\\    |
                |
                |
        ========="""),
    FIFTH_ERROR("""
          +-----+
          |     |
          O     |
         /|\\    |
         /      |
                |
        ========="""),
    SIXTH_ERROR("""
          +-----+
          |     |
          O     |
         /|\\    |
         / \\    |
                |
        =========""");

    private final String picture;

    GallowsState(String picture) {
        this.picture = picture;
    }

    public String getPicture() {
        return picture;
    }
}
