$(function() {
    var gridSizes = "col-xs-12 col-sm-12 col-md-6 col-lg-4";
    $(".figure").addClass("col-lg-4");
    $(".outline-2").addClass("row");
    $(".outline-3").addClass(gridSizes);
    $(".outline-text-2 .figure img").addClass('side_image');
    $(".outline-3 .figure img").css('max-width', '300px');
    $(".outline-3 a").addClass('btn').addClass('btn-success');
    $(".outline-3").addClass("panel panel-default").css('border-width', '0px').css('box-shadow', 'none');
    $(".outline-3 h3").addClass("panel-heading");
    $(".outline-text-3").addClass("panel-body");
})
