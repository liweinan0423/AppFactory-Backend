$(function () {

    toggle_select($("#function_select").val());

    $("#function_select").change(function () {
        toggle_select($(this).val());
    })


    function toggle_select(function_code) {
        switch (function_code) {
            case 'POST_CATEGORY':
                $('#category_select').show();
                $('#category_select').removeAttr("disabled");
                $('#post_select').hide();
                $('#post_select').attr("disabled", "disabled");
                break;
            case 'POST':
                $('#category_select').hide();
                $('#category_select').attr("disabled","disabled");
                $('#post_select').show();
                $('#post_select').removeAttr("disabled");
                break;
            default:
                $("#category_select").hide();
                $("#category_select").attr("disabled", "disabled");
                $("#post_select").hide();
                $("#post_select").attr("disabled", "disabled");
        }
    }
})
