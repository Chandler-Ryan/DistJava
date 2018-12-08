//-- Get all genres using AJAX
refreshGenreList('#stuff','/genre');
//--------------- get one Ajax ----------------------------------------------
$('#getByIdSubmit').click(function(){
    refreshGenreList('#DisplayGenre',"/genre/"+$('#search').val());
    $('#search').val('');//clears input after submit
});

//------------------------------ Add Genre AJAX ------------------------------------------
$( "#addGenre" ).click(function() {
    var finishedMessage="{";
    var message = $( '#theGenre' ).serializeArray();
    $.each(message,function (i,field) {
        finishedMessage+="\"" + field.name + "\":\"" + field.value + "\",";
    });
    finishedMessage = finishedMessage.substring(0,finishedMessage.length - 1) + "}";
    var oReq = new XMLHttpRequest();
    oReq.open("POST", "/genre");
    oReq.setRequestHeader("Content-Type", "application/json");
    oReq.send(finishedMessage);
    setTimeout(refresh,2000);
});
//---------onclick update Navbar link ---------------
$('#updateNav').click(function(){
    buildGenreSelectEle('#updateSelect','Update');
    $('#updateGenreName').val('');
    $('#updateRating').val('');
});
//-------------------Update AJAX ---------------------------------------------------------
$( "#updateGenreButton" ).on("click" ,function( event ) {
    var finishedMessage="{";
    var message = $( "#updateGenre" ).serializeArray();
    $.each(message,function (i,field) {
        finishedMessage+="\"" + field.name + "\":\"" + field.value + "\",";
    });
    finishedMessage =finishedMessage.substring(0,finishedMessage.length - 1) + "}";
    var oReq = new XMLHttpRequest();
    oReq.open("PUT", "/genre/"+ $( "#selected4Update" ).val());
    oReq.setRequestHeader("Content-Type", "application/json");
    oReq.send(finishedMessage);    
    setTimeout(refresh,1000);    
});
//---------------------Delete AJAX -----------------------------------------------------
$( "#deleteTeam" ).on("click" ,function( event ) {
    var name = $( "#selected4Delete" ).val();
    var oReq = new XMLHttpRequest();
    oReq.open("DELETE", "/genre/"+ name);
    oReq.setRequestHeader("Content-Type", "application/json");
    oReq.send();
});
//---------onclick Delete Navbar link ---------------
$('#deleteNav').click(function(){
    $('#deleteResult').html('');
    $('#dTeam').show();
    buildGenreSelectEle('#deleteSelect','Delete');
});
//---------------Delete genre button click -----------------------
$('#deleteTeam').click(function(){
    $('#dTeam').hide();
    $('#deleteResult').html('Your Genre has been deleted.');
    setTimeout(refresh,3000);
});

//-------------- Clear previous Get 1 results on get1Nav click -------------
$('#get1Nav').click(function(){$('#DisplayGenre').html('');});

//-------------- List All NavBar click to refresh list ---------------------
$('#listAllNav').click(function(){refreshGenreList('#stuff','/genre')});

//-- Get all genres using AJAX - Function definition -----------------------
function refreshGenreList(resultLocationSelector, URI){
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var myObj = JSON.parse(this.responseText);
            var content = "<table class=\"table table-striped\">";
            if (Array.isArray(myObj)){
                for (var property in myObj) {
                    if (myObj.hasOwnProperty(property)) {
                        content += "<tr><td>" + myObj[property].genreName + "</td><td>" + myObj[property].rating +
                            "</td></tr>";
                    }
                }
            }else{
                content += "<tr><td>" + myObj.genreName + "</td><td>" + myObj.rating + "</td></tr>";
            }
            content += "</table>";
            $(resultLocationSelector).html(content);
        }
    };
    xmlhttp.open("GET", URI, true);
    xmlhttp.send();
}

// Builds a select box to select the Genre to update/delete
function buildGenreSelectEle(resultLocationSelector,UorD){
    var ajaz = new XMLHttpRequest();
    ajaz.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var myObj = JSON.parse(this.responseText);
            var content = "<select class=\"form-control\" id=\"selected4" + UorD + "\">";
            for (var property in myObj) {
                if (myObj.hasOwnProperty(property)) {
                    content += "<option value=\"" + myObj[property].genreName + "\">" + myObj[property].genreName +"</option>";
                }
            }
            content += "</select>";
            $(resultLocationSelector).html(content);
        }
    };
    ajaz.open("GET", "/genre", true);
    ajaz.send();
}

// A function to show the updated list of genres after Add, Update, Delete
function refresh(){
    $('#listAllNav').trigger('click');
}