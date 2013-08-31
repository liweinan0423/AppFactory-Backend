package appfactory.web;

import appfactory.model.Post;
import appfactory.model.PostCategory;
import appfactory.repositories.PostCategoryRepository;
import appfactory.repositories.PostRepository;
import appfactory.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wli
 * Date: 8/22/13
 * Time: 10:47 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("post_categories")
public class PostsController extends AbstractBaseController {

    @Autowired
    private PostCategoryRepository postCategoryRepository;

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @RequestMapping
    public String listPostCategories(Model model) {
        List<PostCategory> postCategories = postCategoryRepository.findAll();
        model.addAttribute("postCategories", postCategories);
        return "/post_categories/list";
    }

    @RequestMapping("new")
    public String showCreateCateogoryForm(Model model) {
        model.addAttribute(new PostCategory());
        return "/post_categories/new";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createCategory(@Valid PostCategory category, BindingResult result) {
        if (result.hasErrors()) {
            return "/post_categories/new";
        } else {
            postCategoryRepository.save(category);
            return "redirect:/post_categories";
        }
    }

    @RequestMapping("{id}/edit")
    public String showEditCategoryForm(@PathVariable("id") PostCategory postCategory, Model model) {
        model.addAttribute(postCategory);
        return "/post_categories/edit";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String deletePostCategory(@PathVariable("id") Long id) {
        postCategoryRepository.delete(id);
        return "redirect:/post_categories";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public String editCateogry(@PathVariable("id") Long id, @Valid PostCategory postCategory, BindingResult result) {
        if (result.hasErrors()) {
            return "/post_categories/edit";
        }

        PostCategory old = postCategoryRepository.findOne(id);
        old.setName(postCategory.getName());

        postCategoryRepository.save(old);

        return "redirect:/post_categories";

    }

    @RequestMapping("{category_id}")
    public String viewPostCategory(@PathVariable("category_id") PostCategory postCategory, Model model) {

        model.addAttribute("postCategory", postCategory);
        return "/post_categories/show";
    }


    @RequestMapping(value = "{category_id}/posts/new", method = RequestMethod.GET)
    public String showCreatePostForm(@PathVariable("category_id") Long category_id, Model model) {

        model.addAttribute(new Post());
        return "/posts/new";
    }

    @RequestMapping(value = "{category_id}/posts", method = RequestMethod.POST)
    public String createPost(@PathVariable("category_id") Long category_id, @Valid Post post, BindingResult result) {
        if (result.hasErrors()) {
            return "/posts/new";
        }
        postService.addPost(category_id, post);
        return "redirect:/post_categories";
    }

    @RequestMapping("{category_id}/posts/{post_id}/edit")
    public String showEditPostForm(@PathVariable("category_id") Long category_id, @PathVariable("post_id") Post post, Model model) {
        model.addAttribute("post_id", post.getId());
        model.addAttribute("post", post);
        return "/posts/edit";
    }

    @RequestMapping(value = "{category_id}/posts/{post_id}", method = RequestMethod.PATCH)
    public String updatePost(@Valid Post post, BindingResult result, Model model, @PathVariable("category_id") Long category_id, @PathVariable("post_id") Long post_id) {
        if (result.hasErrors()) {
            return "/posts/edit";
        }

        Post oldPost = postRepository.findOne(post_id);
        oldPost.setTitle(post.getTitle());
        oldPost.setContent(post.getContent());

        postRepository.save(oldPost);

        return "redirect:/post_categories/" + category_id;
    }

    @RequestMapping(value = "{category_id}/posts/{post_id}", method = RequestMethod.DELETE)
    public String deletePost(@PathVariable("category_id") Long category_id, @PathVariable("post_id") Long post_id) {
        postRepository.delete(post_id);
        return "redirect:/post_categories/" + category_id;
    }
}
