appfactory = {}

appfactory.product = {

    insertUploadComponent: function () {
        $("#images").children().first().clone().appendTo("#images");
        return false;
    },

    removeUploadComponent: function (_this) {
        if ($("#images").children().size() > 1) {
            $(_this).parents(".row").first().remove();
        }
    }

}

$(function () {
    $("#add_image").click(appfactory.product.insertUploadComponent);
})
