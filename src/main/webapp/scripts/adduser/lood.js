$(document).ready(function () {
    loadDataToTable();
    $('#mySelect').click(function () {
        myFunction();
    })
    $('button[name="saveadd"]').on('click', function () {
        addRepository();
        loadDataToTable();
    })

});

//Add///////////////////////////////////////////////////
function addRepository() {
    var jsonData = {
        firstName: $('#addfirst1').val(),
        lastName: $('#addlast1').val(),
        deseription: $('#adddescription1').val()
    }
    $.ajax({
        url: session.context + "/appUsers/Repository",
        contentType: "application/json;charset=UTF-8",
        headers: {Accept: "application/json;charset=UTF-8"},
        type: "POST",
        data: JSON.stringify(jsonData),
        async: false
    })
    $('#addfirst1').val("");
    $('#addlast1').val("");
    $('#adddescription1').val("");
}

function loadDataToTable() {
    let json = $.ajax({
        url: session.context + "/appUsers/searchfirstName",
        contentType: "application/json;charset=UTF-8",
        headers: {Accept: "application/json;charset=UTF-8"},
        type: "GET",
        //data: {firstName: $('#inputsearch').val()},
        data: {firstName: $('#inputsearch').val()},
        async: false
    }).done(function () {
    }).responseText;
    console.log(json);
    //json = JSON.parse(json);
    json = JSON.parse(json);
    console.log(json);
    $('#tbody').empty();
    if (json.length > 0) {
        for (let x of json) {
            $('#tbody').append('' +
                '<tr>' +
                '<td class="text-center">' + x.id + '</td>' +
                '<td> ' + x.firstName + '</td>' +
                '<td> ' + x.lastName + '</td>' +
                '<td class="text-center">' + x.deseription + '</td>' +
                '<td class="text-center"><button type="button" class="btn btn-outline-success" name="editButton" data-toggle="modal" data-target="#exampleModal" value="' + x.id + " " + x.firstName + " " + x.lastName + " " + x.deseription + " " + '">Edit</button>' + " " +
                '<button type="button" class="btn btn-outline-dark" name="deleteButton" data-toggle="modal" data-target="#exampleModal2" value="' + x.id + '" >Delete</button>' +
                '</td>' +
                '</tr>');
        }
        $('button[name="deleteButton"]').click(function () {
            $('button[name="delc"]').val($(this).val()).on('click', function () {
                deleDataToTable($(this).val());
                loadDataToTable();
            })
        })
        $('button[name="editButton"]').on('click', function () {
            let value = ($(this).val());
            value = value.split(" ");
            $('#addfirst').val(value[1]);
            $('#addlast').val(value[2]);
            $('#adddescription').val(value[3]);
            $('button[name="saveedit"]').val(value[0]).on('click', function () {
                editDataToTable($(this).val());
                loadDataToTable();
            })
        })
    } else {
        $('#tbody').append('<tr><td style="text-align: center;" colspan="5">No data.</td></tr>');
    }
}

function lastDataToTable() {

    let json = $.ajax({
        url: session.context + "/appUsers/searchlastName",
        headers: {Accept: "application/json;charset=UTF-8"},
        type: "GET",
        data: {lastName: $('#inputsearch').val()},
        async: false
    }).done(function () {
        console.log('done')
    }).responseText;
    json = JSON.parse(json);
    console.log(json);
    $('#tbody').empty();
    if (json.length > 0) {
        for (let x of json) {
            //console.log(x);
            $('#tbody').append('' +
                '<tr>' +
                '<td class="text-center">' + x.id + '</td>' +
                '<td> ' + x.firstName + '</td>' +
                '<td> ' + x.lastName + '</td>' +
                '<td class="text-center">' + x.deseription + '</td>' +
                '<td class="text-center"><button type="button" class="btn btn-outline-success" name="editButton" data-toggle="modal" data-target="#exampleModal" value="' + x.id + " " + x.firstName + " " + x.lastName + " " + x.deseription + " " + '">Edit</button>' + " " +
                '<button type="button" class="btn btn-outline-dark" name="deleteButton" data-toggle="modal" data-target="#exampleModal2" value="' + x.id + '" >Delete</button>' +
                '</td>' +
                '</tr>');
        }
        $('button[name="deleteButton"]').click(function () {
            $('button[name="delc"]').val($(this).val()).on('click', function () {
                deleDataToTable($(this).val());
                loadDataToTable();
            })
        })
        $('button[name="editButton"]').on('click', function () {
            let value = ($(this).val());
            value = value.split(" ");
            $('#addfirst').val(value[1]);
            $('#addlast').val(value[2]);
            $('#adddescription').val(value[3]);
            $('button[name="saveedit"]').val(value[0]).on('click', function () {
                editDataToTable($(this).val());
                loadDataToTable();
            })
        })
    } else {
        $('#tbody').append('<tr><td style="text-align: center;" colspan="5">No data.</td></tr>');
    }
}

