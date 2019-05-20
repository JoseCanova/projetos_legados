/*
* FeedEk jQuery RSS/ATOM Feed Plugin v3.0 with YQL API
* http://jquery-plugins.net/FeedEk/FeedEk.html  https://github.com/enginkizil/FeedEk
* Author : Engin KIZIL http://www.enginkizil.com   
* 
* Modified, excluded YQL API dependency... 
* Altered URL for news. 
* var YQLstr = 'SELECT channel.item FROM feednormalizer WHERE output="rss_2.0" AND url ="' + def.FeedUrl + '" LIMIT ' + def.MaxCount;
* https://query.yahooapis.com/v1/public/yql?q=" + encodeURIComponent(YQLstr) + "&format=json&diagnostics=false&callback=?
* TODO: next version update for an arbitrary(configurable), URL. 
*/

(function ($) {
    $.fn.FeedEk = function (opt) {
        var def = $.extend({
            MaxCount: 5,
            ShowDesc: true,
            ShowPubDate: true,
            DescCharacterLimit: 0,
            TitleLinkTarget: "_blank",
            DateFormat: "",
            DateFormatLang:"en",
            RssHost: "https://hubotek.appspot.com/s_content/googleNews"
        }, opt);
        
        var id = $(this).attr("id"), i, s = "", dt;
        $("#" + id).empty();
        if (def.FeedUrl == undefined) return;       
        $("#" + id).append('<img src="images/loader1.gif" />');

        $.ajax({
            url: def.RssHost,
            dataType: "json",
            success: function (data) {
                $("#" + id).empty();
                var inc = 0;
                if (data.rssItems instanceof Array && data.rssItems.length > def.MaxCount){
                	data.rssItems = data.rssItems.slice(def.MaxCount-1);
                }
                $.each(data.rssItems, function (e, itm) {
                	inc++;
                    s += '<li><div class="itemTitle"><a href="' + itm.link + '" target="' + def.TitleLinkTarget + '" >' + itm.title + '</a></div>';
                    
                    if (def.ShowPubDate){
                        dt = new Date(itm.pubDate);
                        s += '<div class="itemDate">';
                        if ($.trim(def.DateFormat).length > 0) {
                            try {
                                moment.lang(def.DateFormatLang);
                                s += moment(dt).format(def.DateFormat);
                            }
                            catch (e){s += dt.toLocaleDateString();}                            
                        }
                        else {
                            s += dt.toLocaleDateString();
                        }
                        s += '</div>';
                    }
                    if (def.ShowDesc) {
                        s += '<div class="itemContent">';
                         if (def.DescCharacterLimit > 0 && itm.length > def.DescCharacterLimit) {
                            s += itm.description.substring(0, def.DescCharacterLimit) + '...';
                        }
                        else {
                            s += itm.description;
                         }
                         s += '</div>';
                    }
                });
                $("#" + id).append('<ul class="feedEkList">' + s + '</ul>');
            }
        });
    };
})(jQuery);