function addRowsToTable(tableId,colNames,values){
    let begin = '<tr>'
    let end = '</tr>'
    console.log(tableId,colNames,values)
    values.forEach(value => {
            var str = '';
            colNames.forEach(colName => {

                console.log(colName,'xxx',value[colName]);
                let fillValue = value[colName]
                if (colName ==='id') {
                    fillValue = "<a href='item/"+fillValue+"'>"+ fillValue+"</a>"
                }
                str += '<td>' + fillValue + '</td>'
            });
        console.log('str',str);

        // document.getElementById("myTable").insertRow(-1).innerHTML =begin+str+end;
        // $('#myTable > tbody:first').append(begin+str+end);
        $('#'+tableId +'>tbody:last-child').append(begin+str+end);

        }


    )

}

function displayItemOnItemPage(item){
    // document.getElementById('aa').innerText = 'ffff'

    $("#aa").html('vvvv')
}


function displayErrorMessage(id,err) {
    // setTimeout(function () {
    //     document.getElementById(id).innerHTML = err;
    // }, 3000);
    // document.getElementById(id).innerHTML = "";
    $('#'+id).text( "Error:"+err);
    $('#'+id).show().delay(3000).fadeOut();

}
function clearDataFromAddItemForm() {
    $('#addItemFormID').trigger("reset");
    $('#addItemFormID').prop('checked', false);


    // let name = $('#nameInputAddItem').val(null)
    // $('#nameInputAddItem').
    // let quantity = $('#quantityInputAddItem').val("");
    // let inventoryCode = $('#inventoryIDInputAddItem').val("");
}
