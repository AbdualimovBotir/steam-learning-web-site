package uz.example.steam_learning.payload;

public class PublicationResponse {
    private Long id;
    private String title;
    private String journal;
    private int year;
    private String url;
    private String authorName; // Foydalanuvchining ismi

    // Constructor, Getters, Setters

    public PublicationResponse() {
    }

    public PublicationResponse(Long id, String title, String journal, int year, String url, String authorName) {
        this.id = id;
        this.title = title;
        this.journal = journal;
        this.year = year;
        this.url = url;
        this.authorName = authorName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
