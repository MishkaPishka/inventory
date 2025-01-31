function f() {
    return new Promise ( (resolve, reject) => {
        $.get('/api/itemddds/'+4)
            .done(data=>{
                console.log("follow sector request -",data);
                return resolve(data);
            }).fail(err => {
            console.log("follow sector request error-",err);
            return reject(err);

        })
    })
}

function getAllItemsRequest() {
    return new Promise ( (resolve, reject) => {
        $.get('/api/get-inventory-list/')
            .done(data=>{
                console.log("api/inventory-items request -",data);
                return resolve(data);
            }).fail(err => {
            console.log("api/inventory-items request  error-",err);
            return reject(err);

        })
    })
}


function updateItemRequest(itemId,map) {
    return new Promise ( (resolve, reject) => {
        $.post('/api/bulk-update',
            {
                allRequestParams:JSON.stringify(map),
                itemId:itemId
            }
               )
            .done(data=>{
                console.log("/api/bulkupdate -",data);
                return resolve(data);
            }).fail(err => {
            console.log("/api/bulkupdate-",err);
            return reject(err.responseJSON);

        })
    })
}

function addItem(newItem) {
    return new Promise ( (resolve, reject) => {
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: window.location + "api/add",
            data: JSON.stringify(newItem),
            dataType: 'json',
        })
        // $.get('/api/get-inventory-list/')
            .done(data=>{
                console.log("/api/add -",data);
                return resolve(data);
                // return data
            }).fail(err => {
                console.log("/api/add-",err.responseJSON);
                return reject(err.responseJSON);

        })
    })
}

function removeItemApiRequest(item) {
    return new Promise ( (resolve, reject) => {



        $.ajax({
            type: "DELETE",
            contentType: "application/json",
            url: window.location + "api/delete/"+item['id']+"/",
            // url: window.location + "api/delete/",

            // dataType: 'json',
        }).done(function( msg ) {
           return resolve(msg);
        })
        .fail(function (val) {
                return reject(val.responseJSON);

        })


    })




}

function getImageApiRequest(itemId) {
    return new Promise ( (resolve, reject) => {



        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: window.location + "/image",

            // dataType: 'json',
        }).done(function( msg ) {
            return resolve(msg);
        })
            .fail(function (val) {
                return reject(val);

            })


    })
}

// function removeItemApiRequest(item) {
//     // return new Promise ( (resolve, reject) => {
//
//
//
//         var url = "http://localhost:8080/api/delete/";
//         var xhr = new XMLHttpRequest();
//         xhr.open("DELETE", url, true);
//         xhr.onload = function () {
//              console.log(xhr.response);
//             // var users = JSON.parse(xhr.responseText);
//             // if (xhr.readyState == 4 && xhr.status == "200") {
//             //     console.table(users);
//             // } else {
//             //     console.error(users);
//             // }
//         }
//         // resolve(xhr.send([{'name':'bla'}]));
//     xhr.send('name=bla')
//         // resolve();
//
//     // })






