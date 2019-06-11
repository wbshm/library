package main.com.library.bean;

public class BookDao extends CommonDao {
    private Integer id;
    private String author;

    private String book_name;

    private String cover;
    private double prize;
    @Override
    public String toString() {
        return "BookDao{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", book_name='" + book_name + '\'' +
                ", cover='" + cover + '\'' +
                ", prize=" + prize +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }
}
