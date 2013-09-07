$(function() {
    $("#checkboxRoot").change(function() {

        if ($(this).is(":checked")) {
            $("#parent_category").attr("disabled", "disabled");
            $("#parent_category").hide();
        } else {
            $("#parent_category").removeAttr("disabled");
            $("#parent_category").show();
        }
    })

    if($("#parent_category > option").size() == 0) {

        $("#checkboxRoot").attr("checked", "checked");
        $("#checkboxRoot").attr("disabled", "disabled");

        $("#parent_category").attr("disabled", "disabled");
        $("#parent_category").hide();
    }
})