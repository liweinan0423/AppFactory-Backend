package appfactory.dto;

/**
 * Created with IntelliJ IDEA.
 * User: liweinan
 * Date: 13-8-24
 * Time: PM12:54
 * To change this template use File | Settings | File Templates.
 */
public class CellData {

    private String title;
    private String iconUrl;
    private String functionCode;
    private String functionId;


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

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
