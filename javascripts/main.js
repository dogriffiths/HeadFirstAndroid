$(function() {
    var gridSizes = "col-xs-12 col-sm-12 col-md-6 col-lg-4";
    $(".figure").addClass("col-lg-4");
    $(".outline-2").addClass("row");
    $(".outline-3").addClass(gridSizes);
//    $(".outline-3 .figure img").css('width', '200%').css('float', 'left').css('border-width', '1px').css('border-color', 'red').css('border-style', 'solid');
    $(".outline-3 .figure img").css('max-width', '300px');
//    $(".outline-3 .figure img").addClass('img-responsive');
    $(".outline-3 a").addClass('btn').addClass('btn-success');
    $(".outline-3").addClass("panel panel-default").css('border-width', '0px').css('box-shadow', 'none');
    $(".outline-3 h3").addClass("panel-heading");
    $(".outline-text-3").addClass("panel-body");
})
