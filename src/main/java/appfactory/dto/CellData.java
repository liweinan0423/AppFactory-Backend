package appfactory.dto;

/**
 * Created with IntelliJ IDEA.
 * User: liweinan
 * Date: 13-8-24
 * Time: PM12:54
 * To change this template use File | Settings | File Templates.
 */
public class CellData {

    private String id;
    private String title;
    private Integer order;
    private String iconURL;
    private String functionCode;
    private String functionId;
    private String functionIdDisplay;


    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFunctionIdDisplay() {
        return functionIdDisplay;
    }

    public void setFunctionIdDisplay(String functionIdDisplay) {
        this.functionIdDisplay = functionIdDisplay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
