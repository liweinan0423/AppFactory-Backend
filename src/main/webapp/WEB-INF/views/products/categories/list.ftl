{
    "categories": [
        <#list productCategories as category>
        {
            "id":"${category.id}",
            "name": "${category.name}",
            "iconURL":"${category.iconURL}",
            "desc": "${category.desc}"
        }<#if category_has_next>,</#if>
        </#list>
    ]
}