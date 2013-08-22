package appfactory.services;

import appfactory.model.Post;
import appfactory.model.PostCategory;
import appfactory.repositories.PostCategoryRepository;
import appfactory.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: wli
 * Date: 8/22/13
 * Time: 4:29 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostCategoryRepository postCategoryRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void addPost(Long category_id, Post post) {
        PostCategory postCategory = postCategoryRepository.findOne(category_id);
        post.setCategory(postCategory);
        postRepository.save(post);
    }
}
