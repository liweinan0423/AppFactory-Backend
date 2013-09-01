{
    "contact_info_list": [
        <#list contact_info_list as contact_info>
        {
            "phoneName":"${contact_info.phoneName}",
            "phoneNumber":"${contact_info.phoneNumber}"
        }<#if contact_info_has_next>,</#if>
        </#list>
    ]
}