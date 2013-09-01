package appfactory.web;

import appfactory.dto.CellData;
import appfactory.model.Cell;
import appfactory.model.MenuPage;
import appfactory.model.Post;
import appfactory.model.PostCategory;
import appfactory.repositories.CellRepository;
import appfactory.repositories.MenuPageRepository;
import appfactory.repositories.PostCategoryRepository;
import appfactory.repositories.PostRepository;
import appfactory.services.AppConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wli
 * Date: 8/23/13
 * Time: 10:47 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/appconfig")
public class AppConfigController extends AbstractBaseController {

    @Autowired
    private CellRepository cellRepository;

    @Autowired
    private MenuPageRepository menuPageRepository;

    @Autowired
    private PostCategoryRepository postCategoryRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AppConfigService appConfigService;

    @Resource(name = "cellToCellDataConverter")
    private Converter<Cell, CellData> cellToCellDataConverter;

    @Resource(name = "cellDataToCellConverter")
    private Converter<CellData, Cell> cellDataToCellConverter;

    @Autowired
    private ServletContext servletContext;

    @RequestMapping("menu_page/cells")
    public String showCells(Model model, HttpServletRequest request) {

        MenuPage menuPage = menuPageRepository.findDefaultMenuPage();

        List<CellData> cells = new ArrayList<CellData>();

        for (Cell cell : menuPage.getCells()) {
            cells.add(cellToCellDataConverter.convert(cell));
        }

        model.addAttribute(menuPage);
        model.addAttribute("cells", cells);
        return "/appconfig/menu_page/cells_list";
    }

    @RequestMapping("menu_page/cells/new")
    public String showCreateCellForm(Model model) {
        model.addAttribute("cell", new CellData());
        preparePostAndCategoryData(model);
        return "/appconfig/menu_page/add_cell";
    }

    @RequestMapping(value = "menu_page/cells", method = RequestMethod.POST)
    public String createCell(@Valid CellData cellData, BindingResult result, MultipartFile icon, HttpServletRequest request) throws IOException {
        if (result.hasErrors()) {
            return "/appconfig/menu_page/add_cell";
        }

        Cell cell = cellDataToCellConverter.convert(cellData);

        appConfigService.addCellToMenuPage(cell, icon, servletContext.getRealPath("/upload"));

        return "redirect:/appconfig/menu_page/cells";
    }

    @RequestMapping(value = "menu_page/cells/{cell_id}", method = RequestMethod.DELETE)
    public String deleteCell(@PathVariable("cell_id") Long cell_id) {
        cellRepository.delete(cell_id);
        return "redirect:/appconfig/menu_page/cells";
    }

    @RequestMapping(value = "menu_page/cells/{cell_id}/edit")
    public String showEditCellForm(@PathVariable("cell_id") Long id, Model model) {
        Cell cell = cellRepository.findOne(id);
        CellData cellData = cellToCellDataConverter.convert(cell);

        model.addAttribute("cell", cellData);
        preparePostAndCategoryData(model);
        return "/appconfig/menu_page/edit_cell";
    }

    @RequestMapping(value = "menu_page/cells/{cell_id}", method = RequestMethod.PATCH)
    public String updateCell(@Valid CellData cellData, BindingResult result) {
        if (result.hasErrors()) {
            return "/appconfig/menu_page/edit_cell";
        }

        Cell cell = cellDataToCellConverter.convert(cellData);

        cellRepository.save(cell);

        return "redirect:/appconfig/menu_page/cells";

    }

    @RequestMapping(value = "menu_page/layout", method = RequestMethod.GET)
    public String showMenuPageLayoutForm(Model model) {

        String[] layout_enums = new String[]{"GRID_9", "GRID_16", "LIST"};

        model.addAttribute("layout_enums", layout_enums);
        MenuPage defaultMenuPage = menuPageRepository.findDefaultMenuPage();
        model.addAttribute(defaultMenuPage);


        return "/appconfig/menu_page/layout_config";
    }

    @RequestMapping(value = "menu_page/layout", method = RequestMethod.PUT)
    public String saveMenuPageLayout(String layoutType) {

        MenuPage menuPage = menuPageRepository.findDefaultMenuPage();
        menuPage.setLayoutType(layoutType);

        menuPageRepository.save(menuPage);

        return "redirect:/appconfig/menu_page/layout";
    }

    private void preparePostAndCategoryData(Model model) {
        List<PostCategory> postCategories = postCategoryRepository.findAll();
        List<Post> posts = postRepository.findAll();
        model.addAttribute("postCategories", postCategories);
        model.addAttribute("posts", posts);
    }
}
