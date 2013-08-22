package appfactory.services;

import appfactory.model.Post;
import appfactory.model.PostCategory;

/**
 * Created with IntelliJ IDEA.
 * User: wli
 * Date: 8/22/13
 * Time: 4:29 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PostService {
    public void addPost(Long category_id, Post post);
}
