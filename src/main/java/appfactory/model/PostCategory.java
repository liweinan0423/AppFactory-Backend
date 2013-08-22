package appfactory.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liweinan
 * Date: 13-8-21
 * Time: PM8:29
 * To change this template use File | Settings | File Templates.
 */
@Entity
@SessionAttributes(types = PostCategory.class)
public class PostCategory extends BaseEntity {

    @NotEmpty
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
    private List<Post> posts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void addPost(Post post) {
        if (this.posts == null) {
            posts = new ArrayList<Post>();
        }

        posts.add(post);
        post.setCategory(this);
    }

}