function deseriptionToTable() {

    let json = $.ajax({
        url: session.context + "/appUsers/deseription",
        headers: {Accept: "application/json"},
        type: "GET",
        data: {deseription: $('#inputsearch').val()},
        async: false
    }).done(function () {
        console.log('done')
    }).responseText;
    json = JSON.parse(json);
    console.log(json);
    $('#tbody').empty();
    if (json.length > 0) {
        for (let x of json) {
            //console.log(x);
            $('#tbody').append('' +
                '<tr>' +
                '<td class="text-center">' + x.id + '</td>' +
                '<td> ' + x.firstName + '</td>' +
                '<td> ' + x.lastName + '</td>' +
                '<td class="text-center">' + x.deseription + '</td>' +
                '<td class="text-center"><button type="button" class="btn btn-outline-success" name="editButton" data-toggle="modal" data-target="#exampleModal" value="' + x.id + " " + x.firstName + " " + x.lastName + " " + x.deseription + " " + '">Edit</button>' + " " +
                '<button type="button" class="btn btn-outline-dark" name="deleteButton" data-toggle="modal" data-target="#exampleModal2" value="' + x.id + '" >Delete</button>' +
                '</td>' +
                '</tr>');
        }
        $('button[name="deleteButton"]').click(function () {
            $('button[name="delc"]').val($(this).val()).on('click', function () {
                deleDataToTable($(this).val());
                loadDataToTable();
            })
        })
        $('button[name="editButton"]').on('click', function () {
            let value = ($(this).val());
            value = value.split(" ");
            $('#addfirst').val(value[1]);
            $('#addlast').val(value[2]);
            $('#adddescription').val(value[3]);
            $('button[name="saveedit"]').val(value[0]).on('click', function () {
                editDataToTable($(this).val());
                loadDataToTable();
            })
        })
    } else {
        $('#tbody').append('<tr><td style="text-align: center;" colspan="5">No data.</td></tr>');
    }
}

function FirstNameAndlastDataToTable() {
    let value = $('#inputsearch').val();
    value = value.split(" ");
    console.log(value[0]);
    console.log(value[1]);
    let json = $.ajax({
        url: session.context + "/appUsers/searchFandL",
        headers: {Accept: "application/json;charset=UTF-8"},
        type: "GET",
        data: {
            firstName: value[0],
            lastName: value[1]
        },
        async: false
    }).done(function () {
        console.log(value[0])
    }).responseText;
    json = JSON.parse(json);
    console.log(json);
    $('#tbody').empty();
    if (json.length > 0) {
        for (let x of json) {
            console.log(x);
            $('#tbody').append('' +
                '<tr>' +
                '<td>' + x.id + '</td>' +
                '<td>' + x.firstName + '</td>' +
                '<td>' + x.lastName + '</td>' +
                '<td>' + x.deseription + '</td>' +
                '<td><button type="button" class="btnedit"  >Edit</button> ' +
                '<button type="button" class="btndelete" name="deleteButton" value="' + x.id + '">Delete</button>' +
                '</td>' +
                '</tr>');
        }
    } else {
        $('#tbody').append('<tr><td style="text-align: center;" colspan="5">No data.</td></tr>');
    }
}

function deleDataToTable(value) {
    $.ajax({
        url: session.context + "/appUsers/del/" + value,
        contentType: "application/json",
        headers: {Accept: "application/json"},
        type: "DELETE",
        async: false
    })
}

function editDataToTable(value) {
    var jsonData = {
        firstName: $('#addfirst').val(),
        lastName: $('#addlast').val(),
        deseription: $('#adddescription').val()
    }
    $.ajax({
        url: session.context + "/appUsers/Putbyclass/" + value,
        contentType: "application/json",
        headers: {Accept: "application/json"},
        type: "PUT",
        data: JSON.stringify(jsonData),
        async: false
    })
}

function myFunction() {
    var x = document.getElementById("mySelect").value;
    if (x == "First") {
        loadDataToTable();
    } else if (x == "Last") {
        lastDataToTable();
    } else if (x == "Description") {
        deseriptionToTable();
    }
}
