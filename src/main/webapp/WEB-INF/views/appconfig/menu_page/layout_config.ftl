{
    "layout_type": "${menuPage.layoutType}",
    "cells" : [
    <#list menuPage.cells as cell>
        {
            "title" : "${cell.title}",
            "functionCode":"${cell.functionCode}",
            "iconURL":"${cell.iconURL}"
        }<#if cell_has_next>,</#if>
    </#list>
    ]
}
