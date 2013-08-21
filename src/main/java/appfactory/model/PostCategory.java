package appfactory.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liweinan
 * Date: 13-8-21
 * Time: PM8:29
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class PostCategory {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private PostCategory parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private List<PostCategory> subCategories;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Post> posts;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PostCategory getParent() {
        return parent;
    }

    public void setParent(PostCategory parent) {
        this.parent = parent;
    }

    public List<PostCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<PostCategory> subCategories) {
        this.subCategories = subCategories;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
