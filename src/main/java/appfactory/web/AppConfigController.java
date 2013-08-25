package appfactory.web;

import appfactory.dto.MenuPageConfig;
import appfactory.model.Cell;
import appfactory.model.MenuPage;
import appfactory.repositories.CellRepository;
import appfactory.repositories.MenuPageRepository;
import appfactory.services.AppConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
    private AppConfigService appConfigService;

    @RequestMapping("menu_page/cells")
    public String showCells(Model model, HttpServletRequest request) {

        MenuPage menuPage = menuPageRepository.findDefaultMenuPage();

        model.addAttribute("menuPage", menuPage);

        return "/appconfig/menu_page/cells_list";
    }

    @RequestMapping("menu_page/cells/new")
    public String showCreateCellForm(Model model) {
        model.addAttribute(new Cell());

        return "/appconfig/menu_page/add_cell";
    }

    @RequestMapping(value = "menu_page/cells", method = RequestMethod.POST)
    public String createCell(@Valid Cell cell, BindingResult result, MultipartFile icon, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "/appconfig/menu_page/add_cell";
        }


        try {
            appConfigService.addCellToMenuPage(cell, icon, request.getSession().getServletContext().getRealPath("/upload"));
        } catch (IOException e) {
            return "/appconfig/menu_page/add_cell";
        }

        return "redirect:/appconfig/menu_page/cells";
    }

    @RequestMapping(value = "menu_page/cells/{cell_id}", method = RequestMethod.DELETE)
    public String deleteCell(@PathVariable("cell_id") Long cell_id) {
        cellRepository.delete(cell_id);
        return "redirect:/appconfig/menu_page/cells";
    }

    @RequestMapping(value = "menu_page/layout", method = RequestMethod.GET)
    public String showMenuPageLayoutForm(Model model) {

        String[] layout_enums = new String[]{"GRID_9", "GRID_16", "LIST"};

        model.addAttribute("layout_enums", layout_enums);
        MenuPage defaultMenuPage = menuPageRepository.findDefaultMenuPage();
        model.addAttribute(defaultMenuPage);

        //for json view
        model.addAttribute("layout_type", defaultMenuPage.getLayoutType());
        model.addAttribute("cells", defaultMenuPage.getCells());

        return "/appconfig/menu_page/layout_config";
    }

    @RequestMapping(value = "menu_page/layout", method = RequestMethod.PUT)
    public String saveMenuPageLayout(String layoutType) {

        MenuPage menuPage = menuPageRepository.findDefaultMenuPage();
        menuPage.setLayoutType(layoutType);

        menuPageRepository.save(menuPage);

        return "redirect:/appconfig/menu_page/layout";
    }
}
