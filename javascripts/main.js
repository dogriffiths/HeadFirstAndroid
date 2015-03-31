$(function() {
    var gridSizes = "col-xs-12 col-sm-12 col-md-6 col-lg-4";
    $(".outline-3 .figure").addClass("col-lg-4");
    $(".outline-2").addClass("row");
    $(".outline-3").addClass(gridSizes);
    $(".outline-text-2 .figure img").addClass('side_image');
    $(".outline-3 .figure img").css('max-width', '300px');
    $(".outline-3").addClass("panel panel-default").css('border-width', '0px').css('box-shadow', 'none');
    $(".outline-3 h3").addClass("panel-heading");
    $(".outline-text-3").addClass("panel-body");

    $('a').each(function() {

        var yturl= /(?:https?:\/\/)?(?:www\.)?(?:youtube\.com|youtu\.be)\/(?:watch\?v=)?([\w\-]{10,12})(?:&feature=related)?(?:[\w\-]{0})?/g;
        var ytplayer= '<div class="embed-responsive embed-responsive-16by9"><iframe width="640" height="360" src="http://www.youtube.com/embed/$1" frameborder="0" allowfullscreen></iframe></div>';

        var url = $(this).attr('href');
        if (url != null)
        {
            var matches = url.match(yturl);
            if (matches)
            {
                var embed = $(this).attr('href').replace(yturl, ytplayer);
                var iframe = $(embed);

                iframe.insertAfter(this);
                $(this).remove();
            }
        }
    });

            $('#divRss').FeedEk({
                FeedUrl: 'https://medium.com/feed/@tcarmody',
                MaxCount: 3
            });

})
