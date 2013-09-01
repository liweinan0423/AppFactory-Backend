{
    "posts": [
    <#list postCategory.posts as post>
    {
        "title": "${post.title}",
        "url" : "/posts/${post.id}"
    }<#if post_has_next>,</#if>
    </#list>
    ]
}