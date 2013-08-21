package appfactory.web;

import appfactory.model.Post;
import appfactory.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: wli
 * Date: 8/21/13
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/posts")
public class PostsController {


    @Autowired
    private PostRepository postRepository;


    @RequestMapping(method = RequestMethod.GET)
    public String postList(Model model, Pageable pageable) {
        Page<Post> page = postRepository.findAll(pageable);
        model.addAttribute("page", page);
        return "/posts/list";
    }

}
