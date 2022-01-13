console.log("ola");
$(document).ready(function() {
    $("#all-carbonated-drinks").on('click', function () {
        console.log("carbonated drinks");
        $.get("/wingman/api/carbonateddrinks", function(data) {
            showList(data);
        });
    });

    $("#all-mocktails").on('click', function () {
        console.log("carbonated drinks");
        $.get("/wingman/api/mocktails", function(data) {
            showList(data);
        });
    });

    $("#all-coffee").on('click', function () {
        console.log("carbonated drinks");
        $.get("/wingman/api/coffee", function(data) {
            showList(data);
        });

    });

    $("#all-tea").on('click', function () {
        console.log("carbonated drinks");
        $.get("/wingman/api/tea", function(data) {
            showList(data);
        });
    });

});

function showList(content) {
    var ret = '<ul class="list-group">';

    for (var i = 0; i < content.length; i++) {
        ret += '<li class="list-group-item">' + content[i] + '</li>';
    }
    ret += '</ul>';
    $("#results-area").html(ret);

}

function clearResultsArea() {
    $("#results-area").html("");
}