function clickRefreshButtonMainTable() {
    //make api call
    getAllItemsRequest()
        .then(data =>{
            $("#myTable > tbody").empty();
            console.log('clickRefreshButtonMainTable---getAllItems',data)
            addRowsToTable('myTable',tableColumns,data)
        }).catch(err => {
        console.log(err)
    })
}


//FROM INSERT ITEM MODAL
function getItemDetialsFromAddItemForm() {
    let name = $('#nameInputAddItem').val();
    let quantity = $('#quantityInputAddItem').val();
    let inventoryCode = $('#inventoryIDInputAddItem').val();


    let id = '23';
    return {
        'name':name, 'quantity':quantity,'inventoryCode':inventoryCode
    }


}

//FROM INSERT ITEM MODAL
function getItemDetailsFromRemoveItemForm() {
    let id = $('#idInputRemoveItemForm').val();
    let name = $('#NameInputRemoveItemForm').val();

    return {
        'name':name, 'id':id
    }


}

